package com.zpaas.dtx.assured;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.db.common.DistributedTransactionManager;
import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.common.TransactionPublisher;

public class AssuredTransactionExecutor {
	public static final Logger log = LoggerFactory.getLogger(AssuredTransactionExecutor.class);
	
	private AssuredTransactionParticipant mainTransaction = null;
	private Map<String, AssuredTransactionParticipant> subTransactions = null;
	private JSONObject transactionContext;
	private TransactionPublisher publisher = null;
	private TransactionContext context = null;
	private String transactionManagerTopic = "assured_transaction_manager_topic";
	
	public AssuredTransactionExecutor(JSONObject transactionContext,
			AssuredTransactionParticipant mainTransaction, Map<String, AssuredTransactionParticipant> subTransactions) {
		this.transactionContext = transactionContext;
		this.mainTransaction = mainTransaction;
		this.subTransactions = subTransactions;
	}
	
	public void changeTransactionContextStatus(Integer transactionStatus) {
		if(publisher == null && context == null) {
			log.error("publisher and context can't be null");
			return;
		}
		context.setStatus(transactionStatus);
		ProducerRecord<String, TransactionContext> transactionMessage = new ProducerRecord<String, TransactionContext>(transactionManagerTopic, String.valueOf(context.getTransactionId()), context);
		if(log.isInfoEnabled()) {
			log.info("change status of transaction:{} to {}",context.getTransactionId(), transactionStatus);
		}
		if(!publisher.publish(transactionMessage)) {
			log.error("publish transaction failed: {} new status: {}",context.getTransactionId(), context.getStatus());
			return ;
		}
	}
	
	public void notifySubTransactionFailed(String subTransaction) {
		if(publisher == null && context == null) {
			log.error("publisher and context can't be null");
			return;
		}
		context.setStatus(TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FAILED);
		context.setParticipant(subTransaction);
		ProducerRecord<String, TransactionContext> transactionMessage = new ProducerRecord<String, TransactionContext>(transactionManagerTopic, String.valueOf(context.getTransactionId()), context);
		if(log.isInfoEnabled()) {
			log.info("change status of transaction:{} to {}", context.getTransactionId(), TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FAILED);
		}
		if(!publisher.publish(transactionMessage)) {
			log.error("publish transaction failed: {} new status: {}", context.getTransactionId(), context.getStatus());
			return ;
		}
	}
	
	public void notifySubTransactionFinish(String subTransaction) {
		if(publisher == null && context == null) {
			log.error("publisher and context can't be null");
			return;
		}
		context.setStatus(TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FINISH);
		context.setParticipant(subTransaction);
		ProducerRecord<String, TransactionContext> transactionMessage = new ProducerRecord<String, TransactionContext>(transactionManagerTopic, String.valueOf(context.getTransactionId()), context);
		if(log.isInfoEnabled()) {
			log.info("change status of transaction: {} to {}",context.getTransactionId(),TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FINISH);
		}
		if(!publisher.publish(transactionMessage)) {
			log.error("publish transaction failed: {} new status: {}",context.getTransactionId(), context.getStatus());
			return ;
		}
	}

	
	public Object doInTransaction(AssuredTransactionStatus assuredStatus) {
		if(mainTransaction == null) {
			log.error("main transaction cannot be null.");
			assuredStatus.setRollbackOnly();
			return null;
		}
		DistributedTransactionManager.beginTransaction();
		Object obj = mainTransaction.participantTransaction(transactionContext, assuredStatus);
		String mainKey = (String)DistributedTransactionManager.getConnectionMap().keySet().iterator().next();
		Connection mainConn = DistributedTransactionManager.getConnectionMap().get(mainKey);
		assuredStatus.setMainConn(mainConn);
		AssuredTransactionContext assuredCtx = new AssuredTransactionContext();
		assuredCtx.setSubTransactionName("");
		assuredCtx.setTransactionContext(transactionContext);
		assuredStatus.setAssuredContext(assuredCtx);
		
		if(assuredStatus.isRollbackOnly()) {
			return obj;
		}
		
		if(DistributedTransactionManager.getConnectionMap().size() != 1) {
			log.error("main transaction only can be assigned with one connection: {}", DistributedTransactionManager.getConnectionMap());
			assuredStatus.setRollbackOnly();
			return null;
		}
		DistributedTransactionManager.unbindConnection(mainKey);
		if(subTransactions != null && subTransactions.size() > 0) {
			
			for(Entry<String, AssuredTransactionParticipant> entry : subTransactions.entrySet()) {
				entry.getValue().participantTransaction(transactionContext, assuredStatus);
				String subKey = (String)DistributedTransactionManager.getConnectionMap().keySet().iterator().next();
				Connection subConn = DistributedTransactionManager.getConnectionMap().get(subKey);
				if(DistributedTransactionManager.getConnectionMap().size() != 1) {
					log.error("sub transaction only can be assigned with one connection: {}",DistributedTransactionManager.getConnectionMap());
					assuredStatus.setRollbackOnly();
					return null;
				}
				DistributedTransactionManager.unbindConnection(subKey);
				assuredStatus.getConns().put(entry.getKey(),subConn);
				
				if(assuredStatus.isRollbackOnly()) {
					break;
				}
			}
		}
		return null;
	}

	public TransactionPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(TransactionPublisher publisher) {
		this.publisher = publisher;
	}

	public TransactionContext getContext() {
		return context;
	}

	public void setContext(TransactionContext context) {
		this.context = context;
	}

	public String getTransactionManagerTopic() {
		return transactionManagerTopic;
	}

	public void setTransactionManagerTopic(String transactionManagerTopic) {
		this.transactionManagerTopic = transactionManagerTopic;
	}
	
	public Object execute() {
		AssuredTransactionStatus assuredStatus = new AssuredTransactionStatus();
		Object result = null;
		try {
			result = this.doInTransaction(assuredStatus);
		}
		catch (Exception ex) {
			DistributedTransactionManager.endTransaction();
			doRollback(assuredStatus);
			assuredStatus.setRollbackOnly();
			log.error(ex.getMessage(),ex);
			return result;
		}
		DistributedTransactionManager.endTransaction();
		if(assuredStatus.isRollbackOnly()) {
			doRollback(assuredStatus);
			this.changeTransactionContextStatus(TransactionContext.ASSURED_TRANSACTION_STATUS_ROLLBACK);
		}else {
			doCommit(assuredStatus);
		}
		doClose(assuredStatus);
		return result;
	}
	
	protected void doCommit(AssuredTransactionStatus assuredStatus) {
		try {
			assuredStatus.getMainConn().commit();
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			rollbackSubTransactions(assuredStatus.getConns().values(), assuredStatus.getAssuredContext());
			this.changeTransactionContextStatus(
						TransactionContext.ASSURED_TRANSACTION_STATUS_ROLLBACK);
			return;
		}
		this.changeTransactionContextStatus(
					TransactionContext.ASSURED_TRANSACTION_STATUS_COMMIT);
		
		if(commitSubTransactions(assuredStatus)) {
			this.changeTransactionContextStatus(
					TransactionContext.ASSURED_TRANSACTION_STATUS_ALL_FINISH);
		}
	}
	
	protected void doClose(AssuredTransactionStatus assuredStatus) {
		try {
			assuredStatus.getMainConn().close();
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			return;
		}
		closeSubTransactions(assuredStatus);
	}

	protected void doRollback(AssuredTransactionStatus assuredStatus) {
		try {
			if(assuredStatus.getMainConn() != null) {
				assuredStatus.getMainConn().rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rollbackSubTransactions(assuredStatus.getConns().values(), assuredStatus.getAssuredContext());
		this.changeTransactionContextStatus(
					TransactionContext.ASSURED_TRANSACTION_STATUS_ROLLBACK);
	}
	
	
	private boolean commitSubTransactions(AssuredTransactionStatus assuredStatus) {
		Map<String, Connection> conns = assuredStatus.getConns();
		AssuredTransactionContext assuredCtx = assuredStatus.getAssuredContext();
		if(conns == null || assuredCtx == null) {
			return true;
		}
		boolean succeed = true;
		for(Entry<String, Connection> entry : conns.entrySet()) {
			Connection conn = entry.getValue();
			try {
				conn.commit();
				this.notifySubTransactionFinish(entry.getKey());
			} catch (Exception e) {
				succeed = false;
				log.error(e.getMessage(),e);
				this.notifySubTransactionFailed(entry.getKey());
			}
			
		}
		return succeed;
	}
	
	private boolean closeSubTransactions(AssuredTransactionStatus assuredStatus) {
		Map<String, Connection> conns = assuredStatus.getConns();
		AssuredTransactionContext assuredCtx = assuredStatus.getAssuredContext();
		if(conns == null || assuredCtx == null) {
			return true;
		}
		boolean succeed = true;
		
		for(Entry<String, Connection> entry : conns.entrySet()) {
			Connection conn = entry.getValue();
			try {
				conn.close();
			} catch (Exception e) {
				succeed = false;
				log.error(e.getMessage(),e);
			}
		}
		return succeed;
	}
	
	private void rollbackSubTransactions(Collection<Connection> conns, AssuredTransactionContext assuredCtx) {
		if(conns == null || assuredCtx == null) {
			return;
		}
		for(Connection conn : conns) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				log.error(e.getMessage(),e);
			}
		}
	}
}
