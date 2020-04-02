package com.zpaas.dtx.common;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

public class ContextPartitioner implements Partitioner {

	
	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
		int numPartitions = partitions.size();
		int partitionNum = 0;
		try {
			partitionNum = Integer.parseInt((String) key);
		} catch (Exception e) {
			partitionNum = key.hashCode();
		}
		return Math.abs(partitionNum % numPartitions);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	
}
