package com.sample.service.impl;

import com.sample.dao.TransactionDAO;
import com.sample.po.Transaction;
import com.sample.service.TransactionSVC;

public class TransactionSVCImpl implements TransactionSVC {
	private TransactionDAO dao = null;
	
	public TransactionDAO getDao() {
		return dao;
	}

	public void setDao(TransactionDAO dao) {
		this.dao = dao;
	}

	@Override
	public String createTransaction(Transaction tx) throws Exception{
		String txName = dao.insert(tx);
		return txName;
	}
	
	@Override
	public Transaction queryTransaction(String txName) throws Exception {
		return dao.getTransactionById(txName);
	}
	
	@Override
	public int updateTransaction(Transaction tx) throws Exception {
		return dao.update(tx);
	}
}
