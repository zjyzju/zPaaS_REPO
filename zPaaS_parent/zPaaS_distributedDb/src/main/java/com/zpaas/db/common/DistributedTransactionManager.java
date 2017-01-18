package com.zpaas.db.common;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DistributedTransactionManager {
	
	private static final ThreadLocal<Boolean> txStatus = new ThreadLocal<Boolean>();
	
	private static final ThreadLocal<ConcurrentHashMap<String, Connection>> connMap = new ThreadLocal<ConcurrentHashMap<String, Connection>>();
	
	private static final ThreadLocal<Integer> level = new ThreadLocal<Integer>();
	
	
	private static void initTxStatus() {
		if(txStatus.get() == null) {
			txStatus.set(false);
		}
	}
	
	private static void initLevel() {
		if(level.get() == null) {
			level.set(0);
		}
	}
	
	private static void initConnMap() {
		if(connMap.get() == null) {
			connMap.set(new ConcurrentHashMap<String, Connection>());
		}
	}
	
	public static void setLevel(Integer dsLevel) {
		level.set(dsLevel);
	}
	
	public static boolean isDistributedLevel() {
		initLevel();
		if(level.get() == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void beginTransaction() {
		txStatus.set(true);
	}
	
	public static void endTransaction() {
		txStatus.set(false);
	}
	
	public static boolean isInTransaction() {
		initTxStatus();
		return txStatus.get();
	}
	
	public static void bindConnection(String name, Connection conn) {
		initConnMap();
		connMap.get().put(name, conn);
	}
	
	public static void unbindConnection(String name) {
		initConnMap();
		connMap.get().remove(name);
	}
	
	public static Map<String, Connection> getConnectionMap() {
		return connMap.get();
	}

}
