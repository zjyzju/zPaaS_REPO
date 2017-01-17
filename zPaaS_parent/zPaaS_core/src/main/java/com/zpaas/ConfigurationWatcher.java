package com.zpaas;

/**
 * 接入统一配置中心的接口类
 * @author ZhangJunyong
 *
 */
public interface ConfigurationWatcher {
	public void process(String conf);
}
