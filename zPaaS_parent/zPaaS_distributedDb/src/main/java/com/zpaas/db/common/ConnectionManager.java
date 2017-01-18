package com.zpaas.db.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 连接管理类
 * @author zjy
 * @date 2014年6月23日 上午9:54:03 
 * @version V1.0
 */
public class ConnectionManager {
	public static final Logger log = LoggerFactory.getLogger(ConnectionManager.class);
	
	private Map<String, Connection> connMap = new ConcurrentHashMap<String, Connection>();
	private List<Statement> stateList = new Vector<Statement>();
	//private Map<String, LogicDBConnection> logicConnMap = new ConcurrentHashMap<String, LogicDBConnection>();
	
	public boolean isContain(String dbName) {
		if(connMap.containsKey(dbName)) {
			return true;
		}else {
			return false;
		}
	}
	
	public Connection getConnection(String dbName,DataSource ds) {
		synchronized(this) {
			Connection conn = connMap.get(dbName);
			if(conn == null) {
				try {
					conn = ds.getConnection();
					this.addConnection(dbName, conn);
					if(log.isTraceEnabled()) {
						log.trace("get new connection from  db: {}", dbName);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			} else {
				if(log.isTraceEnabled()) {
					log.trace("get connection from connection manager, db: {}", dbName);
				}
			}
			return conn;
		}		
	}
	
	private void addConnection(String dbName, Connection conn) {
		connMap.put(dbName, conn);
	}
	
	public void addStatement(Statement statement) {
		stateList.add(statement);
	}
	
	public List<Statement> getStatementList() {
		return stateList;
	}
	
//	public LogicDBConnection getLogicDBConnection(String dbName) {
//		return logicConnMap.get(dbName);
//	}
//	
//	public void addLogicDBConnection(String dbName, LogicDBConnection conn) {
//		logicConnMap.put(dbName, conn);
//	}

	public Map<String, Connection> getConnMap() {
		return connMap;
	}

	public void setConnMap(Map<String, Connection> connMap) {
		this.connMap = connMap;
	}

	public void setStateList(List<Statement> stateList) {
		this.stateList = stateList;
	}

//	public Map<String, LogicDBConnection> getLogicConnMap() {
//		return logicConnMap;
//	}
//
//	public void setLogicConnMap(Map<String, LogicDBConnection> logicConnMap) {
//		this.logicConnMap = logicConnMap;
//	}
	
}
