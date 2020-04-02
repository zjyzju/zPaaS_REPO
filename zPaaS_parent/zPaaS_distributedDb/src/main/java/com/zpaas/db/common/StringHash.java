package com.zpaas.db.common;

/**
 * 计算String类型对象Hash值的工具类
 * @author zjy
 * @date 2014年6月30日 下午4:51:59 
 * @version V1.0
 */
public class StringHash {
	public static Long valueOf(String key) {
		if(key == null || key.trim().length() == 0) {
			return null;
		}
		int hashCode = key.hashCode();
		return Math.abs((long)hashCode);
	}
	
	public static void main(String[] args) {
		System.out.println(StringHash.valueOf("asr@swy.zj.pcc")%4+1);
		System.out.println(StringHash.valueOf("0771A8")%8+1);
		System.out.println(20140711%16+1);
		System.out.println(100001%8+1);
		
	}
}
