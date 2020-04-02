package com.zpaas.message;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;


/**
 * 消息服务-消息解码类
 * @author ZhangJunyong
 *
 */
public class MessageDecoder implements Deserializer<Message> {
	
	

	@Override
	public void close() {
		
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		
	}

	@Override
	public Message deserialize(String arg0, byte[] paramArrayOfByte) {
		try {
			ObjectInputStream  ois = new ObjectInputStream(new ByteArrayInputStream(paramArrayOfByte));
			return (Message)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		Message txMsg = new Message();
		txMsg.setId(1);
		txMsg.setTopic("my-replicated-topic");
		txMsg.setMsg("msg|a"+System.currentTimeMillis());
		MessageEncoder encoder = new MessageEncoder();
		MessageDecoder decoder = new MessageDecoder();
		System.out.println(new String(encoder.serialize("topic", txMsg)));
		System.out.println((decoder.deserialize("topic",encoder.serialize("topic", txMsg))).toString());
		encoder.close();
		decoder.close();
	}
}
