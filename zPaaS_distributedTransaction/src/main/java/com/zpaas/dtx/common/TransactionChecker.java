package com.zpaas.dtx.common;



public interface TransactionChecker {
	public void checkTransaction(TransactionContext message, TransactionStatus status);
}
