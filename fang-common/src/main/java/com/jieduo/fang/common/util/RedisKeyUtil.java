package com.jieduo.fang.common.util;

/**
 * Redis key 生成器
 * 
 * @author lyh
 *
 */
public class RedisKeyUtil {
	// 活动每天兑换数量key
    public static String getDailyExchangeCountKey(Long actId, String date) {
    	return String.format("fang.act.DailyExchangeCountKey.%s.%s", actId, date);
    }
    
    public static void main(String[] args) {
		System.out.println(getDailyExchangeCountKey(4L, "2015-08-03"));
	}
}
