package com.zpaas.monitor;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.utils.CommonUtil;

/**
 * 监控注册器
 * @author ZhangJunyong
 *
 */
public class MonitorRegistry implements ConfigurationWatcher {
	public static final Logger log = Logger.getLogger(MonitorRegistry.class);
	
	public static final String ZK_SERVER_KEY = "zk.server";
	public static final String MONITOR_TARGET_TYPE = "monitor.target.type";
	public static final String ROOT_PATH = "/monitorRegistry";

	private String confPath = "/com/zpaas/monitor/monitorRegistry";
	private ConfigurationCenter cc = null;
	
	private String zkServer = null;
	private String monitorTargetType = null;
	private ZooKeeper zk = null;
	
	
	
	public void init() {
		if (log.isInfoEnabled()) {
			log.info("init MonitorRegistry...");
		}
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (PaasException e) {
			log.error(e.getMessage(),e);
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new MonitorRegistry configuration is received: " + conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		boolean serverChanged = false;
		if(json.getString(ZK_SERVER_KEY) != null && !json.getString(ZK_SERVER_KEY).equals(zkServer)) {
			serverChanged = true;
			zkServer = json.getString(ZK_SERVER_KEY);
		}
		
		boolean typeChanged = false;
		if(json.getString(MONITOR_TARGET_TYPE) != null && !json.getString(MONITOR_TARGET_TYPE).equals(monitorTargetType)) {
			typeChanged = true;
			monitorTargetType = json.getString(MONITOR_TARGET_TYPE);
		}
		
		if(serverChanged) {
			if(zk != null) {
				try {
					zk.close();
				} catch (InterruptedException e) {
					log.error(e.getMessage(),e);
					log.error("close old zk failed:" + e);
				}
			}
			try {
				zk = new ZooKeeper(zkServer, 6000, null);
			} catch (IOException e) {
				log.error(e.getMessage(),e);
				log.error("connect to zookeeper failed:" + e);
			}
		}
		
		if(typeChanged && zk != null) {
			registry();
		}
	}

	public void registry(){
		if(log.isDebugEnabled()) {
			log.debug("registry to zookeeper");
		}
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
		String typePath = ROOT_PATH+"/"+monitorTargetType;
		try {
			stat = zk.exists(typePath, true);
		} catch (Exception e) {			
		} 
		if(stat == null) {
			try {
				zk.create(typePath, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			} 
		}
		
		try {
			
			zk.create(typePath+"/"+CommonUtil.getHostAddr() + "_", CommonUtil.getProcessId().getBytes(), 
					Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		} catch (Exception e) {
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
	
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "monitorProbeContext.xml" });
		ctx.getBean("monitorRegistry");
		while(true) {
			Thread.sleep(1000);
		}
	}
}
