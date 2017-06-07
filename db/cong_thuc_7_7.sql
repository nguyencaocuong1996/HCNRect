-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 30, 2017 lúc 09:47 SA
-- Phiên bản máy phục vụ: 10.1.21-MariaDB
-- Phiên bản PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `restaurant`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cong_thuc`
--

CREATE TABLE `cong_thuc` (
  `MaMA` int(10) UNSIGNED NOT NULL,
  `MaNL` int(10) UNSIGNED NOT NULL,
  `LuongCan` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GhiChu` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cong_thuc`
--

INSERT INTO `cong_thuc` (`MaMA`, `MaNL`, `LuongCan`, `GhiChu`) VALUES
(1, 2, '0.5', NULL),
(1, 23, '0.3', NULL),
(2, 7, '0.5', NULL),
(2, 24, '0.2', NULL),
(3, 1, '0.5', NULL),
(3, 12, '1', NULL),
(3, 25, '2', NULL),
(4, 26, '0.5', NULL),
(4, 27, '0.002', NULL),
(5, 10, '1', NULL),
(5, 28, '0.5', NULL),
(6, 1, '0.3', NULL),
(7, 2, '0.5', NULL),
(16, 2, '1', NULL),
(16, 31, '0.2', NULL),
(16, 32, '0.01', NULL),
(17, 34, '5', NULL),
(17, 35, '0.01', NULL),
(18, 29, '1', NULL),
(18, 36, '1', NULL),
(19, 2, '3', NULL),
(19, 35, '0.01', NULL),
(19, 37, '0.1', NULL),
(20, 38, '2', NULL),
(20, 39, '0.3', NULL),
(21, 29, '0.5', NULL),
(21, 32, '0,01', NULL),
(21, 37, '0,01', NULL),
(22, 40, '0.2', NULL),
(22, 42, '0.01', NULL),
(23, 41, '0.2', NULL),
(23, 42, '0.01', NULL),
(24, 43, '0,5', NULL),
(24, 32, '0.01', NULL),
(24, 28, '0.02', NULL),
(25, 44, '0.2', NULL),
(25, 35, '0.01', NULL),
(26, 45, '0.5', NULL),
(26, 35, '0.01', NULL),
(26, 37, '0.2', NULL),
(27, 3, '0.2', NULL),
(27, 28, '0.01', NULL),
(28, 46, '0.05', NULL),
(28, 47, '0.02', NULL),
(29, 48, '0.3', NULL),
(29, 28, '0.01', NULL),
(30, 34, '0.3', NULL),
(30, 35, '0.01', NULL),
(31, 49, '0.3', NULL),
(31, 35, '0.01', NULL),
(32, 50, '0.5', NULL),
(32, 51, '0.01', NULL),
(7, 25, '3', NULL),
(8, 52, '0.2', NULL),
(8, 5, '0.2', NULL),
(9, 53, '2', NULL),
(9, 50, '0.03', NULL),
(9, 6, '0.03', NULL),
(10, 54, '0.2', NULL),
(11, 55, '3', NULL),
(12, 1, '0.3', NULL),
(12, 56, '0.02', NULL),
(13, 12, '1', NULL),
(14, 54, '0.3', NULL),
(14, 57, '0.2', NULL),
(15, 58, '0.5', NULL),
(33, 17, '1', NULL),
(34, 19, '1', NULL),
(35, 20, '1', NULL),
(36, 16, '1', NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cong_thuc`
--
ALTER TABLE `cong_thuc`
  ADD PRIMARY KEY (`MaMA`,`MaNL`),
  ADD UNIQUE KEY `MaCongThuc_UNIQUE` (`MaNL`,`MaMA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
