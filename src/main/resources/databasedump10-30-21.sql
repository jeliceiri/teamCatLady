-- MySQL dump 10.13  Distrib 8.0.26, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: teamcatlady
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `presidents`
--

DROP TABLE IF EXISTS `presidents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presidents` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `number` int NOT NULL,
                              `president` varchar(22) NOT NULL,
                              `birth_year` int NOT NULL,
                              `death_year` int DEFAULT NULL,
                              `took_office` varchar(10) NOT NULL,
                              `left_office` varchar(10) DEFAULT NULL,
                              `party` varchar(21) NOT NULL,
                              PRIMARY KEY (`id`)
                              UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presidents`
--

LOCK TABLES `presidents` WRITE;
/*!40000 ALTER TABLE `presidents` DISABLE KEYS */;
INSERT INTO `presidents` (`number`, `president`, `birth_year`, `death_year`, `took_office`, `left_office`, `party`) VALUES (1,'George Washington',1732,1799,'1789-04-30','1797-03-04','No Party'),(2,'John Adams',1735,1826,'1797-03-04','1801-03-04','Federalist'),(3,'Thomas Jefferson',1743,1826,'1801-03-04','1809-03-04','Democratic-Republican'),(4,'James Madison',1751,1836,'1809-03-04','1817-03-04','Democratic-Republican'),(5,'James Monroe',1758,1831,'1817-03-04','1825-03-04','Democratic-Republican'),(6,'John Quincy Adams',1767,1848,'1825-03-04','1829-03-04','Democratic-Republican'),(7,'Andrew Jackson',1767,1845,'1829-03-04','1837-03-04','Democratic'),(8,'Martin Van Buren',1782,1862,'1837-03-04','1841-03-04','Democratic'),(9,'William Henry Harrison',1773,1841,'1841-03-04','1841-04-04','Whig'),(10,'John Tyler',1790,1862,'1841-04-04','1845-03-04','Whig'),(11,'James K. Polk',1795,1849,'1845-03-04','1849-03-04','Democratic'),(12,'Zachary Taylor',1784,1850,'1849-03-04','1850-07-09','Whig'),(13,'Millard Fillmore',1800,1874,'1850-07-09','1853-03-04','Whig'),(14,'Franklin Pierce',1804,1869,'1853-03-04','1857-03-04','Democratic'),(15,'James Buchanan',1791,1868,'1857-03-04','1861-03-04','Democratic'),(16,'Abraham Lincoln',1809,1865,'1861-03-04','1865-04-15','Republican'),(17,'Andrew Johnson',1808,1875,'1865-04-15','1869-03-04','Democratic'),(18,'Ulysses S. Grant',1822,1885,'1869-03-04','1877-03-04','Republican'),(19,'Rutherford B. Hayes',1822,1893,'1877-03-04','1881-03-04','Republican'),(20,'James A. Garfield',1831,1881,'1881-03-04','1881-09-19','Republican'),(21,'Chester A. Arthur',1829,1886,'1881-09-19','1885-03-04','Republican'),(22,'Grover Cleveland',1837,1908,'1885-03-04','1889-03-04','Democratic'),(23,'Benjamin Harrison',1833,1901,'1889-03-04','1893-03-04','Republican'),(24,'Grover Cleveland',1837,1908,'1893-03-04','1897-03-04','Democratic'),(25,'William McKinley',1843,1901,'1897-03-04','1901-09-14','Republican'),(26,'Theodore Roosevelt',1858,1919,'1901-09-14','1909-03-04','Republican'),(27,'William Howard Taft',1857,1930,'1909-03-04','1913-03-04','Republican'),(28,'Woodrow Wilson',1856,1924,'1913-03-04','1921-03-04','Democratic'),(29,'Warren G. Harding',1865,1923,'1921-03-04','1923-08-02','Republican'),(30,'Calvin Coolidge',1872,1933,'1923-08-02','1929-03-04','Republican'),(31,'Herbert Hoover',1874,1964,'1929-03-04','1933-03-04','Republican'),(32,'Franklin D. Roosevelt',1882,1945,'1933-03-04','1945-04-12','Democratic'),(33,'Harry S. Truman',1884,1972,'1945-04-12','1953-01-20','Democratic'),(34,'Dwight D. Eisenhower',1890,1969,'1953-01-20','1961-01-20','Republican'),(35,'John F. Kennedy',1917,1963,'1961-01-20','1963-11-22','Democratic'),(36,'Lyndon B. Johnson',1908,1973,'1963-11-22','1969-01-20','Democratic'),(37,'Richard Nixon',1913,1994,'1969-01-20','1974-08-09','Republican'),(38,'Gerald Ford',1913,2006,'1974-08-09','1977-01-20','Republican'),(39,'Jimmy Carter',1924,NULL,'1977-01-20','1981-01-20','Democratic'),(40,'Ronald Reagan',1911,2004,'1981-01-20','1989-01-20','Republican'),(41,'George H. W. Bush',1924,2018,'1989-01-20','1993-01-20','Republican'),(42,'Bill Clinton',1946,NULL,'1993-01-20','2001-01-20','Democratic'),(43,'George W. Bush',1946,NULL,'2001-01-20','2009-01-20','Republican'),(44,'Barack Obama',1961,NULL,'2009-01-20','2017-01-20','Democratic'),(45,'Donald J. Trump',1946,NULL,'2017-01-20','2021-01-20','Republican'),(46,'Joseph \'Joe\' Biden',1942,NULL,'2021-01-20',NULL,'Democratic');
/*!40000 ALTER TABLE `presidents` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-30  8:07:13
