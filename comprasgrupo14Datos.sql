-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 30-10-2023 a las 19:19:09
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `comprasgrupo14`
--
CREATE DATABASE IF NOT EXISTS `comprasgrupo14` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `comprasgrupo14`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idCompra`, `idProveedor`, `fecha`) VALUES
(1, 1, '2023-10-16'),
(2, 2, '2023-10-16'),
(3, 3, '2023-10-17'),
(4, 3, '2023-10-17'),
(5, 13, '2023-10-17'),
(6, 11, '2023-10-18'),
(7, 8, '2023-10-18'),
(8, 14, '2023-10-18'),
(9, 10, '2023-10-19'),
(10, 8, '2023-10-19'),
(11, 6, '2023-10-19'),
(12, 13, '2023-10-19'),
(13, 6, '2023-10-20'),
(14, 10, '2023-10-23'),
(15, 12, '2023-10-23'),
(16, 6, '2023-10-23'),
(17, 11, '2023-10-24'),
(69, 2, '2023-10-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompra`
--

DROP TABLE IF EXISTS `detallecompra`;
CREATE TABLE `detallecompra` (
  `idDetalle` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioCosto` double NOT NULL,
  `idCompra` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallecompra`
--

INSERT INTO `detallecompra` (`idDetalle`, `cantidad`, `precioCosto`, `idCompra`, `idProducto`) VALUES
(1, 2, 120000, 1, 2),
(2, 5, 200000, 1, 1),
(3, 6, 70000, 1, 4),
(4, 9, 500000, 2, 7),
(5, 10, 90000, 2, 8),
(6, 26, 320000, 3, 3),
(7, 4, 85000, 4, 14),
(8, 90, 150000, 5, 16),
(9, 34, 1000000, 5, 19),
(10, 3, 110000, 6, 5),
(11, 25, 360000, 6, 1),
(12, 7, 375000, 7, 4),
(13, 2, 23000.95, 8, 15),
(14, 4, 450000, 9, 4),
(15, 4, 100000, 10, 17),
(16, 2, 200000, 11, 12),
(17, 3, 350000, 11, 5),
(18, 24, 450000, 12, 7),
(19, 10, 1420000, 13, 20),
(20, 11, 173000, 14, 8),
(21, 4, 140000, 15, 6),
(22, 10, 155000, 16, 15),
(23, 6, 1700000, 17, 11),
(92, 2, 2100000, 69, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(30) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `precioActual` double NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `descripcion`, `precioActual`, `stock`, `estado`) VALUES
(1, 'Heladera', 'Patrick, 300 L ', 3000000, 3, 1),
(2, 'Aire Acondicionado', '5000 F', 200000, 1, 1),
(3, 'Calefactor', '220', 200000, 20, 1),
(4, 'Televisor ', 'LG 42\"', 1600000, 10, 0),
(5, 'Plancha', 'LG', 300000, 6, 1),
(6, 'Aspiradora', 'Inalambrica', 45000, 1, 1),
(7, 'Cocina ', 'Industrial 6H', 2000000, 23, 1),
(8, 'microondas', 'LG', 1520000, 6, 0),
(9, 'Televisor', 'Sony 4k', 300000, 0, 0),
(10, 'Aire Acondicionado', '4000 f', 1222, 18, 1),
(11, 'Heladera', 'No Frost, 200 L', 200000, 26, 1),
(12, 'Licuadora', 'Moulinex', 50000, 1, 1),
(13, 'Aspiradora', 'Daewo', 12369, 3, 0),
(14, 'Estabilizador', 'DRT', 12222, 8, 1),
(15, 'Batidora', 'LG', 300000, 14, 1),
(16, 'Cafetera', 'Electrica', 90000, 6, 1),
(17, 'Aire Acondicionado', '2000 F', 5536.2, 9, 1),
(18, 'Tostadora', 'No Frost, 200 L', 200000, 26, 0),
(19, 'Seca Ropa', 'Carga frontal', 20000, 8, 1),
(20, 'Lavadora', 'Carga superior', 500000, 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `razonSocial` varchar(30) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `razonSocial`, `domicilio`, `telefono`, `estado`) VALUES
(1, 'Macros Y', 'Villa Maria 400', '1111111', 0),
(2, 'MultiElecrtro', 'Marquez 5896', '74212931', 1),
(3, 'Caminos', 'Vicente Lopez 1236', '95368531', 0),
(4, 'MarAsociados', 'Mali 8536', '85163', 1),
(5, 'MultiVenta', 'Salamanca 1230', '128513', 1),
(6, 'Misu', 'Malaspina 1478', '9536472', 1),
(7, 'Danun', 'Milagros 9632', '85217', 1),
(8, 'Miraflores', 'Villa Maria 785', '112000', 1),
(9, 'MarcoPolo', 'Lopez ', '25968', 1),
(10, 'Milagro', 'Juanes 555', '2222', 1),
(11, 'MarAzul', 'Nuñez 1700', '12365489', 0),
(12, 'Campeche', 'Jatchal 569', '1220692', 0),
(13, 'Manila', 'Rume 789', '785213956', 1),
(14, 'MariaJuana Electrodomesticos', 'MAr Azul 4569', '12365482', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `idProveedor` (`idProveedor`);

--
-- Indices de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `idCompra` (`idCompra`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`);

--
-- Filtros para la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD CONSTRAINT `detallecompra_ibfk_1` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `detallecompra_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
