package com.zpaas.dtx.common;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import org.apache.kafka.common.serialization.Deserializer;

public class ContextDecoder implements Deserializer<TransactionContext> {
	
	@Override
	public TransactionContext deserialize(String topic, byte[] data) {
		try {
			ObjectInputStream  ois = new ObjectInputStream(new ByteArrayInputStream(data));
			return (TransactionContext)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
