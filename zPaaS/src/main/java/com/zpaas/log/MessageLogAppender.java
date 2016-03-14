package com.zpaas.log;

import net.sf.json.JSONObject;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import com.zpaas.ConfigurationCenter;
import com.zpaas.message.MessageSender;
import com.zpaas.message.v1.MessageSenderImpl;
import com.zpaas.utils.CommonUtil;
import com.zpaas.utils.ThreadId;

public class MessageLogAppender extends AppenderSkeleton {

	private static MessageSender sender = null;
	private static final String localIp = CommonUtil.getHostAddr();
	private String logTopic = "paas_log_mongo_topic";
	private String appName = "unkown";
	private static String ccAddr = null;
	private static String auth = null;
	private static String runMod = ConfigurationCenter.PROD_MODE;
	private static ConfigurationCenter cc = null;
	private static String confPath = "/com/zpaas/log/messageLogAppender";
	private static String configurationFile = "/PaasConfigurationFile.properties";

	public MessageLogAppender() {

	}

	private static MessageSender getSender() {
		if (sender == null) {
			init();
		}
		return sender;
	}

	private static synchronized void init() {

		if (cc == null) {
			cc = new ConfigurationCenter(ccAddr, runMod, null,configurationFile);
			cc.setAuth(auth);
			cc.init();
		}
		if (sender == null) {
			MessageSenderImpl senderImpl = new MessageSenderImpl();
			senderImpl.setCc(cc);
			senderImpl.setConfPath(confPath);
			senderImpl.init();
			sender = senderImpl;
		}
	}

	protected void append(LoggingEvent event) {
		JSONObject json = new JSONObject();
		json.put("thread_id", ThreadId.getThreadId());
		json.put("ip_addr", localIp);
		json.put("app_name", appName);
		json.put("log_time", event.timeStamp);
		json.put("class_name", event.getLocationInformation().getClassName());
		json.put("method_name", event.getLocationInformation().getMethodName());
		json.put("line_number", event.getLocationInformation().getLineNumber());
		json.put("logger_name", event.getLoggerName());
		json.put("log_level", event.getLevel().toString());
		json.put("log_msg", event.getMessage());
		getSender().sendMessage(json, logTopic);

	}

	public void close() {
		if (this.closed) {
			return;
		}
		this.closed = true;
	}

	public boolean requiresLayout() {
		return true;
	}

	public String getLogTopic() {
		return logTopic;
	}

	public void setLogTopic(String logTopic) {
		this.logTopic = logTopic;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		MessageLogAppender.confPath = confPath;
	}

	public String getCcAddr() {
		return ccAddr;
	}

	public void setCcAddr(String ccAddr) {
		MessageLogAppender.ccAddr = ccAddr;
	}

	public String getRunMod() {
		return runMod;
	}

	public void setRunMod(String runMod) {
		MessageLogAppender.runMod = runMod;
	}

	public String getConfigurationFile() {
		return configurationFile;
	}

	public void setConfigurationFile(String configurationFile) {
		MessageLogAppender.configurationFile = configurationFile;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		MessageLogAppender.auth = auth;
	}

	public static void main(String[] args) {

	}
}
