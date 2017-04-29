package com.lf.admin.dev.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: FreemarkerController.java
 * @Description: Freemarker 测试
 * @author Liangfeng
 * @date 2017/4/26 0026 23:09
 * @version 1.0
 */
@Controller
public class FreemarkerController {

    @RequestMapping(value = "/web/free")
    public String index(ModelMap map) {
        map.put("title", "freemarker hello word");
        return "demo/freemarker/index"; // 开头不要加上/，linux下面会出错
    }
}
