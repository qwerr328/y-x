/*
Navicat MySQL Data Transfer
Source Server         : studyMySQL
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : lib
Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001
Date: 2025-06-02 17:45:41
*/
 
SET FOREIGN_KEY_CHECKS=0;
 
-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `publish_time` varchar(50) DEFAULT NULL,
  `rating` float(4,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
-- ----------------------------
-- Records of book
-- ----------------------------