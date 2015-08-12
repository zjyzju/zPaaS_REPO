package com.zpaas.db.logic;

import java.sql.Connection;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.zpaas.db.base.ConnectionBase;
import com.zpaas.db.base.StatementBase;
import com.zpaas.db.distribute.DistributeRuleAssist;

/**
 * 逻辑库的Statement类
 * @author zjy
 * @date 2014年6月23日 上午9:58:40 
 * @version V1.0
 */
public class LogicDBStatement extends StatementBase {
	public static final Logger log = Logger.getLogger(LogicDBStatement.class);
	
	
	private JSONObject dbRule;	
	private LogicDBDataSource ds;
	
	public String selectDb() {
		int dbIndex = this.getDs().randomDbIndex();
		for(String dbName : this.getDs().getDbMap().keySet()) {
			if(dbIndex >= this.getDs().getWeightMap().get(dbName+"_min")  
					&& dbIndex < this.getDs().getWeightMap().get(dbName+"_max")) {
				return dbName;
			}
		}
		return null;
	}
	
	protected void processDbRule(String sql) {
		if(DistributeRuleAssist.isReadonly()) {
			setDbName(selectDb());
		}else {
			setDbName(getDbRule().getString("master"));
		}
		if(log.isTraceEnabled()) {
			log.trace("select db(" + this.getDbName() + ") to execute sql");
		}
	}
	
	public Connection getRealConnection(String dbName) throws SQLException {
		if(this.isClosed()) {
			return null;
		}
		Connection conn = manager.getConnection(dbName,this.getDs().getDbMap().get(dbName));
//		if(conn == null) {
//			BasicDataSource ds = (BasicDataSource)this.getDs().getDbMap().get(dbName);
//			conn = ds.getConnection();
//			manager.addConnection(dbName, conn);
//			if(log.isTraceEnabled()) {
//				log.trace("get new connection from  db: " + this.getDbName());
//			}
//		} else {
//			if(log.isTraceEnabled()) {
//				log.trace("get connection from connection manager, db: " + this.getDbName());
//			}
//		}
		if(conn == null) {
			throw new SQLException("failed to get connection from db: "+ this.getDbName());
		}
		((ConnectionBase)this.getConnection()).setWrappedConnection(conn);
		conn.setAutoCommit(((ConnectionBase)this.getConnection()).getAutoCommit());
		conn.setReadOnly(((ConnectionBase)this.getConnection()).isReadOnly());
		return conn;
	}
	
	@Override
	public Connection getRealConnection() throws SQLException {
		if(this.isClosed()) {
			return null;
		}
		Connection conn = manager.getConnection(dbName,this.getDs().getDbMap().get(dbName));
//		if(conn == null) {
//			DataSource ds = this.getDs().getDbMap().get(dbName);
//			conn = ds.getConnection();
//			manager.addConnection(dbName, conn);
//			if(log.isTraceEnabled()) {
//				log.trace("get new connection from  db: " + this.getDbName());
//			}
//		} else {
//			if(log.isTraceEnabled()) {
//				log.trace("get connection from connection manager, db: " + this.getDbName());
//			}
//		}
		if(conn == null) {
			throw new SQLException("failed to get connection from db: "+ this.getDbName());
		}
		((ConnectionBase)this.getConnection()).setWrappedConnection(conn);
		conn.setReadOnly(((ConnectionBase)this.getConnection()).isReadOnly());
		conn.setAutoCommit(((ConnectionBase)this.getConnection()).getAutoCommit());
		return conn;
	}

	protected JSONObject getDbRule() {
		return dbRule;
	}

	protected void setDbRule(JSONObject dbRule) {
		this.dbRule = dbRule;
	}

	public LogicDBDataSource getDs() {
		return ds;
	}

	public void setDs(LogicDBDataSource ds) {
		this.ds = ds;
	}

}
