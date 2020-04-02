package com.zpaas.dtx.assured;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.db.common.DistributedTransactionManager;
import com.zpaas.db.sequence.Sequence;
import com.zpaas.dtx.common.TransactionChecker;
import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.common.TransactionPublisher;
import com.zpaas.dtx.common.TransactionStatus;


public class AssuredTransactionManager  implements ConfigurationWatcher {
	
	public static final Logger log = LoggerFactory.getLogger(AssuredTransactionManager.class);
	
	private static final String ASSURED_TRANSACTION_MANAGER_TOPIC = "assured.transaction.manager.topic";
	private static final String ASSURED_TRANSACTION_CHECKER_TOPIC = "assured.transaction.checker.topic";
	private static final String ASSURED_TRANSACTION_CHECKER_NUM = "assured.transaction.checker.num";
	
	private String confPath = "/com/zpaas/tx/assuredTransactionManager";
	private ConfigurationCenter cc = null;
	private TransactionPublisher publisher = null;	
	private String transactionManagerTopic = "assured_transaction_manager_topic";	
	private String transactionCheckerTopic = "assured_transaction_checker_topic";
	private TransactionChecker transactionChecker = null;
	private int checkerThreadNum = 1;
	private List<KafkaConsumer<String, TransactionContext>> consumers = null;
	private ExecutorService executor = null;
	private String participant = null;
	private Properties kafkaProps = null;
	private Sequence sequence = null;
	
	private HashMap<String, AssuredTransactionParticipant> subTransactions = null;
	private AssuredTransactionParticipant mainTransaction = null;
	private String transactionName = null;
	
	public void init() {
		if (log.isInfoEnabled()) {
			log.info("init AssuredTransactionManager...");
		}
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			e.printStackTrace();
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new AssuredTransactionManager configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		@SuppressWarnings("rawtypes")
		Iterator keys = json.keys();
		boolean changed = false;
		if (kafkaProps == null) {
			kafkaProps = new Properties();
			changed = true;
		}
		if (keys != null) {
			String key = null;
			while (keys.hasNext()) {
				key = (String) keys.next();
				if(ASSURED_TRANSACTION_MANAGER_TOPIC.equals(key)) {
					transactionManagerTopic = json.getString(key);
					continue;
				}else if(ASSURED_TRANSACTION_CHECKER_TOPIC.equals(key)) {
					String topic = json.getString(key);
					if(transactionCheckerTopic == null || !transactionCheckerTopic.equals(topic)) {
						transactionCheckerTopic = topic;
						changed = true;
					}
					continue;
				}else if(ASSURED_TRANSACTION_CHECKER_NUM.equals(key) ) {
					int n = json.getInt(key);
					if(n != this.checkerThreadNum) {
						this.checkerThreadNum = n;
						changed = true;
					}
					continue;
				}
				
				if (kafkaProps.containsKey(key)) {
					if (kafkaProps.get(key) == null
							|| !kafkaProps.get(key).equals(json.getString(key))) {
						kafkaProps.put(key, json.getString(key));
						changed = true;
					}
				} else {
					kafkaProps.put(key, json.getString(key));
					changed = true;
				}
			}
		}
		
		kafkaProps.put("group.id", participant);
		if(transactionChecker != null && (changed || consumers == null)) {
			stopOld(executor, consumers);
			consumers = new ArrayList<>();
			startTransactionListener();
		}
	}
	
	public void startTransactionListener() {
		if(log.isInfoEnabled()) {
			log.info("start AssuredTransactionCheckListener...");
		}
		if(transactionCheckerTopic == null) {
			return;
		}
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		topicMap.put(transactionCheckerTopic, checkerThreadNum);
		
		List<String> subsList = new ArrayList<String>();
		for(String sub : this.subTransactions.keySet()) {
			subsList.add(sub);
			topicMap.put(this.transactionName + "_abnormal_" + sub, checkerThreadNum);
		}
		
		executor = Executors.newFixedThreadPool(checkerThreadNum * topicMap.size());
		int i=0;
		for(String topic : topicMap.keySet()) {
			for(int j=0; j<checkerThreadNum; j++) {
				KafkaConsumer<String, TransactionContext> consumer = new KafkaConsumer<>(kafkaProps);
				consumer.subscribe(Arrays.asList(topic));
				consumers.add(consumer);
				if(i<checkerThreadNum) {
					executor.execute(new AssuredTransactionCheckProcessor(i, consumer, publisher, 
						transactionManagerTopic, transactionChecker));
				}else {
					String sub = subsList.get((i-checkerThreadNum)/checkerThreadNum);
					executor.execute(new AssuredAbnormalTransactionProcessor(i, consumer, publisher, 
							transactionManagerTopic, subTransactions.get(sub), sub));
				}
				i++;
			}
		}
	}
	
	
	public void stopOld(ExecutorService oldExecutor, List<KafkaConsumer<String, TransactionContext>> oldConsumers) {
		if(log.isInfoEnabled()) {
			log.info("stop Old...");
		}
		if(oldConsumers != null && oldConsumers.size() > 0) {
			
			for(KafkaConsumer<String, TransactionContext> oldConsumer : oldConsumers) {
				if(log.isDebugEnabled()) {
					log.debug("old consumer is closed: {}", oldConsumers);
				}
				oldConsumer.close();
			}
		}
		if(oldExecutor != null) {
			if(log.isDebugEnabled()) {
				log.debug("begin to close old executor: {}", oldExecutor);
			}
			oldExecutor.shutdown();
			try {
				while(!oldExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
					if(log.isDebugEnabled()) {
						log.debug("old executor is not closed: {}", oldExecutor);
					}
				}
			} catch (InterruptedException e) {
				log.error(e.getMessage(),e);
			}
			if(log.isDebugEnabled()) {
				log.debug("old executor is closed: {}", oldExecutor);
			}
		}
	}
	
	
	
	public void execute(JSONObject transactionContext) {
		if(this.transactionName == null) {
			log.error("transaction name is null.");
			return ;
		}
		TransactionContext context = new TransactionContext();
		long id = sequence.nextValue();
		context.setTransactionId(id);
		context.setStartTime(System.currentTimeMillis());
		context.setFinishTime(0l);
		context.setStatus(TransactionContext.ASSURED_TRANSACTION_STATUS_NEW);
		context.setName(transactionName);
		context.setContent(transactionContext.toString());
		context.setTotalParticipants(JSONArray.fromObject(subTransactions.keySet()).toString());
		context.setParticipantAmount(subTransactions.size());
		ProducerRecord<String, TransactionContext> transactionMessage = new ProducerRecord<String, TransactionContext>(transactionManagerTopic, String.valueOf(context.getTransactionId()), context);
		if(log.isInfoEnabled()) {
			log.info("initiate new transaction: {}", context.getTransactionId());
		}
		if(!publisher.publish(transactionMessage)) {
			log.error("publish transaction failed: {} new status: {}",context.getTransactionId(), context.getStatus());
			return ;
		}
		AssuredTransactionExecutor executor = 
				new AssuredTransactionExecutor(transactionContext,mainTransaction,subTransactions);
		executor.setPublisher(publisher);
		context.setContent(null);
		executor.setContext(context);
		executor.setTransactionManagerTopic(transactionManagerTopic);
		executor.execute();
	}
	
	public HashMap<String, AssuredTransactionParticipant> getSubTransactions() {
		return subTransactions;
	}
	public void setSubTransactions(HashMap<String, AssuredTransactionParticipant> subTransactions) {
		this.subTransactions = subTransactions;
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

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	public TransactionPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(TransactionPublisher publisher) {
		this.publisher = publisher;
	}

	public TransactionChecker getTransactionChecker() {
		return transactionChecker;
	}

	public void setTransactionChecker(TransactionChecker transactionChecker) {
		this.transactionChecker = transactionChecker;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	public AssuredTransactionParticipant getMainTransaction() {
		return mainTransaction;
	}

	public void setMainTransaction(AssuredTransactionParticipant mainTransaction) {
		this.mainTransaction = mainTransaction;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
}

class AssuredTransactionCheckProcessor implements Runnable {
	public static final Logger log = LoggerFactory.getLogger(AssuredTransactionCheckProcessor.class);
	
	private String checkerName = null;
	
	private KafkaConsumer<String, TransactionContext> consumer = null;	
	TransactionPublisher publisher = null;
	
	private String transactionManagerTopic = null;
	TransactionChecker transactionChecker;
	
	public AssuredTransactionCheckProcessor(int checkerId, KafkaConsumer<String, TransactionContext> consumer, 
			TransactionPublisher publisher, String transactionManagerTopic, TransactionChecker transactionChecker) {
		this.checkerName = "TransactionCheckProcessor " + checkerId;
		this.consumer = consumer;
		this.publisher = publisher;
		this.transactionManagerTopic = transactionManagerTopic;
		this.transactionChecker = transactionChecker;
		if(log.isInfoEnabled()) {
			log.info("{} started", this.checkerName);
		}
	}
	public void run() {
		ConsumerRecords<String, TransactionContext> records = consumer.poll(Duration.ofMillis(100));	
		TransactionContext msg = null;
		if(records != null && !records.isEmpty()) {
			for(ConsumerRecord<String, TransactionContext> record : records) {
				try {
					msg = record.value();
					if(log.isDebugEnabled()) {
						log.debug("{} check transaction:{}",this.checkerName, msg.toString());
					}
					TransactionStatus status = new TransactionStatus();
					transactionChecker.checkTransaction(msg, status);
					if(status.isRollbackOnly()) {
						msg.setStatus(TransactionContext.TRANSACTION_STATUS_ROLLBACK);
						if(log.isDebugEnabled()) {
							log.debug("the transction:{} has bean rollbacked.", msg.getTransactionId());
						}
					}else {
						msg.setStatus(TransactionContext.TRANSACTION_STATUS_COMMIT);									
						if(log.isDebugEnabled()) {
							log.debug("the transction:{} has been commited.", msg.getTransactionId());
						}
					}
					ProducerRecord<String, TransactionContext> transactionMessage = new ProducerRecord<String, TransactionContext>(transactionManagerTopic, String.valueOf(msg.getTransactionId()), msg);
					if(!publisher.publish(transactionMessage)) {
						log.error("publish transaction failed: {} new status:{}",msg.getTransactionId(), msg.getStatus());
					}
				} catch (Exception e) {
					log.error(e.getMessage(),e);
				} catch (Error e) {
					log.error(e.getMessage(),e);
				}
			}
		}
		
		if(log.isInfoEnabled()) {
			log.info("{} is stopped", checkerName);
		}
	}

}

class AssuredAbnormalTransactionProcessor implements Runnable {
	public static final Logger log = LoggerFactory.getLogger(AssuredAbnormalTransactionProcessor.class);
	
	private String processorName = null;
	private String subTransaction = null;
	
	private KafkaConsumer<String, TransactionContext> consumer = null;	
	TransactionPublisher publisher = null;
	
	private String transactionManagerTopic = null;
	AssuredTransactionParticipant subs;
	
	public AssuredAbnormalTransactionProcessor(int processorId, KafkaConsumer<String, TransactionContext> consumer, 
			TransactionPublisher publisher, String transactionManagerTopic, AssuredTransactionParticipant subs, String subTransaction) {
		this.processorName = "AssuredAbnormalTransactionProcessor " + processorId;
		this.consumer = consumer;
		this.publisher = publisher;
		this.transactionManagerTopic = transactionManagerTopic;
		this.subs = subs;
		this.subTransaction = subTransaction;
		if(log.isInfoEnabled()) {
			log.info("{} started", this.processorName);
		}
	}
	public void run() {
		ConsumerRecords<String, TransactionContext> records = consumer.poll(Duration.ofMillis(100));	
		TransactionContext msg = null;
		Connection subConn = null;
		if(records != null && !records.isEmpty()) {
			for(ConsumerRecord<String, TransactionContext> record : records) {
				try {
					msg = record.value();
					if(log.isDebugEnabled()) {
						log.debug("{} process abnormal transaction:{}",this.processorName, msg.toString());
					}
					AssuredTransactionStatus status = new AssuredTransactionStatus();
					JSONObject ctx = JSONObject.fromObject(msg.getContent());
					DistributedTransactionManager.beginTransaction();
					subs.participantTransaction(ctx, status);
					String subKey = (String)DistributedTransactionManager.getConnectionMap().keySet().iterator().next();
					subConn = DistributedTransactionManager.getConnectionMap().get(subKey);
					if(DistributedTransactionManager.getConnectionMap().size() != 1) {
						log.error("sub transaction only can be assigned with one connection:{}", 
								DistributedTransactionManager.getConnectionMap());
						status.setRollbackOnly();
					}
					DistributedTransactionManager.unbindConnection(subKey);
					if(status.isRollbackOnly()) {
						try {
							subConn.rollback();
						} catch (Exception e) {
							log.error(e.getMessage(),e);
						}
						if(log.isDebugEnabled()) {
							log.debug("the sub transction:{} of {} failed.",subTransaction,msg.getTransactionId());
						}
					}else {
						try {
							subConn.commit();
						} catch (Exception e) {
							log.error(e.getMessage(),e);
							return;
						}
						msg.setStatus(TransactionContext.ASSURED_TRANSACTION_STATUS_PART_FINISH);	
						msg.setParticipant(subTransaction);
						if(log.isDebugEnabled()) {
							log.debug("the sub transction:{} of {} has been commited.",subTransaction,msg.getTransactionId());
						}
						ProducerRecord<String, TransactionContext> transactionMessage = new ProducerRecord<String, TransactionContext>(transactionManagerTopic, String.valueOf(msg.getTransactionId()), msg);
						if(!publisher.publish(transactionMessage)) {
							log.error("publish transaction failed: {} new status:{}",msg.getTransactionId(), msg.getStatus());
						}
					}
					
				} catch (Exception e) {
					log.error(e.getMessage(),e);
				} catch (Error e) {
					log.error(e.getMessage(),e);
				} finally {
					if(subConn != null) {
						try {
							subConn.close();
						} catch (SQLException e) {
							log.error(e.getMessage(),e);
						}
					}
					DistributedTransactionManager.endTransaction();
				}
			}
		}
	
		if(log.isInfoEnabled()) {
			log.info("{} is stopped", processorName);
		}
	}

}
