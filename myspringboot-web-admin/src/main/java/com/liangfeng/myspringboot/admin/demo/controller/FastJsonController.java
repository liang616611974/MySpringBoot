package com.liangfeng.myspringboot.admin.demo.controller;

import com.liangfeng.myspringboot.admin.dev.model.vo.DemoVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Title: FastJsonController.java
 * @Description: FastJson 测试
 * @author Liangfeng
 * @date 2017/4/27 0027 上午 11:52
 * @version 1.0
 */
@RestController
public class FastJsonController {

    /**
     * Spring Boot默认使用的json解析框架是jackson
     * @return
     */
    @RequestMapping("/web/getDemo")
    public DemoVO getDemo(){
        DemoVO demo = new DemoVO();
        demo.setId(1);
        demo.setName("张三");
        demo.setCreateTime(new Date());
        demo.setRemarks("这是备注信息");
        return demo;
    }

}
