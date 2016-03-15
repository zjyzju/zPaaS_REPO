package com.zpaas.http;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;

/**
 * HttpClient服务实现类
 * @author ZhangJunyong
 *
 */
public class HttpClientManagerSVCImpl implements ConfigurationWatcher,HttpClientManagerSVC {

	private static final Logger log = LoggerFactory.getLogger(HttpClientManagerSVCImpl.class);
		
	private static final String CONNECTION_TIMEOUT = "connection.timeout";
	private static final String CONNECTION_SOTIMEOUT = "connection.sotimeout";
	private static final String HTTP_CHARSET = "http.charset";
	
	private static final Integer maxConnsPerhost = 1;
	private static final Integer maxConnsTotal = 1;
	private String httpCharset = null;
	private Integer connTimeout = null;
	private Integer connSoTimeout = null;
	
	private ConfigurationCenter cc = null;
	private String confPath = "/com/zpaas/http/httpClientManagerSVC";
	
	
	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
			
		} catch (PaasException e) {
			e.printStackTrace();
		}
	}
	
	public void process(String conf) {
		if(log.isInfoEnabled()) {
			log.info("new log configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		if(json.getString(CONNECTION_TIMEOUT) != null && !json.getString(CONNECTION_TIMEOUT).equals(connTimeout)) {
			connTimeout = Integer.parseInt(json.getString(CONNECTION_TIMEOUT));
		}
		if(json.getInt(CONNECTION_SOTIMEOUT) != 0 && !json.getString(CONNECTION_SOTIMEOUT).equals(connSoTimeout)) {
			connSoTimeout = Integer.parseInt(json.getString(CONNECTION_SOTIMEOUT));
		}
		if(json.getString(HTTP_CHARSET) != null && !json.getString(HTTP_CHARSET).equals(httpCharset)) {
			httpCharset = json.getString(HTTP_CHARSET);
		}
	}
	
	public HttpClient getHttpClient() {
		MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(connTimeout); 
        params.setSoTimeout(connSoTimeout); 
        params.setDefaultMaxConnectionsPerHost(maxConnsPerhost); 
        params.setMaxTotalConnections(maxConnsTotal); 
        params.setStaleCheckingEnabled(true);
        HttpClient httpClient = new HttpClient(httpConnectionManager);
		httpClient.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, httpCharset);
		httpClient.getParams().setParameter(HTTP.CONTENT_ENCODING, httpCharset);
		return httpClient;
	}
	
	public void shutdownHttpClient(HttpClient httpClient, HttpMethod method) {
		if(method != null) {
			method.releaseConnection();
		}
		if(httpClient != null ) {
			((MultiThreadedHttpConnectionManager)httpClient.getHttpConnectionManager()).shutdown();
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
}
