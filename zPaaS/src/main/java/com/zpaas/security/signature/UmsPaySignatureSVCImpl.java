package com.zpaas.security.signature;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.file.FileManagerSVC;
import com.zpaas.utils.CipherUtil;
import com.zpaas.utils.CommonUtil;

/**
 * 全民付签名服务实现类
 * @author ZhangJunyong
 *
 */
public class UmsPaySignatureSVCImpl implements ConfigurationWatcher, SignatureSVC {
	public static final Logger log = Logger.getLogger(UmsPaySignatureSVCImpl.class);
	
	public static final String PRIVATE_KEY_MOD = "privateKeyMod";
	public static final String PRIVATE_KEY_EXP = "privateKeyExp";
	public static final String PUBLIC_KEY_MOD = "publicKeyMod";
	public static final String PUBLIC_KEY_EXP = "publicKeyExp";
	public static final String UMS_PAY_KEY_FILE = "umsPayKeyFile";
	public static final String SHA1withRSA = "SHA1withRSA";
	public static final String RSA = "RSA";
	
	private PrivateKey privateKey = null;
	private PublicKey publicKey = null;
	private FileManagerSVC secureFileRepo = null;
	private String confPath = "/com/zpaas/security/umsPaySignatureSVC";
	private ConfigurationCenter cc = null;
	private String umsPayKeyFile = null;
	
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
		if(json.getString(UMS_PAY_KEY_FILE) != null && !json.getString(UMS_PAY_KEY_FILE).equals(umsPayKeyFile)) {
			changed = true;
			umsPayKeyFile = json.getString(UMS_PAY_KEY_FILE);
		}
		if(changed) {
			JSONObject umsPayKey = JSONObject.fromObject(CipherUtil.decrypt(new String(secureFileRepo.readFile(umsPayKeyFile))));
			this.loadPrivateKey(umsPayKey.getString(PRIVATE_KEY_MOD), umsPayKey.getString(PRIVATE_KEY_EXP));
			this.loadPublicKey(umsPayKey.getString(PUBLIC_KEY_MOD), umsPayKey.getString(PUBLIC_KEY_EXP));
		}
	}
	
	public UmsPaySignatureSVCImpl() {
		
	}
	
	public void init(String conf,FileManagerSVC secureFileRepo) {
		this.secureFileRepo = secureFileRepo;
		JSONObject json = JSONObject.fromObject(conf);
		boolean changed = false;
		if(json.getString(UMS_PAY_KEY_FILE) != null && !json.getString(UMS_PAY_KEY_FILE).equals(umsPayKeyFile)) {
			changed = true;
			umsPayKeyFile = json.getString(UMS_PAY_KEY_FILE);
		}
		if(changed) {
			JSONObject umsPayKey = JSONObject.fromObject(CipherUtil.decrypt(new String(secureFileRepo.readFile(umsPayKeyFile))));
			this.loadPrivateKey(umsPayKey.getString(PRIVATE_KEY_MOD), umsPayKey.getString(PRIVATE_KEY_EXP));
			this.loadPublicKey(umsPayKey.getString(PUBLIC_KEY_MOD), umsPayKey.getString(PUBLIC_KEY_EXP));
		}
	}
	
	private void loadPrivateKey(String keyMod, String keyExp) {
		try {
			BigInteger mod = new BigInteger(keyMod, 16);
			BigInteger exp = new BigInteger(keyExp, 16);
			RSAPrivateKeySpec spec = new RSAPrivateKeySpec(mod, exp);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA);
			privateKey = keyFactory.generatePrivate(spec);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			log.error("load private key failed.");
		} 
	}
	
	private void loadPublicKey(String keyMod, String keyExp) {
		try {
			RSAPublicKeySpec spec = new RSAPublicKeySpec(new BigInteger(keyMod,16), new BigInteger(keyExp,16));
			KeyFactory keyFactory = KeyFactory.getInstance(RSA);
			publicKey = keyFactory.generatePublic(spec);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			log.error("load public key failed.");
		} 
	}
	
	public PublicKey loadPublicKey(String cerFile) {
		try {
			JSONObject umsPayKey = JSONObject.fromObject(CipherUtil.decrypt(new String(secureFileRepo.readFile(cerFile))));
			RSAPublicKeySpec spec = new RSAPublicKeySpec(new BigInteger(umsPayKey.getString(PUBLIC_KEY_MOD),16), 
					new BigInteger(umsPayKey.getString(PUBLIC_KEY_EXP),16));
			KeyFactory keyFactory = KeyFactory.getInstance(RSA);
			return keyFactory.generatePublic(spec);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			log.error("load public key failed.");
			return null;
		} 
	}
	
	public String sign(String plainText, String charset) {
		try {
			Signature signature = Signature.getInstance(SHA1withRSA);
			signature.initSign(privateKey);
			signature.update(plainText.getBytes(charset));
			byte[] sign = signature.sign();
			return new String(CommonUtil.hex2Ascii(sign));
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		return null;
	}
	
	public String sign(String plainText) {
		try {
			Signature signature = Signature.getInstance(SHA1withRSA);
			signature.initSign(privateKey);
			signature.update(plainText.getBytes());
			byte[] sign = signature.sign();
			return new String(CommonUtil.hex2Ascii(sign));
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} catch (Error e) {
			log.error(e.getMessage(),e);
		} 
		return null;
	}
	
	public boolean verifySignature(String sign, String plainText) {
		try {
			byte[] signArray = CommonUtil.ascii2Hex(sign.toLowerCase().getBytes());
			Signature signature = Signature.getInstance(SHA1withRSA);
			signature.initVerify(publicKey);
			signature.update(plainText.getBytes());
			return signature.verify(signArray);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		return false;
	}
	
	public boolean verifySignatureWithCharset(String sign, String plainText, String charset) {
		try {
			byte[] signArray = CommonUtil.ascii2Hex(sign.toLowerCase().getBytes(charset));
			Signature signature = Signature.getInstance(SHA1withRSA);
			signature.initVerify(publicKey);
			signature.update(plainText.getBytes(charset));
			return signature.verify(signArray);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		return false;
	}
	
	public boolean verifySignature(String sign, String plainText, String cerFile) {
		try {
			PublicKey key = loadPublicKey(cerFile);
			byte[] signArray = CommonUtil.ascii2Hex(sign.toLowerCase().getBytes());
			Signature signature = Signature.getInstance(SHA1withRSA);
			signature.initVerify(key);
			signature.update(plainText.getBytes());
			return signature.verify(signArray);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		return false;
	}
	
	public boolean verifySignatureWithCharset(String sign, String plainText, String cerFile, String charset) {
		try {
			PublicKey key = loadPublicKey(cerFile);
			byte[] signArray = CommonUtil.ascii2Hex(sign.toLowerCase().getBytes());
			Signature signature = Signature.getInstance(SHA1withRSA);
			signature.initVerify(key);
			signature.update(plainText.getBytes(charset));
			return signature.verify(signArray);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		return false;
	}
	
	
	public static void generateKeyPair() {
		KeyPairGenerator kpg = null;
		try {
			kpg = KeyPairGenerator.getInstance(RSA);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return ;
		} 
		KeyPair pair = kpg.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) pair.getPublic(); 
		RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
		String pubMod = publicKey.getModulus().toString(16); 
		String pubExp = publicKey.getPublicExponent().toString(16); 
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 256 - pubExp.length(); i++) {
			buf.append("0"); 
		}
		String pubKey = pubMod + buf + pubExp; 
		System.out.println("RSA key pair generated:");
		System.out.println();
		System.out.println("Public key: \n" + pubKey); 
		System.out.println();
		System.out.println("Public key modulus: \n" + pubMod); 
		System.out.println();
		System.out.println("Public key exponent: \n" + buf + pubExp);
		System.out.println(); 
		System.out.println("Private key modulus: \n" + privateKey.getModulus().toString(16)); 
		System.out.println();
		System.out.println("Private key exponent: \n" + privateKey.getPrivateExponent().toString(16));
	}
	
	
	public FileManagerSVC getSecureFileRepo() {
		return secureFileRepo;
	}

	public void setSecureFileRepo(FileManagerSVC secureFileRepo) {
		this.secureFileRepo = secureFileRepo;
	}

	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	public ConfigurationCenter getCc() {
		return cc;
	}

	public void setCc(ConfigurationCenter cc) {
		this.cc = cc;
	}

	public static void main(String[] args) {
//		generateKeyPair();
	}
	

}
