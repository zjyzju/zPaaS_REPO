package com.zpaas.session;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * 基于Redis缓存的HttpSession实现类
 * 
 * @author ZhangJunyong
 *
 */

@SuppressWarnings("deprecation")
public class CacheHttpSession implements HttpSession, Serializable {
	private static final long serialVersionUID = 1L;
	protected String id;
	protected int maxInactiveInterval;
	protected long lastAccessedTime = 0L;
	protected long creationTime = 0L;
	protected transient boolean isNew = false;
	private SessionManager sessionManager;
	private HttpServletResponse response;
	private HttpServletRequestWrapper request;
	protected transient boolean expired = false;

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequestWrapper getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequestWrapper request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public long getCreationTime() {
		return this.creationTime;
	}

	public boolean isNew() {
		return this.isNew;
	}

	public SessionManager getSessionManager() {
		return sessionManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	public String getId() {
		return this.id;
	}

	public long getLastAccessedTime() {
		return this.lastAccessedTime;
	}

	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public ServletContext getServletContext() {
		return null;
	}

	public void setMaxInactiveInterval(int i) {
		this.maxInactiveInterval = i;
	}

	public int getMaxInactiveInterval() {
		return this.maxInactiveInterval;
	}

	public HttpSessionContext getSessionContext() {
		return null;
	}

	public Object getAttribute(String key) {
		this.sessionManager.updateExpireItemToCache(this);
		return this.sessionManager.getItemFromCache(getId(), key);

	}

	public Object getValue(String key) {
		this.sessionManager.updateExpireItemToCache(this);
		return this.sessionManager.getItemFromCache(getId(), key);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Enumeration getAttributeNames() {
		this.sessionManager.updateExpireItemToCache(this);
		final Iterator iterator = this.sessionManager.getItemNamesFromCache(
				getId()).iterator();
		return new Enumeration() {
			public boolean hasMoreElements() {
				return iterator.hasNext();
			}

			public Object nextElement() {
				return iterator.next();
			}
		};
	}

	public String[] getValueNames() {
		this.sessionManager.updateExpireItemToCache(this);
		String[] names = new String[this.sessionManager.getItemNamesFromCache(
				getId()).size()];
		return (String[]) this.sessionManager.getItemNamesFromCache(getId())
				.toArray(names);
	}

	public void setAttribute(String s, Object o) {
		this.sessionManager.setItemToCache(getId(), s, o);
		this.sessionManager.updateExpireItemToCache(this);
	}

	public void putValue(String s, Object o) {
		this.sessionManager.setItemToCache(getId(), s, o);
		this.sessionManager.updateExpireItemToCache(this);
	}

	public void removeAttribute(String s) {
		this.sessionManager.delItemFromCache(getId(), s);
		this.sessionManager.updateExpireItemToCache(this);
	}

	public void removeValue(String s) {
		this.sessionManager.delItemFromCache(getId(), s);
		this.sessionManager.updateExpireItemToCache(this);
	}

	public void invalidate() {
		this.expired = true;
		this.sessionManager.saveCookie(this, request, response);
	}

}
