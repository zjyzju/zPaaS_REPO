package com.zpaas.db.sql;

import java.io.Serializable;
import java.util.List;
/**
 * 保存SQl解析后信息的类
 * @author zjy
 * @date 2014年6月18日 下午3:11:56 
 * @version V1.0
 */
public class ParsedSqlContext implements Serializable {

	private static final long serialVersionUID = 2330895768878803734L;
	
	private List<Table> tables;//表信息
	private List<Column> columns;//列信息
	private List<String> funcTypes;//集合函数信息
	private List<String> groupElements;//group by列清单
	private boolean havingSql;//是否包含having子句
	private boolean groupBySql;//是否包含group by子句
	private String sqlType;
	
	public List<Table> getTables() {
		return tables;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public List<String> getFuncTypes() {
		return funcTypes;
	}
	public void setFuncTypes(List<String> funcTypes) {
		this.funcTypes = funcTypes;
	}
	public boolean isHavingSql() {
		return havingSql;
	}
	public void setHavingSql(boolean havingSql) {
		this.havingSql = havingSql;
	}
	public boolean isGroupBySql() {
		return groupBySql;
	}
	public void setGroupBySql(boolean groupBySql) {
		this.groupBySql = groupBySql;
	}
	public List<String> getGroupElements() {
		return groupElements;
	}
	public void setGroupElements(List<String> groupElements) {
		this.groupElements = groupElements;
	}
	public String getSqlType() {
		return sqlType;
	}
	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}
	
}
