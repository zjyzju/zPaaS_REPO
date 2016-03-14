package com.zpaas.message.v1;

import org.apache.log4j.Logger;

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
	public static final Logger log = Logger.getLogger(MessageProcessor.class);
	
	private String threadName = null;
	private KafkaStream<String, Message> stream = null;
	private MessageListener listener = null;
	
	public MessageProcessor(int threadId, KafkaStream<String, Message> stream, MessageListener listener) {
		this.threadName = "MessageProcessor " + threadId;
		this.stream = stream;
		this.listener = listener;
		if(log.isInfoEnabled()) {
			log.info(this.threadName + " started");
		}
	}
	public void run() {
		ConsumerIterator<String, Message> it = stream.iterator();
		Message msg = null;
		while(it.hasNext() ) {
			try {
				msg = it.next().message();
				if(log.isDebugEnabled()) {
					log.debug(threadName + " process msg:" + msg.toString());
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
		if(log.isInfoEnabled()) {
			log.info(threadName + " is stopped");
		}
	}

}
