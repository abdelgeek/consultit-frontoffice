-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 13 mars 2018 à 17:29
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `consultdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `agency`
--

DROP TABLE IF EXISTS `agency`;
CREATE TABLE IF NOT EXISTS `agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency_initials` varchar(255) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `approval_type_id` bigint(20) DEFAULT NULL,
  `lead_time` int(11) DEFAULT NULL,
  `price_criteria_id` bigint(20) DEFAULT NULL,
  `certificate_validity` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtgx11d821rio4vuogtlg7018c` (`approval_type_id`),
  KEY `FKdrjp243vgxwlq0bp58odvsbt0` (`country_id`),
  KEY `FKr0fgs1da03n108bia2x6x15s1` (`price_criteria_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4572 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agency`
--

INSERT INTO `agency` (`id`, `agency_initials`, `link`, `country_id`, `approval_type_id`, `lead_time`, `price_criteria_id`, `certificate_validity`) VALUES
(13, 'NTRA', NULL, 13, 3, NULL, 0, NULL),
(12, 'MCCPT', NULL, 12, 3, NULL, 0, NULL),
(11, 'ARTCI', NULL, 11, 3, NULL, 0, NULL),
(10, 'ANRTIC', NULL, 10, 3, NULL, 0, NULL),
(9, 'ANAC', NULL, 9, 3, NULL, 0, NULL),
(8, 'ART', NULL, 8, 3, NULL, 0, NULL),
(7, 'ARCP', NULL, 7, 3, NULL, 1, NULL),
(6, 'ARTEL', NULL, 6, 3, NULL, 0, NULL),
(3, 'INACOM', NULL, 3, 3, NULL, 0, NULL),
(5, 'BOCRA', 'http://www.bocra.org.bw/', 5, 3, NULL, 1, NULL),
(4, 'ARCEP', 'http://www.arcep.bj/', 4, 3, NULL, 0, NULL),
(2, 'ARPT', 'http://www.arpt.dz', 2, 3, NULL, 0, NULL),
(30, 'SABS', 'https://www.sabs.co.za/', 1, 1, NULL, 1, NULL),
(29, 'ICASA', 'https://www.icasa.org.za', 1, 3, NULL, 1, NULL),
(28, 'NRCS', 'http://www.nrcs.org.za/', 1, 2, NULL, 1, NULL),
(14, '', NULL, 14, 3, NULL, 0, NULL),
(15, 'ETA', NULL, 15, 3, NULL, 0, NULL),
(16, 'ARCEP', NULL, 16, 3, NULL, 0, NULL),
(17, 'PURA', NULL, 17, 3, NULL, 0, NULL),
(18, 'NCA', NULL, 18, 3, NULL, 1, NULL),
(19, 'ARTP', NULL, 19, 3, NULL, 1, NULL),
(20, 'ORTEL', NULL, 20, 3, NULL, 0, NULL),
(21, 'ICGB', NULL, 21, 3, NULL, 0, NULL),
(22, 'CCK', NULL, 22, 3, NULL, 0, NULL),
(23, 'LCA', NULL, 23, 3, NULL, 0, NULL),
(24, 'LTA', NULL, 24, 3, NULL, 0, NULL),
(25, 'GTA', NULL, 25, 3, NULL, 0, NULL),
(26, 'OMERT', NULL, 26, 3, NULL, 0, NULL),
(27, 'MACRA', NULL, 27, 3, NULL, 0, NULL),
(31, 'AMRTP', NULL, 28, 3, NULL, 0, NULL),
(32, 'ANRT', NULL, 29, 3, NULL, 0, NULL),
(33, 'ICTA', NULL, 30, 3, NULL, 0, NULL),
(34, 'ARE', NULL, 31, 3, NULL, 0, NULL),
(35, 'INCM', NULL, 32, 3, NULL, 0, NULL),
(36, 'NCC', NULL, 33, 3, NULL, 0, NULL),
(37, 'ARM', NULL, 34, 3, NULL, 1, NULL),
(38, 'NCC', NULL, 35, 3, NULL, 3, NULL),
(39, 'UCC', NULL, 36, 3, NULL, 0, NULL),
(40, 'ART', 'www.art-rca.org ', 37, 3, NULL, 0, NULL),
(41, 'ARPCE', NULL, 38, 3, NULL, 0, NULL),
(42, 'ARPCE', NULL, 39, 3, NULL, 0, NULL),
(43, 'RURA', NULL, 40, 3, NULL, 0, NULL),
(44, '', NULL, 41, 3, NULL, 0, NULL),
(45, 'ARTP', NULL, 42, 3, NULL, 0, NULL),
(46, 'ARCEP', NULL, 43, 3, NULL, 0, NULL),
(47, 'MISD', NULL, 44, 3, NULL, 0, NULL),
(48, 'NATCOM', '', 45, 3, NULL, 0, NULL),
(49, 'MPC', NULL, 46, 3, NULL, 0, NULL),
(50, 'NTC', NULL, 47, 3, NULL, 0, NULL),
(51, 'MOTPS', NULL, 48, 3, NULL, 0, NULL),
(52, 'SPTC', NULL, 49, 3, NULL, 0, NULL),
(53, 'TCRA', NULL, 50, 3, NULL, 0, NULL),
(54, 'ARTP', NULL, 51, 3, NULL, 0, NULL),
(55, 'INT', NULL, 52, 3, NULL, 2, NULL),
(56, 'CAZ', NULL, 53, 3, NULL, 0, NULL),
(57, 'POTRAZ', NULL, 54, 3, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `agency_approval_information`
--

DROP TABLE IF EXISTS `agency_approval_information`;
CREATE TABLE IF NOT EXISTS `agency_approval_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency` bigint(20) DEFAULT NULL,
  `approval_information` bigint(20) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `is_accepted` bit(1) DEFAULT NULL,
  `is_required` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcmhb8u64mb7tebdvndlj9i9sy` (`agency`,`approval_information`),
  KEY `FK5nytidfd93kc59vcmh5933rti` (`approval_information`)
) ENGINE=MyISAM AUTO_INCREMENT=446 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agency_approval_information`
--

INSERT INTO `agency_approval_information` (`id`, `agency`, `approval_information`, `duration`, `is_accepted`, `is_required`) VALUES
(21, 4, 8, NULL, NULL, NULL),
(22, 4, 7, NULL, NULL, NULL),
(23, 4, 5, NULL, NULL, NULL),
(24, 4, 22, NULL, NULL, NULL),
(25, 4, 10, NULL, NULL, NULL),
(26, 4, 3, NULL, NULL, NULL),
(27, 4, 21, NULL, NULL, NULL),
(28, 4, 20, NULL, NULL, NULL),
(29, 4, 17, NULL, NULL, NULL),
(30, 4, 23, NULL, NULL, NULL),
(31, 4, 15, NULL, NULL, NULL),
(32, 4, 14, NULL, NULL, NULL),
(33, 4, 25, NULL, NULL, NULL),
(34, 4, 18, NULL, NULL, NULL),
(35, 5, 7, NULL, NULL, NULL),
(36, 5, 5, NULL, NULL, NULL),
(37, 5, 22, NULL, NULL, NULL),
(38, 5, 10, NULL, NULL, NULL),
(39, 5, 3, NULL, NULL, NULL),
(40, 5, 21, NULL, NULL, NULL),
(112, 46, 7, NULL, NULL, NULL),
(42, 5, 17, NULL, NULL, NULL),
(43, 5, 23, NULL, NULL, NULL),
(44, 5, 24, NULL, NULL, NULL),
(45, 5, 15, NULL, NULL, NULL),
(46, 5, 12, NULL, NULL, NULL),
(47, 5, 25, NULL, NULL, NULL),
(48, 5, 18, NULL, NULL, NULL),
(49, 5, 1, NULL, NULL, NULL),
(50, 5, 11, NULL, NULL, NULL),
(51, 6, 8, NULL, NULL, NULL),
(52, 6, 7, NULL, NULL, NULL),
(53, 6, 5, NULL, NULL, NULL),
(54, 6, 22, NULL, NULL, NULL),
(55, 6, 10, NULL, NULL, NULL),
(56, 6, 2, NULL, NULL, NULL),
(57, 6, 21, NULL, NULL, NULL),
(111, 46, 8, NULL, NULL, NULL),
(109, 40, 25, NULL, NULL, NULL),
(60, 6, 23, NULL, NULL, NULL),
(61, 6, 24, NULL, NULL, NULL),
(110, 40, 18, NULL, NULL, NULL),
(63, 6, 15, NULL, NULL, NULL),
(64, 6, 14, NULL, NULL, NULL),
(65, 6, 25, NULL, NULL, NULL),
(66, 6, 1, NULL, NULL, NULL),
(67, 6, 18, NULL, NULL, NULL),
(68, 7, 8, NULL, NULL, NULL),
(69, 7, 7, NULL, NULL, NULL),
(70, 7, 5, NULL, NULL, NULL),
(71, 7, 22, NULL, NULL, NULL),
(72, 7, 10, NULL, NULL, NULL),
(73, 7, 2, NULL, NULL, NULL),
(74, 7, 21, NULL, NULL, NULL),
(75, 7, 20, NULL, NULL, NULL),
(107, 40, 15, NULL, NULL, NULL),
(77, 7, 23, NULL, NULL, NULL),
(78, 7, 24, NULL, NULL, NULL),
(108, 40, 14, NULL, NULL, NULL),
(80, 7, 15, NULL, NULL, NULL),
(81, 7, 14, NULL, NULL, NULL),
(82, 7, 25, NULL, NULL, NULL),
(83, 7, 1, NULL, NULL, NULL),
(84, 7, 18, NULL, NULL, NULL),
(85, 8, 8, NULL, NULL, NULL),
(86, 8, 7, NULL, NULL, NULL),
(87, 8, 22, NULL, NULL, NULL),
(88, 8, 10, NULL, NULL, NULL),
(89, 8, 2, NULL, NULL, NULL),
(90, 8, 21, NULL, NULL, NULL),
(91, 8, 20, NULL, NULL, NULL),
(106, 40, 24, NULL, NULL, NULL),
(93, 8, 23, NULL, NULL, NULL),
(94, 8, 24, NULL, NULL, NULL),
(95, 8, 15, NULL, NULL, NULL),
(96, 8, 14, NULL, NULL, NULL),
(97, 8, 25, NULL, NULL, NULL),
(98, 8, 1, NULL, NULL, NULL),
(99, 40, 8, NULL, NULL, NULL),
(100, 40, 7, NULL, NULL, NULL),
(101, 40, 5, NULL, NULL, NULL),
(102, 40, 21, NULL, NULL, NULL),
(103, 40, 10, NULL, NULL, NULL),
(105, 40, 23, NULL, NULL, NULL),
(113, 46, 5, NULL, NULL, NULL),
(114, 46, 22, NULL, NULL, NULL),
(115, 46, 10, NULL, NULL, NULL),
(116, 46, 3, NULL, NULL, NULL),
(117, 46, 21, NULL, NULL, NULL),
(118, 46, 20, NULL, NULL, NULL),
(119, 46, 23, NULL, NULL, NULL),
(120, 46, 15, NULL, NULL, NULL),
(121, 46, 14, NULL, NULL, NULL),
(122, 46, 25, NULL, NULL, NULL),
(123, 41, 8, NULL, NULL, NULL),
(124, 41, 7, NULL, NULL, NULL),
(125, 41, 5, NULL, NULL, NULL),
(126, 41, 22, NULL, NULL, NULL),
(127, 41, 10, NULL, NULL, NULL),
(128, 41, 2, NULL, NULL, NULL),
(129, 41, 21, NULL, NULL, NULL),
(130, 41, 20, NULL, NULL, NULL),
(131, 41, 23, NULL, NULL, NULL),
(132, 41, 15, NULL, NULL, NULL),
(133, 41, 14, NULL, NULL, NULL),
(134, 41, 25, NULL, NULL, NULL),
(135, 41, 1, NULL, NULL, NULL),
(136, 11, 8, NULL, NULL, NULL),
(137, 11, 7, NULL, NULL, NULL),
(138, 11, 5, NULL, NULL, NULL),
(139, 11, 22, NULL, NULL, NULL),
(140, 11, 10, NULL, NULL, NULL),
(141, 11, 3, NULL, NULL, NULL),
(142, 11, 21, NULL, NULL, NULL),
(143, 11, 20, NULL, NULL, NULL),
(144, 11, 23, NULL, NULL, NULL),
(145, 11, 15, NULL, NULL, NULL),
(146, 11, 14, NULL, NULL, NULL),
(147, 11, 25, NULL, NULL, NULL),
(148, 11, 1, NULL, NULL, NULL),
(149, 11, 18, NULL, NULL, NULL),
(150, 42, 8, NULL, NULL, NULL),
(151, 42, 7, NULL, NULL, NULL),
(152, 42, 5, NULL, NULL, NULL),
(153, 42, 22, NULL, NULL, NULL),
(154, 42, 10, NULL, NULL, NULL),
(155, 42, 3, NULL, NULL, NULL),
(156, 42, 21, NULL, NULL, NULL),
(157, 42, 20, NULL, NULL, NULL),
(158, 42, 23, NULL, NULL, NULL),
(159, 42, 15, NULL, NULL, NULL),
(160, 42, 12, NULL, NULL, NULL),
(161, 42, 14, NULL, NULL, NULL),
(162, 42, 25, NULL, NULL, NULL),
(163, 42, 1, NULL, NULL, NULL),
(164, 20, 8, NULL, NULL, NULL),
(165, 20, 7, NULL, NULL, NULL),
(166, 20, 5, NULL, NULL, NULL),
(167, 20, 22, NULL, NULL, NULL),
(168, 20, 10, NULL, NULL, NULL),
(169, 20, 3, NULL, NULL, NULL),
(170, 20, 21, NULL, NULL, NULL),
(171, 20, 23, NULL, NULL, NULL),
(172, 20, 15, NULL, NULL, NULL),
(173, 20, 14, NULL, NULL, NULL),
(174, 20, 25, NULL, NULL, NULL),
(175, 20, 1, NULL, NULL, NULL),
(176, 16, 8, NULL, NULL, NULL),
(177, 16, 7, NULL, NULL, NULL),
(178, 16, 5, NULL, NULL, NULL),
(179, 16, 22, NULL, NULL, NULL),
(180, 16, 10, NULL, NULL, NULL),
(181, 16, 3, NULL, NULL, NULL),
(182, 16, 21, NULL, NULL, NULL),
(183, 16, 20, NULL, NULL, NULL),
(184, 16, 23, NULL, NULL, NULL),
(185, 16, 12, NULL, NULL, NULL),
(186, 16, 15, NULL, NULL, NULL),
(187, 16, 14, NULL, NULL, NULL),
(188, 16, 25, NULL, NULL, NULL),
(189, 16, 1, NULL, NULL, NULL),
(190, 17, 8, NULL, NULL, NULL),
(191, 17, 7, NULL, NULL, NULL),
(192, 17, 5, NULL, NULL, NULL),
(193, 17, 22, NULL, NULL, NULL),
(194, 17, 10, NULL, NULL, NULL),
(195, 17, 3, NULL, NULL, NULL),
(196, 17, 21, NULL, NULL, NULL),
(197, 17, 23, NULL, NULL, NULL),
(198, 17, 15, NULL, NULL, NULL),
(199, 17, 14, NULL, NULL, NULL),
(200, 17, 25, NULL, NULL, NULL),
(201, 17, 1, NULL, NULL, NULL),
(202, 18, 8, NULL, NULL, NULL),
(203, 18, 7, NULL, NULL, NULL),
(204, 18, 5, NULL, NULL, NULL),
(205, 18, 22, NULL, NULL, NULL),
(206, 18, 10, NULL, NULL, NULL),
(207, 18, 21, NULL, NULL, NULL),
(208, 18, 23, NULL, NULL, NULL),
(209, 18, 12, NULL, NULL, NULL),
(210, 18, 15, NULL, NULL, NULL),
(211, 18, 1, NULL, NULL, NULL),
(212, 18, 18, NULL, NULL, NULL),
(213, 19, 8, NULL, NULL, NULL),
(214, 19, 7, NULL, NULL, NULL),
(215, 19, 5, NULL, NULL, NULL),
(216, 19, 22, NULL, NULL, NULL),
(217, 19, 10, NULL, NULL, NULL),
(218, 19, 3, NULL, NULL, NULL),
(219, 19, 20, NULL, NULL, NULL),
(220, 19, 21, NULL, NULL, NULL),
(221, 19, 17, NULL, NULL, NULL),
(222, 19, 23, NULL, NULL, NULL),
(223, 19, 12, NULL, NULL, NULL),
(224, 19, 15, NULL, NULL, NULL),
(225, 19, 14, NULL, NULL, NULL),
(226, 19, 25, NULL, NULL, NULL),
(227, 19, 1, NULL, NULL, NULL),
(228, 21, 8, NULL, NULL, NULL),
(229, 21, 7, NULL, NULL, NULL),
(230, 21, 5, NULL, NULL, NULL),
(231, 21, 22, NULL, NULL, NULL),
(232, 21, 10, NULL, NULL, NULL),
(233, 21, 21, NULL, NULL, NULL),
(234, 21, 23, NULL, NULL, NULL),
(235, 21, 12, NULL, NULL, NULL),
(236, 21, 15, NULL, NULL, NULL),
(237, 21, 14, NULL, NULL, NULL),
(238, 21, 25, NULL, NULL, NULL),
(239, 21, 1, NULL, NULL, NULL),
(240, 22, 8, NULL, NULL, NULL),
(241, 22, 7, NULL, NULL, NULL),
(242, 22, 5, NULL, NULL, NULL),
(243, 22, 22, NULL, NULL, NULL),
(244, 22, 10, NULL, NULL, NULL),
(245, 22, 3, NULL, NULL, NULL),
(246, 22, 21, NULL, NULL, NULL),
(247, 22, 23, NULL, NULL, NULL),
(248, 22, 14, NULL, NULL, NULL),
(249, 22, 25, NULL, NULL, NULL),
(250, 22, 1, NULL, NULL, NULL),
(251, 23, 8, NULL, NULL, NULL),
(252, 23, 7, NULL, NULL, NULL),
(253, 23, 5, NULL, NULL, NULL),
(254, 23, 22, NULL, NULL, NULL),
(255, 23, 10, NULL, NULL, NULL),
(256, 23, 3, NULL, NULL, NULL),
(257, 23, 21, NULL, NULL, NULL),
(258, 23, 23, NULL, NULL, NULL),
(259, 23, 24, NULL, NULL, NULL),
(260, 23, 14, NULL, NULL, NULL),
(261, 23, 25, NULL, NULL, NULL),
(262, 23, 1, NULL, NULL, NULL),
(263, 24, 8, NULL, NULL, NULL),
(264, 24, 7, NULL, NULL, NULL),
(265, 24, 5, NULL, NULL, NULL),
(266, 24, 22, NULL, NULL, NULL),
(267, 24, 10, NULL, NULL, NULL),
(268, 24, 3, NULL, NULL, NULL),
(269, 24, 21, NULL, NULL, NULL),
(270, 24, 23, NULL, NULL, NULL),
(271, 24, 24, NULL, NULL, NULL),
(272, 24, 14, NULL, NULL, NULL),
(273, 24, 25, NULL, NULL, NULL),
(274, 24, 1, NULL, NULL, NULL),
(275, 26, 8, NULL, NULL, NULL),
(276, 26, 7, NULL, NULL, NULL),
(277, 26, 5, NULL, NULL, NULL),
(278, 26, 22, NULL, NULL, NULL),
(279, 26, 10, NULL, NULL, NULL),
(280, 26, 21, NULL, NULL, NULL),
(281, 26, 23, NULL, NULL, NULL),
(282, 26, 24, NULL, NULL, NULL),
(283, 26, 14, NULL, NULL, NULL),
(284, 26, 25, NULL, NULL, NULL),
(285, 26, 1, NULL, NULL, NULL),
(286, 26, 15, NULL, NULL, NULL),
(287, 27, 8, NULL, NULL, NULL),
(288, 27, 7, NULL, NULL, NULL),
(289, 31, 8, NULL, NULL, NULL),
(290, 31, 7, NULL, NULL, NULL),
(291, 31, 5, NULL, NULL, NULL),
(292, 31, 22, NULL, NULL, NULL),
(293, 31, 3, NULL, NULL, NULL),
(294, 31, 10, NULL, NULL, NULL),
(295, 31, 20, NULL, NULL, NULL),
(296, 31, 21, NULL, NULL, NULL),
(297, 31, 23, NULL, NULL, NULL),
(298, 31, 24, NULL, NULL, NULL),
(299, 31, 14, NULL, NULL, NULL),
(300, 31, 25, NULL, NULL, NULL),
(301, 31, 1, NULL, NULL, NULL),
(302, 31, 15, NULL, NULL, NULL),
(303, 34, 8, NULL, NULL, NULL),
(304, 34, 7, NULL, NULL, NULL),
(305, 34, 5, NULL, NULL, NULL),
(306, 34, 22, NULL, NULL, NULL),
(307, 34, 10, NULL, NULL, NULL),
(308, 34, 20, NULL, NULL, NULL),
(309, 34, 23, NULL, NULL, NULL),
(310, 34, 24, NULL, NULL, NULL),
(311, 34, 14, NULL, NULL, NULL),
(312, 34, 25, NULL, NULL, NULL),
(313, 34, 1, NULL, NULL, NULL),
(314, 34, 15, NULL, NULL, NULL),
(315, 32, 8, NULL, NULL, NULL),
(316, 32, 7, NULL, NULL, NULL),
(317, 32, 5, NULL, NULL, NULL),
(318, 32, 22, NULL, NULL, NULL),
(319, 32, 10, NULL, NULL, NULL),
(320, 32, 2, NULL, NULL, NULL),
(321, 32, 20, NULL, NULL, NULL),
(322, 32, 23, NULL, NULL, NULL),
(323, 32, 24, NULL, NULL, NULL),
(324, 32, 14, NULL, NULL, NULL),
(325, 32, 25, NULL, NULL, NULL),
(326, 32, 1, NULL, NULL, NULL),
(327, 32, 15, NULL, NULL, NULL),
(328, 36, 8, NULL, NULL, NULL),
(329, 36, 7, NULL, NULL, NULL),
(330, 36, 5, NULL, NULL, NULL),
(331, 36, 22, NULL, NULL, NULL),
(332, 36, 10, NULL, NULL, NULL),
(333, 36, 2, NULL, NULL, NULL),
(334, 36, 20, NULL, NULL, NULL),
(335, 36, 21, NULL, NULL, NULL),
(336, 36, 23, NULL, NULL, NULL),
(337, 36, 24, NULL, NULL, NULL),
(338, 36, 1, NULL, NULL, NULL),
(339, 36, 15, NULL, NULL, NULL),
(340, 37, 8, NULL, NULL, NULL),
(341, 37, 7, NULL, NULL, NULL),
(342, 37, 5, NULL, NULL, NULL),
(343, 37, 22, NULL, NULL, NULL),
(344, 37, 10, NULL, NULL, NULL),
(345, 37, 2, NULL, NULL, NULL),
(346, 37, 20, NULL, NULL, NULL),
(347, 37, 21, NULL, NULL, NULL),
(348, 37, 23, NULL, NULL, NULL),
(349, 37, 24, NULL, NULL, NULL),
(350, 37, 1, NULL, NULL, NULL),
(351, 37, 15, NULL, NULL, NULL),
(352, 43, 8, NULL, NULL, NULL),
(353, 43, 7, NULL, NULL, NULL),
(354, 43, 5, NULL, NULL, NULL),
(355, 43, 22, NULL, NULL, NULL),
(356, 43, 10, NULL, NULL, NULL),
(357, 43, 2, NULL, NULL, NULL),
(358, 43, 20, NULL, NULL, NULL),
(359, 43, 21, NULL, NULL, NULL),
(360, 43, 23, NULL, NULL, NULL),
(361, 43, 24, NULL, NULL, NULL),
(362, 43, 1, NULL, NULL, NULL),
(363, 43, 15, NULL, NULL, NULL),
(364, 43, 14, NULL, NULL, NULL),
(365, 43, 25, NULL, NULL, NULL),
(366, 45, 8, NULL, NULL, NULL),
(367, 45, 7, NULL, NULL, NULL),
(368, 45, 5, NULL, NULL, NULL),
(369, 45, 22, NULL, NULL, NULL),
(370, 45, 10, NULL, NULL, NULL),
(371, 45, 2, NULL, NULL, NULL),
(372, 45, 20, NULL, NULL, NULL),
(373, 45, 23, NULL, NULL, NULL),
(374, 45, 24, NULL, NULL, NULL),
(375, 45, 1, NULL, NULL, NULL),
(376, 45, 15, NULL, NULL, NULL),
(377, 56, 8, NULL, NULL, NULL),
(378, 56, 7, NULL, NULL, NULL),
(379, 56, 5, NULL, NULL, NULL),
(380, 56, 22, NULL, NULL, NULL),
(381, 56, 10, NULL, NULL, NULL),
(382, 56, 2, NULL, NULL, NULL),
(383, 56, 20, NULL, NULL, NULL),
(384, 56, 23, NULL, NULL, NULL),
(385, 56, 24, NULL, NULL, NULL),
(386, 56, 1, NULL, NULL, NULL),
(387, 56, 15, NULL, NULL, NULL),
(388, 57, 8, NULL, NULL, NULL),
(389, 57, 7, NULL, NULL, NULL),
(390, 57, 5, NULL, NULL, NULL),
(391, 57, 22, NULL, NULL, NULL),
(392, 57, 10, NULL, NULL, NULL),
(393, 57, 2, NULL, NULL, NULL),
(394, 57, 20, NULL, NULL, NULL),
(395, 57, 23, NULL, NULL, NULL),
(396, 57, 24, NULL, NULL, NULL),
(397, 57, 1, NULL, NULL, NULL),
(398, 39, 8, NULL, NULL, NULL),
(399, 39, 7, NULL, NULL, NULL),
(400, 39, 5, NULL, NULL, NULL),
(401, 39, 22, NULL, NULL, NULL),
(402, 55, 8, NULL, NULL, NULL),
(403, 55, 7, NULL, NULL, NULL),
(404, 55, 5, NULL, NULL, NULL),
(405, 55, 22, NULL, NULL, NULL),
(406, 53, 8, NULL, NULL, NULL),
(407, 53, 7, NULL, NULL, NULL),
(408, 53, 5, NULL, NULL, NULL),
(409, 53, 22, NULL, NULL, NULL),
(410, 53, 10, NULL, NULL, NULL),
(411, 53, 2, NULL, NULL, NULL),
(412, 53, 20, NULL, NULL, NULL),
(413, 53, 23, NULL, NULL, NULL),
(414, 53, 24, NULL, NULL, NULL),
(415, 53, 1, NULL, NULL, NULL),
(416, 54, 8, NULL, NULL, NULL),
(417, 54, 7, NULL, NULL, NULL),
(418, 54, 5, NULL, NULL, NULL),
(419, 54, 22, NULL, NULL, NULL),
(420, 54, 10, NULL, NULL, NULL),
(421, 54, 2, NULL, NULL, NULL),
(422, 54, 20, NULL, NULL, NULL),
(423, 54, 23, NULL, NULL, NULL),
(424, 54, 24, NULL, NULL, NULL),
(425, 54, 1, NULL, NULL, NULL),
(426, 52, 8, NULL, NULL, NULL),
(427, 52, 7, NULL, NULL, NULL),
(428, 52, 5, NULL, NULL, NULL),
(429, 52, 22, NULL, NULL, NULL),
(430, 52, 10, NULL, NULL, NULL),
(431, 52, 2, NULL, NULL, NULL),
(432, 52, 20, NULL, NULL, NULL),
(433, 52, 23, NULL, NULL, NULL),
(434, 52, 24, NULL, NULL, NULL),
(435, 52, 1, NULL, NULL, NULL),
(436, 48, 8, NULL, NULL, NULL),
(437, 48, 7, NULL, NULL, NULL),
(438, 48, 5, NULL, NULL, NULL),
(439, 48, 22, NULL, NULL, NULL),
(440, 48, 10, NULL, NULL, NULL),
(441, 48, 2, NULL, NULL, NULL),
(442, 48, 20, NULL, NULL, NULL),
(443, 48, 23, NULL, NULL, NULL),
(444, 48, 24, NULL, NULL, NULL),
(445, 48, 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `agency_frequency_band`
--

DROP TABLE IF EXISTS `agency_frequency_band`;
CREATE TABLE IF NOT EXISTS `agency_frequency_band` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_frequency_authorized` bit(1) NOT NULL,
  `agency` bigint(20) DEFAULT NULL,
  `frequency` bigint(20) DEFAULT NULL,
  `has_restriction` bit(1) DEFAULT NULL,
  `is_authorized` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKk5jup029wernp93ekae40x9rn` (`agency`,`frequency`),
  KEY `FKopc6k1pcr7tvddwjfer0u63w8` (`frequency`)
) ENGINE=MyISAM AUTO_INCREMENT=441 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agency_frequency_band`
--

INSERT INTO `agency_frequency_band` (`id`, `is_frequency_authorized`, `agency`, `frequency`, `has_restriction`, `is_authorized`) VALUES
(1, b'1', 1, 1, b'0', NULL),
(2, b'1', 1, 2, b'0', NULL),
(3, b'1', 1, 3, b'0', NULL),
(4, b'1', 1, 4, b'0', NULL),
(5, b'1', 1, 5, b'0', NULL),
(6, b'1', 1, 6, b'0', NULL),
(7, b'1', 1, 7, b'0', NULL),
(8, b'1', 1, 8, b'0', NULL),
(9, b'1', 2, 1, b'0', NULL),
(10, b'1', 2, 2, b'0', NULL),
(11, b'1', 2, 3, b'0', NULL),
(12, b'1', 2, 4, b'0', NULL),
(13, b'1', 2, 5, b'0', NULL),
(14, b'1', 2, 6, b'0', NULL),
(15, b'1', 2, 7, b'0', NULL),
(16, b'1', 2, 8, b'0', NULL),
(17, b'1', 3, 1, b'0', NULL),
(18, b'1', 3, 2, b'0', NULL),
(19, b'1', 3, 3, b'0', NULL),
(20, b'1', 3, 4, b'0', NULL),
(21, b'1', 3, 5, b'0', NULL),
(22, b'1', 3, 6, b'0', NULL),
(23, b'1', 3, 7, b'0', NULL),
(24, b'1', 3, 8, b'0', NULL),
(25, b'1', 4, 1, b'0', NULL),
(26, b'1', 4, 2, b'0', NULL),
(27, b'1', 4, 3, b'0', NULL),
(28, b'1', 4, 4, b'0', NULL),
(29, b'1', 4, 5, b'0', NULL),
(30, b'1', 4, 6, b'0', NULL),
(31, b'1', 4, 7, b'0', NULL),
(32, b'1', 4, 8, b'0', NULL),
(33, b'1', 5, 1, b'0', NULL),
(34, b'1', 5, 2, b'0', NULL),
(35, b'1', 5, 3, b'0', NULL),
(36, b'1', 5, 4, b'0', NULL),
(37, b'1', 5, 5, b'0', NULL),
(38, b'1', 5, 6, b'0', NULL),
(39, b'1', 5, 7, b'0', NULL),
(40, b'1', 5, 8, b'0', NULL),
(41, b'1', 6, 1, b'0', NULL),
(42, b'1', 6, 2, b'0', NULL),
(43, b'1', 6, 3, b'0', NULL),
(44, b'1', 6, 4, b'0', NULL),
(45, b'1', 6, 5, b'0', NULL),
(46, b'1', 6, 6, b'0', NULL),
(47, b'1', 6, 7, b'0', NULL),
(48, b'1', 6, 8, b'0', NULL),
(49, b'1', 7, 1, b'0', NULL),
(50, b'1', 7, 2, b'0', NULL),
(51, b'1', 7, 3, b'0', NULL),
(52, b'1', 7, 4, b'0', NULL),
(53, b'1', 7, 5, b'0', NULL),
(54, b'1', 7, 6, b'0', NULL),
(55, b'1', 7, 7, b'0', NULL),
(56, b'1', 7, 8, b'0', NULL),
(57, b'1', 8, 1, b'0', NULL),
(58, b'1', 8, 2, b'0', NULL),
(59, b'1', 8, 3, b'0', NULL),
(60, b'1', 8, 4, b'0', NULL),
(61, b'1', 8, 5, b'0', NULL),
(62, b'1', 8, 6, b'0', NULL),
(63, b'1', 8, 7, b'0', NULL),
(64, b'1', 8, 8, b'0', NULL),
(65, b'1', 9, 1, b'0', NULL),
(66, b'1', 9, 2, b'0', NULL),
(67, b'1', 9, 3, b'0', NULL),
(68, b'1', 9, 4, b'0', NULL),
(69, b'1', 9, 5, b'0', NULL),
(70, b'1', 9, 6, b'0', NULL),
(71, b'1', 9, 7, b'0', NULL),
(72, b'1', 9, 8, b'0', NULL),
(73, b'1', 10, 1, b'0', NULL),
(74, b'1', 10, 2, b'0', NULL),
(75, b'1', 10, 3, b'0', NULL),
(76, b'1', 10, 4, b'0', NULL),
(77, b'1', 10, 5, b'0', NULL),
(78, b'1', 10, 6, b'0', NULL),
(79, b'1', 10, 7, b'0', NULL),
(80, b'1', 10, 8, b'0', NULL),
(81, b'1', 11, 1, b'0', NULL),
(82, b'1', 11, 2, b'0', NULL),
(83, b'1', 11, 3, b'0', NULL),
(84, b'1', 11, 4, b'0', NULL),
(85, b'1', 11, 5, b'1', NULL),
(86, b'1', 11, 6, b'0', NULL),
(87, b'1', 11, 7, b'0', NULL),
(88, b'1', 11, 8, b'0', NULL),
(89, b'1', 12, 1, b'0', NULL),
(90, b'1', 12, 2, b'0', NULL),
(91, b'1', 12, 3, b'0', NULL),
(92, b'1', 12, 4, b'0', NULL),
(93, b'1', 12, 5, b'0', NULL),
(94, b'1', 12, 6, b'0', NULL),
(95, b'1', 12, 7, b'0', NULL),
(96, b'1', 12, 8, b'0', NULL),
(97, b'1', 13, 1, b'0', NULL),
(98, b'1', 13, 2, b'0', NULL),
(99, b'1', 13, 3, b'0', NULL),
(100, b'1', 13, 4, b'0', NULL),
(101, b'1', 13, 5, b'0', NULL),
(102, b'1', 13, 6, b'0', NULL),
(103, b'1', 13, 7, b'0', NULL),
(104, b'1', 13, 8, b'0', NULL),
(105, b'1', 14, 1, b'0', NULL),
(106, b'1', 14, 2, b'0', NULL),
(107, b'1', 14, 3, b'0', NULL),
(108, b'1', 14, 4, b'0', NULL),
(109, b'1', 14, 5, b'0', NULL),
(110, b'1', 14, 6, b'0', NULL),
(111, b'1', 14, 7, b'0', NULL),
(112, b'1', 14, 8, b'0', NULL),
(113, b'1', 15, 1, b'0', NULL),
(114, b'1', 15, 2, b'0', NULL),
(115, b'1', 15, 3, b'0', NULL),
(116, b'1', 15, 4, b'0', NULL),
(117, b'1', 15, 5, b'0', NULL),
(118, b'1', 15, 6, b'0', NULL),
(119, b'1', 15, 7, b'0', NULL),
(120, b'1', 15, 8, b'0', NULL),
(121, b'1', 16, 1, b'0', NULL),
(122, b'1', 16, 2, b'0', NULL),
(123, b'1', 16, 3, b'0', NULL),
(124, b'1', 16, 4, b'0', NULL),
(125, b'1', 16, 5, b'0', NULL),
(126, b'1', 16, 6, b'0', NULL),
(127, b'1', 16, 7, b'0', NULL),
(128, b'1', 16, 8, b'0', NULL),
(129, b'1', 17, 1, b'0', NULL),
(130, b'1', 17, 2, b'0', NULL),
(131, b'1', 17, 3, b'0', NULL),
(132, b'1', 17, 4, b'0', NULL),
(133, b'1', 17, 5, b'0', NULL),
(134, b'1', 17, 6, b'0', NULL),
(135, b'1', 17, 7, b'0', NULL),
(136, b'1', 17, 8, b'0', NULL),
(137, b'1', 18, 1, b'0', NULL),
(138, b'1', 18, 2, b'0', NULL),
(139, b'1', 18, 3, b'0', NULL),
(140, b'1', 18, 4, b'0', NULL),
(141, b'1', 18, 5, b'0', NULL),
(142, b'1', 18, 6, b'0', NULL),
(143, b'1', 18, 7, b'0', NULL),
(144, b'1', 18, 8, b'0', NULL),
(145, b'1', 19, 1, b'0', NULL),
(146, b'1', 19, 2, b'0', NULL),
(147, b'1', 19, 3, b'0', NULL),
(148, b'1', 19, 4, b'0', NULL),
(149, b'1', 19, 5, b'0', NULL),
(150, b'1', 19, 6, b'0', NULL),
(151, b'1', 19, 7, b'0', NULL),
(152, b'1', 19, 8, b'0', NULL),
(153, b'1', 20, 1, b'0', NULL),
(154, b'1', 20, 2, b'0', NULL),
(155, b'1', 20, 3, b'0', NULL),
(156, b'1', 20, 4, b'0', NULL),
(157, b'1', 20, 5, b'0', NULL),
(158, b'1', 20, 6, b'0', NULL),
(159, b'1', 20, 7, b'0', NULL),
(160, b'1', 20, 8, b'0', NULL),
(161, b'1', 21, 1, b'0', NULL),
(162, b'1', 21, 2, b'0', NULL),
(163, b'1', 21, 3, b'0', NULL),
(164, b'1', 21, 4, b'0', NULL),
(165, b'1', 21, 5, b'0', NULL),
(166, b'1', 21, 6, b'0', NULL),
(167, b'1', 21, 7, b'0', NULL),
(168, b'1', 21, 8, b'0', NULL),
(169, b'1', 23, 1, b'0', NULL),
(170, b'1', 23, 2, b'0', NULL),
(171, b'1', 23, 3, b'0', NULL),
(172, b'1', 23, 4, b'0', NULL),
(173, b'1', 23, 5, b'0', NULL),
(174, b'1', 23, 6, b'0', NULL),
(175, b'1', 23, 7, b'0', NULL),
(176, b'1', 23, 8, b'0', NULL),
(177, b'1', 24, 1, b'0', NULL),
(178, b'1', 24, 2, b'0', NULL),
(179, b'1', 24, 3, b'0', NULL),
(180, b'1', 24, 4, b'0', NULL),
(181, b'1', 24, 5, b'0', NULL),
(182, b'1', 24, 6, b'0', NULL),
(183, b'1', 24, 7, b'0', NULL),
(184, b'1', 24, 8, b'0', NULL),
(185, b'1', 25, 1, b'0', NULL),
(186, b'1', 25, 2, b'0', NULL),
(187, b'1', 25, 3, b'0', NULL),
(188, b'1', 25, 4, b'0', NULL),
(189, b'1', 25, 5, b'0', NULL),
(190, b'1', 25, 6, b'0', NULL),
(191, b'1', 25, 7, b'0', NULL),
(192, b'1', 25, 8, b'0', NULL),
(193, b'1', 26, 1, b'0', NULL),
(194, b'1', 26, 2, b'0', NULL),
(195, b'1', 26, 3, b'0', NULL),
(196, b'1', 26, 4, b'0', NULL),
(197, b'1', 26, 5, b'0', NULL),
(198, b'1', 26, 6, b'0', NULL),
(199, b'1', 26, 7, b'0', NULL),
(200, b'1', 26, 8, b'0', NULL),
(201, b'1', 31, 1, b'0', NULL),
(202, b'1', 31, 2, b'0', NULL),
(203, b'1', 31, 3, b'0', NULL),
(204, b'1', 31, 4, b'0', NULL),
(205, b'1', 31, 5, b'0', NULL),
(206, b'1', 31, 6, b'0', NULL),
(207, b'1', 31, 7, b'0', NULL),
(208, b'1', 31, 8, b'0', NULL),
(209, b'1', 32, 1, b'0', NULL),
(210, b'1', 32, 2, b'0', NULL),
(211, b'1', 32, 3, b'0', NULL),
(212, b'1', 32, 4, b'0', NULL),
(213, b'1', 32, 5, b'0', NULL),
(214, b'1', 32, 6, b'0', NULL),
(215, b'1', 32, 7, b'0', NULL),
(216, b'1', 32, 8, b'0', NULL),
(217, b'1', 33, 1, b'0', NULL),
(218, b'1', 33, 2, b'0', NULL),
(219, b'1', 33, 3, b'0', NULL),
(220, b'1', 33, 4, b'0', NULL),
(221, b'1', 33, 5, b'0', NULL),
(222, b'1', 33, 6, b'0', NULL),
(223, b'1', 33, 7, b'0', NULL),
(224, b'1', 33, 8, b'0', NULL),
(225, b'1', 34, 1, b'0', NULL),
(226, b'1', 34, 2, b'0', NULL),
(227, b'1', 34, 3, b'0', NULL),
(228, b'1', 34, 4, b'0', NULL),
(229, b'1', 34, 5, b'0', NULL),
(230, b'1', 34, 6, b'0', NULL),
(231, b'1', 34, 7, b'0', NULL),
(232, b'1', 34, 8, b'0', NULL),
(233, b'1', 35, 1, b'0', NULL),
(234, b'1', 35, 2, b'0', NULL),
(235, b'1', 35, 3, b'0', NULL),
(236, b'1', 35, 4, b'0', NULL),
(237, b'1', 35, 5, b'0', NULL),
(238, b'1', 35, 6, b'0', NULL),
(239, b'1', 35, 7, b'0', NULL),
(240, b'1', 35, 8, b'0', NULL),
(241, b'1', 36, 1, b'0', NULL),
(242, b'1', 36, 2, NULL, NULL),
(243, b'1', 36, 3, b'0', NULL),
(244, b'1', 36, 4, b'0', NULL),
(245, b'1', 36, 5, b'0', NULL),
(246, b'1', 36, 6, b'0', NULL),
(247, b'1', 36, 7, b'0', NULL),
(248, b'1', 36, 8, b'0', NULL),
(249, b'1', 37, 1, b'0', NULL),
(250, b'1', 37, 2, b'0', NULL),
(251, b'1', 37, 3, b'0', NULL),
(252, b'1', 37, 4, b'0', NULL),
(253, b'1', 37, 5, b'0', NULL),
(254, b'1', 37, 6, b'0', NULL),
(255, b'1', 37, 7, b'0', NULL),
(256, b'1', 37, 8, b'0', NULL),
(257, b'1', 38, 1, b'0', NULL),
(258, b'1', 38, 2, b'0', NULL),
(259, b'1', 38, 3, b'0', NULL),
(260, b'1', 38, 4, b'1', NULL),
(261, b'1', 38, 5, b'1', NULL),
(262, b'1', 38, 6, b'0', NULL),
(263, b'1', 38, 7, b'0', NULL),
(264, b'1', 38, 8, b'0', NULL),
(265, b'1', 39, 1, b'0', NULL),
(266, b'1', 39, 2, b'0', NULL),
(267, b'1', 39, 3, b'0', NULL),
(268, b'1', 39, 4, b'0', NULL),
(269, b'1', 39, 5, b'0', NULL),
(270, b'1', 39, 6, b'0', NULL),
(271, b'1', 39, 7, b'0', NULL),
(272, b'1', 39, 8, b'0', NULL),
(273, b'1', 40, 1, b'0', NULL),
(274, b'1', 40, 2, b'0', NULL),
(275, b'1', 40, 3, b'0', NULL),
(276, b'1', 40, 4, b'0', NULL),
(277, b'1', 40, 5, b'0', NULL),
(278, b'1', 40, 6, b'0', NULL),
(279, b'1', 40, 7, b'0', NULL),
(280, b'1', 40, 8, b'0', NULL),
(281, b'1', 41, 1, b'0', NULL),
(282, b'1', 41, 2, b'0', NULL),
(283, b'1', 41, 3, b'0', NULL),
(284, b'1', 41, 4, b'0', NULL),
(285, b'1', 41, 5, b'0', NULL),
(286, b'1', 41, 6, b'0', NULL),
(287, b'1', 41, 7, b'0', NULL),
(288, b'1', 41, 8, b'0', NULL),
(289, b'1', 42, 1, b'0', NULL),
(290, b'1', 42, 2, b'0', NULL),
(291, b'1', 42, 3, b'0', NULL),
(292, b'1', 42, 4, b'0', NULL),
(293, b'1', 42, 5, b'0', NULL),
(294, b'1', 42, 6, b'0', NULL),
(295, b'1', 42, 7, b'0', NULL),
(296, b'1', 42, 8, b'0', NULL),
(297, b'1', 43, 1, b'0', NULL),
(298, b'1', 43, 2, b'0', NULL),
(299, b'1', 43, 3, b'0', NULL),
(300, b'1', 43, 4, b'0', NULL),
(301, b'1', 43, 5, b'0', NULL),
(302, b'1', 43, 6, b'0', NULL),
(303, b'1', 43, 7, b'0', NULL),
(304, b'1', 43, 8, b'0', NULL),
(305, b'1', 44, 1, b'0', NULL),
(306, b'1', 44, 2, b'0', NULL),
(307, b'1', 44, 3, b'0', NULL),
(308, b'1', 44, 4, b'0', NULL),
(309, b'1', 44, 5, b'0', NULL),
(310, b'1', 44, 6, b'0', NULL),
(311, b'1', 44, 7, b'0', NULL),
(312, b'1', 44, 8, b'0', NULL),
(313, b'1', 45, 1, b'0', NULL),
(314, b'1', 45, 2, b'0', NULL),
(315, b'1', 45, 3, b'0', NULL),
(316, b'1', 45, 4, b'0', NULL),
(317, b'1', 45, 5, b'0', NULL),
(318, b'1', 45, 6, b'0', NULL),
(319, b'1', 45, 7, b'0', NULL),
(320, b'1', 45, 8, b'0', NULL),
(321, b'1', 46, 1, b'0', NULL),
(322, b'1', 46, 2, b'0', NULL),
(323, b'1', 46, 3, b'0', NULL),
(324, b'1', 46, 4, b'0', NULL),
(325, b'1', 46, 5, b'0', NULL),
(326, b'1', 46, 6, b'0', NULL),
(327, b'1', 46, 7, b'0', NULL),
(328, b'1', 46, 8, b'0', NULL),
(329, b'1', 47, 1, b'0', NULL),
(330, b'1', 47, 2, b'0', NULL),
(331, b'1', 47, 3, b'0', NULL),
(332, b'1', 47, 4, b'0', NULL),
(333, b'1', 47, 5, b'0', NULL),
(334, b'1', 47, 6, b'0', NULL),
(335, b'1', 47, 7, b'0', NULL),
(336, b'1', 47, 8, b'0', NULL),
(337, b'1', 48, 1, b'0', NULL),
(338, b'1', 48, 2, b'0', NULL),
(339, b'1', 48, 3, b'0', NULL),
(340, b'1', 48, 4, b'0', NULL),
(341, b'1', 48, 5, b'0', NULL),
(342, b'1', 48, 6, b'0', NULL),
(343, b'1', 48, 7, b'0', NULL),
(344, b'1', 48, 8, b'0', NULL),
(345, b'1', 49, 1, b'0', NULL),
(346, b'1', 49, 2, b'0', NULL),
(347, b'1', 49, 3, b'0', NULL),
(348, b'1', 49, 4, b'0', NULL),
(349, b'1', 49, 5, b'0', NULL),
(350, b'1', 49, 6, b'0', NULL),
(351, b'1', 49, 7, b'0', NULL),
(352, b'1', 49, 8, b'0', NULL),
(353, b'1', 50, 1, b'0', NULL),
(354, b'1', 50, 2, b'0', NULL),
(355, b'1', 50, 3, b'0', NULL),
(356, b'1', 50, 4, b'0', NULL),
(357, b'1', 50, 5, b'0', NULL),
(358, b'1', 50, 6, b'0', NULL),
(359, b'1', 50, 7, b'0', NULL),
(360, b'1', 50, 8, b'0', NULL),
(361, b'1', 51, 1, b'0', NULL),
(362, b'1', 51, 2, b'0', NULL),
(363, b'1', 51, 3, b'0', NULL),
(364, b'1', 51, 4, b'0', NULL),
(365, b'1', 51, 5, b'0', NULL),
(366, b'1', 51, 6, b'0', NULL),
(367, b'1', 51, 7, b'0', NULL),
(368, b'1', 51, 8, b'0', NULL),
(369, b'1', 52, 1, b'0', NULL),
(370, b'1', 52, 2, b'0', NULL),
(371, b'1', 52, 3, b'0', NULL),
(372, b'1', 52, 4, b'0', NULL),
(373, b'1', 52, 5, b'0', NULL),
(374, b'1', 52, 6, b'0', NULL),
(375, b'1', 52, 7, b'0', NULL),
(376, b'1', 52, 8, b'0', NULL),
(377, b'1', 53, 1, b'0', NULL),
(378, b'1', 53, 2, b'0', NULL),
(379, b'1', 53, 3, b'0', NULL),
(380, b'1', 53, 4, b'0', NULL),
(381, b'1', 53, 5, b'0', NULL),
(382, b'1', 53, 6, b'0', NULL),
(383, b'1', 53, 7, b'0', NULL),
(384, b'1', 53, 8, b'0', NULL),
(385, b'1', 54, 1, b'0', NULL),
(386, b'1', 54, 2, b'0', NULL),
(387, b'1', 54, 3, b'0', NULL),
(388, b'1', 54, 4, b'0', NULL),
(389, b'1', 54, 5, b'0', NULL),
(390, b'1', 54, 6, b'0', NULL),
(391, b'1', 54, 7, b'0', NULL),
(392, b'1', 54, 8, b'0', NULL),
(393, b'1', 55, 1, b'0', NULL),
(394, b'1', 55, 2, b'0', NULL),
(395, b'1', 55, 3, b'0', NULL),
(396, b'1', 55, 4, b'0', NULL),
(397, b'1', 55, 5, b'0', NULL),
(398, b'1', 55, 6, b'0', NULL),
(399, b'1', 55, 7, b'0', NULL),
(400, b'1', 55, 8, b'0', NULL),
(401, b'1', 56, 1, b'0', NULL),
(402, b'1', 56, 2, b'0', NULL),
(403, b'1', 56, 3, b'0', NULL),
(404, b'1', 56, 4, b'0', NULL),
(405, b'1', 56, 5, b'0', NULL),
(406, b'1', 56, 6, b'0', NULL),
(407, b'1', 56, 7, b'0', NULL),
(408, b'1', 56, 8, b'0', NULL),
(409, b'1', 57, 1, b'0', NULL),
(410, b'1', 57, 2, b'0', NULL),
(411, b'1', 57, 3, b'0', NULL),
(412, b'1', 57, 4, b'0', NULL),
(413, b'1', 57, 5, b'0', NULL),
(414, b'1', 57, 6, b'0', NULL),
(415, b'1', 57, 7, b'0', NULL),
(416, b'1', 57, 8, b'0', NULL),
(417, b'1', 27, 1, b'0', NULL),
(418, b'1', 27, 2, b'0', NULL),
(419, b'1', 27, 3, b'0', NULL),
(420, b'1', 27, 4, b'0', NULL),
(421, b'1', 27, 5, b'0', NULL),
(422, b'1', 27, 6, b'0', NULL),
(423, b'1', 27, 7, b'0', NULL),
(424, b'1', 27, 8, b'0', NULL),
(425, b'1', 29, 1, b'0', NULL),
(426, b'1', 29, 2, b'0', NULL),
(427, b'1', 29, 3, b'0', NULL),
(428, b'1', 29, 4, b'0', NULL),
(429, b'1', 29, 5, b'0', NULL),
(430, b'1', 29, 6, b'0', NULL),
(431, b'1', 29, 7, b'0', NULL),
(432, b'1', 29, 8, b'0', NULL),
(433, b'0', 22, 1, b'0', NULL),
(434, b'0', 22, 2, b'0', NULL),
(435, b'0', 22, 3, b'0', NULL),
(436, b'0', 22, 4, b'0', NULL),
(437, b'1', 22, 5, b'0', NULL),
(438, b'1', 22, 6, b'0', NULL),
(439, b'1', 22, 7, b'0', NULL),
(440, b'1', 22, 8, b'0', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `agency_message_restriction`
--

DROP TABLE IF EXISTS `agency_message_restriction`;
CREATE TABLE IF NOT EXISTS `agency_message_restriction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpxcryg3w65lapv86nt74qhol` (`agency_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agency_message_restriction`
--

INSERT INTO `agency_message_restriction` (`id`, `message`, `agency_id`) VALUES
(1, 'To be sold in Côte d\'Ivoire your equipment must be configured to operate on the following frequency bands:\r\n\r\n5.250 - 5.350 GHZ\r\n\r\n5.470 - 5.725 GHZ\r\n\r\n5.725 - 5.825 GHZ', 11),
(2, 'To be sold in Nigeria your equipment must be configured to operate on the following frequency bands: 2.400 - 2.4835 GHZ  5.250 - 5.350 GHZ  5.725 5.875 GHZ. Also, the DFS (Dynamic frequency Selection) will be disabled for the 5.4 GHz frequency band', 38);

-- --------------------------------------------------------

--
-- Structure de la table `agency_requirements`
--

DROP TABLE IF EXISTS `agency_requirements`;
CREATE TABLE IF NOT EXISTS `agency_requirements` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_required` bit(1) DEFAULT NULL,
  `agency` bigint(20) DEFAULT NULL,
  `requirements` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKawu8d1ob2nyhbfc9lkhwstaps` (`agency`,`requirements`),
  KEY `FKb89q3r4t6ykx1butfibk7u8yr` (`requirements`)
) ENGINE=MyISAM AUTO_INCREMENT=115 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agency_requirements`
--

INSERT INTO `agency_requirements` (`id`, `is_required`, `agency`, `requirements`) VALUES
(2, b'1', 2, 1),
(3, b'1', 3, 1),
(4, b'1', 4, 1),
(5, b'1', 5, 1),
(6, b'1', 6, 1),
(7, b'1', 7, 1),
(8, b'1', 8, 1),
(9, b'1', 9, 1),
(10, b'1', 10, 1),
(11, b'1', 11, 1),
(12, b'1', 12, 1),
(13, b'1', 13, 1),
(14, b'1', 14, 1),
(15, b'1', 15, 1),
(16, b'1', 16, 1),
(17, b'1', 17, 1),
(18, b'1', 18, 1),
(19, b'1', 19, 1),
(20, b'1', 20, 1),
(21, b'1', 21, 1),
(22, b'1', 22, 1),
(23, b'1', 23, 1),
(24, b'1', 24, 1),
(25, b'1', 25, 1),
(26, b'1', 26, 1),
(27, b'1', 27, 1),
(28, b'1', 28, 1),
(29, b'1', 29, 1),
(30, b'1', 30, 1),
(31, b'1', 31, 1),
(32, b'1', 32, 1),
(33, b'1', 33, 1),
(34, b'1', 34, 1),
(35, b'1', 35, 1),
(36, b'1', 36, 1),
(37, b'1', 37, 1),
(38, b'1', 38, 1),
(39, b'1', 39, 1),
(40, b'1', 40, 1),
(41, b'1', 41, 1),
(42, b'1', 42, 1),
(43, b'1', 43, 1),
(44, b'1', 44, 1),
(45, b'1', 45, 1),
(46, b'1', 46, 1),
(47, b'1', 47, 1),
(48, b'1', 48, 1),
(49, b'1', 49, 1),
(50, b'1', 50, 1),
(51, b'1', 51, 1),
(52, b'1', 52, 1),
(53, b'1', 53, 1),
(54, b'1', 54, 1),
(55, b'1', 55, 1),
(56, b'1', 56, 1),
(57, b'1', 57, 1),
(59, b'1', 2, 2),
(60, b'1', 3, 2),
(61, b'1', 4, 2),
(62, b'1', 5, 2),
(63, b'1', 6, 2),
(64, b'1', 7, 2),
(65, b'1', 8, 2),
(66, b'1', 9, 2),
(67, b'1', 10, 2),
(68, b'1', 11, 2),
(69, b'1', 12, 2),
(70, b'1', 13, 2),
(71, b'1', 14, 2),
(72, b'1', 15, 2),
(73, b'1', 16, 2),
(74, b'1', 17, 2),
(75, b'1', 18, 2),
(76, b'1', 19, 2),
(77, b'1', 20, 2),
(78, b'1', 21, 2),
(79, b'1', 22, 2),
(80, b'1', 23, 2),
(81, b'1', 24, 2),
(82, b'1', 25, 2),
(83, b'1', 26, 2),
(84, b'1', 27, 2),
(85, b'1', 28, 2),
(86, b'1', 29, 2),
(87, b'1', 30, 2),
(88, b'1', 31, 2),
(89, b'1', 32, 2),
(90, b'1', 33, 2),
(91, b'1', 34, 2),
(92, b'1', 35, 2),
(93, b'1', 36, 2),
(94, b'1', 37, 2),
(95, b'1', 38, 2),
(96, b'1', 39, 2),
(97, b'1', 40, 2),
(98, b'1', 41, 2),
(99, b'1', 42, 2),
(100, b'1', 43, 2),
(101, b'1', 44, 2),
(102, b'1', 45, 2),
(103, b'1', 46, 2),
(104, b'1', 47, 2),
(105, b'1', 48, 2),
(106, b'1', 49, 2),
(107, b'1', 50, 2),
(108, b'1', 51, 2),
(109, b'1', 52, 2),
(110, b'1', 53, 2),
(111, b'1', 54, 2),
(112, b'1', 55, 2),
(113, b'1', 56, 2),
(114, b'1', 57, 2);

-- --------------------------------------------------------

--
-- Structure de la table `approval_information`
--

DROP TABLE IF EXISTS `approval_information`;
CREATE TABLE IF NOT EXISTS `approval_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type_approval_information` varchar(31) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `approval_information`
--

INSERT INTO `approval_information` (`id`, `name`, `type_approval_information`) VALUES
(1, 'Accept FCC', 'TechnicalRequirements'),
(2, 'Application form filled by the applicant', 'AdminstrativeRequirements'),
(3, 'Application form filled by the Manufacturer', 'AdminstrativeRequirements'),
(4, 'Certificate validity (months)', 'TechnicalRequirements'),
(5, 'Data sheets on the manufacturer letterhead', 'AdminstrativeRequirements'),
(6, 'Declaration of Conformity (DoC)', 'AdminstrativeRequirements'),
(7, 'Declaration of Conformity (DoC) ( to be translated in French)', 'AdminstrativeRequirements'),
(8, 'Direct Letter Of Authorization (LOA)', 'AdminstrativeRequirements'),
(9, 'Direct Letter Of Authorization (LOA) from the Manufacturer to Consult IT', 'AdminstrativeRequirements'),
(10, 'European Test reports', 'AdminstrativeRequirements'),
(11, 'Family approval', 'TechnicalRequirements'),
(12, 'Label required', 'TechnicalRequirements'),
(13, 'Lead time (weeks).', 'TechnicalRequirements'),
(14, 'Local Certificate Holder Requirement(POA to Consult It)', 'TechnicalRequirements'),
(15, 'Local Representative required', 'TechnicalRequirements'),
(16, 'Manufacturer Business license', 'AdminstrativeRequirements'),
(17, 'Manufacturer Business license (translated in french)', 'AdminstrativeRequirements'),
(18, 'Modular approval', 'TechnicalRequirements'),
(19, 'Name', 'TechnicalRequirements'),
(20, 'Sample', 'TechnicalRequirements'),
(21, 'Test reporting', 'TechnicalRequirements'),
(22, 'User guide', 'TechnicalRequirements'),
(23, 'Lead time', 'TechnicalRequirements'),
(24, 'Certificate validity', 'TechnicalRequirements'),
(25, 'Local Certificate Holder Requirement(Cover letter to agency)', 'TechnicalRequirements');

-- --------------------------------------------------------

--
-- Structure de la table `approval_type`
--

DROP TABLE IF EXISTS `approval_type`;
CREATE TABLE IF NOT EXISTS `approval_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `approval_type`
--

INSERT INTO `approval_type` (`id`, `name`) VALUES
(1, 'Emc'),
(2, 'Safety'),
(3, 'Telecommunications');

-- --------------------------------------------------------

--
-- Structure de la table `category_price`
--

DROP TABLE IF EXISTS `category_price`;
CREATE TABLE IF NOT EXISTS `category_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number_modules` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `regards_the_encryption_function` bit(1) DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1s5c4yufjb8rff0pov5a71n0a` (`agency_id`)
) ENGINE=MyISAM AUTO_INCREMENT=88 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `category_price`
--

INSERT INTO `category_price` (`id`, `name`, `number_modules`, `price`, `regards_the_encryption_function`, `agency_id`) VALUES
(1, 'category algeria', 0, 2000, b'0', 2),
(2, 'category angola', 0, 3000, b'0', 3),
(3, 'category botswana A', 0, 2500, b'0', 5),
(4, 'category botswana B', 0, 5000, b'0', 5),
(5, 'category botswana C', 0, 11000, b'0', 5),
(6, 'category botswana D', 0, 25000, b'0', 5),
(17, 'category ghana c', 0, 1400, b'0', 18),
(16, 'category ghana b', 0, 2600, b'0', 18),
(15, 'category ghana A', 0, 3600, b'0', 18),
(14, 'category burundi B', 0, 3000, b'0', 7),
(13, 'category burundi A', 0, 3500, b'0', 7),
(18, 'category guinee A', 0, 2800, b'0', 19),
(19, 'category guinee b', 0, 2300, b'0', 19),
(20, 'category guinee c', 0, 1400, b'0', 19),
(21, 'category guinee d', 0, 3500, b'0', 19),
(22, 'category guinee e', 0, 2100, b'0', 19),
(23, 'category guinea g', 0, 3266, b'0', 19),
(24, 'category guinea f', 0, 2100, b'0', 19),
(25, 'category niger a', 0, 2300, b'0', 37),
(26, 'category niger b', 0, 8100, b'0', 37),
(27, 'category niger c', 0, 5200, b'0', 37),
(28, 'category niger d', 0, 4100, b'0', 37),
(29, 'category niger e', 0, 2900, b'0', 37),
(30, 'category nigeria 1 module', 1, 3600, b'0', 38),
(31, 'category nigeria 2 module', 2, 8000, b'0', 38),
(32, 'category nigeria 3 module', 3, 9800, b'0', 38),
(33, 'category nigeria smartphone', 0, 9800, b'0', 38),
(34, 'category nigeria tablet', 0, 2600, b'0', 38),
(35, 'category tunisia rf + encryption', 0, 10000, b'1', 55),
(36, 'category tunisia rf only', 0, 3000, b'0', 55),
(37, 'category south africa icasa(RF)', 0, 2600, b'0', 29),
(38, 'category south africa nrcs(safety)', 0, 2600, b'0', 28),
(39, 'category Egypte', 0, 3250, b'0', 13),
(40, 'category', 0, 5890, b'0', 12),
(41, 'category', 0, 3250, b'0', 11),
(42, 'category', 0, 3500, b'0', 10),
(43, 'category', 0, 3600, b'0', 9),
(44, 'category', 0, 3650, b'0', 8),
(45, 'category', 0, 4300, b'0', 6),
(46, 'category', 0, 5890, b'0', 4),
(49, 'category', 0, 3600, b'0', 14),
(50, 'category', 0, 87500, b'0', 15),
(51, 'category', 0, 3600, b'0', 16),
(52, 'category', 0, 58900, b'0', 17),
(53, 'category', 0, 10250, b'0', 20),
(54, 'category', 0, 3250, b'0', 21),
(55, 'category', 0, 4300, b'0', 22),
(56, 'category', 0, 4300, b'0', 23),
(57, 'category', 0, 3000, b'0', 24),
(58, 'category', 0, 5400, b'0', 25),
(59, 'category', 0, 5890, b'0', 26),
(60, 'category', 0, 3250, b'0', 27),
(61, 'category', 0, 4300, b'0', 31),
(62, 'category', 0, 3100, b'0', 32),
(63, 'category', 0, 2600, b'0', 33),
(64, 'category', 0, 5890, b'0', 36),
(65, 'category', 0, 3250, b'0', 37),
(66, 'category', 0, 8700, b'0', 38),
(67, 'category', 0, 4300, b'0', 39),
(68, 'category', 0, 7800, b'0', 40),
(69, 'category', 0, 7800, b'0', 41),
(70, 'category', 0, 5890, b'0', 42),
(71, 'category', 0, 3250, b'0', 43),
(72, 'category', 0, 7800, b'0', 44),
(73, 'category', 0, 4300, b'0', 45),
(74, 'category', 0, 3250, b'0', 46),
(75, 'category', 0, 5890, b'0', 47),
(76, 'category', 0, 3250, b'0', 48),
(77, 'category', 0, 7800, b'0', 49),
(78, 'category', 0, 3250, b'0', 50),
(79, 'category', 0, 2500, NULL, 51),
(80, 'category', 0, 5822, NULL, 52),
(81, 'category', 0, 3200, b'0', 53),
(82, 'category', 0, 3250, b'0', 54),
(84, 'category', 0, 1150, b'0', 56),
(85, 'category', 0, 3600, b'0', 57),
(86, 'category mauritania', 0, 3250, b'0', 34),
(87, 'category mozambique', 0, 2600, b'0', 35);

-- --------------------------------------------------------

--
-- Structure de la table `category_price_equipement_types`
--

DROP TABLE IF EXISTS `category_price_equipement_types`;
CREATE TABLE IF NOT EXISTS `category_price_equipement_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_price_id` bigint(20) DEFAULT NULL,
  `equipment_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKs2pu9iy2f6vlog8rekbiqgfdk` (`category_price_id`,`equipment_type_id`),
  KEY `FKnqvdvot2eq1sb8m9bt2k6ftn3` (`equipment_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `category_price_equipement_types`
--

INSERT INTO `category_price_equipement_types` (`id`, `category_price_id`, `equipment_type_id`) VALUES
(1, 3, 8),
(2, 3, 7),
(3, 4, 9),
(4, 4, 10),
(5, 4, 11),
(6, 4, 12),
(7, 4, 13),
(8, 4, 18),
(9, 4, 14),
(10, 4, 15),
(11, 4, 16),
(12, 4, 17),
(13, 5, 19),
(14, 5, 20),
(15, 5, 21),
(16, 5, 22),
(17, 5, 23),
(18, 5, 24),
(19, 5, 25),
(20, 6, 26),
(21, 6, 27),
(22, 6, 28),
(23, 6, 29),
(24, 6, 30),
(25, 14, 39),
(26, 14, 38),
(27, 14, 37),
(28, 14, 36),
(29, 13, 35),
(30, 13, 34),
(31, 13, 33),
(32, 13, 32),
(33, 13, 31),
(34, 14, 40),
(35, 14, 41),
(36, 14, 42),
(37, 15, 43),
(38, 15, 44),
(39, 15, 45),
(40, 15, 46),
(41, 16, 47),
(42, 16, 48),
(43, 17, 44),
(44, 17, 50),
(45, 17, 51),
(46, 17, 52),
(47, 17, 53),
(48, 18, 45),
(49, 18, 53),
(50, 19, 53),
(51, 19, 55),
(52, 25, 12),
(53, 25, 56),
(54, 26, 56),
(55, 26, 57),
(56, 33, 59),
(57, 34, 60);

-- --------------------------------------------------------

--
-- Structure de la table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_llidyp77h6xkeokpbmoy710d4` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=1874 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `country`
--

INSERT INTO `country` (`id`, `name`) VALUES
(32, 'Mozambique'),
(31, 'Mauritania'),
(30, 'Maurice'),
(29, 'Morroco'),
(28, 'Mali'),
(27, 'Malawi'),
(26, 'Madagascar'),
(25, 'Libya'),
(24, 'Liberia'),
(23, 'Lesotho'),
(22, 'Kenya'),
(21, 'Bissau Guinea'),
(20, 'Equatoriale Guinea'),
(19, 'Guinea'),
(18, 'Ghana'),
(17, 'Gambia'),
(16, 'Gabon '),
(15, 'Ethiopia'),
(14, 'Erythree'),
(13, 'Egypt'),
(12, 'Djibouti'),
(11, 'Cote d’Ivoire'),
(10, 'Comores'),
(9, 'Cape Verde'),
(8, 'Cameroon'),
(7, 'Burundi'),
(6, 'Burkina Faso'),
(5, 'Botswana'),
(4, 'Benin'),
(3, 'Angola'),
(2, 'Algeria'),
(1, 'South Africa'),
(33, 'Namibia'),
(34, 'Niger'),
(35, 'Nigeria'),
(36, 'Uganda'),
(37, 'Centrafrican Republic '),
(38, 'Republic of Congo'),
(39, 'RDC'),
(40, 'Rwanda'),
(41, 'Sao Tome Principe'),
(42, 'Senegal'),
(43, 'Chad'),
(44, 'Seychelles '),
(45, 'Sierra Leone'),
(46, 'Somalia'),
(47, 'Sudan'),
(48, 'South Sudan'),
(49, 'Swaziland'),
(50, 'Tanzania'),
(51, 'Togo'),
(52, 'Tunisia'),
(53, 'Zambia'),
(54, 'Zimbabwe');

-- --------------------------------------------------------

--
-- Structure de la table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE IF NOT EXISTS `equipment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `is_encrypt` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=83 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `equipment`
--

INSERT INTO `equipment` (`id`, `brand`, `is_encrypt`, `name`, `model`) VALUES
(6, 'bn', NULL, 'hg', 'vv'),
(5, 'bn', NULL, 'hg', 'vv'),
(7, NULL, NULL, NULL, NULL),
(8, 'c', NULL, 'c', 'c'),
(9, NULL, NULL, NULL, NULL),
(10, 'zv', NULL, 'ab', 'ag'),
(11, 'zv', NULL, 'ab', 'ag'),
(12, 'h', NULL, 'h', 'h'),
(13, 'h', NULL, 'h', 'h'),
(14, 'h', NULL, 'h', 'h'),
(15, 'f', NULL, 'd', 's'),
(16, 'dgg', NULL, 'sd', 'fg'),
(17, 'hg', NULL, 'hy', 'hj'),
(18, 'f', NULL, 'f', 'f'),
(19, 'f', NULL, 'f', 'f'),
(20, 'd', NULL, 'ci', 'abd'),
(21, 'z', NULL, 'gile', 'j'),
(22, '25', NULL, '25', 'hg'),
(23, '52', NULL, 'gb', '21'),
(24, 'vf', NULL, 'c', 'cisse'),
(25, 'vf', NULL, 'c', 'cisse'),
(26, 'vf', NULL, 'c', 'cisse'),
(27, 'vf', NULL, 'c', 'cisse'),
(28, 'vf', NULL, 'c', 'cisse'),
(29, 'fg', NULL, 'fg', 'fg'),
(30, 'fg', NULL, 'fg', 'fg'),
(31, 'fg', NULL, 'fg', 'fg'),
(32, 'sd', NULL, 'fv', 'fg'),
(33, 'sd', NULL, 'fv', 'fg'),
(34, 'dfd', NULL, 'dfd', 'fd'),
(35, 'dfd', NULL, 'dfd', 'fd'),
(36, 'dfd', NULL, 'dfd', 'fd'),
(37, 'dfd', NULL, 'dfd', 'fd'),
(38, 'dfd', NULL, 'dfd', 'fd'),
(39, 'dfd', NULL, 'dfd', 'fd'),
(40, 'dfd', NULL, 'dfd', 'fd'),
(41, 'hyj', NULL, 'df', 'gfg'),
(42, '2', NULL, 'title', 'enum'),
(43, '2', NULL, 'title', 'enum'),
(44, '2', NULL, 'title', 'enum'),
(45, 'test brand', NULL, 'test', 'test model'),
(46, 'test brand', NULL, 'test', 'test model'),
(47, 'test brand', NULL, 'test', 'test model'),
(48, NULL, NULL, NULL, NULL),
(49, 'test', NULL, 'test', 'test'),
(50, 'yut', NULL, 'trut', 'tuu'),
(51, NULL, NULL, NULL, NULL),
(52, 't', NULL, 't', 't'),
(53, '1', NULL, '1', '2'),
(54, '1', NULL, '1', '2'),
(55, '1', NULL, '1', '2'),
(56, '1', NULL, '1', '2'),
(57, '1', NULL, '1', '2'),
(58, '1', NULL, '1', '2'),
(59, '1', NULL, '1', '2'),
(60, '1', NULL, '1', '2'),
(61, '1', NULL, '1', '2'),
(62, '1', NULL, '1', '2'),
(63, '1', NULL, '1', '2'),
(64, '1', NULL, '1', '2'),
(65, '1', NULL, '1', '2'),
(66, NULL, NULL, NULL, NULL),
(67, '1', NULL, '1', '2'),
(68, NULL, NULL, NULL, NULL),
(69, NULL, NULL, NULL, NULL),
(70, NULL, NULL, NULL, NULL),
(71, NULL, NULL, NULL, NULL),
(72, NULL, NULL, NULL, NULL),
(73, NULL, NULL, NULL, NULL),
(74, NULL, NULL, NULL, NULL),
(75, NULL, NULL, NULL, NULL),
(76, NULL, NULL, NULL, NULL),
(77, NULL, NULL, NULL, NULL),
(78, NULL, NULL, NULL, NULL),
(79, NULL, NULL, NULL, NULL),
(80, NULL, NULL, NULL, NULL),
(81, NULL, NULL, NULL, NULL),
(82, 'g', NULL, 'gt', 'g');

-- --------------------------------------------------------

--
-- Structure de la table `equipment_nature`
--

DROP TABLE IF EXISTS `equipment_nature`;
CREATE TABLE IF NOT EXISTS `equipment_nature` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `approval_type_id` bigint(20) DEFAULT NULL,
  `has_frequency` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgiefjp9ndfl3xmo8t628r0bmt` (`approval_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `equipment_nature`
--

INSERT INTO `equipment_nature` (`id`, `name`, `approval_type_id`, `has_frequency`) VALUES
(1, 'Radio frequency', 3, b'1'),
(2, 'Non Radio Frequency', 3, b'0');

-- --------------------------------------------------------

--
-- Structure de la table `equipment_technologie`
--

DROP TABLE IF EXISTS `equipment_technologie`;
CREATE TABLE IF NOT EXISTS `equipment_technologie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `equipment_nature_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnhxcr5o5r1sqkqri25posc86c` (`equipment_nature_id`)
) ENGINE=MyISAM AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `equipment_technologie`
--

INSERT INTO `equipment_technologie` (`id`, `name`, `equipment_nature_id`) VALUES
(1, 'GSM/IMT-2000', 2),
(46, 'Switching and Signaling Systems', 1),
(2, 'Wimax', 2),
(3, 'Tetra', 2),
(4, 'Dect', 2),
(5, 'Satellite', 2),
(6, 'Two-way radio transceiver', 2),
(7, 'Point-to-multipoint link', 2),
(8, 'Point-to-point link', 2),
(9, 'Receiver only', 2),
(10, 'Repeater', 2),
(11, 'Rlan(Wlan)', 2),
(12, 'RFID', 2),
(13, 'LTE', 2),
(14, 'SRD', 2),
(15, 'Model control', 2),
(16, 'Wideband wireless systems', 2),
(17, 'Wireless microphones', 2),
(18, 'Paging systems', 2),
(19, 'Broadcoast', 2),
(20, 'Inductive loop system', 2),
(21, 'Smart Metering', 2),
(22, 'Telecontrol, Telemetering', 2),
(23, 'Monitoring equipement', 2),
(24, 'Measuring equipment', 2),
(25, 'Passive component', 2),
(26, 'Amplifiers', 2),
(27, 'LPVS', 2),
(28, 'AVI', 2),
(29, 'RTTT', 2),
(30, 'FDDA', 2),
(45, 'Soft Switch', 1),
(44, 'E1', 1),
(43, 'DECT', 1),
(42, 'Transmission systems', 1),
(31, 'Wireless microphones', 1),
(47, 'ISDN BRI', 1),
(48, 'VOIP systems', 1),
(49, 'International Gateway', 1),
(50, 'Telephone Networks', 1),
(51, 'ISDN PRI', 1),
(52, 'Measuring Equipement', 1),
(53, 'Copper Transmission', 1),
(54, 'Data Communication Networks', 1),
(55, 'ADSL', 1),
(56, 'Lines connections and circuits', 1),
(57, 'DVB', 1),
(58, 'Powerline Telecommunication', 1),
(59, 'PSTN', 1),
(60, 'Fibre optic', 1),
(61, 'Audio Visual systems', 1),
(62, 'Telex, Teletext, telefax', 1),
(63, 'Telephone Equipement', 1),
(64, 'Copper', 1);

-- --------------------------------------------------------

--
-- Structure de la table `equipment_type`
--

DROP TABLE IF EXISTS `equipment_type`;
CREATE TABLE IF NOT EXISTS `equipment_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `equipment_type`
--

INSERT INTO `equipment_type` (`id`, `name`) VALUES
(9, 'Alarm systems'),
(8, 'Low power Devices'),
(7, 'Cellular phones'),
(10, 'Answering Machines'),
(11, 'Basic telephone'),
(12, 'Cordless phone'),
(13, 'Data modems(incl. switches,routers)'),
(14, 'Wireless microphones'),
(15, 'Basic routers'),
(16, 'Faxes'),
(17, 'Wireless terminals'),
(18, 'Dtt set- top-box receivers'),
(19, 'PABX with 24-47 ports'),
(20, 'Vsat terminal'),
(21, 'Multiplex equipment (voice and data)'),
(22, 'Radio interface equipment'),
(23, 'Radio transmitters (incl broadcoasting)'),
(24, 'Pabx with less than 24 ports'),
(25, 'Switch with less than 24 ports'),
(26, 'Pabx with 48 -127 ports'),
(27, 'Pabx with 128 -255'),
(28, 'Pabx with 256 and more'),
(29, 'Satellite earth station'),
(30, 'Vsat terminal'),
(31, 'Téléphone DECT'),
(32, 'Terminal RNIS'),
(33, 'Modem ADSL'),
(34, 'Terminaux faible puissance et portée'),
(35, 'Modem FAX'),
(36, 'Routeur point d’accès Wireless'),
(37, 'Routeur Wireless'),
(38, 'Radio téléphonie fixe'),
(39, 'Radio mobile terrestre'),
(40, 'Radio HF/VHF/UHF marine'),
(41, 'Terminal GSM/DCS/PCS etc.'),
(42, 'Terminal WIMAX'),
(43, 'Routers'),
(44, 'Switches'),
(45, 'Modems'),
(46, 'PBX'),
(47, 'Microwave'),
(48, 'VSAT Transceivers'),
(54, 'Station terrienne'),
(50, 'Media gateways'),
(51, 'PSTN '),
(52, 'BSCs'),
(53, 'MSCs'),
(55, 'Cable a fibre optique'),
(56, 'Srd'),
(57, 'PABX accessories'),
(58, 'GPS divices'),
(59, 'Smartphone'),
(60, 'Tablet');

-- --------------------------------------------------------

--
-- Structure de la table `frequency_band`
--

DROP TABLE IF EXISTS `frequency_band`;
CREATE TABLE IF NOT EXISTS `frequency_band` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `max_frequency` int(11) DEFAULT NULL,
  `min_frequency` int(11) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `frequency_band`
--

INSERT INTO `frequency_band` (`id`, `max_frequency`, `min_frequency`, `unit`) VALUES
(1, 30, 9, 'MHz'),
(2, 390, 30, 'MHz'),
(3, 890, 390, 'MHz'),
(4, 3000, 890, 'MHz'),
(5, 10, 3, 'GHz'),
(6, 20, 10, 'GHz'),
(7, 40, 20, 'GHz'),
(8, NULL, 40, 'GHz');

-- --------------------------------------------------------

--
-- Structure de la table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `total_amount` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `purchase_order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpbnhtmx9crcudpxcr5j2xjool` (`purchase_order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `invoice`
--

INSERT INTO `invoice` (`id`, `total_amount`, `date`, `purchase_order_id`) VALUES
(1, 4500, '2018-01-04', 45),
(2, 4000, '2018-01-09', 47),
(3, 16000, '2018-01-12', 48),
(4, 8000, '2018-01-12', 49),
(5, 4500, '2018-01-12', 50),
(6, 4500, '2018-01-12', 51),
(7, 4500, '2018-01-12', 52),
(8, 4000, '2018-01-12', 53),
(9, 6000, '2018-01-12', 54),
(10, 6000, '2018-01-12', 55),
(11, 8000, '2018-01-12', 56),
(12, 5500, '2018-01-12', 57),
(13, 2500, '2018-01-12', 58),
(14, 8000, '2018-01-12', 59),
(15, 500, '2018-01-12', 60),
(16, 4500, '2018-01-12', 61),
(17, 4500, '2018-01-12', 62),
(18, 1500, '2018-01-12', 63),
(19, 1500, '2018-01-12', 64),
(20, 1500, '2018-01-12', 65),
(21, 10000, '2018-01-12', 66),
(22, 14000, '2018-01-19', 67),
(23, 14000, '2018-01-19', 68),
(24, 14000, '2018-01-19', 69),
(25, NULL, '2018-01-26', 70),
(26, NULL, '2018-01-26', 71),
(27, NULL, '2018-01-26', 72),
(28, NULL, '2018-01-26', 73),
(29, NULL, '2018-01-26', 74),
(30, NULL, '2018-01-27', 75),
(31, NULL, '2018-01-28', 76),
(32, 187052, '2018-01-06', 77),
(33, 382342, '2018-01-07', 78),
(34, 382342, '2018-01-07', 79),
(35, 382342, '2018-01-07', 80),
(36, 382342, '2018-01-07', 81),
(37, 382342, '2018-01-07', 82),
(38, 382342, '2018-01-07', 83),
(39, 382342, '2018-01-07', 84),
(40, 382342, '2018-01-07', 85),
(41, 382342, '2018-01-07', 86),
(42, 382342, '2018-01-07', 87),
(43, 382342, '2018-01-07', 88),
(44, 382342, '2018-01-07', 89),
(45, 382342, '2018-01-07', 90),
(46, 0, '2018-01-07', 91),
(47, 382342, '2018-01-07', 92),
(48, 0, '2018-01-07', 93),
(49, 0, '2018-01-07', 94),
(50, 0, '2018-01-07', 95),
(51, 0, '2018-01-07', 96),
(52, 0, '2018-01-07', 97),
(53, 0, '2018-01-07', 98),
(54, 0, '2018-01-07', 99),
(55, 0, '2018-01-07', 100),
(56, 0, '2018-01-07', 101),
(57, 0, '2018-01-07', 102),
(58, 0, '2018-01-07', 103),
(59, 0, '2018-01-07', 104),
(60, 0, '2018-01-07', 105),
(61, 0, '2018-01-07', 106),
(62, 14140, '2018-01-08', 107);

-- --------------------------------------------------------

--
-- Structure de la table `price_criteria`
--

DROP TABLE IF EXISTS `price_criteria`;
CREATE TABLE IF NOT EXISTS `price_criteria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `price_criteria`
--

INSERT INTO `price_criteria` (`id`, `name`) VALUES
(1, 'Equipment Type'),
(2, 'Encryption Feature'),
(0, 'no criteria'),
(3, 'number of module');

-- --------------------------------------------------------

--
-- Structure de la table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `equipment_id` bigint(20) DEFAULT NULL,
  `purchase_order_id` bigint(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo7wti3q1fswj0os6lha1ncvhw` (`country_id`),
  KEY `FKlfvrutjaiykh8rbkfnj5wxc9k` (`agency_id`),
  KEY `FKpx3kxe8i0g71irwvts73y9ihl` (`equipment_id`),
  KEY `FK2r2i9a1aci6u3sx862iqsyc51` (`purchase_order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=131 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `project`
--

INSERT INTO `project` (`id`, `date`, `country_id`, `equipment_id`, `purchase_order_id`, `price`, `agency_id`) VALUES
(1, '2018-01-04', 13, 11, 35, NULL, NULL),
(2, '2018-01-04', 9, 11, 35, NULL, NULL),
(3, '2018-01-04', 29, 11, 35, NULL, NULL),
(4, '2018-01-04', 33, 11, 35, NULL, NULL),
(5, '2018-01-04', 12, 12, 36, NULL, NULL),
(6, '2018-01-04', 13, 12, 36, NULL, NULL),
(7, '2018-01-04', 12, 13, 37, NULL, NULL),
(8, '2018-01-04', 13, 13, 37, NULL, NULL),
(9, '2018-01-04', 12, 14, 38, NULL, NULL),
(10, '2018-01-04', 13, 14, 38, NULL, NULL),
(11, '2018-01-04', 6, 15, 39, NULL, NULL),
(12, '2018-01-04', 2, 15, 39, NULL, NULL),
(13, '2018-01-04', 16, 15, 39, NULL, NULL),
(14, '2018-01-04', 12, 16, 40, NULL, NULL),
(15, '2018-01-04', 5, 16, 40, NULL, NULL),
(16, '2018-01-04', 8, 16, 40, NULL, NULL),
(17, '2018-01-04', 3, 17, 41, NULL, NULL),
(18, '2018-01-04', 13, 17, 41, NULL, NULL),
(19, '2018-01-04', 9, 17, 41, NULL, NULL),
(20, '2018-01-04', 8, 17, 41, NULL, NULL),
(21, '2018-01-04', 12, 17, 41, NULL, NULL),
(22, '2018-01-04', 12, 18, 42, NULL, NULL),
(23, '2018-01-04', 5, 18, 42, NULL, NULL),
(24, '2018-01-04', 7, 18, 42, NULL, NULL),
(25, '2018-01-04', 12, 19, 43, NULL, NULL),
(26, '2018-01-04', 5, 19, 43, NULL, NULL),
(27, '2018-01-04', 7, 19, 43, NULL, NULL),
(28, '2018-01-04', 32, 19, 43, NULL, NULL),
(29, '2018-01-04', 28, 19, 43, NULL, NULL),
(30, '2018-01-04', 24, 19, 43, NULL, NULL),
(31, '2018-01-04', 13, 19, 43, NULL, NULL),
(32, '2018-01-04', 17, 19, 43, NULL, NULL),
(33, '2018-01-04', 21, 19, 43, NULL, NULL),
(34, '2018-01-04', 18, 20, 44, NULL, NULL),
(35, '2018-01-04', 14, 20, 44, NULL, NULL),
(36, '2018-01-04', 5, 20, 44, NULL, NULL),
(37, '2018-01-04', 13, 21, 45, NULL, NULL),
(38, '2018-01-04', 9, 21, 45, NULL, NULL),
(39, '2018-01-09', 15, 22, 47, NULL, NULL),
(40, '2018-01-09', 19, 22, 47, NULL, NULL),
(41, '2018-01-12', 13, 23, 48, NULL, NULL),
(42, '2018-01-12', 9, 23, 48, NULL, NULL),
(43, '2018-01-12', 3, 23, 48, NULL, NULL),
(44, '2018-01-12', 12, 23, 48, NULL, NULL),
(45, '2018-01-12', 8, 23, 48, NULL, NULL),
(46, '2018-01-12', 5, 23, 48, NULL, NULL),
(47, '2018-01-12', 13, 24, 49, NULL, NULL),
(48, '2018-01-12', 9, 24, 49, NULL, NULL),
(49, '2018-01-12', 3, 24, 49, NULL, NULL),
(50, '2018-01-12', 12, 25, 50, NULL, NULL),
(51, '2018-01-12', 8, 25, 50, NULL, NULL),
(52, '2018-01-12', 12, 26, 51, NULL, NULL),
(53, '2018-01-12', 8, 26, 51, NULL, NULL),
(54, '2018-01-12', 9, 27, 52, NULL, NULL),
(55, '2018-01-12', 13, 27, 52, NULL, NULL),
(56, '2018-01-12', 14, 28, 53, NULL, NULL),
(57, '2018-01-12', 18, 28, 53, NULL, NULL),
(58, '2018-01-12', 5, 29, 54, NULL, NULL),
(59, '2018-01-12', 14, 29, 54, NULL, NULL),
(60, '2018-01-12', 5, 30, 55, NULL, NULL),
(61, '2018-01-12', 14, 30, 55, NULL, NULL),
(62, '2018-01-12', 12, 31, 56, NULL, NULL),
(63, '2018-01-12', 8, 31, 56, NULL, NULL),
(64, '2018-01-12', 5, 31, 56, NULL, NULL),
(65, '2018-01-12', 5, 32, 57, NULL, NULL),
(66, '2018-01-12', 8, 32, 57, NULL, NULL),
(67, '2018-01-12', 13, 33, 58, NULL, NULL),
(68, '2018-01-12', 12, 34, 59, NULL, NULL),
(69, '2018-01-12', 8, 34, 59, NULL, NULL),
(70, '2018-01-12', 5, 34, 59, NULL, NULL),
(71, '2018-01-12', 1, 35, 60, NULL, NULL),
(72, '2018-01-12', 13, 36, 61, NULL, NULL),
(73, '2018-01-12', 9, 36, 61, NULL, NULL),
(74, '2018-01-12', 13, 37, 62, NULL, NULL),
(75, '2018-01-12', 9, 37, 62, NULL, NULL),
(76, '2018-01-12', 25, 38, 63, NULL, NULL),
(77, '2018-01-12', 29, 38, 63, NULL, NULL),
(78, '2018-01-12', 25, 39, 64, NULL, NULL),
(79, '2018-01-12', 29, 39, 64, NULL, NULL),
(80, '2018-01-12', 25, 40, 65, NULL, NULL),
(81, '2018-01-12', 29, 40, 65, NULL, NULL),
(82, '2018-01-12', 14, 41, 66, NULL, NULL),
(83, '2018-01-12', 5, 41, 66, NULL, NULL),
(84, '2018-01-12', 11, 41, 66, NULL, NULL),
(85, '2018-01-12', 7, 41, 66, NULL, NULL),
(86, '2018-01-19', 13, 42, 67, NULL, NULL),
(87, '2018-01-19', 9, 42, 67, NULL, NULL),
(88, '2018-01-19', 12, 42, 67, NULL, NULL),
(89, '2018-01-19', 7, 42, 67, NULL, NULL),
(90, '2018-01-19', 4, 42, 67, NULL, NULL),
(91, '2018-01-19', 16, 42, 67, NULL, NULL),
(92, '2018-01-19', 13, 43, 68, NULL, NULL),
(93, '2018-01-19', 9, 43, 68, NULL, NULL),
(94, '2018-01-19', 12, 43, 68, NULL, NULL),
(95, '2018-01-19', 7, 43, 68, NULL, NULL),
(96, '2018-01-19', 4, 43, 68, NULL, NULL),
(97, '2018-01-19', 16, 43, 68, NULL, NULL),
(98, '2018-01-19', 13, 44, 69, NULL, NULL),
(99, '2018-01-19', 9, 44, 69, NULL, NULL),
(100, '2018-01-19', 12, 44, 69, NULL, NULL),
(101, '2018-01-19', 7, 44, 69, NULL, NULL),
(102, '2018-01-19', 4, 44, 69, NULL, NULL),
(103, '2018-01-19', 16, 44, 69, NULL, NULL),
(104, '2018-01-26', 9, 45, 70, NULL, NULL),
(105, '2018-01-26', 5, 45, 70, NULL, NULL),
(106, '2018-01-26', 9, 46, 71, NULL, NULL),
(107, '2018-01-26', 5, 46, 71, NULL, NULL),
(108, '2018-01-26', 9, 47, 72, NULL, NULL),
(109, '2018-01-26', 5, 47, 72, NULL, NULL),
(110, '2018-01-26', 3, 49, 74, NULL, NULL),
(111, '2018-01-26', 6, 49, 74, NULL, NULL),
(112, '2018-01-06', 49, 52, 77, NULL, NULL),
(113, '2018-01-07', NULL, 59, 84, NULL, 51),
(114, '2018-01-07', NULL, 59, 84, NULL, 53),
(115, '2018-01-07', NULL, 60, 85, NULL, 51),
(116, '2018-01-07', NULL, 61, 86, NULL, 51),
(117, '2018-01-07', NULL, 62, 87, NULL, 51),
(118, '2018-01-07', NULL, 62, 87, NULL, 53),
(119, '2018-01-07', NULL, 63, 88, NULL, 51),
(120, '2018-01-07', NULL, 63, 88, NULL, 53),
(121, '2018-01-07', NULL, 64, 89, NULL, 51),
(122, '2018-01-07', NULL, 64, 89, NULL, 53),
(123, '2018-01-07', NULL, 65, 90, NULL, 51),
(124, '2018-01-07', NULL, 65, 90, NULL, 53),
(125, '2018-01-07', NULL, 67, 92, NULL, 51),
(126, '2018-01-07', NULL, 67, 92, NULL, 53),
(127, '2018-01-08', NULL, 82, 107, NULL, 2),
(128, '2018-01-08', NULL, 82, 107, NULL, 3),
(129, '2018-01-08', NULL, 82, 107, NULL, 4),
(130, '2018-01-08', NULL, 82, 107, NULL, 21);

-- --------------------------------------------------------

--
-- Structure de la table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE IF NOT EXISTS `purchase_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `quotation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK264mq9l1u99cn67a1dypssv6d` (`quotation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=108 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `purchase_order`
--

INSERT INTO `purchase_order` (`id`, `date`, `total_amount`, `quotation_id`) VALUES
(30, '2018-01-02', NULL, 98),
(29, '2018-01-02', NULL, 97),
(31, '2018-01-04', NULL, 99),
(32, '2018-01-04', NULL, 100),
(33, '2018-01-04', NULL, 101),
(34, '2018-01-04', NULL, 102),
(35, '2018-01-04', NULL, 103),
(36, '2018-01-04', NULL, 104),
(37, '2018-01-04', NULL, 105),
(38, '2018-01-04', NULL, 106),
(39, '2018-01-04', NULL, 107),
(40, '2018-01-04', NULL, 108),
(41, '2018-01-04', 12500, 109),
(42, '2018-01-04', 8000, 110),
(43, '2018-01-04', 19500, 111),
(44, '2018-01-04', 7500, 112),
(45, '2018-01-04', 4500, 113),
(46, '2018-01-09', NULL, NULL),
(47, '2018-01-09', 4000, 153),
(48, '2018-01-12', 16000, 154),
(49, '2018-01-12', 8000, 155),
(50, '2018-01-12', 4500, 156),
(51, '2018-01-12', 4500, 157),
(52, '2018-01-12', 4500, 158),
(53, '2018-01-12', 4000, 159),
(54, '2018-01-12', 6000, 160),
(55, '2018-01-12', 6000, 161),
(56, '2018-01-12', 8000, 162),
(57, '2018-01-12', 5500, 163),
(58, '2018-01-12', 2500, 164),
(59, '2018-01-12', 8000, 165),
(60, '2018-01-12', 500, 166),
(61, '2018-01-12', 4500, 167),
(62, '2018-01-12', 4500, 168),
(63, '2018-01-12', 1500, 170),
(64, '2018-01-12', 1500, 171),
(65, '2018-01-12', 1500, 172),
(66, '2018-01-12', 10000, 173),
(67, '2018-01-19', 14000, 174),
(68, '2018-01-19', 14000, 175),
(69, '2018-01-19', 14000, 176),
(70, '2018-01-26', NULL, 180),
(71, '2018-01-26', NULL, 181),
(72, '2018-01-26', NULL, 182),
(73, '2018-01-26', NULL, 183),
(74, '2018-01-26', NULL, 184),
(75, '2018-01-27', NULL, 185),
(76, '2018-01-28', NULL, 196),
(77, '2018-01-06', 187052, 4),
(78, '2018-01-07', 382342, 2),
(79, '2018-01-07', 382342, 2),
(80, '2018-01-07', 382342, 2),
(81, '2018-01-07', 382342, 2),
(82, '2018-01-07', 382342, 2),
(83, '2018-01-07', 382342, 2),
(84, '2018-01-07', 382342, 2),
(85, '2018-01-07', 382342, 2),
(86, '2018-01-07', 382342, 2),
(87, '2018-01-07', 382342, 2),
(88, '2018-01-07', 382342, 2),
(89, '2018-01-07', 382342, 2),
(90, '2018-01-07', 382342, 2),
(91, '2018-01-07', 0, 6),
(92, '2018-01-07', 382342, 2),
(93, '2018-01-07', 0, 7),
(94, '2018-01-07', 0, 8),
(95, '2018-01-07', 0, 9),
(96, '2018-01-07', 0, 10),
(97, '2018-01-07', 0, 11),
(98, '2018-01-07', 0, 12),
(99, '2018-01-07', 0, 13),
(100, '2018-01-07', 0, 14),
(101, '2018-01-07', 0, 15),
(102, '2018-01-07', 0, 16),
(103, '2018-01-07', 0, 17),
(104, '2018-01-07', 0, 18),
(105, '2018-01-07', 0, 19),
(106, '2018-01-07', 0, 20),
(107, '2018-01-08', 14140, 21);

-- --------------------------------------------------------

--
-- Structure de la table `quotation`
--

DROP TABLE IF EXISTS `quotation`;
CREATE TABLE IF NOT EXISTS `quotation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reference` varchar(255) DEFAULT NULL,
  `data_sheet_url` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `has_encryption_feature` bit(1) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `approval_type_id` bigint(20) DEFAULT NULL,
  `equipment_nature_id` bigint(20) DEFAULT NULL,
  `equipment_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_el2ivjtfn6ltss2o5fera7myl` (`number`),
  KEY `FK57xvoem5kp6fmif9ikxecmoph` (`approval_type_id`),
  KEY `FKm12t84492qkl4qmu1hri07xcc` (`equipment_nature_id`),
  KEY `FK39osx05dq5a2wv61nacu2eidg` (`equipment_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `quotation`
--

INSERT INTO `quotation` (`id`, `reference`, `data_sheet_url`, `date`, `has_encryption_feature`, `number`, `status`, `total_amount`, `approval_type_id`, `equipment_nature_id`, `equipment_type_id`) VALUES
(1, NULL, NULL, '2018-01-04', b'1', 'QUOT1803043', 0, 2000, 3, 1, 33),
(2, NULL, NULL, '2018-01-07', b'1', 'QUOT1803054', 1, 382342, 3, 1, 9),
(3, NULL, NULL, '2018-01-05', b'0', 'QUOT1803055', 0, 152000, 3, 1, 9),
(4, NULL, NULL, '2018-01-06', b'1', 'QUOT1803056', 1, 187052, 3, 1, 35),
(5, NULL, NULL, '2018-01-05', b'1', 'QUOT1803057', 0, 23650, 3, 1, 35),
(6, NULL, NULL, '2018-01-07', NULL, 'QUOT1803078', 1, 0, NULL, NULL, NULL),
(7, NULL, NULL, '2018-01-07', NULL, 'QUOT1803079', 1, 0, NULL, NULL, NULL),
(8, NULL, NULL, '2018-01-07', NULL, 'QUOT18030710', 1, 0, NULL, NULL, NULL),
(9, NULL, NULL, '2018-01-07', NULL, 'QUOT18030711', 1, 0, NULL, NULL, NULL),
(10, NULL, NULL, '2018-01-07', NULL, 'QUOT18030712', 1, 0, NULL, NULL, NULL),
(11, NULL, NULL, '2018-01-07', NULL, 'QUOT18030713', 1, 0, NULL, NULL, NULL),
(12, NULL, NULL, '2018-01-07', NULL, 'QUOT18030714', 1, 0, NULL, NULL, NULL),
(13, NULL, NULL, '2018-01-07', NULL, 'QUOT18030715', 1, 0, NULL, NULL, NULL),
(14, NULL, NULL, '2018-01-07', NULL, 'QUOT18030716', 1, 0, NULL, NULL, NULL),
(15, NULL, NULL, '2018-01-07', NULL, 'QUOT18030717', 1, 0, NULL, NULL, NULL),
(16, NULL, NULL, '2018-01-07', NULL, 'QUOT18030718', 1, 0, NULL, NULL, NULL),
(17, NULL, NULL, '2018-01-07', NULL, 'QUOT18030719', 1, 0, NULL, NULL, NULL),
(18, NULL, NULL, '2018-01-07', NULL, 'QUOT18030720', 1, 0, NULL, NULL, NULL),
(19, NULL, NULL, '2018-01-07', NULL, 'QUOT18030721', 1, 0, NULL, NULL, NULL),
(20, NULL, NULL, '2018-01-07', NULL, 'QUOT18030722', 1, 0, NULL, NULL, NULL),
(21, NULL, NULL, '2018-01-08', b'1', 'QUOT18030823', 1, 14140, 3, 1, 9),
(22, NULL, NULL, '2018-01-13', b'1', 'QUOT18031324', 0, 6850, 3, 1, 9);

-- --------------------------------------------------------

--
-- Structure de la table `quotation_agency`
--

DROP TABLE IF EXISTS `quotation_agency`;
CREATE TABLE IF NOT EXISTS `quotation_agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency_id` bigint(20) DEFAULT NULL,
  `quotation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKel5kfaer67xryw0gig6y5l2go` (`agency_id`,`quotation_id`),
  KEY `FKhog2ixxwcdxo4ctan6l4t422y` (`quotation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `quotation_agency`
--

INSERT INTO `quotation_agency` (`id`, `agency_id`, `quotation_id`) VALUES
(1, 2, 1),
(46, 2, 3),
(47, 16, 3),
(48, 17, 3),
(49, 15, 3),
(53, 52, 4),
(51, 50, 5),
(93, 53, 2),
(92, 51, 2),
(94, 2, 21),
(95, 3, 21),
(96, 4, 21),
(97, 21, 21),
(98, 11, 22),
(99, 38, 22);

-- --------------------------------------------------------

--
-- Structure de la table `quotation_frequencies`
--

DROP TABLE IF EXISTS `quotation_frequencies`;
CREATE TABLE IF NOT EXISTS `quotation_frequencies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `frequency_band_id` bigint(20) DEFAULT NULL,
  `quotation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKrve8soyqqiyjvifi52ft55hmy` (`quotation_id`,`frequency_band_id`),
  KEY `FKihhsof7xha5ybehpuwelq6hy` (`frequency_band_id`)
) ENGINE=MyISAM AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `quotation_frequencies`
--

INSERT INTO `quotation_frequencies` (`id`, `frequency_band_id`, `quotation_id`) VALUES
(1, 8, 1),
(88, 5, 2),
(87, 4, 2),
(90, 8, 2),
(89, 6, 2),
(9, 8, 3),
(10, 6, 3),
(17, 4, 4),
(12, 4, 5),
(18, 8, 4),
(91, 8, 21),
(92, 4, 22),
(93, 5, 22);

-- --------------------------------------------------------

--
-- Structure de la table `quotation_technologies`
--

DROP TABLE IF EXISTS `quotation_technologies`;
CREATE TABLE IF NOT EXISTS `quotation_technologies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `equipment_technologie_id` bigint(20) DEFAULT NULL,
  `quotation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKirsvryjsshnca1q7bnpk7t9de` (`quotation_id`,`equipment_technologie_id`),
  KEY `FKhjyxm2upxocf3777yw96lfgo8` (`equipment_technologie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `quotation_technologies`
--

INSERT INTO `quotation_technologies` (`id`, `equipment_technologie_id`, `quotation_id`) VALUES
(1, 46, 1),
(43, 31, 2),
(8, 45, 3),
(9, 46, 3),
(10, 42, 3),
(11, 49, 3),
(12, 31, 3),
(13, 50, 3),
(14, 54, 3),
(15, 55, 3),
(16, 47, 3),
(17, 48, 3),
(18, 52, 3),
(19, 56, 3),
(20, 51, 3),
(24, 57, 4),
(22, 57, 5),
(25, 53, 4),
(44, 46, 21),
(45, 45, 21),
(46, 46, 22);

-- --------------------------------------------------------

--
-- Structure de la table `record_counter`
--

DROP TABLE IF EXISTS `record_counter`;
CREATE TABLE IF NOT EXISTS `record_counter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `current_month` varchar(255) DEFAULT NULL,
  `current_year` varchar(255) DEFAULT NULL,
  `quotation_counter` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `record_counter`
--

INSERT INTO `record_counter` (`id`, `current_month`, `current_year`, `quotation_counter`) VALUES
(1, '03', NULL, 24);

-- --------------------------------------------------------

--
-- Structure de la table `requirements`
--

DROP TABLE IF EXISTS `requirements`;
CREATE TABLE IF NOT EXISTS `requirements` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `requirements`
--

INSERT INTO `requirements` (`id`, `name`) VALUES
(1, 'Loa'),
(2, 'Doc');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activated` tinyint(1) DEFAULT '1',
  `description` varchar(255) DEFAULT NULL,
  `role_wording` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_type` varchar(31) NOT NULL,
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `actived` tinyint(1) DEFAULT '1',
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `is_confirm` tinyint(1) NOT NULL DEFAULT '0',
  `last_name` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`user_type`, `user_id`, `actived`, `email`, `first_name`, `is_confirm`, `last_name`, `mobile`, `password`, `username`) VALUES
('', 1, 1, 'at.cisse@consultit-now.com', 'CisseAbdoulaye Toumoutou', 1, 'Abdoulaye Toumoutou', '09514212', '882baf28143fb700b388a87ef561a6e5', 'abdel');

-- --------------------------------------------------------

--
-- Structure de la table `users_role`
--

DROP TABLE IF EXISTS `users_role`;
CREATE TABLE IF NOT EXISTS `users_role` (
  `authorized` bit(1) NOT NULL,
  `users_user_id` bigint(20) NOT NULL,
  `role_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_role_id`,`users_user_id`),
  KEY `FKf9glr0ygo1efad4byt5nt7149` (`users_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
