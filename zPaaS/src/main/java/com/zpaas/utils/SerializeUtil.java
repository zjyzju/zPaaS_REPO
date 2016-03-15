package com.zpaas.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 序列化工具类
 * @author ZhangJunyong
 *
 */
public class SerializeUtil {
	private static final Logger log = LoggerFactory.getLogger(SerializeUtil.class);
	
	public static byte[] serialize(Object object) {
		if(object==null)
			return null;
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
 

	public static Object deserialize(byte[] bytes) {
		if(bytes==null)
			return null;
		ByteArrayInputStream bais = null;
		try {
			
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
}