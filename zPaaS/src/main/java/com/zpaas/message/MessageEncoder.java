package com.zpaas.message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

/**
 * 消息服务-消息编码类
 * @author ZhangJunyong
 *
 */
public class MessageEncoder implements Encoder<Message> {
	
	public MessageEncoder(VerifiableProperties props) {
		
	}

	public byte[] toBytes(Message msg) {
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
