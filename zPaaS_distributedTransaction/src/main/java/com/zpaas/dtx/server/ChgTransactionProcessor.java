package com.zpaas.dtx.server;

import java.util.Date;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.zpaas.cache.remote.RemoteCacheSVC;
import com.zpaas.dtx.common.Transaction;
import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.server.dao.TransactionContextDAO;
import com.zpaas.dtx.server.dao.TransactionDAO;
import com.zpaas.message.MessageStatus;


public class ChgTransactionProcessor implements TransactionProcessor<TransactionContext> {
	public static Logger log = LoggerFactory.getLogger(ChgTransactionProcessor.class);
	
	private TransactionContextDAO contextDAO = null;
	private TransactionDAO transactionDAO = null;
	private RemoteCacheSVC cacheSvc = null;
	private TransactionTemplate tt = null;
	
	public void processTransaction(final TransactionContext context, final MessageStatus status) {
		tt.execute(new TransactionCallback<Object>() {
			
			@Override
			public Object doInTransaction(TransactionStatus paramTransactionStatus) {
				if(log.isInfoEnabled()) {
					log.info("process transaction:{}", context.getContent());
				}
				TransactionContext tm = contextDAO.getTransactionContextById(context.getTransactionId());
				if(tm == null) {
					log.error("invalid transaction:{}", context);
					return false;
				}
				if(TransactionContext.TRANSACTION_STATUS_PART_SUCCEED.equals(context.getStatus()) ||
						TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FINISH.equals(context.getStatus())) {			
					JSONArray array = null;
					if(tm.getSucceedParticipants() != null && tm.getSucceedParticipants().length() > 0) {
						array = JSONArray.fromObject(tm.getSucceedParticipants());
					}else {
						array = new JSONArray();
					}
					if(!array.contains(context.getParticipant())) {
						array.add(context.getParticipant());
						tm.setSucceedParticipants(array.toString());
					}
					JSONArray participants = null;
					if(tm.getTotalParticipants() != null && tm.getTotalParticipants().length() > 0) {
						participants = JSONArray.fromObject(tm.getTotalParticipants()); 
					}
					JSONArray failedParticipants = null;
					if(tm.getFailedParticipants() != null && tm.getFailedParticipants().length() > 0) {
						failedParticipants = JSONArray.fromObject(tm.getFailedParticipants()); 
						if(failedParticipants.contains(context.getParticipant())) {
							failedParticipants.remove(context.getParticipant());
							tm.setFailedParticipants(failedParticipants.toString());
						}				
					}
					if((participants == null || array.containsAll(participants)) && 
							(failedParticipants == null || failedParticipants.isEmpty())) {
						if(TransactionContext.TRANSACTION_STATUS_PART_SUCCEED.equals(context.getStatus())) {
							tm.setStatus(TransactionContext.TRANSACTION_STATUS_ALL_SUCCEED);
						}else {
							tm.setStatus(TransactionContext.ASSURED_TRANSACTION_STATUS_ALL_FINISH);
						}
						tm.setFinishTime(System.currentTimeMillis());
					}else {
						if(!tm.getStatus().equals(TransactionContext.ASSURED_TRANSACTION_STATUS_ALL_FINISH) && 
								!tm.getStatus().equals(TransactionContext.TRANSACTION_STATUS_ALL_SUCCEED)) {
							if(TransactionContext.TRANSACTION_STATUS_PART_SUCCEED.equals(context.getStatus())) {
								tm.setStatus(TransactionContext.TRANSACTION_STATUS_PART_FAILED);
							}else {
								tm.setStatus(TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FAILED);
							}
						}
						//tm.setFinishTime(System.currentTimeMillis());
					}
					
				}else if(TransactionContext.TRANSACTION_STATUS_PART_FAILED.equals(context.getStatus()) ||
						TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FAILED.equals(context.getStatus())) {			
					JSONArray failedSubscribers = null;
					if(tm.getFailedParticipants() != null && tm.getFailedParticipants().length() > 0) {
						failedSubscribers = JSONArray.fromObject(tm.getFailedParticipants()); 				
					}else {
						failedSubscribers = new JSONArray();
					}			
					if(!failedSubscribers.contains(context.getParticipant())) {
						failedSubscribers.add(context.getParticipant());
						tm.setFailedParticipants(failedSubscribers.toString());
					}
					if(!tm.getStatus().equals(TransactionContext.TRANSACTION_STATUS_ALL_SUCCEED)) {
						if(TransactionContext.TRANSACTION_STATUS_PART_FAILED.equals(context.getStatus())) {
							tm.setStatus(TransactionContext.TRANSACTION_STATUS_PART_FAILED);
						}else {
							tm.setStatus(TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FAILED);
						}
					}
				}else {
					if(TransactionContext.TRANSACTION_STATUS_COMMIT.equals(context.getStatus())) {
						Transaction topic = (Transaction) cacheSvc.getItem(Transaction.CACHE_PREFIX + context.getName());
						if(topic == null) {
							topic = transactionDAO.getTransactionById(context.getName());
						}
						tm.setTotalParticipants(topic.getParticipants());
					}
					tm.setStatus(context.getStatus());
				}
				tm.setStatusTime(new Date());
				contextDAO.update(tm);
				return true;
			}
		});
		
	}

	public TransactionContextDAO getContextDAO() {
		return contextDAO;
	}

	public void setContextDAO(TransactionContextDAO contextDAO) {
		this.contextDAO = contextDAO;
	}

	public TransactionDAO getTransactionDAO() {
		return transactionDAO;
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	public RemoteCacheSVC getCacheSvc() {
		return cacheSvc;
	}

	public void setCacheSvc(RemoteCacheSVC cacheSvc) {
		this.cacheSvc = cacheSvc;
	}

	public TransactionTemplate getTt() {
		return tt;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}

	
}
