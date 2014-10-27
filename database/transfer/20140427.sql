-- phpMyAdmin SQL Dump
-- version 3.5.8.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 27, 2014 at 09:55 PM
-- Server version: 5.5.34-0ubuntu0.13.04.1
-- PHP Version: 5.4.9-4ubuntu2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `1541215_android`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int(15) NOT NULL AUTO_INCREMENT,
  `house_no` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `address_line1` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `address_line2` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `city` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `state` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `pin` int(10) DEFAULT NULL,
  `country` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=26 ;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`address_id`, `house_no`, `address_line1`, `address_line2`, `city`, `state`, `pin`, `country`, `person_id`) VALUES
(1, 'a', NULL, NULL, NULL, NULL, NULL, NULL, 1),
(2, 'b', NULL, NULL, NULL, NULL, NULL, NULL, 2),
(3, 'c', NULL, NULL, NULL, NULL, NULL, NULL, 3),
(4, 'd', NULL, NULL, NULL, NULL, NULL, NULL, 4),
(5, 'e', NULL, NULL, NULL, NULL, NULL, NULL, 5),
(6, 'ff', NULL, NULL, NULL, NULL, NULL, NULL, 6),
(7, 'g', NULL, NULL, NULL, NULL, NULL, NULL, 7),
(8, 'h', NULL, NULL, NULL, NULL, NULL, NULL, 8),
(9, 'i', NULL, NULL, NULL, NULL, NULL, NULL, 9),
(10, 'j', NULL, NULL, NULL, NULL, NULL, NULL, 10),
(11, 'suryansh', NULL, NULL, NULL, NULL, NULL, NULL, 11),
(12, 'imt', NULL, NULL, NULL, NULL, NULL, NULL, 12),
(13, 'surya', NULL, NULL, NULL, NULL, NULL, NULL, 13),
(14, 'Gsgs hd sn', NULL, NULL, NULL, NULL, NULL, NULL, 14),
(15, 'Cfj of choc', NULL, NULL, NULL, NULL, NULL, NULL, 15),
(16, 'sadashiv peth pune', NULL, NULL, NULL, NULL, NULL, NULL, 16),
(17, 'asdfghjkl', NULL, NULL, NULL, NULL, NULL, NULL, 17),
(18, 'wetyip', NULL, NULL, NULL, NULL, NULL, NULL, 18),
(19, 'yv', NULL, NULL, NULL, NULL, NULL, NULL, 19),
(20, 'yv', NULL, NULL, NULL, NULL, NULL, NULL, 20),
(21, 'sadashiv peth pune', NULL, NULL, NULL, NULL, NULL, NULL, 21),
(22, 'abc', NULL, NULL, NULL, NULL, NULL, NULL, 22),
(23, '', NULL, NULL, NULL, NULL, NULL, NULL, 23),
(24, '', NULL, NULL, NULL, NULL, NULL, NULL, 24),
(25, 'Ranka Hospitals Pune', NULL, NULL, NULL, NULL, NULL, NULL, 25);

-- --------------------------------------------------------

--
-- Table structure for table `disease`
--

DROP TABLE IF EXISTS `disease`;
CREATE TABLE IF NOT EXISTS `disease` (
  `disease_id` int(11) NOT NULL AUTO_INCREMENT,
  `history_id` int(11) NOT NULL,
  `disease` varchar(100) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`disease_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `disease`
--

INSERT INTO `disease` (`disease_id`, `history_id`, `disease`) VALUES
(1, 11, 'AIDS'),
(2, 11, 'HIV'),
(3, 11, 'more aids'),
(4, 11, 'more more aids'),
(5, 11, 'last disease'),
(6, 11, 'swear'),
(7, 11, 'debug'),
(8, 11, 'debug2'),
(9, 11, 'awesome'),
(10, 11, 'cool'),
(11, 26, 'Food Poisoning');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `specialization_id` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=15 ;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctor_id`, `person_id`, `specialization_id`) VALUES
(1, 1, NULL),
(2, 3, NULL),
(3, 5, NULL),
(4, 6, NULL),
(5, 7, NULL),
(6, 8, NULL),
(7, 9, NULL),
(8, 10, NULL),
(9, 11, NULL),
(10, 14, NULL),
(11, 16, NULL),
(12, 18, NULL),
(13, 23, NULL),
(14, 25, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `doc_data`
--

DROP TABLE IF EXISTS `doc_data`;
CREATE TABLE IF NOT EXISTS `doc_data` (
  `doc_data_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `specialization_id` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`doc_data_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
CREATE TABLE IF NOT EXISTS `medicine` (
  `medicine_data_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_id` int(11) NOT NULL,
  `history_id` int(11) NOT NULL,
  `morning` set('Y','N') COLLATE latin1_general_ci NOT NULL DEFAULT 'N',
  `afternoon` set('Y','N') COLLATE latin1_general_ci NOT NULL DEFAULT 'N',
  `evening` set('Y','N') COLLATE latin1_general_ci NOT NULL DEFAULT 'N',
  `night` set('Y','N') COLLATE latin1_general_ci NOT NULL DEFAULT 'N',
  PRIMARY KEY (`medicine_data_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`medicine_data_id`, `medicine_id`, `history_id`, `morning`, `afternoon`, `evening`, `night`) VALUES
(1, 1, 11, 'N', 'Y', 'N', 'Y'),
(2, 2, 11, 'Y', 'N', 'Y', 'Y'),
(3, 1, 11, 'N', 'N', 'N', 'Y'),
(4, 2, 26, 'Y', 'N', 'N', 'Y'),
(5, 1, 26, 'N', 'Y', 'N', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `medicines_all`
--

DROP TABLE IF EXISTS `medicines_all`;
CREATE TABLE IF NOT EXISTS `medicines_all` (
  `medicine_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `type` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  `dose` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  `manufacturer` varchar(45) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `medicines_all`
--

INSERT INTO `medicines_all` (`medicine_id`, `medicine_name`, `type`, `dose`, `manufacturer`) VALUES
(1, 'crocin', 'tablet', '500mg', 'suryansh'),
(2, 'benadryl', 'syrup', '1 tablespoon', 'suryansh');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

DROP TABLE IF EXISTS `notes`;
CREATE TABLE IF NOT EXISTS `notes` (
  `notes_id` int(11) NOT NULL AUTO_INCREMENT,
  `history_id` int(11) NOT NULL,
  `note` varchar(500) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`notes_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `parameters`
--

DROP TABLE IF EXISTS `parameters`;
CREATE TABLE IF NOT EXISTS `parameters` (
  `parameter_id` int(11) NOT NULL AUTO_INCREMENT,
  `history_id` int(11) NOT NULL,
  `parameter_type` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `value` varchar(45) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`parameter_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=13 ;

--
-- Dumping data for table `parameters`
--

INSERT INTO `parameters` (`parameter_id`, `history_id`, `parameter_type`, `value`) VALUES
(1, 11, 'temperature', '98'),
(2, 11, 'blood pressure ', '140'),
(3, 11, 'parameter3', '3'),
(4, 11, 'parameter 4', '4'),
(5, 11, 'parameter 5', ''),
(6, 11, 'parameter 6', '6'),
(7, 20, 'test', '12'),
(8, 23, 'temperature ', ' 104'),
(9, 21, 'temperature ', '104'),
(10, 26, 'Temperature', '104'),
(11, 26, 'Heartbeat', '150'),
(12, 26, 'Weight', '101Kg');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `height` varchar(15) COLLATE latin1_general_ci DEFAULT NULL,
  `weight` varchar(15) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patient_id`, `person_id`, `height`, `weight`) VALUES
(1, 2, NULL, NULL),
(2, 4, NULL, NULL),
(3, 12, NULL, NULL),
(4, 13, NULL, NULL),
(5, 15, NULL, NULL),
(6, 17, NULL, NULL),
(7, 19, NULL, NULL),
(8, 20, NULL, NULL),
(9, 21, NULL, NULL),
(10, 22, NULL, NULL),
(11, 24, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `patient_history`
--

DROP TABLE IF EXISTS `patient_history`;
CREATE TABLE IF NOT EXISTS `patient_history` (
  `history_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) unsigned NOT NULL,
  `person_id` int(11) unsigned NOT NULL,
  `symptoms_id` int(11) unsigned DEFAULT NULL,
  `parameters_id` int(11) unsigned DEFAULT NULL,
  `disease_id` int(11) unsigned DEFAULT NULL,
  `medicines_id` int(11) unsigned DEFAULT NULL,
  `tests_id` int(11) unsigned DEFAULT NULL,
  `notes_id` int(11) unsigned DEFAULT NULL,
  `doctor_id` int(10) unsigned NOT NULL,
  `saved` varchar(45) COLLATE latin1_general_ci NOT NULL DEFAULT 'N',
  `date_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_created` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`history_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=28 ;

--
-- Dumping data for table `patient_history`
--

INSERT INTO `patient_history` (`history_id`, `patient_id`, `person_id`, `symptoms_id`, `parameters_id`, `disease_id`, `medicines_id`, `tests_id`, `notes_id`, `doctor_id`, `saved`, `date_modified`, `date_created`) VALUES
(7, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'Y', '2013-11-28 10:56:08', '0000-00-00 00:00:00'),
(2, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'Y', '2013-11-28 08:27:33', '0000-00-00 00:00:00'),
(3, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'Y', '2013-11-27 23:43:24', '0000-00-00 00:00:00'),
(8, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'Y', '2013-11-28 11:00:29', '0000-00-00 00:00:00'),
(9, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'Y', '2013-11-28 11:01:53', '0000-00-00 00:00:00'),
(10, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'Y', '2013-11-28 11:02:22', '0000-00-00 00:00:00'),
(11, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'N', '2013-11-28 11:03:46', '0000-00-00 00:00:00'),
(12, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 2, 'N', '2013-11-28 11:07:33', '0000-00-00 00:00:00'),
(13, 2, 4, NULL, NULL, NULL, NULL, NULL, NULL, 2, 'Y', '2013-11-28 11:09:16', '0000-00-00 00:00:00'),
(14, 2, 4, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'Y', '2013-11-28 11:10:17', '0000-00-00 00:00:00'),
(16, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 'N', '2013-12-03 08:36:09', '0000-00-00 00:00:00'),
(17, 3, 12, NULL, NULL, NULL, NULL, NULL, NULL, 9, 'Y', '2014-03-07 05:38:43', '0000-00-00 00:00:00'),
(18, 4, 13, NULL, NULL, NULL, NULL, NULL, NULL, 9, 'Y', '2014-03-17 10:34:22', '0000-00-00 00:00:00'),
(19, 5, 15, NULL, NULL, NULL, NULL, NULL, NULL, 10, 'N', '2014-04-01 06:16:14', '0000-00-00 00:00:00'),
(20, 8, 20, NULL, NULL, NULL, NULL, NULL, NULL, 12, 'Y', '2014-04-03 03:42:14', '0000-00-00 00:00:00'),
(21, 4, 13, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'Y', '2014-04-13 08:45:38', '0000-00-00 00:00:00'),
(22, 9, 21, NULL, NULL, NULL, NULL, NULL, NULL, 11, 'Y', '2014-04-03 17:48:29', '0000-00-00 00:00:00'),
(23, 4, 13, NULL, NULL, NULL, NULL, NULL, NULL, 0, 'N', '2014-04-07 11:28:57', '0000-00-00 00:00:00'),
(24, 4, 13, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'N', '2014-04-23 06:34:03', '0000-00-00 00:00:00'),
(25, 11, 24, NULL, NULL, NULL, NULL, NULL, NULL, 13, 'N', '2014-04-26 18:30:41', '0000-00-00 00:00:00'),
(26, 9, 21, NULL, NULL, NULL, NULL, NULL, NULL, 14, 'N', '2014-04-27 22:45:14', '0000-00-00 00:00:00'),
(27, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, 14, 'N', '2014-04-28 00:38:07', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `per_all_people_f`
--

DROP TABLE IF EXISTS `per_all_people_f`;
CREATE TABLE IF NOT EXISTS `per_all_people_f` (
  `person_id` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `email` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  `person_type` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `address_id` int(15) DEFAULT NULL,
  `telephone` int(15) NOT NULL,
  `patient_id` int(15) DEFAULT NULL,
  `doctor_id` int(15) DEFAULT NULL,
  `person_no` int(15) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=26 ;

--
-- Dumping data for table `per_all_people_f`
--

INSERT INTO `per_all_people_f` (`person_id`, `name`, `email`, `person_type`, `address_id`, `telephone`, `patient_id`, `doctor_id`, `person_no`) VALUES
(1, 'a', 'a', 'D', NULL, 1, NULL, 1, NULL),
(2, 'b', 'b', 'P', NULL, 1, 1, NULL, NULL),
(3, 'c', 'c', 'D', NULL, 3, NULL, 2, NULL),
(4, 'd', 'd', 'P', NULL, 4, 2, NULL, NULL),
(5, 'e', 'e', 'D', NULL, 5, NULL, 3, NULL),
(6, 'f', 'f', 'D', NULL, 5, NULL, 4, NULL),
(7, 'g', 'g', 'D', NULL, 6, NULL, 5, NULL),
(8, 'h', 'h', 'D', NULL, 7, NULL, 6, NULL),
(9, 'i', 'i', 'D', NULL, 8, NULL, 7, NULL),
(10, 'j', 'j', 'D', NULL, 89, NULL, 8, NULL),
(11, 'suryansh', 'suryansh', 'D', NULL, 2147483647, NULL, 9, NULL),
(12, 'stuti', 'stuti', 'P', NULL, 2147483647, 3, NULL, NULL),
(13, 'surya', 'surya', 'P', NULL, 777, 4, NULL, NULL),
(14, 'Anup', 'anuprathi321@gmail.com', 'D', NULL, 999556, NULL, 10, NULL),
(15, 'Anup', 'anuprathi321@gmail.com', 'P', NULL, 99569, 5, NULL, NULL),
(16, 'Archana Rathi', 'ra@gmail.com', 'D', NULL, 2147483647, NULL, 11, NULL),
(17, 'tp patient', 'tp@gmail.com', 'P', NULL, 2147483647, 6, NULL, NULL),
(18, 'Archana rathi', 'archana@gmail.com', 'D', NULL, 2147483647, NULL, 12, NULL),
(19, 'gctg', 'g', 'P', NULL, 2147483647, 7, NULL, NULL),
(20, 'gctg', 'g@gmail.com', 'P', NULL, 2147483647, 8, NULL, NULL),
(21, 'Anup rathi', 'anup@gmail.com', 'P', NULL, 2147483647, 9, NULL, NULL),
(22, 'xyz', 'ABC@gmail. com', 'P', NULL, 123567, 10, NULL, NULL),
(23, 'Tanmay', 'tanmay.tapase@gmail.com', 'D', NULL, 0, NULL, 13, NULL),
(24, 'Tanmay', 'tanmay.tapase@gmail.com', 'P', NULL, 0, 11, NULL, NULL),
(25, 'Anuj Ranka', 'anuj.r@gmail.com', 'D', NULL, 20, NULL, 14, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
CREATE TABLE IF NOT EXISTS `prescription` (
  `prescription_id` int(11) NOT NULL AUTO_INCREMENT,
  `history_id` int(11) NOT NULL,
  `prescription_date` date NOT NULL,
  PRIMARY KEY (`prescription_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `symptoms`
--

DROP TABLE IF EXISTS `symptoms`;
CREATE TABLE IF NOT EXISTS `symptoms` (
  `symptom_id` int(11) NOT NULL AUTO_INCREMENT,
  `history_id` int(11) NOT NULL,
  `symptom` varchar(100) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`symptom_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=21 ;

--
-- Dumping data for table `symptoms`
--

INSERT INTO `symptoms` (`symptom_id`, `history_id`, `symptom`) VALUES
(1, 11, 'head ache'),
(3, 11, 'stomach ache'),
(4, 11, 'throat ache'),
(5, 11, 'leg ache'),
(6, 11, 'the fifth symptom'),
(7, 11, 'sha'),
(8, 11, 'shahahahahah'),
(9, 17, 'fever'),
(10, 17, 'pregnant'),
(11, 18, 'fever'),
(12, 20, 'xtrr'),
(13, 22, 'cold'),
(14, 22, 'cough'),
(15, 23, 'fever'),
(16, 23, 'vomiting'),
(17, 21, 'fever'),
(18, 24, 'fever'),
(19, 26, 'Stomach Ache'),
(20, 26, 'Sore throat');

-- --------------------------------------------------------

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
CREATE TABLE IF NOT EXISTS `tests` (
  `tests_id` int(11) NOT NULL AUTO_INCREMENT,
  `history_id` int(11) NOT NULL,
  `tests` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`tests_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `unique_id` varchar(23) COLLATE latin1_general_ci NOT NULL,
  `name` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `email` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `person_id` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `encrypted_password` varchar(80) COLLATE latin1_general_ci NOT NULL,
  `salt` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `login_number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `unique_id` (`unique_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=23 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `unique_id`, `name`, `email`, `person_id`, `encrypted_password`, `salt`, `created_at`, `updated_at`, `last_login`, `login_number`) VALUES
(1, '5293cf0a088344.17963477', 'a', 'a', '1', 'HqhNFQSwemKIuXXn40oh828z/Tw1ZDExM2QxMWU1', '5d113d11e5', '2013-11-25 17:28:26', NULL, '2014-04-05 06:04:49', 25),
(2, '5293cf211b12e0.15882339', 'b', 'b', '2', 'L+2E1OXNl8u+g4Ywm9bD9rqQxSI4OGFiMDUyZWNl', '88ab052ece', '2013-11-25 17:28:49', NULL, '2013-12-02 00:00:00', 2),
(3, '529723b58029d1.91968511', 'c', 'c', '3', 'FlscyPbS6hvsGEttHg0vjsRFejgzNjg2MDM3NWEy', '36860375a2', '2013-11-28 06:06:29', NULL, '2013-12-02 00:00:00', 2),
(4, '5297244d3760a8.82351140', 'd', 'd', '4', 'tZXFJInW08aQqIWqelNH0D60Ky1iNDY2YjViNWRk', 'b466b5b5dd', '2013-11-28 06:09:01', NULL, '2013-12-02 00:00:00', 2),
(5, '529724ef981599.54961990', 'e', 'e', '5', 'Tzq9DjziF0uh8Lowb3q8u5SHxxQ1MjU0ZDMzYzQ0', '5254d33c44', '2013-11-28 06:11:43', NULL, '2013-12-02 00:00:00', 2),
(6, '52972567362278.88388377', 'f', 'f', '6', 'OqzMnTk+U9En59cxkO69cUDBxrUyNmIwYjEyNjA5', '26b0b12609', '2013-11-28 06:13:43', NULL, '2013-12-02 00:00:00', 2),
(7, '529725e9e4e015.65959347', 'g', 'g', '7', 'r7/oEAqR5d0jlzUCEuOYOoHaVDQ4MTdhYWYyMDA3', '817aaf2007', '2013-11-28 06:15:53', NULL, '2013-12-02 00:00:00', 2),
(8, '52972653c9a596.40477000', 'h', 'h', '8', 'p3j7sie0aN885GMS2JoVgjQPTxo5NzhlMTFiZWIy', '978e11beb2', '2013-11-28 06:17:39', NULL, '2013-12-02 00:00:00', 2),
(9, '52972779e245e9.86745941', 'i', 'i', '9', '2gAfyelJjifZEsHjc4YKvvlgSeEyNzEzZmYyMzZk', '2713ff236d', '2013-11-28 06:22:33', NULL, '2013-12-02 00:00:00', 2),
(10, '5297285af39a67.38790572', 'j', 'j', '10', '/1kN0C1zXiMzRA1bY/UNI6l64Yo5M2JhMTYwOGZj', '93ba1608fc', '2013-11-28 06:26:18', NULL, '2013-12-02 00:00:00', 2),
(11, '53195a5f2bc281.34475395', 'suryansh', 'suryansh', '11', 'aeVSVYLOhChYkvkI/RBUoCOW9840YjdlMmUxNGI0', '4b7e2e14b4', '2014-03-07 00:34:23', NULL, '2014-03-17 06:32:01', 2),
(12, '53195a9a535169.05541197', 'stuti', 'stuti', '12', 'SBRcT1wMBuXpzFI6tlVhhQ78kBQ3NDdhZWFmZmIw', '747aeaffb0', '2014-03-07 00:35:22', NULL, NULL, 0),
(13, '53252d62a5c006.74537741', 'surya', 'surya', '13', 'gGm0uyT47sia8eLADGyiBMRvsg03NWI3MTAzZmJm', '75b7103fbf', '2014-03-16 00:49:38', NULL, NULL, 0),
(14, '533a50108cc022.94588200', 'Anup', 'anuprathi321@gmail.com', '14', 'KItypmOZlOAUib8REOizbMsUJBVjYTdjNzNlZDc0', 'ca7c73ed74', '2014-04-01 01:35:12', NULL, NULL, 0),
(15, '533bf9bfc42db3.28601772', 'Archana Rathi', 'ra@gmail.com', '16', 'chhRrFro8TQ9UkFq5vhv9Btbv5EyZGQzZjRlZmNl', '2dd3f4efce', '2014-04-02 07:51:27', NULL, '2014-04-03 13:33:34', 1),
(16, '533c0d8cc79125.82394409', 'tp patient', 'tp@gmail.com', '17', 'IHg8HEbxqWTCVC2o2f2iqmnQD1VmMmMyNjU3Yzk1', 'f2c2657c95', '2014-04-02 09:15:56', NULL, NULL, 0),
(17, '533cd63dba7295.01256462', 'Archana rathi', 'archana@gmail.com', '18', 'Ybavt+Uo3eU1XZk84QhHf9nvEIM1ZTFjNjJiYzQ0', '5e1c62bc44', '2014-04-02 23:32:13', NULL, NULL, 0),
(18, '533cd66bd20e55.99810305', 'gctg', 'g@gmail.com', '20', 'I7lHY9b4JxON5EUj7uxs9tcWryphZDI4NmM5ZTVm', 'ad286c9e5f', '2014-04-02 23:32:59', NULL, NULL, 0),
(19, '533d9c7aa8b307.70632402', 'Anup rathi', 'anup@gmail.com', '21', 'fP6egFvC6sLffJlw58wQcKNMJYIzM2RiODcxZjAx', '33db871f01', '2014-04-03 13:38:02', NULL, NULL, 0),
(20, '53575e6f2dad33.96820870', 'xyz', 'ABC@gmail. com', '22', 'WEeBYttKWYcfm/o0ljhR5DRbzTQ2ZjJmOWJkOTQw', '6f2f9bd940', '2014-04-23 02:32:15', NULL, NULL, 0),
(21, '535bfac7126266.81772063', 'Tanmay', 'tanmay.tapase@gmail.com', '23', 'wEObYjb3nycuCyeSgCkGT49DxlsxNDRlMDAxMzVh', '144e00135a', '2014-04-26 14:28:23', NULL, NULL, 0),
(22, '535d8852226c69.51380043', 'Anuj Ranka', 'anuj.r@gmail.com', '25', 'Xvg+yKX52R/PAUUuOFf87Xa9gtxmMzVjOTQ1ZmYw', 'f35c945ff0', '2014-04-27 18:44:34', NULL, '2014-04-27 20:37:00', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
