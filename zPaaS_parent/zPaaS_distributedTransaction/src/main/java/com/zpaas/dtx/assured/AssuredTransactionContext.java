package com.zpaas.dtx.assured;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class AssuredTransactionContext  implements Serializable{
	
	private static final long serialVersionUID = 1175502777545743731L;
	
	private String subTransactionName;
	private JSONObject transactionContext;
	public String getSubTransactionName() {
		return subTransactionName;
	}
	public void setSubTransactionName(String subTransactionName) {
		this.subTransactionName = subTransactionName;
	}
	public JSONObject getTransactionContext() {
		return transactionContext;
	}
	public void setTransactionContext(JSONObject transactionContext) {
		this.transactionContext = transactionContext;
	}
	
}
