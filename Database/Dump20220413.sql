-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: agronomydb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `catid` int NOT NULL AUTO_INCREMENT,
  `catname` varchar(30) NOT NULL,
  `catdesc` varchar(100) NOT NULL,
  PRIMARY KEY (`catid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Fertilizers','Variety of different fertilizers,pesticide,insecticides,crop nutrition'),(2,'Seeds','Horticulture seeds, feild crops,Saplings etc'),(3,'Machinaries','Powertiller,weeder, tools and equipments.');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerrequest`
--

DROP TABLE IF EXISTS `customerrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerrequest` (
  `orderid` int NOT NULL,
  `cid` int NOT NULL,
  `sid` int NOT NULL,
  `requesttype` varchar(30) NOT NULL,
  `requestdesc` varchar(100) NOT NULL,
  `response` varchar(100) DEFAULT NULL,
  `requeststatus` varchar(30) NOT NULL DEFAULT 'Pending',
  PRIMARY KEY (`orderid`,`cid`),
  KEY `FK_Cid_Custreq_idx` (`cid`),
  KEY `FK_Sid_Custreq_idx` (`sid`),
  CONSTRAINT `FK_Cid_Custreq` FOREIGN KEY (`cid`) REFERENCES `customers` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_OrderId_Custreq` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Sid_Custreq` FOREIGN KEY (`sid`) REFERENCES `sellers` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerrequest`
--

LOCK TABLES `customerrequest` WRITE;
/*!40000 ALTER TABLE `customerrequest` DISABLE KEYS */;
INSERT INTO `customerrequest` VALUES (3,1,3,'maintainence','replace the battries in sprayer','viewed','pending');
/*!40000 ALTER TABLE `customerrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `loginid` int DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK9p50r2kakm3c1cla4hcmlf81a` (`loginid`),
  CONSTRAINT `FK9p50r2kakm3c1cla4hcmlf81a` FOREIGN KEY (`loginid`) REFERENCES `login` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Kartik','Verma',2),(5,'dummy','dunn',6),(6,'dummyet','dunny',7),(7,'dummyeti','dunnya',8),(8,'dueti','du',9),(9,'dueti','du',11),(10,'aaaa','bbbb',12),(11,'bbbb','asdhj',13),(14,'regdummmy','saddsad',16),(15,'reagsf','dasd',17),(16,'vctrd','asjj',18),(17,'helloworld','this',19),(18,'hvtre','asjv ',20),(19,'asdas','bgdsagyu',21),(20,'Rohit','sharma',22),(21,'adddb','sajggs',23),(22,'Rohan','Gupta',24);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `pass` varchar(12) NOT NULL,
  `ans` varchar(30) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contactno` varchar(10) NOT NULL,
  `accstatus` varchar(10) NOT NULL DEFAULT 'Enabled',
  `address` varchar(100) NOT NULL,
  `role` varchar(10) NOT NULL,
  `roleid` int NOT NULL,
  `sec_ques` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'saurabh#123','saurabh','Saurabh123@gmail.com','9665578123','enabled','p-22 spineroad,pune,maharashtra,411033','Seller',2,NULL),(2,'kar123','5','Kartik85@gmail.com','9882230304','enabled','g-564,range colony, bhugaon,pune,maharashtra,410234','Customer',3,NULL),(3,'Adi$171','licence card','Aditya171@gmail.com','8977984115','enabled','po-106, Range hills,Loahgaon,pune,410034','Admin',1,NULL),(4,'maheshRockXX','manali','MaheshK988@hotmail.com','9876543210','enabled','plot p-19 H Block,M I D C ,Pimpri,Pune Maharashtra,411018','Seller',2,NULL),(5,'Gta@Spano','blue','SureshAKKK@yahoo.com','7489551810','disabled','La Melosa, Venu Nagar Cotes, Wakad, Pimpri-Chinchwad, Maharashtra,411057','Seller',2,NULL),(6,'var123','var','dummyinsert@gmail.com','8564251','enabled','dummy123 at gmail','Customer',3,NULL),(7,'var152','ert','dummy@gmail.com','8510564251','enabled','dummy at gmail','Customer',3,NULL),(8,'var11','ertuy','dummymmm@gmail.com','8164251','enabled','dumj at gmail','Customer',3,NULL),(9,'vs11','ertuaaasdy','duggmm@gmail.com','816451','enabled','dufhh gmail','Customer',3,NULL),(11,'ve11','ertsdy','duretggmm@gmail.com','8a6451','enabled','dufhh gmail','Customer',3,'addffah ashdf'),(12,'adahjjj','hello','affassa@gmail.com','89856623','enabled','asfcdsaasdiuhh','Customer',3,NULL),(13,'asdda','aadd','asdddaas@gmail.com','9856421','enabled','asxdasjg asugdygy','Customer',3,NULL),(16,'asdadsd','vpnems','asdfdreg@gmail.com','85465215','enabled','agsaggy asduhu','Customer',3,'byschool'),(17,'asddad','cricket','ascft@gmail.com','85479625','enabled','adesgvt afcrts','Customer',3,'bysports'),(18,'acdsret','football','sadas@gamil.com','asdaww','enabled','fdtrst','Customer',3,'Which is Favourite Sport?'),(19,'tysrr sy','rocky','helloworld@gmail.com','75461203','enabled','cvxtr acbvx','Customer',3,''),(20,'asdcxrter','vpacs','avgsas@gmail.com','85210235','enabled','safhd ashdh','Customer',3,'What is School Name from you passed 10th?'),(21,'acfsrtete','asbcter','assda@gmail.com','4545455','enabled','National Medical bhigwan chawk Baramati','Customer',3,'Which is Favourite Sport?'),(22,'rohit@123','vpacs','rohit@gmail.com','858274652','enabled','asjh asdkhh','Customer',3,'What is School Name from you passed 10th?'),(23,'abc','cric','agvvdsab@gmail.com','8542316','enabled','ssahkhkshh sa','Customer',3,'Which is Favourite Sport?'),(24,'rohan123','Nems','rohan@gmail.com','7854213652','enabled','asdhbhj asbhb','Customer',3,'What is School Name from you passed 10th?');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `odid` int NOT NULL AUTO_INCREMENT,
  `orderid` int NOT NULL,
  `pid` int NOT NULL,
  `qty` int NOT NULL,
  `disprice` int NOT NULL,
  PRIMARY KEY (`odid`,`orderid`),
  KEY `Fk_orderdetails_orders_idx` (`orderid`),
  KEY `Fk_orderdetais_products_idx` (`pid`),
  CONSTRAINT `Fk_orderdetails_orders` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Fk_orderdetais_products` FOREIGN KEY (`pid`) REFERENCES `products` (`prodid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (1,22,3,5,780),(2,22,4,6,500);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `orderdt` date NOT NULL,
  `totalprice` decimal(10,2) NOT NULL,
  `paydate` date NOT NULL,
  `paystatus` varchar(10) NOT NULL DEFAULT 'Unpaid',
  `paymode` varchar(10) NOT NULL,
  `transid` int NOT NULL,
  `orderstatus` varchar(10) NOT NULL DEFAULT 'pending',
  `sid` int NOT NULL,
  `cid` int NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FK_SId_orders_idx` (`sid`),
  KEY `FK_Cid_orders_idx` (`cid`),
  CONSTRAINT `FK_Cid_orders` FOREIGN KEY (`cid`) REFERENCES `customers` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SId_orders` FOREIGN KEY (`sid`) REFERENCES `sellers` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,'2022-03-25',8909.00,'2022-03-25','paid','cash',102,'confirmed',3,1),(11,'2022-04-08',3000.00,'2022-04-08','paid','online',108,'delivery',1,7),(12,'2022-04-08',3000.00,'2022-04-08','paid','online',108,'delivery',1,7),(13,'2022-04-08',6000.00,'2022-04-08','paid','online',897,'delivery',1,7),(14,'2022-04-08',8000.00,'2022-04-08','paid','online',908,'delivery',1,7),(15,'2022-04-08',1400.00,'2022-04-08','paid','online',908,'delivery',1,7),(22,'2022-04-08',2400.00,'2022-04-08','paid','online',128,'delivery',1,7);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `prodid` int NOT NULL AUTO_INCREMENT,
  `prodname` varchar(45) NOT NULL,
  `photo` longblob,
  `compname` varchar(30) NOT NULL,
  `varmodel` varchar(30) NOT NULL,
  `proddesc` varchar(250) NOT NULL,
  `catid` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prodid`),
  KEY `FK_Catid_products_idx` (`catid`),
  CONSTRAINT `FK_Catid_products` FOREIGN KEY (`catid`) REFERENCES `categories` (`catid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Phospate Rich Manuare',NULL,'Ts Agri','Organic','organic fertilizer manufactured by cowdung.',1,200.00,'1 kilogram'),(2,'Hybrid Brinjal Seeds',NULL,'MAHYCO','MHB-4','Prominent spines with desi look and Very good taste',2,800.00,'50 grams'),(3,'Hybrid Tomato seed',NULL,'Iris','Hybrid','Iris Hybrid have always believed in sustainable development of the environment by believing in growing a seed per house. The Iris Hybrid concept leads you to a healthy and fit life where you have the opportunity to grow what you eat.',2,134.00,'15 seeds'),(4,'Battery Powered Sprayer',NULL,'Pad Corp','5 Litre','Pad Corp lithium-ion battery sprayer tank capacity 5 liter runs on rechargeable battery Peculiarity Suitable Small office or home or bungalow.',3,8500.00,'1 unit'),(5,'Hand Weeder',NULL,'Tapas','P-104','Useful for removing weeds\nCan be attached to metal / wooden sticking for weeding\nPowder coating to make it rust resistant\nLight weight and easy to operate',3,409.00,'1 unit'),(6,'Chilly Seeds',NULL,'MAHYCO','MHCP-317','Excellent Rejuvenation and Tolerant to Powdery Mildew.',2,3070.00,'50 grams'),(7,'Pottasium Nitrate',NULL,'ShamRock','NPK 13:00:45','It is a free flowing, 100% water-soluble product and recommended to used for drip fertigation or foliar spray. It has nitrate nitrogen content which has proved best for fertilization for almost all the crops.',1,198.00,'1 kg'),(8,'NutriMix',NULL,'Maltose Bio Inovation Pvt. Ltd','MultiMicroNutrients','Nutrimix contains Bioactive, iron ,zinc, Manganaese, Boron, and other essential micronutrients which are microbially chelated and are very effective in all types of soil conditions which works on wide range of soils.',1,270.00,'250ml'),(9,'Pressure Hose Pipe',NULL,'Neptune ','10mm ','Durable & Long Lasting Product Material/Durable And Flexible In All Weathers',3,90.00,'1 meter');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productstock`
--

DROP TABLE IF EXISTS `productstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productstock` (
  `prodstid` int NOT NULL AUTO_INCREMENT,
  `sid` int NOT NULL,
  `prodid` int NOT NULL,
  `qty` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`prodstid`),
  KEY `FK_Sid_ProductStock_idx` (`sid`),
  KEY `FK_ProdId_ProductStock_idx` (`prodid`),
  CONSTRAINT `FK_ProdId_ProductStock` FOREIGN KEY (`prodid`) REFERENCES `products` (`prodid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Sid_ProductStock` FOREIGN KEY (`sid`) REFERENCES `sellers` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productstock`
--

LOCK TABLES `productstock` WRITE;
/*!40000 ALTER TABLE `productstock` DISABLE KEYS */;
INSERT INTO `productstock` VALUES (1,3,1,5),(2,2,2,7),(3,2,3,3),(4,1,4,1),(5,1,5,1),(6,4,2,3),(7,4,3,7),(8,2,6,8),(9,3,7,10),(10,3,8,5),(11,1,9,0);
/*!40000 ALTER TABLE `productstock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `revid` int NOT NULL AUTO_INCREMENT,
  `prodid` int NOT NULL,
  `rating` decimal(10,0) DEFAULT NULL,
  `revdetails` varchar(45) DEFAULT NULL,
  `cid` int NOT NULL,
  PRIMARY KEY (`revid`),
  KEY `FK_ProdId_reviews_idx` (`prodid`),
  KEY `FK_Cid_reviews_idx` (`cid`),
  CONSTRAINT `FK_Cid_reviews` FOREIGN KEY (`cid`) REFERENCES `customers` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ProdId_reviews` FOREIGN KEY (`prodid`) REFERENCES `products` (`prodid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,4,4,'quality is good',1);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sellers`
--

DROP TABLE IF EXISTS `sellers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sellers` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `epname` varchar(50) NOT NULL,
  `licid` varchar(30) NOT NULL,
  `about` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellers`
--

LOCK TABLES `sellers` WRITE;
/*!40000 ALTER TABLE `sellers` DISABLE KEYS */;
INSERT INTO `sellers` VALUES (1,'Saurabh','Sablok','Bombay Machinaries','LCMC2022','We are dealer and wholesaler of the the farm solutions Bombay Machineries Equipments Pvt. Ltd. manufacturers agricultral equipements under the brand name of PUSHPAK.'),(2,'Mahesh','Patil','TS Agri World Organic Pvt Ltd.','LCSD2033','TS Agri World Organic Private Limited company, working since 20 years to a humble beginning as a closed association with “Agriculture and its input”, focusing on development of organic based agricultural input product and Modernize Agriculture.'),(3,'Aditya','Agnihotri','Godrej Agrovet Limited.','LCFD2044','A company that manufactures agricultural products and is one of the largest in the country is included in the top ten list.'),(4,'Suresh','Shukla','JK Agri Genetics Limites','LCSD2055','JKAL is a pioneer in India\'s seed sector, dedicated to helping the farming community, and is one of the top 10 agricultural companies in the country.');
/*!40000 ALTER TABLE `sellers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockdetails`
--

DROP TABLE IF EXISTS `stockdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stockdetails` (
  `Sdid` int NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL,
  `sid` int NOT NULL,
  `qty` int NOT NULL,
  `ops` varchar(10) NOT NULL,
  `desc` varchar(100) NOT NULL,
  PRIMARY KEY (`Sdid`),
  KEY `FK_Pid_StockDetails_idx` (`pid`),
  KEY `FK_Sid_StockDetails_idx` (`sid`),
  CONSTRAINT `FK_Pid_StockDetails` FOREIGN KEY (`pid`) REFERENCES `products` (`prodid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Sid_StockDetails` FOREIGN KEY (`sid`) REFERENCES `sellers` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockdetails`
--

LOCK TABLES `stockdetails` WRITE;
/*!40000 ALTER TABLE `stockdetails` DISABLE KEYS */;
INSERT INTO `stockdetails` VALUES (1,1,1,1,'decrease','1 sold to customer'),(2,2,1,1,'decrease','1 sold'),(3,3,1,1,'decreased','1 sold'),(4,1,1,10,'increased','added to stock'),(5,1,2,1,'decreased','sold'),(6,2,2,2,'decreased','sold'),(7,9,2,5,'decreased','sold'),(8,2,3,15,'increased','added to stock'),(9,4,3,1,'decreased','sold to customer'),(10,5,3,1,'decreased','sold'),(11,7,1,5,'decreased','sold'),(12,5,1,1,'decreased','sold'),(13,8,1,3,'decreased','sold'),(14,7,1,8,'increased','added to stock');
/*!40000 ALTER TABLE `stockdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-13 17:49:17
