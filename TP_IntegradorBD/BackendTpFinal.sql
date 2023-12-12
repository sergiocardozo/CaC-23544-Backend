-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.1.0 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para final_cac
CREATE DATABASE IF NOT EXISTS `final_cac` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `final_cac`;

-- Volcando estructura para tabla final_cac.hora_turno
CREATE TABLE IF NOT EXISTS `hora_turno` (
  `id_hora` int NOT NULL AUTO_INCREMENT,
  `nombre_hora` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_hora`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla final_cac.hora_turno: ~11 rows (aproximadamente)
INSERT INTO `hora_turno` (`id_hora`, `nombre_hora`) VALUES
	(1, '08:00 AM'),
	(2, '09:00 AM'),
	(3, '10:00 AM'),
	(4, '11:00 AM'),
	(5, '12:00 PM'),
	(6, '13:00 PM'),
	(7, '14:00 PM'),
	(8, '15:00 PM'),
	(9, '16:00 PM'),
	(10, '17:00 PM'),
	(11, '18:00 PM');

-- Volcando estructura para tabla final_cac.turnos
CREATE TABLE IF NOT EXISTS `turnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `mail` varchar(25) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_turno` datetime NOT NULL,
  `id_hora` int NOT NULL,
  `tipo_corte` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `fecha_alta` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail` (`mail`),
  KEY `FK_hora` (`id_hora`),
  CONSTRAINT `FK_hora` FOREIGN KEY (`id_hora`) REFERENCES `hora_turno` (`id_hora`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla final_cac.turnos: ~5 rows (aproximadamente)
INSERT INTO `turnos` (`id`, `nombre`, `apellido`, `mail`, `fecha_turno`, `id_hora`, `tipo_corte`, `fecha_alta`) VALUES
	(16, 'sergio', 'card', 'asdsa@gmai', '2023-12-14 00:00:00', 4, 'Barba', '2023-12-13 13:14:40'),
	(17, 'asd', 'asds', 'asdsad@gmail', '2023-12-21 00:00:00', 1, 'Barba', '2023-12-13 13:19:50'),
	(28, 'sergio', 'card', 'asdsad@gmail.coms', '2023-12-13 00:00:00', 11, 'Corte', '2023-12-13 13:34:43'),
	(29, 'sergio', 'cardozo', 'asdsa@gmaiasd', '2023-12-15 00:00:00', 4, 'Barba', '2023-12-11 03:18:02'),
	(31, 'sergio', 'card', 'asdsad@gmail.coma', '2023-12-15 00:00:00', 2, 'Barba', '2023-12-11 18:03:28'),
	(33, 'asd', 'card', 'asdsa@gmais', '2023-12-13 00:00:00', 7, 'Corte', '2023-12-11 19:19:58'),
	(34, 'sergio', 'sa', 'saas@g', '2023-12-12 00:00:00', 1, 'Corte', '2023-12-11 19:25:40'),
	(35, 'asd', 'asd', 'asdas@bg', '2023-12-12 00:00:00', 2, 'Afeitado Italiano', '2023-12-11 19:26:11'),
	(37, 'Ser', 'Cardoz', 'scardozo.sc@hotmail.com', '2023-12-12 00:00:00', 4, 'Corte', '2023-12-12 02:58:48');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
