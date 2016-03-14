package com.zpaas.message.v2;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.log4j.Logger;

public class LongPartitioner implements Partitioner {
	public static final Logger log = Logger.getLogger(LongPartitioner.class);

	@Override
	public void configure(Map<String, ?> arg0) {
		
	}

	@Override
	public void close() {
		
	}

	@Override
	public int partition(String topic, Object key, byte[] keyByte, Object value, byte[] valueByte, Cluster cluster) {
		if(key == null) {
			return 0;
		}
		try {
			long id = Long.parseLong(key.toString());
			return (int)id%cluster.partitionCountForTopic(topic);
		} catch (NumberFormatException e) {
			log.error(e.getMessage(),e);
			return 0;
		}
		
	}

}
