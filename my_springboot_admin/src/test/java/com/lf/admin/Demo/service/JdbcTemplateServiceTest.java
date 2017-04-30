package com.lf.admin.Demo.service;

import com.lf.admin.demo.service.JdbcTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateServiceTest {

    @Autowired
    JdbcTemplateService jdbcTemplateService;

    int i = 8;

    @Test
    public void insert1() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id",i);
        param.put("username","用户" + i);
        jdbcTemplateService.insert1(param);
    }

    @Test
    public void insert2() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id",i);
        param.put("username","用户" + i);
        jdbcTemplateService.insert2(param);
    }

}
