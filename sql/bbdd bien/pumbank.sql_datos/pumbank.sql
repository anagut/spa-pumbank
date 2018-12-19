-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-12-2018 a las 15:55:56
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

--
-- Volcado de datos para la tabla `hijo`
--

INSERT INTO `hijo` (`hid`, `nombre`, `apellidos`, `fecha_nacimiento`, `password`, `email`, `saldo`) VALUES
(1, 'Ricardo Jr', 'Rodríguez', '2005-06-17', 'rrrr', 'rjr@r.es', 70.6),
(2, 'Leticia', 'Rodríguez', '2006-05-25', 'llll', 'l@l.es', 45.7),
(3, 'Emo', 'Rodríguez', '2004-12-06', 'eeee', 'e@e.es', 123.9),
(4, 'Rosario', 'García', '2003-03-23', 'rrrr', 'ro@ro.es', 89.5),
(5, 'Sasha', 'García', '2005-07-18', 'ssss', 's@s.es', 36.4),
(6, 'Lenin', 'Asimov', '2006-11-11', 'llll', 'le@le.es', 83.1);

--
-- Volcado de datos para la tabla `padre`
--

INSERT INTO `padre` (`pid`, `nombre`, `apellidos`, `fecha_nacimiento`, `email`, `password`, `tarjeta_credito`, `cvv`, `mes_caducidad`, `a_caducidad`) VALUES
(1, 'Ricardo', 'Rodríguez', '1980-09-03', 'r@r.es', 'rrrr', 4123456748904123, 333, 12, 2019),
(2, 'Gertrudis', 'García', '1960-11-20', 'g@g.es', 'gggg', 4123456748904123, 666, 12, 2019),
(3, 'Mykola', 'Asimov', '1989-02-01', 'm@m.es', 'mmmm', 4123456748904123, 777, 12, 2019);

--
-- Volcado de datos para la tabla `padre_hijo_rel`
--

INSERT INTO `padre_hijo_rel` (`padre`, `hijo`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6);

--
-- Volcado de datos para la tabla `congelarcuenta`
--

INSERT INTO `congelarcuenta` (`cid`, `fecha_inicio`, `fecha_fin`, `padre`, `hijo`) VALUES
(1, '2018-12-05', '2018-12-19', 1, 1);

--
-- Volcado de datos para la tabla `paga`
--

INSERT INTO `paga` (`pgid`, `cantidad`, `frecuencia`, `padre`, `hijo`) VALUES
(1, 30, 15, 1, 1),
(3, 15, 15, 1, 3),
(4, 15, 7, 2, 4),
(5, 20, 7, 2, 5),
(6, 50, 30, 3, 6);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
