DROP INDEX uk_invite_code ON Team;

DROP INDEX uk_apply_num ON Team;

DROP TABLE IF EXISTS Team;

/*==============================================================*/
/* Table: Team                                                  */
/*==============================================================*/
CREATE TABLE Team
(
   id                   VARCHAR(32) NOT NULL COMMENT '表主键',
   apply_num            VARCHAR(12) COMMENT '申请编号',
   apply_status         CHAR(2) COMMENT '申请状态：01-未申请（none），02-待审核（wait），03-审核通过（pass），04-审核不通过（reject）',
   apply_type           CHAR(2) COMMENT '申请类型：01-个人（person），02-团队（team）',
   apply_date           DATE COMMENT '申请日期',
   province             INT COMMENT '开馆省份',
   city                 INT COMMENT '开馆城市',
   invite_code          CHAR(4) COMMENT '邀请码',
   initiator_id         VARCHAR(32) COMMENT '发起人id主键',
   initiator_name       VARCHAR(20) COMMENT '发起人名称',
   initiator_mallid     INT COMMENT '发起人猫号',
   initiator_project    VARCHAR(50) COMMENT '发起人主项目',
   initiator_is_fulltime TINYINT(1) COMMENT '发起人是否全职',
   initiator_honors     VARCHAR(50) COMMENT '发起人荣誉集合',
   initiator_operations VARCHAR(50) COMMENT '发起人执业等级集合',
   create_time          DATETIME COMMENT '创建时间',
   modify_time          DATETIME COMMENT '修改时间',
   PRIMARY KEY (id)
);

ALTER TABLE Team COMMENT '团队表，保存私教组团的申请信息';

/*==============================================================*/
/* Index: uk_apply_num                                          */
/*==============================================================*/
CREATE UNIQUE INDEX uk_apply_num ON Team
(
   apply_num
);

/*==============================================================*/
/* Index: uk_invite_code                                        */
/*==============================================================*/
CREATE UNIQUE INDEX uk_invite_code ON Team
(
   invite_code
);
