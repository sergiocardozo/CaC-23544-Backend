-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2023 a las 02:26:13
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `integrador_cac`
--
CREATE DATABASE IF NOT EXISTS `integrador_cac` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `integrador_cac`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oradores`
--

CREATE TABLE `oradores` (
  `id_oradores` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `mail` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `tema` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `fecha_alta` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `oradores`
--

INSERT INTO `oradores` (`id_oradores`, `nombre`, `apellido`, `mail`, `tema`, `fecha_alta`) VALUES
(1, 'Sergio', 'Cardozo', 'scardozo.sc@gmail.com', 'PHP', '2023-11-12 01:16:35'),
(2, 'Juan', 'Pedro', 'correo2@gmail.com', 'Java', '2023-11-12 01:16:35'),
(3, 'Esteban', 'Juarez', 'correo3@gmail.com', 'Ciberseguridad', '2023-11-12 01:16:35'),
(4, 'Jane', 'Doe', 'correo4@gmail.com', '.Net', '2023-11-12 01:16:35'),
(5, 'Natalia', 'Natalia', 'correo5@gmail.com', 'Vue', '2023-11-12 01:16:35'),
(6, 'Roberto', 'Gimenez', 'correo6@gmail.com', 'Angular', '2023-11-12 01:16:35'),
(7, 'Agustin', 'Cardozo', 'correo7@gmail.com', 'Javascript', '2023-11-12 01:16:35'),
(8, 'Esteban', 'Jimenez', 'correo8@gmail.com', 'Phyton', '2023-11-12 01:16:35'),
(9, 'Carlos', 'Romero', 'correo9@gmail.com', 'React', '2023-11-12 01:16:35'),
(10, 'Cristian', 'Kraft', 'correo10@gmail.com', 'Java', '2023-11-12 01:16:35');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `oradores`
--
ALTER TABLE `oradores`
  ADD PRIMARY KEY (`id_oradores`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `oradores`
--
ALTER TABLE `oradores`
  MODIFY `id_oradores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
