package com.zpaas.utils;

import java.util.Random;

/**
 * 字符串工具类
 * @author ZhangJunyong
 *
 */
public class StringUtil {

    public static boolean isBlank(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }
    
    public static boolean isEmpty(Object obj) {
		if(obj == null || obj.toString().length() == 0){
			return true;
		}
		return false;
	}
    
    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static String restrictLength(String strSrc, int iMaxLength) {
        if (strSrc == null) {
            return null;
        }
        if (iMaxLength <= 0) {
            return strSrc;
        }
        String strResult = strSrc;
        byte[] b = null;
        int iLength = strSrc.length();
        if (iLength > iMaxLength) {
            strResult = strResult.substring(0, iMaxLength);
            iLength = iMaxLength;
        }
        while (true) {
            b = strResult.getBytes();
            if (b.length <= iMaxLength) {
                break;
            }
            iLength--;
            strResult = strResult.substring(0, iLength);
        }
        return strResult;
    }
    
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random  random = new Random();
        StringBuffer buf = new StringBuffer();
        
        for(int i = 0 ;i < length ; i ++)
        {
         int num = random.nextInt(str.length());
         buf.append(str.charAt(num));
        }
        
        return buf.toString();
    }
	
	/**
	 * 左补齐
	 * @param target 目标字符串
	 * @param fix 补齐字符
	 * @param length 目标长度
	 * @return
	 */
	public static String lPad(String target, String fix, int length){
		if(target==null || fix ==null || !(target.length()<length))
			return target;
		StringBuffer newStr = new StringBuffer();
		for(int i=0; i<length-target.length(); i++){
			newStr.append(fix);
		}
		return newStr.append(target).toString();
	}
	
	/**
	 * 右补齐
	 * @param target 目标字符串
	 * @param fix 补齐字符
	 * @param length 目标长度
	 * @return
	 */
	public static String rPad(String target, String fix, int length){
		if(target==null || fix ==null || !(target.length()<length))
			return target;
		StringBuffer newStr = new StringBuffer();
		newStr.append(target);
		for(int i=0; i<length-target.length(); i++){
			newStr.append(fix);
		}
		return newStr.toString();
	}
	
	/**
	 * 字符串数据join操作
	 * @param strs
	 * @param spi
	 * @return
	 * @author 
	 */
	public static String join(String[] strs, String spi){
		StringBuffer buf = new StringBuffer();
		int step = 0;
		for(String str : strs){
			buf.append(str);
			if (step ++ < strs.length - 1)
				buf.append(spi);
		}
		return buf.toString();
	}
    
    public static void main(String[] args) {
        
    }
}
