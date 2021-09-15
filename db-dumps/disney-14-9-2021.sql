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
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'/assets/images/1.png','Suspenso'),(2,'/assets/images/1.png','Terror'),(3,'/assets/images/1.png','Fantasia');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_serie`
--

DROP TABLE IF EXISTS `pelicula_serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_serie` (
  `id_pelicula_serie` int NOT NULL AUTO_INCREMENT,
  `calificacion` int DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pelicula_serie`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_serie`
--

LOCK TABLES `pelicula_serie` WRITE;
/*!40000 ALTER TABLE `pelicula_serie` DISABLE KEYS */;
INSERT INTO `pelicula_serie` VALUES (4,3,'2021-09-02 11:00:00.123000','assets/t.jpg','Leia'),(5,4,'2021-08-02 11:00:00.123000','assets/t.jpg','Kelly'),(6,2,'2020-01-02 11:00:00.123000','assets/t.jpg','Buscando a Nemo'),(8,5,'2020-01-02 11:00:00.123000','assets/t.jpg','El señor de los anillos'),(9,5,'2010-07-02 11:00:00.123000','assets/t.jpg','Harry Potter'),(10,5,'2010-07-02 11:00:00.123000','assets/t.jpg','Harry Potter'),(11,4,'2022-01-01 09:00:00.123000','assets/t.jpg','Matrix Resurrection');
/*!40000 ALTER TABLE `pelicula_serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculaserie_genero`
--

DROP TABLE IF EXISTS `peliculaserie_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculaserie_genero` (
  `id_pelicula_serie` int NOT NULL,
  `id_genero` int NOT NULL,
  PRIMARY KEY (`id_pelicula_serie`,`id_genero`),
  KEY `FKemvwhe16orx3aom0t2rrh73cb` (`id_genero`),
  CONSTRAINT `FKemvwhe16orx3aom0t2rrh73cb` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`),
  CONSTRAINT `FKi35thw5rgcjgy0ckg3gg5jfvl` FOREIGN KEY (`id_pelicula_serie`) REFERENCES `pelicula_serie` (`id_pelicula_serie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculaserie_genero`
--

LOCK TABLES `peliculaserie_genero` WRITE;
/*!40000 ALTER TABLE `peliculaserie_genero` DISABLE KEYS */;
INSERT INTO `peliculaserie_genero` VALUES (4,1),(8,1),(6,2),(5,3),(9,3),(10,3),(11,3);
/*!40000 ALTER TABLE `peliculaserie_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculaserie_personaje`
--

DROP TABLE IF EXISTS `peliculaserie_personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculaserie_personaje` (
  `id_pelicula_serie` int NOT NULL,
  `id_personaje` int NOT NULL,
  PRIMARY KEY (`id_pelicula_serie`,`id_personaje`),
  KEY `FKgdtdxkkcbnkbp50hwgtf0fs45` (`id_personaje`),
  CONSTRAINT `FKal2rnaet5mcfsefnxvfjmdtcs` FOREIGN KEY (`id_pelicula_serie`) REFERENCES `pelicula_serie` (`id_pelicula_serie`),
  CONSTRAINT `FKgdtdxkkcbnkbp50hwgtf0fs45` FOREIGN KEY (`id_personaje`) REFERENCES `personajes` (`id_personaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculaserie_personaje`
--

LOCK TABLES `peliculaserie_personaje` WRITE;
/*!40000 ALTER TABLE `peliculaserie_personaje` DISABLE KEYS */;
INSERT INTO `peliculaserie_personaje` VALUES (4,1),(6,1),(9,1),(10,1),(11,1),(5,2),(8,2);
/*!40000 ALTER TABLE `peliculaserie_personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes` (
  `id_personaje` int NOT NULL AUTO_INCREMENT,
  `edad` int DEFAULT NULL,
  `historia` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `peso` float DEFAULT NULL,
  PRIMARY KEY (`id_personaje`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (1,40,'algo.','/assets/imagenes/2.png','Bombi',43),(2,10,'algo.','/assets/imagenes/2.png',' Wan',43),(4,20,'algo.','/assets/imagenes/2.png','Sol',3),(5,11,'es un loro','/assets/imagenes/2.png','Luna',14);
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `clave` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (7,'karen123','maldonado.karen32@hotmail.com','Guzmán','Karen','kmaldonado'),(8,'Lucas123','lcarnero88@gmail.com','Guzmán','Lucas','lcarnero'),(9,'Lucas123','lcarnero88@gmail.com','Guzmán','Lucas','lcarnero');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-14 23:47:01
