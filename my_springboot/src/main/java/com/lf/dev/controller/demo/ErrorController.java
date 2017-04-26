package com.lf.dev.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: ErrorController.java
 * @Description: 错误处理 测试
 * @author Liangfeng
 * @date 2017/4/27 0027 1:29
 * @version 1.0
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/web/error")
    public String error(ModelMap map) {
        throw new RuntimeException("测试异常");
    }
}
