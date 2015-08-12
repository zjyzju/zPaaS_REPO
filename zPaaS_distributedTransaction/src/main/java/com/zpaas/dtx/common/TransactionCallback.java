package com.zpaas.dtx.common;



public interface TransactionCallback {
	
	public Object doInTransaction(TransactionStatus status);

}
