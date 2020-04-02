package com.zpaas.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	//从请求的referer中获取访问者域名
		public static String getDomainNameFromReferer(HttpServletRequest request){
			String referer=request.getHeader("REFERER");
			if(referer == null) {
				return null;
			}
			String domainName="";
			int beginIndex=referer.indexOf("//")+2;
			int endIndex=referer.indexOf("/",beginIndex);
			domainName=referer.substring(beginIndex, endIndex);
			return domainName;
		}
		//获取浏览器端客户IP地址
		public static String getClientAddr(HttpServletRequest request){
	        String ip = request.getHeader("x-forwarded-for");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("x-real-ip");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
	        return ip;
	    }
}
