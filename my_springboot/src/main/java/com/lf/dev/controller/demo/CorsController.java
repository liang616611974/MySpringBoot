package com.lf.dev.controller.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @Title: CorsController.java
 * @Description: cors 跨域防御测试
 * @author Liangfeng
 * @date 2017/4/27 0027 上午 11:52
 * @version 1.0
 */
public class CorsController {

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/web/cors")
    public HashMap<String, Object> get(String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }
}
