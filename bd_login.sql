-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_sistema_login
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleventa` (
  `iddetalleVenta` int NOT NULL,
  `idVenta` int DEFAULT NULL,
  `idProducto` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precioUnitario` decimal(10,2) DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `detalleVentaCol` varchar(45) DEFAULT NULL,
  `subTotal` decimal(10,2) DEFAULT NULL,
  `IVA` decimal(10,2) DEFAULT NULL,
  `idLogin` int DEFAULT NULL,
  PRIMARY KEY (`iddetalleVenta`),
  KEY `idVenta` (`idVenta`),
  KEY `idProducto` (`idProducto`),
  KEY `idLogin` (`idLogin`),
  CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idventa`),
  CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idproductos`),
  CONSTRAINT `detalleventa_ibfk_3` FOREIGN KEY (`idLogin`) REFERENCES `login` (`idLogin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `idLogin` int NOT NULL AUTO_INCREMENT,
  `nombreLogin` varchar(45) DEFAULT NULL,
  `passwordLogin` varchar(256) DEFAULT NULL,
  `fechaCreacionLogin` date DEFAULT NULL,
  `estatusLogin` tinyint DEFAULT NULL,
  `idUsuario` int DEFAULT NULL,
  `idRolUsuario` int DEFAULT NULL,
  PRIMARY KEY (`idLogin`),
  KEY `fk_usuario_login_idx` (`idUsuario`),
  KEY `fk_rolusuario_login_idx` (`idRolUsuario`),
  CONSTRAINT `fk_rolusuario_login` FOREIGN KEY (`idRolUsuario`) REFERENCES `rolusuario` (`idrolUsuario`),
  CONSTRAINT `fk_usuario_login` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'ajm','123','2025-06-27',1,1,1),(2,'tnl','1234','2025-06-27',1,2,2);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idproductos` int NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idproductos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Gomitas','Gomitas de frutas rellenas de miel','5',17.00),(2,'Galletas','de chocolate','5',19.00),(3,'Sabritas','Papas adobadas','10',19.00);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolusuario`
--

DROP TABLE IF EXISTS `rolusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rolusuario` (
  `idrolUsuario` int NOT NULL AUTO_INCREMENT,
  `tipoRolUsuario` varchar(45) DEFAULT NULL,
  `descripcionRolUsuario` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idrolUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolusuario`
--

LOCK TABLES `rolusuario` WRITE;
/*!40000 ALTER TABLE `rolusuario` DISABLE KEYS */;
INSERT INTO `rolusuario` VALUES (1,'ADMIN','tiene todos los permisos'),(2,'cliente','tiene permisos de agregar y consultar'),(3,'invitado','tiene permisos de consultar'),(4,'invitado','lo tiene todo'),(5,'cliente','TIENE PERMISOS DE AGREGAR'),(6,'admin','´poihghnmlñ');
/*!40000 ALTER TABLE `rolusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `apPaterno` varchar(45) DEFAULT NULL,
  `apMaterno` varchar(45) DEFAULT NULL,
  `emailUsuario` varchar(45) DEFAULT NULL,
  `telCelularUsuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Alfredo','Juan','Moroni','24300632@uttt.edu.mx','7731075199'),(2,'Tania','Nuñez','Laguna','24300655@uttt.edu.mx','7731256895'),(5,'Kevin','Gonzles','Valdez','24300678@uttt.edu.mx','7731191116'),(8,'Julio Eduardo ','Angeles','Diaz','24300897@uttt.edu.mx','7731800840'),(11,'Ivan','Ramirez','Lopez','25365845@uttt.edu.mx','7735624581'),(12,'Pablo','Gil','Lopez','24300686@uttt.edu.mx','7731237720');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `idventa` int NOT NULL,
  `fechaVenta` date DEFAULT NULL,
  `metodoDePago` varchar(20) DEFAULT NULL,
  `estatus` varchar(20) DEFAULT NULL,
  `estadoDeVenta` varchar(45) DEFAULT NULL,
  `totalDeVenta` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (0,'2025-08-11','Efec','conf','cerra',80.00);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-13 10:18:32
