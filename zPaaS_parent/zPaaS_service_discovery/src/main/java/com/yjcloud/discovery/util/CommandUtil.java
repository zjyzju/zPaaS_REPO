package com.yjcloud.discovery.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

/**
 * 命令执行工具类
 * @author ZhangJunyong
 *
 */
public class CommandUtil {
	public static final Logger log = Logger.getLogger(CommandUtil.class);
	
	public static String execCommandForResult(String[] cmd) {
		if(log.isDebugEnabled()) {
			String cmdStr = "";
			for(int i=0; i<cmd.length; i++) {
				cmdStr = cmdStr + " " + cmd[i];
			}
			log.debug(cmdStr);
		}
		try {
			Process process = Runtime.getRuntime().exec(cmd);	
			StringBuffer sb = new StringBuffer();
			if(process.waitFor() == 0) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String tmp = null;
				while((tmp = reader.readLine()) != null) {
					sb.append(tmp).append("\n");
				}
			}else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String tmp = null;
				while((tmp = reader.readLine()) != null) {
					sb.append(tmp).append("\n");
				}
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getStackTrace());
			return null;
		}
	}
	
	public static String execCommandForResult(String cmd) {
		if(log.isDebugEnabled()) {
			log.debug(cmd);
		}
		try {
			Process process = Runtime.getRuntime().exec(cmd);	
			StringBuffer sb = new StringBuffer();
			if(process.waitFor() == 0) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String tmp = null;
				while((tmp = reader.readLine()) != null) {
					sb.append(tmp).append("\n");
				}
			}else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String tmp = null;
				while((tmp = reader.readLine()) != null) {
					sb.append(tmp).append("\n");
				}
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getStackTrace());
			return null;
		}
	}
	
	public static boolean execCommand(String[] cmd) {
		if(log.isDebugEnabled()) {
			String cmdStr = "";
			for(int i=0; i<cmd.length; i++) {
				cmdStr = cmdStr + " " + cmd[i];
			}
			log.debug(cmdStr);
		}
		try {
			Process process = Runtime.getRuntime().exec(cmd);	

			if(process.waitFor() == 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getStackTrace());
			return false;
		}
	}
	
	public static boolean execCommand(String cmd) {
		if(log.isDebugEnabled()) {
			log.debug(cmd);
		}
		try {
			Process process = Runtime.getRuntime().exec(cmd);	
			if(process.waitFor() == 0) {
				return true;
			}else {
				return false;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getStackTrace());
			return false;
		}
	}
	
	public static String getDockerContainerHostPort(String cmd, String port) {
		try {
			Process process = Runtime.getRuntime().exec(cmd);	
			StringBuffer sb = new StringBuffer();
			if(process.waitFor() == 0) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String tmp = null;
				int i=0;
				while((tmp = reader.readLine()) != null) {
					i++;
					if(i <= 5) {
						continue;
					}
					sb.append(tmp).append("\n");
				}
				JSONObject json = JSONObject.fromObject(sb.toString());
				return ((JSONObject)json.getJSONObject("NetworkSettings").getJSONObject("Ports").getJSONArray(port + "/tcp").get(0)).getString("HostPort");
			}else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String tmp = null;
				while((tmp = reader.readLine()) != null) {
					sb.append(tmp).append("\n");
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		String[] cmd = new String[] {
			"ps -ef | grep \"haproxy\" | grep -v \"grep\" | awk '{print $2}'",
		};
		System.out.println("result:" + execCommandForResult(cmd));
	}
}
