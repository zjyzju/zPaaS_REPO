package com.sample.dao.impl;


import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.sample.dao.TransactionDAO;
import com.sample.po.Transaction;
import com.zpaas.db.sequence.Sequence;

public class TransactionDAOImpl extends SqlMapClientDaoSupport implements
		TransactionDAO {
	
	private Sequence seq = null;

	public Sequence getSeq() {
		return seq;
	}

	public void setSeq(Sequence seq) {
		this.seq = seq;
	}

	@Override
	public Transaction getTransactionById(String name) {
		return (Transaction)this.getSqlMapClientTemplate().queryForObject("transaction.queryById", name);
	}
	
	@Override
	public String insert(Transaction record) {
		record.setName(record.getName() + seq.nextValue());
		this.getSqlMapClientTemplate().insert("transaction.insert", record);
		return record.getName();
	}
	
	@Override
	public int update(Transaction record) {
		return this.getSqlMapClientTemplate().update("transaction.update", record);
	}
}