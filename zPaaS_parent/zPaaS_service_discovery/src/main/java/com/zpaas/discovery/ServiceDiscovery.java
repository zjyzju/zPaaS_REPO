package com.zpaas.discovery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

import com.yjcloud.discovery.util.CipherUtil;
import com.yjcloud.discovery.util.CommandUtil;
import com.yjcloud.discovery.util.CommonUtil;

import net.sf.json.JSONObject;

/**
 * 托管类应用发现类
 * 
 * @author ZhangJunyong
 *
 */
public class ServiceDiscovery {
	public static final Logger log = Logger.getLogger(ServiceDiscovery.class);
	private static final Object lock = new Object();

	private static final Pattern p = Pattern.compile("\\{\\{([^\\{]*)\\}\\}");

	private static final String RANGE_FLAG = "{{RANGE}}";
	private static final String END_FLAG = "{{END}}";
	private static final String INDEX = "INDEX";
	private static final String FOREACH = "{{FOREACH_";
	private static final String SEPARATOR = "___";
	private static final String APP_PATH = "app";
	private static final String DISCOVERY_PATH = "discovery";
	public static final String WEB_APP_PATH = "webApp";
	public static final String LACAL_APP_PATH = "localApp";
	public static final String DOMAIN_TYPE_DOMAIN = "domain";
	public static final String DOMAIN_TYPE_IP = "ip";

	public static final String PROXY_NEXT_UPSTREAM = "proxy_next_upstream";
	public static final String PROXY_CONNECT_TIMEOUT = "proxy_connect_timeout";
	public static final String PROXY_READ_TIMEOUT = "proxy_read_timeout";
	public static final String PROXY_SEND_TIMEOUT = "proxy_send_timeout";
	public static final String POLICY = "policy";
	public static final String MAX_FAILS = "max_fails";
	public static final String FAIL_TIMEOUT = "fail_timeout";

	public static final String NGINX_CONF_TPL = "nginx.conf.tpl";
	public static final String NGINX_UPSTREAM_CONF_TPL = "nginx.upstream.conf.tpl";
	public static final String NGINX_LOCALTION_CONF_TPL = "nginx.localtion.conf.tpl";
	public static final String UPSTREAM_CONF_SUFFIX = ".upstream.conf";
	public static final String LOCALTION_CONF_SUFFIX = ".localtion.conf";

	private String zkServer = null;
	private String zkAuth = null;
	private String basePath = null;
	private String routeTplFilePath = null;
	private String routeFile = null;
	private String routerCmd = null;
	private String restartRouterCmd = null;
	private String domainType = null;

	private ZooKeeper zookeeper = null;
	private String appPath = null;
	private String discoveryPath = null;

	private String monitorPath = null; // 监听的目录名，取最后一级，旧的agent为webApp;

	private String defaultNginxConfigPath = null; // "/yjcloud/cache/nginxConfigCacheSVC";
	private String proxy_next_upstream = null; // "error";
	private String proxy_connect_timeout = null; // "120s";
	private String proxy_read_timeout = null; // "600s";
	private String proxy_send_timeout = null; // "120s";
	private String policy = "";
	private String max_fails = null; // "3";
	private String fail_timeout = null; // "10s";

	/**
	 * 构造函数
	 * 
	 * @param zkServer
	 *            注册中心地址
	 * @param zkAuth
	 *            注册中心鉴权信息
	 * @param basePath
	 *            注册中心基础路径
	 * @param routeTplFile
	 *            路由模板文件
	 * @param routeFile
	 *            路由文件
	 * @param routerCmd
	 *            路由程序路径
	 * @param restartRouterCmd
	 *            平滑重启路由程序脚本
	 * @throws Exception
	 */
	public ServiceDiscovery(String zkServer, String zkAuth, String basePath, String monitorPath,
			String defaultNginxConfigPath, String routeTplFilePath, String routeFile, String routerCmd,
			String restartRouterCmd, String domainType) throws Exception {
		this.zkServer = zkServer;
		this.zkAuth = zkAuth;
		this.basePath = basePath;
		this.routeTplFilePath = routeTplFilePath;
		this.routeFile = routeFile;
		this.routerCmd = routerCmd;
		this.restartRouterCmd = restartRouterCmd;
		this.domainType = domainType;
		this.defaultNginxConfigPath = defaultNginxConfigPath;
		this.monitorPath = monitorPath;

		this.appPath = this.basePath + "/" + APP_PATH + "/" + monitorPath;
		this.discoveryPath = this.basePath + "/" + DISCOVERY_PATH;

		try {
			zookeeper = new ZooKeeper(this.zkServer, 10000, new Watcher() {
				public void process(WatchedEvent arg0) {

				}
			});
		} catch (IOException e) {
			log.error("connect to zookeeper failed.");
			log.error(e.getMessage(), e);
			throw e;
		}
		if (this.zkAuth != null && this.zkAuth.length() > 0) {
			zookeeper.addAuthInfo("digest", CipherUtil.decrypt(this.zkAuth).getBytes());
		}

		this.createPath();

		String discoveryNode = "/ServiceDiscovery" + SEPARATOR + CommonUtil.getHostAddr() + SEPARATOR;
		String agentNodePath = null;
		try {
			agentNodePath = zookeeper.create(discoveryPath + discoveryNode, "".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.EPHEMERAL_SEQUENTIAL);
		} catch (Exception e) {
			log.error("register ServiceDiscovery to zookeeper failed.");
			log.error(e.getMessage(), e);
			throw e;
		}
		if (log.isInfoEnabled()) {
			log.info("register ServiceDiscovery to zookeeper:" + agentNodePath);
		}

		List<String> serverRegistry = zookeeper.getChildren(this.appPath, wh);
		if (log.isDebugEnabled()) {
			log.debug("get new serverRegistry:" + serverRegistry);
		}

		String data = new String(zookeeper.getData(defaultNginxConfigPath, configWh, null));
		if (StringUtils.isNotBlank(data)) {
			updateDefaultConfig(new String(data));
		}

		if (serverRegistry != null && serverRegistry.size() > 0) {
			this.restartRouter(serverRegistry);
		}

	}

	/**
	 * 在上级目录不存在的情况下，创建目录
	 */
	private void createPath() {
		if (log.isDebugEnabled()) {
			log.debug("begin to createPath");
		}
		Stat stat = null;
		try {
			stat = zookeeper.exists(basePath, true);
		} catch (Exception e) {
		}
		if (stat == null) {
			try {
				zookeeper.create(basePath, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			}
		}

		try {
			stat = zookeeper.exists(appPath, true);
		} catch (Exception e) {
		}
		if (stat == null) {
			try {
				zookeeper.create(appPath, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			}
		}

		try {
			stat = zookeeper.exists(discoveryPath, true);
		} catch (Exception e) {
		}
		if (stat == null) {
			try {
				zookeeper.create(discoveryPath, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * app目录的Watcher
	 */
	private Watcher wh = new Watcher() {
		public void process(WatchedEvent event) {
			if (log.isDebugEnabled()) {
				log.debug("receive watch event:" + event.toString());
			}
			if (EventType.NodeChildrenChanged.equals(event.getType()) && (appPath).equals(event.getPath())) {
				try {
					List<String> appServerRegistry = zookeeper.getChildren(appPath, wh);
					if (log.isDebugEnabled()) {
						log.debug("get new serverRegistry:" + appServerRegistry);
					}
					restartRouter(appServerRegistry);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			} else if (Event.KeeperState.Expired.equals(event.getState())) {
				try {
					zookeeper = new ZooKeeper(zkServer, 10000, wh);
					log.info("reconnect to zookeeper for expired");
					if (zkAuth != null && zkAuth.length() > 0) {
						zookeeper.addAuthInfo("digest", CipherUtil.decrypt(zkAuth).getBytes());
					}
					zookeeper.getData(defaultNginxConfigPath, configWh, null);
					List<String> appServerRegistry = zookeeper.getChildren(appPath, wh);
					if (log.isDebugEnabled()) {
						log.debug("get new serverRegistry:" + appServerRegistry);
					}
					restartRouter(appServerRegistry);
				} catch (Exception e) {
					log.error("connect zookeeper failed", e);
				}
			}

		}
	};

	/**
	 * nginx默认配置节点的Watcher
	 */
	private Watcher configWh = new Watcher() {
		public void process(WatchedEvent event) {
			if (log.isDebugEnabled()) {
				log.debug("receive watch event:" + event.toString());
			}
			if (EventType.NodeDataChanged.equals(event.getType()) && (defaultNginxConfigPath).equals(event.getPath())) {
				try {
					byte[] data = zookeeper.getData(defaultNginxConfigPath, configWh, null);
					if (data != null) {
						updateDefaultConfig(new String(data));
					}
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			} else if (Event.KeeperState.Expired.equals(event.getState())) {
				try {
					zookeeper = new ZooKeeper(zkServer, 10000, wh);
					log.info("reconnect to zookeeper for expired");
					if (zkAuth != null && zkAuth.length() > 0) {
						zookeeper.addAuthInfo("digest", CipherUtil.decrypt(zkAuth).getBytes());
					}
					byte[] data = zookeeper.getData(defaultNginxConfigPath, configWh, null);
					if (data != null) {
						updateDefaultConfig(new String(data));
					}
					zookeeper.getChildren(appPath, wh);
				} catch (Exception e) {
					log.error("connect zookeeper failed", e);
				}
			}

		}
	};

	/**
	 * 更新nginx的默认配置
	 * 
	 * @param defaultConfig
	 * 
	 */
	public void updateDefaultConfig(String defaultConfig) {
		if (log.isDebugEnabled()) {
			log.debug("update nginx default config: " + defaultConfig);
		}
		try {
			if (StringUtils.isNotBlank(defaultConfig)) {
				JSONObject json = JSONObject.fromObject(defaultConfig);
				if (json.has(PROXY_NEXT_UPSTREAM)) {
					this.proxy_next_upstream = json.getString(PROXY_NEXT_UPSTREAM);
				}
				if (json.has(PROXY_CONNECT_TIMEOUT)) {
					this.proxy_connect_timeout = json.getString(PROXY_CONNECT_TIMEOUT);
				}
				if (json.has(PROXY_READ_TIMEOUT)) {
					this.proxy_read_timeout = json.getString(PROXY_READ_TIMEOUT);
				}
				if (json.has(PROXY_SEND_TIMEOUT)) {
					this.proxy_send_timeout = json.getString(PROXY_SEND_TIMEOUT);
				}
				if (json.has(MAX_FAILS)) {
					this.max_fails = json.getString(MAX_FAILS);
				}
				if (json.has(FAIL_TIMEOUT)) {
					this.fail_timeout = json.getString(FAIL_TIMEOUT);
				}
				if (json.has(POLICY)) {
					this.policy = json.getString(POLICY);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setAppMapConfig(HashMap<String, Object> appMap, JSONObject nodeConfig) {

		if (nodeConfig.has(PROXY_NEXT_UPSTREAM)) {
			appMap.put(PROXY_NEXT_UPSTREAM, nodeConfig.getString(PROXY_NEXT_UPSTREAM));
		} else {
			appMap.put(PROXY_NEXT_UPSTREAM, proxy_next_upstream);
		}
		if (nodeConfig.has(PROXY_READ_TIMEOUT)) {
			appMap.put(PROXY_READ_TIMEOUT, nodeConfig.getString(PROXY_READ_TIMEOUT));
		} else {
			appMap.put(PROXY_READ_TIMEOUT, proxy_read_timeout);
		}
		if (nodeConfig.has(PROXY_SEND_TIMEOUT)) {
			appMap.put(PROXY_SEND_TIMEOUT, nodeConfig.getString(PROXY_SEND_TIMEOUT));
		} else {
			appMap.put(PROXY_SEND_TIMEOUT, proxy_send_timeout);
		}
		if (nodeConfig.has(PROXY_CONNECT_TIMEOUT)) {
			appMap.put(PROXY_CONNECT_TIMEOUT, nodeConfig.getString(PROXY_CONNECT_TIMEOUT));
		} else {
			appMap.put(PROXY_CONNECT_TIMEOUT, proxy_connect_timeout);
		}
		if (nodeConfig.has(POLICY)) {
			appMap.put(POLICY, nodeConfig.getString(POLICY) + ";");
		} else {
			appMap.put(POLICY, policy);
		}
	}

	/**
	 * 重启路由器
	 * 
	 * @param serverRegistry
	 *            从注册中心获取的应用注册信息
	 */
	public void restartRouter(List<String> serverRegistry) {
		synchronized (lock) {
			this.updateRouteFile(serverRegistry);
			String[] cmd = new String[] { restartRouterCmd, routerCmd, routeFile };
			CommandUtil.execCommand(cmd);
		}
	}

	/**
	 * 更新路由文件
	 * 
	 * @param serverRegistry
	 *            从注册中心获取的应用注册信息
	 * @throws Exception
	 */
	public void updateRouteFile(List<String> serverRegistry) {
		ArrayList<HashMap<String, Object>> appLst = new ArrayList<HashMap<String, Object>>();
		HashMap<String, HashMap<String, Object>> cacheMap = new HashMap<String, HashMap<String, Object>>();
		if (serverRegistry != null && serverRegistry.size() > 0) {
			for (String registry : serverRegistry) {
				// 获取配置信息
				JSONObject nodeConfig = new JSONObject();
				try {
					String data = new String(zookeeper.getData(this.appPath + "/" + registry, true, null));
					if (StringUtils.isNotBlank(data)) {
						log.info("nodeData is " + data);
						nodeConfig = JSONObject.fromObject(data);
					}
				} catch (Exception e1) {
					nodeConfig = new JSONObject();
					e1.printStackTrace();
				}

				String[] array = registry.split(SEPARATOR);
				String frontUrl = null;
				try {
					frontUrl = URLDecoder.decode(array[4], "UTF-8");
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
				if (frontUrl != null && frontUrl.endsWith("/")) {
					frontUrl = frontUrl.substring(0, frontUrl.length() - 1);
				}
				String frontContext = null;
				if (DOMAIN_TYPE_DOMAIN.equals(this.domainType)) {
					if (frontUrl.lastIndexOf("/") > frontUrl.indexOf("//") + 1) {
						frontContext = frontUrl.substring(frontUrl.lastIndexOf("/"));
					} else {
						frontContext = frontUrl.substring(frontUrl.indexOf("//") + 1, frontUrl.indexOf("."));
					}
				} else {
					frontContext = frontUrl.substring(frontUrl.lastIndexOf("/"));
				}
				String backendUrl = null;
				try {
					backendUrl = URLDecoder.decode(array[5], "UTF-8");
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
				if (backendUrl != null && backendUrl.startsWith("http://")) {
					backendUrl = backendUrl.substring(7);
				}
				String deployName = null;
				if (backendUrl != null && backendUrl.indexOf("/") >= 0) {
					deployName = backendUrl.substring(backendUrl.indexOf("/") + 1);
					backendUrl = backendUrl.substring(0, backendUrl.indexOf("/"));
				}
				//增加对ip地址正确性的验证，ip地址不符合格式就过滤这条记录
				boolean flag = true;
				if (backendUrl != null) {
					if (backendUrl.indexOf(":") >= 0) {
						flag = isIPAddress(backendUrl.substring(0, backendUrl.indexOf(":")));
					}
					if (flag == false) {
						continue;
					}
				} else {
					continue;
				}
				String serverName = frontContext.substring(1);

				HashMap<String, Object> appMap = cacheMap.get(frontUrl);
				if (appMap == null) {
					appMap = new HashMap<String, Object>();
					cacheMap.put(frontUrl, appMap);
					appLst.add(appMap);
					appMap.put("aclRule", serverName);
					appMap.put("backend", serverName);
					appMap.put("frontContext", frontContext);
					appMap.put("deployName", deployName);
					setAppMapConfig(appMap, nodeConfig);
				}

				@SuppressWarnings("unchecked")
				ArrayList<HashMap<String, Object>> instLst = (ArrayList<HashMap<String, Object>>) appMap
						.get("serverInsts");
				if (instLst == null) {
					instLst = new ArrayList<HashMap<String, Object>>();
					appMap.put("serverInsts", instLst);
				}
				HashMap<String, Object> instMap = new HashMap<String, Object>();
				instMap.put("backendUrl", backendUrl);
				instMap.put("serverName", serverName);
				if (nodeConfig.has(MAX_FAILS)) {
					instMap.put(MAX_FAILS, MAX_FAILS + "=" + nodeConfig.getString(MAX_FAILS));
				} else {
					instMap.put(MAX_FAILS, MAX_FAILS + "=" + max_fails);
				}
				if (nodeConfig.has(FAIL_TIMEOUT)) {
					instMap.put(FAIL_TIMEOUT, FAIL_TIMEOUT + "=" + nodeConfig.getString(FAIL_TIMEOUT));
				} else {
					instMap.put(FAIL_TIMEOUT, FAIL_TIMEOUT + "=" + fail_timeout);
				}
				instLst.add(instMap);
			}
		}
		// 分别更新对应的upstream.conf和localtion.conf,用include的方式更新到总的conf
		this.genRouteFile(routeTplFilePath + "/" + NGINX_UPSTREAM_CONF_TPL,
				routeTplFilePath + "/" + monitorPath + UPSTREAM_CONF_SUFFIX, appLst);
		this.genRouteFile(routeTplFilePath + "/" + NGINX_LOCALTION_CONF_TPL,
				routeTplFilePath + "/" + monitorPath + LOCALTION_CONF_SUFFIX, appLst);
		HashMap<String, Object> confMap = new HashMap<String, Object>();
		confMap.put("configPath", routeTplFilePath);
		ArrayList<HashMap<String, Object>> confLst = new ArrayList<HashMap<String, Object>>();
		confLst.add(confMap);
		// 更新nginx.conf
		this.genRouteFile(routeTplFilePath + "/" + NGINX_CONF_TPL, routeFile, confLst);

	}

	/**
	 * 生成路由文件
	 * 
	 * @param tplFile
	 *            路由文件模板
	 * @param appLst
	 *            应用信息列表
	 */
	public void genRouteFile(String tplFilePath, String targetFilePath, ArrayList<HashMap<String, Object>> appLst) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(tplFilePath)));
			String line = null;
			StringBuilder sb = new StringBuilder("\n");
			StringBuilder rangeStr = null;
			boolean rangeFlag = false;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(RANGE_FLAG)) {
					rangeFlag = true;
					rangeStr = new StringBuilder();
				} else if (line.startsWith(END_FLAG)) {
					String rangeResult = this.processRange(rangeStr.toString(), appLst);
					if (rangeResult == null) {
						return;
					}
					sb.append(rangeResult).append("\n");
					rangeFlag = false;
					rangeStr = null;
				} else if (rangeFlag) {
					rangeStr.append(line).append("\n");
				} else {
					sb.append(line).append("\n");
				}
			}
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFilePath)));
			writer.write(sb.toString());
			writer.flush();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * 处理模板文件中的{{RANGE}}标签
	 * 
	 * @param rangeStr
	 *            RANGE标签内的文本
	 * @param appLst
	 *            应用信息
	 * @return 返回生成好的文本
	 */
	public String processRange(String rangeStr, ArrayList<HashMap<String, Object>> appLst) {
		if (appLst == null || appLst.size() == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder("\n");
		BufferedReader reader = null;

		try {
			String line = null;
			for (HashMap<String, Object> appMap : appLst) {
				reader = new BufferedReader(new StringReader(rangeStr));
				while ((line = reader.readLine()) != null) {
					if (line.startsWith(FOREACH)) {
						int off = line.indexOf("}}");
						String key = line.substring(FOREACH.length(), off);
						line = line.substring(off + 2);
						Object instLst = appMap.get(key);
						if (instLst instanceof ArrayList<?>) {
							int index = 0;
							for (HashMap<String, Object> instMap : (ArrayList<HashMap<String, Object>>) instLst) {
								result.append(this.processLine(line, instMap, appMap, index++)).append("\n");
							}

						} else {
							log.error(
									"type of map key <" + key + ">'s value is not ArrayList<HashMap<String, Object>>");
						}

					} else {
						result.append(this.processLine(line, appMap, null, 0)).append("\n");
					}
				}
				reader.close();
			}
			return result.toString();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * 处理模板中的{{FOREACH_serverInsts}}标签
	 * 
	 * @param line
	 *            行文本
	 * @param mainMap
	 *            主替换信息存在的Map
	 * @param secondMap
	 *            辅助替换信息存在的Map
	 * @param index
	 *            索引号
	 * @return 返回处理好的文本
	 */
	public String processLine(String line, HashMap<String, Object> mainMap, HashMap<String, Object> secondMap,
			int index) {
		Matcher m = p.matcher(line);
		HashSet<String> keySet = new HashSet<String>();
		while (m.find()) {
			keySet.add(m.group(1));
		}
		if (!keySet.isEmpty()) {
			String result = line;
			Iterator<String> keyIt = keySet.iterator();
			String key = null;
			Object value = null;
			while (keyIt.hasNext()) {
				key = keyIt.next();
				if (INDEX.equals(key)) {
					value = "" + index;
				} else {
					value = mainMap.get(key);
					if (value == null && secondMap != null) {
						value = secondMap.get(key);
					}
					if (value == null) {
						value = "\\{\\{" + key + "\\}\\}";
					}
				}

				result = result.replaceAll("\\{\\{" + key + "\\}\\}", value.toString());
			}
			return result;
		} else {
			return line;
		}
	}

	public static boolean isIPAddress(String ipaddr) {
		boolean flag = false;
		Pattern pattern = Pattern.compile(
				"\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher m = pattern.matcher(ipaddr);
		flag = m.matches();
		return flag;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		if (args.length != 10) {
			System.out.println("Must have 10 params.");
			return;
		}
		String zkServer = args[0];
		String zkAuth = args[1];
		String basePath = args[2];
		String monitorPath = args[3];
		if (monitorPath.contains("/")) {
			System.out.println("监控路径只需传入最后一级目录名，ps:为了兼容旧的agent,web应用托管的服务发现监听目录为webApp");
			return;
		}
		String defaultNginxConfigPath = args[4];
		String routeTplFilePath = args[5];
		String routeFile = args[6];
		String routerCmd = args[7];
		String restartRouterCmd = args[8];
		String domainType = args[9];
		ServiceDiscovery sd = new ServiceDiscovery(zkServer, zkAuth, basePath, monitorPath, defaultNginxConfigPath,
				routeTplFilePath, routeFile, routerCmd, restartRouterCmd, domainType);

		while (true) {
			try {
				Thread.sleep(50000l);
			} catch (Exception e) {

			}
		}

	}
}
