package com.zpaas.message;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;

/**
 * 消息服务-消息解码类
 * @author ZhangJunyong
 *
 */
public class MessageDecoder implements Decoder<Message> {
	
	public MessageDecoder(VerifiableProperties props) {
		
	}
	
	public Message fromBytes(byte[] paramArrayOfByte) {
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
		System.out.println(new String((new MessageEncoder(null)).toBytes(txMsg)));
		System.out.println(((new MessageDecoder(null)).fromBytes((new MessageEncoder(null)).toBytes(txMsg))).toString());
	}
}
