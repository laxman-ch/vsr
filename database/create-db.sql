CREATE DATABASE `vsr` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `short_code` varchar(16) NOT NULL,
  `name` varchar(64) NOT NULL,
  `address` varchar(256) NOT NULL,
  `details` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `faremap` (
  `from_station_id` int(11) NOT NULL,
  `to_station_id` int(11) NOT NULL,
  `fare` float NOT NULL,
  PRIMARY KEY (`from_station_id`,`to_station_id`),
  KEY `fk_faremap_toid_idx` (`to_station_id`),
  CONSTRAINT `fk_faremap_fromid` FOREIGN KEY (`from_station_id`) REFERENCES `station` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_faremap_toid` FOREIGN KEY (`to_station_id`) REFERENCES `station` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL,
  `waybill_number` varchar(16) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `from_station_id` int(11) NOT NULL,
  `to_station_id` int(11) NOT NULL,
  `dc_number` varchar(32) NOT NULL,
  `from_address` varchar(256) DEFAULT NULL,
  `to_address` varchar(256) DEFAULT NULL,
  `goods_value` float NOT NULL,
  `package_count` int(11) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `weight` float NOT NULL,
  `freight` float NOT NULL,
  `value_surcharge` float NOT NULL,
  `doordel_charges` float NOT NULL,
  `article_charges` float NOT NULL,
  `stat_charges` float NOT NULL,
  `handling_charges` float NOT NULL,
  `other_charges` float NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_from_stn_id_idx` (`to_station_id`,`from_station_id`),
  KEY `fk_dept_id_idx` (`dept_id`),
  CONSTRAINT `fk_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_from_stn_id` FOREIGN KEY (`to_station_id`, `from_station_id`) REFERENCES `faremap` (`to_station_id`, `from_station_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `station` (
  `id` int(11) NOT NULL,
  `short_code` varchar(6) NOT NULL COMMENT 'Easy to remember short code for station.\nFor example: HYD for HYDERABAD',
  `station_name` varchar(32) NOT NULL COMMENT 'Name of the station',
  `district` varchar(32) NOT NULL,
  `state` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_short_code` (`short_code`),
  UNIQUE KEY `station_name_UNIQUE` (`station_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `task_list` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(100) NOT NULL,
  `task_description` varchar(255) DEFAULT NULL,
  `task_priority` varchar(20) DEFAULT NULL,
  `task_status` varchar(20) DEFAULT NULL,
  `task_start_time` datetime DEFAULT NULL,
  `task_end_time` datetime DEFAULT NULL,
  `task_archived` int(11) DEFAULT '0',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

