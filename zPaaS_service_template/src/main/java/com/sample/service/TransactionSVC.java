package com.sample.service;

import com.sample.po.Transaction;

public interface TransactionSVC {
	public String createTransaction(Transaction tx) throws Exception;
	public int updateTransaction(Transaction tx) throws Exception;
	public Transaction queryTransaction(String txName) throws Exception;
}
