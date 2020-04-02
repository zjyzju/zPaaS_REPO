package com.zpaas.dtx.server.dao.impl;


import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.zpaas.dtx.common.Transaction;
import com.zpaas.dtx.server.dao.TransactionDAO;

public class TransactionDAOImpl extends SqlMapClientDaoSupport implements
		TransactionDAO {

	@Override
	public Transaction getTransactionById(String name) {
		return (Transaction)this.getSqlMapClientTemplate().queryForObject("transaction.queryById", name);
	}
	
	@Override
	public boolean insert(Transaction record) {
		this.getSqlMapClientTemplate().insert("transaction.insert", record);
		return true;
	}
	
	@Override
	public int update(Transaction record) {
		return this.getSqlMapClientTemplate().update("transaction.update", record);
	}
}