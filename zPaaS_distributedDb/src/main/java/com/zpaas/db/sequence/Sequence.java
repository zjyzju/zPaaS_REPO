package com.zpaas.db.sequence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分布式数据库的Sequence实现类
 * @author zjy
 * @date 2014年6月23日 上午9:59:05 
 * @version V1.0
 */
public class Sequence {
	private final Lock lock = new ReentrantLock();
	
	private String sequenceName;
	private SequenceCache sequence;
	private SequenceService service;
	
	public Long nextValue() {
		if(sequence == null) {
			this.lock.lock();
			if(sequence == null) {
				sequence = service.getSequenceCache(sequenceName);
			}
			if(sequence == null) {
				return null;
			}
			this.lock.unlock();
		}
		long value = sequence.nextValue();
		if(value == -1) {
			this.lock.lock();
			value = sequence.nextValue();
			if(value == -1) {
				sequence = service.getSequenceCache(sequenceName);
			}
			if(sequence == null) {
				return null;
			}
			this.lock.unlock();
			if(value == -1) {
				value = sequence.nextValue();
			}
		}
		if(value == -1) {
			return null;
		}
		return value;
	}

	public String getSequenceName() {
		return sequenceName;
	}

	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	public SequenceService getService() {
		return service;
	}

	public void setService(SequenceService service) {
		this.service = service;
	}
	

}
