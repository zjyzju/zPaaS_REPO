package com.zpaas.db.distribute;

/**
 * 分布式数据库的分库分表规则类
 * @author zjy
 * @date 2014年6月23日 上午9:56:50 
 * @version V1.0
 */
public class DistributedTableRule {
	private String logicDBPattern;
	private String tableNamePattern;
	private String logicDBRule;
	private String tableNameRule;
	private String distributeKey;
	private boolean allowFullTableScan;
	private int subTableCount;
	private String tenantColumn;
	private boolean allowFullTenantScan;
	
	public int getSubTableCount() {
		return subTableCount;
	}
	public void setSubTableCount(int subTableCount) {
		this.subTableCount = subTableCount;
	}
	public String getLogicDBPattern() {
		return logicDBPattern;
	}
	public void setLogicDBPattern(String logicDBPattern) {
		this.logicDBPattern = logicDBPattern;
	}
	public String getTableNamePattern() {
		return tableNamePattern;
	}
	public void setTableNamePattern(String tableNamePattern) {
		this.tableNamePattern = tableNamePattern;
	}
	public String getLogicDBRule() {
		return logicDBRule;
	}
	public void setLogicDBRule(String logicDBRule) {
		this.logicDBRule = logicDBRule;
	}
	public String getTableNameRule() {
		return tableNameRule;
	}
	public void setTableNameRule(String tableNameRule) {
		this.tableNameRule = tableNameRule;
	}
	public boolean isAllowFullTableScan() {
		return allowFullTableScan;
	}
	public void setAllowFullTableScan(boolean allowFullTableScan) {
		this.allowFullTableScan = allowFullTableScan;
	}
	public String getDistributeKey() {
		return distributeKey;
	}
	public void setDistributeKey(String distributeKey) {
		this.distributeKey = distributeKey;
	}
	public String getTenantColumn() {
		return tenantColumn;
	}
	public void setTenantColumn(String tenantColumn) {
		this.tenantColumn = tenantColumn;
	}
	public boolean isAllowFullTenantScan() {
		return allowFullTenantScan;
	}
	public void setAllowFullTenantScan(boolean allowFullTenantScan) {
		this.allowFullTenantScan = allowFullTenantScan;
	}
}
