package com.lf.admin.common.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Title: JdbcTemplateConfiguration.java
 * @Description: spring JdbcTemplate 配置
 * @author Liangfeng
 * @date 2017/4/29 0029 17:16
 * @version 1.0
 */
@Configuration
public class JdbcTemplateConfiguration {

    /**
     * 配置 primaryJdbcTemplate
     * @param dataSource
     * @return
     */
    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
