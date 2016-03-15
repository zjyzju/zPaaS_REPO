package com.zpaas.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 签名工具类
 * @author ZhangJunyong
 *
 */
public class SignatureUtil {
	public static final Logger log = LoggerFactory.getLogger(SignatureUtil.class);
	
	private static final String PKCS12 = "PKCS12";
	private static final String X509 = "X.509";
	private static final String SHA1withRSA = "SHA1withRSA";
	
	private static PrivateKey loadPrivateKey(String pfxFile, String pfxPwd,String privateKeyPwd) {
		try {
			InputStream bis = new FileInputStream(pfxFile);
			KeyStore store = KeyStore.getInstance(PKCS12);
			store.load(bis, pfxPwd.toCharArray());
			String alias = store.aliases().nextElement();
			return (PrivateKey)store.getKey(alias, privateKeyPwd.toCharArray());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			log.error("load private key failed.");
			return null;
		} 
	}
	
	private static PublicKey loadPublicKey(String cerFile) {
		try {
			InputStream bis = new FileInputStream(cerFile);
			CertificateFactory cf = CertificateFactory.getInstance(X509);
			Certificate cert = cf.generateCertificate(bis);
			return cert.getPublicKey();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			log.error("load public key failed.");
			return null;
		} 
	}
	
	/**
	 * 签名方法
	 * @param plainText 原始文本
	 * @param charset 文本字符集
	 * @param pfxFile 私钥文件路径
	 * @param pfxPwd	私钥库密码
	 * @param privateKeyPwd 私钥密码
	 * @return 签名信息
	 */
	public static String sign(String plainText, String charset, String pfxFile, String pfxPwd, String privateKeyPwd) {
		try {
			Signature signature = Signature.getInstance(SHA1withRSA);
			signature.initSign(loadPrivateKey(pfxFile,pfxPwd,privateKeyPwd));
			if(charset != null && charset.length() > 0) {
				signature.update(plainText.getBytes(charset));
			}else {
				signature.update(plainText.getBytes());
			}
			byte[] sign = signature.sign();
			return new String(CommonUtil.hex2Ascii(sign));
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		return null;
	}
	
	/**
	 * 签名方法，使用默认字符集
	 * @param plainText 原始文本
	 * @param pfxFile 私钥文件路径
	 * @param pfxPwd	私钥库密码
	 * @param privateKeyPwd 私钥密码
	 * @return 签名信息
	 */
	public static String sign(String plainText, String pfxFile, String pfxPwd, String privateKeyPwd) {
		return sign(plainText, null, pfxFile, pfxPwd,privateKeyPwd);
	}
	
	/**
	 * 验签方法，使用默认字符集
	 * @param sign	签名信息
	 * @param plainText	原始文本
	 * @param cerFile 公钥文件路径
	 * @return 验签结果
	 */
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
	
	/**
	 * 验签方法，使用默认字符集
	 * @param sign	签名信息
	 * @param plainText	原始文本
	 * @param cerFile 公钥文件路径
	 * @param charset 文本字符集
	 * @return 验签结果
	 */
	public static boolean verifySignatureWithCharset(String sign, String plainText, String cerFile, String charset) {
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
	

	public static void main(String[] args) throws Exception{
//		String strSendData = "test date";
//		String sign = SignatureTools.sign(strSendData,"UTF-8","/Volumes/HD/workspace/01_工作文档/01_支付平台/支付平台接口协议/private_key.pfx","123456","654321");
//		System.out.println(sign);
//		boolean ret = SignatureTools.verifySignatureWithCharset(sign, strSendData,
//				"/Volumes/HD/Downloads/53c398ca30045257c78b6f93", "UTF-8");
//		System.out.println(ret);
		String text = "a1中国";
		text = new String(text.getBytes("UTF-8"),"GBK");
		System.out.println("1:" + new String(text.getBytes("UTF-8")));
		System.out.println(new String(CommonUtil.hex2Ascii(text.getBytes())));
		System.out.println(new String(CommonUtil.hex2Ascii(text.getBytes("GBK"))));
	}
}
