-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2017 at 01:33 PM
-- Server version: 5.6.33-0ubuntu0.14.04.1
-- PHP Version: 5.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartHotel`
--
CREATE DATABASE IF NOT EXISTS `smartHotel` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `smartHotel`;

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--
-- Creation: Jan 05, 2017 at 01:31 PM
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id` bigint(20) NOT NULL,
  `name` text NOT NULL,
  `surname` text NOT NULL,
  `idnumber` text NOT NULL,
  `phone` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `title` text NOT NULL,
  `tempRooms` text
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `name`, `surname`, `idnumber`, `phone`, `email`, `password`, `title`, `tempRooms`) VALUES
(1, 'Stef', 'Kardasis', 'AE12345', '1124123123', 's@s.s', '123', 'Male', 'rooms1'),
(2, 'Math', 'Papoutsoglou', '123123', '12312', 'adasd', '123', 'Male', 'rooms2'),
(3, 'Stefanos', 'Kardasis', '41802', '6931234567', 'mymail', 'test123', 'Mr', 'rooms3'),
(4, 'Stefanos', 'Kardasis', '41802', '6931234567', 'mymail', 'test123', 'Mr', 'rooms4'),
(5, 'Mathew', 'Papoustoglou', '41802', '6931234567', 'mymail', 'test123', 'Mrs', 'rooms5'),
(6, 't', 't', 't', 't', 't', 't', 'Mr', 'rooms6'),
(7, '', '', '', '', '', '', 'Mr', 'rooms7'),
(8, 'Stefan', 'Kard', 'AE12345', '1234567890', 'a', '1', 'Mr', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `offers`
--
-- Creation: Jan 06, 2017 at 11:52 AM
--

DROP TABLE IF EXISTS `offers`;
CREATE TABLE IF NOT EXISTS `offers` (
  `id` bigint(20) NOT NULL,
  `title` text,
  `DiscFrom` text,
  `DiscTo` text,
  `discount` int(11) DEFAULT NULL,
  `category1` text,
  `category2` text,
  `category3` text
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `offers`
--

INSERT INTO `offers` (`id`, `title`, `DiscFrom`, `DiscTo`, `discount`, `category1`, `category2`, `category3`) VALUES
(1, 'Title', 'toso', 'mexritoso', 100, 'standard', 'none', 'suite'),
(2, 'New', '27', '26', 50, 'none', 'comfort', 'none'),
(3, 'New', '27', '26', 50, 'standard', 'comfort', 'none'),
(4, 't', 't', 't', 5, 'none', 'comfort', 'suite'),
(5, 't', 't', 't', 5, 'none', 'comfort', 'suite'),
(7, 't', 't', 't', 5, 'standard', 'comfort', 'suite'),
(8, 't', 't', 't', 5, 'standard', 'comfort', 'suite'),
(9, 't', 't', 't', 5, 'standard', 'comfort', 'suite');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--
-- Creation: Jan 05, 2017 at 07:05 PM
--

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` bigint(20) NOT NULL,
  `room` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `beds` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `singlebed` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `doublebed` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `category` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `discount` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `persons` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `datefrom` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `dateto` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `DiscFrom` text,
  `DiscTo` text,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `room`, `beds`, `singlebed`, `doublebed`, `category`, `name`, `discount`, `persons`, `datefrom`, `dateto`, `DiscFrom`, `DiscTo`, `price`) VALUES
(2, '101', '1', '0', '1', 'standard', 'name1', '10', '2', '01/01/2017', '07/01/2017', '15/07/2017', '18/07/2017', NULL),
(3, '102', '3', '2', '1', 'comfort', 'name2', '0', '4', '01/01/2017', '07/01/2017', '-', '-', NULL),
(4, '103', '1', '0', '1', 'suite', 'name3', '0', '2', '25/03/2018', '27/03/2018', '-', '-', NULL),
(5, '104', '1', '1', '0', 'suite', 'name4', '0', '1', '06/01/2017', '10/01/2017', '-', '-', NULL),
(6, '105', '1', '1', '0', 'suite', 'name5', '0', '1', '02/01/2017', '09/01/2017', '-', '-', NULL),
(9, '107', '4', '3', '1', 'suite', 'redsuite', '0', '5', '12/05/2017', '20/05/2017', '-', '-', 500),
(11, '200', '5', '2', '3', 'suite', 'extreme', '0', '8', '15/01/2017', '18/01/2017', '-', '-', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--
-- Creation: Dec 30, 2016 at 12:06 PM
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `name`) VALUES
(1, 'stefanos'),
(2, 'matthew'),
(3, 'hello'),
(4, 'hello'),
(5, 'hello');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `offers`
--
ALTER TABLE `offers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `offers`
--
ALTER TABLE `offers`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
