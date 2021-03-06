package com.liangfeng.myspringboot.admin.common.Config;

import com.liangfeng.myspringboot.admin.common.constant.DatabaseConstant;
import com.liangfeng.myspringboot.common.framework.plugin.OffsetLimitInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
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
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Title: MybatisConfig.java
 * @Description: Mybatis 配置
 * @author Liangfeng
 * @date 2017/4/30 0030 10:49
 * @version 1.0
 */
@Configuration
public class MybatisConfig implements EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    private Environment env;

    private RelaxedPropertyResolver propertyResolver;

    public void setEnvironment(Environment env) {
        this.env = env;
        this.propertyResolver = new RelaxedPropertyResolver(env, "mybatis.");
    }


    /**
     * 创建 primarySqlSessionFactory
     * @param dataSource
     * @return
     */
    @Bean(name = DatabaseConstant.PRIMARY_SQL_SESSION_FACTORY)
    @Qualifier(DatabaseConstant.PRIMARY_SQL_SESSION_FACTORY)
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier(DatabaseConstant.PRIMARY_DATASOURCE)DataSource dataSource){
        return getSqlSessionFactory(DatabaseConstant.PRIMARY_SQL_SESSION_FACTORY,dataSource);
    }

    /**
     * 创建 secondarySqlSessionFactory
     * @param dataSource
     * @return
     */
    @Bean(name = DatabaseConstant.SECONDARY_SQL_SESSION_FACTORY)
    @Qualifier(DatabaseConstant.SECONDARY_SQL_SESSION_FACTORY)
    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier(DatabaseConstant.SECONDARY_DATASOURCE)DataSource dataSource){
        return getSqlSessionFactory(DatabaseConstant.SECONDARY_SQL_SESSION_FACTORY,dataSource);
    }

    /**
     * 创建 primarySqlSessionTemplate
     * @param sessionFactory
     * @return
     */
    @Bean(name = DatabaseConstant.PRIMARY_SQL_SESSION_TEMPLATE)
    @Qualifier(DatabaseConstant.PRIMARY_SQL_SESSION_TEMPLATE)
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier(DatabaseConstant.PRIMARY_SQL_SESSION_FACTORY)SqlSessionFactory sessionFactory){
        return new SqlSessionTemplate(sessionFactory);
    }

    /**
     * 创建 secondarySqlSessionTemplate
     * @param sessionFactory
     * @return
     */
    @Bean(name = DatabaseConstant.SECONDARY_SQL_SESSION_TEMPLATE)
    @Qualifier(DatabaseConstant.SECONDARY_SQL_SESSION_TEMPLATE)
    public SqlSessionTemplate secondarySqlSessionTemplate(@Qualifier(DatabaseConstant.SECONDARY_SQL_SESSION_FACTORY)SqlSessionFactory sessionFactory){
        return new SqlSessionTemplate(sessionFactory);
    }

    /**
     * 创建 SqlSessionFactory
     * @param sessionFactoryName 名称
     * @param dataSource 数据源
     * @return
     */
    private SqlSessionFactory getSqlSessionFactory(String sessionFactoryName, DataSource dataSource){
        logger.info("===============创建 " +  sessionFactoryName + " 开始===========");
        // 1.校验配置参数完整性
        if(StringUtils.isBlank(propertyResolver.getProperty("configLocation"))){
            logger.error("没有配置 Mybatis.configLocation 属性");
            throw new ApplicationContextException("没有配置 Mybatis.configLocation 属性");
        }
        // 2.创建 SqlSessionFactory
        SqlSessionFactory sessionFactory = null;
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        // 2.1 设置mybatis配置文件路径
        sessionFactoryBean.setConfigLocation(new DefaultResourceLoader()
                .getResource(propertyResolver.getProperty("configLocation")));
        try {
            // 2.2 设置Mapper.xml文件路径
            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources(propertyResolver.getProperty("mapperLocations")));
            // 2.3 设置分页插件
            Interceptor pageInterceptor = new OffsetLimitInterceptor();
            Properties properties = new Properties();
            properties.setProperty("dialectClass", propertyResolver.getProperty("dialect"));
            pageInterceptor.setProperties(properties);
            sessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
            sessionFactory = sessionFactoryBean.getObject();
        }catch (Exception e){
            logger.error("创建 " +  sessionFactoryName + " 发生异常",e);
            throw new ApplicationContextException("创建 " +  sessionFactoryName + " 发生异常");
        }
        logger.info("===============创建 " +  sessionFactoryName + " 结束===========");
        return sessionFactory;
    }



}
