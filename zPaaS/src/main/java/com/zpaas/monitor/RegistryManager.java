package com.zpaas.monitor;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

/**
 * 监控注册管理器
 * @author ZhangJunyong
 *
 */
public class RegistryManager implements ConfigurationWatcher {
	public static final Logger log = LoggerFactory.getLogger(RegistryManager.class);
	
	public static final String ZK_SERVER_KEY = "zk.server";
	public static final String ROOT_PATH = "/monitorRegistry";
	public static final String LEADER_PATH = "/RegistryManager";

	private String confPath = "/com/zpaas/monitor/registryManager";
	private ConfigurationCenter cc = null;
	
	private RegistrySerializer serializer = null;
	
	private String zkServer = null;
	private ZooKeeper zk = null;
	private boolean isLeader = false;
	private Thread selectLeaderThread = null;
	private Map<String, String> monitorTargetMap = new HashMap<String, String>();
	
	private final Object lock = new Object();
	private boolean firstTime = true;
	
	
	public void init() {
		if (log.isInfoEnabled()) {
			log.info("init RegistryManager...");
		}
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new RegistryManager configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		@SuppressWarnings("rawtypes")
		Iterator keys = json.keys();
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
				if(selectLeaderThread != null) {
					selectLeaderThread.interrupt();
				}
				selectLeaderThread = new Thread() {
					public void run() {
						while(true && !this.isInterrupted()) {
							try {
								selectLeader();
							} catch (Exception e) {
								log.error(e.getMessage(),e);
							}
						}
					}
				};
				selectLeaderThread.start();
				watchMonitorRegistry();
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
		}
		
	}
	
	public void selectLeader() {
		if(log.isDebugEnabled()) {
			log.debug("begin to select leader...");
		}
		try {
			Stat stat = zk.exists(LEADER_PATH, wh);
			String newLeader = null;
			if(stat == null) {
				newLeader = zk.create(LEADER_PATH, null, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
			}
			if(newLeader != null) {
				if(log.isDebugEnabled()) {
					log.debug("I'm the leader");
				}
				isLeader = true;
				firstTime = true;
				synchronized(lock) {
					lock.wait();
				}
			}else {
				if(log.isDebugEnabled()) {
					log.debug("follow leader.");
				}
				isLeader = false;
				synchronized(lock) {
					lock.wait();
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
		} 
	}
	
	private Watcher wh = new Watcher() {
		public void process(WatchedEvent event) {
			if(log.isDebugEnabled()) {
				log.debug("receive watch event: {}", event.toString());
			}
			if(LEADER_PATH.equals(event.getPath())) {
				if(EventType.NodeDeleted.equals(event.getType())) {
					if(log.isDebugEnabled()) {
						log.debug("Leader is down, notify to select leader.");
					}
					synchronized(lock) {
						lock.notifyAll();
					}
				}
			}else if(EventType.NodeChildrenChanged.equals(event.getType())) {
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
	
	private void watchMonitorRegistry() {
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
			if(log.isDebugEnabled()) {
				log.debug("monitor TargetTypes: {}", monitorTargetTypes);
			}
			monitorTargetType(monitorTargetTypes);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
	}
	
	private void monitorTargetType(List<String> monitorTargetTypes) {
		if(monitorTargetTypes != null && monitorTargetTypes.size() > 0) {
			for(String targetType : monitorTargetTypes) {
				monitorTarget(ROOT_PATH + "/" + targetType);
			}
			if(isLeader && firstTime) {
				List<String> validTargets = new LinkedList<String>();
				Iterator<String> ite = monitorTargetMap.keySet().iterator();
				while(ite.hasNext()) {
					String key = ite.next();
					validTargets.add(key + "_" + monitorTargetMap.get(key));
				}
				List<String> invalidTargets = serializer.queryInvalidRegistry(validTargets);
				if(invalidTargets != null && invalidTargets.size() > 0) {
					for(String target : invalidTargets) {
						serializer.endRegistry(target, new Date());
					}
				}
				firstTime = false;
			}
		}
	}
	
	private void monitorTarget(String monitorTargetType) {
		try {
			List<String> monitorTargets = zk.getChildren(monitorTargetType, wh);
			if(log.isDebugEnabled()) {
				log.debug("{} has children: {}",monitorTargetType, monitorTargets);
			}
			Map<String, String> tmpMap = new HashMap<String, String>();
			if(monitorTargets != null && monitorTargets.size() > 0) {
				for(String monitorTarget : monitorTargets) {
					String pid = "";
					try {
						pid = new String(zk.getData(monitorTargetType + "/" + monitorTarget, false, null));
					} catch (Exception e) {
						e.printStackTrace();
					}
					tmpMap.put(monitorTargetType+"/"+monitorTarget, pid);
				}
			}
			if(log.isDebugEnabled()) {
				log.debug("old monitorTargetMap is: {}", monitorTargetMap);
			}
			if(isLeader) {
				Iterator<String> ite = monitorTargetMap.keySet().iterator();
				List<String> remove = new LinkedList<String>();
				while(ite.hasNext()) {
					String key = ite.next();
					if(!key.startsWith(monitorTargetType + "/")) {
						continue;
					}
					if(!tmpMap.containsKey(key)) {
						if(serializer != null) {
							serializer.endRegistry(key + "_" + monitorTargetMap.get(key), new Date());
						}
						remove.add(key);
					}else{
						if(!monitorTargetMap.get(key).equals(tmpMap.get(key))) {
							if(serializer != null) {
								serializer.endRegistry(key + "_" + monitorTargetMap.get(key), new Date());
								serializer.newRegistry(key + "_" + monitorTargetMap.get(key), new Date());
							}
							remove.add(key);
						}
					}
					tmpMap.remove(key);
				}
				if(remove.size() > 0) {
					for(String key : remove) {
						monitorTargetMap.remove(key);
					}
				}
				if(!tmpMap.isEmpty()) {
					ite = tmpMap.keySet().iterator();
					while(ite.hasNext()) {
						String key = ite.next();
						if(serializer != null) {
							if(!firstTime  || (firstTime && !serializer.hasValidRegistry(key + "_" + tmpMap.get(key)))) {
								serializer.newRegistry(key + "_" + tmpMap.get(key), new Date());
							}
						}
						monitorTargetMap.put(key, tmpMap.get(key));
					}					
				}
			}else {
				monitorTargetMap.clear();
				monitorTargetMap.putAll(tmpMap);
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		if(log.isDebugEnabled()) {
			log.debug("new monitorTargetMap is: {}", monitorTargetMap);
		}
		
	}
	
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

	public RegistrySerializer getSerializer() {
		return serializer;
	}

	public void setSerializer(RegistrySerializer serializer) {
		this.serializer = serializer;
	}

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "registryManagerContext.xml" });
		RegistryManager rm = (RegistryManager)ctx.getBean("registryManager");
		
		while(true) {
			Thread.sleep(10000);
			System.out.println(rm.getMonitorTargetMap());
		}
	}
}
