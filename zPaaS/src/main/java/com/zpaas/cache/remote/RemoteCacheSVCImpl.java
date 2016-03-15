package com.zpaas.cache.remote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;


/**
 * 远程缓存服务实现类
 * @author ZhangJunyong
 *
 */
public class RemoteCacheSVCImpl implements ConfigurationWatcher,RemoteCacheSVC {
	
	private static final Logger log = LoggerFactory.getLogger(RemoteCacheSVCImpl.class);
	
	
	private static final String HOST_KEY = "host";
	private static final String PORT_KEY = "port";
	private static final String TIMEOUT_KEY = "timeOut";
	private static final String MAXACTIVE_KEY = "maxActive";
	private static final String MAXIDLE_KEY = "maxIdle";
	private static final String MAXWAIT_KEY = "maxWait";
	private static final String TESTONBORROW_KEY = "testOnBorrow";
	private static final String TESTONRETURN_KEY = "testOnReturn";
	private static final String DBINDEX_KEY = "dbIndex";
	
	private String confPath = "/com/zpaas/cache/remote/remoteCacheSVC";
	
	private String host = null;
	private String port = null;
	private String timeOut = null;
	private String maxActive = null;
	private String maxIdle = null;
	private String maxWait = null;
	private String testOnBorrow = null;
	private String testOnReturn = null;
	
	private RedisCacheClient redisCache=null;
	private ConfigurationCenter cc = null;
	private int dbIndex=0;
	
	public  RemoteCacheSVCImpl(){
		
	}
	
	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			e.printStackTrace();
		}
	}
	
	
	public void process(String conf) {
		if(log.isInfoEnabled()) {
			log.info("new remote cache configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		boolean changed = false;
		if(json.getString(HOST_KEY) != null && !json.getString(HOST_KEY).equals(host)) {
			changed = true;
			host = json.getString(HOST_KEY);
		}
		if(json.getString(PORT_KEY) != null && !json.getString(PORT_KEY).equals(port)) {
			changed = true;
			port = json.getString(PORT_KEY);
		}
		if(json.getString(TIMEOUT_KEY) != null && !json.getString(TIMEOUT_KEY).equals(timeOut)) {
			changed = true;
			timeOut = json.getString(TIMEOUT_KEY);
		}
		if(json.getString(MAXACTIVE_KEY) != null && !json.getString(MAXACTIVE_KEY).equals(maxActive)) {
			changed = true;
			maxActive = json.getString(MAXACTIVE_KEY);
		}
		if(json.getString(MAXIDLE_KEY) != null && !json.getString(MAXIDLE_KEY).equals(maxIdle)) {
			changed = true;
			maxIdle = json.getString(MAXIDLE_KEY);
		}
		if(json.getString(MAXWAIT_KEY) != null && !json.getString(MAXWAIT_KEY).equals(maxWait)) {
			changed = true;
			maxWait = json.getString(MAXWAIT_KEY);
		}
		if(json.getString(TESTONBORROW_KEY) != null && !json.getString(TESTONBORROW_KEY).equals(testOnBorrow)) {
			changed = true;
			testOnBorrow = json.getString(TESTONBORROW_KEY);
		}
		if(json.getString(TESTONRETURN_KEY) != null && !json.getString(TESTONRETURN_KEY).equals(testOnReturn)) {
			changed = true;
			testOnReturn = json.getString(TESTONRETURN_KEY);
		}
		if(json.getString(DBINDEX_KEY) != null && !json.getString(DBINDEX_KEY).equals(dbIndex)) {
			dbIndex = json.getInt(DBINDEX_KEY);
		}
		if(changed) {
				redisCache = new RedisCacheClient(conf);
				if(log.isInfoEnabled()) {
					log.info("cache server address is changed to {}", conf);
				}
		}
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
	public void addItemToList(String key, Object object) {
		redisCache.addItemToList(dbIndex,key, object);
	}

	@SuppressWarnings("rawtypes")
	public List getItemFromList(String key) {
		return redisCache.getItemFromList(dbIndex,key);
	}

	public void addItem(String key, Object object) {
		redisCache.addItem(dbIndex,key, object);

	}
	
	public void addItem(String key, Object object, int seconds) {
		redisCache.addItem(dbIndex,key, object, seconds);
	}

	public Object getItem(String key) {
		return redisCache.getItem(dbIndex,key);
	}

	public void delItem(String key) {
		redisCache.delItem(dbIndex,key);
	}

	public long getIncrement(String key) {
		return redisCache.getIncrement(dbIndex,key);
	}
	public long getDecrement(String key) {
		return redisCache.getDecrement(dbIndex,key);
	}

	public void setHashMap(String key, HashMap<String, String> map) {
		redisCache.setHashMap(dbIndex,key, map);
	}

	public Map<String, String> getHashMap(String key) {
		return redisCache.getHashMap(dbIndex,key);
	}

	public void addSet(String key, Set<String> set) {
		redisCache.addSet(dbIndex,key, set);
	}

	public Set<String> getSet(String key) {
		return redisCache.getSet(dbIndex,key);
	}
	
	public String flushDB() {
		return redisCache.flushDB(dbIndex);
	}
	
	public boolean exists(String key) {
		return redisCache.exists(dbIndex,key);
	}
	
	@SuppressWarnings("rawtypes")
	public List keys(String keyPattern) {
		return redisCache.keys(dbIndex, keyPattern);
	}
	
	public void hsetItem(String key, String field, Object object) {
		redisCache.hsetItem(dbIndex, key, field, object);
	}
	
	public Object hgetItem(String key, String field) {
		return redisCache.hgetItem(dbIndex, key, field);
	}
	
	public void hdelItem(String key, String field) {
		redisCache.hdelItem(dbIndex, key, field);
	}
	
	public void expire(String key, int seconds) {
		redisCache.expire(dbIndex, key, seconds);
	}
	
	public Set<String> hkeys(String key) {
		return redisCache.hkeys(dbIndex, key);
	}
	
	public static void main(String[] args) throws PaasException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "paasContext.xml" });
		RemoteCacheSVC cacheSvc = (RemoteCacheSVC)ctx.getBean("cacheSvc");
		cacheSvc.addItem("key", "value");
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
