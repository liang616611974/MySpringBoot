package com.liangfeng.myspringboot.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;


/**
 * @Title: MySpringBootApp.java
 * @Description: 系统启动入口
 * @author Liangfeng
 * @date 2017/4/28 0028 下午 3:54
 * @version 1.0
 */
@SpringBootApplication
public class MySpringBootApp {

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApp.class, args);
    }


}
