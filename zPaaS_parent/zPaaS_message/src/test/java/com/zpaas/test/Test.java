package com.zpaas.test;



import com.zpaas.message.MessageSender;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//消息服务
		MessageSender messageSender = (MessageSender)PaasContextHolder.getContext().getBean("messageSender");
		messageSender.sendMessage("test message", "message-topic");
	}
}
