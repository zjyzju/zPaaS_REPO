package com.zpaas.dtx.server;

import com.zpaas.message.MessageStatus;


public interface  TransactionProcessor<T> {
	public void processTransaction(T context, MessageStatus status);
}
