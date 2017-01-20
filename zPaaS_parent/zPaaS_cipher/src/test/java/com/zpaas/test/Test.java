package com.zpaas.test;



import com.zpaas.security.cipher.CipherSVC;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//加密服务
		CipherSVC desCipher = (CipherSVC) PaasContextHolder.getContext().getBean("desCipherSVC");
		String encyptedText = desCipher.encrypt("plainText");
		System.out.println(desCipher.decrypt(encyptedText));
	}
}
