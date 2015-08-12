package com.distribute.tx.test;

import net.sf.json.JSONObject;

import com.distribute.tx.test.dao.CustDAO;
import com.distribute.tx.test.vo.Cust;
import com.zpaas.dtx.common.TransactionChecker;
import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.common.TransactionStatus;


public class TransactionCheckSample implements TransactionChecker{
	private CustDAO custDao = null;
	
	public CustDAO getCustDao() {
		return custDao;
	}

	public void setCustDao(CustDAO custDao) {
		this.custDao = custDao;
	}

	public void checkTransaction(TransactionContext message, TransactionStatus status) {
		System.out.println("check transaction:" + message.getTransactionId());
		Cust cust = (Cust)JSONObject.toBean(JSONObject.fromObject(message.getContent()), Cust.class);
		Cust queryCust = custDao.queryById(cust.getCustId());
		if(queryCust == null || queryCust.getCustId() == null){
			status.setRollbackOnly();
			System.out.println("status.setRollbackOnly()");
		}else {
			System.out.println("commit");
		}
	}
	


	
}
