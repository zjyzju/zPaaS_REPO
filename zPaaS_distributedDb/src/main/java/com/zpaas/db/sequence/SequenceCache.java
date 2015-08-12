package com.zpaas.db.sequence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分段缓存的sequence类
 * @author zjy
 * @date 2014年6月19日 上午11:15:10 
 * @version V1.0
 */
public class SequenceCache {
	private final Lock lock = new ReentrantLock();
	
	private long start;
	private long end;
	private long current;
	
	private boolean over;
	
	public SequenceCache(long start, long end) {
		this.start = start;
		this.end = end;
		current = this.start -1;
	}
	
	public long nextValue() {
		this.lock.lock();
		current++;
		long nextValue = current;
		this.lock.unlock();
		if(nextValue > end) {
			over = true;
			nextValue = -1;
		}
		return nextValue;
	}

	public long getStart() {
		return start;
	}

	public long getEnd() {
		return end;
	}

	public boolean isOver() {
		return over;
	}

	public long getCurrent() {
		return current;
	}
	
	
}
