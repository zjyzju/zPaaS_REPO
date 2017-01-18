package com.distribute.tx.test;

import net.sf.json.JSONObject;

import com.distribute.tx.test.dao.CustDAO;
import com.distribute.tx.test.vo.Cust;
import com.zpaas.dtx.assured.AssuredTransactionParticipant;
import com.zpaas.dtx.common.TransactionStatus;

public class AssuredTransactionMain implements AssuredTransactionParticipant {

	private CustDAO custDao;

	public CustDAO getCustDao() {
		return custDao;
	}

	public void setCustDao(CustDAO custDao) {
		this.custDao = custDao;
	}

	@Override
	public Object participantTransaction(JSONObject transactionContext, TransactionStatus status) {
		if(!mainTransaction(transactionContext)) {
			status.setRollbackOnly();
		}
		return null;
	}

	public boolean mainTransaction(final JSONObject ctx) {
		Cust cust = (Cust) JSONObject.toBean(ctx, Cust.class);
		return custDao.insert(cust);
	}

	
}
