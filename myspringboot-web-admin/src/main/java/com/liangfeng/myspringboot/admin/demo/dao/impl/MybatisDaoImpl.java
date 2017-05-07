package com.liangfeng.myspringboot.admin.demo.dao.impl;


import com.liangfeng.myspringboot.admin.common.constant.DatabaseConstant;
import com.liangfeng.myspringboot.admin.demo.dao.MybatisDao;
import com.liangfeng.myspringboot.admin.demo.model.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisDaoImpl implements MybatisDao{

    @Autowired
    @Qualifier(DatabaseConstant.PRIMARY_SQL_SESSION_TEMPLATE)
    SqlSessionTemplate primaryTemplate;

    @Autowired
    @Qualifier(DatabaseConstant.SECONDARY_SQL_SESSION_TEMPLATE)
    SqlSessionTemplate secondaryTemplate;

    @Override
    public void insertForPrimary(User user) {
        primaryTemplate.insert("User.insert",user);
    }

    @Override
    public void insertForSecondary(User user) {
        secondaryTemplate.insert("User.insert",user);
    }
}
