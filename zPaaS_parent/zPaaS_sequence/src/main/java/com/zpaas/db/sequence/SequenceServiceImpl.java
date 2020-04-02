package com.zpaas.db.sequence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import net.sf.json.JSONObject;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.utils.CipherUtil;


/**
 * Sequence服务实现类
 * @author zjy
 * @date 2014年6月23日 上午9:59:57 
 * @version V1.0
 */
public class SequenceServiceImpl implements ConfigurationWatcher,SequenceService{
	public static final Logger log = LoggerFactory.getLogger(SequenceServiceImpl.class);
	
	private int range = 1000;
	private String sqlSelect;
	private String sqlUpdate;
	private String sequenceTable = "sequence";
	
	private DataSource db;
	private JSONObject conf;
	private String dbConf = null;
	
	
	private String confPath = "/com/zpaas/db/sequence/conf";	
	private ConfigurationCenter cc = null;
	
	public SequenceCache getSequenceCache(String sequenceName){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			if(sqlSelect  == null || sqlSelect.length() == 0) {
				sqlSelect = "select value from " + sequenceTable + " where name = ? for update";
			}
			ps = conn.prepareStatement(sqlSelect);
			ps.setString(1, sequenceName);
			rs = ps.executeQuery();
			if(rs != null && rs.next()) {
				long currVal = rs.getLong(1);
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(sqlUpdate  == null || sqlUpdate.length() == 0) {
					sqlUpdate = "update " + sequenceTable + " set value=? where name = ?";
				}
				ps = conn.prepareStatement(sqlUpdate);
				ps.setLong(1, currVal + range);
				ps.setString(2, sequenceName);
				int ret = ps.executeUpdate();
				conn.commit();
				if(ret == 1) {
					SequenceCache cache = new SequenceCache(currVal+1, currVal+range);
					if(log.isDebugEnabled()) {
						log.debug("get sequence cache: {}", JSONObject.fromObject(cache));
					}
					return cache;
				}				
			}
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
			try {
				if(ps != null)
					ps.close();
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
		}
		return null;
	}
	
	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
			
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public void process(String conf) {
		if(log.isInfoEnabled()) {
			log.info("new log configuration is received: {}", conf);
		}
		if(conf != null && !conf.equals(dbConf)) {
			dbConf = conf;
			this.conf = JSONObject.fromObject(dbConf);
			initDb();
			String tableName = this.conf.getString("sequenceTable");
			if(tableName != null && !tableName.equals(sequenceTable)) {
				sequenceTable = tableName;
				sqlSelect = null;
				sqlUpdate = null;
			}
		}
	}
	
	public void initDb() {				
		if(conf != null) {
			if(log.isDebugEnabled()) {
				log.debug("init Sequence DataSource");
				log.debug("----dbRule:{}", dbConf);
			}
			BasicDataSource ds = new BasicDataSource();
			if(conf.containsKey("driver")) {
				ds.setDriverClassName(conf.getString("driver"));
			}
			if(conf.containsKey("username")) {
				ds.setUsername(conf.getString("username"));
			}
			if(conf.containsKey("password")) {
				ds.setPassword(CipherUtil.decrypt(conf.getString("password")));
			}
			if(conf.containsKey("url")) {
				ds.setUrl(conf.getString("url"));
			}
			if(conf.containsKey("initSize")) {
				ds.setInitialSize(conf.getInt("initSize"));
			}
			if(conf.containsKey("maxActive")) {
				ds.setMaxActive(conf.getInt("maxActive"));
			}
			if(conf.containsKey("maxIdle")) {
				ds.setMaxIdle(conf.getInt("maxIdle"));
			}
			if(conf.containsKey("maxWait")) {
				ds.setMaxWait(conf.getInt("maxWait"));
			}
			if(conf.containsKey("validationQuery")) {
				ds.setValidationQuery(conf.getString("validationQuery").replace("&nbsp;", " "));
			}
			if(conf.containsKey("testWhileIdle")) {
				ds.setTestWhileIdle(Boolean.valueOf(conf.getString("testWhileIdle")));
			}
			db = ds;
		}
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	public ConfigurationCenter getCc() {
		return cc;
	}

	public void setCc(ConfigurationCenter cc) {
		this.cc = cc;
	}

	public String getSequenceTable() {
		return sequenceTable;
	}

	public void setSequenceTable(String sequenceTable) {
		this.sequenceTable = sequenceTable;
	}
}
