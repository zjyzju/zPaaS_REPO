package com.zpaas.test;



import com.zpaas.cache.remote.RemoteCacheSVC;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//远程缓存服务
		RemoteCacheSVC remoteCache = (RemoteCacheSVC)PaasContextHolder.getContext().getBean("remoteCacheSVC");
		remoteCache.addItem("testKey", "testValue");
		System.out.println(remoteCache.getItem("testKey"));
		remoteCache.delItem("testKey");
	}
}
