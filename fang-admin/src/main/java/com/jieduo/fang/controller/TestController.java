package com.jieduo.fang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jieduo.fang.controller.base.BaseController;

/**
 * 
 * @author lyh
 *
 */
@Controller
@RequestMapping("/")
public class TestController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "")
	public String index(Model view) {
		return "test/index";
	}
	
}