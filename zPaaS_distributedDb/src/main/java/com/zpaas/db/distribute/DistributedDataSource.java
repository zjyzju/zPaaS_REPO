package com.zpaas.db.distribute;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;

import javax.sql.DataSource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ByteArrayResource;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.db.common.DistributedTransactionManager;
import com.zpaas.db.logic.LogicDBDataSource;
import com.zpaas.file.FileManagerSVC;

/**
 * 分布式数据库的DataSource类
 * @author zjy
 * @date 2014年6月23日 上午9:54:49 
 * @version V1.0
 */
@SuppressWarnings("deprecation")
public class DistributedDataSource implements DataSource, ConfigurationWatcher {
	public static final Logger log = Logger.getLogger(DistributedDataSource.class);
	public static final HashMap<String, LogicDBDataSource> logicDBMap = new HashMap<String, LogicDBDataSource>();
	 
	private String distributedDB="distributedDB";
	private String dbType;
	private DistributedDBRule dbRule = null;
	
	private String confPath = "/com/zpaas/db/distributedDb/conf";
	private String dbConf = null;
	private ConfigurationCenter cc = null;
	private FileManagerSVC fileManager = null;
	
	
	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
			
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 根据表名，分库字段值计算分表id
	 * @param tableName 表名
	 * @param keyValues 分库字段值
	 * @return 分表id
	 */
	public Integer calculateDistributeId(String tableName, Object keyValue) {
		return this.dbRule.calculateDistributeId(tableName, keyValue);
	}
	
	public void process(String conf) {
		if(log.isInfoEnabled()) {
			log.info("new DistributedDataSource configuration is received: " + conf);
		}
		if(conf == null || conf.trim().length() == 0) {
			log.error("DistributedDataSource configuration is empty.");
			return;
		}
		if(conf != null && !conf.equals(dbConf)) {
			dbConf = conf;
			initDb();
		}
	}
	
	public void initDb() {
		if(log.isDebugEnabled()) {
			log.debug("init DistributedDataSource:" + distributedDB);
		}
		JSONObject conf = JSONObject.fromObject(dbConf);
		String filePath = conf.getString("fileId");
		if(filePath == null || filePath.trim().length() == 0) {
			log.error("invalid db conf: fileId is empty.");
			return;
		}
		XmlBeanFactory ctx = null;
		try {
			ByteArrayResource res = new ByteArrayResource(fileManager.readFile(filePath));
			ctx = new XmlBeanFactory(res);
		} catch (Exception e) {
			log.error("load db rule from file failed:" + e);
			log.error(e.getMessage(),e);
			return;
		}
		dbRule = (DistributedDBRule)ctx.getBean("dbRule");
		this.setDbType(dbRule.getDbType());
		if(dbRule == null) {
			log.error("invalid db conf: can't get dbRule bean.");
			return;
		}
		JSONArray array = conf.getJSONArray("logicDbs");
		if(array == null) {
			log.error("invalid db conf: can't get logicDbs bean.");
			return;
		}
		if(array != null && array.size() > 0) {
			JSONObject json = null;
			for(int i=0; i<array.size(); i++) {
				json = array.getJSONObject(i);
				String dbName = json.getString("logicDB");
				LogicDBDataSource ds = (LogicDBDataSource)ctx.getBean(json.getString("logicDB"));
				ds.setDbType(this.getDbType());
				if(dbName == null || dbName.trim().length() == 0 || ds == null) {
					log.error("invalid logicDB conf:" + i);
				}
				logicDBMap.put(dbName, ds);
			}
		}
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		throw new SQLException("unsupported operation");
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		throw new SQLException("unsupported operation");
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		throw new SQLException("unsupported operation");
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		throw new SQLException("unsupported operation");
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		try {
			return (T) this;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		if(super.getClass().isAssignableFrom(iface)) {
			return true;
		}
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		DistributedConnection conn = new DistributedConnection();
		conn.setDbRule(dbRule);
		if(DistributeRuleAssist.isReadonly()) {
			conn.setReadOnly(true);
		}
		if(DistributedTransactionManager.isInTransaction()) {
			conn.setAutoCommit(false);
			DistributedTransactionManager.bindConnection(distributedDB, conn);
			DistributedTransactionManager.setLevel(1);
		}
		return conn;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		return getConnection();
	}

	public String getDistributedDB() {
		return distributedDB;
	}

	public void setDistributedDB(String distributedDB) {
		this.distributedDB = distributedDB;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public ConfigurationCenter getCc() {
		return cc;
	}

	public void setCc(ConfigurationCenter cc) {
		this.cc = cc;
	}

	public FileManagerSVC getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManagerSVC fileManager) {
		this.fileManager = fileManager;
	}

	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
