/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.18 : Database - wxmp
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wxmp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wxmp`;

# /* create user seth to manage this database */
# create user 'seth'@'localhost' identified by '123456';
# create user 'seth'@'%' identified by '123456';
# grant all privileges on `exmp`.* to 'seth'@'%' identified by '123456';
# grant all privileges on `exmp`.* to 'seth'@'localhost' identified by '123456';
# grant all privileges on *.* to 'seth'@'%' identified by '123456';
# grant all privileges on *.* to 'seth'@'localhost' identified by '123456';
# flush privileges;

/*Table structure for table `t_wxcms_account` */

DROP TABLE IF EXISTS `t_wxcms_account`;

CREATE TABLE `t_wxcms_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `account` varchar(100) NOT NULL,
  `appid` varchar(100) DEFAULT NULL,
  `appsecret` varchar(100) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `msgCount` int(11) DEFAULT '1',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_account` */

/*Table structure for table `t_wxcms_account_fans` */

DROP TABLE IF EXISTS `t_wxcms_account_fans`;

CREATE TABLE `t_wxcms_account_fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(100) DEFAULT NULL,
  `subscribeStatus` int(1) DEFAULT '1',
  `subscribeTime` varchar(50) DEFAULT NULL,
  `nickname` varbinary(50) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT '1',
  `language` varchar(50) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  `remark` varchar(50) DEFAULT NULL,
  `wxid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_account_fans` */

/*Table structure for table `t_wxcms_account_menu` */

DROP TABLE IF EXISTS `t_wxcms_account_menu`;

CREATE TABLE `t_wxcms_account_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mtype` varchar(50) DEFAULT NULL,
  `eventType` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `inputCode` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `msgId` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_account_menu` */

/*Table structure for table `t_wxcms_account_menu_group` */

DROP TABLE IF EXISTS `t_wxcms_account_menu_group`;

CREATE TABLE `t_wxcms_account_menu_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_account_menu_group` */

/*Table structure for table `t_wxcms_article` */

DROP TABLE IF EXISTS `t_wxcms_article`;

CREATE TABLE `t_wxcms_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `digest` varchar(100) DEFAULT NULL,
  `show_cover_pic` int(1) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `thumb_media_id` varchar(150) DEFAULT NULL,
  `content_source_url` varchar(200) DEFAULT NULL,
  `media_id` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_article` */

/*Table structure for table `t_wxcms_img_resource` */

DROP TABLE IF EXISTS `t_wxcms_img_resource`;

CREATE TABLE `t_wxcms_img_resource` (
  `id` varchar(32) NOT NULL,
  `mediaId` varchar(100) DEFAULT NULL,
  `trueName` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `url` varchar(200) NOT NULL,
  `httpUrl` varchar(200) DEFAULT NULL,
  `size` int(9) NOT NULL,
  `createTime` mediumtext NOT NULL,
  `updateTime` mediumtext NOT NULL,
  `flag` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_img_resource` */

/*Table structure for table `t_wxcms_media_files` */

DROP TABLE IF EXISTS `t_wxcms_media_files`;

CREATE TABLE `t_wxcms_media_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mediaType` varchar(20) DEFAULT NULL COMMENT '媒体类型',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `introduction` varchar(500) DEFAULT NULL COMMENT '简介说明',
  `logicClass` varchar(50) DEFAULT NULL COMMENT '标签_逻辑分类',
  `media_id` varchar(100) DEFAULT NULL COMMENT '返回的media_id',
  `uploadUrl` varchar(200) DEFAULT NULL COMMENT '返回的wx服务器url',
  `rmk` varchar(500) DEFAULT NULL COMMENT '备注_预留',
  `createTime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `updateTime` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_media_files` */

/*Table structure for table `t_wxcms_msg_base` */

DROP TABLE IF EXISTS `t_wxcms_msg_base`;

CREATE TABLE `t_wxcms_msg_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msgType` varchar(20) DEFAULT NULL,
  `inputCode` varchar(20) DEFAULT NULL,
  `rule` varchar(20) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `readCount` int(11) DEFAULT '0',
  `favourCount` int(11) unsigned zerofill DEFAULT '00000000000',
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_msg_base` */

/*Table structure for table `t_wxcms_msg_news` */

DROP TABLE IF EXISTS `t_wxcms_msg_news`;

CREATE TABLE `t_wxcms_msg_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `multType` varchar(5) DEFAULT NULL COMMENT '单图文多图文类型',
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `brief` varchar(255) DEFAULT NULL,
  `description` longtext,
  `picPath` varchar(255) DEFAULT NULL,
  `showPic` int(11) DEFAULT '0',
  `url` varchar(255) DEFAULT NULL,
  `fromurl` varchar(255) DEFAULT NULL,
  `base_id` int(11) DEFAULT NULL,
  `media_id` varchar(100) DEFAULT NULL COMMENT '上传后返回的媒体素材id',
  `thumbMediaId` varchar(150) DEFAULT NULL COMMENT '封面图片id',
  `news_index` int(11) DEFAULT NULL COMMENT '多图文中的第几条',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_msg_news` */

/*Table structure for table `t_wxcms_msg_news_combin` */

DROP TABLE IF EXISTS `t_wxcms_msg_news_combin`;

CREATE TABLE `t_wxcms_msg_news_combin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_id` int(11) NOT NULL,
  `msgnews_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`main_id`,`msgnews_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_msg_news_combin` */

/*Table structure for table `t_wxcms_msg_text` */

DROP TABLE IF EXISTS `t_wxcms_msg_text`;

CREATE TABLE `t_wxcms_msg_text` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `base_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_msg_text` */

/*Table structure for table `t_wxcms_sys_user` */

DROP TABLE IF EXISTS `t_wxcms_sys_user`;

CREATE TABLE `t_wxcms_sys_user` (
  `id` varchar(64) NOT NULL DEFAULT '' COMMENT '主键id',
  `account` varchar(50) DEFAULT NULL COMMENT '账号',
  `pwd` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `trueName` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) DEFAULT '0' COMMENT '性别：0是男 1是女',
  `phone` varchar(11) DEFAULT '' COMMENT '手机号码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `flag` int(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_wxcms_sys_user` */

insert  into `t_wxcms_sys_user`(`id`,`account`,`pwd`,`trueName`,`sex`,`phone`,`createTime`,`updateTime`,`email`,`flag`) values ('1','admin','e10adc3949ba59abbe56e057f20f883e','admin','0','',NULL,NULL,'',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


-- 业务：修改表名为自身定义
-- 作者：SethMessenger
-- 日期: 2018-03-30
-- 执行状态： 未执行

-- 修改表名,起始字符修改为"s_"，
-- 微信账户表
ALTER  TABLE `t_wxcms_account` RENAME TO `s_account`;
-- 微信关注用户表（也可以理解为用户表）
ALTER  TABLE `t_wxcms_account_fans` RENAME TO `s_account_fans`;
-- 微信账户菜单
ALTER  TABLE `t_wxcms_account_menu` RENAME TO `s_account_menu`;
-- 微信账户菜单组
ALTER  TABLE `t_wxcms_account_menu_group` RENAME TO `s_account_menu_group`;
-- 微信图文消息表
ALTER  TABLE `t_wxcms_article` RENAME TO `s_article`;
-- 微信图片资料信息
ALTER  TABLE `t_wxcms_img_resource` RENAME TO `s_img_resource`;
-- 微信媒体信息？？？
ALTER  TABLE `t_wxcms_media_files` RENAME TO `s_media_files`;
-- 消息
ALTER  TABLE `t_wxcms_msg_base` RENAME TO `s_msg_base`;
-- 消息
ALTER  TABLE `t_wxcms_msg_news` RENAME TO `s_msg_news`;
-- 消息
ALTER  TABLE `t_wxcms_msg_news_combin` RENAME TO `s_msg_news_combin`;
-- 消息
ALTER  TABLE `t_wxcms_msg_text` RENAME TO `s_msg_text`;
-- 系统用户表（待拆分，根据业务单位公司进行人员权限划分）
ALTER  TABLE `t_wxcms_sys_user` RENAME TO `s_sys_user`;


-- 业务：新增冗余表s_company，以便于根据公司维度进行微信业务的区分，并且将微信账户和公司账户进行关联
-- 作者：SethMessenger
-- 日期: 2018-03-30
-- 执行状态： 未执行

CREATE TABLE `s_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '公司名称（以微信业务划分）',
  `legalPerson` varchar(32) NOT NULL DEFAULT '' COMMENT '法人姓名',
  `legalPhone` varchar(32) NOT NULL DEFAULT '' COMMENT '法人联系电话',
  `legalCompanyName` varchar(64) NOT NULL COMMENT '公司法定名称（以营业执照为准）',
  `legalLicense` varchar(64) NOT NULL DEFAULT '' COMMENT '公司法定营业号',
  `legalLicenseImage` int(64) NOT NULL COMMENT '营业执照图片',
  `logo` varchar(64) DEFAULT NULL COMMENT '公司logo缩略图',
  `createTime` date NOT NULL COMMENT '记录创建时间',
  `updateTime` date NOT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table s_sys_user add companyId varchar(11) not null default '';

alter table `s_account` add companyId varchar(11) not null default '';

