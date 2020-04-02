package com.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpaas.message.Message;
import com.zpaas.message.MessageConsumer;
import com.zpaas.message.MessageListener;
import com.zpaas.message.MessageStatus;

/**
 * 消息监听示例类
 * @author ZhangJunyong
 *
 */
public class MessageListenerSample implements MessageListener {

	public void receiveMessage(Message message, MessageStatus status) {
		System.out.println(message.getMsg());
	}
	
	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "messageConsumerContext.xml" });
		MessageConsumer server = (MessageConsumer)ctx.getBean("messageConsumer");
		while(true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				//  Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
