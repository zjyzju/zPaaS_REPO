package com.zpaas.security.signature;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.file.FileManagerSVC;
import com.zpaas.utils.CipherUtil;
import com.zpaas.utils.CommandUtil;
import com.zpaas.utils.CommonUtil;

/**
 * SHA1WithRSA签名服务实现类
 * @author ZhangJunyong
 *
 */
public class SHA1WithRSASignatureSVCImpl implements ConfigurationWatcher, SignatureSVC {
	public static final Logger log = LoggerFactory.getLogger(SHA1WithRSASignatureSVCImpl.class);
	
	public static final String JKS = "JKS";
	public static final String PKCS12 = "PKCS12";
	public static final String X509 = "X.509";
	public static final String PFX = "pfx";
	public static final String CER = "cer";
	public static final String PFX_PWD = "pfxPwd";
	public static final String PRIVATE_KEY_PWD = "privateKeyPwd";
	public static final String ALIAS = "alias";
	public static final String SHA1withRSA = "SHA1withRSA";
	
	private PrivateKey privateKey = null;
	private PublicKey publicKey = null;
	private FileManagerSVC secureFileRepo = null;
	private String confPath = "/com/zpaas/security/SHA1WithRSASignatureSVC";
	private ConfigurationCenter cc = null;
	private String pfxFile = null;
	private String cerFile = null;
	private String pfxPwd = null;
	private String privateKeyPwd = null;
	private String alias = null;
	
	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
			
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public void process(String conf) {
		JSONObject json = JSONObject.fromObject(conf);
		boolean pfxChg = false;
		if(json.getString(PFX) != null && !json.getString(PFX).equals(pfxFile)) {
			pfxChg = true;
			pfxFile = json.getString(PFX);
		}
		if(json.getString(CER) != null && !json.getString(CER).equals(cerFile)) {
			cerFile = json.getString(CER);
		}
		if(json.getString(PFX_PWD) != null && !json.getString(PFX_PWD).equals(pfxPwd)) {
			pfxPwd = json.getString(PFX_PWD);
		}
		if(json.getString(PRIVATE_KEY_PWD) != null && !json.getString(PRIVATE_KEY_PWD).equals(privateKeyPwd)) {
			privateKeyPwd = json.getString(PRIVATE_KEY_PWD);
		}
		if(json.getString(ALIAS) != null && !json.getString(ALIAS).equals(alias)) {
			alias = json.getString(ALIAS);
		}
		if(pfxChg) {
			if(pfxFile != null) {
				loadPrivateKey();
			}
			if(cerFile != null) {
				loadPublicKey();
			}
		}
	}
	
	public SHA1WithRSASignatureSVCImpl() {
		
	}
	
	public void init(String conf,FileManagerSVC secureFileRepo) {
		this.secureFileRepo = secureFileRepo;
		JSONObject json = JSONObject.fromObject(conf);
		boolean pfxChg = false;
		if(json.getString(PFX) != null && !json.getString(PFX).equals(pfxFile)) {
			pfxChg = true;
			pfxFile = json.getString(PFX);
		}
		if(json.getString(CER) != null && !json.getString(CER).equals(cerFile)) {
			cerFile = json.getString(CER);
		}
		if(json.getString(PFX_PWD) != null && !json.getString(PFX_PWD).equals(pfxPwd)) {
			pfxPwd = json.getString(PFX_PWD);
		}
		if(json.getString(PRIVATE_KEY_PWD) != null && !json.getString(PRIVATE_KEY_PWD).equals(privateKeyPwd)) {
			privateKeyPwd = json.getString(PRIVATE_KEY_PWD);
		}
		if(json.getString(ALIAS) != null && !json.getString(ALIAS).equals(alias)) {
			alias = json.getString(ALIAS);
		}
		if(pfxChg) {
			if(pfxFile != null) {
				loadPrivateKey();
			}
			if(cerFile != null) {
				loadPublicKey();
			}
		}
	}
	
	public void loadPrivateKey() {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(secureFileRepo.readFile(pfxFile));
			KeyStore store = KeyStore.getInstance(PKCS12);
			store.load(bis, CipherUtil.decrypt(pfxPwd).toCharArray());
			if(alias == null || alias.trim().length() == 0) {
				alias = store.aliases().nextElement();
			}
			privateKey = (PrivateKey)store.getKey(alias, CipherUtil.decrypt(privateKeyPwd).toCharArray());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			log.error("load private key failed.");
		} 
	}
	
	public void loadPublicKey() {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(secureFileRepo.readFile(cerFile));
			CertificateFactory cf = CertificateFactory.getInstance(X509);
			Certificate cert = cf.generateCertificate(bis);
			publicKey = cert.getPublicKey();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			log.error("load public key failed.");
		} 
	}
	
	public PublicKey loadPublicKey(String cerFile) {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(secureFileRepo.readFile(cerFile));
			CertificateFactory cf = CertificateFactory.getInstance(X509);
			Certificate cert = cf.generateCertificate(bis);
			return cert.getPublicKey();
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
			byte[] signArray = CommonUtil.ascii2Hex(sign.getBytes());
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
			byte[] signArray = CommonUtil.ascii2Hex(sign.getBytes(charset));
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
			byte[] signArray = CommonUtil.ascii2Hex(sign.getBytes());
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
			byte[] signArray = CommonUtil.ascii2Hex(sign.getBytes());
			Signature signature = Signature.getInstance(SHA1withRSA);
			signature.initVerify(key);
			signature.update(plainText.getBytes(charset));
			return signature.verify(signArray);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		return false;
	}
	
	public static boolean genKeyStore(long validity, int keySize, String alias, String keyAlg, String keyStorePath, 
			String dName, String storePass, String keyPass) {
		String[] cmd = new String[] {
				"keytool",
				"-genkey", 
				"-validity", String.valueOf(validity),
				"-keysize", String.valueOf(keySize), 
				"-alias", alias,
				"-keyalg", keyAlg, 
				"-keystore", keyStorePath,
				"-dname", dName,
				"-storepass", storePass, 
				"-keypass", keyPass, 
				"-v"
			};
		return CommandUtil.execCommand(cmd);
	}
	
	public static boolean exportPfxFile(String keyStorePath, String alias, String storePass, 
			String keyPass, String filePath) {
		try {
			KeyStore keyStore = KeyStore.getInstance(JKS);
			keyStore.load(new FileInputStream(keyStorePath), storePass.toCharArray());
			Certificate cert = keyStore.getCertificate(alias);
			Certificate[] certs = new Certificate[] {cert};		
			KeyStore pfx = KeyStore.getInstance(PKCS12);
			pfx.load(null, storePass.toCharArray());
			pfx.setKeyEntry(alias, (PrivateKey)keyStore.getKey(alias, keyPass.toCharArray()), keyPass.toCharArray(), certs);
			FileOutputStream fos = new FileOutputStream(filePath);
			pfx.store(fos, storePass.toCharArray());
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return false;
		} 
	}
	
	public static boolean exportCerFile( String alias, String cerFile, String keyStorePath, String storePass) {
		String[] cmd = new String[] {
				"keytool",
				"-export", 
				"-alias", alias,
				"-keystore", keyStorePath,
				"-storepass", storePass, 
				"-storetype", JKS,
				"-file", cerFile
			};
		return CommandUtil.execCommand(cmd);
	}
	
	
	
	public static boolean genAllKeyFile(long validity, int keySize, String alias, String keyAlg, String dName, 
			String storePass, String keyPass, String storeFile, String pfxFile, String cerFile) {
		try {
			if(!genKeyStore(validity, keySize, alias, keyAlg, storeFile, dName, storePass, keyPass)) {
				log.error("gen key store failed.");
				return false;
			}
			
			if(!exportPfxFile(storeFile, alias, storePass, keyPass, pfxFile)) {
				log.error("export pfx file failed.");
				return false;
			}
			
			if(!exportCerFile(alias, cerFile, storeFile, storePass)) {
				log.error("export cer file failed.");
				return false;
			}				
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return false;
		} 
	}
	
	public String uploadToSecureFileRepo(long validity, int keySize, String alias, String keyAlg, String dName, 
			String storePass, String keyPass, String storeFile, String pfxFile, String cerFile) {
		if(!genAllKeyFile(validity, keySize, alias, keyAlg, dName, storePass, keyPass, storeFile, pfxFile, cerFile)) {
			return null;
		}
		JSONObject json = new JSONObject();
		json.put("keystore", secureFileRepo.saveFile(storeFile, "key"));
		json.put("pfx", secureFileRepo.saveFile(pfxFile, "key"));
		json.put("cer", secureFileRepo.saveFile(cerFile, "key"));
		File file = new File(storeFile);
		file.delete();
		file = new File(pfxFile);
		file.delete();
		file = new File(cerFile);
		file.delete();
		return json.toString();
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

	public static void main(String[] args) throws Exception{

		// CN=(名字与姓氏), OU=(组织单位名称), O=(组织名称), L=(城市或区域名称),  
		// ST=(州或省份名称), C=(单位的两字母国家代码)"
		String dName = "CN=(WWW.COM.CN),OU=(),O=(),L=(BJ),ST=(BJ),C=(CN)";
		boolean ret = genAllKeyFile(36500, 1024, "test_php", "RSA", dName, "123456", "123456",
				"/Users/ZhangJunyong/Downloads/test_php.keystore",
				"/Users/ZhangJunyong/Downloads/test_private_php.pfx",
				"/Users/ZhangJunyong/Downloads/test_public_php.cer");
//		boolean ret = exportPfxFile("/Users/ZhangJunyong/Downloads/server.key", "", "", "", 
//				"/Users/ZhangJunyong/Downloads/server.pfx");
		System.out.println(ret);
	}
}
