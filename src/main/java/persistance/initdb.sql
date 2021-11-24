-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 161.35.214.156    Database: cupcake
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `Bottom`
--

DROP TABLE IF EXISTS `Bottom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bottom` (
  `id_bottom` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bottomPrice` double DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id_bottom`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bottom`
--

--
-- Table structure for table `Cart`
--

DROP TABLE IF EXISTS `Cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cart` (
  `id_cart` int NOT NULL AUTO_INCREMENT,
  `id_cartitems` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_cart`),
  KEY `Cart_FK` (`id_cartitems`),
  KEY `User_Cart_FK` (`id_user`),
  CONSTRAINT `Cart_FK` FOREIGN KEY (`id_cartitems`) REFERENCES `Cartitems` (`id_cartitems`),
  CONSTRAINT `User_Cart_FK` FOREIGN KEY (`id_user`) REFERENCES `Users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cart`
--

--
-- Table structure for table `Cartitems`
--

DROP TABLE IF EXISTS `Cartitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cartitems` (
  `id_cartitems` int NOT NULL AUTO_INCREMENT,
  `id_bottom` int NOT NULL,
  `id_topping` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`id_cartitems`),
  KEY `Bottom_FK` (`id_bottom`),
  KEY `Topping_FK` (`id_topping`),
  CONSTRAINT `Bottom_FK` FOREIGN KEY (`id_bottom`) REFERENCES `Bottom` (`id_bottom`),
  CONSTRAINT `Topping_FK` FOREIGN KEY (`id_topping`) REFERENCES `Topping` (`id_topping`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cartitems`
--

--
-- Table structure for table `Orderitems`
--

DROP TABLE IF EXISTS `Orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orderitems` (
  `id_orderitems` int NOT NULL AUTO_INCREMENT,
  `id_bottom` int NOT NULL,
  `id_topping` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`id_orderitems`),
  KEY `Bottom_Orderitems_FK` (`id_bottom`),
  KEY `Topping_Orderitems_FK` (`id_topping`),
  CONSTRAINT `Bottom_Orderitems_FK` FOREIGN KEY (`id_bottom`) REFERENCES `Bottom` (`id_bottom`),
  CONSTRAINT `Topping_Orderitems_FK` FOREIGN KEY (`id_topping`) REFERENCES `Topping` (`id_topping`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orderitems`
--

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
  `id_order` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_orderitems` int NOT NULL,
  `status` varchar(100) COLLATE utf8mb4_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  KEY `Orders_FK` (`id_user`),
  KEY `id_Ordersitems_FK` (`id_orderitems`),
  CONSTRAINT `id_Ordersitems_FK` FOREIGN KEY (`id_orderitems`) REFERENCES `Orderitems` (`id_orderitems`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Orders_FK` FOREIGN KEY (`id_user`) REFERENCES `Users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

--
-- Table structure for table `PremadeCupcake`
--

DROP TABLE IF EXISTS `PremadeCupcake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PremadeCupcake` (
  `id_item` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `desc` varchar(255) NOT NULL,
  `imageURL` varchar(100) NOT NULL,
  `bottom` int DEFAULT NULL,
  `topping` int DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `ItemDescriptions_FK` (`bottom`),
  KEY `ItemDescriptions_FK_1` (`topping`),
  CONSTRAINT `ItemDescriptions_FK` FOREIGN KEY (`bottom`) REFERENCES `Bottom` (`id_bottom`),
  CONSTRAINT `ItemDescriptions_FK_1` FOREIGN KEY (`topping`) REFERENCES `Topping` (`id_topping`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PremadeCupcake`
--

--
-- Table structure for table `Topping`
--

DROP TABLE IF EXISTS `Topping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Topping` (
  `id_topping` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `toppingPrice` double DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id_topping`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Topping`
--

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `balance` double NOT NULL,
  `role` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sessionID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

--
-- Dumping routines for database 'cupcake'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-24 12:17:21
