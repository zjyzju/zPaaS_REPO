package com.zpaas.dtx.common;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class ContextPartitioner implements Partitioner {

	public ContextPartitioner(VerifiableProperties props) {
		
	}
	
	public int partition(Object id, int partitionNumber) {
		long key = Long.parseLong(id.toString());
		return (int)key%partitionNumber;
	}
	
	
}
