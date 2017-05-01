package com.lf.admin.Demo.service;

import com.lf.admin.demo.model.pojo.User;
import com.lf.admin.demo.service.MybatisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Title: MybatisServiceTest.java
 * @Description: 
 * @author Liangfeng
 * @date 2017/4/30 0030 16:34
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisServiceTest {

    @Autowired
    MybatisService mybatisService;

    int i = 12;

    @Test
    public void testInsertForPrimary(){
        User user = new User();
        user.setId(i);
        user.setName("用户" + i);
        user.setCreateTime(new Date());
        mybatisService.insertForPrimary(user);
    }

    @Test
    public void testInsertForSecondary(){
        User user = new User();
        user.setId(i);
        user.setName("用户" + i);
        user.setCreateTime(new Date());
        mybatisService.insertForSecondary(user);
    }

}
