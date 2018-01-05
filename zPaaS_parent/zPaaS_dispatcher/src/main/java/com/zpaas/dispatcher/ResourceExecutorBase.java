package com.zpaas.dispatcher;


import org.apache.log4j.Logger;
import com.zpaas.dispatcher.ResourceExecutor;
import net.sf.json.JSONArray;

public class ResourceExecutorBase implements ResourceExecutor {
	public static final Logger log = Logger.getLogger(ResourceExecutorBase.class);
	
	
	@SuppressWarnings("unused")
	private JSONArray allResources = null;
	private JSONArray resources = null;
	private Object lock = new Object();
	private boolean isRunning = false;
	
	
	@Override
	/**
	 * 当配置的总资源发生变化时，通过该方向告知实例
	 */
	public void modifyAllResources(JSONArray allResources) {
		this.allResources = allResources;
	}
	
	@Override
	/**
	 * 根据新分配的资源和原来分配的资源，在预分配阶段将不再分配给该实例的资源释放
	 * 当任务正在执行时，等任务执行完成后再再进行资源释放操作
	 */
	public void prepareResourceAllocate(JSONArray resources) {
		synchronized(lock) {
			if(log.isInfoEnabled()) {
				log.info("prepareResourceAllocate:" + resources);
			}
			int i=1;
			while(isRunning) {
				try {
					Thread.sleep(10000l*i++);
				} catch (InterruptedException e) {
					
				}
			}
			JSONArray tmp = new JSONArray();
			tmp.addAll(this.resources);
			tmp.removeAll(resources);
			JSONArray tmp1 = new JSONArray();
			tmp1.addAll(this.resources);
			tmp1.removeAll(tmp);
			this.resources = tmp1;
		}
	}
	
	/**
	 * 提交分配的资源
	 */
	public void commitResourceAllocate(JSONArray resources) {
		synchronized(lock) {
			if(log.isInfoEnabled()) {
				log.info("commitResourceAllocate:" + resources);
			}
			this.resources = resources;
		}
	}

	/**
	 * 是否允许释放该资源
	 */
	public boolean canReleaseResource(String resource) {
		if(log.isInfoEnabled()) {
			log.info("canReleaseResource:" + resources + ". Occupied resources:" + this.resources);
		}
		if(resources != null && resources.contains(resource)) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * 业务方法
	 */
	public void run() {
		synchronized(lock) {
			if(this.resources == null || this.resources.size() == 0) {
				if(log.isInfoEnabled()) {
					log.info("no resources, task exit.");
				}
				return;
			}
			
			this.isRunning = true;
			try {
				//do task
				for(int i=0; i< this.resources.size(); i++) {
					@SuppressWarnings("unused")
					String resource = this.resources.getString(i);
					//do business
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			} finally {
				this.isRunning = false;
			}
		}
	}
}
