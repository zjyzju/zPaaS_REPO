package com.zpaas.monitor;

import java.util.Date;
import java.util.List;


public interface RegistrySerializer {
	public boolean newRegistry(String entry, Date startTime);
	public boolean hasValidRegistry(String entry);
	public boolean endRegistry(String entry, Date endTime);
	public List<String> queryInvalidRegistry(List<String> validEntries);
}
