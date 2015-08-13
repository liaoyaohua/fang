package com.jieduo.fang.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lyh
 *
 */
public class ThreadUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ThreadUtils.class);

	/**
	 * 线程睡眠
	 * 
	 * @param str
	 * @return
	 */
	public static void sleep(long millis) {
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			LOGGER.error("ThreadUtils sleep error", e);
		}
	}

}