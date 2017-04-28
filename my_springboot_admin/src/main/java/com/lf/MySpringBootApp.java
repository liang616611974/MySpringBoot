package com.lf;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;


/**
 * @Title: MySpringBootApp.java
 * @Description: 系统启动入口
 * @author Liangfeng
 * @date 2017/4/28 0028 下午 3:54
 * @version 1.0
 */
@SpringBootApplication
public class MySpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApp.class, args);
    }


}
