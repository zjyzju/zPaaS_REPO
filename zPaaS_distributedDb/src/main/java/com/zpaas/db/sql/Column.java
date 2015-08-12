package com.zpaas.db.sql;

import java.io.Serializable;

import net.sf.json.JSONObject;

/**
 * 存放SQL经过解析后的条件信息
 * @author zjy
 * @date 2014年6月18日 下午2:12:14 
 * @version V1.0
 */
public class Column implements Serializable {
	private static final long serialVersionUID = -7805289011851894064L;
	private String columnName;	//列名
	private String value;		//条件值
	private String operator;	//比较操作符
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}
