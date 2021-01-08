-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Czas generowania: 06 Sty 2021, 22:50
-- Wersja serwera: 8.0.22
-- Wersja PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `warehousedatabase`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cooler`
--

CREATE TABLE `cooler` (
  `fan` varchar(255) DEFAULT NULL,
  `speed_control` varchar(255) DEFAULT NULL,
  `type_of_colling` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `cooler`
--

INSERT INTO `cooler` (`fan`, `speed_control`, `type_of_colling`, `id`) VALUES
('1 x 120mm', 'PWM', 'Active', 23),
('2 x 120mm', 'PWM', 'Water', 24),
('1 x 100mm', 'PWM', 'Active', 25),
('2 x 120mm', 'PWM', 'Water', 26);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cpu`
--

CREATE TABLE `cpu` (
  `cache` varchar(255) DEFAULT NULL,
  `cores` varchar(255) DEFAULT NULL,
  `series` varchar(255) DEFAULT NULL,
  `timing` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `cpu`
--

INSERT INTO `cpu` (`cache`, `cores`, `series`, `timing`, `id`) VALUES
('12 MB', '6 cores', 'i5-10400F', '2.9 GHz', 31),
('20 MB', '10 cores', 'i9-10850K', '3.6 GHz', 32),
('35 MB', '6 cores', 'Ryzen 5 3600', '3.6 GHz', 33),
('288 MB', '64 cores', 'Threadripper 3990X', '2.9 GHz', 34);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `gpu`
--

CREATE TABLE `gpu` (
  `layout` varchar(255) DEFAULT NULL,
  `type_of_memory` varchar(255) DEFAULT NULL,
  `vram` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `gpu`
--

INSERT INTO `gpu` (`layout`, `type_of_memory`, `vram`, `id`) VALUES
('GeForce RTX 3070', 'GDDR6', '8 GB', 13),
('GeForce GTX 1650', 'GDDR6', '4 GB', 14),
('GeForce GTX 1660', 'GDDR5', '6 GB', 15),
('Radeon RX 5700 XT', 'GDDR6', '8 GB', 16),
('Radeon RX 550', 'GDDR5', '4 GB', 17),
('GeForce RTX 3080', 'GDDR6X', '10 GB', 18);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hdd`
--

CREATE TABLE `hdd` (
  `capacity` varchar(255) DEFAULT NULL,
  `disk_interface` varchar(255) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL,
  `rotation_speed` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `hdd`
--

INSERT INTO `hdd` (`capacity`, `disk_interface`, `format`, `rotation_speed`, `id`) VALUES
('1000 GB', 'SATA III', '2.5\'\'', '7200 obr./min', 27),
('2000 GB', 'SATA III', '2.5\'\'', '7200 obr./min', 28);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(67);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `motherboard`
--

CREATE TABLE `motherboard` (
  `chipset` varchar(255) DEFAULT NULL,
  `cpu_socket` varchar(255) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `motherboard`
--

INSERT INTO `motherboard` (`chipset`, `cpu_socket`, `format`, `id`) VALUES
('AMD B450', 'Socket AM4', 'mATX', 19),
('AMD B550', 'Socket AM4', 'ATX', 20),
('AMD B450', 'Socket AM4', 'mATX', 21),
('Intel Z490', 'Socket 1200', 'ATX', 22);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product`
--

CREATE TABLE `product` (
  `id` bigint NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `product`
--

INSERT INTO `product` (`id`, `created_at`, `description`, `name`, `price`, `quantity`, `type`) VALUES
(1, '2020-12-28 00:13:25', 'Custom description', 'SilentiumPC Vero L3 600W 80 Plus Bronze', 220, 1, 'psu'),
(2, '2020-12-28 00:14:18', 'Custom description', 'Corsair CV 550W 80 Plus Bronze', 439, 1, 'psu'),
(3, '2020-12-28 00:15:13', 'Custom description', 'be quiet! Straight Power 11 750W 80 Plus Gold', 619, 1, 'psu'),
(4, '2020-12-28 00:16:20', 'Custom description', 'SilentiumPc Superemo FM2 750W Plus Gold', 229, 1, 'psu'),
(5, '2020-12-28 00:16:41', 'Custom description', 'SilentiumPc Superemo FM2 650W Plus Gold', 200, 1, 'psu'),
(6, '2020-12-28 00:17:11', 'Custom description', 'Seasonic Focus GX 750W 80 Plus Gold', 599, 4, 'psu'),
(7, '2020-12-28 00:19:51', 'Custom description', 'G.SKILL 16GB (2x8GB) 3200MHz CL16 Aegis', 319.5, 4, 'ram'),
(8, '2020-12-28 00:20:54', 'Custom description', 'GOODRAM 16GB (2x8GB) 2666MHz CL16 IRDM', 274, 1, 'ram'),
(9, '2020-12-28 00:21:29', 'Custom description', 'HyperX 16GB (2x8GB) 3200MHz CL16 Fury RGB', 365, 1, 'ram'),
(10, '2020-12-28 00:22:30', 'Custom description', 'G.SKILL 32GB (2x16GB) 4000MHz CL16 Ripjaws V Black', 799, 1, 'ram'),
(11, '2020-12-28 00:23:09', 'Custom description', 'G.SKILL 16GB (2x8GB) 3600MHz CL17 Ripjaws V Black', 359, 1, 'ram'),
(12, '2020-12-28 00:23:54', 'Custom description', 'GOODRAM 4GB (1x4GB) 1600MHz CL11', 84, 1, 'ram'),
(13, '2020-12-28 00:26:22', 'Custom description', 'Gigabyte GeForce RTX 3070 GAMING OC 8GB GDDR6', 2979, 1, 'gpu'),
(14, '2020-12-28 00:27:01', 'Custom description', 'Zotac GeForce GTX 1650 Gaming AMP CORE GDDR6 4GB', 719, 1, 'gpu'),
(15, '2020-12-28 00:27:54', 'Custom description', 'MSI GeForce GTX 1660 VENTUS XS OC 6GB GDDR5', 1249, 1, 'gpu'),
(16, '2020-12-28 00:28:41', 'Custom description', 'Sapphire Radeon RX 5700 XT Pulse BE 8GB GDDR6', 2199, 1, 'gpu'),
(17, '2020-12-28 00:29:23', 'Custom description', 'ASUS Radeon RX 550 Phoenix EVO 4GB GDDR5', 399, 1, 'gpu'),
(18, '2020-12-28 00:30:05', 'Custom description', 'Gigabyte GeForce RTX 3080 GAMING OC 10GB GDDR6X', 3749, 1, 'gpu'),
(19, '2020-12-28 00:34:23', 'Custom description', 'Gigabyte B450M DS3H', 499, 1, 'motherboard'),
(20, '2020-12-28 00:34:56', 'Custom description', 'MSI MAG B550 TOMAHAWK', 579.5, 1, 'motherboard'),
(21, '2020-12-28 00:35:24', 'Custom description', 'ASRock B450M-HDV R4.0', 529, 1, 'motherboard'),
(22, '2020-12-28 00:36:46', 'Custom description', 'MSI MPG Z490 GAMING PLUS', 499, 1, 'motherboard'),
(23, '2020-12-28 00:37:57', 'Custom description', 'SilentiumPC Fera 3 120mm', 105, 1, 'cooler'),
(24, '2020-12-28 00:40:51', 'Custom description', 'SilentiumPC Navis RGB 240 2x120mm', 319, 1, 'cooler'),
(25, '2020-12-28 00:41:30', 'Custom description', 'SilentiumPC Spartan 4 100mm', 65, 1, 'cooler'),
(26, '2020-12-28 00:42:06', 'Custom description', 'SilentiumPC Navis Evo ARGB 240 2x120mm', 379, 1, 'cooler'),
(27, '2020-12-28 00:45:37', 'Custom description', 'WD Elements Portable 1TB USB 3.0', 209, 1, 'hdd'),
(28, '2020-12-28 00:46:07', 'Custom description', 'Silicon Power armor A30 2TB USB 3.0', 349, 1, 'hdd'),
(29, '2020-12-28 00:47:54', 'Custom description', 'Kingston 500GB M.2 PcIe NVMe A2000', 289, 1, 'ssd'),
(30, '2020-12-28 00:49:16', 'Custom description', 'KIOXIA 480GB 2,5 SATA SSD EXCERIA BDQ', 279.2, 4, 'ssd'),
(31, '2020-12-28 00:54:44', 'Custom description', 'Intel Core i5-10400F', 699, 1, 'cpu'),
(32, '2020-12-28 00:55:39', 'Custom description', 'Intel Core i9-10850K AE', 2149, 1, 'cpu'),
(33, '2020-12-28 00:56:16', 'Custom description', 'AMD Ryzen 5 3600', 1069, 1, 'cpu'),
(34, '2020-12-28 00:56:47', 'Custom description', 'AMD Ryzen Threadripper 3990X', 18400, 1, 'cpu');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `psu`
--

CREATE TABLE `psu` (
  `certificate` varchar(255) DEFAULT NULL,
  `efficiency` varchar(255) DEFAULT NULL,
  `power` varchar(255) DEFAULT NULL,
  `standard` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `psu`
--

INSERT INTO `psu` (`certificate`, `efficiency`, `power`, `standard`, `id`) VALUES
('80 Plus Bronze', '89% at 230V', '600 W', 'ATX', 1),
('80 Plus Bronze', '92% at 230V', '550 W', 'ATX', 2),
('80 Plus Gold', '92-94% at 230V', '750 W', 'ATX', 3),
('80 Plus Gold', '92% at 230V', '750 W', 'ATX', 4),
('80 Plus Gold', '92% at 230V', '650 W', 'ATX', 5),
('80 Plus Gold', '90% at 230V', '750 W', 'ATX', 6);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ram`
--

CREATE TABLE `ram` (
  `delay` varchar(255) DEFAULT NULL,
  `speed` varchar(255) DEFAULT NULL,
  `total_capacity` varchar(255) DEFAULT NULL,
  `type_of_memory` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `ram`
--

INSERT INTO `ram` (`delay`, `speed`, `total_capacity`, `type_of_memory`, `id`) VALUES
('CL 15', '3200 Mhz', '16 GB', 'DDR4', 7),
('CL 16', '2666 Mhz', '16 GB', 'DDR4', 8),
('CL 16', '3200 Mhz', '16 GB', 'DDR4', 9),
('CL 16', '4000 Mhz', '32 GB', 'DDR4', 10),
('CL 17', '3600 Mhz', '16 GB', 'DDR4', 11),
('CL 11', '1600 Mhz', '4 GB', 'DDR3 SODIMM', 12);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ssd`
--

CREATE TABLE `ssd` (
  `capacity` varchar(255) DEFAULT NULL,
  `disk_interface` varchar(255) DEFAULT NULL,
  `save_speed` varchar(255) DEFAULT NULL,
  `write_speed` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `ssd`
--

INSERT INTO `ssd` (`capacity`, `disk_interface`, `save_speed`, `write_speed`, `id`) VALUES
('500GB', 'M.2 PCIe NVMe 3.0 x4', '2000 MB/s', '2200 MB/s', 29),
('480GB', 'SATA III', '540 MB/s', '555 MB/s', 30);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `cooler`
--
ALTER TABLE `cooler`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `cpu`
--
ALTER TABLE `cpu`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `gpu`
--
ALTER TABLE `gpu`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `hdd`
--
ALTER TABLE `hdd`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `motherboard`
--
ALTER TABLE `motherboard`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `psu`
--
ALTER TABLE `psu`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `ram`
--
ALTER TABLE `ram`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `ssd`
--
ALTER TABLE `ssd`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
