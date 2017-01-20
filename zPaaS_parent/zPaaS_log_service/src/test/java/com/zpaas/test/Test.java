package com.zpaas.test;



import com.zpaas.log.LogSVC;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//交易日志服务
		LogSVC tradeLogSVC = (LogSVC) PaasContextHolder.getContext().getBean("tradeLogSVC");
		tradeLogSVC.write("{\"info\":\"trade_log_test\"}");
	}
}
