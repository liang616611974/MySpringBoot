package com.lf.web.controller;

import com.lf.module.bean.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 在这里我们使用RestController  （等待于 @Controller 和 @RequestBody）
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2016年12月10日
 */
@RestController
public class HelloController2 {
	


	
	/**
	 * Spring Boot默认使用的json解析框架是jackson
	 * @return
	 */
	@RequestMapping("/getDemo1")
	public Demo getDemo(){
		Demo demo = new Demo();
		demo.setId(1);
		demo.setName("1111222333444555");
		demo.setCreateTime(new Date());
		demo.setRemarks("这是备注信息");
		return demo;
	}
	
}
