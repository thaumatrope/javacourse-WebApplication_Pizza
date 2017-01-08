CREATE DATABASE  IF NOT EXISTS `guestbook` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `guestbook`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 192.168.178.113    Database: guestbook
-- ------------------------------------------------------
-- Server version	5.5.35-1ubuntu1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `filterwords`
--

DROP TABLE IF EXISTS `filterwords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filterwords` (
  `word` varchar(70) NOT NULL,
  PRIMARY KEY (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filterwords`
--

LOCK TABLES `filterwords` WRITE;
/*!40000 ALTER TABLE `filterwords` DISABLE KEYS */;
INSERT INTO `filterwords` VALUES ('sauPreiss'),('sauPreiß'),('saupreuss');
/*!40000 ALTER TABLE `filterwords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gaestebuch`
--

DROP TABLE IF EXISTS `gaestebuch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gaestebuch` (
  `vorname` varchar(45) DEFAULT NULL,
  `nachname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `web` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `kommentar` varchar(45) DEFAULT NULL,
  `sessionid` varchar(45) DEFAULT NULL,
  `inet` varchar(45) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `entrydate` timestamp NULL DEFAULT NULL,
  `entryId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`entryId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gaestebuch`
--

LOCK TABLES `gaestebuch` WRITE;
/*!40000 ALTER TABLE `gaestebuch` DISABLE KEYS */;
INSERT INTO `gaestebuch` VALUES ('Hans-Herbert','Meier','Hans@hans.de','www','34','Bayern','sauPreiß','bb395e353e4eed6e59c67f1e1f3b','0:0:0:0:0:0:0:1','2016-02-04',NULL,1),('Hans-Herbert','im Glück','Hans@hans.de','Alles wird gut','12','Bayern','sauPreiss','bbc9609d1f2841cea60c5a808026','0:0:0:0:0:0:0:1','2016-02-04',NULL,5),('Franz','Beckenbauer','Hans@hans.de','www','12','Bayern','sauPreiss','bc1336b6172e043958ec800f9e87','0:0:0:0:0:0:0:1','2016-02-04',NULL,7),('Hans-Herbert','Meier','Franz','www','12','Bayern','Alles saupreuss','1d55a42cf2e80d03e49b6114bc83','0:0:0:0:0:0:0:1','2016-05-27',NULL,8),('Hans-Herbert','Meier','Franz','www','12','Bayern','Alles saupreuss','1d55a42cf2e80d03e49b6114bc83','0:0:0:0:0:0:0:1','2016-05-27',NULL,9),('Hans-Herbert','Meier','Franz','www','12','Bayern','Alles saupreuss','1d55a42cf2e80d03e49b6114bc83','0:0:0:0:0:0:0:1','2016-05-27',NULL,10),('Uli','Hoeness','Uli@Uli.de','www','12','Bayern','Hallo Welt','d4f4758e610d6754cf88761aefd0','0:0:0:0:0:0:0:1','2016-07-21',NULL,11),('Uli','Hoeness','Uli@Uli.de','www','12','Bayern','Hallo Welt','d4f4758e610d6754cf88761aefd0','0:0:0:0:0:0:0:1','2016-07-21',NULL,12),('Hans','Meier','Hans@hans.de','www','12','Bayern','Ihr seid ja alle      sauPreiß               ','25ff66553074007acebb2ad24048','0:0:0:0:0:0:0:1','2016-09-16',NULL,13),('Ulrike','Meier','www','www','12','Bayern','sauPreuss                     ','2802b284ad51d1d1aaa596a66984','0:0:0:0:0:0:0:1','2016-11-14',NULL,14),('hans','Meier','dirk.albrecht@klu.de','www','12','Bayern','saupreuss                        ','e45be1150c4306e6449a55521d90','0:0:0:0:0:0:0:1','2017-01-05',NULL,15);
/*!40000 ALTER TABLE `gaestebuch` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-05 12:00:27
