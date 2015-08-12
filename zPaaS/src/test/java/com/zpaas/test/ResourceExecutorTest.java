package com.zpaas.test;

import com.zpaas.dispatcher.ResourceExecutor;

import net.sf.json.JSONArray;

/**
 * 示例类
 * @author ZhangJunyong
 *
 */
public class ResourceExecutorTest implements ResourceExecutor {
	private JSONArray resources = null;
	@SuppressWarnings("unused")
	private JSONArray allResources = null;
	private Object lock = new Object();
	
	@Override
	public void modifyAllResources(JSONArray allResources) {
		this.allResources = allResources;
	}
	
	@Override
	public void prepareResourceAllocate(JSONArray resources) {
		synchronized(lock) {
			System.out.println("prepareResourceAllocate:" + resources);
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("prepareResourceAllocate: clear resources");
			JSONArray tmp = new JSONArray();
			tmp.addAll(this.resources);
			tmp.removeAll(resources);
			JSONArray tmp1 = new JSONArray();
			tmp1.addAll(this.resources);
			tmp1.removeAll(tmp);
			this.resources = tmp1;
		}
	}
	
	
	public void commitResourceAllocate(JSONArray resources) {
		synchronized(lock) {
			System.out.println("commitResourceAllocate:" + resources);
			this.resources = resources;
		}
	}

	
	public boolean canReleaseResource(String resource) {
		System.out.println("canReleaseResource:" + resources);
		if(resources != null && resources.contains(resource)) {
			System.out.println("canReleaseResource: false");
			return false;
		}else {
			System.out.println("canReleaseResource: true");
			return true;
		}
	}

}
