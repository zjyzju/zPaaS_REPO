package com.zpaas.db.base;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现Connection接口的基类
 * @author zjy
 * @date 2014年6月23日 上午9:52:49 
 * @version V1.0
 */
public abstract class ConnectionBase implements Connection {
	public static final Logger log = LoggerFactory.getLogger(ConnectionBase.class);
	
	protected boolean closed = false;
	private boolean autoCommit = true;
	private boolean readOnly = false;
	private int transactionIsolation = -1;
	private Connection wrappedConnection = null;
	
	
	public ConnectionBase() {
		
	}
	
	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		this.autoCommit = autoCommit;
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		return this.autoCommit;
	}
	
	

	@Override
	public boolean isClosed() throws SQLException {
		return closed;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		if(this.getWrappedConnection() != null) {
			return this.getWrappedConnection().getMetaData();
		}else {
			throw new SQLException("wrapped connecion not found");
		}
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		this.readOnly = readOnly;
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		return this.readOnly;
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public String getCatalog() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		this.transactionIsolation = level;
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		return this.transactionIsolation;
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
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		throw new SQLException("unsupport operation");
	}
	
	@Override
	public Clob createClob() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Blob createBlob() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public NClob createNClob() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void setClientInfo(String name, String value)
			throws SQLClientInfoException {
		throw new SQLClientInfoException();
	}

	@Override
	public void setClientInfo(Properties properties)
			throws SQLClientInfoException {
		throw new SQLClientInfoException();
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException {
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
	
	@Override
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public int getHoldability() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	public Connection getWrappedConnection() {
		return wrappedConnection;
	}

	public void setWrappedConnection(Connection wrappedConnection) {
		this.wrappedConnection = wrappedConnection;
	}
	
	public void setSchema(String schema) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	public String getSchema() throws SQLException {
		throw new SQLException("unsupport operation");
	}

	public void abort(Executor executor) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		throw new SQLException("unsupport operation");
	}

	public int getNetworkTimeout() throws SQLException {
		throw new SQLException("unsupport operation");
	}
}
