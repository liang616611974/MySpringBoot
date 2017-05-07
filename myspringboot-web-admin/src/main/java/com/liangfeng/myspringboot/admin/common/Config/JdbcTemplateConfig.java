package com.liangfeng.myspringboot.admin.common.Config;

import com.liangfeng.myspringboot.admin.common.constant.DatabaseConstant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Title: JdbcTemplateConfig.java
 * @Description: spring JdbcTemplate 配置
 * @author Liangfeng
 * @date 2017/4/29 0029 17:16
 * @version 1.0
 */
@Configuration
public class JdbcTemplateConfig {

    /**
     * 配置 primaryJdbcTemplate
     * @param dataSource
     * @return
     */
    @Bean(name = DatabaseConstant.PRIMARY_JDBC_TEMPLATE)
    public JdbcTemplate primaryJdbcTemplate(@Qualifier(DatabaseConstant.PRIMARY_DATASOURCE)DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = DatabaseConstant.SECONDARY_JDBC_TEMPLATE)
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier(DatabaseConstant.SECONDARY_DATASOURCE)DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
