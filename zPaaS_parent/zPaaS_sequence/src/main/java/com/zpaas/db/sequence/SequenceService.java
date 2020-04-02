package com.zpaas.db.sequence;

/**
 * Sequence服务接口类
 * @author zjy
 * @date 2014年6月23日 上午9:59:37 
 * @version V1.0
 */
public interface SequenceService {
	public SequenceCache getSequenceCache(String sequenceName);
}
