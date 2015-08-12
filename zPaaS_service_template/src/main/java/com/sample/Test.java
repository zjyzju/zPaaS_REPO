package com.sample;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sample.po.Transaction;
import com.sample.service.TransactionSVC;
import com.zpaas.cache.local.LocalCacheSVC;
import com.zpaas.cache.remote.RemoteCacheSVC;
import com.zpaas.file.FileManagerSVC;
import com.zpaas.log.LogSVC;
import com.zpaas.security.cipher.CipherSVC;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//交易日志服务
		LogSVC tradeLogSVC = (LogSVC) PaasContextHolder.getContext().getBean("tradeLogSVC");
		tradeLogSVC.write("{\"info\":\"trade_log_test\"}");
		
		//文件服务，机密文件服务（secureFileSVC）
		FileManagerSVC fileSVC = (FileManagerSVC)PaasContextHolder.getContext().getBean("fileSVC");
		String fileId = fileSVC.saveFile("/Users/ZhangJunyong/Downloads/bank.gif", "gif");
		fileSVC.readFile(fileId, "/Users/ZhangJunyong/Downloads/bank_bak.gif");
		fileSVC.deleteFile(fileId);
		
		//远程缓存服务
		RemoteCacheSVC remoteCache = (RemoteCacheSVC)PaasContextHolder.getContext().getBean("remoteCacheSVC");
		remoteCache.addItem("testKey", "testValue");
		System.out.println(remoteCache.getItem("testKey"));
		remoteCache.delItem("testKey");
		
		//本地缓存服务
		LocalCacheSVC localCache = (LocalCacheSVC)PaasContextHolder.getContext().getBean("localCacheSVC");
		System.out.println(localCache.getCacheItemString("appName"));
		
		//加密服务
		CipherSVC desCipher = (CipherSVC) PaasContextHolder.getContext().getBean("desCipherSVC");
		String encyptedText = desCipher.encrypt("plainText");
		System.out.println(desCipher.decrypt(encyptedText));
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		TransactionSVC svc = (TransactionSVC)ctx.getBean("transactionSVC");
		System.out.println(svc.getClass().getName());
		Transaction tx = new Transaction();
		tx.setName("tx");
		tx.setParticipantNum(1);
		tx.setParticipants("participant01");
		String txName = svc.createTransaction(tx);
		tx = svc.queryTransaction(txName);
		System.out.println(tx.toString());
		
		tx = new Transaction();
		tx.setName(txName);
		tx.setParticipantNum(1);
		tx.setParticipants("participant02");
		int count = svc.updateTransaction(tx);
		System.out.println(count + " record updated.");
		
		tx = svc.queryTransaction(txName);
		System.out.println(tx.toString());
		
	}
}
