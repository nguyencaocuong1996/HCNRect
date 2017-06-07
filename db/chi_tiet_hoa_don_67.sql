-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 07, 2017 lúc 10:36 SA
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
-- Cấu trúc bảng cho bảng `chi_tiet_hoa_don`
--

CREATE TABLE `chi_tiet_hoa_don` (
  `MaHD` int(10) UNSIGNED NOT NULL,
  `MaMA` int(10) UNSIGNED NOT NULL,
  `SoLuong` float UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_hoa_don`
--

INSERT INTO `chi_tiet_hoa_don` (`MaHD`, `MaMA`, `SoLuong`) VALUES
(1, 1, 4),
(1, 2, 4),
(1, 3, 2),
(1, 5, 1),
(33, 3, 1),
(32, 11, 2),
(32, 10, 2),
(32, 8, 1),
(32, 6, 2),
(32, 5, 1),
(3, 1, 1),
(3, 2, 1),
(3, 3, 1),
(3, 4, 1),
(4, 1, 3),
(4, 2, 3),
(4, 3, 3),
(4, 8, 1),
(4, 10, 1),
(5, 2, 1),
(5, 3, 1),
(5, 4, 1),
(5, 6, 1),
(5, 5, 1),
(6, 2, 1),
(6, 4, 1),
(6, 3, 1),
(7, 2, 1),
(7, 1, 1),
(7, 3, 1),
(7, 4, 1),
(8, 2, 1),
(8, 4, 1),
(8, 3, 2),
(9, 2, 1),
(9, 4, 1),
(9, 3, 1),
(9, 1, 1),
(10, 2, 1),
(10, 4, 1),
(10, 3, 1),
(10, 1, 1),
(11, 2, 1),
(11, 4, 1),
(11, 1, 2),
(12, 2, 1),
(12, 1, 1),
(12, 4, 1),
(13, 2, 2),
(13, 1, 1),
(13, 3, 1),
(13, 6, 1),
(14, 2, 1),
(14, 3, 1),
(14, 4, 1),
(14, 6, 1),
(14, 5, 1),
(15, 12, 1),
(16, 1, 1),
(17, 1, 1),
(17, 2, 1),
(17, 3, 1),
(17, 4, 1),
(18, 1, 4),
(18, 2, 4),
(19, 1, 1),
(19, 2, 1),
(19, 3, 1),
(20, 2, 1),
(21, 4, 2),
(21, 3, 1),
(21, 6, 1),
(22, 1, 1),
(22, 2, 1),
(22, 3, 1),
(22, 5, 1),
(23, 34, 10),
(24, 1, 10),
(25, 2, 1),
(26, 1, 1),
(26, 2, 1),
(26, 4, 1),
(27, 2, 1),
(27, 1, 3),
(28, 1, 3),
(28, 2, 1),
(29, 1, 3),
(29, 2, 1),
(30, 3, 1),
(31, 3, 2),
(31, 5, 1),
(33, 4, 1),
(33, 6, 1),
(33, 2, 1),
(33, 5, 1),
(34, 13, 4),
(34, 8, 1),
(34, 9, 3),
(34, 4, 1),
(35, 15, 3),
(35, 19, 2),
(35, 20, 2),
(35, 21, 1),
(36, 23, 6),
(36, 22, 2),
(36, 29, 2),
(36, 33, 2),
(37, 36, 2),
(37, 34, 4),
(37, 32, 2),
(37, 31, 2),
(37, 30, 2),
(37, 20, 1),
(38, 12, 3),
(38, 11, 2),
(38, 9, 1),
(38, 10, 2),
(39, 10, 2),
(39, 9, 3),
(39, 25, 3),
(39, 22, 1),
(39, 29, 1),
(40, 18, 2),
(40, 34, 2),
(40, 5, 1),
(40, 3, 1),
(40, 2, 1),
(41, 6, 2),
(41, 5, 2),
(41, 15, 1),
(41, 14, 1),
(41, 17, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD PRIMARY KEY (`MaHD`,`MaMA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
