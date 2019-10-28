SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `TcPower`;
CREATE TABLE `TcPower` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(512) default NULL,
`powerKey` varchar(512) default NULL,
`powerUrl` varchar(512) default NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcPower` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcConfig`;
CREATE TABLE `TcConfig` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(512) default NULL,
`configKey` varchar(512) default NULL,
`configValue` varchar(512) default NULL,
`type` varchar(512) default NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcConfig` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcUser_TcPart`;
CREATE TABLE `TcUser_TcPart` (
`id` bigint NOT NULL AUTO_INCREMENT,
`tcUser_id` bigint NOT NULL,
`tcPart_id` bigint NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcUser_TcPart` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcPower_TcPart`;
CREATE TABLE `TcPower_TcPart` (
`id` bigint NOT NULL AUTO_INCREMENT,
`tcPower_id` bigint NOT NULL,
`tcPart_id` bigint NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcPower_TcPart` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcCourier`;
CREATE TABLE `TcCourier` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(512) default NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcCourier` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcReason`;
CREATE TABLE `TcReason` (
`id` bigint NOT NULL AUTO_INCREMENT,
`receiveName` int default NULL,
`state` int default NULL,
`type` varchar(512) default NULL,
`content` varchar(512) default NULL,
`tcUser_id` bigint NOT NULL,
`tcOrder_id` bigint NOT NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcReason` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcCompany`;
CREATE TABLE `TcCompany` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(512) default NULL,
`telephone` varchar(512) default NULL,
`createTime` datetime default NULL,
`info` varchar(512) default NULL,
`location` varchar(512) default NULL,
`officeAddress` varchar(512) default NULL,
`legal` varchar(512) default NULL,
`licenseCode` varchar(512) default NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcCompany` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcCustomer`;
CREATE TABLE `TcCustomer` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(512) default NULL,
`telephone` varchar(512) default NULL,
`createTime` datetime default NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcCustomer` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcUser`;
CREATE TABLE `TcUser` (
`id` bigint NOT NULL AUTO_INCREMENT,
`loginname` varchar(512) default NULL,
`password` varchar(512) default NULL,
`salt` varchar(512) default NULL,
`name` varchar(512) default NULL,
`telephone` varchar(512) default NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcUser` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcPart`;
CREATE TABLE `TcPart` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(512) default NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcPart` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcOrder`;
CREATE TABLE `TcOrder` (
`id` bigint NOT NULL AUTO_INCREMENT,
`number` int default NULL,
`courierNumber` varchar(512) default NULL,
`orderTime` datetime default NULL,
`orderType` int default NULL,
`stage` int default NULL,
`tcCompany_id` bigint NOT NULL,
`tcUser_id` bigint NOT NULL,
`tcCourier_id` bigint NOT NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcOrder` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcLog`;
CREATE TABLE `TcLog` (
`id` bigint NOT NULL AUTO_INCREMENT,
`content` varchar(512) default NULL,
`operateTime` datetime default NULL,
`startId` int default NULL,
`receiveId` int default NULL,
`type` varchar(512) default NULL,
`tcUser_id` bigint NOT NULL,
`tcOrder_id` bigint NOT NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcLog` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcCompany_TcCustomer`;
CREATE TABLE `TcCompany_TcCustomer` (
`id` bigint NOT NULL AUTO_INCREMENT,
`tcCompany_id` bigint NOT NULL,
`tcCustomer_id` bigint NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcCompany_TcCustomer` ADD CHECK (`id` IS NOT NULL);


DROP TABLE IF EXISTS `TcSign`;
CREATE TABLE `TcSign` (
`id` bigint NOT NULL AUTO_INCREMENT,
`state` int default NULL,
`createTime` datetime default NULL,
`tcUser_id` bigint NOT NULL,
`flag` varchar(255) default '1',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `TcSign` ADD CHECK (`id` IS NOT NULL);

