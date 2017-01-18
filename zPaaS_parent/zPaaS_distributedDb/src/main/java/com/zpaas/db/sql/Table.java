package com.zpaas.db.sql;

import java.io.Serializable;

import net.sf.json.JSONObject;

/**
 * 存放SQL经过解析后的表的信息
 * @author zjy
 * @date 2014年6月18日 下午2:12:46 
 * @version V1.0
 */
public class Table implements Serializable{
	private static final long serialVersionUID = 8604791019520237354L;
	private String tableName;	//表名
	private String alias;		//别名
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}
