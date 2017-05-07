package com.liangfeng.myspringboot.admin.common.constant;

/**
 * @author Liangfeng
 * @version 1.0
 * @Title: DatabaseConstant.java
 * @Description: 数据库连接配置常量
 * @date 2017/4/30 0030 9:00
 */
public class DatabaseConstant {

    /** 主数据库名称 */
    public static final String PRIMARY = "primary";

    /** 第二数据库名称 */
    public static final String SECONDARY = "secondary";

    /** 主要数据源 */
    public static final String PRIMARY_DATASOURCE = "primaryDataSource";

    /** 第二数据源 */
    public static final String SECONDARY_DATASOURCE = "secondaryDataSource";

    /** 主要事务管理器 */
    public static final String PRIMARY_TX_MANAGER = "primaryTxManager";

    /** 第二事务管理器 */
    public static final String SECONDARY_TX_MANAGER = "secondaryTxManager";

    /** 主要 JdbcTemplate */
    public static final String PRIMARY_JDBC_TEMPLATE = "primaryJdbcTemplate";

    /** 第二 JdbcTemplate */
    public static final String SECONDARY_JDBC_TEMPLATE = "secondaryJdbcTemplate";

    /** 主要 SqlSessionFactory */
    public static final String PRIMARY_SQL_SESSION_FACTORY = "primarySqlSessionFactory";

    /** 第二 SqlSessionFactory */
    public static final String SECONDARY_SQL_SESSION_FACTORY = "secondarySqlSessionFactory";

    /** 主要 SqlSessionTemplate */
    public static final String PRIMARY_SQL_SESSION_TEMPLATE = "primarySqlSessionTemplate";

    /** 第二 SqlSessionTemplate */
    public static final String SECONDARY_SQL_SESSION_TEMPLATE = "secondarySqlSessionTemplate";

    /** MySql 方言类*/
    public static final String MYSQL_DIALECT = "MySQLDialect";


}
