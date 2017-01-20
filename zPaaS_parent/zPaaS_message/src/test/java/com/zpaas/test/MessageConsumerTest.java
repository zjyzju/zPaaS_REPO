package com.zpaas.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageConsumerTest {
	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "clientListenerContext.xml" });
		ctx.getId();
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
