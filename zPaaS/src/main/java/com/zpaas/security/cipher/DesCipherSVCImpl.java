package com.zpaas.security.cipher;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.file.FileManagerSVC;
import com.zpaas.utils.CipherUtil;
import com.zpaas.utils.CommonUtil;
import com.zpaas.utils.PaasContextHolder;

/**
 * DES加密服务实现类
 * @author ZhangJunyong
 *
 */
public class DesCipherSVCImpl implements CipherSVC,ConfigurationWatcher {
	
	private static final Logger log = Logger.getLogger(DesCipherSVCImpl.class);
	
	private static final String CIPHER_CFG_FILE_KEY = "cipher.cfg.file";
	public static final String KEY_ALGORITHM = "DES";
	public static final String SECURITY_KEY = "securityKey";
	public static final String CIPHER_ALGORITHM = "cipherAlgorithm";
	public static final byte[] DES_CBC_IV = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
	public static final String DES_ECB_ALGORITHM = "DES/ECB/PKCS5Padding";
	public static final String DES_CBC_ALGORITHM = "DES/CBC/PKCS5Padding";
	public static final String DES_CBC_NOPADDING = "DES/CBC/NoPadding";
	
	private ConfigurationCenter cc = null;
	private String confPath = "/com/zpaas/cipher/desCipherSVC";
	private String cipherCfgFile = null;
	private FileManagerSVC secureFileRepo = null;
	private Key key = null;
	private String cipherAlgorithm = "DES/ECB/PKCS5Padding";
	
	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
			
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public void process(String conf) {
		JSONObject json = JSONObject.fromObject(conf);
		boolean changed = false;
		if(json.getString(CIPHER_CFG_FILE_KEY) != null && !json.getString(CIPHER_CFG_FILE_KEY).equals(cipherCfgFile)) {
			changed = true;
			cipherCfgFile = json.getString(CIPHER_CFG_FILE_KEY);
		}
		if(changed) {
			String tmp = new String(secureFileRepo.readFile(cipherCfgFile));
			JSONObject cipherCfg = JSONObject.fromObject(CipherUtil.decrypt(tmp));
			key = toKey(cipherCfg.getString(SECURITY_KEY).getBytes());
			cipherAlgorithm = cipherCfg.getString(CIPHER_ALGORITHM);
		}
	}
	
	private Key toKey(byte[] key) {
		try {
			DESKeySpec des = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			SecretKey secretKey = keyFactory.generateSecret(des);
			return secretKey;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}

	private byte[] encrypt(byte[] data, String algorithm) {
		try {
			Cipher cipher = Cipher.getInstance(algorithm);
			if(DES_CBC_ALGORITHM.equals(algorithm) || DES_CBC_NOPADDING.equals(algorithm)) {
				IvParameterSpec spec = new IvParameterSpec(DES_CBC_IV);
				cipher.init(Cipher.ENCRYPT_MODE, key, spec);
			}else {
				cipher.init(Cipher.ENCRYPT_MODE, key);
			}
			return cipher.doFinal(data);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}

	private byte[] decrypt(byte[] data, String algorithm) {
		try {
			Cipher cipher = Cipher.getInstance(algorithm);
			if(DES_CBC_ALGORITHM.equals(algorithm) || DES_CBC_NOPADDING.equals(algorithm)) {
				IvParameterSpec spec = new IvParameterSpec(DES_CBC_IV);
				cipher.init(Cipher.DECRYPT_MODE, key,spec);
			}else {
				cipher.init(Cipher.DECRYPT_MODE, key);
			}
			return cipher.doFinal(data);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
	
	public String encrypt(String data) {
		byte[] aa = encrypt(data.getBytes(),cipherAlgorithm);
		return new String(CommonUtil.hex2Ascii(aa));
	}
	
	public String decrypt(String data) {
		byte[] aa = CommonUtil.ascii2Hex(data.getBytes());
		return new String(decrypt(aa,cipherAlgorithm));
	}
	
	public String encrypt(String data, String algorithm) {
		byte[] aa = encrypt(data.getBytes(),algorithm);
		return new String(CommonUtil.hex2Ascii(aa));
	}
	
	public String decrypt(String data, String algorithm) {
		byte[] aa = CommonUtil.ascii2Hex(data.getBytes());
		return new String(decrypt(aa,algorithm));
	}

	public ConfigurationCenter getCc() {
		return cc;
	}

	public void setCc(ConfigurationCenter cc) {
		this.cc = cc;
	}

	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	public FileManagerSVC getSecureFileRepo() {
		return secureFileRepo;
	}

	public void setSecureFileRepo(FileManagerSVC secureFileRepo) {
		this.secureFileRepo = secureFileRepo;
	}

	
	public static void main(String[] args) throws Exception{
		String param1 = null;
		String param2 = null;
		if(args != null && args.length > 1) {
			param1 = args[0];
			param2 = args[1];
		}else if(args != null && args.length <= 1) {
			param1 = "-encrypt";
			param2 = args[0];
		}else {
			return;
		}
		if(!param1.equals("-encrypt") && !param1.equals("-decrypt")) {
			System.out.println("invalid mode:" + param1);
		}
		if(param2 == null || param2.length() == 0) {
			return;
		}
		CipherSVC cipher = (CipherSVC)PaasContextHolder.getContext().getBean("desCipher");
		if(param1.equals("-encrypt")) {
			String aa = cipher.encrypt(param2);
			System.out.println(aa);
		}else {
			System.out.println(cipher.decrypt(param2));
		}
	}
}
