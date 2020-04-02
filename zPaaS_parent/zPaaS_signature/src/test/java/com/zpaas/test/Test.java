package com.zpaas.test;



import com.zpaas.security.signature.SignatureSVC;
import com.zpaas.security.signature.SignatureSVCManager;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//签名验签服务
		SignatureSVC sign = (SignatureSVC)PaasContextHolder.getContext().getBean("signatureSVC");
		String signText = sign.sign("plainText");
		System.out.println("signText:" + signText);
		System.out.println("verify result:" + sign.verifySignature(signText, "plainText"));
		
		SignatureSVCManager signMgr = (SignatureSVCManager)PaasContextHolder.getContext().getBean("signatureMgr");
		String signText1 = signMgr.sign("plainTextMgr",1001002L);
		System.out.println("signText(plainTextMgr):" + signText1);
		System.out.println("verify result(plainTextMgr):" + sign.verifySignature(signText1, "plainTextMgr"));
	}
}
