package com.zpaas.mongo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.mongodb.util.JSON;
import com.zpaas.utils.CipherUtil;

/**
 * MongoDB访问封装类
 * @author ZhangJunyong
 *
 */
public class MongoDBClient {
	private static final Logger log = LoggerFactory.getLogger(MongoDBClient.class);
	
	private static final String IP_KEY = "ip";
	private static final String PORT_KEY = "port";
	private static final String FILE_NAME = "filename";
	
	
	private MongoClient mongo = null;
	
	public MongoDBClient(String addr) {
		try {
			JSONArray array = JSONArray.fromObject(addr);
			if(array != null && array.size() > 0) {
				int size = array.size();
				JSONObject json = null;
				ArrayList<ServerAddress> sa = new ArrayList<ServerAddress>();
				for(int i=0; i<size; i++) {
					json = (JSONObject)array.get(i);
					sa.add(new ServerAddress(json.getString(IP_KEY), json.getInt(PORT_KEY)));
				}
				mongo = new MongoClient(sa);
				
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public MongoDBClient(String addr, String database, String userName, String password) {
		try {
			JSONArray array = JSONArray.fromObject(addr);
			if(array != null && array.size() > 0) {
				int size = array.size();
				JSONObject json = null;
				ArrayList<ServerAddress> sa = new ArrayList<ServerAddress>();
				for(int i=0; i<size; i++) {
					json = (JSONObject)array.get(i);
					sa.add(new ServerAddress(json.getString(IP_KEY), json.getInt(PORT_KEY)));
				}
				if(userName != null && userName.length() > 0 && password != null && password.length() > 0) {
					String orignPwd = CipherUtil.decrypt(password);
					MongoCredential credential = MongoCredential.createMongoCRCredential(userName, database, orignPwd.toCharArray());
					mongo = new MongoClient(sa, Arrays.asList(credential));
				}else {
					mongo = new MongoClient(sa);
				}
				
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public void insert(String dbName, String collectionName, String doc) {
		DBObject dbObj = (DBObject)JSON.parse(doc);
		mongo.getDB(dbName).getCollection(collectionName).insert(dbObj);
	}
	
	public void insert(String dbName, String collectionName, JSONObject doc) {
		DBObject dbObj = (DBObject)JSON.parse(doc.toString() );
		mongo.getDB(dbName).getCollection(collectionName).insert(dbObj);
	}
	
	@SuppressWarnings("rawtypes")
	public void insert(String dbName, String collectionName, Map docMap) {
		DBObject dbObj = new BasicDBObject(docMap);
		mongo.getDB(dbName).getCollection(collectionName).insert(dbObj);
	}
	
	
	
	
	public String saveFile(String dbName, byte[] byteFile, String fileName, String fileType) {
		GridFS fs = new GridFS(mongo.getDB(dbName));
		GridFSInputFile dbFile = null;
		try {
			dbFile = fs.createFile(byteFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbFile.setContentType(fileType);
		dbFile.setFilename(fileName);
		dbFile.put("fileName", fileName);
		dbFile.save();
		return dbFile.getId().toString();
	}
	
	public String saveFile(String dbName, String fileName, String fileType) {
		if(fileName == null) {
			return null;
		}
		String name = fileName.substring(fileName.lastIndexOf("/")+1);
		GridFS fs = new GridFS(mongo.getDB(dbName));
		File file = new File(fileName);
		GridFSInputFile dbFile = null;
		try {
			dbFile = fs.createFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dbFile.setContentType(fileType);
		dbFile.setFilename(name);
		dbFile.save();
		return dbFile.getId().toString();
	}
	
	public void deleteFile(String dbName, String fileId) {
		if(fileId == null) {
			return ;
		}
		GridFS fs = new GridFS(mongo.getDB(dbName));
		GridFSDBFile dbFile = fs.findOne(new ObjectId(fileId));
		if(dbFile == null) {
			return ;
		}
		fs.remove(dbFile);
	}
	
	public void deleteFileByName(String dbName, String fileName) {
		if(fileName == null) {
			return ;
		}
		GridFS fs = new GridFS(mongo.getDB(dbName));
		GridFSDBFile dbFile = fs.findOne(new BasicDBObject(FILE_NAME, fileName));
		if(dbFile == null) {
			return ;
		}
		fs.remove(dbFile);
	}
	
	
	
	public byte[] readFile(String dbName, String fileId) {
		if(fileId == null) {
			return null;
		}
		GridFS fs = new GridFS(mongo.getDB(dbName));
		GridFSDBFile dbFile = fs.findOne(new ObjectId(fileId));
		if(dbFile == null) {
			return null;
		}
		InputStream is = null;
		try {		
			int len = (int)dbFile.getLength();
			byte[] ret = new byte[len];
			is = dbFile.getInputStream();
			int tmp = 0;
			int i=0;
			while((tmp = is.read()) != -1 && i < len) {
				ret[i] = (byte)tmp;
				i++;
			}
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage(),e);
			return null;
		}finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error(e.getMessage(),e);
				}
			}
		}		
	}
	
	public byte[] readFileByName(String dbName, String fileName) {
		if(fileName == null) {
			return null;
		}
		GridFS fs = new GridFS(mongo.getDB(dbName));
		GridFSDBFile dbFile = fs.findOne(new BasicDBObject(FILE_NAME, fileName));
		if(dbFile == null) {
			return null;
		}
		InputStream is = null;
		try {		
			int len = (int)dbFile.getLength();
			byte[] ret = new byte[len];
			is = dbFile.getInputStream();
			int tmp = 0;
			int i=0;
			while((tmp = is.read()) != -1 && i < len) {
				ret[i] = (byte)tmp;
				i++;
			}
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage(),e);
			return null;
		}finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error(e.getMessage(),e);
				}
			}
		}
	}
	
	public void readFile(String dbName, String fileId, String localFileName) {
		if(fileId == null) {
			return ;
		}
		GridFS fs = new GridFS(mongo.getDB(dbName));
		GridFSDBFile dbFile = fs.findOne(new ObjectId(fileId));
		if(dbFile == null) {
			return ;
		}
		File file = new File(localFileName);
		try {
			dbFile.writeTo(file);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		
	}
	
	public void readFileByName(String dbName, String fileName, String localFileName) {
		if(fileName == null) {
			return ;
		}
		GridFS fs = new GridFS(mongo.getDB(dbName));
		GridFSDBFile dbFile = fs.findOne(new BasicDBObject(FILE_NAME, fileName));
		if(dbFile == null) {
			return ;
		}
		File file = new File(localFileName);
		try {
			dbFile.writeTo(file);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		
	}
}
