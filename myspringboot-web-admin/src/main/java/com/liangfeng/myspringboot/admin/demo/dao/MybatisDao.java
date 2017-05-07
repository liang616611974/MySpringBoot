package com.liangfeng.myspringboot.admin.demo.dao;


import com.liangfeng.myspringboot.admin.demo.model.pojo.User;

/**
 * @Title: MybatisDao.java
 * @Description: 
 * @author Liangfeng
 * @date 2017/4/30 0030 14:39
 * @version 1.0
 */
public interface MybatisDao {

    public void insertForPrimary(User user);

    public void insertForSecondary(User user);

}
