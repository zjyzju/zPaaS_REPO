package com.zpaas.db.sql;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * 定义SQL类型的常量类，并提供返回SQL类型的表态方法
 * @author zjy
 * @date 2014年6月18日 下午2:13:34 
 * @version V1.0
 */
public class SQLType {
	public static final String INSERT = "INSERT";
	public static final String UPDATE = "UPDATE";
	public static final String SELECT = "SELECT";
	public static final String SELECT_FOR_UPDATE = "SELECT_FOR_UPDATE";
	public static final String DELETE = "DELETE";
	public static final String TRUNCATE = "TRUNCATE";
	public static final String REPLACE = "REPLACE";
	public static final String CREATE = "CREATE";
	public static final String ALTER = "ALTER";
	public static final String DROP = "DROP";
	public static final String DESC = "DESC";
	public static final String SHOW = "SHOW";
	private static final HashMap<String, String> sqlTypeCache = new HashMap<String, String>();
	private static final Pattern SELECT_FOR_UPDATE_PATTERN = Pattern.compile("^select\\s+.*\\s+for\\s+update.*$", 2);
	
	/**
	 * 返回SQL的类型
	 * @param sql SQL语句
	 * @return SQL类型
	 * @throws SQLException
	 */
	public static String getSqlType(String sql) throws SQLException {
		if(sql == null || sql.length() == 0) {
			return null;
		}
		String sqlType = sqlTypeCache.get(sql);
		if (sqlType != null && sqlType.length() != 0) {
			return sqlType;
		}

		sql = sql.trim().toLowerCase();

		if (sql.startsWith("select")) {
			if ((sql.contains(" for ")) && (SELECT_FOR_UPDATE_PATTERN.matcher(sql).matches()))
				sqlType = SQLType.SELECT_FOR_UPDATE;
			else
				sqlType = SQLType.SELECT;
		} else if (sql.startsWith("insert")) {
			sqlType = SQLType.INSERT;
		} else if (sql.startsWith("update")) {
			sqlType = SQLType.UPDATE;
		} else if (sql.startsWith("delete")) {
			sqlType = SQLType.DELETE;
		} else if (sql.startsWith("replace")) {
			sqlType = SQLType.REPLACE;
		} else if (sql.startsWith("truncate")) {
			sqlType = SQLType.TRUNCATE;
		} else if (sql.startsWith("create")) {
			sqlType = SQLType.CREATE;
		} else if (sql.startsWith("alter")) {
			sqlType = SQLType.ALTER;
		} else if (sql.startsWith("drop")) {
			sqlType = SQLType.DROP;
		} else if (sql.startsWith("show")) {
			sqlType = SQLType.SHOW;
		} else if (sql.startsWith("desc")) {
			sqlType = SQLType.DESC;
		} else{
			throw new SQLException("only select, insert, update, delete, replace,truncate,create,alter,drop,show,desc sql is supported");
		}

		sqlTypeCache.put(sql, sqlType);
		return sqlType;
	}
}
