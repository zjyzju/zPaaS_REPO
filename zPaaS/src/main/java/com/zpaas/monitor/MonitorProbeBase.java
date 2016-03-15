package com.zpaas.monitor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.utils.CommonUtil;

/**
 * 监控探测器基类
 * @author ZhangJunyong
 *
 */
public abstract class MonitorProbeBase implements ConfigurationWatcher {
	public static final Logger log = LoggerFactory.getLogger(MonitorProbeBase.class);
	
	public static final String ZK_SERVER_KEY = "zk.server";
	public static final String ROOT_PATH = "/monitorRegistry";

	private String confPath = "/com/zpaas/monitor/monitorProbe";
	private ConfigurationCenter cc = null;
	private Properties props = null;
	
	private String zkServer = null;
	private ZooKeeper zk = null;
	private Map<String, String> monitorTargetMap = new HashMap<String, String>();
	
	private final Object lock = new Object();
	private String hostAddr = null;
	
	public void init() {
		if (log.isInfoEnabled()) {
			log.info("init MonitorProbe...");
		}
		hostAddr = CommonUtil.getHostAddr();
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new MonitorProbe configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		@SuppressWarnings("rawtypes")
		Iterator keys = json.keys();
		boolean changed = false;
		boolean zkChanged = false;
		if (keys != null) {
			String key = null;
			while (keys.hasNext()) {
				key = (String) keys.next();
				if(ZK_SERVER_KEY.equals(key) && (zkServer == null ||
						!zkServer.equals(json.getString(ZK_SERVER_KEY)))) {
					zkServer = json.getString(ZK_SERVER_KEY);
					zkChanged = true;
					continue;
				}
				if (props == null) {
					props = new Properties();
					changed = true;
				}
				if (props.containsKey(key)) {
					if (props.get(key) == null
							|| !props.get(key).equals(json.getString(key))) {
						props.put(key, json.getString(key));
						changed = true;
					}
				} else {
					props.put(key, json.getString(key));
					changed = true;
				}
			}
		}
		if(zkChanged) {
			if(zk != null) {
				try {
					zk.close();
				} catch (InterruptedException e) {
					log.error(e.getMessage(),e);
				}
			}
			try {
				zk = new ZooKeeper(zkServer, 6000, null);
				watchMonitorRegistry();
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
		}
		if (changed) {
			onConfigurationChanged();
		}
	}
	
	private Watcher wh = new Watcher() {
		public void process(WatchedEvent event) {
			if(log.isDebugEnabled()) {
				log.debug("receive watch event: {}", event.toString());
			}
			if(EventType.NodeChildrenChanged.equals(event.getType())) {
				if(ROOT_PATH.equals(event.getPath())) {
					synchronized(lock) {
						watchMonitorRegistry();
					}				
				}else {
					synchronized(lock) {
						monitorTarget(event.getPath());
					}
				}
			}
		}
	};
	
	public void watchMonitorRegistry() {
		Stat stat = null;
		try {
			stat = zk.exists(ROOT_PATH, true);
		} catch (Exception e) {			
		} 
		if(stat == null) {
			try {
				zk.create(ROOT_PATH, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			} 
		}
		
		try {
			List<String> monitorTargetTypes = zk.getChildren(ROOT_PATH, wh);
			monitorTargetType(monitorTargetTypes);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
	}
	
	public void monitorTargetType(List<String> monitorTargetTypes) {
		if(monitorTargetTypes != null && monitorTargetTypes.size() > 0) {
			for(String targetType : monitorTargetTypes) {
				monitorTarget(ROOT_PATH + "/" + targetType);
			}
		}
	}
	
	public void monitorTarget(String monitorTargetType) {
		try {
			List<String> monitorTargets = zk.getChildren(monitorTargetType, wh);
			Iterator<String> ite = monitorTargetMap.keySet().iterator();
			List<String> remove = new LinkedList<String>();
			while(ite.hasNext()) {
				String key = ite.next();
				if(key.startsWith(monitorTargetType+"/")) {
					remove.add(key);
				}
			}
			if(remove.size() > 0) {
				for(String key : remove) {
					monitorTargetMap.remove(key);
				}
			}
			if(monitorTargets != null && monitorTargets.size() > 0) {
				for(String monitorTarget : monitorTargets) {
					if(monitorTarget.startsWith(hostAddr+"_")) {
						String pid = "";
						try {
							pid = new String(zk.getData(monitorTargetType+"/"+monitorTarget, false, null));
						} catch (Exception e) {
							log.error(e.getMessage(),e);
						}
						monitorTargetMap.put(monitorTargetType+"/"+monitorTarget, pid);
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		
	}

	abstract public void onConfigurationChanged();
	
	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	public ConfigurationCenter getCc() {
		return cc;
	}

	public void setCc(ConfigurationCenter cc) {
		this.cc = cc;
	}
	
	public Map<String, String> getMonitorTargetMap() {
		return monitorTargetMap;
	}

	public Properties getProps() {
		return props;
	}

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "probeContext.xml" });
		ctx.getBean("monitorProbe");
		while(true) {
			Thread.sleep(1000);
		}
	}
}
