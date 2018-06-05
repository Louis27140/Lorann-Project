-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 05 juin 2018 à 07:10
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lorann`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `ChooseLevel`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ChooseLevel` (IN `id` INT(11))  NO SQL
SELECT * FROM map WHERE id = map_id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `map_id` int(5) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  PRIMARY KEY (`map_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `map`
--

INSERT INTO `map` (`map_id`, `text`) VALUES
(1, '02222222222222222220\r\n1                 51\r\n1 5 0  0220222220  1\r\n02220  15 1        1\r\n13     1  0     0220\r\n1      1           6\r\n020  020  02220  021\r\n1      1  1        1\r\n1      0  1  0222220\r\n1  5      1        1\r\n1         1       81\r\n02222222220222222220\r\n'),
(2, '02222222222222222220\r\n13     0           1\r\n1         B        1\r\n0220  02220 020 0220\r\n1     1            1\r\n1  0  0 A   4     81\r\n1  1               1\r\n1  022220  020222220\r\n1    1       1     1\r\n1    0 5     0     1\r\n1        9         1\r\n02222222222222222620\r\n'),
(3, '02222222222222220260\r\n13              1  1\r\n1        B      1  1\r\n1  022220  022220  1\r\n1  0     9      0  1\r\n1    4             1\r\n1                  1\r\n1  0            0  1\r\n022022220  022220220\r\n1         A        1\r\n15                81\r\n02222222222222222220\r\n'),
(4, '02222222220222022220\r\n13        1   1   81\r\n0220      1   1    1\r\n1     9   0 0 0    1\r\n1           1      1\r\n1  02222220202222220\r\n1  A      1        1\r\n0         1  0     1\r\n02222220  0  0220  6\r\n15           0     1\r\n1 4     B          1\r\n02222222222222222220\r\n'),
(5, '02222220222022222220\r\n1      1 3 1       1\r\n1 8    0   0    4  1\r\n1    9             1\r\n02222220   022222220\r\n1                  1\r\n1      0   0       1\r\n1  02220222022220  1\r\n1   A          B   1\r\n1  4   0   0   4 5 1\r\n1      1   1       1\r\n02222220262022222220\r\n');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
