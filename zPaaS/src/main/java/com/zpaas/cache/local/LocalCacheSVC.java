package com.zpaas.cache.local;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface LocalCacheSVC {
	public Object getCacheItem(String key);
	
	public String getCacheItemString(String key);
	
	public JSONObject getCacheItemJSONObject(String key);
	
	public JSONArray getCacheItemJSONArray(String key);
}
