package com.zpaas.dtx.common;

import java.util.Iterator;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;

import net.sf.json.JSONObject;

public class TransactionPublisher implements ConfigurationWatcher {
	public static final Logger log = LoggerFactory.getLogger(TransactionPublisher.class);

	private String confPath = "/com/zpaas/tx/transactionPublisher";

	private ConfigurationCenter cc = null;

	private Producer<String, TransactionContext> producer = null;

	private Properties props = null;

	public void init() {
		if (log.isInfoEnabled()) {
			log.info("init TransactionPublisher...");
		}
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			e.printStackTrace();
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new TransactionPublisher configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		@SuppressWarnings("rawtypes")
		Iterator keys = json.keys();
		boolean changed = false;
		if (keys != null) {
			String key = null;
			while (keys.hasNext()) {
				key = (String) keys.next();

				if (props == null) {
					props = new Properties();
					changed = true;
				}
				if (props.containsKey(key)) {
					if (props.get(key) == null
							|| !props.get(key).equals(json.getString(key))) {
						props.put(key, json.getString(key));
						changed = true;
					}
				} else {
					props.put(key, json.getString(key));
					changed = true;
				}
			}
		}
		if (changed) {
			producer = new KafkaProducer<String, TransactionContext>(props);
		}
	}
	
	public boolean publish(ProducerRecord<String, TransactionContext> transactionMessage) {
		if(producer == null) {
			return false;
		}
		try {
			producer.send(transactionMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception:" + e);
			return false;
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

	public Producer<String, TransactionContext> getProducer() {
		return producer;
	}

	public void setProducer(Producer<String, TransactionContext> producer) {
		this.producer = producer;
	}
}
