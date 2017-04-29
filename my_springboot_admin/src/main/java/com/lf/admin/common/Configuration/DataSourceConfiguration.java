package com.lf.admin.common.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;


import javax.sql.DataSource;

/**
 * @Title: DataSourceConfiguration.java
 * @Description: 数据源配置
 * @author Liangfeng
 * @date 2017/4/29 0029 16:18
 * @version 1.0
 */
@Configuration
public class DataSourceConfiguration implements EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    private Environment env;

    private RelaxedPropertyResolver propertyResolver;

    public void setEnvironment(Environment env) {
        this.env = env;
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }


    /**
     * 配置 primaryDataSource
     * @return
     */
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @Primary
    //@ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
        logger.info("===============加载 primaryDataSource 数据源 开始===========");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertyResolver.getProperty("primary.url"));
        dataSource.setUsername(propertyResolver.getProperty("primary.username"));
        dataSource.setPassword(propertyResolver.getProperty("primary.password"));
        dataSource.setDriverClassName(propertyResolver.getProperty("primary.driver"));
        logger.info("===============加载 primaryDataSource 数据源 结束===========");
        return dataSource;
    }

    /**
     * 配置 secondaryDataSource
     * @return
     */
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    //@ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource(){
        logger.info("===============加载 secondaryDataSource 数据源 开始===========");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertyResolver.getProperty("secondary.url"));
        dataSource.setUsername(propertyResolver.getProperty("secondary.username"));
        dataSource.setPassword(propertyResolver.getProperty("secondary.password"));
        dataSource.setDriverClassName(propertyResolver.getProperty("secondary.driver"));
        logger.info("===============加载 secondaryDataSource 数据源 结束===========");
        return dataSource;
    }


}
