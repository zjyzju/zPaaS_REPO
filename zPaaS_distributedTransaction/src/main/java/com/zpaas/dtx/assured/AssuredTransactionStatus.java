package com.zpaas.dtx.assured;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import com.zpaas.dtx.common.TransactionStatus;

public class AssuredTransactionStatus extends TransactionStatus {
	

	private Map<String, Connection> conns = new HashMap<String, Connection>();
	private AssuredTransactionContext assuredContext = null;
	private Connection mainConn;
	
	public AssuredTransactionStatus() {
		
	}

	public Map<String, Connection> getConns() {
		return conns;
	}

	public void setConns(Map<String, Connection> conns) {
		this.conns = conns;
	}

	public AssuredTransactionContext getAssuredContext() {
		return assuredContext;
	}

	public void setAssuredContext(AssuredTransactionContext assuredContext) {
		this.assuredContext = assuredContext;
	}

	public Connection getMainConn() {
		return mainConn;
	}

	public void setMainConn(Connection mainConn) {
		this.mainConn = mainConn;
	}

	
	
}
