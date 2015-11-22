/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : bysj

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-11-22 22:44:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fav
-- ----------------------------
DROP TABLE IF EXISTS `fav`;
CREATE TABLE `fav` (
  `favid` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `setfavuserid` int(11) NOT NULL,
  PRIMARY KEY (`favid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fav
-- ----------------------------
INSERT INTO `fav` VALUES ('1', '1', '1');
INSERT INTO `fav` VALUES ('2', '2', '1');
INSERT INTO `fav` VALUES ('3', '3', '1');
INSERT INTO `fav` VALUES ('4', '4', '1');
INSERT INTO `fav` VALUES ('5', '5', '1');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(15) NOT NULL,
  `sellprice` int(11) NOT NULL COMMENT '售价',
  `originprice` int(11) NOT NULL COMMENT '原价',
  `color` varchar(10) NOT NULL COMMENT '成色',
  `tradeposition` varchar(20) NOT NULL,
  `sellerid` int(11) NOT NULL,
  `itemcreatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `bargain` int(11) NOT NULL COMMENT '议价',
  `discreption` varchar(150) DEFAULT NULL,
  `itemmainimg` varchar(100) NOT NULL,
  `viewtime` int(10) DEFAULT '0',
  `sellstatus` int(1) DEFAULT '0',
  `itemclassid` int(11) NOT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '衣服衣服衣服', '2000', '5000', '9成新', '台州学院', '1', '2015-11-21 21:31:04', '1', '的发射点发', 'images/mob.jpg', '0', '1', '12');
INSERT INTO `item` VALUES ('2', '的发射反低俗', '200', '600', '8', '是的发射点发', '1', '2015-11-21 21:32:07', '1', '大幅杀跌', 'sdfsdfds', '0', '0', '23');
INSERT INTO `item` VALUES ('3', 'sdfsdfsf', '222', '111', '2', '的发射点发的', '1', '2015-11-21 21:32:03', '1', '第三方斯蒂芬', 'sdfsdfsdf', '0', '0', '9');
INSERT INTO `item` VALUES ('4', 'dsfsdfsdfsdf', '2', '3', '1', 'dgdfgdfg', '1', '2015-11-21 20:08:37', '1', 'cvxcvbcvb', 'fsdfsdfsdf', '0', '0', '15');
INSERT INTO `item` VALUES ('5', 'sdadasdsafsdfds', '1', '22', '22', 'sdfsdfsdf', '1', '2015-11-21 20:08:40', '1', 'gdfgdfgdfg', 'dsfsdfsdf', '0', '0', '16');
INSERT INTO `item` VALUES ('6', 'dsfsdfsdf', '2', '22', '2', 'dsfsdf', '1', '2015-11-21 20:08:45', '1', 'dsfsdfsdfsf', 'dsfsdfsdfdfs', '0', '0', '13');

-- ----------------------------
-- Table structure for itemclass
-- ----------------------------
DROP TABLE IF EXISTS `itemclass`;
CREATE TABLE `itemclass` (
  `itemclass_id` int(11) NOT NULL AUTO_INCREMENT,
  `itemclass_name` varchar(10) NOT NULL,
  `itemclass_fatherid` int(11) NOT NULL,
  PRIMARY KEY (`itemclass_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itemclass
-- ----------------------------
INSERT INTO `itemclass` VALUES ('1', '代步工具', '0');
INSERT INTO `itemclass` VALUES ('2', '数码设备', '0');
INSERT INTO `itemclass` VALUES ('3', '电器设备', '0');
INSERT INTO `itemclass` VALUES ('4', '衣物伞帽', '0');
INSERT INTO `itemclass` VALUES ('5', '图书教材', '0');
INSERT INTO `itemclass` VALUES ('6', '租赁', '0');
INSERT INTO `itemclass` VALUES ('7', '生活娱乐', '0');
INSERT INTO `itemclass` VALUES ('8', '其他', '0');
INSERT INTO `itemclass` VALUES ('9', '自行车', '1');
INSERT INTO `itemclass` VALUES ('10', '电动车', '1');
INSERT INTO `itemclass` VALUES ('11', '摩托车', '1');
INSERT INTO `itemclass` VALUES ('12', '手机', '2');
INSERT INTO `itemclass` VALUES ('13', '电脑', '2');
INSERT INTO `itemclass` VALUES ('14', '相机', '2');
INSERT INTO `itemclass` VALUES ('15', '电吹风', '3');
INSERT INTO `itemclass` VALUES ('16', '电风扇', '3');
INSERT INTO `itemclass` VALUES ('17', '电水壶', '3');
INSERT INTO `itemclass` VALUES ('18', '女装', '4');
INSERT INTO `itemclass` VALUES ('19', '鞋子', '4');
INSERT INTO `itemclass` VALUES ('20', '箱包', '4');
INSERT INTO `itemclass` VALUES ('21', '教材', '5');
INSERT INTO `itemclass` VALUES ('22', '小说', '5');
INSERT INTO `itemclass` VALUES ('23', '漫画', '5');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mes_id` int(11) NOT NULL AUTO_INCREMENT,
  `mes_itemid` int(11) NOT NULL,
  `mes_levuserid` int(11) NOT NULL,
  `mes_touserid` int(11) DEFAULT NULL,
  `mes_content` varchar(150) NOT NULL,
  `mes_status` int(1) NOT NULL,
  PRIMARY KEY (`mes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '1', '1', '1', 'dsafasdfasdf', '0');
INSERT INTO `message` VALUES ('2', '1', '1', '1', 'sdfsdfsdfdddddddd', '1');

-- ----------------------------
-- Table structure for user_normal
-- ----------------------------
DROP TABLE IF EXISTS `user_normal`;
CREATE TABLE `user_normal` (
  `usernormal_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `pwd` varchar(15) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `userclass` varchar(15) DEFAULT NULL,
  `authen` int(1) NOT NULL,
  `cardid` varchar(20) DEFAULT NULL,
  `cardimg` varchar(200) DEFAULT NULL,
  `levexp` int(11) NOT NULL DEFAULT '0',
  `usernormalcreatime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `headimg` varchar(100) NOT NULL,
  PRIMARY KEY (`usernormal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_normal
-- ----------------------------
INSERT INTO `user_normal` VALUES ('1', 'wangkewei', 'w123456', 'Inaho', '15267286375', '569017623', '111111', '13', '2', '1', '11321313', '1200', '2015-11-20 18:08:28', '1361');
