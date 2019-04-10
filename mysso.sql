/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : mysso

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-04-10 15:53:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title_us` varchar(60) DEFAULT NULL,
  `title_cn` varchar(60) DEFAULT NULL,
  `title_tw` varchar(60) DEFAULT NULL,
  `icon` varchar(60) DEFAULT NULL,
  `url` varchar(60) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', 'home page', '首页', '首頁', 'icon_home', null, '0');
INSERT INTO `tb_menu` VALUES ('2', 'my project', '我的项目', '我的項目', 'icon_doc', null, '0');
INSERT INTO `tb_menu` VALUES ('3', 'statistical analysis', '统计分析', '統計分析', 'icon_index_line', null, '0');
INSERT INTO `tb_menu` VALUES ('4', 'personnel management', '人员管理', '人員管理', 'icon_addperson', null, '0');
INSERT INTO `tb_menu` VALUES ('5', 'knowledge management', '知识管理', '知識管理', 'icon_new_recruit', null, '0');
INSERT INTO `tb_menu` VALUES ('31', 'statistical summary', '项目统计、汇总', '項目統計、匯總', 'icon_subordinate', null, '3');
INSERT INTO `tb_menu` VALUES ('32', 'item analysis', '项目分析', '項目分析', 'icon_refresh', null, '3');
INSERT INTO `tb_menu` VALUES ('41', 'basic information management', '人员基本信息管理', '人員基本資訊管理', 'icon_signal', null, '4');
INSERT INTO `tb_menu` VALUES ('42', 'role based access control', '权限管理', '許可權管理', 'icon_meeting', null, '4');
INSERT INTO `tb_menu` VALUES ('51', 'installation and debugging records', '安装调试记录', '安裝調試記錄', 'icon_details', null, '5');
INSERT INTO `tb_menu` VALUES ('52', 'equipment handover record', '设备交接记录', '設備交接記錄', 'icon_calendar', null, '5');
INSERT INTO `tb_menu` VALUES ('53', 'equipment maintenance manual', '设备维护手册', '設備維護手册', 'icon_addresslist', null, '5');
INSERT INTO `tb_menu` VALUES ('54', 'problem statistics', '项目执行过程问题统计', '項目執行過程問題統計', 'icon_warn', null, '5');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '管理员');
INSERT INTO `tb_role` VALUES ('2', '普通用户');
INSERT INTO `tb_role` VALUES ('3', 'test');

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES ('1', '1', '1');
INSERT INTO `tb_role_menu` VALUES ('2', '1', '2');
INSERT INTO `tb_role_menu` VALUES ('3', '1', '3');
INSERT INTO `tb_role_menu` VALUES ('4', '1', '4');
INSERT INTO `tb_role_menu` VALUES ('5', '1', '5');
INSERT INTO `tb_role_menu` VALUES ('6', '1', '6');
INSERT INTO `tb_role_menu` VALUES ('7', '1', '7');
INSERT INTO `tb_role_menu` VALUES ('8', '1', '8');
INSERT INTO `tb_role_menu` VALUES ('9', '1', '9');
INSERT INTO `tb_role_menu` VALUES ('10', '1', '10');
INSERT INTO `tb_role_menu` VALUES ('11', '1', '11');
INSERT INTO `tb_role_menu` VALUES ('12', '1', '12');
INSERT INTO `tb_role_menu` VALUES ('13', '1', '13');
INSERT INTO `tb_role_menu` VALUES ('14', '1', '14');
INSERT INTO `tb_role_menu` VALUES ('15', '1', '15');
INSERT INTO `tb_role_menu` VALUES ('16', '1', '16');
INSERT INTO `tb_role_menu` VALUES ('17', '1', '17');
INSERT INTO `tb_role_menu` VALUES ('18', '1', '18');
INSERT INTO `tb_role_menu` VALUES ('19', '1', '19');
INSERT INTO `tb_role_menu` VALUES ('20', '1', '20');
INSERT INTO `tb_role_menu` VALUES ('21', '1', '21');
INSERT INTO `tb_role_menu` VALUES ('22', '1', '22');
INSERT INTO `tb_role_menu` VALUES ('23', '1', '23');
INSERT INTO `tb_role_menu` VALUES ('24', '2', '1');
INSERT INTO `tb_role_menu` VALUES ('25', '2', '5');
INSERT INTO `tb_role_menu` VALUES ('26', '2', '6');
INSERT INTO `tb_role_menu` VALUES ('27', '2', '7');
INSERT INTO `tb_role_menu` VALUES ('28', '2', '8');
INSERT INTO `tb_role_menu` VALUES ('29', '2', '9');
INSERT INTO `tb_role_menu` VALUES ('30', '2', '10');
INSERT INTO `tb_role_menu` VALUES ('31', '2', '11');
INSERT INTO `tb_role_menu` VALUES ('32', '2', '12');
INSERT INTO `tb_role_menu` VALUES ('33', '2', '13');
INSERT INTO `tb_role_menu` VALUES ('34', '2', '14');
INSERT INTO `tb_role_menu` VALUES ('35', '2', '15');
INSERT INTO `tb_role_menu` VALUES ('36', '2', '4');
INSERT INTO `tb_role_menu` VALUES ('37', '2', '20');
INSERT INTO `tb_role_menu` VALUES ('38', '2', '21');
INSERT INTO `tb_role_menu` VALUES ('39', '2', '22');
INSERT INTO `tb_role_menu` VALUES ('40', '2', '23');
INSERT INTO `tb_role_menu` VALUES ('41', '3', '1');
INSERT INTO `tb_role_menu` VALUES ('42', '3', '2');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('2', 'zhangsan', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('3', 'lisi', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('4', 'wangwu', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('5', 'admin1', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('6', 'admin2', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('7', 'admin3', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('8', 'admin4', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('9', 'admin5', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('10', 'admin6', '123456');
INSERT INTO `tb_user` VALUES ('11', 'admin7', '$2a$10$5evD7BD7THaJz065Hy2ieOytBKPdeS0jDj7FP1Yyay7KZRwahdwL2');
INSERT INTO `tb_user` VALUES ('12', 'zhuxianda', '$2a$10$D/ZrgffOxPIjflczm2jXYu6SlUCsGMcDFmMlMmODRcWPoz3n2iTPC');
INSERT INTO `tb_user` VALUES ('13', 'jjjj', '$2a$10$A3iZYt6E86ErCfyBu60eGOuzXPWOj2eUHJrmsM1/8RYE4wPanQKJe');
INSERT INTO `tb_user` VALUES ('14', 'test1', '$2a$10$xs8gtYd28GWCunM39Q1JJeuTA7EbBwirL8e6exMjHe7VPgIDpkJPC');
INSERT INTO `tb_user` VALUES ('16', 'test4', '$2a$10$S2ImYTPxSnp5MKl9g/lewOUAIbrjeMc/moRj6fLpRqdKd8fbw5.1G');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '1', '1');
INSERT INTO `tb_user_role` VALUES ('2', '2', '2');
INSERT INTO `tb_user_role` VALUES ('3', '1', '2');
