package com.zpaas.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 命令执行工具类
 * @author ZhangJunyong
 *
 */
public class CommandUtil {
	public static final Logger log = LoggerFactory.getLogger(CommandUtil.class);
	
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
			log.error(e.getMessage(),e);
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
			log.error(e.getMessage(),e);
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
			log.error(e.getMessage(),e);
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
			log.error(e.getMessage(),e);
			return false;
		}
	}
	
	public static void main(String[] args) {
		String[] cmd = new String[] {
			"ls",
			"-la"
		};
		System.out.println(execCommandForResult(cmd));
	}
}
