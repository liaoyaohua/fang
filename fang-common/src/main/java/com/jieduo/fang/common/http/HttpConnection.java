package com.jieduo.fang.common.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author bjliaoyh
 *
 */
public class HttpConnection {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpConnection.class);

	/**
	 * 链接超时
	 */
	private static final int TASK_SCHEDULE_CONNECT_TIMEOUT = 10000;
	/**
	 * 读数据超时
	 */
	private static final int TASK_SCHEDULE_READ_TIMEOUT = 10000;
	
	/**
	 * 连接
	 * 
	 * @param url
	 * @param encode
	 * @return
	 */
	public String connect(String url, String encode) {
		// 建立连接
		HttpURLConnection httpURLConnection = createConnection(url);
		if(httpURLConnection == null) {
			return null;
		}
		
		// 提交连接
		String res = post(httpURLConnection, encode);
		httpURLConnection.disconnect();
		return res;
	}

	/**
	 * 建立连接
	 * 
	 * @param connetUrl
	 * @param param
	 * @return
	 */
	private HttpURLConnection createConnection(String connetUrl) {
		// 构建URL对象
		URL url = null;
		try {
			url = new URL(connetUrl);
		} catch (MalformedURLException e) {
			LOGGER.error("new url error", e);
		}
		if(url == null) {
			return null;
		}
		
		// 打开url连接
		URLConnection urlConnection = null;
		try {
			urlConnection = url.openConnection();
		} catch (IOException e) {
			LOGGER.error("openConnection error", e);
		}
		if (urlConnection == null) {
			return null;
		}
		
		urlConnection.setConnectTimeout(TASK_SCHEDULE_CONNECT_TIMEOUT);
		urlConnection.setReadTimeout(TASK_SCHEDULE_READ_TIMEOUT);
		HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
		// http正文内，因此需要设为true
		httpURLConnection.setDoOutput(true);
		try {
			httpURLConnection.setRequestMethod("POST");
		} catch (ProtocolException e) {
			LOGGER.error("setRequestMethod error", e);
			return null;
		}

		// 建立连接
		try {
			httpURLConnection.connect();
		} catch (IOException e) {
			LOGGER.error("connect error", e);
			return null;
		}
	
		return httpURLConnection;
	}

	/**
	 * post 提交
	 * 
	 * @param httpURLConnection
	 * @param encode
	 * @return
	 */
	private String post(HttpURLConnection httpURLConnection, String encode) {
		int responseCode = 0;
		try {
			responseCode = httpURLConnection.getResponseCode();
		} catch (IOException e) {
			LOGGER.error("HttpConnection getResponseCode error", e);
			return null;
		}
		
		if (responseCode != 200) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		try {
			inputStream = httpURLConnection.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, encode));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			LOGGER.error("HttpConnection getInputStream error", e);
		} finally {
			try {
				if(bufferedReader != null) {
					bufferedReader.close();
				}
				
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (Exception e) {
				LOGGER.error("HttpConnection close error", e);
			}
		}
		
		return sb.toString();
	}

}
