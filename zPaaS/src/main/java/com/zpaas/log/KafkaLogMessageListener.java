package com.zpaas.log;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.zpaas.message.Message;
import com.zpaas.message.MessageListener;
import com.zpaas.message.MessageStatus;

/**
 * 系统日志服务模块-kafka消息监听器
 * @author ZhangJunyong
 *
 */
public class KafkaLogMessageListener implements MessageListener {
	private static final Logger log = Logger.getLogger(KafkaLogMessageListener.class);
	
	private String logTopic = "paas_log_mongo_topic";
	private LogSVC logWriter = null;
	
	public void receiveMessage(Message message, MessageStatus status) {
		try {
			if(logTopic.equals(message.getTopic())) {
				if(log.isDebugEnabled()) {
					log.debug("get log message: " + message.getMsg());
				}
				logWriter.write(JSONObject.fromObject(message.getMsg()));
			}
		} catch (Exception e) {
			System.out.println("exception:" + e);
			if(logTopic.equals(message.getTopic())) {
				if(message.getMsg() != null) {
					log.error("process message failed: " + e + " message:" +  message.getMsg());				
					logWriter.write(message.getMsg().toString());
				}
			}
		}catch (Error e) {
			System.out.println("process message failed: " + e + " message:" +  message.getMsg());
			if(logTopic.equals(message.getTopic())) {
				if(message.getMsg() != null) {
					log.error("process message failed: " + e + " message:" +  message.getMsg());				
					logWriter.write(message.getMsg().toString());
				}
			}
		}
	}

	public String getLogTopic() {
		return logTopic;
	}

	public void setLogTopic(String logTopic) {
		this.logTopic = logTopic;
	}

	public LogSVC getLogWriter() {
		return logWriter;
	}

	public void setLogWriter(LogSVC logWriter) {
		this.logWriter = logWriter;
	}
	
	
}
