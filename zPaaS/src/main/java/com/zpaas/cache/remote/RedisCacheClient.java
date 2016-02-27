package com.zpaas.cache.remote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.zpaas.utils.SerializeUtil;

/**
 * Redis缓存访问类
 * 
 * @author ZhangJunyong
 *
 */
public class RedisCacheClient {
	private static final Logger log = Logger.getLogger(RedisCacheClient.class);

	private static final String HOST_KEY = "host";
	private static final String PORT_KEY = "port";
	private static final String TIMEOUT_KEY = "timeOut";
	private static final String MAXACTIVE_KEY = "maxActive";
	private static final String MAXIDLE_KEY = "maxIdle";
	private static final String MAXWAIT_KEY = "maxWait";
	private static final String TESTONBORROW_KEY = "testOnBorrow";
	private static final String TESTONRETURN_KEY = "testOnReturn";

	private JedisPool pool;
	private JedisPoolConfig config;

	public RedisCacheClient(String parameter) {
		try {
			JSONObject json = JSONObject.fromObject(parameter);
			if (json != null) {
				config = new JedisPoolConfig();
				config.setMaxTotal(json.getInt(MAXACTIVE_KEY));
				config.setMaxIdle(json.getInt(MAXIDLE_KEY));
				config.setMaxWaitMillis(json.getLong(MAXWAIT_KEY));
				config.setTestOnBorrow(json.getBoolean(TESTONBORROW_KEY));
				config.setTestOnReturn(json.getBoolean(TESTONRETURN_KEY));
				pool = new JedisPool(config, json.getString(HOST_KEY),
						json.getInt(PORT_KEY), json.getInt(TIMEOUT_KEY));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public void addItemToList(int dbIndex, String key, Object object) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.connect();
			jedis.select(dbIndex);
			jedis.lpush(key.getBytes(), SerializeUtil.serialize(object));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	public List<Object> getItemFromList(int dbIndex, String key) {
		Jedis jedis = null;
		List<byte[]> ss = null;
		List<Object> data = new ArrayList<Object>();
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			long len = jedis.llen(key);
			if (len == 0)
				return null;
			ss = jedis.lrange(key.getBytes(), 0, (int) len - 1);
			for (int i = 0; i < len; i++) {
				data.add(SerializeUtil.deserialize(ss.get(i)));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return data;

	}

	public List<String> keys(int dbIndex, String keyPattern) {
		Jedis jedis = null;
		Set<byte[]> ss = null;
		List<String> data = new ArrayList<String>();
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			ss = jedis.keys(keyPattern.getBytes());
			for (Iterator<byte[]> iterator = ss.iterator(); iterator.hasNext();) {
				data.add(new String(iterator.next()));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return data;

	}

	public void addItem(int dbIndex, String key, Object object) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			jedis.set(key.getBytes(), SerializeUtil.serialize(object));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public String flushDB(int dbIndex) {
		Jedis jedis = null;
		String result = "";
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			result = jedis.flushDB();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return result;
	}

	public boolean exists(int dbIndex, String key) {
		Jedis jedis = null;
		boolean result = false;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			result = jedis.exists(key.getBytes());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return result;
	}

	public void addItem(int dbIndex, String key, Object object, int seconds) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			jedis.setex(key.getBytes(), seconds,
					SerializeUtil.serialize(object));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	public Object getItem(int dbIndex, String key) {
		Jedis jedis = null;
		byte[] data = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			data = jedis.get(key.getBytes());
			return SerializeUtil.deserialize(data);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public void delItem(int dbIndex, String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			jedis.del(key.getBytes());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public void hsetItem(int dbIndex, String key, String field, Object object) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			jedis.hset(key.getBytes(), field.getBytes(),
					SerializeUtil.serialize(object));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public Object hgetItem(int dbIndex, String key, String field) {
		Jedis jedis = null;
		byte[] data = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			data = jedis.hget(key.getBytes(), field.getBytes());
			return SerializeUtil.deserialize(data);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public void hdelItem(int dbIndex, String key, String field) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			jedis.hdel(key.getBytes(), field.getBytes());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public Set<String> hkeys(int dbIndex, String key) {
		Jedis jedis = null;
		Set<String> data = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			data = jedis.hkeys(key);
			return data;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public void expire(int dbIndex, String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			jedis.expire(key.getBytes(), seconds);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	public long getIncrement(int dbIndex, String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			return jedis.incr(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return 0L;
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public long getDecrement(int dbIndex, String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			return jedis.decr(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return 0L;
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public void setHashMap(int dbIndex, String key, HashMap<String, String> map) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			if (map != null && !map.isEmpty()) {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					jedis.hset(key, entry.getKey(), entry.getValue());
				}

			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}

	}

	public Map<String, String> getHashMap(int dbIndex, String key) {
		Map<String, String> map = new HashMap<String, String>();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			map = jedis.hgetAll(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
		return map;

	}

	public void addSet(int dbIndex, String key, Set<String> set) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			if (set != null && !set.isEmpty()) {
				for (String value : set) {
					jedis.sadd(key, value);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	public Set<String> getSet(int dbIndex, String key) {
		Set<String> sets = new HashSet<String>();
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.select(dbIndex);
			sets = jedis.smembers(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (jedis != null)
				jedis.close();
		}

		return sets;
	}

}
