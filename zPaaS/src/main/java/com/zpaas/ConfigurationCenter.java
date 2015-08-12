package com.zpaas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import com.zpaas.utils.CipherUtil;

/**
 * zPaaS核心类，统一配置中心
 * @author ZhangJunyong
 *
 */
public class ConfigurationCenter {
	
	private static final Logger log = Logger.getLogger(ConfigurationCenter.class);
	
	public static final String DEV_MODE="D";
	public static final String PROD_MODE="P";
	
	private ZooKeeper zookeeper = null;	
	private String zkServer = null;
	private String zkAuth = null;	
	private String runMode = PROD_MODE;//P:product mode; D:dev mode
	
	private String configurationFile="/PaasConfigurationFile.properties";
	private Properties props = new Properties();
	private String charset = null;
	
	private HashMap<String, ArrayList<ConfigurationWatcher>> subsMap = null;
	
	public ConfigurationCenter(String zkServer, String runMode, String charset,String configurationFile) {
		this.zkServer = zkServer;
		this.runMode = runMode;
		if(configurationFile != null) {
			this.configurationFile = configurationFile;
		}
		this.charset = charset;
	}
	
	public ConfigurationCenter(String zkServer, String runMode) {
		this.zkServer = zkServer;
		this.runMode = runMode;
	}
	
	public ConfigurationCenter(String zkServer, String runMode, String charset) {
		this.zkServer = zkServer;
		this.runMode = runMode;
		this.charset = charset;
	}
	
	public String getConfAndWatch(String confPath, ConfigurationWatcher warcher)throws PaasException {
		ArrayList<ConfigurationWatcher> watcherList = subsMap.get(confPath);
		if(watcherList == null) {
			watcherList = new ArrayList<ConfigurationWatcher>();
			subsMap.put(confPath, watcherList);
		}
		watcherList.add(warcher);
		return this.getConf(confPath);	
	}
	
	public String getConf(String confPath)throws PaasException {
		String conf = null;
		try {
			if(DEV_MODE.equals(this.getRunMode())) {
				return props.getProperty(confPath);
			}else {
				if(charset == null) {
					conf = new String(zookeeper.getData(confPath, true, null));
				}else {
					conf = new String(zookeeper.getData(confPath, true, null),charset);
				}
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new PaasException("9999", "failed to get configuration from configuration center", e);
		} 
		return conf;
	}
	
	public void init() {
		if(DEV_MODE.equals(runMode)) {
			try {
				props.load(this.getClass().getResourceAsStream(configurationFile));
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
			subsMap = new HashMap<String, ArrayList<ConfigurationWatcher>>();
			return;
		}
		try {
			zookeeper = new ZooKeeper(zkServer, 10000, new Watcher() {
				public void process(WatchedEvent event) {
					if(log.isInfoEnabled()) {
						log.info(event.toString());
					}
					if(Event.EventType.NodeDataChanged.equals(event.getType()) && subsMap.size() > 0) {
						String path = event.getPath();
						ArrayList<ConfigurationWatcher> watcherList = subsMap.get(path);
						if(watcherList != null && watcherList.size() > 0) {
							for(ConfigurationWatcher watcher : watcherList) {
								try {
									watcher.process(getConf(path));
								} catch (PaasException e) {
									log.error(e.getMessage(),e);
								}
							}
						}
					}
				}
			});
			if(zkAuth != null && zkAuth.length() > 0) {
				zookeeper.addAuthInfo("digest", CipherUtil.decrypt(zkAuth).getBytes());
			}
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		subsMap = new HashMap<String, ArrayList<ConfigurationWatcher>>();
	}
	
	@SuppressWarnings("rawtypes")
	public void removeWatcher(String confPath, Class warcherClazz)throws PaasException {
		ArrayList<ConfigurationWatcher> watcherList = subsMap.get(confPath);
		try {
			if(watcherList == null) {
				zookeeper.getData(confPath, false, null);
			}else {
				int size = watcherList.size();
				for(int i=size-1; i>=0; i--) {
					if(watcherList.get(i).getClass().equals(warcherClazz)) {
						watcherList.remove(i);
					}
				}
				if(watcherList.size() == 0) {
					zookeeper.getData(confPath, false, null);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new PaasException("9999", "failed to get configuration from configuration center", e);
		} 
			
	}
	
	public boolean setData(String path, String data) {
		try {
			zookeeper.setData(path, data.getBytes(), -1);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return false;
		} 
	}
	
	public String getRunMode() {
		return runMode;
	}

	public String getConfigurationFile() {
		return configurationFile;
	}

	public void setConfigurationFile(String configurationFile) {
		this.configurationFile = configurationFile;
	}
	
	public String getAuth() {
		return zkAuth;
	}

	public void setAuth(String zkAuth) {
		this.zkAuth = zkAuth;
	}

	public static void main(String[] args) throws Exception{
		System.out.println(DigestAuthenticationProvider.generateDigest(""));
	}
}

