package com.zpaas.dispatcher;

import net.sf.json.JSONArray;

public interface ResourceExecutor {
	public void modifyAllResources(JSONArray allResources);
	public void prepareResourceAllocate(JSONArray resources);
	public void commitResourceAllocate(JSONArray resources);
	public boolean canReleaseResource(String resource);
}
