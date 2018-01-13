-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Sam 13 Janvier 2018 à 12:31
-- Version du serveur :  5.7.14
-- Version de PHP :  7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

CREATE TABLE `agency` (
  `id` bigint(20) NOT NULL,
  `agency_initials` varchar(255) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `approval_type_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `agency`
--

INSERT INTO `agency` (`id`, `agency_initials`, `link`, `name`, `country_id`, `approval_type_id`) VALUES
(1, 'ARPT', 'http://www.arpt.dz', ' Autorité de Régulation de la Poste et des Télécommunications', 2, 3),
(2, 'ARCEP', 'http://www.arcep.bj', 'Autorité de Régulation des Communications Electroniques et de la Poste', 1, 3),
(3, 'BOCRA', 'http://www.bocra.org.bw/', ' Botswana Communications Regulatory Authority ', 3, 3),
(4, 'ARTCI', 'http://www.artci.ci', 'Autorité de Régulation des Télécommunications de Côte d’Ivoire ', 5, 3),
(5, 'ICASA', 'https://www.icasa.org.za/', ' Independent Communications Authority of South Africa', 6, 3),
(6, 'SABS', 'https://www.sabs.co.za/', 'The South African Bureau of Standards ', 6, 1),
(7, 'NRCS', 'http://www.nrcs.org.za/', 'National Regulator for Compulsory Specifications ', 6, 2),
(8, 'CA', 'http://www.ca.go.ke/', 'Communications Authority of Kenya ', 7, 3);

-- --------------------------------------------------------

--
-- Structure de la table `approval_type`
--

CREATE TABLE `approval_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `approval_type`
--

INSERT INTO `approval_type` (`id`, `name`) VALUES
(1, 'EMC'),
(2, 'SAFETY'),
(3, 'TELECOMMUNICATION');

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `category_price` double DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `category`
--

INSERT INTO `category` (`id`, `category_name`, `category_price`, `country_id`) VALUES
(1, 'algerie ', 1000, 2),
(2, 'benin', 750, 1),
(3, 'botswana A', 600, 3),
(4, 'botswana B', 1000, 3),
(5, 'botswana C', 1500, 3),
(6, 'botswana D', 2750, 3),
(7, 'cote d\'Ivoire', 1150, 5),
(8, 'guinee conakry A', 500, 4),
(9, 'guinee conakry B', 700, 4),
(10, 'guinee conakry C', 850, 4),
(11, 'guinee conakry D', 1000, 4),
(12, 'guinee conakry E', 1200, 4),
(13, 'south africa icasa (RF)', 2000, 6),
(14, 'south africa icasa (SAFETY)', 1500, 6);

-- --------------------------------------------------------

--
-- Structure de la table `country`
--

CREATE TABLE `country` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `country`
--

INSERT INTO `country` (`id`, `name`) VALUES
(1, 'BENIN'),
(2, 'ALGERIE'),
(3, 'BOTSWANA'),
(4, 'GUINEA'),
(5, 'COTE D\'IVOIRE'),
(6, 'SOUTH AFRICA'),
(7, 'KENEYA');

-- --------------------------------------------------------

--
-- Structure de la table `country_frequency_band`
--

CREATE TABLE `country_frequency_band` (
  `id` bigint(20) NOT NULL,
  `authorized` bit(1) NOT NULL,
  `country` bigint(20) DEFAULT NULL,
  `frequency_band` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `country_frequency_band`
--

INSERT INTO `country_frequency_band` (`id`, `authorized`, `country`, `frequency_band`) VALUES
(1, b'0', 7, 5),
(2, b'0', 7, 4),
(3, b'0', 7, 3),
(4, b'0', 7, 2),
(5, b'0', 7, 1),
(6, b'1', 1, 1),
(7, b'1', 1, 2),
(8, b'1', 1, 3),
(9, b'1', 1, 4),
(10, b'1', 1, 5),
(11, b'1', 1, 6),
(12, b'1', 1, 7),
(13, b'1', 1, 8),
(16, b'1', 2, 1),
(17, b'1', 2, 2),
(18, b'1', 2, 3),
(19, b'1', 2, 4),
(20, b'1', 2, 5),
(21, b'1', 2, 6),
(22, b'1', 2, 7),
(23, b'1', 2, 8),
(26, b'1', 3, 1),
(27, b'1', 3, 2),
(28, b'1', 3, 3),
(29, b'1', 3, 4),
(30, b'1', 3, 5),
(31, b'1', 3, 6),
(32, b'1', 3, 7),
(33, b'1', 3, 8),
(36, b'1', 4, 1),
(37, b'1', 4, 2),
(38, b'1', 4, 3),
(39, b'1', 4, 4),
(46, b'1', 5, 1),
(48, b'1', 5, 3),
(49, b'1', 5, 4),
(50, b'1', 5, 5),
(51, b'1', 5, 6),
(52, b'1', 5, 7),
(53, b'1', 5, 8),
(56, b'1', 6, 1),
(57, b'1', 6, 2),
(58, b'1', 6, 3),
(59, b'1', 6, 4),
(60, b'1', 6, 5),
(61, b'1', 6, 6),
(62, b'1', 6, 7),
(63, b'1', 6, 8);

-- --------------------------------------------------------

--
-- Structure de la table `equipement_nature`
--

CREATE TABLE `equipement_nature` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `approval_type_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `equipement_nature`
--

INSERT INTO `equipement_nature` (`id`, `name`, `approval_type_id`) VALUES
(1, 'NON RADIO FREQUENCY', 3),
(2, 'RADIO FREQUENCY', 3);

-- --------------------------------------------------------

--
-- Structure de la table `equipement_technologie`
--

CREATE TABLE `equipement_technologie` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `equipement_nature_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `equipement_technologie`
--

INSERT INTO `equipement_technologie` (`id`, `name`, `equipement_nature_id`) VALUES
(1, 'GSM/IMT-2000', 2),
(2, 'Wimax', 2),
(3, 'Tetra', 2),
(4, 'Dect', 2),
(5, 'Satellite', 2),
(6, 'two-way radio transceiver', 2),
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
(46, 'Switching and Signaling Systems', 1),
(45, 'Soft Switch', 1),
(44, 'E1', 1),
(43, 'DECT', 1),
(42, 'Transmission systems', 1),
(31, 'wireless microphones', 1),
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
-- Structure de la table `frequency_band`
--

CREATE TABLE `frequency_band` (
  `id` bigint(20) NOT NULL,
  `max_frequency` int(11) DEFAULT NULL,
  `min_frequency` int(11) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `frequency_band`
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
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `activated` tinyint(1) DEFAULT '1',
  `description` varchar(255) DEFAULT NULL,
  `role_wording` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `user_type` varchar(31) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `actived` tinyint(1) DEFAULT '1',
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `is_confirm` tinyint(1) NOT NULL DEFAULT '0',
  `last_name` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users_role`
--

CREATE TABLE `users_role` (
  `authorized` bit(1) NOT NULL,
  `users_user_id` bigint(20) NOT NULL,
  `role_role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agency`
--
ALTER TABLE `agency`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtgx11d821rio4vuogtlg7018c` (`approval_type_id`),
  ADD KEY `FKdrjp243vgxwlq0bp58odvsbt0` (`country_id`);

--
-- Index pour la table `approval_type`
--
ALTER TABLE `approval_type`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp3g72ms07ax8iv7n9muyxkmki` (`country_id`);

--
-- Index pour la table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_llidyp77h6xkeokpbmoy710d4` (`name`);

--
-- Index pour la table `country_frequency_band`
--
ALTER TABLE `country_frequency_band`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK1spuci093jemv77apdgli413p` (`country`,`frequency_band`),
  ADD KEY `FKnrx2yclix4reoxaiti2m53572` (`frequency_band`);

--
-- Index pour la table `equipement_nature`
--
ALTER TABLE `equipement_nature`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpg2kyoxbjleqws5kgd2yf95wk` (`approval_type_id`);

--
-- Index pour la table `equipement_technologie`
--
ALTER TABLE `equipement_technologie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm9h0m56u865vflcqck8bnwcnq` (`equipement_nature_id`);

--
-- Index pour la table `frequency_band`
--
ALTER TABLE `frequency_band`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Index pour la table `users_role`
--
ALTER TABLE `users_role`
  ADD PRIMARY KEY (`role_role_id`,`users_user_id`),
  ADD KEY `FKf9glr0ygo1efad4byt5nt7149` (`users_user_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agency`
--
ALTER TABLE `agency`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `approval_type`
--
ALTER TABLE `approval_type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `country`
--
ALTER TABLE `country`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `country_frequency_band`
--
ALTER TABLE `country_frequency_band`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;
--
-- AUTO_INCREMENT pour la table `equipement_nature`
--
ALTER TABLE `equipement_nature`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `equipement_technologie`
--
ALTER TABLE `equipement_technologie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT pour la table `frequency_band`
--
ALTER TABLE `frequency_band`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
