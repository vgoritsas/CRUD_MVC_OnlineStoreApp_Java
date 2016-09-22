-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 22 Ιαν 2016 στις 11:15:46
-- Έκδοση διακομιστή: 10.1.9-MariaDB
-- Έκδοση PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `tvapp`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `onlinestore`
--

CREATE TABLE `onlinestore` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Sku` varchar(255) NOT NULL,
  `Price` double NOT NULL,
  `Size` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `onlinestore`
--

INSERT INTO `onlinestore` (`Id`, `Name`, `Sku`, `Price`, `Size`) VALUES
(2, 'asdfsdf', 'asdfsdf', 222, 22),
(5, 'giannisxssasasa', '121223', 12112, 121);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `onlinestore`
--
ALTER TABLE `onlinestore`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `onlinestore`
--
ALTER TABLE `onlinestore`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
