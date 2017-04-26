package com.lf.dev.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: ThymeleafController.java
 * @Description: thymeleaf 测试
 * @author Liangfeng
 * @date 2017/4/27 0027 1:05
 * @version 1.0
 */
@Controller
public class ThymeleafController {

    @RequestMapping(value = "/web/thyme")
    public String index(ModelMap map) {
        map.put("title", "thymeleaf hello word");
        return "demo/thymeleaf/index";
    }
}
