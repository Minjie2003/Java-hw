DROP DATABASE IF EXISTS springboot_demo; -- 数据库名不能用中划线-
CREATE DATABASE springboot_demo CHARSET utf8;
USE springboot_demo;
CREATE TABLE `admin`(
  id BIGINT AUTO_INCREMENT,
  loginName VARCHAR(255),
  PASSWORD VARCHAR(64),
  lastLoginTime DATETIME,
  remark  VARCHAR(255),
  PRIMARY KEY (id)
);
INSERT INTO admin(loginName,PASSWORD,remark) VALUES ('admin','admin','测试数据:管理员用户');

CREATE TABLE whitelist_setting
(
    id           BIGINT      NOT NULL AUTO_INCREMENT,
    sn           VARCHAR(50) NOT NULL COMMENT '限定用户SN',
    `name`       VARCHAR (150) NOT NULL COMMENT '用户名',
    role_id      BIGINT COMMENT '用户角色id',
    is_enabled   BOOL         NOT NULL COMMENT '是否启用',
    is_deleted   BOOL         NOT NULL COMMENT '是否删除',
    gmt_created  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    gmt_modified TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
);

CREATE TABLE dictionary
(
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
    parent_id    INT UNSIGNED NOT NULL COMMENT '父ID',
    TYPE         VARCHAR(50)  NOT NULL COMMENT '字典类型',
    item_name    VARCHAR(100) NOT NULL COMMENT '显示名',
    item_value   VARCHAR(100)          DEFAULT NULL COMMENT '存储值',
    description  VARCHAR(100)          DEFAULT NULL COMMENT '描述说明',
    extdata      VARCHAR(200)          DEFAULT NULL COMMENT '扩展JSON',
    sort_id      SMALLINT     NOT NULL DEFAULT '99' COMMENT '排序号',
    is_editable  TINYINT(1)   NOT NULL DEFAULT '1' COMMENT '是否可改',
    is_deletable TINYINT(1)   NOT NULL DEFAULT '0' COMMENT '是否可删',
    is_deleted   TINYINT(1)   NOT NULL DEFAULT '0' COMMENT '删除标记',
    gmt_created  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    gmt_modified TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
) AUTO_INCREMENT = 10000 COMMENT '数据字典';
