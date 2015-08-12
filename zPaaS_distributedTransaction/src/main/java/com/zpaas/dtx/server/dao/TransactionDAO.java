package com.zpaas.dtx.server.dao;

import com.zpaas.dtx.common.Transaction;

public interface TransactionDAO {

	public Transaction getTransactionById(String name);
	public boolean insert(Transaction record);
	public int update(Transaction record);

}