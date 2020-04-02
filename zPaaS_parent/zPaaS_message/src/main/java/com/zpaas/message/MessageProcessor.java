package com.zpaas.message.v2;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.message.Message;
import com.zpaas.message.MessageListener;
import com.zpaas.message.MessageStatus;



/**
 * 消息服务-消息处理类
 * @author ZhangJunyong
 *
 */
public class MessageProcessor implements Runnable {
	public static final Logger log = LoggerFactory.getLogger(MessageProcessor.class);
	
	private String threadName = null;
	private KafkaConsumer<String, Message> stream = null;
	private MessageListener listener = null;
	private boolean interrupted = false;
	
	public MessageProcessor(int threadId, KafkaConsumer<String, Message> stream, MessageListener listener) {
		this.threadName = "MessageProcessor " + threadId;
		this.stream = stream;
		this.listener = listener;
		if(log.isInfoEnabled()) {
			log.info("{} started", this.threadName);
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
							log.debug("{} process msg: {} of topic {}", threadName, msg.toString(),record.topic());
						}
						MessageStatus status = new MessageStatus();
						listener.receiveMessage(msg, status);
					} catch (Exception e) {
						e.printStackTrace();
						log.error(e.getMessage(),e);
					}catch (Error e) {
						e.printStackTrace();
						log.error(e.getMessage(),e);
					}
				}
			}
		}
		if(log.isInfoEnabled()) {
			log.info("{} is stopped", threadName);
		}
	}

}
