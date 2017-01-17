package com.zpaas.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;

/**
 * HttpClient服务接口类
 * @author ZhangJunyong
 *
 */
public interface HttpClientManagerSVC {
	public HttpClient getHttpClient();
	
	public void shutdownHttpClient(HttpClient httpClient, HttpMethod method);
}
