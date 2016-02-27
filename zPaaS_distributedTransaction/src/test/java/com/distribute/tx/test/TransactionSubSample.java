package com.distribute.tx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

import net.sf.json.JSONObject;

import com.distribute.tx.test.dao.UserDAO;
import com.distribute.tx.test.vo.Cust;
import com.distribute.tx.test.vo.User;
import com.zpaas.db.sequence.Sequence;
import com.zpaas.dtx.common.TransactionListener;
import com.zpaas.dtx.common.TransactionStatus;
import com.zpaas.dtx.eventual.TransactionListenerManager;

public class TransactionSubSample implements TransactionListener {

	private TransactionTemplate tt = null;
	private Sequence userSeq = null;
	private UserDAO userDao = null;

	public TransactionTemplate getTt() {
		return tt;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}

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

	public void joinTransaction(JSONObject message, TransactionStatus status, String transactionName) {
		System.out.println("get message:" + message.toString());
		Cust cust = (Cust) JSONObject.toBean(message,Cust.class);
		final User user = new User();
		user.setUserId(userSeq.nextValue());
		user.setUsername("user of " + cust.getName());
		user.setProvId("10");
		user.setCityId(user.getUserId().toString());
		user.setCustId(cust.getCustId());
		final UserDAO dao = userDao;
		Object ret = tt
				.execute(new org.springframework.transaction.support.TransactionCallback<Object>() {

					@Override
					public Object doInTransaction(
							org.springframework.transaction.TransactionStatus paramTransactionStatus) {
						return dao.insert(user);
					}
				});
		if (ret != null && ((Boolean) ret)) {
			System.out.println("succeed");
			return ;
		} else {
			System.out.println("failed");
			status.setRollbackOnly();
			return ;
		}

		// if(message.getStartTime() != 0){
		// status.setRollbackOnly();
		// }

	}

	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "txListenerContext.xml" });
		@SuppressWarnings("unused")
		TransactionListenerManager server = (TransactionListenerManager) ctx
				.getBean("transactionListenerManager");
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
