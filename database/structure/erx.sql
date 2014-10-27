-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2013 at 11:17 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int(15) NOT NULL AUTO_INCREMENT,
  `house_no` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `address_line1` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `address_line2` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `city` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `state` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `pin` int(10) NOT NULL,
  `country` varchar(20) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

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
  `medicine_data_id` int(11) NOT NULL,
  `medicines_id` int(11) NOT NULL,
  `prescription_id` int(11) NOT NULL,
  `history_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `medicines_all`
--

DROP TABLE IF EXISTS `medicines_all`;
CREATE TABLE IF NOT EXISTS `medicines_all` (
  `medicines_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `type` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  `dose` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  `manufacturer` varchar(45) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`medicines_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

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
  `parameters_id` int(11) NOT NULL,
  `history_id` int(11) NOT NULL,
  `parameter_type` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `value` varchar(45) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`parameters_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `patient_data`
--

DROP TABLE IF EXISTS `patient_data`;
CREATE TABLE IF NOT EXISTS `patient_data` (
  `patient_data_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `height` varchar(15) COLLATE latin1_general_ci DEFAULT NULL,
  `weight` varchar(15) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`patient_data_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `patient_history`
--

DROP TABLE IF EXISTS `patient_history`;
CREATE TABLE IF NOT EXISTS `patient_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `symptoms_id` int(11) DEFAULT NULL,
  `parameters_id` int(11) DEFAULT NULL,
  `disease_id` int(11) DEFAULT NULL,
  `medicines_id` int(11) DEFAULT NULL,
  `tests_id` int(11) DEFAULT NULL,
  `notes_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`history_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

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
  `address_id` int(15) NOT NULL,
  `telephone` int(15) NOT NULL,
  `patient_id` int(15) DEFAULT NULL,
  `doc_id` int(15) DEFAULT NULL,
  `person_no` int(15) NOT NULL,
  PRIMARY KEY (`person_id`,`person_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

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
  `symptoms_id` int(11) NOT NULL AUTO_INCREMENT,
  `history_id` int(11) NOT NULL,
  `symptom` varchar(100) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`symptoms_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

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
  PRIMARY KEY (`uid`),
  UNIQUE KEY `unique_id` (`unique_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=6 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
