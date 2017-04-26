/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.lf.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring-boot-demo-6-2
 * 
 * @author wujing
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {

	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	@RequestMapping(value = "index")
	public String index(ModelMap map) {
		logger.debug("debug hahah================");
		logger.info("info ====================");
		map.put("title", "thymeleaf hello word");
		return "index";
	}

	@RequestMapping(value = "error")
	public String error(ModelMap map) {
		throw new RuntimeException("测试异常");
	}

}
