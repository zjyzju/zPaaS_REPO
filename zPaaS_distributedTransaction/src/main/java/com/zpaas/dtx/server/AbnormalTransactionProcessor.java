package com.zpaas.dtx.server;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import kafka.producer.KeyedMessage;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.db.distribute.DistributeRuleAssist;
import com.zpaas.dispatcher.ResourceExecutor;
import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.common.TransactionPublisher;
import com.zpaas.dtx.server.dao.TransactionContextDAO;

public class AbnormalTransactionProcessor implements ResourceExecutor,ConfigurationWatcher{
    
	private static final Logger log = Logger.getLogger(AbnormalTransactionProcessor.class);
	private static final String ABNORMAL_PROCESSOR_NUM = "abnormal.transaction.processor.num";
	private static final String ABNORMAL_PROCESSOR_MIN_TASKNUM = "abnormal.transaction.processor.minTaskNum";
	private static final String ABNORMAL_PROCESSOR_INTERVAL = "abnormal.transaction.processor.interval";
	private static final String TRANSACTION_CHECKER_TOPIC = "transaction.checker.topic";
	
	private JSONArray resources = null;
	private Object lock = new Object();
	private boolean isRunning = false;
	
	private String confPath = "/com/zpaas/tx/abnormalMessageProcessor";
	private ConfigurationCenter cc = null;
	
	private int processorNum = 5;
	private int minTaskNum = 10;
	private int interval = 90;//second
	private String checkerTopic = "distribute_transaction_checker_topic";
	
	private TransactionContextDAO contextDAO = null;
	private TransactionPublisher publisher = null;
	
	public void init() {
		if (log.isInfoEnabled()) {
			log.info("init AbnormalMessageProcessor...");
		}
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			e.printStackTrace();
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new AbnormalMessageProcessor configuration is received: " + conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		@SuppressWarnings("rawtypes")
		Iterator keys = json.keys();
		if (keys != null) {
			String key = null;
			while (keys.hasNext()) {
				key = (String) keys.next();
				if (ABNORMAL_PROCESSOR_NUM.equals(key)) {
					this.processorNum = json.getInt(key);
				} else if (ABNORMAL_PROCESSOR_MIN_TASKNUM.equals(key)) {
					this.minTaskNum = json.getInt(key);
				} else if (ABNORMAL_PROCESSOR_INTERVAL.equals(key)) {
					this.interval = json.getInt(key);
				} else if (TRANSACTION_CHECKER_TOPIC.equals(key)) {
					this.checkerTopic = json.getString(key);
				} 
			}
		}		
	}
	
	@Override
	public void modifyAllResources(JSONArray arg0) {
		
	}
	
	@Override
	public void prepareResourceAllocate(JSONArray resources) {
		synchronized(lock) {
			log.debug("prepareResourceAllocate:" + resources);
				if(this.resources != null && this.resources.size() > 0) {
				int i=0;
				while(isRunning) {
					i++;
					try {
						Thread.sleep(i * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				JSONArray tmp = new JSONArray();
				tmp.addAll(this.resources);
				tmp.removeAll(resources);
				resources.removeAll(tmp);
			}
			log.debug("prepareResourceAllocate: clear resources");
			this.resources = null;
		}
	}
	
	@Override
	public void commitResourceAllocate(JSONArray resources) {
		synchronized(lock) {
            log.debug("commitResourceAllocate:" + resources);
			this.resources = resources;
		}
	}

	@Override
	public boolean canReleaseResource(String resource) {
		log.debug("canReleaseResource:" + this.resources);
		if(this.resources != null && this.resources.contains(resource)) {
			log.debug("canReleaseResource: false");
			return false;
		}else {
			log.debug("canReleaseResource: true");
			return true;
		}
	}
	
	public void processAbnormalTransaction() {
		if(resources == null || resources.isEmpty()) {
			if(log.isDebugEnabled()) {
				log.debug("not allocated any resoruces. break the job.");
			}
			return;
		}
		isRunning = true;
		if(log.isDebugEnabled()) {
			log.debug("begin process abnormal message. resources is " + resources);
		}
		int count = resources.size();
		Integer resourceId = null;
		List<AbnormalProcessor> threads = new ArrayList<AbnormalProcessor>();
		for(int i=0; i<count; i++) {
			resourceId = resources.getInt(i);
			if(log.isDebugEnabled()) {
				log.debug("process abnormal message of resource:" + resourceId);
			}		
			DistributeRuleAssist.setTableIndex(resourceId);
			List<TransactionContext> list = contextDAO.queryAbnormalTransaction(interval);
			DistributeRuleAssist.clearTableIndex();
			if(list == null || list.size() == 0) {
				if(log.isDebugEnabled()) {
					log.debug("no abnormal message found of resource:" + resourceId);
				}
				continue;
			}
			if(log.isDebugEnabled()) {
				log.debug(list.size() + " abnormal messages found of resource:" + resourceId);
			}
			int size = list.size();
			int min = 0;
			int mod = 0;
			int counter = 1;
			if(size > processorNum*minTaskNum) {
				min = size/processorNum;
				mod = size%processorNum;
			}else {
				min = minTaskNum;
				mod = 0;
			}
			if(log.isDebugEnabled()) {
				log.debug("resource:" + resourceId + " dispatch task min:" + min + " mod:" + mod);
			}
			
			List<TransactionContext> subList = null;
			int k=0;
			for(TransactionContext msg : list) {
				k++;
				if(counter == 1) {
					subList = new ArrayList<TransactionContext>();
				}
				subList.add(msg);
				if(mod > 0 && counter == (min+1)) {
					mod--;
					counter=1;
					AbnormalProcessor proc = new AbnormalProcessor(subList, publisher, contextDAO,checkerTopic);
					threads.add(proc);
					proc.start();
				}else if(mod <=0 && counter == min) {
					counter=1;
					AbnormalProcessor proc = new AbnormalProcessor(subList, publisher, contextDAO,checkerTopic);
					threads.add(proc);
					proc.start();
				}else if(k==size) {
					counter=1;
					AbnormalProcessor proc = new AbnormalProcessor(subList, publisher, contextDAO,checkerTopic);
					threads.add(proc);
					proc.start();
				}else {
					counter++;
				}
			}
		}
		for(AbnormalProcessor proc : threads) {
			try {
				proc.join();
			} catch (InterruptedException e) {
				
			}
		}
				
		isRunning = false;
		if(log.isDebugEnabled()) {
			log.debug("abnormal message processing finished.");
		}
	}

	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	public ConfigurationCenter getCc() {
		return cc;
	}

	public void setCc(ConfigurationCenter cc) {
		this.cc = cc;
	}

	public TransactionContextDAO getContextDAO() {
		return contextDAO;
	}

	public void setContextDAO(TransactionContextDAO contextDAO) {
		this.contextDAO = contextDAO;
	}

	public TransactionPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(TransactionPublisher publisher) {
		this.publisher = publisher;
	}
}

class AbnormalProcessor extends Thread {
	private static final Logger log = Logger.getLogger(AbnormalProcessor.class);
	
	private List<TransactionContext> transactions = null;
	private TransactionPublisher publisher = null;
	private TransactionContextDAO contextDAO = null;
	private String checkerTopic = "distribute_transaction_checker_topic";
	
	public AbnormalProcessor(List<TransactionContext> transactions, TransactionPublisher publisher
			,TransactionContextDAO contextDAO, String checkerTopic) {
		if(log.isDebugEnabled()) {
			log.debug("start AbnormalProcessor...");
		}
		this.transactions = transactions;
		this.publisher = publisher;
		this.contextDAO = contextDAO;
		this.checkerTopic = checkerTopic;
	}
	
	@Override
	public void run() {
		if(transactions == null || transactions.size() == 0) {
			return;
		}
		if(log.isDebugEnabled()) {
			log.debug("AbnormalProcessor process transaction:" + transactions.size());
		}
		for(TransactionContext transaction : transactions) {
			TransactionContext deliverMessage = new TransactionContext();
			deliverMessage.setTransactionId(transaction.getTransactionId());
			deliverMessage.setContent(transaction.getContent());
			deliverMessage.setName(transaction.getName());
			if(TransactionContext.TRANSACTION_STATUS_COMMIT.equals(transaction.getStatus())) {
				int sendTimes = 1;
				if(transaction.getSendTimes() != null) {
					sendTimes = transaction.getSendTimes()+1;
				}
				transaction.setSendTimes(sendTimes);
				transaction.setStatus(TransactionContext.TRANSACTION_STATUS_DELIVERED);
				transaction.setStatusTime(new Date());
				contextDAO.update(transaction);
				KeyedMessage<String, TransactionContext> keyedMsg = 
						new KeyedMessage<String, TransactionContext>(
								deliverMessage.getName(),String.valueOf(transaction.getTransactionId()),deliverMessage);
				if(log.isDebugEnabled()) {
					log.debug("AbnormalProcessor deliver message:" + keyedMsg);
				}
				publisher.getProducer().send(keyedMsg);
				continue;
			}else if(TransactionContext.TRANSACTION_STATUS_NEW.equals(transaction.getStatus())) {
				KeyedMessage<String, TransactionContext> keyedMsg = 
						new KeyedMessage<String, TransactionContext>(
								checkerTopic,String.valueOf(transaction.getTransactionId()),deliverMessage);
				if(log.isDebugEnabled()) {
					log.debug("AbnormalProcessor deliver message:" + keyedMsg);
				}
				publisher.getProducer().send(keyedMsg);
				continue;
			}
			JSONArray participantArray = new JSONArray();
			if(transaction.getFailedParticipants() != null && transaction.getFailedParticipants().length() > 0) {
				participantArray.addAll(JSONArray.fromObject(transaction.getFailedParticipants()));
			}
			JSONArray allParticipants = new JSONArray();
			if(transaction.getTotalParticipants() != null && transaction.getTotalParticipants().length() > 0) {
				allParticipants.addAll(JSONArray.fromObject(transaction.getTotalParticipants()));
			}
			JSONArray succeedParticipants = new JSONArray();
			if(transaction.getSucceedParticipants() != null && transaction.getSucceedParticipants().length() > 0) {
				succeedParticipants.addAll(JSONArray.fromObject(transaction.getSucceedParticipants()));
			}
			allParticipants.removeAll(succeedParticipants);
			participantArray.addAll(allParticipants);
			int count = participantArray.size();
			if(count == 0) {
				transaction.setFinishTime(System.currentTimeMillis());
				transaction.setStatus(TransactionContext.TRANSACTION_STATUS_ALL_SUCCEED);
				contextDAO.update(transaction);
				continue;
			}
			int sendTimes = 1;
			if(transaction.getSendTimes() != null) {
				sendTimes = transaction.getSendTimes()+1;
			}
			transaction.setSendTimes(sendTimes);
			transaction.setStatusTime(new Date());
			contextDAO.update(transaction);
			for(int i=0; i<count; i++) {
				String subs = participantArray.getString(i);
				KeyedMessage<String, TransactionContext> keyedMsg = 
						new KeyedMessage<String, TransactionContext>(
								deliverMessage.getName()+"_abnormal_"+subs, 
								String.valueOf(transaction.getTransactionId()), 
								deliverMessage);
				if(log.isDebugEnabled()) {
					log.debug("AbnormalProcessor deliver message:" + keyedMsg);
				}
				publisher.publish(keyedMsg);
			}	
			
		}
	}
	
}
