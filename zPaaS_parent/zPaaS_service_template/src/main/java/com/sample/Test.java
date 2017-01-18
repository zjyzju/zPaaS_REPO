package com.sample;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.po.Transaction;
import com.sample.service.TransactionSVC;
import com.zpaas.cache.local.LocalCacheSVC;
import com.zpaas.cache.remote.RemoteCacheSVC;
import com.zpaas.file.FileManagerSVC;
import com.zpaas.log.LogSVC;
import com.zpaas.message.MessageSender;
import com.zpaas.rule.RuleSVC;
import com.zpaas.security.cipher.CipherSVC;
import com.zpaas.security.signature.SignatureSVC;
import com.zpaas.security.signature.SignatureSVCManager;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//交易日志服务
		LogSVC tradeLogSVC = (LogSVC) PaasContextHolder.getContext().getBean("tradeLogSVC");
		tradeLogSVC.write("{\"info\":\"trade_log_test\"}");
		
		//文件服务，机密文件服务（secureFileSVC）
		FileManagerSVC fileSVC = (FileManagerSVC)PaasContextHolder.getContext().getBean("fileSVC");
		String fileId = fileSVC.saveFile("/Users/ZhangJunyong/Downloads/云嘉LOGO.png", "png");
		fileSVC.readFile(fileId, "/Users/ZhangJunyong/Downloads/云嘉LOGO_bak.png");
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
		
		//签名验签服务
		SignatureSVC sign = (SignatureSVC)PaasContextHolder.getContext().getBean("signatureSVC");
		String signText = sign.sign("plainText");
		System.out.println("signText:" + signText);
		System.out.println("verify result:" + sign.verifySignature(signText, "plainText"));
		
		SignatureSVCManager signMgr = (SignatureSVCManager)PaasContextHolder.getContext().getBean("signatureMgr");
		String signText1 = signMgr.sign("plainTextMgr",1001002L);
		System.out.println("signText(plainTextMgr):" + signText1);
		System.out.println("verify result(plainTextMgr):" + sign.verifySignature(signText1, "plainTextMgr"));
		
		//消息服务
		MessageSender messageSender = (MessageSender)PaasContextHolder.getContext().getBean("messageSender");
		messageSender.sendMessage("test message", "message-topic");
		
		//规则服务
		RuleSVC rule = (RuleSVC) PaasContextHolder.getContext().getBean("zpaasRule");
		Transaction transaction = new Transaction();
		transaction.setName("tx");
		transaction.setParticipantNum(0);
		transaction.setParticipants("participant01");
		rule.executeRule(transaction);
		System.out.println("ruel test 0:" + transaction.getParticipants());
		transaction.setParticipantNum(1);
		transaction.setParticipants("participant01");
		rule.executeRule(transaction);
		System.out.println("ruel test 1:" + transaction.getParticipants());
		
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
