package com.zpaas.log;

import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 统一日志服务接口类
 * @author ZhangJunyong
 *
 */
public interface LogSVC {
	public void write(String log);
	public void write(JSONObject logJson);
	@SuppressWarnings("rawtypes")
	public void write(Map logMap);
}
