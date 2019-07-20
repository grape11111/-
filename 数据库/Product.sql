-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: product
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admins` (
  `aID` int(6) NOT NULL AUTO_INCREMENT,
  `aNickname` varchar(20) NOT NULL,
  `aName` varchar(10) NOT NULL,
  `aSex` varchar(2) NOT NULL,
  `aPassword` varchar(10) NOT NULL,
  `aPhone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`aID`),
  UNIQUE KEY `aNickname_UNIQUE` (`aNickname`)
) ENGINE=InnoDB AUTO_INCREMENT=100003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (100001,'小莉','莉莉','女','123456','12345678912'),(100002,'小李','李林','男','123456','12345875321');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart` (
  `uID` int(6) NOT NULL,
  `code` char(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`uID`,`code`),
  KEY `2_idx` (`code`),
  CONSTRAINT `1` FOREIGN KEY (`uID`) REFERENCES `users` (`uID`),
  CONSTRAINT `2` FOREIGN KEY (`code`) REFERENCES `product` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (100001,'1',1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderproduct`
--

DROP TABLE IF EXISTS `orderproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orderproduct` (
  `orderID` char(16) NOT NULL,
  `code` char(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderID`,`code`),
  KEY `fk_product_idx` (`code`),
  CONSTRAINT `fk_order` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`),
  CONSTRAINT `fk_product` FOREIGN KEY (`code`) REFERENCES `product` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderproduct`
--

LOCK TABLES `orderproduct` WRITE;
/*!40000 ALTER TABLE `orderproduct` DISABLE KEYS */;
INSERT INTO `orderproduct` VALUES ('1000011906212865','8',1),('1000011906215877','12',1),('1000011906215877','13',1),('1000011906216614','12',1),('1000011906216614','14',1),('1000021906220379','8',1),('1000021906226719','1',1),('1000021906229581','1',1);
/*!40000 ALTER TABLE `orderproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `orderID` char(16) NOT NULL,
  `uID` int(6) NOT NULL,
  `datetime` char(30) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0',
  `result` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('1000011906212865',100001,'2019/06/21 21:12:32',1,0),('1000011906215877',100001,'2019/06/21 21:34:55',1,1),('1000011906216614',100001,'2019/06/21 21:35:26',1,1),('1000021906220379',100002,'2019/06/22 09:50:10',1,0),('1000021906226719',100002,'2019/06/22 09:59:36',1,0),('1000021906229581',100002,'2019/06/22 20:45:49',1,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `code` char(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `style` char(15) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1','长袖','Clothes',33),('11','牛仔裤','Clothes',59),('12','连衣裙','Clothes',180),('13','高等数学','Book',36),('14','巧克力','Food',72),('15','薯片','Food',37),('2','短袖','Clothes',22),('3','Java','Book',30),('4','海苔','Food',16),('5','数据结构','Book',42),('6','JavaWeb','Book',24),('66','连衣裙','Clothes',22),('7','大学英语','Book',26),('8','面包','Food',42);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `uID` int(6) NOT NULL,
  `uNickname` varchar(20) NOT NULL,
  `uName` varchar(10) NOT NULL,
  `uSex` varchar(2) NOT NULL,
  `uPassword` varchar(10) NOT NULL,
  `uPhone` varchar(11) DEFAULT NULL,
  `uAddress` varchar(50) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`uID`),
  UNIQUE KEY `uNickname_UNIQUE` (`uNickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (100001,'小汤','Tom','男','123456','12345678914','广东工业大学龙洞校区',1),(100002,'张三','张三','男','123456','13131313133','广东省广州市天河区',1),(100003,'lisa','lisa','女','123456','12345678911','广东省广州市',1),(100004,'李四','李四','男','123456','12345678913','广东省广州市天河区',0),(100005,'Jack','杰克','男','123456abc','13555522246','北京市',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-22 23:54:44
