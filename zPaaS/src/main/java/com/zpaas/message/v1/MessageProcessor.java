package com.zpaas.message.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.message.Message;
import com.zpaas.message.MessageListener;
import com.zpaas.message.MessageStatus;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;


/**
 * 消息服务-消息处理类
 * @author ZhangJunyong
 *
 */
public class MessageProcessor implements Runnable {
	public static final Logger log = LoggerFactory.getLogger(MessageProcessor.class);
	
	private String threadName = null;
	private KafkaStream<String, Message> stream = null;
	private MessageListener listener = null;
	
	public MessageProcessor(int threadId, KafkaStream<String, Message> stream, MessageListener listener) {
		this.threadName = "MessageProcessor " + threadId;
		this.stream = stream;
		this.listener = listener;
		if(log.isInfoEnabled()) {
			log.info("{} started", this.threadName);
		}
	}
	public void run() {
		ConsumerIterator<String, Message> it = stream.iterator();
		Message msg = null;
		while(it.hasNext() ) {
			try {
				msg = it.next().message();
				if(log.isDebugEnabled()) {
					log.debug("{} process msg: {}",threadName, msg.toString());
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
		if(log.isInfoEnabled()) {
			log.info("{} is stopped", threadName);
		}
	}

}
