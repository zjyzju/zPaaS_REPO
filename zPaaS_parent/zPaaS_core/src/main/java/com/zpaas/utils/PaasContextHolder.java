package com.zpaas.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * zPaaS对象管理类
 * @author ZhangJunyong
 *
 */
public class PaasContextHolder {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "paasContext.xml" });
	
	public static ApplicationContext getContext() {
		return ctx;
	}

}
