package com.distribute.tx.test;

import net.sf.json.JSONObject;

import com.distribute.tx.test.dao.UserDAO;
import com.distribute.tx.test.vo.Cust;
import com.distribute.tx.test.vo.User;
import com.zpaas.db.sequence.Sequence;
import com.zpaas.dtx.assured.AssuredTransactionParticipant;
import com.zpaas.dtx.common.TransactionStatus;

public class AssuredTransactionSub1 implements AssuredTransactionParticipant {
	
	private Sequence userSeq = null;
	private UserDAO userDao = null;

	public Sequence getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Sequence userSeq) {
		this.userSeq = userSeq;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public Object participantTransaction(JSONObject transactionContext, TransactionStatus status) {
		if(!subTransaction1(transactionContext)) {
			status.setRollbackOnly();
		}
		return null;
	}
	
	public boolean subTransaction1(final JSONObject ctx) {
				Cust cust = (Cust)JSONObject.toBean(ctx, Cust.class);
				User user = new User();
				user.setUserId(userSeq.nextValue());
				user.setUsername("user1 of " + cust.getName());
				user.setProvId("10");
				user.setCityId(user.getUserId().toString());
				user.setCustId(cust.getCustId());
				return userDao.insert(user);
	}

	
	
}
