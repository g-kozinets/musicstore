CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addresses` (
  `adressPK_id` int(11) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(45) DEFAULT NULL,
  `street_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adressPK_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'lojinskaya','15'),(2,'leftstrett','100'),(3,'rightstreet','201'),(4,'Malaya','2'),(5,'Bolshaya','34');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instruments`
--

DROP TABLE IF EXISTS `instruments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `instruments` (
  `instrPK_id` int(11) NOT NULL AUTO_INCREMENT,
  `instr_name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `manufctFK_id` int(11) NOT NULL,
  `supplierFK_id` int(11) NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`instrPK_id`),
  KEY `manufact_instrum_idx` (`manufctFK_id`),
  KEY `suppliers_instrum_idx` (`supplierFK_id`),
  CONSTRAINT `manufact_instrum` FOREIGN KEY (`manufctFK_id`) REFERENCES `manufacturers` (`manufacturepk_id`),
  CONSTRAINT `suppliers_instrum` FOREIGN KEY (`supplierFK_id`) REFERENCES `suppliers` (`supplierpk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instruments`
--

LOCK TABLES `instruments` WRITE;
/*!40000 ALTER TABLE `instruments` DISABLE KEYS */;
INSERT INTO `instruments` VALUES (1,'Korg 213xp','keyboard',5,3,100),(2,'Yamaha EX23','Piano',2,2,230),(3,'Roland Blaze','Amplifier',2,4,70);
/*!40000 ALTER TABLE `instruments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturers`
--

DROP TABLE IF EXISTS `manufacturers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `manufacturers` (
  `manufacturePK_id` int(11) NOT NULL AUTO_INCREMENT,
  `manufct_name` varchar(45) DEFAULT NULL,
  `manufct_location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`manufacturePK_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturers`
--

LOCK TABLES `manufacturers` WRITE;
/*!40000 ALTER TABLE `manufacturers` DISABLE KEYS */;
INSERT INTO `manufacturers` VALUES (1,'Marshall','UK'),(2,'Yamaha','Japan'),(3,'Fender','USA'),(4,'Roland','Japan'),(5,'Korg','Japan');
/*!40000 ALTER TABLE `manufacturers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `orderPK_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_name` varchar(45) DEFAULT NULL,
  `addressFK_id` int(11) NOT NULL,
  `total_price` double DEFAULT NULL,
  `instrFK_id` int(11) NOT NULL,
  PRIMARY KEY (`orderPK_id`),
  KEY `instr_orders_idx` (`instrFK_id`),
  KEY `adress_orders_idx` (`addressFK_id`),
  CONSTRAINT `adress_orders` FOREIGN KEY (`addressFK_id`) REFERENCES `addresses` (`adresspk_id`),
  CONSTRAINT `instr_orders` FOREIGN KEY (`instrFK_id`) REFERENCES `instruments` (`instrpk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `suppliers` (
  `supplierPK_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(45) DEFAULT NULL,
  `supplier_location` varchar(45) DEFAULT NULL,
  `delivery_price` double DEFAULT NULL,
  PRIMARY KEY (`supplierPK_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Vasia','Japan',10),(2,'Petya','USA',20),(3,'Brother','Russia',15),(4,'Best Supplier','UK',23),(5,'Even better','Germany',24);
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-07 21:45:45
