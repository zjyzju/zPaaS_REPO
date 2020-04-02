package com.zpaas.test;



import com.zpaas.ConfigurationCenter;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//加密服务
		ConfigurationCenter cc = (ConfigurationCenter) PaasContextHolder.getContext().getBean("cc");
		System.out.println(cc.getRunMode());
		while(true) {
			Thread.sleep(1000000l);
		}
	}
}
