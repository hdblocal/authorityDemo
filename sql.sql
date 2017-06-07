/*
Navicat MySQL Data Transfer

Source Server         : taotao
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : mooc_quanxian

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-06-07 18:11:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `access`
-- ----------------------------
DROP TABLE IF EXISTS `access`;
CREATE TABLE `access` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_unicode_520_ci NOT NULL,
  `urls` varchar(1000) COLLATE utf8_unicode_520_ci NOT NULL,
  `status` tinyint(4) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

-- ----------------------------
-- Records of access
-- ----------------------------
INSERT INTO `access` VALUES ('1', '测试页面1', 'test/page1', '1', '2017-06-07 10:44:44', '2017-06-07 10:44:44');
INSERT INTO `access` VALUES ('3', '测试页面2', 'test/page2', '1', '2017-06-07 10:44:46', '2017-06-07 10:44:46');
INSERT INTO `access` VALUES ('4', '测试页面3', 'test/page3', '1', '2017-06-07 10:44:48', '2017-06-07 10:44:48');
INSERT INTO `access` VALUES ('5', '测试页面4', 'test/page4', '1', '2017-06-07 10:44:50', '2017-06-07 10:44:50');
INSERT INTO `access` VALUES ('6', '测试页面5', 'test/page5', '1', '2017-06-07 10:44:53', '2017-06-07 10:44:53');

-- ----------------------------
-- Table structure for `app_access_log`
-- ----------------------------
DROP TABLE IF EXISTS `app_access_log`;
CREATE TABLE `app_access_log` (
  `id` int(11) NOT NULL,
  `uid` bigint(20) NOT NULL,
  `target_url` varchar(255) COLLATE utf8_unicode_520_ci NOT NULL,
  `query_params` longtext COLLATE utf8_unicode_520_ci NOT NULL,
  `ua` varchar(255) COLLATE utf8_unicode_520_ci NOT NULL,
  `ip` varchar(32) COLLATE utf8_unicode_520_ci NOT NULL,
  `note` varchar(1000) COLLATE utf8_unicode_520_ci NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

-- ----------------------------
-- Records of app_access_log
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci NOT NULL COMMENT '角色名称',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '''状态 1：有效 0：无效'',',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('5', '普通用户', '1', '2017-06-05 00:00:00', '2017-06-05 00:00:00');
INSERT INTO `role` VALUES ('6', '系统管理员 ', '1', '2017-06-05 00:00:00', '2017-06-05 00:00:00');
INSERT INTO `role` VALUES ('7', '超级VIP', '1', '2017-06-05 00:00:00', '2017-06-05 00:00:00');
INSERT INTO `role` VALUES ('8', '黄金VIP', '1', '2017-06-06 10:22:20', '2017-06-06 10:22:20');
INSERT INTO `role` VALUES ('9', '游客', '1', '2017-06-06 11:12:05', '2017-06-06 11:12:05');

-- ----------------------------
-- Table structure for `role_access`
-- ----------------------------
DROP TABLE IF EXISTS `role_access`;
CREATE TABLE `role_access` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `access_id` int(11) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

-- ----------------------------
-- Records of role_access
-- ----------------------------
INSERT INTO `role_access` VALUES ('1', '5', '1', '2017-06-06 23:04:57');
INSERT INTO `role_access` VALUES ('2', '5', '3', '2017-06-06 23:04:57');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `email` varchar(30) NOT NULL DEFAULT '' COMMENT '邮箱',
  `is_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否是超级管理员 1表示是 0 表示不是',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态 1：有效 0：无效',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `created_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11', '系统管理员', 'xtgly@163.com', '0', '1', null, null);
INSERT INTO `user` VALUES ('12', '张三', 'zhangsan@163.com', '0', '1', null, null);
INSERT INTO `user` VALUES ('13', '李四', 'lisi@163.com', '0', '1', null, null);
INSERT INTO `user` VALUES ('15', '王五', 'wangwu@163.com', '0', '1', null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(11) unsigned NOT NULL,
  `role_id` int(12) unsigned NOT NULL,
  `created_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('3', '11', '6', '2017-06-06 20:56:56');
INSERT INTO `user_role` VALUES ('4', '12', '5', '2017-06-06 20:57:10');
INSERT INTO `user_role` VALUES ('5', '13', '5', '2017-06-06 20:57:23');
INSERT INTO `user_role` VALUES ('6', '14', '7', '2017-06-06 20:57:34');
INSERT INTO `user_role` VALUES ('7', '15', '7', '2017-06-06 20:58:31');
