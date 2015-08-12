package com.zpaas.dtx.server.dao.impl;

import java.util.List;







import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.server.dao.TransactionContextDAO;

public class TransactionContextDAOImpl extends SqlMapClientDaoSupport implements
		TransactionContextDAO {

	@Override
	public TransactionContext getTransactionContextById(Long transactionId) {
		return (TransactionContext)this.getSqlMapClientTemplate().queryForObject("transaction_context.queryById", transactionId);
	}
	
	@Override
	public boolean insert(TransactionContext record) {
		this.getSqlMapClientTemplate().insert("transaction_context.insert", record);
		return true;
	}
	
	@Override
	public int update(TransactionContext record) {
		return this.getSqlMapClientTemplate().update("transaction_context.update", record);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionContext> queryAbnormalTransaction(long interval) {
		return (List<TransactionContext>)this.getSqlMapClientTemplate().
				queryForList("transaction_context.queryAbnormalTransaction",interval);
	}
}