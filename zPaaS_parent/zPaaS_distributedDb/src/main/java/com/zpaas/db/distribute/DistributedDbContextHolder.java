package com.zpaas.db.distribute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DistributedDbContextHolder {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "distributedDbContext.xml" });
	
	public static ApplicationContext getContext() {
		return ctx;
	}

}
