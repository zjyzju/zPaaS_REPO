package com.zpaas.session;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.cache.remote.RedisCacheClient;

/**
 * 统一Session管理器
 * @author ZhangJunyong
 *
 */
public class SessionManager implements ConfigurationWatcher {
	private Logger log = LoggerFactory.getLogger(SessionManager.class);
	private static final String SESSION_ID_PREFIX = "R_JSID_";
	private static final String SESSION_ID_COOKIE = "JSESSIONID";
	private static final String EXPIRATIONUPDATEINTERVAL_KEY = "expirationUpdateInterval";
	private static final String MAXINACTIVEINTERVAL_KEY = "maxInactiveInterval";
	private static final String HOST_KEY = "host";
	private static final String PORT_KEY = "port";
	private static final String TIMEOUT_KEY = "timeOut";
	private static final String MAXACTIVE_KEY = "maxActive";
	private static final String MAXIDLE_KEY = "maxIdle";
	private static final String MAXWAIT_KEY = "maxWait";
	private static final String TESTONBORROW_KEY = "testOnBorrow";
	private static final String TESTONRETURN_KEY = "testOnReturn";
	private static final String DBINDEX_KEY = "dbIndex";
	private static final String COOKIE_DOMAIN = "cookieDomain";
	private String host = null;
	private String port = null;
	private String timeOut = null;
	private String maxActive = null;
	private String maxIdle = null;
	private String maxWait = null;
	private String testOnBorrow = null;
	private String testOnReturn = null;
	private String cookieDomain = null;
	private RedisCacheClient cacheClient = null;
	private int dbIndex = 0;
	private int expirationUpdateInterval = 300;
	private int maxInactiveInterval = 1800;
	private String confPath = "";
	private ConfigurationCenter cc = null;

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

	public CacheHttpSession createSession(
			SessionHttpServletRequestWrapper request,
			HttpServletResponse response, boolean create) {
		String sessionId = getRequestedSessionId(request);
		CacheHttpSession session = null;
		if ((StringUtils.isEmpty(sessionId)) && (!create))
			return null;
		if (StringUtils.isNotEmpty(sessionId)) {
			session = loadSession(sessionId, request, response);
		}
		if ((session == null) && (create)) {
			session = createEmptySession(request, response);
		}
		return session;
	}

	private String getRequestedSessionId(HttpServletRequestWrapper request) {
		Cookie[] cookies = request.getCookies();
		if ((cookies == null) || (cookies.length == 0))
			return null;
		for (Cookie cookie : cookies) {
			if (SESSION_ID_COOKIE.equals(cookie.getName()))
				return cookie.getValue();
		}
		return null;
	}

	private CacheHttpSession createEmptySession(
			SessionHttpServletRequestWrapper request,
			HttpServletResponse response) {
		CacheHttpSession session = new CacheHttpSession();
		session.id = createSessionId();
		session.isNew = true;
		session.creationTime = System.currentTimeMillis();
		session.setSessionManager(this);
		session.lastAccessedTime = System.currentTimeMillis();
		session.setRequest(request);
		session.setResponse(response);
		this.setItemToCache(session.id, "lastAccessedTime" + session.id,
				session.lastAccessedTime);
		this.expireItemToCache(session.id, this.maxInactiveInterval);
		if (this.log.isDebugEnabled())
			this.log.debug("CacheHttpSession Create [ID={}]", session.id);
		saveCookie(session, request, response);
		return session;
	}

	private String createSessionId() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	public void saveCookie(CacheHttpSession session,
			HttpServletRequestWrapper request, HttpServletResponse response) {
		if ((!session.isNew) && (!session.expired))
			return;
		// 清除cookie时，需setMaxAge(0)和setDomain("")需写具体的域名，并且创建时也需要写上此域名。
		// 如果本地测试时，不写域名项，配置domain为空字符串
		// 目前仅设置支付平台专用cookie名称SESSION_ID_COOKIE为ZPAAS_JSESSIONID。
		if (session.expired) {
			Cookie[] cookies = request.getCookies();
			if ((cookies == null) || (cookies.length == 0))
				return;
			for (Cookie cookie : cookies) {
				if (SESSION_ID_COOKIE.equals(cookie.getName()))
					if (!"".equals(cookieDomain)) {
						cookie.setDomain(cookieDomain);
					}
				cookie.setPath(StringUtils.isBlank(request.getContextPath()) ? "/"
						: request.getContextPath());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				return;
			}
		}

		if (session.isNew) {
			Cookie cookie = new Cookie(SESSION_ID_COOKIE, null);
			cookie.setPath(StringUtils.isBlank(request.getContextPath()) ? "/"
					: request.getContextPath());
			if (!"".equals(cookieDomain)) {
				cookie.setDomain(cookieDomain);
			}
			cookie.setValue(session.getId());
			response.addCookie(cookie);
		}

		if (this.log.isDebugEnabled())
			this.log.debug("CacheHttpSession saveCookie [ID={}]", session.id);
	}

	private CacheHttpSession loadSession(String sessionId,
			SessionHttpServletRequestWrapper request,
			HttpServletResponse response) {
		CacheHttpSession session;
		Object o = this.getItemFromCache(sessionId, "lastAccessedTime"
				+ sessionId);
		if (o == null) {
			this.log.debug("Session {} not found in Redis", sessionId);
			session = null;
		} else {
			session = new CacheHttpSession();
			session.id = sessionId;
			session.setSessionManager(this);
			session.setRequest(request);
			session.setResponse(response);
			session.isNew = false;
			session.lastAccessedTime = (Long) this.getItemFromCache(session.id,
					"lastAccessedTime" + session.id);
			this.updateExpireItemToCache(session);
		}
		if (this.log.isDebugEnabled())
			this.log.debug("CacheHttpSession Load [ID={},exist={}]", sessionId, (session != null));
		return session;
	}

	private String generatorSessionKey(String sessionId) {
		return SESSION_ID_PREFIX.concat(sessionId);
	}

	public SessionManager() {
	}

	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new session configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		boolean changed = false;
		if (json.getString(HOST_KEY) != null
				&& !json.getString(HOST_KEY).equals(host)) {
			changed = true;
			host = json.getString(HOST_KEY);
		}
		if (json.getString(PORT_KEY) != null
				&& !json.getString(PORT_KEY).equals(port)) {
			changed = true;
			port = json.getString(PORT_KEY);
		}
		if (json.getString(TIMEOUT_KEY) != null
				&& !json.getString(TIMEOUT_KEY).equals(timeOut)) {
			changed = true;
			timeOut = json.getString(TIMEOUT_KEY);
		}
		if (json.getString(MAXACTIVE_KEY) != null
				&& !json.getString(MAXACTIVE_KEY).equals(maxActive)) {
			changed = true;
			maxActive = json.getString(MAXACTIVE_KEY);
		}
		if (json.getString(MAXIDLE_KEY) != null
				&& !json.getString(MAXIDLE_KEY).equals(maxIdle)) {
			changed = true;
			maxIdle = json.getString(MAXIDLE_KEY);
		}
		if (json.getString(MAXWAIT_KEY) != null
				&& !json.getString(MAXWAIT_KEY).equals(maxWait)) {
			changed = true;
			maxWait = json.getString(MAXWAIT_KEY);
		}
		if (json.getString(TESTONBORROW_KEY) != null
				&& !json.getString(TESTONBORROW_KEY).equals(testOnBorrow)) {
			changed = true;
			testOnBorrow = json.getString(TESTONBORROW_KEY);
		}
		if (json.getString(TESTONRETURN_KEY) != null
				&& !json.getString(TESTONRETURN_KEY).equals(testOnReturn)) {
			changed = true;
			testOnReturn = json.getString(TESTONRETURN_KEY);
		}
		if (json.getString(DBINDEX_KEY) != null
				&& json.getInt(DBINDEX_KEY) != dbIndex) {
			dbIndex = json.getInt(DBINDEX_KEY);
		}
		if (json.getInt(EXPIRATIONUPDATEINTERVAL_KEY) != expirationUpdateInterval) {
			expirationUpdateInterval = json
					.getInt(EXPIRATIONUPDATEINTERVAL_KEY);
		}
		if (json.getInt(MAXINACTIVEINTERVAL_KEY) != maxInactiveInterval) {
			maxInactiveInterval = json.getInt(MAXINACTIVEINTERVAL_KEY);
		}
		if (json.getString(COOKIE_DOMAIN) != cookieDomain) {
			cookieDomain = json.getString(COOKIE_DOMAIN);
		}
		if (changed) {
			cacheClient = new RedisCacheClient(conf);
			if (log.isInfoEnabled()) {
				log.info("cache server address is changed to {}", conf);
			}
		}
	}

	public void removeSessionFromCache(String id) {
		cacheClient.delItem(dbIndex, generatorSessionKey(id));
	}

	public void setItemToCache(String id, String k, Object v) {
		cacheClient.hsetItem(dbIndex, generatorSessionKey(id), k, v);
	}

	public void delItemFromCache(String id, String k) {
		cacheClient.hdelItem(dbIndex, generatorSessionKey(id), k);
	}

	public Object getItemFromCache(String id, String k) {
		return cacheClient.hgetItem(dbIndex, generatorSessionKey(id), k);
	}

	public void expireItemToCache(String id, int seconds) {
		cacheClient.expire(dbIndex, generatorSessionKey(id), seconds);
	}

	public Set<String> getItemNamesFromCache(String id) {
		Set<String> itemNames = cacheClient.hkeys(dbIndex,
				generatorSessionKey(id));
		itemNames.remove("lastAccessedTime" + id); // 移除最后访问时间
		return itemNames;
	}

	public void updateExpireItemToCache(CacheHttpSession session) {
		int updateInterval = (int) ((System.currentTimeMillis() - session.lastAccessedTime) / 1000L);
		if (updateInterval < this.expirationUpdateInterval)
			return; // 访问间隔时间小于设置时间，直接返回，不更新最大有存活时间和最后访问时间
		else {
			if (session.expired)
				this.removeSessionFromCache(session.getId());
			else {
				this.setItemToCache(session.getId(), "lastAccessedTime"
						+ session.getId(), System.currentTimeMillis());
				this.expireItemToCache(session.getId(),
						this.maxInactiveInterval);
			}
		}
	}

	public static void main(String[] args) throws PaasException {
		Set<String> attrNames = new HashSet<String>();
		attrNames.add("a");
		attrNames.add("b");
		attrNames.remove("a");
		String[] a = new String[attrNames.size()];
		String[] b = (String[]) attrNames.toArray(a);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		// System.out.println(attrNames.toArray(a).toString());
		// Enumeration b = (Enumeration)attrNames;
		// Iterator iterator = b.

	}

}
