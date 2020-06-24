/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : clockin

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 12/06/2020 23:27:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clockin_log
-- ----------------------------
DROP TABLE IF EXISTS `clockin_log`;
CREATE TABLE `clockin_log`  (
  `cin_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `start_time` datetime(0) DEFAULT NULL,
  `end_time` datetime(0) DEFAULT NULL,
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`cin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clockin_log
-- ----------------------------
INSERT INTO `clockin_log` VALUES (8, 1, '2020-06-11 10:45:35', '2020-06-11 23:14:24', '2020-06-11 10:45:34', '2020-06-11 10:45:34');
INSERT INTO `clockin_log` VALUES (9, 1, '2020-05-01 08:59:59', '2020-05-02 03:30:01', '2020-06-11 12:07:41', '2020-06-11 12:07:41');
INSERT INTO `clockin_log` VALUES (10, 1, '2020-05-02 08:59:59', '2020-05-02 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (11, 1, '2020-05-03 08:59:59', '2020-05-03 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (12, 1, '2020-05-04 08:59:59', '2020-05-04 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (13, 1, '2020-05-05 08:59:59', '2020-05-05 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (14, 1, '2020-05-06 08:59:59', '2020-05-06 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (15, 1, '2020-05-07 08:59:59', '2020-05-07 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (16, 1, '2020-05-08 08:59:59', '2020-05-08 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (17, 1, '2020-05-09 08:59:59', '2020-05-09 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (18, 1, '2020-05-10 08:59:59', '2020-05-10 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (19, 1, '2020-05-11 08:59:59', '2020-05-11 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (20, 1, '2020-05-12 08:59:59', '2020-05-12 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (21, 1, '2020-05-13 08:59:59', '2020-05-13 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (22, 1, '2020-05-14 08:59:59', '2020-05-14 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (23, 1, '2020-05-15 08:59:59', '2020-05-15 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (24, 1, '2020-05-16 08:59:59', '2020-05-16 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (25, 1, '2020-05-17 08:59:59', '2020-05-17 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (26, 1, '2020-05-18 08:59:59', '2020-05-18 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (27, 1, '2020-05-19 08:59:59', '2020-05-19 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (28, 1, '2020-05-20 08:59:59', '2020-05-20 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (29, 1, '2020-05-21 08:59:59', '2020-05-21 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (30, 1, '2020-05-22 08:59:59', '2020-05-22 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (31, 1, '2020-05-23 08:59:59', '2020-05-23 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (32, 1, '2020-05-24 08:59:59', '2020-05-24 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (33, 1, '2020-05-25 08:59:59', '2020-05-25 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (34, 1, '2020-05-26 08:59:59', '2020-05-26 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (35, 1, '2020-05-27 08:59:59', '2020-05-27 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (36, 1, '2020-05-28 08:59:59', '2020-05-28 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (37, 1, '2020-05-29 08:59:59', '2020-05-29 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (38, 1, '2020-05-30 08:59:59', '2020-05-30 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (39, 1, '2020-05-31 08:59:59', '2020-05-31 17:30:01', '2020-06-11 11:45:17', '2020-06-11 11:45:17');
INSERT INTO `clockin_log` VALUES (40, 1, '2020-06-12 12:47:21', '2020-06-12 23:25:39', '2020-06-12 12:47:21', '2020-06-12 12:47:21');

-- ----------------------------
-- Table structure for configuration
-- ----------------------------
DROP TABLE IF EXISTS `configuration`;
CREATE TABLE `configuration`  (
  `key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of configuration
-- ----------------------------
INSERT INTO `configuration` VALUES ('AppName', 'ClockIn');
INSERT INTO `configuration` VALUES ('EndWorkTime', '1730');
INSERT INTO `configuration` VALUES ('StartWorkTime', '0900');
INSERT INTO `configuration` VALUES ('SubsidyRule1', '35');
INSERT INTO `configuration` VALUES ('SubsidyRule1EndTime', '2100');
INSERT INTO `configuration` VALUES ('SubsidyRule1StartTime', '1900');
INSERT INTO `configuration` VALUES ('SubsidyRule2', '20');
INSERT INTO `configuration` VALUES ('SubsidyRule2EndTime', '0300');
INSERT INTO `configuration` VALUES ('WeekSubsidyRule', '100');

-- ----------------------------
-- Table structure for subsidy
-- ----------------------------
DROP TABLE IF EXISTS `subsidy`;
CREATE TABLE `subsidy`  (
  `ss_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `subsidy` decimal(10, 0) DEFAULT NULL,
  `ss_year_month` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`ss_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subsidy
-- ----------------------------
INSERT INTO `subsidy` VALUES (7, 1, 1155, '202005', '2020-06-11 12:40:41', '2020-06-11 12:40:41');
INSERT INTO `subsidy` VALUES (8, 1, 0, '202001', '2020-06-11 22:01:15', '2020-06-11 22:01:15');
INSERT INTO `subsidy` VALUES (9, 1, 0, '202002', '2020-06-11 22:01:19', '2020-06-11 22:01:19');
INSERT INTO `subsidy` VALUES (10, 1, 0, '202004', '2020-06-12 21:36:08', '2020-06-12 21:36:08');

-- ----------------------------
-- Table structure for user_master
-- ----------------------------
DROP TABLE IF EXISTS `user_master`;
CREATE TABLE `user_master`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_master
-- ----------------------------
INSERT INTO `user_master` VALUES (1, '张三', '2020-06-10 17:38:52', '2020-06-10 17:38:49');

SET FOREIGN_KEY_CHECKS = 1;
