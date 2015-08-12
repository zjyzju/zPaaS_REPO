package com.zpaas.message;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * 消息服务-消息分区类
 * @author ZhangJunyong
 *
 */
public class MessageIdPartitioner implements Partitioner {

	public MessageIdPartitioner(VerifiableProperties props) {
		
	}
	
	public int partition(Object id, int partitionNumber) {
		long key = Long.parseLong(id.toString());
		return (int)key%partitionNumber;
	}
	
	
}
