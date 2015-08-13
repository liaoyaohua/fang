package com.jieduo.fang.common.util;

import java.util.UUID;

/**
 * 
 * @author lyh
 *
 */
public class UUIDUtil {
	public static synchronized String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("\\-", "");
	}
}
