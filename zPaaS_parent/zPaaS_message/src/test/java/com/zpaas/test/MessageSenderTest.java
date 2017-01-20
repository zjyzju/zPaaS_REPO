package com.zpaas.test;

import com.zpaas.message.MessageSender;
import com.zpaas.utils.PaasContextHolder;

public class MessageSenderTest {
	
	public static void main(String[] args) {
//		MessageSender sender = (MessageSender) PaasContextHolder.getContext().getBean("messageSender");
//		sender.sendMessage("test", "message-topic");
		
		MessageSender sender = (MessageSender) PaasContextHolder.getContext().getBean("messageSenderV2");
		sender.sendMessage("test", "test");
		System.out.println("send message");
		for(int i=0; i<10; i++) {
			MessageThread t = new MessageThread(String.valueOf(i), sender);
			t.start();
		}
	}

}


class MessageThread extends Thread {
	private String id;
	private MessageSender sender;
	
	public MessageThread(String id, MessageSender sender) {
		this.id = id;
		this.sender = sender;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			sender.sendMessage("thread " + id + ": test" + i, "test");
			System.out.println("send message:" + "thread " + id + ": test" + i);
		}
	}
}