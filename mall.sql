/*
Navicat MySQL Data Transfer

Source Server         : MikeHe
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-07-17 16:15:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `orderid` int(11) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  CONSTRAINT `orderid` FOREIGN KEY (`orderid`) REFERENCES `order` (`orderid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `gid` int(11) NOT NULL,
  `gname` varchar(255) DEFAULT NULL,
  `price` int(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `timeonshelf` datetime DEFAULT NULL,
  `sellerid` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `sellerid` (`sellerid`),
  CONSTRAINT `sellerid` FOREIGN KEY (`sellerid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(11) NOT NULL,
  `buyerid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `buyerid` (`buyerid`),
  KEY `gid` (`gid`),
  CONSTRAINT `buyerid` FOREIGN KEY (`buyerid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `gid` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `isseller` int(11) DEFAULT NULL,
  KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
