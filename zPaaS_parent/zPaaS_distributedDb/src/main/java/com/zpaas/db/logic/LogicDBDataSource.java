package com.zpaas.db.logic;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Random;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.db.common.DistributedTransactionManager;
import com.zpaas.utils.CipherUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 逻辑库的DataSource类
 * @author zjy
 * @date 2014年6月23日 上午9:58:04 
 * @version V1.0
 */
public class LogicDBDataSource implements DataSource, ConfigurationWatcher {
	public static final Logger log = LoggerFactory.getLogger(LogicDBDataSource.class);
	private String logicDB;
	private String dbType;
	private JSONObject dbRule;
	private HashMap<String, DataSource> dbMap = new HashMap<String, DataSource>();
	private HashMap<String, Integer> weightMap = new HashMap<String, Integer>();
	private int weight;
	private Random random = null;
	
	
	private String confPath = "/com/zpaas/db/logicDb/conf";
	private String dbConf = null;
	private ConfigurationCenter cc = null;
	
	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
			
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public void process(String conf) {
		if(log.isInfoEnabled()) {
			log.info("new LogicDBDataSource configuration is received: {}", conf);
		}
		if(conf == null || conf.trim().length() == 0) {
			log.error("LogicDBDataSource configuration is empty.");
			return;
		}
		if(conf != null && !conf.equals(dbConf)) {
			dbConf = conf;
			initDb();
		}
	}
	
	public void initDb() {
		try {
			dbRule = JSONObject.fromObject(dbConf);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return;
		}
		
		if(dbRule != null) {
			logicDB = dbRule.getString("logicDB");
			if(logicDB == null || logicDB.trim().length() == 0) {
				log.error("invalid db conf: logicDB is empty.");
				return;
			}
			if(log.isDebugEnabled()) {
				log.debug("init LogicDBDataSource:{}", logicDB);
				log.debug("----dbRule: {}", dbRule);
			}
			String dbName = dbRule.getString("master");
			if(dbName == null || dbName.trim().length() == 0) {
				log.error("invalid db conf: master is empty.");
				return;
			}
			if(log.isDebugEnabled()) {
				log.debug("create master DataSource:{}", dbName);
			}
			
			JSONObject conf = dbRule.getJSONObject(dbName);
			BasicDataSource ds = new BasicDataSource();
			if(conf.containsKey("driver")) {
				String driver = conf.getString("driver");
				if(driver != null && driver.trim().length() > 0) {
					ds.setDriverClassName(driver);
				}else {
					log.error("invalid db conf of {}: driver is empty.", dbName);
				}
			}else {
				log.error("invalid db conf of {}: driver is empty.", dbName);
			}
			if(conf.containsKey("username")) {
				String username = conf.getString("username");
				if(username != null && username.trim().length() >0) {
					ds.setUsername(username);
				}else {
					log.error("invalid db conf of {}: username is empty.", dbName);
				}
			}else {
				log.error("invalid db conf of {}: username is empty.", dbName);
			}
			if(conf.containsKey("password")) {
				String password = null;
				try {
					password = CipherUtil.decrypt(conf.getString("password"));
				} catch (Exception e) {
					log.error(e.getMessage(),e);
				}
				if(password != null && password.trim().length() > 0) {
					ds.setPassword(password);
				}else {
					log.error("invalid db conf of {}: password is empty.", dbName);
				}
			}else {
				log.error("invalid db conf of {}: password is empty.", dbName);
			}
			if(conf.containsKey("url")) {
				String url = conf.getString("url");
				if(url != null && url.trim().length() > 0) {
					ds.setUrl(url);
				}else {
					log.error("invalid db conf of {}: url is empty.", dbName);
				}
			}else {
				log.error("invalid db conf of {}: url is empty.", dbName);
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
			
			if(conf.containsKey("testOnBorrow")) {
				ds.setTestOnBorrow(Boolean.valueOf(conf.getString("testOnBorrow")));
			}
			if(conf.containsKey("testOnReturn")) {
				ds.setTestOnReturn(Boolean.valueOf(conf.getString("testOnReturn")));
			}
			if(conf.containsKey("timeBetweenEvictionRunsMillis")) {
				ds.setTimeBetweenEvictionRunsMillis(Long.valueOf(conf.getString("timeBetweenEvictionRunsMillis")));
			}
			if(conf.containsKey("minEvictableIdleTimeMillis")) {
				ds.setMinEvictableIdleTimeMillis(Long.valueOf(conf.getString("minEvictableIdleTimeMillis")));
			}
			if(conf.containsKey("numTestsPerEvictionRun")) {
				ds.setNumTestsPerEvictionRun(Integer.valueOf(conf.getString("numTestsPerEvictionRun")));
			}
			if(conf.containsKey("removeAbandoned")) {
				ds.setRemoveAbandoned(Boolean.valueOf(conf.getString("removeAbandoned")));
			}
			if(conf.containsKey("removeAbandonedTimeout")) {
				ds.setRemoveAbandonedTimeout(Integer.valueOf(conf.getString("removeAbandonedTimeout")));
			}
			
			int weight = dbRule.getInt("weight");
			weightMap.put(dbName+"_min", 0);
			weightMap.put(dbName+"_max", weight);
			dbMap.put(dbName, ds);
			JSONArray array = dbRule.getJSONArray("slaves");
			if(array != null && array.size() > 0) {
				for(int i=0; i<array.size(); i++) {
					dbName = array.getJSONObject(i).getString("slave");
					conf = dbRule.getJSONObject(dbName);
					if(log.isDebugEnabled()) {
						log.debug("create slave DataSource: {}", dbName);
						log.debug("slave DataSource: {}", conf);
					}					
					ds = new BasicDataSource();
					if(conf.containsKey("driver")) {
						String driver = conf.getString("driver");
						if(driver != null && driver.trim().length() > 0) {
							ds.setDriverClassName(driver);
						}else {
							log.error("invalid db conf of {}: driver is empty.", dbName);
						}
					}else {
						log.error("invalid db conf of {}: driver is empty.", dbName);
					}
					if(conf.containsKey("username")) {
						String username = conf.getString("username");
						if(username != null && username.trim().length() >0) {
							ds.setUsername(username);
						}else {
							log.error("invalid db conf of {}: username is empty.", dbName);
						}
					}else {
						log.error("invalid db conf of {}: username is empty.", dbName);
					}
					if(conf.containsKey("password")) {
						String password = null;
						try {
							password = CipherUtil.decrypt(conf.getString("password"));
						} catch (Exception e) {
							log.error(e.getMessage(),e);
						}
						if(password != null && password.trim().length() > 0) {
							ds.setPassword(password);
						}else {
							log.error("invalid db conf of {}: password is empty.", dbName);
						}
					}else {
						log.error("invalid db conf of {}: password is empty.", dbName);
					}
					if(conf.containsKey("url")) {
						String url = conf.getString("url");
						if(url != null && url.trim().length() > 0) {
							ds.setUrl(url);
						}else {
							log.error("invalid db conf of {}: url is empty.", dbName);
						}
					}else {
						log.error("invalid db conf of {}: url is empty.", dbName);
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
					if(conf.containsKey("testOnBorrow")) {
						ds.setTestOnBorrow(Boolean.valueOf(conf.getString("testOnBorrow")));
					}
					if(conf.containsKey("testOnReturn")) {
						ds.setTestOnReturn(Boolean.valueOf(conf.getString("testOnReturn")));
					}
					if(conf.containsKey("timeBetweenEvictionRunsMillis")) {
						ds.setTimeBetweenEvictionRunsMillis(Long.valueOf(conf.getString("timeBetweenEvictionRunsMillis")));
					}
					if(conf.containsKey("minEvictableIdleTimeMillis")) {
						ds.setMinEvictableIdleTimeMillis(Long.valueOf(conf.getString("minEvictableIdleTimeMillis")));
					}
					if(conf.containsKey("numTestsPerEvictionRun")) {
						ds.setNumTestsPerEvictionRun(Integer.valueOf(conf.getString("numTestsPerEvictionRun")));
					}
					if(conf.containsKey("removeAbandoned")) {
						ds.setRemoveAbandoned(Boolean.valueOf(conf.getString("removeAbandoned")));
					}
					if(conf.containsKey("removeAbandonedTimeout")) {
						ds.setRemoveAbandonedTimeout(Integer.valueOf(conf.getString("removeAbandonedTimeout")));
					}
					weightMap.put(dbName+"_min", weight);
					weight += array.getJSONObject(i).getInt("weight");
					weightMap.put(dbName+"_max", weight);
					dbMap.put(dbName, ds);
				}
			}
			this.weight = weight;
			random = new Random(weight);
		}else {
			log.error("dbRule is null");
		}
	}
	
	public int randomDbIndex() {
		return random.nextInt(weight);
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
		LogicDBConnection conn = new LogicDBConnection();
		conn.setDbRule(dbRule);
		conn.setDs(this);
		if(DistributedTransactionManager.isInTransaction()) {
			conn.setAutoCommit(false);
			if(!DistributedTransactionManager.isDistributedLevel()) {
				DistributedTransactionManager.bindConnection(logicDB, conn);
			}
		}
		return conn;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		return this.getConnection();
	}

	public String getLogicDB() {
		return logicDB;
	}

	public void setLogicDB(String logicDB) {
		this.logicDB = logicDB;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public JSONObject getDbRule() {
		return dbRule;
	}

	public void setDbRule(JSONObject dbRule) {
		this.dbRule = dbRule;
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

	public HashMap<String, DataSource> getDbMap() {
		return dbMap;
	}

	public void setDbMap(HashMap<String, DataSource> dbMap) {
		this.dbMap = dbMap;
	}

	public HashMap<String, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<String, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
