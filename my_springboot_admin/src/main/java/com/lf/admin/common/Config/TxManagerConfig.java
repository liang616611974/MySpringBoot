package com.lf.admin.common.Config;

import com.lf.admin.common.constant.DatabaseConstant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Title: TxManagerConfig.java
 * @Description: 事务管理器配置
 * @author Liangfeng
 * @date 2017/4/30 0030 8:34
 * @version 1.0
 */
@Configuration
public class TxManagerConfig {

    /**
     * 创建primaryTxManager
     * @param dataSource
     * @return
     */
    @Bean(name = DatabaseConstant.PRIMARY_TX_MANAGER)
    @Qualifier(DatabaseConstant.PRIMARY_TX_MANAGER)
    @Primary
    public PlatformTransactionManager primaryTxManager(@Qualifier(DatabaseConstant.PRIMARY_DATASOURCE)DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    /**
     * 创建secondaryTxManager
     * @param dataSource
     * @return
     */
    @Bean(name = DatabaseConstant.SECONDARY_TX_MANAGER)
    @Qualifier(DatabaseConstant.SECONDARY_TX_MANAGER)
    public PlatformTransactionManager secondaryTxManager(@Qualifier(DatabaseConstant.SECONDARY_DATASOURCE)DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }




}
