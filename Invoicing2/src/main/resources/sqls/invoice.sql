/*
SQLyog Enterprise
MySQL - 5.6.34-log : Database - test_spring
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `invoice_billing_record` */

DROP TABLE IF EXISTS `invoice_billing_record`;

CREATE TABLE `invoice_billing_record` (
  `urn` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(50) DEFAULT NULL,
  `contract_id` varchar(50) DEFAULT NULL,
  `category_id` varchar(50) DEFAULT NULL,
  `candidate_id` varchar(50) DEFAULT NULL,
  `product_id` varchar(50) DEFAULT NULL,
  `candidate_product_id` varchar(50) DEFAULT NULL,
  `client_name` varchar(250) DEFAULT NULL,
  `contract_name` varchar(250) DEFAULT NULL,
  `category_name` varchar(250) DEFAULT NULL,
  `candidate_name` varchar(250) DEFAULT NULL,
  `candidate_fname` varchar(200) DEFAULT NULL,
  `product_name` varchar(250) DEFAULT NULL,
  `addition` int(1) DEFAULT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `standard_price` decimal(12,2) DEFAULT NULL,
  `standard_cost` decimal(12,2) DEFAULT NULL,
  `nominal_code` varchar(200) DEFAULT NULL,
  `client_code` varchar(200) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `invoice_status` int(1) DEFAULT NULL,
  `invoice_id` int(12) DEFAULT NULL,
  `billing_date` datetime DEFAULT NULL,
  `extract_date` date DEFAULT NULL,
  `od_status` int(1) DEFAULT NULL,
  `od_timestamp` varchar(40) DEFAULT NULL,
  `od_createdon` datetime DEFAULT NULL,
  `od_createdby` int(12) DEFAULT NULL,
  `od_updatedon` datetime DEFAULT NULL,
  `od_updatedby` int(12) DEFAULT NULL,
  PRIMARY KEY (`urn`),
  KEY `billing_date` (`billing_date`),
  KEY `status` (`status`),
  KEY `candidate_id` (`candidate_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `invoice_billing_record` */

/*Table structure for table `invoice_client` */

DROP TABLE IF EXISTS `invoice_client`;

CREATE TABLE `invoice_client` (
  `client_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `invoice_client` */

/*Table structure for table `invoice_contract` */

DROP TABLE IF EXISTS `invoice_contract`;

CREATE TABLE `invoice_contract` (
  `contract_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contract_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `invoice_contract` */

/*Table structure for table `invoice_details` */

DROP TABLE IF EXISTS `invoice_details`;

CREATE TABLE `invoice_details` (
  `urn` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(50) NOT NULL,
  `contract_id` varchar(50) DEFAULT NULL,
  `invoice_num` varchar(50) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `line_manager` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `cancels_invoice` int(11) DEFAULT NULL,
  `authorised_by` int(12) DEFAULT NULL,
  `authorised_on` datetime DEFAULT NULL,
  `cancelled_by` int(12) DEFAULT NULL,
  `cancelled_on` datetime DEFAULT NULL,
  `paid_status` int(1) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  `sent_status` int(1) DEFAULT NULL,
  `sent_date` date DEFAULT NULL,
  `net` decimal(10,2) DEFAULT NULL,
  `gross` decimal(10,2) DEFAULT NULL,
  `vat` decimal(10,2) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  `currency` varchar(10) DEFAULT NULL,
  `period_start` date DEFAULT NULL,
  `period_end` date DEFAULT NULL,
  `text` text,
  `comments` text,
  `description` text,
  `invoiceFile` varchar(255) DEFAULT NULL,
  `backingFile` varchar(255) DEFAULT NULL,
  `source_name` varchar(200) DEFAULT NULL,
  `source_building` varchar(200) DEFAULT NULL,
  `source_street` varchar(200) DEFAULT NULL,
  `source_town` varchar(200) DEFAULT NULL,
  `source_county` varchar(200) DEFAULT NULL,
  `source_postcode` varchar(10) DEFAULT NULL,
  `source_country` varchar(200) DEFAULT NULL,
  `source_email` varchar(200) DEFAULT NULL,
  `target_name` varchar(200) DEFAULT NULL,
  `target_building` varchar(200) DEFAULT NULL,
  `target_street` varchar(200) DEFAULT NULL,
  `target_town` varchar(200) DEFAULT NULL,
  `target_county` varchar(200) DEFAULT NULL,
  `target_postcode` varchar(10) DEFAULT NULL,
  `target_country` varchar(200) DEFAULT NULL,
  `target_email` varchar(200) DEFAULT NULL,
  `department` varchar(200) DEFAULT NULL,
  `cost_code` varchar(50) DEFAULT NULL,
  `od_status` int(1) DEFAULT NULL,
  `od_timestamp` varchar(40) DEFAULT NULL,
  `od_createdon` datetime DEFAULT NULL,
  `od_createdby` int(12) DEFAULT NULL,
  `od_updatedon` datetime DEFAULT NULL,
  `od_updatedby` int(12) DEFAULT NULL,
  `paymethod_type` varchar(255) DEFAULT NULL,
  `send_type` varchar(255) DEFAULT NULL,
  `sapfile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`urn`),
  KEY `FKnpbv4as3pvhiywvhbjrnep16n` (`client_id`),
  KEY `FKt50nob6lulj7ryna2ia4k6jr8` (`contract_id`),
  KEY `FKswjudplxs6y776p1do4e09lp3` (`sapfile_id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `invoice_details` */

insert  into `invoice_details`(`urn`,`client_id`,`contract_id`,`invoice_num`,`invoice_date`,`line_manager`,`start_date`,`end_date`,`due_date`,`status`,`cancels_invoice`,`authorised_by`,`authorised_on`,`cancelled_by`,`cancelled_on`,`paid_status`,`paid_date`,`sent_status`,`sent_date`,`net`,`gross`,`vat`,`balance`,`currency`,`period_start`,`period_end`,`text`,`comments`,`description`,`invoiceFile`,`backingFile`,`source_name`,`source_building`,`source_street`,`source_town`,`source_county`,`source_postcode`,`source_country`,`source_email`,`target_name`,`target_building`,`target_street`,`target_town`,`target_county`,`target_postcode`,`target_country`,`target_email`,`department`,`cost_code`,`od_status`,`od_timestamp`,`od_createdon`,`od_createdby`,`od_updatedon`,`od_updatedby`,`paymethod_type`,`send_type`,`sapfile_id`) values 
(1,'518908d2d68339ad7c00011c','518908d2d68339ad7c00011d','R00001001','2013-05-09','','0000-00-00','2013-05-09','0000-00-00',2,0,0,'2013-05-09 15:49:54',0,'2013-05-09 15:49:54',1,'0000-00-00',2,'0000-00-00','988.95','1186.74','197.79','0.00','','0000-00-00','0000-00-00','','','','1.pdf','Backing-1.pdf','','','','','','','','','','','','','','','','','','',1,NULL,'2013-05-09 15:49:54',79545,'2013-05-09 15:51:41',79545,NULL,NULL,0),
(2,'518908d2d68339ad7c000184','518908d2d68339ad7c000185','R00001002','2013-05-09','','0000-00-00','2013-05-09','0000-00-00',2,0,0,'2013-05-09 15:50:35',0,'2013-05-09 15:50:35',1,'0000-00-00',2,'0000-00-00','1507.20','1808.64','301.44','0.00','','0000-00-00','0000-00-00','','','','2.pdf','Backing-2.pdf','','','','','','','','','','','','','','','','','','',1,NULL,'2013-05-09 15:50:35',79545,'2013-05-09 15:52:37',79545,NULL,NULL,0),
(23,'518908d2d68339ad7c00016c','518908d2d68339ad7c00016d','R00001023','2013-05-09','','0000-00-00','2013-05-09','0000-00-00',3,0,0,'2013-05-09 16:45:00',0,'2013-05-09 16:45:00',1,'0000-00-00',0,'0000-00-00','0.00','0.00','0.00','0.00','','0000-00-00','0000-00-00','','','','23.pdf','Backing-23.pdf','','','','','','','','','','','','','','','','','','',1,NULL,'2013-05-09 16:45:00',79545,'2013-05-09 16:46:36',79545,NULL,NULL,0);

/*Table structure for table `invoice_ebulkimport` */

DROP TABLE IF EXISTS `invoice_ebulkimport`;

CREATE TABLE `invoice_ebulkimport` (
  `urn` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `SapClientCode` varchar(100) DEFAULT NULL,
  `ApplicantForename` varchar(100) DEFAULT NULL,
  `ApplicantSurname` varchar(100) DEFAULT NULL,
  `ApplicationSentDate` varchar(20) DEFAULT NULL,
  `AppRef` varchar(100) DEFAULT NULL,
  `OrganisationReference` varchar(100) DEFAULT NULL,
  `OrganisationName` varchar(100) DEFAULT NULL,
  `OrganisationPostcode` varchar(100) DEFAULT NULL,
  `ApplicantIsVolunteer` varchar(100) DEFAULT NULL,
  `ApplicationChannel` varchar(100) DEFAULT NULL,
  `ApplicationDisclosureType` varchar(100) DEFAULT NULL,
  `ApplicationBasicFee` float NOT NULL DEFAULT '0',
  `ApplicationAdminFee` float NOT NULL DEFAULT '0',
  `ApplicationDBSAdultFirstFee` float NOT NULL DEFAULT '0',
  `ApplicationDBSAdultFirstAdminFee` float NOT NULL DEFAULT '0',
  `ApplicationEnhancedFee` float NOT NULL DEFAULT '0',
  `ApplicationStandardFee` float NOT NULL DEFAULT '0',
  `ApplicationPaymentCharge` float NOT NULL DEFAULT '0',
  `ApplicationPaymentChargeExempt` varchar(10) DEFAULT NULL,
  `ApplicationVatFee` float NOT NULL DEFAULT '0',
  `ApplicationVatExempt` varchar(100) DEFAULT NULL,
  `ApplicationTotalFee` float DEFAULT NULL,
  `ApplicationPaymentIndicator` varchar(100) DEFAULT NULL,
  `EbulkInvoiceUpdates` varchar(100) DEFAULT NULL,
  `ApplicationRepeatCheck` varchar(100) DEFAULT NULL,
  `ApplicationCostCode` varchar(100) DEFAULT NULL,
  `OrganisationPurchaseOrderNumber` varchar(100) DEFAULT NULL,
  `batchID` varchar(45) DEFAULT NULL,
  `edited` tinyint(1) DEFAULT '0',
  `imported` tinyint(1) DEFAULT '0',
  `FK_invoiceNum` varchar(100) DEFAULT NULL,
  `UdatedOn` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`urn`),
  KEY `FK_invoiceNum` (`FK_invoiceNum`),
  KEY `SapClientCode` (`SapClientCode`),
  KEY `imported` (`imported`),
  FULLTEXT KEY `AppRef` (`AppRef`),
  FULLTEXT KEY `batchID` (`batchID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `invoice_ebulkimport` */

insert  into `invoice_ebulkimport`(`urn`,`SapClientCode`,`ApplicantForename`,`ApplicantSurname`,`ApplicationSentDate`,`AppRef`,`OrganisationReference`,`OrganisationName`,`OrganisationPostcode`,`ApplicantIsVolunteer`,`ApplicationChannel`,`ApplicationDisclosureType`,`ApplicationBasicFee`,`ApplicationAdminFee`,`ApplicationDBSAdultFirstFee`,`ApplicationDBSAdultFirstAdminFee`,`ApplicationEnhancedFee`,`ApplicationStandardFee`,`ApplicationPaymentCharge`,`ApplicationPaymentChargeExempt`,`ApplicationVatFee`,`ApplicationVatExempt`,`ApplicationTotalFee`,`ApplicationPaymentIndicator`,`EbulkInvoiceUpdates`,`ApplicationRepeatCheck`,`ApplicationCostCode`,`OrganisationPurchaseOrderNumber`,`batchID`,`edited`,`imported`,`FK_invoiceNum`,`UdatedOn`) values 
(1,'115962','sdsds','WEIsdsds','2013-04-15','784WEI4207','SHUDS','Sheffield Hallam University','S1 1WB','false','ebulk','Enhanced',0,3.5,0,0,0,0,0,'',0.7,'false',4.2,'Invoice','','','','','MAY_BATCH',1,1,NULL,NULL),
(2,'115962','sdsdsdsd','sddsdsd','2013-04-10','639Z4MZ8854','SHUDS','Sheffield Hallam University','S1 1WB','false','ebulk','Enhanced',0,3.5,0,0,0,0,0,'',0.7,'false',4.2,'Invoice','','','','','MAY_BATCH',1,1,NULL,NULL);

/*Table structure for table `invoice_email_queue` */

DROP TABLE IF EXISTS `invoice_email_queue`;

CREATE TABLE `invoice_email_queue` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `contract_name` varchar(100) DEFAULT '',
  `invoice_number` varchar(20) DEFAULT '',
  `od_createdon` datetime DEFAULT NULL,
  `od_updatedby` varchar(50) DEFAULT NULL,
  `od_updatedon` datetime DEFAULT NULL,
  `od_createdby` int(11) DEFAULT NULL,
  `invoice_id` varchar(50) DEFAULT NULL,
  `template` text,
  `username` varchar(50) NOT NULL DEFAULT '',
  `to` varchar(200) DEFAULT NULL,
  `from` varchar(50) DEFAULT NULL,
  `cc` varchar(200) DEFAULT NULL,
  `bcc` varchar(200) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `PDFAttachment` varchar(200) DEFAULT NULL,
  `BackingPDFAttachment` varchar(210) DEFAULT NULL,
  `BackingCSVAttachment` varchar(210) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `invoice_email_queue` */

/*Table structure for table `invoice_email_templates` */

DROP TABLE IF EXISTS `invoice_email_templates`;

CREATE TABLE `invoice_email_templates` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `email_template` text,
  `po_template` text,
  `od_createdon` datetime DEFAULT NULL,
  `od_updatedby` varchar(50) DEFAULT NULL,
  `od_updatedon` datetime DEFAULT NULL,
  `od_createdby` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `subject` varchar(100) NOT NULL DEFAULT '',
  `email_from` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

/*Data for the table `invoice_email_templates` */

insert  into `invoice_email_templates`(`id`,`email_template`,`po_template`,`od_createdon`,`od_updatedby`,`od_updatedon`,`od_createdby`,`username`,`subject`,`email_from`) values 
(21,'<div class=\"WordSection1\">\r\n<p><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">Please find attached your latest Invoice, which we have raised, along with backup information.</span></p>\r\n<p><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">Also attached is a CSV of the Invoice backup for you to use if required.</span></p>\r\n<span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">Kind Regards</span>\r\n<p class=\"MsoNormal\"><strong><span lang=\"EN-US\" style=\"font-size: 11.0pt; font-family: \'Arial\',\'sans-serif\'; color: #5587b4;\">Finance Team</span><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Trebuchet MS\',\'sans-serif\'; color: #027ab6;\"><br style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #5587b4;\" /></span></strong><span lang=\"EN-US\" style=\"font-size: 9.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">____________________________________________________________________________<br /></span><span lang=\"EN-US\" style=\"font-size: 4.5pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\"><br /></span><strong><span lang=\"EN-US\" style=\"font-size: 10.0pt; font-family: \'Arial\',\'sans-serif\'; color: #5587b4;\"><strong>Capita Recruitment Vetting Services</strong> &nbsp;</span></strong><span lang=\"EN-US\" style=\"font-size: 6.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">part of Capita plc</span><span lang=\"EN-US\" style=\"font-size: 9.0pt; font-family: \'Arial\',\'sans-serif\'; color: #1f497d;\"><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span lang=\"EN-US\" style=\"font-size: 11.0pt; font-family: \'Arial\',\'sans-serif\'; color: #1f497d;\"><br /></span><strong><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #5587b4;\">ddi</span></strong><strong><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #027ab6;\">:</span></strong><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\"> +44(0)1420 595516</span><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #027ab6;\">&nbsp;&nbsp;</span><strong><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #5587b4;\">fax: </span></strong><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">01420 595589</span></p>\r\n<p class=\"MsoNormal\"><span lang=\"EN-US\" style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">Cross and Pillory House, Cross and Pillory Lane, Alton, Hampshire, GU34 1HL, United Kingdom</span><span lang=\"EN-US\" style=\"font-size: 11.0pt; font-family: \'Arial\',\'sans-serif\'; color: #1f497d;\"> <br /></span><span style=\"font-size: 11.0pt; font-family: \'Calibri\',\'sans-serif\';\"><a href=\"http://www.securitywatchdog.org.uk\"><strong><span lang=\"EN-US\" style=\"font-size: 7.5pt; font-family: \'Arial\',\'sans-serif\';\">www.securitywatchdog.org.uk</span></strong></a></span><span lang=\"EN-US\" style=\"font-size: 11.0pt; font-family: \'Arial\',\'sans-serif\'; color: #1f497d;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><strong><span style=\"text-decoration: underline;\"><span lang=\"EN-US\" style=\"font-size: 7.5pt; font-family: \'Arial\',\'sans-serif\'; color: blue;\"><a href=\"mailto:finance@securitywatchdog.org.uk\">finance@securitywatchdog.org.uk</a></span></span></strong></p>\r\n<p class=\"MsoNormal\"><span style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #747678;\">A trading name of Capita Resourcing Ltd.</span></p>\r\n<p class=\"MsoNormal\"><span style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #747678;\">Registered office as below. Registered in England No. 3949686</span></p>\r\n<p class=\"MsoNormal\"><span style=\"font-size: 8.0pt; font-family: \'Arial\',\'sans-serif\'; color: #747678;\">Part of Capita plc, 71 Victoria Street, Westminster, London SW1H 0XA</span></p>\r\n<p class=\"MsoNormal\"><strong><span lang=\"EN-US\" style=\"font-size: 10.0pt; font-family: \'Arial\',\'sans-serif\'; color: #027ab6;\">&nbsp;</span></strong><span lang=\"EN-US\" style=\"font-size: 9.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">______________________________________________________________________________</span></p>\r\n<p class=\"MsoNormal\" style=\"mso-margin-top-alt: auto; mso-margin-bottom-alt: auto; text-align: justify;\"><strong><span lang=\"EN-US\" style=\"font-size: 7.0pt; font-family: \'Arial\',\'sans-serif\'; color: #5587b4;\">The Security Watchdog</span></strong><span lang=\"EN-US\" style=\"font-size: 7.0pt; font-family: \'Arial\',\'sans-serif\'; color: #5587b4;\"> is the international industry leader and subject matter expert in all areas of background screening and risk mitigation solutions in EMEA and internationally. The Security Watchdog works with over 10% of FTSE 100 companies and undertakes Best Practice pre and post employment screening to underpin informed recruitment decisions. Screening is carried out with candidate consent in compliance with Data Protection regulations. </span></p>\r\n<p class=\"MsoNormal\" style=\"mso-margin-top-alt: auto; mso-margin-bottom-alt: auto; text-align: justify;\"><span lang=\"EN-US\" style=\"font-size: 7.0pt; font-family: \'Arial\',\'sans-serif\'; color: #717073;\">The Security Watchdog scans all documents using the latest anti-virus software and virus definition files before sending them. However, we also recommend that you ensure that your own scanning software and procedures are kept up-to-date and fully operational. CONFIDENTIAL - The information contained in this email and any attachment is confidential. It is intended only for the named addressee(s) If you are not the named addressee please notify the sender immediately and do not disclose, copy or distribute the contents to any other person other than the intended. The Security Watchdog is a trading name of Capita Resourcing Ltd. </span><span style=\"font-size: 7.0pt; font-family: \'Arial\',\'sans-serif\'; color: #747678;\">Registered in England No. 3949686. Part of Capita plc. 71 Victoria Street, Westminster, London SW1H 0XA.</span></p>\r\n</div>','','2018-02-19 12:19:23',NULL,NULL,79554,'NGV Support','Invoice','finance@securitywatchdog.org.uk');

/*Table structure for table `invoice_line` */

DROP TABLE IF EXISTS `invoice_line`;

CREATE TABLE `invoice_line` (
  `urn` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_id` int(12) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `net` decimal(10,2) DEFAULT NULL,
  `vat` decimal(10,2) DEFAULT NULL,
  `gross` decimal(10,2) DEFAULT NULL,
  `total_net` decimal(10,2) DEFAULT NULL,
  `total_vat` decimal(10,2) DEFAULT NULL,
  `total_gross` decimal(10,2) DEFAULT NULL,
  `qty` int(8) DEFAULT NULL,
  `vat_rate` decimal(8,2) DEFAULT NULL,
  `comments` text,
  `od_status` int(1) DEFAULT NULL,
  `od_timestamp` varchar(40) DEFAULT NULL,
  `od_createdon` datetime DEFAULT NULL,
  `od_createdby` int(12) DEFAULT NULL,
  `od_updatedon` datetime DEFAULT NULL,
  `od_updatedby` int(12) DEFAULT NULL,
  PRIMARY KEY (`urn`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `invoice_line` */

insert  into `invoice_line`(`urn`,`invoice_id`,`name`,`description`,`net`,`vat`,`gross`,`total_net`,`total_vat`,`total_gross`,`qty`,`vat_rate`,`comments`,`od_status`,`od_timestamp`,`od_createdon`,`od_createdby`,`od_updatedon`,`od_updatedby`) values 
(1,1,'Admin Fee','','2.85','0.57','3.42','988.95','197.79','1186.74',347,'0.00','',1,NULL,'2013-05-09 15:49:54',79545,NULL,NULL),
(2,2,'Admin Fee','','2.40','0.48','2.88','1507.20','301.44','1808.64',628,'0.00','',1,NULL,'2013-05-09 15:50:35',79545,NULL,NULL),
(23,24,'Admin Fee','','3.00','0.60','3.60','585.00','117.00','702.00',195,'0.00','',1,NULL,'2013-05-10 11:21:24',79545,NULL,NULL);

/*Table structure for table `invoice_sapfile` */

DROP TABLE IF EXISTS `invoice_sapfile`;

CREATE TABLE `invoice_sapfile` (
  `sapfile_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sapfile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `invoice_sapfile` */

/*Table structure for table `invoice_txn_details` */

DROP TABLE IF EXISTS `invoice_txn_details`;

CREATE TABLE `invoice_txn_details` (
  `invoice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `invoice_number` varchar(255) NOT NULL,
  `invoice_status` varchar(255) DEFAULT NULL,
  `invoice_paymethod` varchar(255) DEFAULT NULL,
  `invoice_send_type` varchar(255) DEFAULT NULL,
  `invoice_sent_date` datetime DEFAULT NULL,
  `invoice_client_id` bigint(20) NOT NULL,
  `invoice_contract_id` bigint(20) NOT NULL,
  `invoice_sapfile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `FK6rn81y54qthdw90cfylavs00o` (`invoice_client_id`),
  KEY `FKihx6kla2nm4whd6kiey7mhnr6` (`invoice_contract_id`),
  KEY `FK682dkbduw3suemxosa869jm5d` (`invoice_sapfile_id`),
  CONSTRAINT `FK682dkbduw3suemxosa869jm5d` FOREIGN KEY (`invoice_sapfile_id`) REFERENCES `invoice_sapfile` (`sapfile_id`),
  CONSTRAINT `FK6rn81y54qthdw90cfylavs00o` FOREIGN KEY (`invoice_client_id`) REFERENCES `invoice_client` (`client_id`),
  CONSTRAINT `FKihx6kla2nm4whd6kiey7mhnr6` FOREIGN KEY (`invoice_contract_id`) REFERENCES `invoice_contract` (`contract_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `invoice_txn_details` */

/*Table structure for table `passwordresettoken` */

DROP TABLE IF EXISTS `passwordresettoken`;

CREATE TABLE `passwordresettoken` (
  `id` bigint(20) NOT NULL,
  `expiryDate` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `passwordresettoken` */

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `persistent_logins` */

/*Table structure for table `user_details` */

DROP TABLE IF EXISTS `user_details`;

CREATE TABLE `user_details` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  `authority` varchar(1500) DEFAULT NULL,
  `user_created_date` datetime DEFAULT NULL,
  `user_updated_date` datetime DEFAULT NULL,
  `failed_attempts` int(11) DEFAULT '0',
  `user_locked_until_date` datetime DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `is_one_time_password` tinyint(1) DEFAULT '0',
  `expiry_date` datetime DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `user_enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `user_details` */

insert  into `user_details`(`userid`,`user_name`,`password`,`email`,`dob`,`enabled`,`authority`,`user_created_date`,`user_updated_date`,`failed_attempts`,`user_locked_until_date`,`token`,`is_one_time_password`,`expiry_date`,`user_role`,`user_enabled`) values 
(2,'demo','$2a$10$wtJUmMxg52O64ijD1JjLd.IDjO3hvWfMLFJu3u.TFjdT8C/Abvazq','demo@ganesh.com','1980-12-12',1,'ROLE_ADMIN','2018-09-12 14:18:02',NULL,0,NULL,NULL,0,NULL,NULL,NULL),
(3,'ganesh','$2a$10$wtJUmMxg52O64ijD1JjLd.IDjO3hvWfMLFJu3u.TFjdT8C/Abvazq','ganesh@ganesh.com','1980-12-12',1,'ROLE_ADMIN','2018-09-12 14:18:02',NULL,0,NULL,NULL,0,NULL,NULL,NULL),
(4,'sonali','$2a$10$wtJUmMxg52O64ijD1JjLd.IDjO3hvWfMLFJu3u.TFjdT8C/Abvazq','sonali@ganesh.com','1980-12-12',1,'ROLE_ADMIN','2018-09-12 14:18:02',NULL,0,NULL,NULL,0,NULL,NULL,NULL),
(5,'dan','$2a$10$wtJUmMxg52O64ijD1JjLd.IDjO3hvWfMLFJu3u.TFjdT8C/Abvazq','dan@ganesh.com','1980-12-12',1,'ROLE_ADMIN','2018-09-12 14:18:02',NULL,0,NULL,NULL,0,NULL,NULL,NULL),
(6,'chris','$2a$10$wtJUmMxg52O64ijD1JjLd.IDjO3hvWfMLFJu3u.TFjdT8C/Abvazq','chris@ganesh.com','1980-12-12',1,'ROLE_ADMIN','2018-09-12 14:18:02',NULL,0,NULL,NULL,0,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
