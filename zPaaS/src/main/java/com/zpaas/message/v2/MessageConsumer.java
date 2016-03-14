package com.zpaas.message.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONObject;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.message.Message;
import com.zpaas.message.MessageListener;


/**
 * 消息服务-消息消费类
 * @author ZhangJunyong
 *
 */
public class MessageConsumer implements ConfigurationWatcher{
	public static final Logger log = Logger.getLogger(MessageConsumer.class);
	
	private String confPath = "/com/zpaas/message/messageConsumer";
	private static final String MSG_PROCESSOR_NUM = "msg.processor.num";
	
	private ConfigurationCenter cc = null;
	
	private MessageListener listener = null;
	
	private List<KafkaConsumer<String, Message>> consumers = null;
	private ExecutorService executor = null;
	private ArrayList<String> monitorTopicList = null;
	private String groupId = null;
	

	private int nThreads = 1;	
	private Properties props = null;
	
	public MessageConsumer() {
		if(log.isInfoEnabled()) {
			log.info("starting MessageConsumer...");
		}
	}
	
	public void init() {
		if(log.isInfoEnabled()) {
			log.info("init MessageConsumer...");
		}
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			e.printStackTrace();
		}
	}
	
	public void process(String conf) {
		if(log.isInfoEnabled()) {
			log.info("new MessageConsumer configuration is received: " + conf);
		}
		
		JSONObject json = JSONObject.fromObject(conf);
		@SuppressWarnings("rawtypes")
		Iterator keys = json.keys();
		boolean threadNumChanged = false;
		boolean changed = false;
		if(props == null) {
			props = new Properties();
			changed = true;
		}
		props.put("group.id", groupId);
		if(keys != null) {
			String key = null;
			while(keys.hasNext()) {
				key = (String)keys.next();
				if(MSG_PROCESSOR_NUM.equals(key)) {
					nThreads = json.getInt(key);
				}else{
					if(props.containsKey(key)) {
						if(props.get(key) == null || !props.get(key).equals(json.getString(key))) {
							props.put(key, json.getString(key));
							changed = true;
						}
					}else {
						props.put(key, json.getString(key));
						changed = true;
					}
				}
			}
		}
		if(changed || threadNumChanged) {
			stopConsumeMessage(executor, consumers);
			consumers = new ArrayList<>();
			if(monitorTopicList != null && monitorTopicList.size() > 0 && nThreads > 0) {
				for(int i=0; i<nThreads; i++) {
					consumers.add(new KafkaConsumer<String, Message>(props));
				}
				startConsumeMessage();
			}
			
		}
	}
	
	public void startConsumeMessage() {
		if(log.isInfoEnabled()) {
			log.info("start consume message...");
		}
		if(monitorTopicList == null || monitorTopicList.size() == 0) {
			return;
		}
		
		executor = Executors.newFixedThreadPool(nThreads);
		int i=0;
		for(KafkaConsumer<String, Message> consumer : consumers) {
			consumer.subscribe(monitorTopicList);
			executor.execute(new MessageProcessor(i, consumer, listener));
			i++;
		}
		
	}
	
	public void stopConsumeMessage(ExecutorService oldExecutor, List<KafkaConsumer<String, Message>> oldConsumers) {
		if(log.isInfoEnabled()) {
			log.info("stop consume message...");
		}
		if(oldConsumers != null) {
			if(log.isInfoEnabled()) {
				log.info("old consumer is closed: " + oldConsumers);
			}
			for(KafkaConsumer<String, Message> consumer : oldConsumers) {
				consumer.close();
			}
		}
		if(oldExecutor != null) {
			if(log.isInfoEnabled()) {
				log.info("begin to close old executor: " + oldExecutor);
			}
			oldExecutor.shutdown();
			try {
				while(!oldExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
					if(log.isInfoEnabled()) {
						log.info("old executor is not closed: " + oldExecutor);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(log.isInfoEnabled()) {
				log.info("old executor is closed: " + oldExecutor);
			}
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

	public MessageListener getListener() {
		return listener;
	}

	public void setListener(MessageListener listener) {
		this.listener = listener;
	}
	
	public ArrayList<String> getMonitorTopicList() {
		return monitorTopicList;
	}

	public void setMonitorTopicList(ArrayList<String> monitorTopicList) {
		this.monitorTopicList = monitorTopicList;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


}


