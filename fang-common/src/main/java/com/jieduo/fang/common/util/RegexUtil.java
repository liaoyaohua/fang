package com.jieduo.fang.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author lyh
 *
 */
public abstract class RegexUtil {

	private static Pattern getPattern(String regex) {
		if (regex == null)
			return null;
		return Pattern
				.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	}

	/**
	 * 正则表达式替换
	 * 
	 * @param source
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static String replaceAll(String source, String regex,
			String replacement) {
		if (source == null || regex == null || regex.isEmpty()
				|| replacement == null)
			return source;
		return getPattern(regex).matcher(source).replaceAll(replacement);
	}

	/**
	 * 是否匹配
	 * 
	 * @param source
	 * @param regex
	 * @return
	 */
	public static boolean match(String source, String regex) {
		if (source == null || regex == null || regex.isEmpty())
			return false;
		Matcher matcher = getPattern(regex).matcher(source);
		return matcher.find();
	}

	/**
	 * 正则表达式捕获
	 * 
	 * @param source
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static String group(String source, String regex, int index)
			throws Exception {
		if (source == null || regex == null || regex.isEmpty())
			return source;
		Matcher matcher = getPattern(regex).matcher(source);
		if (matcher.find()) {
			if (index <= matcher.groupCount())
				return matcher.group(index);
		}
		return null;
	}

	/**
	 * 正则表达式捕获所有匹配
	 * 
	 * @param source
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static List<String> groups(String source, String regex, int index)
			throws Exception {
		List<String> result = new ArrayList<String>();
		if (source == null || regex == null || regex.isEmpty())
			return result;
		Matcher matcher = getPattern(regex).matcher(source);
		while (matcher.find()) {
			if (index <= matcher.groupCount())
				result.add(matcher.group(index));
		}
		return result;
	}

	/**
	 * 正则表达式捕获
	 * 
	 * @param source
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static String[] groups(String source, String regex, int[] indexs) {
		if (source == null || regex == null || regex.isEmpty()
				|| indexs == null || indexs.length == 0)
			return null;
		Matcher matcher = getPattern(regex).matcher(source);
		if (matcher.find()) {
			String[] result = new String[indexs.length];
			for (int i = 0; i < indexs.length; i++) {
				if (indexs[i] <= matcher.groupCount())
					result[i] = matcher.group(indexs[i]);
				else
					result[i] = null;
			}
			return result;
		}
		return null;
	}

	/**
	 * 捕获开始和结束区间的字符串
	 * 
	 * @param source
	 * @param begin
	 * @param end
	 * @return
	 */
	public static String between(String source, String begin, String end) {
		if (source == null || source.isEmpty())
			return source;
		Matcher matcher = null;
		int beginPos = 0;
		int endPos = source.length();
		if (begin != null && !begin.isEmpty()) {
			matcher = getPattern(begin).matcher(source);
			if (matcher.find()) {
				beginPos = matcher.end();
				if (beginPos == endPos - 1)
					return null;
			} else
				return null;
		}
		if (end != null && !end.isEmpty()) {
			if (beginPos == 0)
				matcher = getPattern(end).matcher(source);
			else
				matcher = getPattern(end).matcher(
						source.substring(beginPos + 1));
			if (matcher.find()) {
				endPos = matcher.start();
			} else
				return null;
		}
		return source.substring(beginPos + 1, endPos);
	}

	/**
	 * 是否匹配(完全匹配)
	 * 
	 * @param source
	 * @param regex
	 * @return
	 */
	public static boolean matchAll(String source, String regex) {
		if (StringUtils.isEmpty(source) || StringUtils.isEmpty(regex)) {
			return false;
		}

		Matcher matcher = getPattern(regex).matcher(source);
		return matcher.matches();
	}
}