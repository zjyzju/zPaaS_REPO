package com.zpaas.dtx.server;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.server.dao.TransactionContextDAO;
import com.zpaas.message.MessageStatus;



public class NewTransactionProcessor implements TransactionProcessor<TransactionContext>{
	public static Logger log = Logger.getLogger(NewTransactionProcessor.class);
	
	private TransactionContextDAO contextDAO = null;
	private TransactionTemplate tt = null;
	
	public void processTransaction(final TransactionContext context, final MessageStatus status) {
		
		tt.execute(new TransactionCallback<Object>() {
			
			@Override
			public Object doInTransaction(TransactionStatus paramTransactionStatus) {
				if(log.isInfoEnabled()) {
					log.info("save new transaction context to db:" + context.toString());
				}
				try {
					context.setStatusTime(new Date());
					context.setSendTimes(0);
					contextDAO.insert(context);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		});
		
	}

	public TransactionContextDAO getContextDAO() {
		return contextDAO;
	}

	public void setContextDAO(TransactionContextDAO contextDAO) {
		this.contextDAO = contextDAO;
	}

	public TransactionTemplate getTt() {
		return tt;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
}
