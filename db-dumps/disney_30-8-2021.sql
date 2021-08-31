-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: disney
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
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id_genero` int NOT NULL AUTO_INCREMENT,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `pelicula_serie` int DEFAULT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'assets/imagenes/genero-terror.jpg','Terror',2);
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_serie`
--

DROP TABLE IF EXISTS `pelicula_serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_serie` (
  `imagen` varchar(100) DEFAULT NULL,
  `id_pelicula_serie` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `calificacion` int DEFAULT NULL,
  `personajes_asociados` int DEFAULT NULL,
  PRIMARY KEY (`id_pelicula_serie`),
  KEY `pelicula_o_serie_FK` (`personajes_asociados`),
  CONSTRAINT `pelicula_o_serie_FK` FOREIGN KEY (`personajes_asociados`) REFERENCES `personajes` (`id_personaje`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_serie`
--

LOCK TABLES `pelicula_serie` WRITE;
/*!40000 ALTER TABLE `pelicula_serie` DISABLE KEYS */;
INSERT INTO `pelicula_serie` VALUES ('assets/imagenes/pelicula-forest.jpg',2,'Forest Gump','2021-09-02',10,1);
/*!40000 ALTER TABLE `pelicula_serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_serie_genero`
--

DROP TABLE IF EXISTS `pelicula_serie_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_serie_genero` (
  `pelicula_serie_id` int NOT NULL,
  `id_genero` int NOT NULL,
  PRIMARY KEY (`pelicula_serie_id`,`id_genero`),
  KEY `FK304x5yyf733urf1jcmkhsb5ui` (`id_genero`),
  CONSTRAINT `FK304x5yyf733urf1jcmkhsb5ui` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`),
  CONSTRAINT `FK9tbl4co5cmu1o2lkv47bc7b3j` FOREIGN KEY (`pelicula_serie_id`) REFERENCES `pelicula_serie` (`id_pelicula_serie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_serie_genero`
--

LOCK TABLES `pelicula_serie_genero` WRITE;
/*!40000 ALTER TABLE `pelicula_serie_genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `pelicula_serie_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_serie_personaje`
--

DROP TABLE IF EXISTS `pelicula_serie_personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_serie_personaje` (
  `pelicula_serie_id` int NOT NULL,
  `personaje_id` int NOT NULL,
  PRIMARY KEY (`pelicula_serie_id`,`personaje_id`),
  KEY `FKb1panjhl7c8e5qenxf12giveh` (`personaje_id`),
  CONSTRAINT `FK4fj5hhhhv8j3hlwvrxsipyvqv` FOREIGN KEY (`pelicula_serie_id`) REFERENCES `pelicula_serie` (`id_pelicula_serie`),
  CONSTRAINT `FKb1panjhl7c8e5qenxf12giveh` FOREIGN KEY (`personaje_id`) REFERENCES `personajes` (`id_personaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_serie_personaje`
--

LOCK TABLES `pelicula_serie_personaje` WRITE;
/*!40000 ALTER TABLE `pelicula_serie_personaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `pelicula_serie_personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes` (
  `nombre` varchar(100) DEFAULT NULL,
  `id_personaje` int NOT NULL AUTO_INCREMENT,
  `imagen` varchar(100) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `historia` varchar(100) DEFAULT NULL,
  `pelicula_serie` int DEFAULT NULL,
  PRIMARY KEY (`id_personaje`),
  KEY `personajes_FK` (`pelicula_serie`),
  CONSTRAINT `personajes_FK` FOREIGN KEY (`pelicula_serie`) REFERENCES `pelicula_serie` (`id_pelicula_serie`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES ('Forest Gump',1,'assets/imagenes/personaje-forest.jpg',40,15.6,'Es el personaje principal de la movie',NULL);
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-30 21:16:36
