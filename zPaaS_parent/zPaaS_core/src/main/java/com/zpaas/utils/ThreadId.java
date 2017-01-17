package com.zpaas.utils;

import java.util.UUID;

/**
 * ThreadId工具类
 * @author ZhangJunyong
 *
 */
public class ThreadId {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public static String getThreadId() {
		if(threadLocal.get() == null) {
			threadLocal.set(String.valueOf(UUID.randomUUID().getLeastSignificantBits()));
		}
		return threadLocal.get();
	}
	
	public static void setThreadId(String threadId) {
		threadLocal.set(threadId);
	}
	
	public static void setThreadIdWithIP(String ip) {
		threadLocal.set(ip + ":" + UUID.randomUUID().getLeastSignificantBits());
	}
}
