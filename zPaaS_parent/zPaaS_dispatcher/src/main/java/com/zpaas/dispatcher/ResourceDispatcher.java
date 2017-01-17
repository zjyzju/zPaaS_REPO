package com.zpaas.dispatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;

/**
 * 分布式资源调度器
 * @author ZhangJunyong
 *
 */
public class ResourceDispatcher implements ConfigurationWatcher {
	
	public static final Logger log = LoggerFactory.getLogger(ResourceDispatcher.class);

	public static final String ROOT_PATH = "/dispatcher";
	public static final String EXECUTOR_PATH = "/executor";
	public static final String EXECUTOR_PATH1 = "/executor/";
	public static final String LEADER_PATH = "/leader";
	public static final String EXECUTOR_I_PATH = "/executor/executor_";
	public static final String OWNER_PATH = "/owners/";
	public static final String OWNER_PATH1 = "/owners";
	public static final String ZK_SERVER_KEY = "zkServer";
	public static final String RESOURCES_KEY = "resources";

	private int resourceAmount = 0;
	private JSONArray resourceArray = null;
	private String zkServer = null;

	private ZooKeeper zk = null;
	private Thread selectLeaderThread = null;
	private String nodeName = null;
	private String node = null;
	private final Object lock = new Object();
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();
	private boolean isLeader = false;
	private JSONArray occupiedResource = null;

	private ConfigurationCenter cc = null;
	private String confPath = "/com/zpaas/dispatcher/resourceDispatcher";
	private ResourceExecutor executor = null;
	private String resourceId = null;
	private String domainPath = null;

	private Watcher wh = new Watcher() {
		public void process(WatchedEvent event) {
			if (log.isDebugEnabled()) {
				log.debug("receive watch event: {}", event.toString());
			}
			if ((domainPath + LEADER_PATH).equals(event.getPath())) {
				if (EventType.NodeDeleted.equals(event.getType())) {
					if (log.isDebugEnabled()) {
						log.debug("Leader is down, notify to select leader.");
					}
					synchronized (lock) {
						lock.notifyAll();
					}
				}
			} else if (EventType.NodeChildrenChanged.equals(event.getType())
					&& (domainPath + EXECUTOR_PATH).equals(event.getPath())) {
				dispatchResource();
				
			} else if (EventType.NodeDataChanged.equals(event.getType()) && nodeName.equals(event.getPath())) {
				occupyResource();
				
			}
			
		}
	};

	public ResourceDispatcher() {

	}

	public void init() {
		if (log.isDebugEnabled()) {
			log.debug("init");
		}
		domainPath = ROOT_PATH + "/" + resourceId;
		try {
			process(cc.getConfAndWatch(confPath, this));
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

	public void process(String conf) {
		if (log.isInfoEnabled()) {
			log.info("new dispatcher configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		boolean changed = false;
		if (json.getString(ZK_SERVER_KEY) != null && !json.getString(ZK_SERVER_KEY).equals(zkServer)) {
			changed = true;
			zkServer = json.getString(ZK_SERVER_KEY);
		}
		boolean resChanged = false;
		if (resourceArray == null) {
			if (json.getJSONArray(RESOURCES_KEY) != null) {
				resChanged = true;
				resourceArray = json.getJSONArray(RESOURCES_KEY);
				resourceAmount = resourceArray.size();
				executor.modifyAllResources(resourceArray);
			}
		} else {
			if (json.getJSONArray(RESOURCES_KEY) != null
					&& !(json.getJSONArray(RESOURCES_KEY).containsAll(resourceArray) && resourceArray.containsAll(json
							.getJSONArray(RESOURCES_KEY)))) {
				resChanged = true;
				resourceArray = json.getJSONArray(RESOURCES_KEY);
				resourceAmount = resourceArray.size();
				executor.modifyAllResources(resourceArray);
			}
		}

		try {
			if (changed) {
				if (zkServer != null) {
					zk = new ZooKeeper(zkServer, 6000, wh);
					createPath();
					startService();
					if (selectLeaderThread != null) {
						selectLeaderThread.interrupt();
					}
					selectLeaderThread = new Thread() {
						public void run() {
							while (true && !this.isInterrupted()) {
								try {
									selectLeader();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					};
					selectLeaderThread.start();
				}
			} else {
				if (resChanged) {
					dispatchResource();
					
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

	public void createPath() throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("begin to createPath");
		}
		Stat stat = null;
		try {
			stat = zk.exists(ROOT_PATH, false);
		} catch (Exception e) {
		}
		if (stat == null) {
			try {
				zk.create(ROOT_PATH, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			}
		}

		try {
			stat = zk.exists(domainPath, false);
		} catch (Exception e) {
		}
		if (stat == null) {
			try {
				zk.create(domainPath, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			}
		}

		try {
			stat = zk.exists(domainPath + EXECUTOR_PATH, true);
		} catch (Exception e) {
		}
		if (stat == null) {
			try {
				zk.create(domainPath + EXECUTOR_PATH, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			}
		}

		try {
			stat = zk.exists(domainPath + OWNER_PATH1, false);
		} catch (Exception e) {
		}
		if (stat == null) {
			try {
				zk.create(domainPath + OWNER_PATH1, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (Exception e) {
			}
		}

	}

	public void selectLeader() {
		if (log.isDebugEnabled()) {
			log.debug("begin to select leader...");
		}
		try {
			Stat stat = zk.exists(domainPath + LEADER_PATH, true);
			String newLeader = null;
			if (stat == null) {
				newLeader = zk.create(domainPath + LEADER_PATH, nodeName.getBytes(), Ids.OPEN_ACL_UNSAFE,
						CreateMode.EPHEMERAL);
			}
			if (newLeader != null) {
				if (log.isDebugEnabled()) {
					log.debug("I'm the leader: {}", nodeName);
				}
				isLeader = true;
				dispatchResource();
				synchronized (lock) {
					lock.wait();
				}
			} else {
				if (log.isDebugEnabled()) {
					log.debug("follow leader.");
				}
				isLeader = false;
				synchronized (lock) {
					lock.wait();
				}
			}
		} catch (Exception e) {
		}
	}

	public void dispatchResource() {
		List<String> servers = null;
		try {
			servers = zk.getChildren(domainPath + EXECUTOR_PATH, true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (log.isDebugEnabled()) {
			log.debug("new servers: {}", servers);
		}
		
		if(servers == null || servers.size() == 0) {
			return;
		}
		synchronized (lock2) {

			if (!isLeader) {
				return;
			}
			if (log.isDebugEnabled()) {
				log.debug("begin to dispatch resource");
			}
			
			HashMap<String, JSONArray> lastAllocMap = new HashMap<>();
			for(String server : servers) {
				byte[] resourceByte = null;
				try {
					String serverNode = domainPath + EXECUTOR_PATH + "/" + server;
					if(nodeName.equals(serverNode)) {
						resourceByte = zk.getData(serverNode, true, null);	
					}else {
						resourceByte = zk.getData(serverNode, false, null);			
					}
				} catch (Exception e) {
				}				
				if (resourceByte != null) {
					lastAllocMap.put(server, JSONArray.fromObject(new String(resourceByte)));
				}else {
					lastAllocMap.put(server, null);
				}
			}
			
			//lastAllocMap is controlled by leader, can be used to judge whether has last resource occupying finished.
			//if last resource occupying not finish, wait until it finish.
			if (log.isDebugEnabled()) {
				log.debug("lastAllocMap: {}", lastAllocMap);
			}
			boolean lastFinished = true;
			HashMap<String, String> owners = null;
			int retry = 0;
			do {
				lastFinished = true;
				owners = new HashMap<>();
				HashMap<String, JSONArray> occupyMap = new HashMap<>();
				for (int i = 0; i < resourceAmount; i++) {
					String resource = resourceArray.getString(i);
					byte[] ownerByte = null;
					try {
						ownerByte = zk.getData(domainPath + OWNER_PATH + resource, false, null);
					} catch (Exception e) {
					}
					if (ownerByte != null) {
						String owner = new String(ownerByte);
						String server = owner.replace(domainPath + EXECUTOR_PATH1, "");
						JSONArray serverResources = occupyMap.get(server);
						if (serverResources == null) {
							serverResources = new JSONArray();
							occupyMap.put(server, serverResources);
						}
						serverResources.add(resource);
						owners.put(resource, owner);
					}
				}
				if (log.isDebugEnabled()) {
					log.debug("current resource owner: {}", owners);
					log.debug("current occupyMap: {}", occupyMap);
				}
				for(String server : lastAllocMap.keySet()) {
					JSONArray allocServerResources = lastAllocMap.get(server);
					if(allocServerResources == null) {
						continue;
					}
					JSONArray serverResources = occupyMap.get(server);
					if(allocServerResources.containsAll(serverResources) && serverResources.containsAll(allocServerResources)) {
						continue;
					}else {
						lastFinished = false;
						break;
					}
				}
				if(!lastFinished) {
					retry++;
					if(retry >= 5) {
						log.error("Have Waited for last resource occupying finish for max times, break.");
						break;
					}
					if(log.isInfoEnabled()) {
						log.info("Waiting for last resource occupying finish for times: {}", retry);
					}
					try {
						Thread.sleep(2000*retry);
					} catch (Exception e) {
					}
				}
			} while(!lastFinished);
			
			dispatcher(servers, owners);
			
		}
		if (log.isDebugEnabled()) {
			log.debug("dispatch round finished: {}", nodeName);
		}
	}

	public void dispatcher(List<String> servers, HashMap<String, String> owners) {
		if (servers == null || servers.size() == 0) {
			return;
		}
		int serverAmount = servers.size();
		int count = resourceAmount / serverAmount;
		int mod = resourceAmount % serverAmount;
		HashMap<String, ArrayList<String>> dispatchResult = new HashMap<String, ArrayList<String>>();
		if (owners == null || owners.size() == 0) {
			int j = 0;
			for (int i = 0; i < resourceAmount; i++) {
				String resource = resourceArray.getString(i);
				String server = servers.get(j);
				ArrayList<String> resources = dispatchResult.get(server);
				if (resources == null) {
					resources = new ArrayList<String>();
					dispatchResult.put(server, resources);
				}
				resources.add(resource);
				j++;
				if (j >= serverAmount) {
					j = 0;
				}
			}
		} else {
			HashMap<String, ArrayList<String>> old = new HashMap<String, ArrayList<String>>();
			ArrayList<String> allocated = new ArrayList<String>();
			for (String resource : owners.keySet()) {
				String server = owners.get(resource).replace(domainPath + EXECUTOR_PATH1, "");
				if (!servers.contains(server)) {
					continue;
				}
				ArrayList<String> resources = old.get(server);
				if (resources == null) {
					resources = new ArrayList<String>();
					old.put(server, resources);
				}
				allocated.add(resource);
				resources.add(resource);
			}

			if (log.isDebugEnabled()) {
				log.debug("allocated resource: {}", allocated);
				log.debug("allocate info: {}", old);
			}

			ArrayList<String> free = new ArrayList<String>();
			for (int i = 0; i < resourceAmount; i++) {
				String resource = resourceArray.getString(i);
				if (!allocated.contains(resource)) {
					free.add(resource);
				}
			}

			if (log.isDebugEnabled()) {
				log.debug("free resource: {}", free);
			}

			
			int tryTimes = 1;
			do {
				int k = mod;
				tryTimes++;
				for (String server : old.keySet()) {
					ArrayList<String> resources = old.get(server);
					int size = resources.size();
					if (size == count) {
						if (k > 0 && free.size() > 0) {
							k--;
							resources.add(free.remove(free.size() - 1));
						}
					} else if (size == count + 1) {
						if (k > 0) {
							k--;
						} else {
							free.add(resources.remove(size - 1));
						}
					} else if (size > count + 1) {
						if (k > 0) {
							k--;
							for (int i = size - 1; i > count; i--) {
								free.add(resources.remove(i));
							}
						} else {
							for (int i = size - 1; i >= count; i--) {
								free.add(resources.remove(i));
							}
						}
					} else {
						int freeSize = free.size();
						if (k > 0) {
							if(freeSize >= (count + 1 - size)) {
								k--;
								for (int i = freeSize - 1; i > freeSize - 1 - (count + 1 - size); i--) {
									resources.add(free.remove(i));
								}
							}else if(freeSize >= (count - size)) {
								for (int i = freeSize - 1; i > freeSize - 1 - (count - size); i--) {
									resources.add(free.remove(i));
								}
							}else if(freeSize > 0 && freeSize < (count - size)) {
								for (int i = freeSize - 1; i >= 0; i--) {
									resources.add(free.remove(i));
								}
							}						
						} else {
							if(freeSize >= (count - size)) {
								for (int i = freeSize - 1; i > freeSize - 1 - (count - size); i--) {
									resources.add(free.remove(i));
								}
							}else if(freeSize > 0 && freeSize < (count - size)) {
								for (int i = freeSize - 1; i >= 0; i--) {
									resources.add(free.remove(i));
								}
							}
						}
					}
				}
			} while(tryTimes <=2);//try two times for abnormal condition
			

			if (log.isDebugEnabled()) {
				log.debug("new allocated resource: {}", old);
				log.debug("new free resource: {}", free);
			}

			servers.removeAll(old.keySet());
			if (log.isDebugEnabled()) {
				log.debug("left servers need to assign resource: {}", servers);
			}
			int size = servers.size();
			int freeSize = free.size();
			if (size > 0 && freeSize > 0) {
				int j = 0;
				for (int i = 0; i < freeSize; i++) {
					String server = servers.get(j);
					ArrayList<String> resources = dispatchResult.get(server);
					if (resources == null) {
						resources = new ArrayList<String>();
						dispatchResult.put(server, resources);
					}
					resources.add(free.get(i));
					j++;
					if (j >= size) {
						j = 0;
					}
				}
				if (size > freeSize) {
					for (int i = freeSize; i < size; i++) {
						dispatchResult.put(servers.get(i), new ArrayList<String>());
					}
				}
			} else {
				if (size > 0) {
					for (int i = 0; i < size; i++) {
						dispatchResult.put(servers.get(i), new ArrayList<String>());
					}
				}
			}
			dispatchResult.putAll(old);
		}
		if (log.isDebugEnabled()) {
			log.debug("final allocate info: {}", dispatchResult);
		}
		
		for (String server : dispatchResult.keySet()) {
			try {
				zk.setData(domainPath + EXECUTOR_PATH + "/" + server, JSONArray.fromObject(dispatchResult.get(server))
						.toString().getBytes(), -1);
			} catch (Exception e) {
				
			}

		}

	}
	
	public void startService() throws Exception {
		nodeName = zk.create(domainPath + EXECUTOR_I_PATH, null, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		node = nodeName.substring(nodeName.lastIndexOf("/") + 1);
		if (log.isDebugEnabled()) {
			log.debug("{} : {} start to provide service.", nodeName, node);
		}

		zk.getData(nodeName, true, null);
	}

	@SuppressWarnings("unchecked")
	public void occupyResource() {
		String tmp = null;
		try {
			tmp = new String(zk.getData(nodeName, true, null));
		} catch (Exception e2) {
			log.error(e2.getMessage(),e2);
		} 
		JSONArray occupyResource = JSONArray.fromObject(tmp);
		synchronized (lock1) {
			try {				
				if (log.isDebugEnabled()) {
					log.debug("begin to occupy resource: {}", occupyResource);
				}
				executor.prepareResourceAllocate(JSONArray.fromObject(tmp));//修改成新的对象，避免executor修改后造成影响

				ArrayList<Object> left = new ArrayList<Object>();
				if (occupiedResource != null) {
					if (log.isDebugEnabled()) {
						log.debug("occupiedResource: {}", occupiedResource);
					}
					if (occupiedResource.containsAll(occupyResource) && occupyResource.containsAll(occupiedResource)) {
						if (log.isDebugEnabled()) {
							log.debug("occupyResource has no change, break.");
						}

						return;
					}
					ArrayList<Object> occupied = new ArrayList<Object>();
					occupied.addAll(JSONArray.toCollection(occupiedResource));

					ArrayList<Object> occupying = new ArrayList<Object>();
					occupying.addAll(JSONArray.toCollection(occupyResource));

					occupied.removeAll(occupying);
					int size = occupied.size();
					if (size > 0) {
						for (int i = 0; i < size; i++) {
							try {
								String resource = (String) occupied.get(i);
								int count = 1;
								while (!executor.canReleaseResource(resource)) {
									try {
										if (log.isDebugEnabled()) {
											log.debug("waite executor to release resource: {}", resource);
										}
										Thread.sleep(count * 1000);
									} catch (Exception e) {

									}
									count++;
								}
								String node = domainPath + OWNER_PATH + resource;
								if (log.isDebugEnabled()) {
									log.debug("release resource: {}", node);
								}
								zk.delete(node, -1);
							} catch (Exception e) {
								log.error(e.getMessage(), e);
							}
						}
					}

					occupied = new ArrayList<Object>();
					occupied.addAll(JSONArray.toCollection(occupiedResource));
					occupying.removeAll(occupied);
					left.addAll(occupying);
				} else {
					left.addAll(JSONArray.toCollection(occupyResource));
				}
				int count = 0;
				do {
					if (left.size() == 0) {
						break;
					}
					ArrayList<Object> resources = new ArrayList<Object>();
					resources.addAll(left);
					left = new ArrayList<Object>();
					int size = resources.size();
					for (int i = 0; i < size; i++) {
						String resource = (String) resources.get(i);
						String node = null;
						String occupyNode = domainPath + OWNER_PATH + resource;
						try {
							node = zk
									.create(occupyNode, nodeName.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
							if (log.isDebugEnabled()) {
								log.debug("occupy resource: {}", occupyNode);
							}
						} catch (Exception e) {
							
							String oldOwner = null;
							try {
								oldOwner = new String(zk.getData(occupyNode, false, null));
							} catch (Exception e1) {
							}
							if (nodeName.equals(oldOwner)) {
								continue;
							}
							
							String newRes = null;
							String oldRes = null;
							try {
								oldRes = new String(zk.getData(oldOwner, false, null));
								newRes = new String(zk.getData(nodeName, true, null));								
							} catch (Exception e1) {
							}
							if(oldRes != null) {
								JSONArray oldArray = JSONArray.fromObject(oldRes);
								if(oldArray.contains(resource)) {
									if (newRes == null) {
										log.warn("the resource had been assigned to {}.{} abandon occuping.", oldOwner, nodeName );
										occupyResource.remove(resource);
										continue;
									}else {
										JSONArray newArray = JSONArray.fromObject(newRes);
										if(!newArray.contains(resource)) {
											log.warn("the resource had been assigned to {}.{} abandon occuping.", oldOwner, nodeName);
											occupyResource.remove(resource);
											continue;
										}
									}
								}
							}

							if (log.isDebugEnabled()) {
								log.debug("failed to occupy resource: {}", occupyNode);
								log.debug("new occupyier is: {} old is: {}",nodeName, oldOwner);
							}
						}
						if (node == null) {
							left.add(resource);
						}
					}
					count++;
					if (left.size() > 0) {
						if (log.isDebugEnabled()) {
							log.debug("waiting for occupy resources: {}", count);
						}
						try {
							Thread.sleep(1000 * (count));
						} catch (Exception e) {

						}
					}
				} while (left.size() > 0);
				occupiedResource = occupyResource;
				JSONArray commitArray = new JSONArray();
				commitArray.addAll(occupiedResource);
				executor.commitResourceAllocate(commitArray);
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			} 
		}
		if (log.isDebugEnabled()) {
			log.debug("occupy resource finished: {}", nodeName);
		}
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

	public ResourceExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(ResourceExecutor executor) {
		this.executor = executor;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public int getResourceAmount() {
		return resourceAmount;
	}

	public JSONArray getResourceArray() {
		return resourceArray;
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "dispatcherContext.xml" });
		ctx.getBean("resourceDispatcher");
		while (true) {
			Thread.sleep(1000);
		}
	}
}
