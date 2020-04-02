package com.zpaas.dtx.assured;

import net.sf.json.JSONObject;

import com.zpaas.dtx.common.TransactionStatus;

public interface AssuredTransactionParticipant {
	
	public Object participantTransaction(JSONObject transactionContext, TransactionStatus status);
}
