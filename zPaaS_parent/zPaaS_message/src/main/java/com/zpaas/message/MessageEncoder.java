package com.zpaas.message.v2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.zpaas.message.Message;

/**
 * 消息服务-消息编码类
 * @author ZhangJunyong
 *
 */
public class MessageEncoder implements Serializer<Message> {
	
	@Override
	public void configure(Map<String, ?> prpty, boolean arg1) {
		
	}
	
	public byte[] serialize(String arg0, Message msg) {
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
	
	@Override
	public void close() {
		
	}

}
