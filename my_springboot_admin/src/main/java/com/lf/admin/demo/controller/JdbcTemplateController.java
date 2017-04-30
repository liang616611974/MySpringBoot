package com.lf.admin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Title: JdbcTemplateController.java
 * @Description: JdbcTemplate 测试
 * @author Liangfeng
 * @date 2017/4/29 0029 18:23
 * @version 1.0
 */
@RestController
public class JdbcTemplateController {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate jdbcTemplate2;

    @RequestMapping("/jdbc/test1")
    public String test1(){
        List<Map<String,Object>> list = jdbcTemplate1.queryForList("select * from user");
        return Arrays.asList(list).toString();
    }

    @RequestMapping("/jdbc/test2")
    public String test2(){
        List<Map<String,Object>> list = jdbcTemplate2.queryForList("SELECT * from user");
        return Arrays.asList(list).toString();
    }


}
