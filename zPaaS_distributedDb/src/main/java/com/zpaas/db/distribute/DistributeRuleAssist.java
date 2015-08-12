package com.zpaas.db.distribute;

/**
 * 设置事务类型是否是只读，默认为读写
 * @author zjy
 * @date 2014年6月18日 下午3:13:09 
 * @version V1.0
 */
public class DistributeRuleAssist {
	private static final ThreadLocal<String> transactionType = new ThreadLocal<String>();
	private static final ThreadLocal<Integer> assistRule = new ThreadLocal<Integer>();
	private static final ThreadLocal<String> tenant = new ThreadLocal<String>();
	
	public static void setTenant(String tenantId) {
		tenant.set(tenantId);
	}
	
	public static void clearTenant() {
		tenant.set(null);
	}
	
	public static String getTenant() {
		return tenant.get();
	}
	
	public static void setTableIndex(Integer tableIndex) {
		assistRule.set(tableIndex);
	}
	
	public static void clearTableIndex() {
		assistRule.set(null);
	}
	
	public static Integer getTableIndex() {
		return assistRule.get();
	}
	
	public static void setReadonly() {
		transactionType.set("readonly");
	}
	
	public static void setReadWrite() {
		transactionType.set("readwrite");
	}
	
	public static boolean isReadonly() {
		if("readonly".equals(transactionType.get())) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isReadWrite() {
		if("readwrite".equals(transactionType.get())) {
			return true;
		}else {
			return false;
		}
	}
}
