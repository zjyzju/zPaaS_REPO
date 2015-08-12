package com.zpaas.db.base;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.zpaas.db.sql.ParsedSqlContext;

/**
 * 实现ResultSet接口的基类
 * @author zjy
 * @date 2014年6月23日 上午9:53:22 
 * @version V1.0
 */
public abstract class ResultSetBase implements ResultSet {
	
	protected ResultSetMetaData metaData = null;
	protected Statement statement;
	protected int first = 0;
	protected int last = -1;
	protected int current = -1;
	protected int size = 0;
	
	private boolean closed = false;
	private ParsedSqlContext ctx = null;
	private Object lastColumnValue = null;
	
	private String dbType;
	
	private LinkedList<HashMap<String, Object>> resultSet = new LinkedList<HashMap<String, Object>>();
	private LinkedList<ResultSet> sets = new LinkedList<ResultSet>();
	HashMap<String, HashMap<String, Object>> groupMerge = new HashMap<String, HashMap<String,Object>>();
	
	public void mergeResultSet(ResultSet rs)  throws SQLException {
		if(this.isClosed()) {
			return ;
		}
		if(metaData == null) {
			metaData = rs.getMetaData();
		}
		sets.add(rs);
		HashMap<String, Object> row = null;
		int count = metaData.getColumnCount();
		boolean groupSql = false;
		boolean hasSetFunc = false;
		List<String> groupElements = null;
		if(ctx != null) {
			groupSql = ctx.isGroupBySql();
			groupElements = ctx.getGroupElements();
			if(ctx.getFuncTypes() != null && ctx.getFuncTypes().size() > 0 && 
					(ctx.getFuncTypes().contains("count") || ctx.getFuncTypes().contains("avg") 
					|| ctx.getFuncTypes().contains("max")
					|| ctx.getFuncTypes().contains("min") || ctx.getFuncTypes().contains("sum"))) {
				hasSetFunc = true;
			}
		}
		
		if (hasSetFunc && count == 1) {
			last = 0;
			size = 1;
			long value = 0;
			if(resultSet != null && resultSet.size() > 0) {
				row = resultSet.get(0);
			}else {
				row = new HashMap<String, Object>();
				resultSet.add(row);
			}
			String funcKey = null;
			while (rs != null && rs.next()) {
				value = rs.getLong(1);
				funcKey = metaData.getColumnLabel(1);
			}
			if(funcKey == null) {
				return;
			}
			if(funcKey.startsWith("count") || funcKey.startsWith("sum") ||funcKey.startsWith("COUNT") || funcKey.startsWith("SUM")) {
				if(row.get(funcKey) != null) {
					row.put(funcKey, value + (Long)row.get(funcKey));
				}else {
					row.put(funcKey, value);
				}				
			}else if(funcKey.startsWith("max") || funcKey.startsWith("MAX")) {
				if(row.get(funcKey) != null) {
					Long max = (Long)row.get(funcKey);
					max = (value > max) ?value:max;
					row.put(funcKey, max);
				}else {
					row.put(funcKey, value);
				}
			}else if(funcKey.startsWith("min") || funcKey.startsWith("MIN")) {
				if(row.get(funcKey) != null) {
					Long min = (Long)row.get(funcKey);
					min = (value < min) ?value:min;
					row.put(funcKey, min);
				}else {
					row.put(funcKey, value);
				}
			}
		}else if(hasSetFunc && groupSql && groupElements != null) {
			while (rs != null && rs.next()) {
				long rowValue = 0;
				HashMap<String, Long> rowValueMap = new HashMap<String, Long>();
				String rowKey = null;
				String key = "";
				row = new HashMap<String, Object>();
				for (int i = 1; i <= count; i++) {
					String label = metaData.getColumnLabel(i);
					String name = metaData.getColumnName(i);
					if (name.startsWith("count") || name.startsWith("avg") || name.startsWith("max")
							|| name.startsWith("min") || name.startsWith("sum") ||
							name.startsWith("COUNT") || name.startsWith("AVG") || name.startsWith("MAX")
							|| name.startsWith("MIN") || name.startsWith("SUM")) {
						rowValue = rs.getLong(i);
						rowKey = label;
						row.put(rowKey, rowValue);
						rowValueMap.put(rowKey, rowValue);
					}else {
						key += label + ":" + rs.getObject(label) + ",";
						row.put(label, rs.getObject(label));
					}
					
				}
				
				if(groupMerge.containsKey(key)) {
					for(String funcKey : rowValueMap.keySet()) {
						if(funcKey.startsWith("count") || funcKey.startsWith("sum") ||funcKey.startsWith("COUNT") || funcKey.startsWith("SUM")) {
							groupMerge.get(key).put(funcKey, 
									((Long)groupMerge.get(key).get(funcKey))+(Long)rowValueMap.get(funcKey));
						}else if(funcKey.startsWith("max") || funcKey.startsWith("MAX")) {
							long max = (Long)groupMerge.get(key).get(funcKey);
							long tmp = (Long)rowValueMap.get(funcKey);
							if(max < tmp) {
								max = tmp;
							}
							groupMerge.get(key).put(funcKey, max);
						}else if(funcKey.startsWith("min") || funcKey.startsWith("MIN")) {
							long min = (Long)groupMerge.get(key).get(funcKey);
							long tmp = (Long)rowValueMap.get(funcKey);
							if(min > tmp) {
								min = tmp;
							}
							groupMerge.get(key).put(funcKey, min);
						}
					}
					
				}else {
					groupMerge.put(key, row);
				}
			}			
			if(groupMerge.size() > 0) {
				size = groupMerge.size();
				last = size-1;
				resultSet.clear();
				resultSet.addAll(groupMerge.values());
			}
		}else {
			while (rs != null && rs.next()) {
				row = new HashMap<String, Object>();
				for (int i = 1; i <= count; i++) {
					String label = metaData.getColumnLabel(i);
					row.put(label, rs.getObject(label));
				}
				resultSet.add(row);
				last++;
				size++;
			}
		}
		
	}
	
	public ParsedSqlContext getCtx() {
		return ctx;
	}

	public void setCtx(ParsedSqlContext ctx) {
		this.ctx = ctx;
	}
	
	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		if(current < first || current > last) {
			throw new SQLException("invalid row");
		}
		String colName = metaData.getColumnLabel(columnIndex);
		lastColumnValue = resultSet.get(current).get(colName);
		return type.cast(lastColumnValue);
	}

	public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
		if(current < first || current > last) {
			throw new SQLException("invalid row");
		}
		if("ORACLE".equals(this.getDbType())) {
			lastColumnValue = resultSet.get(current).get(columnLabel.toUpperCase());
		}else {
			lastColumnValue = resultSet.get(current).get(columnLabel.toLowerCase());
		}
		
		return type.cast(lastColumnValue);
	}

	@Override
	public Object getObject(int columnIndex) throws SQLException {
		if(current < first || current > last) {
			throw new SQLException("invalid row");
		}
		String colName = metaData.getColumnLabel(columnIndex);
		lastColumnValue = resultSet.get(current).get(colName);
		return lastColumnValue;
	}
	
	@Override
	public Object getObject(String columnLabel) throws SQLException {
		if(current < first || current > last) {
			throw new SQLException("invalid row");
		}
		lastColumnValue = resultSet.get(current).get(columnLabel.toLowerCase());
		return lastColumnValue;
	}

	@Override
	public String getString(int columnIndex) throws SQLException {
		Object obj = this.getObject(columnIndex);
		if(obj == null) {
			return null;
		}else {
			return obj.toString();
		}
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException {
		this.getObject(columnIndex);
		if(lastColumnValue == null) {
			return false;
		}
		return (Boolean)lastColumnValue;
	}

	@Override
	public byte getByte(int columnIndex) throws SQLException {
		this.getObject(columnIndex);
		if(lastColumnValue == null) {
			return 0;
		}
		return (Byte)lastColumnValue;
	}

	@Override
	public short getShort(int columnIndex) throws SQLException {
		this.getObject(columnIndex);
		if(lastColumnValue == null) {
			return 0;
		}
		return (Short)lastColumnValue;
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {
		this.getObject(columnIndex);
		if(lastColumnValue == null) {
			return 0;
		}
		return (Integer)lastColumnValue;
	}

	@Override
	public long getLong(int columnIndex) throws SQLException {
		this.getObject(columnIndex);
		if(lastColumnValue == null) {
			return 0;
		}
		return (Long)lastColumnValue;
	}

	@Override
	public float getFloat(int columnIndex) throws SQLException {
		this.getObject(columnIndex);
		if(lastColumnValue == null) {
			return 0.0F;
		}
		return (Float)lastColumnValue;
	}

	@Override
	public double getDouble(int columnIndex) throws SQLException {
		this.getObject(columnIndex);
		if(lastColumnValue == null) {
			return 0.0;
		}
		return (Double)lastColumnValue;
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
		return (BigDecimal)this.getObject(columnIndex);
	}

	@Override
	public byte[] getBytes(int columnIndex) throws SQLException {
		return (byte[])this.getObject(columnIndex);
	}

	@Override
	public Date getDate(int columnIndex) throws SQLException {
		return (Date)this.getObject(columnIndex);
	}

	@Override
	public Time getTime(int columnIndex) throws SQLException {
		return (Time)this.getObject(columnIndex);
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) throws SQLException {
		return (Timestamp)this.getObject(columnIndex);
	}
	
	@Override
	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		return (BigDecimal)this.getObject(columnIndex);
	}
	
	@Override
	public Blob getBlob(int columnIndex) throws SQLException {
		return (Blob)this.getObject(columnIndex);
	}

	@Override
	public Clob getClob(int columnIndex) throws SQLException {
		return (Clob)this.getObject(columnIndex);
	}

	@Override
	public Array getArray(int columnIndex) throws SQLException {
		return (Array)this.getObject(columnIndex);
	}
	
	@Override
	public NClob getNClob(int columnIndex) throws SQLException {
		return (NClob)this.getObject(columnIndex);
	}
	
	@Override
	public String getNString(int columnIndex) throws SQLException {
		return (String)this.getObject(columnIndex);
	}

	@Override
	public String getString(String columnLabel) throws SQLException {
		Object obj = this.getObject(columnLabel);
		if(obj == null) {
			return null;
		}else {
			return obj.toString();
		}
	}

	@Override
	public boolean getBoolean(String columnLabel) throws SQLException {
		this.getObject(columnLabel);
		if(lastColumnValue == null) {
			return false;
		}
		return (Boolean)lastColumnValue;
	}

	@Override
	public byte getByte(String columnLabel) throws SQLException {
		this.getObject(columnLabel);
		if(lastColumnValue == null) {
			return 0;
		}
		return (Byte)lastColumnValue;
	}

	@Override
	public short getShort(String columnLabel) throws SQLException {
		this.getObject(columnLabel);
		if(lastColumnValue == null) {
			return 0;
		}
		return (Short)lastColumnValue;
	}

	@Override
	public int getInt(String columnLabel) throws SQLException {
		this.getObject(columnLabel);
		if(lastColumnValue == null) {
			return 0;
		}
		return (Integer)lastColumnValue;
	}

	@Override
	public long getLong(String columnLabel) throws SQLException {
		this.getObject(columnLabel);
		if(lastColumnValue == null) {
			return 0;
		}
		return (Long)lastColumnValue;
	}

	@Override
	public float getFloat(String columnLabel) throws SQLException {
		this.getObject(columnLabel);
		if(lastColumnValue == null) {
			return 0.0F;
		}
		return (Float)lastColumnValue;
	}

	@Override
	public double getDouble(String columnLabel) throws SQLException {
		this.getObject(columnLabel);
		if(lastColumnValue == null) {
			return 0.0;
		}
		return (Double)lastColumnValue;
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
		return (BigDecimal)this.getObject(columnLabel);
	}

	@Override
	public byte[] getBytes(String columnLabel) throws SQLException {
		return (byte[])this.getObject(columnLabel);
	}

	@Override
	public Date getDate(String columnLabel) throws SQLException {
		return (Date)this.getObject(columnLabel);
	}

	@Override
	public Time getTime(String columnLabel) throws SQLException {
		return (Time)this.getObject(columnLabel);
	}

	@Override
	public Timestamp getTimestamp(String columnLabel) throws SQLException {
		return (Timestamp)this.getObject(columnLabel);
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
		return (BigDecimal)this.getObject(columnLabel);
	}

	@Override
	public Blob getBlob(String columnLabel) throws SQLException {
		return (Blob)this.getObject(columnLabel);
	}

	@Override
	public Clob getClob(String columnLabel) throws SQLException {
		return (Clob)this.getObject(columnLabel);
	}

	@Override
	public Array getArray(String columnLabel) throws SQLException {
		return (Array)this.getObject(columnLabel);
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException {
		return (NClob)this.getObject(columnLabel);
	}

	@Override
	public String getNString(String columnLabel) throws SQLException {
		return (String)this.getObject(columnLabel);
	}
	
	@Override
	public boolean isBeforeFirst() throws SQLException {
		if(current == -1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isAfterLast() throws SQLException {
		if(current == last+1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isFirst() throws SQLException {
		if(current == 0 && size > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isLast() throws SQLException {
		if(current == last && size > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void beforeFirst() throws SQLException {
		current = -1;
	}

	@Override
	public void afterLast() throws SQLException {
		current = last + 1;
	}

	@Override
	public boolean first() throws SQLException {
		current = 0;
		if(size > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean last() throws SQLException {
		current = last;
		if(size > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int getRow() throws SQLException {
		return current+1;
	}

	@Override
	public boolean absolute(int row) throws SQLException {
		if(row - 1 < first) {
			current = -1;
			return false;
		}else if(row -1 > last) {
			current = last + 1;
			return false;
		}else {
			current = row-1;
		}
		return true;
	}

	@Override
	public boolean previous() throws SQLException {
		if(current - 1 < first) {
			current = -1;
			return false;
		}else {
			current--;
			return true;
		}
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public int getFetchSize() throws SQLException {
		return size;
	}
	
	@Override
	public int findColumn(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}
	
	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return metaData;
	}
	
	@Override
	public boolean next() throws SQLException {
		if(current + 1 > last) {
			current = last + 1;
			return false;
		}else {
			current++;
			return true;
		}
	}

	@Override
	public void close() throws SQLException {
		if(closed) {
			return;
		}
		for(ResultSet rs : sets) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		closed = true;
	}

	@Override
	public boolean wasNull() throws SQLException {
		if(lastColumnValue == null) {
			return true;
		}else {
			return false;
		}
	}
	
	
	@Override
	public Ref getRef(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}
	
	@Override
	public Ref getRef(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}
	
	@Override
	public URL getURL(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public URL getURL(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}
	
	@Override
	public Reader getCharacterStream(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Reader getCharacterStream(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}
	
	@Override
	public InputStream getAsciiStream(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public InputStream getUnicodeStream(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public InputStream getBinaryStream(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public InputStream getAsciiStream(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public InputStream getUnicodeStream(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public InputStream getBinaryStream(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void clearWarnings() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public String getCursorName() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public boolean relative(int rows) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public int getFetchDirection() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public int getType() throws SQLException {
		return ResultSet.TYPE_SCROLL_INSENSITIVE;
	}

	@Override
	public int getConcurrency() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public boolean rowUpdated() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public boolean rowInserted() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public boolean rowDeleted() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNull(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBoolean(int columnIndex, boolean x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateByte(int columnIndex, byte x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateShort(int columnIndex, short x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateInt(int columnIndex, int x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateLong(int columnIndex, long x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateFloat(int columnIndex, float x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateDouble(int columnIndex, double x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateString(int columnIndex, String x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateDate(int columnIndex, Date x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateTime(int columnIndex, Time x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateObject(int columnIndex, Object x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNull(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBoolean(String columnLabel, boolean x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateByte(String columnLabel, byte x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateShort(String columnLabel, short x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateInt(String columnLabel, int x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateLong(String columnLabel, long x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateFloat(String columnLabel, float x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateDouble(String columnLabel, double x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateString(String columnLabel, String x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBytes(String columnLabel, byte[] x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateDate(String columnLabel, Date x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateTime(String columnLabel, Time x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateObject(String columnLabel, Object x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void insertRow() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateRow() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void deleteRow() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void refreshRow() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void cancelRowUpdates() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void moveToInsertRow() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void moveToCurrentRow() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Statement getStatement() throws SQLException {
		return this.statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	@Override
	public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Date getDate(String columnLabel, Calendar cal) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Time getTime(int columnIndex, Calendar cal) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Time getTime(String columnLabel, Calendar cal) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateRef(int columnIndex, Ref x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateRef(String columnLabel, Ref x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBlob(String columnLabel, Blob x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateClob(int columnIndex, Clob x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateClob(String columnLabel, Clob x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateArray(int columnIndex, Array x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateArray(String columnLabel, Array x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public RowId getRowId(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public int getHoldability() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public boolean isClosed() throws SQLException {
		return closed;
	}

	@Override
	public void updateNString(int columnIndex, String nString) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNString(String columnLabel, String nString) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Reader getNCharacterStream(String columnLabel) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateClob(String columnLabel, Reader reader) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader) throws SQLException {
		throw new SQLException("unsupport operation");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		try {
			return (T) this;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		if(super.getClass().isAssignableFrom(iface)) {
			return true;
		}
		return false;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
}
