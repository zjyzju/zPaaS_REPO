package com.distribute.tx.test;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.zpaas.db.common.StringHash;
import com.zpaas.utils.Md5Util;

public class Test {
	public static void main(String[] args) {
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("fileManager");
//		System.out.println(manager.saveFile("/Volumes/HD/ec_workspace/distributedTransactionPrj/config/distributedRule.xml", "xml"));
		
//		String orign = "transaction";
//		String aa = CiperTools.encrypt(orign);
//		System.out.println("aa:" + aa);
//		String bb = CiperTools.decrypt(aa);
//		System.out.println("bb:" + bb);
		
		System.out.println(StringHash.valueOf("1502150000000122")%16+1);
		System.out.println(14001%16+1);
		System.out.println(new Date(1431831378725l));
		try {
			String gbk = new String("工".getBytes("GBK"),"GBK");
			System.out.println(gbk);
			System.out.println(new String(gbk.getBytes("GBK")));
			
			gbk = "我来了";  
		    String iso = new String(gbk.getBytes("UTF-8"),"ISO-8859-1");  
		    for (byte b : iso.getBytes("ISO-8859-1")) {  
		        System.out.println(b + " ");  
		    }  
		    //
		    //String str ="appId=wxab924fec4c1cb366&nonceStr=GdITl1jjqbLXXvfZ&package=Sign=WXPay&partnerId=1251798701&prepayId=wx201507101616014c48b0ba040902630603&timeStamp=1436516159&key=B556vrsAxEMf9udOJiu0o95vvV4fT40d";
		    String str ="appid=wxab924fec4c1cb366&noncestr=GdITl1jjqbLXXvfZ&package=Sign=WXPay&partnerid=1251798701&prepayid=wx201507101616014c48b0ba040902630603&timestamp=1436516159&key=B556vrsAxEMf9udOJiu0o95vvV4fT40d";
		    
		    System.out.println(Md5Util.encode(str));  
		  
		    //模拟UTF-8编码的网站显示  
		    System.out.println(new String(iso.getBytes("ISO-8859-1"),"UTF-8"));  
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
