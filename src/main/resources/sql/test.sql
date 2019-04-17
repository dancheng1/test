/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.24-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `corp_summary_detail` */

DROP TABLE IF EXISTS `corp_summary_detail`;

CREATE TABLE `corp_summary_detail` (
  `AssetsNo` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '资产编号',
  `ASSETSTYPE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '资产类别',
  `ASSETSNAME` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '资产名称',
  `BUYPERSON` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '购买人',
  `BUYPRICE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '购买价格',
  `DANWEI` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '物品单位',
  `BUYNO` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '购买数量',
  `USERPERSON` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '使用人',
  `RECIVETIME` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '领取日期',
  `HEAD` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '负责人',
  `SAVETIME` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '存放日期',
  `SAVEPOINT` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '存放地点',
  `SAVESTATE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '存放状态',
  `AUDITPERSON` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '审核人',
  `USETIME` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '使用时间',
  `USEPLACE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '使用地点',
  `RETURNTIME` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '归还时间',
  `USESTATE` int(11) DEFAULT '0' COMMENT '使用状态,0代表未使用，1代表以被使用',
  `CREATDATE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '录入时间',
  `CREATBY` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '录入人',
  `UPDATEDATE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新时间',
  `UPDATEBY` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新人',
  `NOTE` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `NOTE1` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注1',
  `NOTE2` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注2',
  `NOTE3` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注3',
  `NOTE4` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注4',
  `NOTE5` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注5',
  PRIMARY KEY (`AssetsNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `corp_summary_detail` */

insert  into `corp_summary_detail`(`AssetsNo`,`ASSETSTYPE`,`ASSETSNAME`,`BUYPERSON`,`BUYPRICE`,`DANWEI`,`BUYNO`,`USERPERSON`,`RECIVETIME`,`HEAD`,`SAVETIME`,`SAVEPOINT`,`SAVESTATE`,`AUDITPERSON`,`USETIME`,`USEPLACE`,`RETURNTIME`,`USESTATE`,`CREATDATE`,`CREATBY`,`UPDATEDATE`,`UPDATEBY`,`NOTE`,`NOTE1`,`NOTE2`,`NOTE3`,`NOTE4`,`NOTE5`) values ('0003','文具','dasdas',NULL,'1234.2',NULL,NULL,NULL,NULL,NULL,NULL,'吉林青年创业园',NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'这里是备注',NULL,NULL,NULL,NULL,NULL),('0004','文具','电脑',NULL,'1234.2',NULL,NULL,NULL,NULL,NULL,NULL,'吉林青年创业园',NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'这里是备注',NULL,NULL,NULL,NULL,NULL),('0005','文具','电脑',NULL,'1234.2',NULL,NULL,NULL,NULL,NULL,NULL,'吉林青年创业园',NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'这里是备注',NULL,NULL,NULL,NULL,NULL),('00056','文具','橡皮11111','10','0.2','个','50','猪八戒','2017年1月9日','孙悟空11111','2017年1月9日','吉林省科宇信息有限公司','吉林省科宇信息有限公司','沙和尚','2017年1月9日13:03:47','吉林省科宇信息有限公司','待定',0,'2017年1月9日13:02:56','唐僧','2017年1月9日13:02:35','白龙','备注','备注1','备注2','备注3','备注4','备注5'),('0006','文具','橡皮11111','10','0.2','个','50','猪八戒','2017年1月9日','孙悟空11111','2017年1月9日','吉林省科宇信息有限公司','吉林省科宇信息有限公司','沙和尚','2017年1月9日13:03:47','吉林省科宇信息有限公司','待定',0,'2017年1月9日13:02:56','唐僧','2017年1月9日13:02:35','白龙','备注','备注1','备注2','备注3','备注4','备注5'),('0007','文具','橡皮11111','10','0.2','个','50','猪八戒','2017年1月9日','孙悟空11111','2017年1月9日','吉林省科宇信息有限公司','吉林省科宇信息有限公司','沙和尚','2017年1月9日13:03:47','吉林省科宇信息有限公司','待定',0,'2017年1月9日13:02:56','唐僧','2017年1月9日13:02:35','白龙','备注','备注1','备注2','备注3','备注4','备注5'),('dasda','asa1','dasd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `university` */

DROP TABLE IF EXISTS `university`;

CREATE TABLE `university` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT '""' COMMENT '大学名称',
  `picLink` varchar(255) DEFAULT '""' COMMENT '图片存储链接',
  `picClickLink` varchar(255) DEFAULT '""' COMMENT '点击图片跳转链接',
  `registrationTime` varchar(255) DEFAULT '""' COMMENT '报名时间',
  `registrationConditionLink` varchar(255) DEFAULT '""' COMMENT '报名条件链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `university` */

insert  into `university`(`id`,`name`,`picLink`,`picClickLink`,`registrationTime`,`registrationConditionLink`) values (1,'北京大学','static/resource/937f50b7-2c7b-48be-92f1-54ceb0da7d63.png','http://www.baidu.com','21345','http://www.baidu.com'),(2,'南京大学','http://www.baidu.com','http://www.baidu.com','2019-1-2','http://www.baidu.com'),(3,'吉林大学','http://www.baidu.com','http://www.baidu.com','2019-03-04','http://www.baidu.com'),(4,'吉林大学','http://www.baidu.com','http://www.baidu.com','2019-03-04','http://www.baidu.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
