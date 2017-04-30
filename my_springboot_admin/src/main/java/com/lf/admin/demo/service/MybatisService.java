package com.lf.admin.demo.service;

import com.lf.admin.demo.model.pojo.User;

/**
 * @Title: MybatisService.java
 * @Description: 
 * @author Liangfeng
 * @date 2017/4/30 0030 16:15
 * @version 1.0
 */
public interface MybatisService {

    public void insertForPrimary(User user);

    public void insertForSecondary(User user);


}
