package com.lf.admin.demo.service.impl;

import com.lf.admin.common.constant.DatabaseConstant;
import com.lf.admin.demo.service.JdbcTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;


@Service
public class JdbcTemplateServiceImpl implements JdbcTemplateService {

    @Autowired
    @Qualifier(DatabaseConstant.PRIMARY_JDBC_TEMPLATE)
    JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier(DatabaseConstant.SECONDARY_JDBC_TEMPLATE)
    JdbcTemplate jdbcTemplate2;

    @Transactional(transactionManager = DatabaseConstant.PRIMARY_TX_MANAGER)
    @Override
    public void insert1(Map<String,Object> param) {
        String sql = "insert into user (id,name, create_time) values (?,?, ?)";
        jdbcTemplate1.update(sql, param.get("id"),param.get("username"), new Date());
        int i=1/0;
    }

    @Transactional(transactionManager = DatabaseConstant.SECONDARY_TX_MANAGER)
    @Override
    public void insert2(Map<String,Object> param) {
        String sql = "insert into user (id,name, create_time) values (?,?, ?)";
        jdbcTemplate2.update(sql, param.get("id"),param.get("username"), new Date());
        int i=1/0;
    }


}
