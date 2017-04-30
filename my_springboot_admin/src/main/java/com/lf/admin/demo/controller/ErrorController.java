package com.lf.admin.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: ErrorController.java
 * @Description: 异常测试
 * @author Liangfeng
 * @date 2017/4/27 0027 上午 11:51
 * @version 1.0
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/web/error")
    public String error(ModelMap map) {
        throw new RuntimeException("测试异常");
    }
}
