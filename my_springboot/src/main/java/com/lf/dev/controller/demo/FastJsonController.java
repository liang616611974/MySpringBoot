package com.lf.dev.controller.demo;

import com.lf.dev.model.vo.DemoVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
