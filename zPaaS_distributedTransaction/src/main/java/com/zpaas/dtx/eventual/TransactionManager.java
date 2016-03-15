package com.zpaas.dtx.eventual;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.db.sequence.Sequence;
import com.zpaas.dtx.common.ContextDecoder;
import com.zpaas.dtx.common.TransactionCallback;
import com.zpaas.dtx.common.TransactionChecker;
import com.zpaas.dtx.common.TransactionContext;
import com.zpaas.dtx.common.TransactionPublisher;
import com.zpaas.dtx.common.TransactionStatus;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.producer.KeyedMessage;
import kafka.serializer.StringDecoder;

public class TransactionManager implements ConfigurationWatcher {
	public static final Logger log = LoggerFactory.getLogger(TransactionManager.class);
	
	private static final String TRANSACTION_TOPIC = "transaction.topic";
	private static final String CHECKER_TOPIC = "checker.topic";
	private static final String CHECKER_NUM = "checker.num";
	

	private String confPath = "/com/zpaas/tx/transactionManager";
	private ConfigurationCenter cc = null;
	private TransactionPublisher publisher = null;
	private TransactionChecker transactionChecker = null;
	private Sequence sequence = null;
	private String participant = null;
	
		
	private String transactionTopic = "distribute_transaction_manager_topic";	
	private String checkerTopic = "distribute_transaction_checker_topic";	
	private int checkerThreadNum = 1;
	private Properties kafkaProps = null;
	
	
	private ConsumerConnector consumer = null;
	private ExecutorService executor = null;
	
	public void init() {
		if (log.isInfoEnabled()) {
			log.info("init TransactionManager...");
		}
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			e.printStackTrace();
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new TransactionManager configuration is received: {}", conf);
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
				if(TRANSACTION_TOPIC.equals(key)) {
					transactionTopic = json.getString(key);
					continue;
				}else if(CHECKER_TOPIC.equals(key)) {
					String topic = json.getString(key);
					if(checkerTopic == null || !checkerTopic.equals(topic)) {
						checkerTopic = topic;
						changed = true;
					}
					continue;
				}else if(CHECKER_NUM.equals(key) ) {
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
		
		if(transactionChecker != null && (changed || consumer == null)) {
			stopTransactionCheckListener(executor, consumer);
			ConsumerConfig cfg = new ConsumerConfig(kafkaProps);
			consumer = Consumer.createJavaConsumerConnector(cfg);
			startTransactionCheckListener();
		}
	}
	
	public void startTransactionCheckListener() {
		if(log.isInfoEnabled()) {
			log.info("start TransactionCheckListener...");
		}
		if(checkerTopic == null) {
			return;
		}
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		topicMap.put(checkerTopic, checkerThreadNum);
		Map<String, List<KafkaStream<String,TransactionContext>>> topicMessageStreams = 
				consumer.createMessageStreams(topicMap, new StringDecoder(null), new ContextDecoder(null));
		executor = Executors.newFixedThreadPool(checkerThreadNum);
		List<KafkaStream<String,TransactionContext>> streams = topicMessageStreams.get(checkerTopic);
		int i=0;
		for(final KafkaStream<String,TransactionContext> stream : streams) {				
			executor.execute(new TransactionCheckProcessor(i, stream, publisher, 
					transactionTopic, transactionChecker));
			i++;
		}
	}
	
	public void stopTransactionCheckListener(ExecutorService oldExecutor, ConsumerConnector oldConsumer) {
		if(log.isInfoEnabled()) {
			log.info("stop TransactionCheckListener...");
		}
		if(oldConsumer != null) {
			if(log.isDebugEnabled()) {
				log.debug("old consumer is closed: {}", oldConsumer);
			}
			oldConsumer.shutdown();
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
				e.printStackTrace();
			}
			if(log.isDebugEnabled()) {
				log.debug("old executor is closed: {}", oldExecutor);
			}
		}
	}
	
//	public Object startTransaction(TransactionContext context, TransactionCallback callback) {
//		return this.startTransaction(context, callback, null, null);
//	}
	
	public Object startTransaction(TransactionContext context, TransactionCallback callback){//, String distributeTableName, String distributeId) {
		if(context == null) {
			log.error("transaction context is null");
			return null;
		}
		long id = sequence.nextValue();
		context.setTransactionId(id);
		context.setStartTime(System.currentTimeMillis());
		context.setFinishTime(0l);
		context.setStatus(TransactionContext.TRANSACTION_STATUS_NEW);
//		context.setDistributeId(distributeId);
//		context.setDistributeTableName(distributeTableName);
		KeyedMessage<String, TransactionContext> transactionMessage = 
				new KeyedMessage<String, TransactionContext>(transactionTopic,String.valueOf(id), context);
		if(log.isInfoEnabled()) {
			log.info("initiate new transaction: {}", context.getTransactionId());
		}
//		if(this.transactionChecker != null && distributeTableName != null && distributeId != null) {
//			this.transactionChecker.saveTransaction(context);
//		}
		if(!publisher.publish(transactionMessage)) {
			log.error("publish transaction failed: {} new status:{}",context.getTransactionId(), context.getStatus());
			return null;
		}
		TransactionStatus status = new TransactionStatus();
		Object result = callback.doInTransaction(status);	
//		if(this.transactionChecker != null && distributeTableName != null && distributeId != null) {
//			this.transactionChecker.updateTransaction(context);
//		}
		if(status.isRollbackOnly()) {
			context.setStatus(TransactionContext.TRANSACTION_STATUS_ROLLBACK);
			transactionMessage = new KeyedMessage<String, TransactionContext>(transactionTopic,
					String.valueOf(id), context);
			if(!publisher.publish(transactionMessage)) {
				log.error("publish transaction failed: {} new status:{}",context.getTransactionId(), context.getStatus());
				return null;
			}
		}else {
			context.setStatus(TransactionContext.TRANSACTION_STATUS_COMMIT);
			transactionMessage = new KeyedMessage<String, TransactionContext>(transactionTopic,
					String.valueOf(id), context);
			if(!publisher.publish(transactionMessage)) {
				log.error("publish transaction failed: {} new status:{}",context.getTransactionId(), context.getStatus());
				return null;
			}
		}
		return result;
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

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}
	
}


class TransactionCheckProcessor implements Runnable {
	public static final Logger log = LoggerFactory.getLogger(TransactionCheckProcessor.class);
	
	private String checkerName = null;
	
	private KafkaStream<String, TransactionContext> stream = null;	
	TransactionPublisher publisher = null;
	
	private String transactionManagerTopic = null;
	TransactionChecker transactionChecker;
	
	public TransactionCheckProcessor(int checkerId, KafkaStream<String, TransactionContext> stream, 
			TransactionPublisher publisher, String transactionManagerTopic, TransactionChecker transactionChecker) {
		this.checkerName = "TransactionCheckProcessor " + checkerId;
		this.stream = stream;
		this.publisher = publisher;
		this.transactionManagerTopic = transactionManagerTopic;
		this.transactionChecker = transactionChecker;
		if(log.isInfoEnabled()) {
			log.info(this.checkerName + " started");
		}
	}
	public void run() {
		ConsumerIterator<String, TransactionContext> it = stream.iterator();
		TransactionContext msg = null;
		while(it.hasNext() ) {
			try {
				msg = it.next().message();
				if(log.isDebugEnabled()) {
					log.debug("{} check transaction:{}",checkerName, msg.toString());
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
				KeyedMessage<String, TransactionContext> transactionMessage = 
						new KeyedMessage<String, TransactionContext>(transactionManagerTopic,
								String.valueOf(msg.getTransactionId()), msg);
				if(!publisher.publish(transactionMessage)) {
					log.error("publish transaction failed: {} new status:{}",msg.getTransactionId(), msg.getStatus());
				}
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			} catch (Error e) {
				log.error(e.getMessage(),e);
			}			
		}
		if(log.isInfoEnabled()) {
			log.info("{} is stopped", checkerName);
		}
	}

}
