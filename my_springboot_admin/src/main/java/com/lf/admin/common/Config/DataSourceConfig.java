package com.lf.admin.common.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lf.admin.common.constant.DatabaseConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @Title: DataSourceConfig.java
 * @Description: 数据源配置
 * @author Liangfeng
 * @date 2017/4/29 0029 16:18
 * @version 1.0
 */
@Configuration
public class DataSourceConfig implements EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    private Environment env;

    private RelaxedPropertyResolver propertyResolver;

    public void setEnvironment(Environment env) {
        this.env = env;
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }


    /**
     * 创建 primaryDataSource
     * @return
     */
    @Bean(name = DatabaseConstant.PRIMARY_DATASOURCE)
    @Qualifier(DatabaseConstant.PRIMARY_DATASOURCE)
    @Primary
    //@ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
        return getDruidDataSource(DatabaseConstant.PRIMARY,DatabaseConstant.PRIMARY_DATASOURCE);
    }

    /**
     * 创建 secondaryDataSource
     * @return
     */
    @Bean(name = DatabaseConstant.SECONDARY_DATASOURCE)
    @Qualifier(DatabaseConstant.SECONDARY_DATASOURCE)
    //@ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource(){
        return getDruidDataSource(DatabaseConstant.SECONDARY,DatabaseConstant.SECONDARY_DATASOURCE);
    }


 /*   public BeanNameAutoProxyCreator dataSourceSpyInterceptor(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setInterceptorNames();
        beanNameAutoProxyCreator.setBeanNames(DatabaseConstant.PRIMARY_DATASOURCE,DatabaseConstant.SECONDARY_DATASOURCE);
    }*/

    /**
     * 创建 DruidDataSource 数据连接池
     * @param dbName 数据库名称
     * @param dataSourceName 数据源名称
     * @return
     */
    private DruidDataSource getDruidDataSource(String dbName,String dataSourceName){
        logger.info("===============创建 " + dataSourceName + " 数据源 开始===========");
        // 1.校验配置参数完整性
        if(StringUtils.isBlank(propertyResolver.getProperty( dbName + ".url"))||
                StringUtils.isBlank(propertyResolver.getProperty(dbName + ".username"))||
                StringUtils.isBlank(propertyResolver.getProperty(dbName + ".password"))||
                StringUtils.isBlank(propertyResolver.getProperty(dbName + ".driver"))){
            logger.error(dataSourceName + " 数据源配置信息不完整");
            throw new ApplicationContextException(dataSourceName + " 数据源配置信息不完整");
        }
        // 2.创建 DruidDataSource 连接池
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertyResolver.getProperty( dbName + ".url"));
        dataSource.setUsername(propertyResolver.getProperty(dbName + ".username"));
        dataSource.setPassword(propertyResolver.getProperty(dbName + ".password"));
        dataSource.setDriverClassName(propertyResolver.getProperty(dbName + ".driver"));
        logger.info("===============创建 " +  dataSourceName + " 数据源 结束===========");
        return dataSource;
    }



}
