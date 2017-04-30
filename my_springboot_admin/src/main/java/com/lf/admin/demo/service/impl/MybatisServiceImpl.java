package com.lf.admin.demo.service.impl;

import com.lf.admin.demo.dao.MybatisDao;
import com.lf.admin.demo.model.pojo.User;
import com.lf.admin.demo.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: MybatisServiceImpl.java
 * @Description: 
 * @author Liangfeng
 * @date 2017/4/30 0030 16:31
 * @version 1.0
 */
@Service
public class MybatisServiceImpl implements MybatisService {

    @Autowired
    MybatisDao mybatisDao;

    @Override
    public void insertForPrimary(User user) {
        mybatisDao.insertForPrimary(user);
    }

    @Override
    public void insertForSecondary(User user) {
        mybatisDao.insertForSecondary(user);
    }
}
