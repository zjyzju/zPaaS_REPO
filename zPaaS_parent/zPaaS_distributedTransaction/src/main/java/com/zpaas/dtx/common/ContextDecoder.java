package com.zpaas.dtx.common;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;

public class ContextDecoder implements Decoder<TransactionContext> {
	
	public ContextDecoder(VerifiableProperties props) {
		
	}
	
	public TransactionContext fromBytes(byte[] paramArrayOfByte) {
		try {
			ObjectInputStream  ois = new ObjectInputStream(new ByteArrayInputStream(paramArrayOfByte));
			return (TransactionContext)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		TransactionContext txMsg = new TransactionContext();
		System.out.print(new String((new ContextEncoder(null)).toBytes(txMsg)));
		System.out.print(((new ContextDecoder(null)).fromBytes((new ContextEncoder(null)).toBytes(txMsg))).toString());
	}
}
