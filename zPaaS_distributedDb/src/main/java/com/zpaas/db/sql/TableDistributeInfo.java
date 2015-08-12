package com.zpaas.db.sql;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * 解析后的分库分表规则信息
 * @author zjy
 * @date 2014年6月23日 上午10:00:35 
 * @version V1.0
 */
public class TableDistributeInfo implements Serializable{
	private static final long serialVersionUID = 2743575240419513854L;
	private HashMap<Object, Integer> dbIdMap = new HashMap<Object, Integer>();
	private HashMap<Object, Integer> tableIdMap = new HashMap<Object, Integer>();
	
	private String tableName;
	private String tablePattern;
	private String dbPattern;
	private HashMap<Object, String> logicDbMap = new HashMap<Object, String>();
	private HashMap<Object, String> physicalTableMap = new HashMap<Object, String>();
	private HashMap<String, Object> tableColValueMap = new HashMap<String, Object>();
	private Set<Object> tenants = null;
	
	private int fullTableScan = 1;//-1表示全分表扫描
	private int fullDBScan = 1;//-1表示全分库扫描
	
	public String getDbPattern() {
		return dbPattern;
	}
	public void setDbPattern(String dbPattern) {
		this.dbPattern = dbPattern;
	}
	public HashMap<String, Object> getTableColValueMap() {
		return tableColValueMap;
	}
	public void setTableColValueMap(HashMap<String, Object> tableColValueMap) {
		this.tableColValueMap = tableColValueMap;
	}
	public int getFullDBScan() {
		return fullDBScan;
	}
	public void setFullDBScan(int fullDBScan) {
		this.fullDBScan = fullDBScan;
	}
	public HashMap<Object, Integer> getDbIdMap() {
		return dbIdMap;
	}
	public void setDbIdMap(HashMap<Object, Integer> dbIdMap) {
		this.dbIdMap = dbIdMap;
	}
	public HashMap<Object, Integer> getTableIdMap() {
		return tableIdMap;
	}
	public void setTableIdMap(HashMap<Object, Integer> tableIdMap) {
		this.tableIdMap = tableIdMap;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public HashMap<Object, String> getLogicDbMap() {
		return logicDbMap;
	}
	public void setLogicDbMap(HashMap<Object, String> logicDbMap) {
		this.logicDbMap = logicDbMap;
	}
	public HashMap<Object, String> getPhysicalTableMap() {
		return physicalTableMap;
	}
	public void setPhysicalTableMap(HashMap<Object, String> physicalTableMap) {
		this.physicalTableMap = physicalTableMap;
	}
	public String getTablePattern() {
		return tablePattern;
	}
	public void setTablePattern(String tablePattern) {
		this.tablePattern = tablePattern;
	}
	public int getFullTableScan() {
		return fullTableScan;
	}
	public void setFullTableScan(int fullTableScan) {
		this.fullTableScan = fullTableScan;
	}
	public Set<Object> getTenants() {
		return tenants;
	}
	public void setTenants(Set<Object> tenants) {
		this.tenants = tenants;
	}
	
	
}
