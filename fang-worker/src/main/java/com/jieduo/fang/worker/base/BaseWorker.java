package com.jieduo.fang.worker.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lyh
 *
 */
public abstract class BaseWorker {
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseWorker.class);

	public void doWork() {
		this.process();
	}
	
	public abstract void process();
}
