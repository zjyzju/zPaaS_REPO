package com.sample.dao;

import com.sample.po.Transaction;

public interface TransactionDAO {

	public Transaction getTransactionById(String name);
	public String insert(Transaction record);
	public int update(Transaction record);

}