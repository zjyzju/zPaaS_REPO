package com.zpaas.db.distribute;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.zpaas.cache.remote.RemoteCacheSVC;
import com.zpaas.db.sql.Column;
import com.zpaas.db.sql.ParsedSqlContext;
import com.zpaas.db.sql.SQLType;
import com.zpaas.db.sql.SqlParser;
import com.zpaas.db.sql.Table;
import com.zpaas.db.sql.TableDistributeInfo;

/**
 * 分布式数据库分库分表规则的处理类
 * 
 * @author zjy
 * @date 2014年6月18日 下午3:30:41
 * @version V1.0
 */
public class DistributedDBRule {
	public static final Logger log = Logger.getLogger(DistributedDBRule.class);

	public static final String QUESTION_MARK = "question_mark_";// 替换？的字符串
	public static final String DEFAULT_RULE = "defaultRule";
	private String dbType;// 数据库类型
	private HashMap<String, DistributedTableRule> tableRules;// 分库分表规则
	private HashMap<String, Map<Object, Integer>> mappingRules;// 分库分表规则
	private static HashMap<String, ParsedSqlContext> sqlCache = new HashMap<String, ParsedSqlContext>();// 本地缓存
	private RemoteCacheSVC cacheSvc = null;// redis缓存
	private String multiTenantMode;// <!--
									// 多租户模式：false:关闭；multiUser:用户隔离模式；oneUser1:单用户，字段隔离模式，查检条件模式;
									// oneUser2:单用户，字段隔离模式,自动增加条件模式-->
	private boolean allowFullTenantScan;//<!-- 是否允许访问多个租户的数据 -->

	public void init() {

	}

	/**
	 * 根据sql从缓存获取分析后的sql缓存，如果在缓存中获取不到，则重新分析生成并加入缓存
	 * 
	 * @param sql
	 *            SQL语句
	 * @return ParsedSqlContext
	 */
	public ParsedSqlContext getParsedSqlContext(String sql,
			Map<Integer, Object> valueMap) {
		if (log.isTraceEnabled()) {
			log.trace("originalSql:" + sql);
		}
		if (sql.indexOf("?") > 0 && valueMap != null) {
			int len = valueMap.size();
			for (int i = 1; i < len + 1; i++) {
				sql = sql.replaceFirst("\\?", QUESTION_MARK + i);
			}
		}
		if (log.isTraceEnabled()) {
			log.trace("tmpSql:" + sql);
		}
		ParsedSqlContext ctx = null;
		if (cacheSvc != null) {// 从redis缓存获取
			if (log.isTraceEnabled()) {
				log.trace("get parsed sql from remote cache");
			}
			ctx = (ParsedSqlContext) cacheSvc.getItem(sql);
		} else {// 从本地缓存获取
			if (log.isTraceEnabled()) {
				log.trace("get parsed sql from local cache");
			}
			ctx = sqlCache.get(sql);
		}
		if (ctx != null) {// 如果能取到则直接返回
			if (log.isTraceEnabled()) {
				log.trace("get parsed sql:" + JSONArray.fromObject(ctx));
			}
			return ctx;
		} else {// 如果取不到则重新解析
			ctx = SqlParser.parseSql(sql);// 解析SQL语句，得到解析后的类
			// 将解析后的类加入缓存
			if (ctx != null) {
				if (cacheSvc != null) {
					cacheSvc.addItem(sql, ctx);
				} else {
					sqlCache.put(sql, ctx);
				}
				if (log.isTraceEnabled()) {
					log.trace("get parsed sql by sql parser:"
							+ JSONArray.fromObject(ctx));
				}
				return ctx;
			}
		}
		return null;
	}

	public List<TableDistributeInfo> parseSql(String sql,
			Map<Integer, Object> valueMap, ParsedSqlContext ctx)
			throws SQLException {
		if (ctx == null) {
			return null;
		}
		ctx.setSqlType(SQLType.getSqlType(sql));
		List<Table> tables = ctx.getTables();
		List<Column> columns = ctx.getColumns();
		
		Set<Object> tenants = new HashSet<Object>();
		
		if(SQLType.SHOW.equals(ctx.getSqlType())) {
			LinkedList<TableDistributeInfo> list = new LinkedList<TableDistributeInfo>();
			TableDistributeInfo info = new TableDistributeInfo();
			info.setTableName(null);
			info.setFullTableScan(-1);
			info.setFullDBScan(-1);
			info.setTablePattern(null);
			info.setDbPattern(null);
			list.add(info);
			return list;
		}
		
		if (tables.size() > 0) {
			int len = tables.size();
			Table table = null;
			LinkedList<TableDistributeInfo> list = new LinkedList<TableDistributeInfo>();
			
			if(SQLType.CREATE.equals(ctx.getSqlType()) || SQLType.ALTER.equals(ctx.getSqlType()) || SQLType.DROP.equals(ctx.getSqlType())
					 || SQLType.DESC.equals(ctx.getSqlType())) {
				table = tables.get(0);
				TableDistributeInfo info = new TableDistributeInfo();
				DistributedTableRule tableRule = tableRules.get(table
						.getTableName().toLowerCase());
				info.setTableName(table.getTableName());
				info.setFullTableScan(-1);
				info.setFullDBScan(-1);
				info.setTablePattern(tableRule.getTableNamePattern());
				info.setDbPattern(tableRule.getLogicDBPattern());
				list.add(info);
				return list;
			}
			
			
			int minTableScan = Integer.MAX_VALUE;
			TableDistributeInfo keyTable = null;
			for (int i = 0; i < len; i++) {
				table = tables.get(i);
				DistributedTableRule tableRule = tableRules.get(table
						.getTableName().toLowerCase());
				TableDistributeInfo info = calculateTableDistributeInfo(table,
						columns, valueMap, tableRule);
				list.add(info);
				if (info.getFullTableScan() != -1
						&& info.getFullTableScan() < minTableScan) {
					minTableScan = info.getFullTableScan();
					keyTable = info;
				}
				if(info.getTenants() != null) {
					tenants.addAll(info.getTenants());
				}
			}
			
			//多租户处理
			if(!this.isAllowFullTenantScan() && (tenants == null || tenants.size() != 1) && "oneUser1".equals(this.getMultiTenantMode())) {
				throw new SQLException(
						"not allowed to scan more than one tenants");
			}
			
			if (keyTable == null) {
				if (log.isTraceEnabled()) {
					log.trace(JSONArray.fromObject(list));
				}
				return list;
			}
			for (TableDistributeInfo info : list) {
				if (keyTable == info) {
					list.remove(info);
					break;
				}
			}
			for (TableDistributeInfo info : list) {
				info.setPhysicalTableMap(new HashMap<Object, String>());
				for (Object colValue : keyTable.getTableIdMap().keySet()) {
					Integer tableId = keyTable.getTableIdMap().get(colValue);
					calculatePattern(colValue, tableId, info.getTablePattern(),
							info.getPhysicalTableMap());
				}
			}
			for (Object key : keyTable.getPhysicalTableMap().keySet()) {
				keyTable.getTableColValueMap().put(
						keyTable.getPhysicalTableMap().get(key), key);
			}
			list.add(0, keyTable);
			if (log.isTraceEnabled()) {
				log.trace(JSONArray.fromObject(list));
			}
			return list;
		} else if (tables.size() == 0) {
			throw new SQLException("invalid sql: can't get table from sql:"
					+ sql);
		} else {
			throw new SQLException("can't get distribute rule from sql:" + sql);
		}
	}

	public List<Object> findColumnValues(Table table, List<Column> columns,
			Map<Integer, Object> valueMap, DistributedTableRule rule, String columnName)
			throws SQLException {
		if (columnName == null) {
			return null;
		}
		String[] cols = columnName.split(",");
		
		List<List<Object>> lst = new ArrayList<List<Object>>();
		for(String colName : cols) {
			if (table.getAlias() != null && table.getAlias().trim().length() > 0) {
				colName = table.getAlias().trim() + "." + colName;
			}
			Set<Object> valueSet = new HashSet<Object>();
			for (Column col : columns) {
				if (col == null || col.getValue() == null) {
					continue;
				}
				if (colName.equals(col.getColumnName())) {
					String colValue = col.getValue();
					if (!colValue.startsWith("'")
							&& !colValue.startsWith(QUESTION_MARK)) {
						boolean isCol = false;
						for (Column col1 : columns) {
							if (colValue.equals(col1.getColumnName())) {
								isCol = true;
								break;
							}
						}
						if (isCol) {
							continue;
						}
					}
					Object[] values = null;
					if ("in".equalsIgnoreCase(col.getOperator())) {// (1,2,3);('a','b','c');(question_mark_1,2,question_mark_2)
						String[] tempArray = colValue.split(",");
						values = new Object[tempArray.length];
						int i = 0;
						for (String tmp : tempArray) {
							if (tmp.startsWith("'")) {// 'a'
								values[i] = tmp.replaceAll("'", "");
							} else if (tmp.startsWith(QUESTION_MARK)) {// question_mark_1
								values[i] = (valueMap.get(Integer.valueOf(tmp
										.replace(QUESTION_MARK, ""))).toString());
							} else {// 1
								values[i] = tmp;
							}
							valueSet.add(values[i]);
							i++;
						}
	
					} else if ("=".equals(col.getOperator())) {
						values = new Object[1];
						if (colValue.startsWith(QUESTION_MARK)) {// question_mark_1
							values[0] = (valueMap.get(Integer.valueOf(colValue
									.replace(QUESTION_MARK, ""))).toString());
						} else if (colValue.startsWith("'")
								&& colValue.endsWith("'")) {// 'a'
							values[0] = colValue.replaceAll("'", "");
						} else {// 1
							values[0] = colValue;
						}
						valueSet.add(values[0]);
					} else {
						continue;
					}
	
				}
			}
			if(valueSet.size() == 0) {//有一个为空的情况下，就需要全表扫
				return null;
			}
			lst.add(new ArrayList<Object>(valueSet));
		}
		int size = lst.size();
		if(size == 0) {
			return null;
		}else if(size == 1){
			return lst.get(0);
		}else {
			List<Object> tmpLst = new ArrayList<Object>();
			List<Object> tmpLst1 = null;
			List<Object> tmp = null;
			for(int i=0; i<size; i++) {
				tmp = lst.get(i);//长度为0的情况在上面循环中已经被过滤
				if(tmp.size() == 0) {
					return null;
				}
				
				int size1 = tmp.size();
				for(int j=0; j<size1; j++) {
					if(tmpLst.size() == 0) {
						tmpLst.add(tmp.get(j).toString());
					}else {
						tmpLst1 = new ArrayList<Object>();
						for(Object val : tmpLst) {
							tmpLst1.add(val + "," + tmp.get(j));
						}
						tmpLst = tmpLst1;
					}
				}
			}
			return tmpLst;
		}

	}

	/**
	 * 计算某个表的分库分表信息
	 * 
	 * @param table
	 *            需要计算的表
	 * @param columns
	 *            SQL中解析出来的所有列值
	 * @param valueMap
	 *            SQL语句中“？”对应的值列表，可能为空
	 * @param rule
	 *            分库规则
	 * @return 分库分表信息
	 * @throws SQLException
	 */
	public TableDistributeInfo calculateTableDistributeInfo(Table table,
			List<Column> columns, Map<Integer, Object> valueMap,
			DistributedTableRule rule) throws SQLException {
		
		// 不允许同时访问多租户数据时
		Set<Object> tenants = null;
		if (!this.isAllowFullTenantScan()
				&& "oneUser1".equals(this.getMultiTenantMode())) {
			String tenantColumn = rule.getTenantColumn();

			if (tenantColumn != null && tenantColumn.trim().length() > 0) {
				List<Object> tenantValues = findColumnValues(table, columns,
						valueMap, rule, tenantColumn);
				if (tenantValues != null && tenantValues.size() > 0) {
					tenants = new HashSet<Object>();
					tenants.addAll(tenantValues);
				}
			}
		}
		
		String key = rule.getDistributeKey();
		if (key == null || key.trim().length() == 0) {
			throw new SQLException(
					"invalid distribute rule：distributeKey is null");
		}
		List<Object> keyValues = findColumnValues(table, columns, valueMap, rule, key);
				
		if (keyValues != null && keyValues.size() > 0) {
			TableDistributeInfo info = calculateTableDistributeIds(rule,
					keyValues.toArray());
			if (info != null) {
				info.setTableName(table.getTableName());
				HashSet<Integer> set = new HashSet<Integer>();
				set.addAll(info.getTableIdMap().values());
				if (!rule.isAllowFullTableScan() && set.size() > 1) {
					throw new SQLException(
							"not allowed to scan more than one sub table");
				}
				
				if(tenants != null) {
					info.setTenants(tenants);
				}
				
				info.setFullTableScan(set.size());
				set = new HashSet<Integer>();
				set.addAll(info.getDbIdMap().values());
				info.setFullDBScan(set.size());
				
				return info;
			}
		}
		if (!rule.isAllowFullTableScan()) {
			throw new SQLException(
					"not allowed to scan more than one sub table");
		}
		TableDistributeInfo info = new TableDistributeInfo();
		
		
		if(tenants != null) {
			info.setTenants(tenants);
		}
		
		info.setTableName(table.getTableName());
		info.setFullTableScan(-1);
		info.setFullDBScan(-1);
		info.setTablePattern(rule.getTableNamePattern());
		info.setDbPattern(rule.getLogicDBPattern());
		return info;
	}

	/**
	 * 计算分库分表信息
	 * 
	 * @param rule
	 *            表的分库分表规则
	 * @param colValues
	 *            表的分库分表字段的值，可能是多值
	 * @return 分库分表信息
	 */
	public TableDistributeInfo calculateTableDistributeIds(
			DistributedTableRule rule, Object... colValues) throws SQLException {
		if (colValues == null || colValues.length == 0) {
			return null;
		}
		JSONObject dbRule = JSONObject.fromObject(rule.getLogicDBRule());
		JSONObject tableRule = JSONObject.fromObject(rule.getTableNameRule());
		TableDistributeInfo ret = new TableDistributeInfo();
		ret.setTablePattern(rule.getTableNamePattern());
		ret.setDbPattern(rule.getLogicDBPattern());
		for (Object colValue : colValues) {
			Integer dbId = calculateDistributeId(dbRule, colValue, this.getMappingRules());
			if (dbId == null) {
				throw new SQLException("calculate db id failed");
			}
			ret.getDbIdMap().put(colValue, dbId);
			calculatePattern(colValue, dbId, rule.getLogicDBPattern(),
					ret.getLogicDbMap());

			Integer tableId = calculateDistributeId(tableRule, colValue, this.getMappingRules());
			if (tableId == null) {
				throw new SQLException("calculate table id failed");
			}
			ret.getTableIdMap().put(colValue, tableId);
			calculatePattern(colValue, tableId, rule.getTableNamePattern(),
					ret.getPhysicalTableMap());
		}
		return ret;
	}
	
	/**
	 * 根据表名，分库字段值计算分表id
	 * @param tableName 表名
	 * @param keyValues 分库字段值
	 * @return 分表id
	 */
	public Integer calculateDistributeId(String tableName, Object key) {
		if(key == null) {
			return null;
		}
		DistributedTableRule tableRule = tableRules.get(tableName.toLowerCase());
		try {
			Integer tableId = calculateDistributeId(JSONObject.fromObject(tableRule.getTableNameRule()), key, this.getMappingRules());
			return tableId;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据计算逻辑分库名和物理表名，将计算出来的结果放到HashMap中
	 * 
	 * @param colValue
	 *            分库字段值
	 * @param id
	 *            分库或分表ID
	 * @param pattern
	 *            分库或分表样式，如cust{_00}
	 * @param map
	 *            返回结果map
	 * @throws SQLException
	 */
	public static void calculatePattern(Object colValue, Integer id,
			String pattern, HashMap<Object, String> map) throws SQLException {
		String replace = calculatePattern(id, pattern);
		map.put(colValue, replace);
	}

	/**
	 * 根据计算逻辑分库名和物理表名，将计算出来的结果放到HashMap中
	 * 
	 * @param colValue
	 *            分库字段值
	 * @param id
	 *            分库或分表ID
	 * @param pattern
	 *            分库或分表样式，如cust{_00}
	 * @param map
	 *            返回结果map
	 * @throws SQLException
	 */
	public static String calculatePattern(Integer id, String pattern)
			throws SQLException {
		String replace = null;
		if (pattern.indexOf("{") >= 0) {
			try {
				replace = pattern.substring(pattern.indexOf("{") + 1,
						pattern.indexOf("}"));
			} catch (Exception e) {
				log.error(e.getMessage(),e);
				throw new SQLException("invalid db pattern");
			}
		}
		if (replace == null) {
			return pattern;
		} else {
			String originalName = pattern.substring(0, pattern.indexOf("{"));// "cust"
			String prefix = "";
			if (replace.indexOf("0") != 0) {
				prefix = replace.substring(0, replace.indexOf("0"));// 中间的"_"
				replace = replace.substring(replace.indexOf("0"));// "00"
			}
			String idStr = String.valueOf(id);
			if (idStr.length() > replace.length()) {
				throw new SQLException("invalid db pattern");
			} else {
				replace = originalName
						+ prefix
						+ replace.substring(0,
								replace.length() - idStr.length()) + idStr;
			}
			return replace;
		}
	}

	/**
	 * 根据分库和分表规则计算分库或分表ID
	 * 
	 * @param json
	 *            分库或分表规则，如： {keyValue:{keyColumn:'cust_id',
	 *            tranferType:'java.lang.Long', operator:'%',operatorValue:4},
	 *            operator:'+',operatorValue:1}
	 * @param colValue
	 *            分库分表字段值
	 * @return 分库或分表ID 
	 */
	public static Integer calculateDistributeId(JSONObject json, Object colValue, HashMap<String, Map<Object, Integer>> mappingRules)
			throws SQLException {
		if (json.containsKey("keyColumn")) {
			String tranferType = json.getString("tranferType");
			Object value = null;
			try {
				if("java.lang.String".equals(tranferType)) {
					value = colValue.toString();
				}else {
					value =  Class.forName(tranferType)
							.getMethod("valueOf", colValue.toString().getClass())
							.invoke(null, colValue.toString());
				}
			} catch (Exception e) {
				log.error(e.getMessage(),e);
				throw new SQLException("tranfer column Value to type "
						+ tranferType + " failed", e);
			}
			return calculateFormula(value, json.getString("operator"),
					json.get("operatorValue"), mappingRules);
		} else {
			JSONObject keyValue = json.getJSONObject("keyValue");
			Integer value = calculateDistributeId(keyValue, colValue, mappingRules);// 递归处理嵌套
			return calculateFormula(value, json.getString("operator"),
					json.get("operatorValue"), mappingRules);
		}
	}

	/**
	 * 计算公式的结果值
	 * 
	 * @param left
	 *            左值
	 * @param operator
	 *            操作符
	 * @param rigth
	 *            右值
	 * @return
	 */
	private static Integer calculateFormula(Object leftValue, String operator,
			Object rightValue, HashMap<String, Map<Object, Integer>> mappingRules) {
		if("Mapping".equals(operator)) {
			if(mappingRules == null) {
				return null;
			}
			return mappingRules.get(rightValue).get(leftValue);
		}else {
			long left = -1;
			if(leftValue instanceof Integer) {
				left =  (Integer) leftValue;
			}else {
				left =  (Long) leftValue;
			}
			int right = (Integer) rightValue;
			if ("%".equals(operator)) {
				return (int) (left % right);
			} else if ("/".equals(operator)) {
				return (int) (left / right);
			} else if ("+".equals(operator)) {
				return (int) (left + right);
			} else if ("-".equals(operator)) {
				return (int) (left - right);
			} else {
				return null;
			}
		}
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public HashMap<String, DistributedTableRule> getTableRules() {
		return tableRules;
	}

	public void setTableRules(HashMap<String, DistributedTableRule> tableRules) {
		this.tableRules = tableRules;
	}

	public RemoteCacheSVC getCacheSvc() {
		return cacheSvc;
	}

	public void setCacheSvc(RemoteCacheSVC cacheSvc) {
		this.cacheSvc = cacheSvc;
	}

	public static HashMap<String, ParsedSqlContext> getSqlCache() {
		return sqlCache;
	}

	public static void setSqlCache(HashMap<String, ParsedSqlContext> sqlCache) {
		DistributedDBRule.sqlCache = sqlCache;
	}

	public String getMultiTenantMode() {
		return multiTenantMode;
	}

	public void setMultiTenantMode(String multiTenantMode) {
		this.multiTenantMode = multiTenantMode;
	}

	public boolean isAllowFullTenantScan() {
		return allowFullTenantScan;
	}

	public void setAllowFullTenantScan(boolean allowFullTenantScan) {
		this.allowFullTenantScan = allowFullTenantScan;
	}

	public HashMap<String, Map<Object, Integer>> getMappingRules() {
		return mappingRules;
	}

	public void setMappingRules(HashMap<String, Map<Object, Integer>> mappingRules) {
		this.mappingRules = mappingRules;
	}

	public static void main(String[] args) {
		// ApplicationContext ctx = new ClassPathXmlApplicationContext(new
		// String[] { "distributedRule.xml" });
		// DistributedDBRule dbRule = (DistributedDBRule)ctx.getBean("dbRule");
		// String sql = "select * from cust a where a.cust_id = ?";
		// List<Object> valueArray = new ArrayList<Object>();
		// valueArray.add(0);
		// valueArray.add(1,7L);
		// System.out.println(dbRule.getLogicDBAndTableName(sql, valueArray));
	}
}
