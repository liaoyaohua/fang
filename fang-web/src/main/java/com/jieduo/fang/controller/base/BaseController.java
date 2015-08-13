package com.jieduo.fang.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lyh
 *
 */
public class BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	
	protected String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		try {
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("http_client_ip");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			// 如果是多级代理，那么取第一个ip为客户ip
			if (ip != null && ip.contains(",")) {
				ip = ip.substring(0, ip.lastIndexOf(","));
			}
		} catch (Exception e) {
			LOGGER.error("getIpAddress error!", e);
		}
		return ip;
	}

}
