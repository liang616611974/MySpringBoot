CREATE TABLE `a_admin_user` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `status` smallint(6) DEFAULT NULL COMMENT '状态：0-禁用，1-正常',
  `idcard` varchar(50) DEFAULT NULL COMMENT '身分证号码',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮箱',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建用户主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_user` bigint(20) DEFAULT NULL COMMENT '修改用户主键',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_createtime` (`create_time`),
  KEY `idx_abc` (`username`,`password`,`status`),
  KEY `idx_sort` (`password`),
  KEY `idx_sort1` (`status`),
  KEY `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户'
