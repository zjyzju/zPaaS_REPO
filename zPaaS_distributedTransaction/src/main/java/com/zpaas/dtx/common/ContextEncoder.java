package com.zpaas.dtx.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

public class ContextEncoder implements Encoder<TransactionContext> {
	
	public ContextEncoder(VerifiableProperties props) {
		
	}

	public byte[] toBytes(TransactionContext msg) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(msg);
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
