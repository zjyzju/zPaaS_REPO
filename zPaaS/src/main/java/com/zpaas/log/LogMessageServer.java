package com.zpaas.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 系统日志服务模块-服务端启动类
 * @author ZhangJunyong
 *
 */
public class LogMessageServer {
	public static void main(String[] args) {
		String conf = "paasServerContext.xml";
		if(args.length > 1) {
			conf = args[0];
		}
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { conf });
		ctx.getBean("messageConsumer");
		while(true) {
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
