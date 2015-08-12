package com.zpaas.db.tenant;

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
public class MultiTenantStatement extends StatementBase {
	public static final Logger log = Logger.getLogger(MultiTenantStatement.class);
	
	
	private JSONObject dbRule;	
	private MultiTenantDataSource ds;
	
	public String selectDb() {
		String tenantId = DistributeRuleAssist.getTenant();
		if(tenantId == null || tenantId.trim().length() == 0) {
			log.error("invalid tenantId:" + tenantId);
			return null;
		}
		return tenantId;
	}
	
	protected void processDbRule(String sql) {
		setDbName(selectDb());
		if(log.isTraceEnabled()) {
			log.trace("select db(" + this.getDbName() + ") to execute sql");
		}
	}
	
	public Connection getRealConnection(String dbName) throws SQLException {
		if(this.isClosed()) {
			return null;
		}
		Connection conn = manager.getConnection(dbName, this.getDs().getDbMap().get(dbName));
//		if(conn == null) {
//			DistributedDataSource ds = (DistributedDataSource)this.getDs().getDbMap().get(dbName);
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
		Connection conn = manager.getConnection(dbName, this.getDs().getDbMap().get(dbName));
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

	public MultiTenantDataSource getDs() {
		return ds;
	}

	public void setDs(MultiTenantDataSource ds) {
		this.ds = ds;
	}

}
