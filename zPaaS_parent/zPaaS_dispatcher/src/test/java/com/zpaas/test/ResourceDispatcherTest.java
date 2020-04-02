package com.zpaas.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceDispatcherTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "dispatcherContext.xml" });
		ctx.getBean("resourceDispatcher");
		while (true) {
			Thread.sleep(100000);
		}
	}

}
