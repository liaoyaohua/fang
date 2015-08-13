package com.jieduo.fang.controller.base;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.Writer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.jieduo.fang.common.util.JsonUtils;
import com.jieduo.fang.common.util.RegexUtil;
import com.jieduo.fang.domain.base.ResultParam;
import com.jieduo.fang.editor.CustomTimestampEditor;

/**
 * base controller
 * 
 * @author lyh
 *
 */
public class BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor(
				new SimpleDateFormat("HH:mm:ss")));
	}
	
	protected void writeJson(Object data, HttpServletResponse response) {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/plain;charset=GBK");
		Writer writer = null;
		try {
			writer = response.getWriter();
			writer.write(JsonUtils.objectToJson(data));
			writer.flush();
		} catch (Exception e) {
			LOGGER.error("BaseController writeJson error", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					LOGGER.error("BaseController close error", e);
				}
			}
		}
	}
	
	protected boolean validImg(InputStream inputStream, String fileName, int width, int height, ResultParam resultParam) {
		if(!RegexUtil.match(fileName.toLowerCase(), ".+[.]jpg")) {
			resultParam.setFlag(false);
			resultParam.setMessage("请上传图片文件, 只支持jpg格式！");
			return false;
		}
		try {
			BufferedImage bi = ImageIO.read(inputStream);
			if ((bi.getWidth() != width) || (bi.getHeight() != height)) {
				resultParam.setFlag(false);
				resultParam.setMessage("图片高度或宽度尺寸不正确！");
				return false;
			}
			return true;
		} catch (Exception e) {
			LOGGER.error("validImg read error", e);
			return false;
		}
	}
	
	protected void writeErrorJson(ResultParam resultParam, String message, HttpServletResponse response) {
		resultParam.setFlag(false);
		resultParam.setMessage(message);
		this.writeJson(resultParam, response);
	}
}
