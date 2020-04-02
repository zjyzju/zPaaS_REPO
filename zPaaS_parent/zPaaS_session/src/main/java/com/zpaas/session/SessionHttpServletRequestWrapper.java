package com.zpaas.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Request包装类
 * @author ZhangJunyong
 *
 */
public class SessionHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private HttpServletResponse response;
	private CacheHttpSession httpSession;
	private SessionManager sessionManager;

	public SessionHttpServletRequestWrapper(HttpServletRequest request,
			HttpServletResponse response, SessionManager sessionManager) {
		super(request);
		this.response = response;
		this.sessionManager = sessionManager;
	}

	public HttpSession getSession(boolean create) {
		if ((this.httpSession != null) && (!this.httpSession.expired))
			return this.httpSession;
		this.httpSession = this.sessionManager.createSession(this,
				this.response, create);
		return this.httpSession;
	}

	public HttpSession getSession() {
		return getSession(true);
	}

}
