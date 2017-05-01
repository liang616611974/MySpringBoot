package com.lf.admin.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: SpringSecurityController
 * @Description: 
 * @author Liangfeng
 * @date 2017/5/1 0001 23:11
 * @version 1.0
 */
@Controller
public class SpringSecurityController {

    private static final String htmlPath = "demo/security";

    @RequestMapping("/safe")
    public String index() {
        return htmlPath + "/index";
    }

    @RequestMapping("/secu/hello")
    public String hello() {
        return htmlPath + "/hello";
    }

    @RequestMapping("/login11")
    public String login() {
        return htmlPath + "/login";
    }




}
