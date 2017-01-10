-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 09. Jan 2017 um 10:39
-- Server-Version: 10.1.19-MariaDB
-- PHP-Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `pizzaworld`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bestellung`
--

CREATE TABLE `bestellung` (
  `ID` int(11) NOT NULL,
  `bestellnummer` int(11) NOT NULL,
  `menge` int(5) NOT NULL,
  `position` int(5) NOT NULL,
  `preis` varchar(10) NOT NULL,
  `sorte` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `bestellung`
--

INSERT INTO `bestellung` (`ID`, `bestellnummer`, `menge`, `position`, `preis`, `sorte`) VALUES
(1, 0, 2, 1, '22.00', 'Pizza ai Spinaci'),
(2, 0, 1, 2, '10.00', 'Pizza Margherita'),
(3, 0, 2, 1, '22.00', 'Pizza ai Spinaci'),
(4, 0, 1, 2, '13.50', 'Pizza Hawaii'),
(5, 6, 1, 1, '11.00', 'Pizza ai Spinaci'),
(6, 6, 2, 2, '20.00', 'Pizza Margherita'),
(7, 7, 1, 1, '11.00', 'Pizza ai Spinaci'),
(8, 8, 1, 1, '11.00', 'Pizza ai Spinaci'),
(9, 9, 1, 1, '11.00', 'Pizza ai Spinaci'),
(10, 10, 1, 1, '11.00', 'Pizza ai Spinaci'),
(11, 11, 1, 1, '11.00', 'Pizza ai Spinaci'),
(12, 11, 2, 2, '27.00', 'Pizza Hawaii'),
(13, 12, 1, 1, '11.00', 'Pizza ai Spinaci'),
(14, 12, 2, 2, '13.32', 'Pizza Diavolo'),
(15, 13, 1, 1, '11.00', 'Pizza ai Spinaci'),
(16, 13, 2, 2, '27.00', 'Pizza Hawaii'),
(17, 13, 3, 3, '45.00', 'Pizza Quattro Stagioni'),
(18, 14, 1, 1, '11.00', 'Pizza ai Spinaci'),
(19, 14, 2, 2, '27.00', 'Pizza Hawaii'),
(20, 14, 3, 3, '45.00', 'Pizza Quattro Stagioni'),
(21, 15, 1, 1, '11.00', 'Pizza ai Spinaci'),
(22, 15, 2, 2, '27.00', 'Pizza Hawaii'),
(23, 15, 3, 3, '45.00', 'Pizza Quattro Stagioni'),
(24, 16, 1, 1, '6.66', 'Pizza Diavolo'),
(25, 16, 4, 2, '40.00', 'Pizza Margherita'),
(26, 16, 2, 3, '24.00', 'Pizza Tonno'),
(27, 17, 1, 1, '11.00', 'Pizza ai Spinaci'),
(28, 17, 2, 2, '27.00', 'Pizza Hawaii'),
(29, 18, 1, 1, '11.00', 'Pizza ai Spinaci'),
(30, 18, 3, 2, '40.50', 'Pizza Hawaii'),
(31, 19, 1, 1, '11.00', 'Pizza ai Spinaci'),
(32, 20, 1, 1, '11.00', 'Pizza ai Spinaci'),
(33, 20, 3, 2, '36.00', 'Pizza Tonno'),
(34, 21, 1, 1, '10.00', 'Pizza Margherita'),
(35, 21, 3, 2, '36.00', 'Pizza Tonno'),
(36, 21, 2, 3, '27.00', 'Pizza Hawaii'),
(37, 22, 1, 1, '11.00', 'Pizza ai Spinaci'),
(38, 22, 2, 2, '27.00', 'Pizza Hawaii'),
(39, 23, 1, 1, '16.00', 'Pizza Calzone'),
(40, 23, 2, 2, '27.00', 'Pizza Hawaii'),
(41, 23, 3, 3, '36.00', 'Pizza Tonno'),
(42, 24, 3, 1, '48.00', 'Pizza Calzone'),
(43, 24, 2, 2, '13.32', 'Pizza Diavolo'),
(44, 24, 3, 3, '40.50', 'Pizza Hawaii'),
(45, 24, 6, 4, '72.00', 'Pizza Tonno'),
(46, 25, 1, 1, '11.00', 'Pizza ai Spinaci'),
(47, 25, 2, 2, '27.00', 'Pizza Hawaii'),
(48, 26, 1, 1, '11.00', 'Pizza ai Spinaci'),
(49, 27, 1, 1, '11.00', 'Pizza ai Spinaci'),
(50, 28, 1, 1, '13.50', 'Pizza Hawaii'),
(51, 29, 1, 1, '11.00', 'Pizza ai Spinaci'),
(52, 30, 1, 1, '11.00', 'Pizza ai Spinaci'),
(53, 31, 1, 1, '11.00', 'Pizza ai Spinaci'),
(54, 31, 3, 2, '40.50', 'Pizza Hawaii'),
(55, 32, 1, 1, '11.00', 'Pizza ai Spinaci'),
(56, 32, 4, 2, '54.00', 'Pizza Hawaii'),
(57, 33, 1, 1, '11.00', 'Pizza ai Spinaci'),
(58, 33, 3, 2, '36.00', 'Pizza Tonno'),
(59, 34, 1, 1, '11.00', 'Pizza ai Spinaci'),
(60, 34, 3, 2, '45.00', 'Pizza Quattro Stagioni'),
(61, 35, 3, 1, '33.00', 'Pizza ai Spinaci'),
(62, 35, 6, 2, '72.00', 'Pizza Tonno'),
(63, 36, 4, 1, '44.00', 'Pizza ai Spinaci'),
(64, 36, 2, 2, '20.00', 'Pizza Margherita'),
(65, 37, 1, 1, '10.00', 'Pizza Margherita'),
(66, 37, 3, 2, '33.00', 'Pizza ai Spinaci'),
(67, 38, 1, 1, '11.00', 'Pizza ai Spinaci');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kunde`
--

CREATE TABLE `kunde` (
  `kundennummer` int(11) NOT NULL,
  `vorname` varchar(100) NOT NULL,
  `nachname` varchar(100) NOT NULL,
  `strasse` varchar(100) NOT NULL,
  `ort` varchar(100) NOT NULL,
  `plz` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `kunde`
--

INSERT INTO `kunde` (`kundennummer`, `vorname`, `nachname`, `strasse`, `ort`, `plz`) VALUES
(524642546, 'John', 'Westfield', 'Lohnstrasse 4', 'Stuttgart', '70181'),
(635863851, 'Ludwig', 'Lolle', 'Primmelweg 4', 'Hohenlohe', '55555'),
(719859124, 'Peter', 'Schimpf', 'Lieblingsweg 22', 'Trier', '12345'),
(786697876, 'Peter', 'Pan', 'Weg 2', 'Stadt', '99999'),
(1876846012, 'Robert', 'Vielfrass', 'Teller 1', 'Essen', '23456');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `lieferung`
--

CREATE TABLE `lieferung` (
  `bestellnummer` int(11) NOT NULL,
  `kundennummer` int(11) NOT NULL,
  `datum` varchar(100) NOT NULL,
  `ip` varchar(100) NOT NULL,
  `sessionid` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `lieferung`
--

INSERT INTO `lieferung` (`bestellnummer`, `kundennummer`, `datum`, `ip`, `sessionid`) VALUES
(1, 524642546, '08.01.2017 01:49:53', '0:0:0:0:0:0:0:1', 'b8d42e6a874f11d1519aa1edc5d1'),
(2, 524642546, '08.01.2017 02:06:46', '0:0:0:0:0:0:0:1', 'b9cbf99c81906e26af019551ed98'),
(3, 524642546, '08.01.2017 12:09:42', '0:0:0:0:0:0:0:1', 'dc47ea26edbda83c232bbd85c7c4'),
(4, 524642546, '08.01.2017 12:20:34', '0:0:0:0:0:0:0:1', 'dceb749e473a4acad78caef4e9ab'),
(5, 524642546, '08.01.2017 12:26:37', '0:0:0:0:0:0:0:1', 'dd41921383bb81913cc9f6785c85'),
(6, 524642546, '08.01.2017 12:31:12', '0:0:0:0:0:0:0:1', 'dd86f6f2ef56f5d9ea9e003057cb'),
(7, 524642546, '08.01.2017 12:35:23', '0:0:0:0:0:0:0:1', 'ddc5166bd03f7768e097ef4fa867'),
(8, 524642546, '08.01.2017 12:38:39', '0:0:0:0:0:0:0:1', 'ddf4b954be3cc46b5c2823dc82a2'),
(9, 524642546, '08.01.2017 12:48:09', '0:0:0:0:0:0:0:1', 'de80773c9fdcd292e0a71b19cb83'),
(10, 524642546, '08.01.2017 12:54:47', '0:0:0:0:0:0:0:1', 'dee189e9f1d1d0ca380ad295ee26'),
(11, 524642546, '08.01.2017 12:57:33', '0:0:0:0:0:0:0:1', 'df091aeaaca29478926029e50134'),
(12, 524642546, '08.01.2017 13:04:25', '0:0:0:0:0:0:0:1', 'df6ec6178ac6a7f1f7941e88b120'),
(13, 524642546, '08.01.2017 13:07:11', '0:0:0:0:0:0:0:1', 'df95f6d98084647503308353f818'),
(14, 524642546, '08.01.2017 13:07:23', '0:0:0:0:0:0:0:1', 'df95f6d98084647503308353f818'),
(15, 524642546, '08.01.2017 13:07:26', '0:0:0:0:0:0:0:1', 'df95f6d98084647503308353f818'),
(16, 524642546, '08.01.2017 13:08:29', '0:0:0:0:0:0:0:1', 'dfa75a78f690c35238ea1c95d90e'),
(17, 524642546, '08.01.2017 13:22:22', '0:0:0:0:0:0:0:1', 'e07530697651d3275473f1fd7eb3'),
(18, 524642546, '08.01.2017 13:27:12', '0:0:0:0:0:0:0:1', 'e0bc61adaa10a5d7fd0d36bcbdf6'),
(19, 524642546, '08.01.2017 13:28:24', '0:0:0:0:0:0:0:1', 'e0ce82def47073e68faf2c1e14fc'),
(20, 524642546, '08.01.2017 13:35:44', '0:0:0:0:0:0:0:1', 'e138b0a79716d1338779cf1eb345'),
(21, 524642546, '08.01.2017 13:39:51', '0:0:0:0:0:0:0:1', 'e1738505a539a2ecaff534adadfc'),
(22, 524642546, '08.01.2017 13:51:07', '0:0:0:0:0:0:0:1', 'e21a661aa9677cc071dee2df40f2'),
(23, 719859124, '08.01.2017 17:16:00', '0:0:0:0:0:0:0:1', 'edc4ac06906b75e1a6cd082c9bd8'),
(24, 1876846012, '08.01.2017 21:25:54', '0:0:0:0:0:0:0:1', 'fc12221522485f479be6c21c3441'),
(25, 524642546, '08.01.2017 21:28:15', '0:0:0:0:0:0:0:1', 'fc41369334e8f357807deaba83bf'),
(26, 524642546, '08.01.2017 21:29:52', '0:0:0:0:0:0:0:1', 'fc58f6d5ca228dd8a19ba43327bb'),
(27, 524642546, '08.01.2017 21:30:32', '0:0:0:0:0:0:0:1', 'fc65d037fce472f17b458777a6c8'),
(28, 524642546, '08.01.2017 21:31:19', '0:0:0:0:0:0:0:1', 'fc716b87ae65160e61b8553b8885'),
(29, 524642546, '08.01.2017 21:33:30', '0:0:0:0:0:0:0:1', 'fc8fdd53ce4780bd89320597e6bf'),
(30, 524642546, '08.01.2017 21:34:30', '0:0:0:0:0:0:0:1', 'fca01dc286624fffd656e6c8a816'),
(31, 524642546, '08.01.2017 21:41:03', '0:0:0:0:0:0:0:1', 'fcfdb7b1079d4fdebf44e4d8262e'),
(32, 524642546, '08.01.2017 21:42:47', '0:0:0:0:0:0:0:1', 'fd1570d5d844f45b4ff204160cf5'),
(33, 524642546, '08.01.2017 21:47:27', '0:0:0:0:0:0:0:1', 'fd5b7ecc3915697d5a2e03cbcaca'),
(34, 524642546, '08.01.2017 21:51:36', '0:0:0:0:0:0:0:1', 'fd9864661f92221dbbcae234c145'),
(35, 1876846012, '08.01.2017 22:09:25', '0:0:0:0:0:0:0:1', 'fe99e8f71746d8c12b921d36f498'),
(36, 524642546, '09.01.2017 08:19:35', '0:0:0:0:0:0:0:1', '2181aaef81b4bf273658b76e1e23'),
(37, 786697876, '09.01.2017 10:13:29', '0:0:0:0:0:0:0:1', '2805c7c23174ef91ef1d429fbfad'),
(38, 524642546, '09.01.2017 10:34:18', '0:0:0:0:0:0:0:1', '293d74f704df38a032751f6e55ff');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `pizza`
--

CREATE TABLE `pizza` (
  `ID` int(11) NOT NULL,
  `sorte` varchar(100) NOT NULL,
  `preis` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `pizza`
--

INSERT INTO `pizza` (`ID`, `sorte`, `preis`) VALUES
(1, 'Pizza Tonno', '12.00'),
(2, 'Pizza Diavolo', '6.66'),
(3, 'Pizza Hawaii', '13.50'),
(4, 'Pizza Calzone', '16.00'),
(5, 'Pizza Quattro Stagioni', '15.00'),
(6, 'Pizza Margherita', '10.00'),
(7, 'Pizza ai Spinaci', '11.00');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `kunde`
--
ALTER TABLE `kunde`
  ADD PRIMARY KEY (`kundennummer`),
  ADD UNIQUE KEY `kundennummer` (`kundennummer`);

--
-- Indizes für die Tabelle `lieferung`
--
ALTER TABLE `lieferung`
  ADD PRIMARY KEY (`bestellnummer`);

--
-- Indizes für die Tabelle `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT für Tabelle `lieferung`
--
ALTER TABLE `lieferung`
  MODIFY `bestellnummer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT für Tabelle `pizza`
--
ALTER TABLE `pizza`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
