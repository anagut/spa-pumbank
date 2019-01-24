-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-12-2018 a las 15:50:16
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pumbank`
--
CREATE DATABASE IF NOT EXISTS `pumbank` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pumbank`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `congelarcuenta`
--

DROP TABLE IF EXISTS `congelarcuenta`;
CREATE TABLE `congelarcuenta` (
  `cid` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `padre` int(11) NOT NULL,
  `hijo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hijo`
--

DROP TABLE IF EXISTS `hijo`;
CREATE TABLE `hijo` (
  `hid` int(11) NOT NULL,
  `nombre` varchar(11) NOT NULL,
  `apellidos` varchar(64) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `password` varchar(11) NOT NULL,
  `email` varchar(56) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `padre`
--

DROP TABLE IF EXISTS `padre`;
CREATE TABLE `padre` (
  `pid` int(11) NOT NULL,
  `nombre` varchar(11) NOT NULL,
  `apellidos` varchar(64) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `email` varchar(56) NOT NULL,
  `password` varchar(11) NOT NULL,
  `tarjeta_credito` bigint(255) NOT NULL,
  `cvv` int(11) NOT NULL,
  `mes_caducidad` int(11) NOT NULL,
  `a_caducidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `padre_hijo_rel`
--

DROP TABLE IF EXISTS `padre_hijo_rel`;
CREATE TABLE `padre_hijo_rel` (
  `padre` int(11) NOT NULL,
  `hijo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paga`
--

DROP TABLE IF EXISTS `paga`;
CREATE TABLE `paga` (
  `pgid` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `frecuencia` int(11) NOT NULL,
  `padre` int(11) NOT NULL,
  `hijo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `congelarcuenta`
--
ALTER TABLE `congelarcuenta`
  ADD PRIMARY KEY (`cid`);

--
-- Indices de la tabla `hijo`
--
ALTER TABLE `hijo`
  ADD PRIMARY KEY (`hid`),
  ADD UNIQUE KEY `hid` (`hid`),
  ADD KEY `saldo` (`saldo`);

--
-- Indices de la tabla `padre`
--
ALTER TABLE `padre`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `pid` (`pid`);

--
-- Indices de la tabla `padre_hijo_rel`
--
ALTER TABLE `padre_hijo_rel`
  ADD UNIQUE KEY `hijo_2` (`hijo`),
  ADD KEY `padre` (`padre`),
  ADD KEY `hijo` (`hijo`);

--
-- Indices de la tabla `paga`
--
ALTER TABLE `paga`
  ADD PRIMARY KEY (`pgid`),
  ADD KEY `pgid` (`pgid`),
  ADD KEY `pid` (`padre`),
  ADD KEY `hid` (`hijo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `congelarcuenta`
--
ALTER TABLE `congelarcuenta`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `hijo`
--
ALTER TABLE `hijo`
  MODIFY `hid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `padre`
--
ALTER TABLE `padre`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `paga`
--
ALTER TABLE `paga`
  MODIFY `pgid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `padre_hijo_rel`
--
ALTER TABLE `padre_hijo_rel`
  ADD CONSTRAINT `hijo_rel` FOREIGN KEY (`hijo`) REFERENCES `hijo` (`hid`),
  ADD CONSTRAINT `padre_rel` FOREIGN KEY (`padre`) REFERENCES `padre` (`pid`);

--
-- Filtros para la tabla `paga`
--
ALTER TABLE `paga`
  ADD CONSTRAINT `padre_paga` FOREIGN KEY (`padre`) REFERENCES `padre` (`pid`),
  ADD CONSTRAINT `paga_hijo` FOREIGN KEY (`hijo`) REFERENCES `hijo` (`hid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
