package com.zpaas.log;

import java.util.Date;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.mongo.MongoDBClient;

/**
 * 基于MongoDB的统一日志服务实现类
 * @author ZhangJunyong
 *
 */
public class MongoLogSVCImpl implements ConfigurationWatcher, LogSVC{
	private static final Logger log = LoggerFactory.getLogger(MongoLogSVCImpl.class);
	
	private String confPath = "/com/zpaas/log/logSVC";
	
	private static final String LOG_SERVER_KEY = "logServer";
	private static final String LOG_REPO_KEY = "logRepo";
	private static final String LOG_PATH_KEY = "logPath";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	private String logServer = null;
	private String logRepo = null;
	private String logPath = null;
	private String userName = null;
	private String password = null;
	private MongoDBClient mongo = null;
	private ConfigurationCenter cc = null;
	
	public MongoLogSVCImpl() {
		
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
			log.info("new log configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		boolean changed = false;
		if(json.getString(LOG_SERVER_KEY) != null && !json.getString(LOG_SERVER_KEY).equals(logServer)) {
			changed = true;
			logServer = json.getString(LOG_SERVER_KEY);
		}
		if(json.getString(LOG_REPO_KEY) != null && !json.getString(LOG_REPO_KEY).equals(logRepo)) {
			changed = true;
			logRepo = json.getString(LOG_REPO_KEY);
		}
		if(json.getString(USERNAME) != null && !json.getString(USERNAME).equals(userName)) {
			changed = true;
			userName = json.getString(USERNAME);
		}
		if(json.getString(PASSWORD) != null && !json.getString(PASSWORD).equals(password)) {
			changed = true;
			password = json.getString(PASSWORD);
		}
		if(json.getString(LOG_PATH_KEY) != null && !json.getString(LOG_PATH_KEY).equals(logPath)) {
			logPath = json.getString(LOG_PATH_KEY);
		}
		if(changed) {
			if(logServer != null) {
				mongo = new MongoDBClient(logServer,logRepo, userName, password);
				if(log.isInfoEnabled()) {
					log.info("log server address is changed to {}", logServer);
				}
			}
		}
	}
	
	public void write(JSONObject logJson) {
		mongo.insert(logRepo, logPath, logJson);
	}
	
	@SuppressWarnings("rawtypes")
	public void write(Map logMap) {
		mongo.insert(logRepo, logPath, logMap);
	}
	
	public void write(String log) {
		mongo.insert(logRepo, logPath, log);
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

	public static void main(String[] args) throws PaasException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "paasContext.xml" });
		LogSVC logWriter = (LogSVC)ctx.getBean("logWriter");
		for(int i=0; i<10; i++) {
			System.out.println(i);
			String log = "{level:'ERROR',server:'10.1.1.3',log:'test log "+new Date()+"'}";
			logWriter.write(log);
			JSONObject json = JSONObject.fromObject("{level:'ERROR',server:'10.1.1.4',log:'test log"+new Date()+"'}");
			logWriter.write(json);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
