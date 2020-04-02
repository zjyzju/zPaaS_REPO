package com.zpaas.security.cipher;

/**
 * 加密服务接口类
 * @author ZhangJunyong
 *
 */
public interface CipherSVC {
	public String encrypt(String data);	
	public String decrypt(String data);
}
