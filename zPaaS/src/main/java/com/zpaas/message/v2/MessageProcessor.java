package com.zpaas.message.v2;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;

import com.zpaas.message.Message;
import com.zpaas.message.MessageListener;
import com.zpaas.message.MessageStatus;



/**
 * 消息服务-消息处理类
 * @author ZhangJunyong
 *
 */
public class MessageProcessor implements Runnable {
	public static final Logger log = Logger.getLogger(MessageProcessor.class);
	
	private String threadName = null;
	private KafkaConsumer<String, Message> stream = null;
	private MessageListener listener = null;
	private boolean interrupted = false;
	
	public MessageProcessor(int threadId, KafkaConsumer<String, Message> stream, MessageListener listener) {
		this.threadName = "MessageProcessor " + threadId;
		this.stream = stream;
		this.listener = listener;
		if(log.isInfoEnabled()) {
			log.info(this.threadName + " started");
		}
	}
	
	public void stop() {
		this.interrupted = true;
	}
	
	public void run() {
		Message msg = null;
		while(!interrupted) {
			ConsumerRecords<String, Message> records = stream.poll(100);			
			if(records != null && !records.isEmpty()) {
				for(ConsumerRecord<String, Message> record : records) {
					try {
						msg = record.value();
						if(log.isDebugEnabled()) {
							log.debug(threadName + " process msg:" + msg.toString() + " of topic " + record.topic());
						}
						MessageStatus status = new MessageStatus();
						listener.receiveMessage(msg, status);
					} catch (Exception e) {
						e.printStackTrace();
						log.error("exception:" + e);
					}catch (Error e) {
						e.printStackTrace();
						log.error("exception:" + e);
					}
				}
			}
		}
		if(log.isInfoEnabled()) {
			log.info(threadName + " is stopped");
		}
	}

}
