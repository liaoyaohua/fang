package com.jieduo.fang.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lyh
 *
 */
public class DateUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	
	public static final String df_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String df_yyyy_MM_dd = "yyyy-MM-dd";
	public static final String df_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String df_yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String df_yyyyMMdd = "yyyyMMdd";
	public static final String df_yyyyMMdd_Virgule = "yyyy/MM/dd HH:mm";
	
	/**
	 * 计算某个日期距离今天的天数
	 *
	 * @param beforeDate
	 * @param afterDate
	 * @return
	 */
	public static int daysAwayNow(String beforeDateStr) {
		Date beforeDate = parseTimeDate(beforeDateStr);
		return daysBetween(beforeDate, new Date());
	}

	/**
	 * 计算2个日期之间相差的天数
	 *
	 * @param beforeDate
	 * @param afterDate
	 * @return
	 */
	public static Integer daysBetween(Date beforeDate, Date afterDate) {
		if (beforeDate == null || afterDate == null) {
			return null;
		}
		return (int)((afterDate.getTime() / 86400000L) - (beforeDate.getTime() / 86400000L)); 
	}
	
	/**
	 * 计算2个日期之间相差的天数
	 *
	 * @param beforeDate
	 * @param afterDate
	 * @return
	 */
	public static int daysBetween(String beforeDateStr, String afterDateStr) {
		Date beforeDate = parseTimeDate(beforeDateStr);
		Date afterDate = parseTimeDate(afterDateStr);
		
		return daysBetween(beforeDate, afterDate);
	}

	public static Date parseTimeDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(df_yyyy_MM_dd_HH_mm_ss);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			LOGGER.error("parseDate error", e);
		}
		
		return null;
	}
	
	/**
	 * 获取当前时间字符串
	 *
	 * @return
	 */
	public static String currentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(df_yyyy_MM_dd_HH_mm_ss);
		return sdf.format(new Date());		
	}
	
	/**
	 * 指定的date是否在当前时间之后
	 * 比如传入的date为: 2015-05-27 08:12:41  当前日期为 2015-05-27 09:12:41, 则返回值为false
	 *
	 * @param date
	 * @return
	 */
	public static boolean isAfter(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(df_yyyy_MM_dd_HH_mm_ss);
		Date parseDate = null;
		try {
			parseDate = sdf.parse(date);
		} catch (ParseException e) {
			LOGGER.error("parseDate error", e);
			return false;
		}
		if (parseDate == null) {
			return false;
		}
		
		return parseDate.after(new Date());
	}
	
}
