package com.zpaas.test;



import com.zpaas.cache.local.LocalCacheSVC;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//本地缓存服务
		LocalCacheSVC localCache = (LocalCacheSVC)PaasContextHolder.getContext().getBean("localCacheSVC");
		System.out.println(localCache.getCacheItemString("appName"));
	}
}
