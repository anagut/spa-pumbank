-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
<<<<<<< HEAD
-- Tiempo de generación: 29-11-2018 a las 13:39:43
=======
-- Tiempo de generación: 30-11-2018 a las 09:26:32
>>>>>>> 9cdca97eca53082ea4dcfab2e29f0ecf9b4db636
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
<<<<<<< HEAD
=======
CREATE DATABASE IF NOT EXISTS `pumbank` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pumbank`;

>>>>>>> 9cdca97eca53082ea4dcfab2e29f0ecf9b4db636

--
-- Volcado de datos para la tabla `hijo`
--

<<<<<<< HEAD
INSERT INTO `hijo` (`hid`, `nombre`, `apellidos`, `fecha_nacimiento`, `password`, `email`, `saldo`, `paga`, `congelar`) VALUES
(1, 'Ricardo Jr', 'Rodríguez', '2005-06-17', 'rrrr', 'rjr@r.es', 105.6, 1, NULL),
(2, 'Leticia', 'Rodríguez', '2006-05-25', 'llll', 'l@l.es', 45.7, 6, NULL),
(3, 'Emo', 'Rodríguez', '2004-12-06', 'eeee', 'e@e.es', 123.9, 7, NULL),
(4, 'Rosario', 'García', '2003-03-23', 'rrrr', 'ro@ro.es', 89.5, 2, NULL),
(5, 'Sasha', 'García', '2005-07-18', 'ssss', 's@s.es', 36.4, 8, NULL),
(6, 'Lenin', 'Asimov', '2006-11-11', 'llll', 'le@le.es', 83.1, 3, NULL);
=======
INSERT INTO `hijo` (`hid`, `nombre`, `apellidos`, `fecha_nacimiento`, `password`, `email`, `saldo`) VALUES
(1, 'Ricardo Jr', 'Rodríguez', '2005-06-17', 'rrrr', 'rjr@r.es', 105.6),
(2, 'Leticia', 'Rodríguez', '2006-05-25', 'llll', 'l@l.es', 45.7),
(3, 'Emo', 'Rodríguez', '2004-12-06', 'eeee', 'e@e.es', 123.9),
(4, 'Rosario', 'García', '2003-03-23', 'rrrr', 'ro@ro.es', 89.5),
(5, 'Sasha', 'García', '2005-07-18', 'ssss', 's@s.es', 36.4),
(6, 'Lenin', 'Asimov', '2006-11-11', 'llll', 'le@le.es', 83.1);
>>>>>>> 9cdca97eca53082ea4dcfab2e29f0ecf9b4db636

--
-- Volcado de datos para la tabla `padre`
--

<<<<<<< HEAD
INSERT INTO `padre` (`pid`, `nombre`, `apellidos`, `fecha_nacimiento`, `email`, `password`, `tarjeta_credito`, `cvv`, `fecha_caducidad`) VALUES
(1, 'Ricardo', 'Rodríguez', '1980-09-03', 'r@r.es', 'rrrr', 4123456748904123, 333, '2019-01-01'),
(2, 'Gertrudis', 'García', '1960-11-20', 'g@g.es', 'gggg', 4123456748904123, 666, '2019-03-03'),
(3, 'Mykola', 'Asimov', '1989-02-01', 'm@m.es', 'mmmm', 4123456748904123, 777, '2020-02-20');
=======
INSERT INTO `padre` (`pid`, `nombre`, `apellidos`, `fecha_nacimiento`, `email`, `password`, `tarjeta_credito`, `cvv`, `fecha_caducidad`, `contraseña`) VALUES
(1, 'Ricardo', 'Rodríguez', '1980-09-03', 'r@r.es', 'rrrr', 4123456748904123, 333, '2019-01-01', NULL),
(2, 'Gertrudis', 'García', '1960-11-20', 'g@g.es', 'gggg', 4123456748904123, 666, '2019-03-03', NULL),
(3, 'Mykola', 'Asimov', '1989-02-01', 'm@m.es', 'mmmm', 4123456748904123, 777, '2020-02-20', NULL);

--
-- Volcado de datos para la tabla `congelarcuenta`
--

INSERT INTO `congelarcuenta` (`cid`, `fecha_inicio`, `fecha_fin`, `activar`, `padre`, `hijo`) VALUES
(1, '2018-12-05', '2018-12-12', 0, 1, 3);
>>>>>>> 9cdca97eca53082ea4dcfab2e29f0ecf9b4db636

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
-- Volcado de datos para la tabla `paga`
--

<<<<<<< HEAD
INSERT INTO `paga` (`pgid`, `cantidad`, `frecuencia`) VALUES
(1, 20, 15),
(2, 10, 7),
(3, 50, 30),
(6, 20, 15),
(7, 20, 15),
(8, 10, 7);

--
-- Volcado de datos para la tabla `padre_paga_rel`
--

INSERT INTO `padre_paga_rel` (`padre`, `paga`) VALUES
(1, 1),
(1, 6),
(1, 7),
(2, 2),
(2, 8),
(3, 3);


=======
INSERT INTO `paga` (`pgid`, `cantidad`, `frecuencia`, `padre`, `hijo`) VALUES
(9, 20, 15, 1, 1),
(10, 25, 15, 1, 2),
(11, 15, 15, 1, 3),
(12, 15, 7, 2, 4),
(13, 20, 7, 2, 5),
(14, 50, 30, 3, 6);
>>>>>>> 9cdca97eca53082ea4dcfab2e29f0ecf9b4db636

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
