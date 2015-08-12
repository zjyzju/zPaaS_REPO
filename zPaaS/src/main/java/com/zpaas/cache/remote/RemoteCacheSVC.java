package com.zpaas.cache.remote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 远程缓存服务接口类
 * @author ZhangJunyong
 *
 */
public interface RemoteCacheSVC {
	public void addItemToList(String key, Object object);
	@SuppressWarnings("rawtypes")
	public List getItemFromList(String key);
	public void addItem(String key, Object object);
	public void addItem(String key, Object object, int seconds);
	public String flushDB();
	public boolean exists(String key);
	@SuppressWarnings("rawtypes")
	public List keys(String keyPattern);
	public Object getItem(String key);
	public void delItem(String key);
	public long getIncrement(String key);
	public long getDecrement(String key);
	public void setHashMap(String key, HashMap<String, String> map);
	public Map<String, String> getHashMap(String key);
	public void addSet(String key, Set<String> set);
	public Set<String> getSet(String key);
	public void hsetItem(String key, String field,Object object);
	public Object hgetItem(String key, String field);
	public void hdelItem(String key, String field);
	public void expire(String key,int seconds);
	public Set<String> hkeys(String key);
	
}
