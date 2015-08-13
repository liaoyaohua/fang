package com.jieduo.fang.domain.util;

import net.spy.memcached.HashAlgorithm;



/**
 * 分表算法
 * 
 * @author lyh
 *
 */
public class RouteUtil {
    /**
     * 根据hash计算出在路由环上的落点。
     * 为保证平均分配，采用的%算法
     * 起始值为0
     *
     * @param hashCode
     * @return 传入的hashCode在路由环上的落点
     */
    public static int getRouteCode(String routeSeed, int routeCount) {
    	if (routeSeed == null || "".equals(routeSeed)) {
			return -1;
		}
    	
    	if (routeCount == 0) {
			return 0;
		}
    	
    	String routeSeedTrim = routeSeed.trim().toLowerCase();
        long hashCode = HashAlgorithm.KETAMA_HASH.hash(routeSeedTrim);
        return (int)(hashCode % routeCount);
    }

}
