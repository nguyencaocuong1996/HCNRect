-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 08, 2017 lúc 09:40 PM
-- Phiên bản máy phục vụ: 10.1.22-MariaDB
-- Phiên bản PHP: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
-- Cấu trúc bảng cho bảng `ban`
--

CREATE TABLE `ban` (
  `MaBan` int(11) NOT NULL,
  `TenBan` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GhiChu` text COLLATE utf8_unicode_ci
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`MaBan`, `TenBan`, `GhiChu`) VALUES
(1, 'Bàn 1', 'Bàn thường 1'),
(2, 'Bàn 2', 'Bàn thường 2'),
(3, 'Bàn 3', 'Bàn thường 3'),
(4, 'Bàn 4', NULL),
(5, 'Bàn 5', NULL),
(6, 'Bàn 6', NULL),
(7, 'Bàn 7', NULL),
(8, 'Bàn 8', NULL),
(9, 'Bàn 9', NULL),
(10, 'Bàn 10', NULL),
(11, 'Bàn 11', NULL),
(12, 'Bàn 12', NULL),
(13, 'Bàn 13', NULL),
(14, 'Bàn 14', NULL),
(15, 'Bàn 15', NULL),
(16, 'Bàn 16', NULL),
(17, 'Bàn 17', NULL),
(18, 'Bàn 18', NULL),
(19, 'Bàn 19', NULL),
(20, 'Bàn 20', NULL),
(21, 'Bàn 21', NULL),
(22, 'Bàn 22', NULL),
(23, 'Bàn 23', NULL),
(24, 'Bàn 24', NULL),
(25, 'Bàn 25', NULL),
(26, 'Bàn 26', NULL),
(27, 'Bàn 27', NULL),
(28, 'Bàn 28', NULL),
(29, 'Bàn 29', NULL),
(30, 'Bàn 30', NULL),
(31, 'Bàn 31', NULL),
(32, 'Bàn 32', NULL),
(33, 'Bàn 33', NULL),
(34, 'Bàn 34', NULL),
(35, 'Bàn 35', NULL),
(36, 'Bàn 36', NULL),
(37, 'Bàn 37', NULL),
(38, 'Bàn 38', NULL),
(39, 'Bàn 39', NULL),
(40, 'Bàn 40', NULL),
(41, 'VIP 1', NULL),
(42, 'VIP 2', NULL),
(43, 'VIP 3', NULL),
(44, 'VIP 4', NULL),
(45, 'VIP 5', NULL),
(46, 'VIP 6', NULL),
(47, 'VIP 7', NULL),
(48, 'VIP 8', NULL),
(49, 'VIP 9', NULL),
(50, 'VIP 10', NULL),
(51, 'VIP 11', 'bàn vip 11'),
(52, 'VIP 12', 'Bàn Vip12'),
(53, 'VIP 13', 'Bàn này dùng để cho khách vip !!!');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_dat_mon`
--

CREATE TABLE `chi_tiet_dat_mon` (
  `MaBan` int(10) UNSIGNED NOT NULL,
  `MaMA` int(10) UNSIGNED NOT NULL,
  `SoLuong` int(3) UNSIGNED DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_dat_mon`
--

INSERT INTO `chi_tiet_dat_mon` (`MaBan`, `MaMA`, `SoLuong`) VALUES
(52, 5, 1),
(53, 4, 1),
(53, 7, 1),
(53, 3, 1),
(53, 5, 1),
(52, 3, 1);

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
(0, 2, 1),
(0, 1, 1),
(0, 3, 1),
(0, 4, 1),
(0, 6, 1),
(0, 5, 1),
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
(30, 2, 2),
(30, 4, 1),
(31, 4, 1),
(31, 7, 1),
(31, 24, 3),
(31, 29, 3),
(31, 20, 1),
(32, 2, 3),
(32, 3, 1),
(32, 10, 1),
(32, 12, 3),
(32, 15, 2),
(32, 18, 4),
(32, 23, 2),
(33, 7, 1),
(33, 8, 1),
(33, 6, 3),
(33, 4, 4),
(33, 17, 3),
(33, 32, 3),
(34, 17, 3),
(34, 23, 5),
(34, 24, 3),
(34, 32, 7),
(34, 36, 4),
(34, 27, 5),
(34, 21, 5),
(35, 2, 3),
(35, 3, 1),
(35, 10, 1),
(35, 15, 2),
(35, 18, 4),
(35, 23, 2),
(36, 20, 5),
(36, 22, 3),
(36, 21, 2),
(36, 25, 3),
(36, 26, 3),
(36, 27, 1),
(36, 13, 2),
(36, 12, 4),
(37, 12, 9),
(37, 10, 5),
(37, 11, 8),
(37, 17, 5),
(37, 18, 5),
(37, 19, 5),
(37, 23, 1),
(37, 25, 1),
(37, 24, 3),
(38, 12, 9),
(38, 10, 5),
(38, 11, 8),
(38, 17, 5),
(38, 18, 5),
(38, 19, 5),
(38, 23, 1),
(38, 25, 1),
(38, 24, 3),
(39, 7, 3),
(39, 5, 2),
(39, 4, 3),
(39, 6, 5),
(39, 3, 3),
(39, 2, 2),
(39, 10, 1),
(39, 11, 2),
(39, 9, 2),
(40, 2, 5),
(40, 4, 4),
(40, 8, 3),
(40, 9, 1),
(40, 13, 2),
(40, 12, 2),
(40, 10, 1),
(40, 14, 3),
(40, 15, 3),
(40, 16, 3),
(40, 17, 4),
(41, 26, 2),
(41, 24, 1),
(41, 27, 1),
(41, 29, 1),
(41, 30, 2),
(41, 34, 1),
(41, 32, 1),
(42, 7, 3),
(42, 5, 2),
(42, 4, 3),
(42, 6, 5),
(42, 3, 3),
(42, 2, 2),
(42, 10, 1),
(42, 11, 2),
(42, 9, 2),
(43, 24, 1),
(43, 26, 1),
(43, 27, 1),
(43, 30, 1),
(44, 5, 1),
(44, 9, 1),
(44, 10, 1),
(44, 11, 1),
(44, 12, 2),
(44, 15, 1),
(44, 17, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_phieu_nhap`
--

CREATE TABLE `chi_tiet_phieu_nhap` (
  `MaPNH` int(10) UNSIGNED NOT NULL,
  `MaNL` int(10) UNSIGNED NOT NULL,
  `SoLuongNhap` float UNSIGNED DEFAULT NULL,
  `GiaNhap` float UNSIGNED DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_phieu_nhap`
--

INSERT INTO `chi_tiet_phieu_nhap` (`MaPNH`, `MaNL`, `SoLuongNhap`, `GiaNhap`) VALUES
(3, 2, 1, 50000),
(3, 31, 1, 6000),
(4, 4, 5, 15000),
(4, 5, 4, 20000),
(4, 6, 4, 60000),
(4, 31, 1, 0),
(5, 6, 4, 99999),
(5, 7, 4, 88888),
(8, 2, 8, 100000),
(8, 31, 8, 50000),
(9, 2, 4, 50000),
(9, 4, 2, 10000),
(9, 5, 4, 15000),
(9, 31, 5, 10000),
(10, 2, 10, 20000),
(10, 31, 10, 10000),
(11, 31, 40, 10000),
(12, 4, 20, 20000),
(12, 5, 20, 30000),
(13, 13, 100, 9000),
(13, 14, 100, 15000),
(13, 15, 100, 10000),
(14, 5, 100, 20000),
(14, 6, 100, 50000),
(15, 2, 50, 40000),
(15, 3, 50, 50000),
(16, 12, 200, 10000),
(16, 15, 200, 10000),
(17, 4, 50, 58000),
(17, 5, 50, 54000),
(18, 7, 50, 33000),
(18, 8, 50, 30000),
(18, 9, 50, 28000),
(19, 6, 50, 100000),
(19, 10, 50, 60000),
(19, 11, 50, 180000),
(20, 16, 144, 15000),
(20, 13, 144, 15000),
(21, 18, 96, 5000),
(21, 19, 96, 5000),
(21, 20, 96, 4000),
(21, 21, 96, 4000),
(22, 18, 168, 5000),
(22, 20, 168, 4000),
(23, 22, 624, 4000),
(24, 23, 80, 19000),
(24, 24, 60, 12000),
(24, 27, 30, 9000),
(24, 28, 40, 7500),
(25, 32, 60, 6000),
(25, 33, 85, 9000),
(25, 25, 100, 1000),
(25, 26, 70, 35000),
(26, 32, 60, 6000),
(26, 33, 85, 9000),
(26, 25, 100, 1000),
(26, 26, 70, 35000),
(27, 34, 50, 120000),
(27, 36, 30, 25000),
(27, 38, 45, 80000),
(27, 29, 100, 100000),
(28, 35, 50, 1000),
(28, 37, 100, 6000),
(28, 39, 20, 2000),
(28, 42, 100, 2000),
(29, 60, 30, 400000),
(29, 61, 40, 600000),
(29, 62, 80, 700000),
(30, 48, 70, 50000),
(30, 49, 150, 25000),
(30, 51, 60, 2000),
(30, 38, 80, 80000),
(31, 40, 50, 40000),
(31, 41, 60, 50000),
(31, 43, 100, 60000),
(31, 44, 70, 50000),
(32, 53, 100, 2000),
(32, 56, 250, 5000),
(32, 26, 90, 50000),
(32, 59, 100, 15000),
(33, 2, 100, 40000),
(33, 3, 150, 50000),
(33, 26, 200, 50000),
(34, 52, 200, 7000),
(34, 57, 140, 8000),
(34, 58, 80, 20000),
(34, 47, 100, 10000),
(35, 6, 10, 300000),
(35, 7, 80, 30000),
(35, 8, 80, 70000),
(35, 9, 30, 40000),
(36, 16, 48, 15000),
(36, 17, 48, 15000),
(36, 12, 48, 15000),
(36, 13, 48, 15000),
(36, 14, 48, 15000),
(36, 15, 48, 15000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cong_thuc`
--

CREATE TABLE `cong_thuc` (
  `MaMA` int(10) UNSIGNED NOT NULL,
  `MaNL` int(10) UNSIGNED NOT NULL,
  `LuongCan` float DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cong_thuc`
--

INSERT INTO `cong_thuc` (`MaMA`, `MaNL`, `LuongCan`) VALUES
(1, 2, 0.6),
(2, 7, 0.5),
(2, 24, 0.2),
(3, 1, 0.5),
(3, 12, 1),
(3, 25, 2),
(4, 26, 0.5),
(4, 27, 0.002),
(5, 10, 1),
(5, 28, 0.5),
(6, 1, 0.3),
(7, 2, 0.5),
(16, 2, 1),
(16, 31, 0.2),
(16, 32, 0.01),
(17, 34, 5),
(17, 35, 0.01),
(18, 29, 1),
(18, 36, 1),
(19, 2, 3),
(19, 35, 0.01),
(19, 37, 0.1),
(20, 38, 2),
(20, 39, 0.3),
(21, 29, 0.5),
(21, 32, 0),
(21, 37, 0),
(22, 40, 0.2),
(22, 42, 0.01),
(23, 41, 0.2),
(23, 42, 0.01),
(24, 43, 0),
(24, 32, 0.01),
(24, 28, 0.02),
(25, 44, 0.2),
(25, 35, 0.01),
(26, 45, 0.5),
(26, 35, 0.01),
(26, 37, 0.2),
(27, 3, 0.2),
(27, 28, 0.01),
(28, 46, 0.05),
(28, 47, 0.02),
(29, 48, 0.3),
(29, 28, 0.01),
(30, 34, 0.3),
(30, 35, 0.01),
(31, 49, 0.3),
(31, 35, 0.01),
(32, 50, 0.5),
(32, 51, 0.01),
(7, 25, 3),
(8, 52, 0.2),
(8, 5, 0.2),
(9, 53, 2),
(9, 50, 0.03),
(9, 6, 0.03),
(10, 54, 0.2),
(11, 55, 3),
(12, 1, 0.3),
(12, 56, 0.02),
(13, 12, 1),
(14, 54, 0.3),
(14, 57, 0.2),
(15, 58, 0.5),
(33, 17, 1),
(34, 19, 1),
(35, 20, 1),
(36, 16, 1),
(1, 31, 0.5),
(37, 6, 0.5),
(37, 59, 0.3),
(38, 34, 0.3),
(38, 35, 0.001),
(39, 25, 0.02),
(39, 31, 0.002),
(40, 6, 0.2),
(40, 52, 0.02),
(42, 46, 0.02),
(42, 23, 0.04),
(43, 50, 0.2),
(43, 24, 0.01),
(44, 32, 0.01),
(44, 10, 0.2),
(45, 20, 0.04),
(45, 53, 0.02),
(46, 9, 0.02),
(46, 16, 0.04),
(47, 33, 0.3),
(47, 49, 0.006),
(48, 39, 0.04),
(48, 29, 0.022),
(49, 19, 0.22),
(49, 39, 0.01),
(50, 15, 0.044),
(50, 25, 0.02),
(51, 35, 0.006),
(51, 45, 0.07),
(52, 55, 0.15),
(52, 16, 0.2),
(53, 26, 0.015),
(53, 36, 0.06),
(54, 53, 0.12),
(54, 12, 0.04),
(55, 32, 0.23),
(55, 42, 0.078),
(56, 52, 0.04),
(56, 13, 0.06),
(57, 23, 0.055),
(57, 33, 0.023),
(58, 43, 0.33),
(58, 33, 0.13),
(59, 53, 0.13),
(59, 12, 0.18),
(60, 14, 0.3),
(60, 24, 0.04),
(61, 34, 0.035),
(61, 44, 0.02),
(61, 66, 0.05),
(62, 65, 1),
(63, 60, 1),
(64, 61, 1),
(65, 62, 1),
(66, 63, 0.2),
(67, 58, 0.5),
(68, 67, 0.4),
(69, 57, 0.23),
(70, 64, 1),
(71, 55, 0.1),
(72, 34, 0.03),
(73, 58, 0.2),
(74, 22, 0.13),
(75, 16, 0.05),
(76, 64, 0.3),
(77, 48, 0.1),
(78, 54, 0.2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoa_don`
--

CREATE TABLE `hoa_don` (
  `MaHD` int(10) UNSIGNED NOT NULL,
  `MaKH` int(10) UNSIGNED DEFAULT NULL,
  `MaNV` int(10) UNSIGNED NOT NULL,
  `NgayLapHD` datetime NOT NULL,
  `TriGiaHD` float DEFAULT '0',
  `MaBan` int(10) NOT NULL,
  `MaPGG` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TriGiaThuc` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoa_don`
--

INSERT INTO `hoa_don` (`MaHD`, `MaKH`, `MaNV`, `NgayLapHD`, `TriGiaHD`, `MaBan`, `MaPGG`, `TriGiaThuc`) VALUES
(1, 1, 6, '2017-06-11 12:00:00', 100000, 1, NULL, 85000),
(2, 1, 6, '2017-05-22 12:07:18', 500000, 1, NULL, 425000),
(3, 2, 6, '2017-07-22 12:10:12', 500000, 23, NULL, 425000),
(4, 1, 6, '2017-05-22 12:16:49', 1390000, 24, NULL, 1181500),
(5, 1, 6, '2017-05-22 12:17:29', 670000, 1, NULL, 569500),
(6, 3, 6, '2015-05-24 08:48:32', 400000, 1, NULL, 340000),
(7, 1, 6, '2015-05-25 11:19:07', 500000, 1, NULL, 425000),
(8, 1, 6, '2016-08-25 11:21:34', 530000, 3, NULL, 450500),
(9, 1, 6, '2016-05-25 11:25:25', 500000, 4, NULL, 425000),
(10, 5, 6, '2016-05-25 11:25:25', 500000, 4, NULL, 425000),
(11, 1, 6, '2015-05-25 11:27:35', 470000, 2, NULL, 399500),
(12, 1, 6, '2015-06-25 11:28:24', 370000, 2, NULL, 314500),
(13, 4, 1, '2017-05-25 11:35:53', 680000, 4, NULL, 578000),
(14, 1, 1, '2017-08-25 11:37:03', 670000, 3, NULL, 569500),
(15, 1, 1, '2017-05-26 08:42:39', 50000, 44, NULL, 42500),
(16, 4, 4, '2017-05-31 12:56:49', 500000, 53, NULL, 425000),
(17, 0, 4, '2017-05-31 12:58:53', 500000, 53, NULL, 425000),
(18, 5, 4, '2017-05-31 13:02:08', 1000000, 53, NULL, 850000),
(19, 0, 1, '2015-03-01 17:27:21', 380000, 53, NULL, 323000),
(20, 2, 1, '2016-07-01 18:20:53', 150000, 51, NULL, 127500),
(21, 4, 1, '2015-06-01 18:58:50', 520000, 50, NULL, 442000),
(22, 4, 1, '2017-04-07 18:58:50', 500000, 51, NULL, 425000),
(23, 12, 1, '2017-01-01 22:35:28', 100000, 51, NULL, 85000),
(24, 9, 1, '2017-01-01 22:38:11', 1000000, 49, NULL, 850000),
(25, 12, 1, '2016-04-09 22:39:40', 150000, 48, NULL, 127500),
(26, 0, 1, '2016-06-01 22:42:44', 370000, 43, NULL, 314500),
(27, 12, 1, '2017-03-01 22:45:42', 450000, 51, NULL, 382500),
(28, 0, 1, '2017-04-01 22:47:56', 450000, 51, NULL, 382500),
(29, 4, 1, '2017-05-01 23:05:18', 450000, 51, NULL, 382500),
(30, 4, 1, '2015-07-03 18:48:04', 420000, 53, 'HCNAHIHI', 378000),
(31, 4, 4, '2016-09-08 21:29:41', 1535000, 52, 'null', 1535000),
(32, 9, 4, '2016-06-08 21:29:41', 1390000, 36, 'HCNAHIHI', 1153700),
(33, 5, 4, '2017-03-28 21:29:41', 2295000, 42, 'HCNAHIHI', 1904850),
(34, 12, 4, '2017-02-07 21:29:41', 4147000, 24, 'HCNCUONG', 2902900),
(35, 8, 4, '2017-01-08 21:29:41', 1240000, 36, 'HCNCUONG', 1054000),
(36, 10, 4, '2015-12-08 21:29:41', 2722000, 50, 'HCNCUONG', 2123160),
(37, 10, 4, '2016-06-09 21:29:41', 5390000, 7, 'HCN16', 4473700),
(38, 10, 4, '2017-03-01 21:29:41', 5390000, 7, 'HCN16', 4473700),
(39, 3, 4, '2017-05-07 21:29:41', 3300000, 47, 'HCN16', 2739000),
(40, 5, 4, '2016-12-15 21:29:41', 3051000, 38, 'HCNHUY', 2532330),
(41, 5, 4, '2016-08-08 21:29:41', 1240000, 30, 'HCNHUY', 1029200),
(42, 4, 4, '2016-06-08 21:29:41', 3300000, 47, 'HCNHUY', 2970000),
(43, 2, 4, '2015-05-08 21:29:41', 485000, 27, 'HCNHUY', 412250),
(44, 12, 1, '2017-06-09 02:39:07', 760000, 47, 'null', 760000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_hang`
--

CREATE TABLE `khach_hang` (
  `MaKH` int(11) UNSIGNED NOT NULL,
  `HoTenKH` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDTKH` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `MaLKH` int(10) UNSIGNED DEFAULT NULL,
  `DiaChiKH` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khach_hang`
--

INSERT INTO `khach_hang` (`MaKH`, `HoTenKH`, `SDTKH`, `MaLKH`, `DiaChiKH`) VALUES
(1, 'Nguyễn Vắn A', '01258472474', 1, '12 Láng Hạ, Phường 1, Quận 1, TP HCM'),
(2, 'Trần Thị Thu Thủy', '0955814728', 3, '221/54 Phạm Thi, Phường 3, Quận Hải Châu, TP Đà Nẵng'),
(3, 'Trần Nguyên Cảnh', '094565313', 3, '14 Tân Lập, Phường 13, Quận Thủ Đức, TP HCM'),
(4, 'Sơn Tùng', '012454323', 1, '32 Lâm Viên, Phường 7, Quận 2, TP HCM'),
(5, 'Phước Thịnh', '093214952', 3, '67 Lê Văn Trí, Phường 5, Quận 9, TP HCM'),
(6, 'Đông Nhi', '0128384384', 2, '231 Trương Văn Hải, Phường 13, Quận Bình Thạnh, TP HCM'),
(7, 'Tóc Tiên', '096818439', 2, '594 Đình Phong Phú, Phường 2, Quận 1, TP Nha Trang'),
(8, 'Thu Minh', '0128838838', 3, '342 Nguyễn Chánh, Phường 2, Quận9, TP HCM'),
(9, 'Ông Cao Thắng', '093438842', 3, '12 Nguyễn Lương Bằng, Phường 9, Quận Tân Bình, TP HCM'),
(10, 'Ưng Hoàng Phúc', '092381248', 4, '44/121 Phạm Ngũ Lão, Phường 12, Quận 2, TP HCM'),
(12, 'Nguyễn Cao Cường', '01689179348', 3, 'Thủ Đức, TPHCM'),
(21, 'Huỳnh Tuấn Anh', '012458478698', 2, 'Thủ Đức, TP HCM'),
(16, 'Trần Hữu Duy', '0905358224', 2, '21 Trần Văn Cẩn, Đà Nẵng'),
(17, 'Lê Thị Châu', '09053582243', 2, '21 Trần Văn Cẩn, Đà Nẵng'),
(18, 'Trần Anh Quốc', '012585842294', 2, 'Đà Nẵng'),
(19, 'Võ Quang', '0124584785', 5, 'Liên Chiểu, Đà Nẵng'),
(20, 'Lê Thanh Trọng', '012458478554', 5, 'Thủ Đức, TP HCM');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_khach_hang`
--

CREATE TABLE `loai_khach_hang` (
  `MaLKH` int(11) NOT NULL,
  `TenLKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `GhiChuLKH` text COLLATE utf8_unicode_ci,
  `SoTienToiThieu` float DEFAULT NULL,
  `PhanTramGiamGia` float DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loai_khach_hang`
--

INSERT INTO `loai_khach_hang` (`MaLKH`, `TenLKH`, `GhiChuLKH`, `SoTienToiThieu`, `PhanTramGiamGia`) VALUES
(1, 'Vãng lai', 'Không được ưu đãi', 0, 0),
(2, 'Bạc', 'Được giảm giá 5%', 1000000, 5),
(3, 'Vàng', 'Được giảm giá 7%', 3000000, 7),
(4, 'Bạch kim', 'Được giảm giá 10%', 10000000, 10),
(5, 'Kim cương', 'Được giảm giá 15%', 20000000, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mon_an`
--

CREATE TABLE `mon_an` (
  `MaMA` int(10) UNSIGNED NOT NULL,
  `TenMA` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GiaMA` float UNSIGNED DEFAULT NULL,
  `DiaChiAnhMA` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaTD` int(10) UNSIGNED DEFAULT '5'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `mon_an`
--

INSERT INTO `mon_an` (`MaMA`, `TenMA`, `GiaMA`, `DiaChiAnhMA`, `MaTD`) VALUES
(2, 'Cá diêu hồng xốt cam', 150000, 'salmon-teriyaki.jpg', 2),
(3, 'Bò sốt chanh cơm tấm', 130000, 'lemon-rice.jpg', 2),
(4, 'Sườn heo kho tiêu ', 120000, 'salmon.jpeg', 2),
(5, 'Ếch xào sả ớt ', 120000, 'tranmautritam.jpeg', 2),
(6, 'Pizza', 150000, 'pizza.jpeg', 2),
(7, 'Bánh mì kẹp thịt', 200000, 'bread-sandwich.jpg', 1),
(8, 'Salad gà xé', 130000, 'sala-spinach.jpg', 1),
(9, 'Mì xào hải sản', 120000, 'Pasta.jpeg', 2),
(10, 'Rượu vang đỏ', 120000, 'Beverage-wine.jpeg', 4),
(11, 'Bánh kem socola', 150000, 'hamani.jpeg', 3),
(12, 'Phở bò', 50000, 'Pho.jpeg', 2),
(13, 'Bia Tiger', 16000, 'tiger.jpg', 4),
(14, 'Cocktails Chanh', 13000, 'cocktails-lemon.jpeg', 4),
(15, 'Nước dâu', 30000, 'Strawberry-Juice.jpeg', 4),
(16, 'beefsteak sốt tiêu', 150000, 'beefsteak_sot_tieu.jpg', 2),
(17, 'Gà nướng', 120000, 'ga_nuong.jpg', 2),
(18, 'Bánh canh ghẹ', 80000, 'banh_canh_ghe.jpg', 2),
(19, 'Heo mẹt', 300000, 'heo_met.jpg', 2),
(20, 'Lẩu dê', 150000, 'lau_de.jpg', 2),
(21, 'Cua rang me', 200000, 'cua_rang_me.jpg', 1),
(22, 'Ốc cúc', 70000, 'oc_cuc.jpg', 1),
(23, 'Ốc hoàng', 80000, 'oc_hoang.jpg', 1),
(24, 'Rạn biển', 120000, 'ran_bien.jpg', 2),
(25, 'Mực Một Nắng chiên mắm', 200000, 'muc_mot_nang_chien_nuoc_mam.jpg', 2),
(26, 'Bạch tuộc nướng', 150000, 'bach_tuoc_nuong.jpg', 5),
(27, 'Phá lấu', 80000, 'pha_lau.jpg', 2),
(28, 'Sushi', 100000, 'sushi.jpg', 1),
(29, 'Vẹm hấp', 235000, 'vem_hap.jpg', 2),
(30, 'Gà bó xôi', 135000, 'ga_bo_xoi.jpg', 2),
(31, 'Cút quay', 105000, 'cut_quay.jpg', 2),
(32, 'Hào Pháp nướng phomai', 225000, 'hao_phap_nuong_phomai.jpg', 2),
(33, 'Bia Heineken', 17000, 'heineken.jpg', 4),
(34, 'Pepsi', 10000, 'pepsi.jpg', 4),
(35, 'Coca Cola', 10000, 'cocacola.jpg', 4),
(36, 'Bia Larue', 13000, 'larue.jpg', 4),
(37, 'Chạo tôm', 20000, 'Chao-tom.jpg', 1),
(38, 'Gà cuốn lá nếp', 25000, 'ga-cuon-la-nep.jpg', 1),
(39, 'Gỏi gà bắp cải', 15000, 'goi-ga-bap-cai.jpg', 1),
(40, 'Gỏi tôm thịt', 25000, 'goi-tom-thit.jpg', 1),
(41, 'Salad Nga', 25000, 'mon-salad-nga.jpg', 1),
(42, 'Ram chiên giòn', 23000, 'Ram-chien-gion.jpg', 1),
(43, 'Salad khoai lang', 15000, 'salad-khoai-lang.jpg', 1),
(44, 'Súp gà', 23000, 'sup-ga.jpg', 1),
(45, 'Thịt heo cuốn xả', 30000, 'thit-heo-cuon-xa.jpg', 1),
(46, 'Mực nhồi thịt', 33000, 'muc-nhoi-thit.jpg', 1),
(47, 'Tôm cuộn khoai tây', 33000, 'tom-cuon-khoai-tay.jpg', 1),
(48, 'Tôm hùm nướng', 35000, 'tom-hum-nuong.jpg', 1),
(49, 'Trứng cuộn', 22000, 'trung-cuon.jpg', 1),
(50, 'Xôi khoai tây', 20000, 'xoi-khoai-tay.jpg', 1),
(51, 'Cá diêu hồng chiên xù', 45000, 'ca-dieu-hong-chien-xu.jpg', 2),
(52, 'Cánh gà chiên nước mắm', 36000, 'canh-ga-chien-nuoc-mam.jpg', 2),
(53, 'Lẩu chay', 150000, 'lau-chay.jpg', 2),
(54, 'Lẩu hải sản', 250000, 'lau-hai-san.jpg', 2),
(55, 'Lẩu nấm', 150000, 'lau-nam.jpg', 2),
(56, 'Lẩu Thái chua cay', 200000, 'lau-thai-chua-cay.jpg', 2),
(57, 'Lẩu thịt vịt', 200000, 'lau-thit-vit.jpg', 2),
(58, 'Mực sốt cà', 150000, 'muc-sot-ca.jpg', 2),
(59, 'Sườn bò xông khói', 250000, 'suon-bo-xong-khoi.jpg', 2),
(60, 'Vịt quay Bắc Kinh', 230000, 'vit-quay-bac-kinh.jpg', 2),
(61, 'coffee', 50000, 'coffee.jpg', 4),
(62, 'Nước dừa', 20000, 'nuoc-dua.jpg', 4),
(63, 'Rượu Chivas', 300000, 'ruou-chivas.jpg', 4),
(64, 'Rượu Raynal', 350000, 'ruou-Raynal.jpg', 4),
(65, 'Rượu van', 330000, 'ruou-van.jpg', 4),
(66, 'Sinh tố bơ', 25000, 'sinh-to-bo.jpg', 4),
(67, 'Sinh tố dâu ', 25000, 'sinh-to-dau.jpg', 4),
(68, 'Sinh tố xoài', 25000, 'sinh-to-xoai.jpg', 4),
(69, 'Trà chanh', 15000, 'tra-chanh.jpg', 4),
(70, 'Rượu Voka Men', 250000, 'voka-men.jpg', 4),
(71, 'Bánh plan', 25000, 'banh-plan.jpg', 3),
(72, 'kem cokie', 30000, 'cokie.jpg', 3),
(73, 'Dâu tây kem tươi ', 33000, 'dau-tay-kem-tuoi.jpg', 3),
(74, 'Đu đủ', 15000, 'du-du.jpg', 3),
(75, 'Kem chocolate', 50000, 'kem-chocolate.jpg', 3),
(76, 'Rau câu', 50000, 'rau-cau.jpg', 3),
(77, 'Chocolate kem chuối', 30000, 'shocolate-kem-chuoi.jpg', 3),
(78, 'Dĩa trái cây', 50000, 'trai-cay-tuoi.jpg', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguyen_lieu`
--

CREATE TABLE `nguyen_lieu` (
  `MaNL` int(10) UNSIGNED NOT NULL,
  `TenNL` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuongTon` float DEFAULT NULL,
  `DonVi` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MucToiThieu` float UNSIGNED DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nguyen_lieu`
--

INSERT INTO `nguyen_lieu` (`MaNL`, `TenNL`, `SoLuongTon`, `DonVi`, `MucToiThieu`) VALUES
(31, 'Đậu bắp', 142, 'kg', 2),
(2, 'Thịt ba chỉ', 186.5, 'kg', 20),
(3, 'Thịt trâu', 220, 'kg', 20),
(4, 'Cánh gà ta', 155, 'kg', 20),
(5, 'Chân gà ta', 222, 'kg', 20),
(6, 'Tôm sú', 249.97, 'kg', 20),
(7, 'Cá diêu hồng', 143.5, 'kg', 20),
(8, 'Cá chép', 150, 'kg', 20),
(9, 'Cá kèo', 150, 'kg', 20),
(10, 'ếch', 198, 'kg', 20),
(11, 'Lươn', 150, 'kg', 20),
(12, 'Bia Tiger (Lon)', 96, 'Lon', 50),
(13, 'Bia Larue(Lon)', 300, 'Lon', 50),
(14, 'Bia Heniken(Lon)', 300, 'Lon', 50),
(15, 'Bia Tiger(Chai)', 400, 'Chai', 50),
(16, 'Bia Larue(Chai)', 300, 'Chai', 50),
(17, 'Bia Heniken(Chai)', 300, 'Chai', 50),
(18, 'CocaCola(Lon)', 100, 'Lon', 50),
(19, 'Pepsi(Lon)', 90, 'Lon', 50),
(20, 'CocaCola(Chai)', 150, 'Chai', 50),
(21, 'Pepsi(Chai)', 150, 'Chai', 50),
(22, 'Nước suối', 100, 'Chai', 50),
(23, 'Đậu đỏ', 101.9, 'kg', 20),
(24, 'Cam', 147.4, 'kg', 20),
(25, 'Bánh mì ', 92, 'ổ', 15),
(26, 'Sườn heo', 98, 'kg', 20),
(27, 'Tiêu đen', 49.992, 'kg', 10),
(28, 'Sả', 99, 'kq', 10),
(29, 'Cua biển', 100, 'kg', 10),
(32, 'Tỏi', 20, 'kg', 2),
(33, 'Khoai tây', 20, 'kg', 5),
(34, 'Gà (nguyên con)', 20, 'kg', 10),
(35, 'Rau răm', 1.99, 'kg', 0.5),
(36, 'Chả cá', 15, 'kg', 1),
(37, 'Tương ớt', 15, 'kg', 5),
(38, 'Thịt dê', 10, 'kg', 5),
(39, 'Củ cải đường', 5, 'kg', 1),
(40, 'Ốc cúc', 10, 'kg', 3),
(41, 'ỐC hoàng', 10, 'kg', 3),
(42, 'Đậu phộng', 12, 'kg', 0.5),
(43, 'Rạn biển', 10, 'kg', 2),
(44, 'Mực biển', 10, 'kg', 2),
(45, 'Bạch tuộc', 10, 'kg', 2),
(46, 'Cá Thu', 15, 'kg', 3),
(47, 'Cà rốt', 15, 'kg', 1),
(48, 'Vẹm biển ', 10, 'kg', 3),
(49, 'Chim cút', 15, 'kg', 5),
(50, 'Hào', 9.97, 'kg', 5),
(51, 'Phô mai', 12, 'kg', 0.5),
(1, 'Thịt bò', 297.1, 'kg', 10),
(52, 'Rau salad', 13, 'kg', 1),
(53, 'Mỳ tôm', 98, 'gói', 10),
(54, 'Rượu vang đỏ', 99.8, 'lít', 20),
(55, 'Bánh kem Socola', 17, 'g', 5),
(56, 'bánh phở', 4.96, 'kg', 2),
(57, 'Chanh', 30, 'kg', 10),
(58, 'Dâu', 9.5, 'kg', 2),
(59, 'Bột nở', 30, 'kg', 10),
(60, 'Rượu Chivas', 5, 'chai', 1),
(61, 'Rượu Raynal', 5, 'chai', 1),
(62, 'Rượu van', 5, 'chai', 1),
(63, 'Bơ', 15, 'kg', 2),
(64, 'Rượu voka men', 10, 'chai', 2),
(65, 'Dừa', 10, 'trái', 2),
(66, 'Coffee', 25, 'kg', 5),
(67, 'Xoài', 15, 'kg', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `MaNV` int(10) UNSIGNED NOT NULL,
  `HoTenNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SDTNV` varchar(12) CHARACTER SET latin1 NOT NULL,
  `DiaChiNV` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MaPB` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhan_vien`
--

INSERT INTO `nhan_vien` (`MaNV`, `HoTenNV`, `SDTNV`, `DiaChiNV`, `MaPB`) VALUES
(11, 'Nguyễn Nguyên Duy', '0989787787', 'Gần Cái Chùa, Thích Quảng Đức, Phú Nhận, TP HCM', 1),
(1, 'Nguyễn Cao Cường', '01689179348', 'Thủ Đức, TP Hồ Chí Minh', 1),
(4, 'Lê Thành Tuấn', '0989088888', 'Quận 2, TPHCM', 3),
(5, 'Trần Khánh Nguyên', '01214231041', '72 Nam Cao, Tân Phú, Quận 9, TP Hồ Chí Minh', 2),
(6, 'Phùng Trọng Huy', '0989786561', '24 Thành Công, Tân Phú, TP Hồ Chí Minh', 1),
(8, 'Lê Văn Luyện', '01234134231', '8 Nguyễn Huệ, Quận 1, TP Hồ Chí Minh', 1),
(9, 'Nguyễn Thanh Tùng', '0987162754', '24 Phú Mỹ Hưng, Q7, TP Hồ Chí Minh', 1),
(10, 'Đàm Vĩnh Hưng', '0989999999', '87 Phú Mỹ Hưng, Q7, TP Hồ Chí Minh', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nha_cung_cap`
--

CREATE TABLE `nha_cung_cap` (
  `MaNCC` int(10) UNSIGNED NOT NULL,
  `TenNCC` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDTNCC` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChiNCC` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MoTaNCC` text COLLATE utf8_unicode_ci
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nha_cung_cap`
--

INSERT INTO `nha_cung_cap` (`MaNCC`, `TenNCC`, `SDTNCC`, `DiaChiNCC`, `MoTaNCC`) VALUES
(1, 'Công ty TNHH ThaCo', '012453098', '31 Nguyễn Trãi, Phường 3, Quận 4', 'Cung cấp thủy, hải sản'),
(2, 'Công ty Hải Vân', '090343434', '124 Nguyễn Thị Minh Khai, Phường 9, Quận 3', 'Cung cấp thịt'),
(3, 'Công ty Hoàng Gia ', '093676767', '288 Trường Chinh, Phường 7, Quận 8', 'Cung cấp gia vị'),
(4, 'Công ty Đại Việt', '0122898989', '1A KCN Thủ Đức, Phường 2, Quận Thủ Đức', 'Cung cấp ếch'),
(5, 'Công ty TNHH Pramic', '090656565', '91 Nguyễn Huy Tưởng, Phường 1, Quận 3', 'Cung cấp thịt Dê'),
(6, 'Cửa hàng Hồng Phúc', '091231230', '12 Nguyễn Lương Bằng, Phường 10, Quận 4', 'Cung cấp bánh ngọt'),
(7, 'Công ty TNHH Tiger', '012787878', '89 Thăng Long, Phường 11, Quận 9', 'Cung cấp bia'),
(8, 'Công ty TNHH Coca', '098567896', '6B Kênh Hạc, Phường 13, Quận 12', 'Cung cấp nước ngọt'),
(9, 'Công ty Văn Trỗi', '012454545', '44 Bàu Mạc, Phường 11, Quận 8', 'Cung cấp lươn'),
(10, 'Công ty Thống Nhất', '0235654421', '34/313 Việt Cồ, Phường 2, Quận 7', 'Cung cấp rau'),
(11, 'Công ty Nam Cường', '0166898989', '32A Hoàng Hoa Thám, Phường 6, Bà Rịa - Vũng Tàu', 'Cung cấp cua biển');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_chi_ncc`
--

CREATE TABLE `phieu_chi_ncc` (
  `MaPCNCC` int(10) NOT NULL,
  `MaNCC` int(10) NOT NULL,
  `NgayChi` date DEFAULT NULL,
  `SoTienChi` float DEFAULT NULL,
  `GhiChuPC` text COLLATE utf8_unicode_ci,
  `MaNV` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieu_chi_ncc`
--

INSERT INTO `phieu_chi_ncc` (`MaPCNCC`, `MaNCC`, `NgayChi`, `SoTienChi`, `GhiChuPC`, `MaNV`) VALUES
(1, 1, '2017-05-08', 100000, 'lý do là đang test phần mềm', 1),
(2, 5, '2017-05-08', 200000, 'thich thì chi', 1),
(3, 1, '2017-06-08', 200000, 'ád', 1),
(4, 5, '2017-06-08', 300000, 'ád', 1),
(5, 1, '2017-06-08', 3000000, 'Tra tien dau thang', 1),
(6, 1, '2017-06-08', 4000000, 'trả tiền nợ giữa tháng', 1),
(7, 1, '2017-06-08', 4000000, 'trả tiền', 1),
(8, 1, '2017-06-08', 5000000, 'trả tiền', 1),
(9, 2, '2017-05-08', 80000, 'trả tiền đầu tháng', 1),
(10, 2, '2017-06-08', 1250000, 'trả tiền', 1),
(11, 2, '2017-06-08', 2500000, 'trả tiền', 1),
(12, 2, '2017-06-08', 4000000, 'trả tiền\n', 1),
(13, 3, '2017-05-08', 56000, 'trả tiền đầu tháng', 1),
(14, 3, '2017-06-08', 10000000, 'trả tiền', 1),
(15, 3, '2017-06-08', 7500000, 'trả tiền', 1),
(16, 3, '2017-06-08', 12000000, 'trả tiền', 1),
(17, 3, '2017-06-08', 2400000, 'trả tiền', 1),
(18, 3, '2017-06-08', 6000000, 'trả tiền', 1),
(19, 3, '2017-06-08', 6000000, 'trả tiền', 1),
(20, 4, '2017-05-08', 100000, 'trả tiền đầu tháng', 1),
(21, 4, '2017-06-08', 3000000, 'trả tiền', 1),
(22, 4, '2017-06-08', 500000, 'trả tiền', 1),
(23, 4, '2017-06-08', 1000000, 'trả tiền', 1),
(24, 4, '2017-06-08', 2000000, 'trả tiền', 1),
(25, 4, '2017-06-08', 1000000, 'trả tiền', 1),
(26, 5, '2017-06-08', 2000000, 'trả tiền đầu tháng', 1),
(27, 5, '2017-06-08', 2000000, 'trả tiền', 1),
(28, 5, '2017-06-08', 4000000, 'trả tiền ', 1),
(29, 6, '2017-05-08', 3000000, 'trả tiền đầu tháng', 1),
(30, 6, '2017-06-08', 1000000, 'trả tiền', 1),
(31, 6, '2017-06-08', 2500000, 'trả tiền', 1),
(32, 7, '2017-05-08', 1000000, 'trả tiền đầu tháng', 1),
(33, 7, '2017-06-08', 15000000, 'trả tiền', 1),
(34, 7, '2017-06-08', 24000000, 'trả tiền', 1),
(35, 7, '2017-06-08', 30000000, 'trả tiền', 1),
(36, 7, '2017-06-08', 10000000, 'trả tiền', 1),
(37, 7, '2017-06-08', 2000000, 'trả tiền', 1),
(38, 7, '2017-06-08', 4000000, 'trả tiền', 1),
(39, 8, '2017-05-08', 700000, 'trả tiền đầu tháng', 1),
(40, 8, '2017-06-08', 400000, 'trả tiền', 1),
(41, 9, '2017-05-08', 700000, 'trả tiền đầu tháng', 1),
(42, 9, '2017-06-08', 4000000, 'trả tiền', 1),
(43, 9, '2017-06-08', 3000000, 'trả tiền', 1),
(44, 9, '2017-06-08', 3000000, 'trả tiền', 1),
(45, 10, '2017-05-08', 300000, 'trả tiền đầu tháng', 1),
(46, 10, '2017-06-08', 6000000, 'trả tiền', 1),
(47, 10, '2017-06-08', 6000000, 'trả tiền', 1),
(48, 10, '2017-06-08', 10000000, 'trả tiền', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_dat_ban`
--

CREATE TABLE `phieu_dat_ban` (
  `MaPDB` int(10) UNSIGNED NOT NULL,
  `MaBan` int(10) UNSIGNED NOT NULL,
  `MaKH` int(10) UNSIGNED NOT NULL,
  `NgayGioDatBan` datetime NOT NULL,
  `TrangThai` tinyint(2) UNSIGNED NOT NULL DEFAULT '0',
  `GhiChu` text COLLATE utf8_unicode_ci
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieu_dat_ban`
--

INSERT INTO `phieu_dat_ban` (`MaPDB`, `MaBan`, `MaKH`, `NgayGioDatBan`, `TrangThai`, `GhiChu`) VALUES
(1, 2, 1, '2016-12-27 12:00:00', 0, NULL),
(4, 1, 1, '2017-05-17 11:00:00', 0, NULL),
(5, 2, 2, '2017-05-18 11:00:00', 0, NULL),
(6, 3, 3, '2017-05-17 11:00:00', 0, NULL),
(8, 5, 2, '2017-05-17 11:00:00', 0, NULL),
(9, 9, 2, '2017-05-17 23:10:00', 0, NULL),
(10, 11, 1, '2017-05-17 11:00:00', 0, NULL),
(11, 12, 2, '2017-05-17 12:30:00', 0, NULL),
(12, 13, 3, '2017-05-17 11:00:00', 0, NULL),
(13, 14, 4, '2017-05-17 16:20:00', 0, NULL),
(14, 15, 5, '2017-05-17 11:00:00', 0, NULL),
(17, 12, 1, '2017-05-22 07:00:00', 0, 'day la loi nhan'),
(18, 27, 2, '2017-05-22 07:00:00', 0, 'Lời nhắn của tui'),
(19, 0, 1, '2017-05-24 17:00:00', 0, 'anh nguyeenx van a'),
(20, 0, 1, '2017-05-26 20:00:00', 0, 'asdasd123'),
(22, 18, 11, '2017-05-22 07:00:00', 0, 'adsdsadasdas'),
(23, 20, 12, '2017-05-25 19:00:00', 0, 'Admin đẹp trai pro =]]'),
(24, 20, 12, '2017-05-24 13:34:00', 0, 'test lời nhắn'),
(25, 13, 1, '2017-05-22 07:00:00', 0, 'adsasdsadsad'),
(26, 19, 2, '2017-05-26 15:00:00', 0, 'asddd asdas das d'),
(27, 17, 2, '2017-05-17 12:23:00', 0, 'test'),
(30, 50, 14, '2017-06-01 07:03:00', 1, 'asdasd'),
(31, 42, 15, '2017-06-01 11:00:00', 0, 'asdasd'),
(32, 35, 2, '2017-06-01 07:00:00', 0, 'hihihiasdlkjaslkdj');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_khuyen_mai`
--

CREATE TABLE `phieu_khuyen_mai` (
  `MaPGG` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `PhanTramGiamGia` float DEFAULT NULL,
  `NgayBatDau` date DEFAULT NULL,
  `NgayKetThuc` date DEFAULT NULL,
  `GhiChuPGG` text COLLATE utf8_unicode_ci
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieu_khuyen_mai`
--

INSERT INTO `phieu_khuyen_mai` (`MaPGG`, `PhanTramGiamGia`, `NgayBatDau`, `NgayKetThuc`, `GhiChuPGG`) VALUES
('HCN16', 10, '2017-06-03', '2017-06-30', 'Giảm giá nhân dịp báo cáo tiến độ ngày 1/6 cô đã cất công lên trường giải đáp thắc mắc của bọn em về đồ án.\ntest'),
('HCNFINAL', 10, '2017-06-09', '2017-07-01', 'Giảm giá nhân dịp báo cáo final môn phân tích thiết kế hệ thống thông tin'),
('HCNAHIHI', 10, '2017-06-03', '2017-06-30', 'test chức năng thêm phiếu khuyến mãi'),
('HCNCUONG', 15, '2017-06-01', '2018-01-01', NULL),
('HCNNGUYEN', 10, '2017-06-01', '2018-01-01', NULL),
('HCNHUY', 10, '2017-06-01', '2018-01-01', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_nhap_hang`
--

CREATE TABLE `phieu_nhap_hang` (
  `MaPNH` int(10) UNSIGNED NOT NULL,
  `MaNCC` int(11) DEFAULT NULL,
  `NgayNhapHang` date DEFAULT NULL,
  `TriGiaPNH` float NOT NULL,
  `MaNV` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieu_nhap_hang`
--

INSERT INTO `phieu_nhap_hang` (`MaPNH`, `MaNCC`, `NgayNhapHang`, `TriGiaPNH`, `MaNV`) VALUES
(1, 1, '2017-05-31', 1900000, 1),
(2, 2, '2017-05-31', 80000, 1),
(3, 3, '2017-05-31', 56000, 4),
(4, 4, '2017-05-31', 395000, 4),
(5, 5, '2017-05-31', 755548, 5),
(6, 2, '2017-06-02', 60000, 1),
(7, 1, '2017-06-02', 60000, 1),
(8, 3, '2017-06-02', 1200000, 1),
(9, 5, '2017-06-02', 330000, 1),
(10, 3, '2017-06-03', 300000, 1),
(11, 1, '2017-06-03', 400000, 1),
(12, 4, '2017-06-03', 1000000, 1),
(13, 1, '2017-06-03', 3400000, 1),
(14, 4, '2017-06-04', 7000000, 1),
(15, 1, '2017-06-08', 4500000, 1),
(16, 7, '2017-06-08', 4000000, 1),
(17, 9, '2017-06-08', 5600000, 1),
(18, 2, '2017-06-08', 4550000, 1),
(19, 3, '2017-06-08', 17000000, 1),
(20, 5, '2017-06-08', 4320000, 1),
(21, 6, '2017-06-08', 1728000, 1),
(22, 8, '2017-06-08', 1512000, 1),
(23, 10, '2017-06-08', 2496000, 1),
(24, 1, '2017-06-08', 2810000, 1),
(25, 2, '2017-06-08', 3675000, 1),
(26, 2, '2017-06-08', 3675000, 1),
(27, 3, '2017-06-08', 20350000, 1),
(28, 4, '2017-06-08', 890000, 1),
(29, 7, '2017-06-08', 92000000, 1),
(30, 9, '2017-06-08', 13770000, 1),
(31, 10, '2017-06-08', 14500000, 1),
(32, 1, '2017-06-08', 7450000, 1),
(33, 3, '2017-06-08', 21500000, 1),
(34, 6, '2017-06-08', 5120000, 1),
(35, 10, '2017-06-08', 12200000, 1),
(36, 5, '2017-06-08', 4320000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phong_ban`
--

CREATE TABLE `phong_ban` (
  `MaPB` int(10) UNSIGNED NOT NULL,
  `TenPB` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `GhiChuPB` text COLLATE utf8_unicode_ci
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phong_ban`
--

INSERT INTO `phong_ban` (`MaPB`, `TenPB`, `GhiChuPB`) VALUES
(1, 'Giám đốc', NULL),
(2, 'Quản lý', NULL),
(3, 'Lễ tân', NULL),
(4, 'Tiếp thực', NULL),
(5, 'Đầu bếp', NULL),
(6, 'Phụ bếp', NULL),
(7, 'Bảo vệ', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `MaNV` int(10) UNSIGNED NOT NULL,
  `TenDangNhap` varchar(100) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `MatKhau` varchar(255) CHARACTER SET latin1 NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Đang đổ dữ liệu cho bảng `tai_khoan`
--

INSERT INTO `tai_khoan` (`MaNV`, `TenDangNhap`, `MatKhau`) VALUES
(1, 'giamdoc', '202cb962ac59075b964b07152d234b70'),
(4, 'letan', '202cb962ac59075b964b07152d234b70'),
(5, 'quanly', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuc_don`
--

CREATE TABLE `thuc_don` (
  `MaTD` int(10) UNSIGNED NOT NULL,
  `TenTD` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `GhiChuTD` text COLLATE utf8_unicode_ci
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thuc_don`
--

INSERT INTO `thuc_don` (`MaTD`, `TenTD`, `GhiChuTD`) VALUES
(1, 'Khai Vị', NULL),
(2, 'Món Chính', NULL),
(3, 'Tráng Miệng', NULL),
(4, 'Đồ uống', NULL),
(5, 'Chưa phân loại', NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`MaBan`),
  ADD UNIQUE KEY `MaBan_UNIQUE` (`MaBan`),
  ADD UNIQUE KEY `TenBan_UNIQUE` (`TenBan`);

--
-- Chỉ mục cho bảng `chi_tiet_dat_mon`
--
ALTER TABLE `chi_tiet_dat_mon`
  ADD PRIMARY KEY (`MaBan`,`MaMA`);

--
-- Chỉ mục cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD PRIMARY KEY (`MaHD`,`MaMA`);

--
-- Chỉ mục cho bảng `chi_tiet_phieu_nhap`
--
ALTER TABLE `chi_tiet_phieu_nhap`
  ADD PRIMARY KEY (`MaPNH`,`MaNL`);

--
-- Chỉ mục cho bảng `cong_thuc`
--
ALTER TABLE `cong_thuc`
  ADD PRIMARY KEY (`MaMA`,`MaNL`),
  ADD UNIQUE KEY `MaCongThuc_UNIQUE` (`MaNL`,`MaMA`);

--
-- Chỉ mục cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `PK_MaKH_idx` (`MaKH`),
  ADD KEY `PK_MaNV_idx` (`MaNV`);

--
-- Chỉ mục cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`MaKH`),
  ADD UNIQUE KEY `SDTKH_UNIQUE` (`SDTKH`);

--
-- Chỉ mục cho bảng `loai_khach_hang`
--
ALTER TABLE `loai_khach_hang`
  ADD PRIMARY KEY (`MaLKH`),
  ADD UNIQUE KEY `TenLKH_UNIQUE` (`TenLKH`),
  ADD UNIQUE KEY `MaLKH_UNIQUE` (`MaLKH`);

--
-- Chỉ mục cho bảng `mon_an`
--
ALTER TABLE `mon_an`
  ADD PRIMARY KEY (`MaMA`),
  ADD UNIQUE KEY `MaMA_UNIQUE` (`MaMA`),
  ADD UNIQUE KEY `TenMA_UNIQUE` (`TenMA`);

--
-- Chỉ mục cho bảng `nguyen_lieu`
--
ALTER TABLE `nguyen_lieu`
  ADD PRIMARY KEY (`MaNL`),
  ADD UNIQUE KEY `MaNL_UNIQUE` (`MaNL`),
  ADD UNIQUE KEY `TenNL_UNIQUE` (`TenNL`);

--
-- Chỉ mục cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`MaNV`),
  ADD UNIQUE KEY `MaNV_UNIQUE` (`MaNV`),
  ADD UNIQUE KEY `SDTNV_UNIQUE` (`SDTNV`);

--
-- Chỉ mục cho bảng `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  ADD PRIMARY KEY (`MaNCC`),
  ADD UNIQUE KEY `MaNCC_UNIQUE` (`MaNCC`),
  ADD UNIQUE KEY `SDTNCC_UNIQUE` (`SDTNCC`);

--
-- Chỉ mục cho bảng `phieu_chi_ncc`
--
ALTER TABLE `phieu_chi_ncc`
  ADD PRIMARY KEY (`MaPCNCC`),
  ADD UNIQUE KEY `MaPCNCC_UNIQUE` (`MaPCNCC`);

--
-- Chỉ mục cho bảng `phieu_dat_ban`
--
ALTER TABLE `phieu_dat_ban`
  ADD PRIMARY KEY (`MaPDB`),
  ADD UNIQUE KEY `MaPDB_UNIQUE` (`MaPDB`),
  ADD UNIQUE KEY `MaBan_NgayGio_Unique` (`MaBan`,`NgayGioDatBan`);

--
-- Chỉ mục cho bảng `phieu_khuyen_mai`
--
ALTER TABLE `phieu_khuyen_mai`
  ADD PRIMARY KEY (`MaPGG`);

--
-- Chỉ mục cho bảng `phieu_nhap_hang`
--
ALTER TABLE `phieu_nhap_hang`
  ADD PRIMARY KEY (`MaPNH`);

--
-- Chỉ mục cho bảng `phong_ban`
--
ALTER TABLE `phong_ban`
  ADD PRIMARY KEY (`MaPB`),
  ADD UNIQUE KEY `TenPB_UNIQUE` (`TenPB`),
  ADD UNIQUE KEY `MaPB_UNIQUE` (`MaPB`);

--
-- Chỉ mục cho bảng `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `thuc_don`
--
ALTER TABLE `thuc_don`
  ADD PRIMARY KEY (`MaTD`),
  ADD UNIQUE KEY `MaTD_UNIQUE` (`MaTD`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ban`
--
ALTER TABLE `ban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  MODIFY `MaHD` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `MaKH` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT cho bảng `loai_khach_hang`
--
ALTER TABLE `loai_khach_hang`
  MODIFY `MaLKH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT cho bảng `mon_an`
--
ALTER TABLE `mon_an`
  MODIFY `MaMA` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
--
-- AUTO_INCREMENT cho bảng `nguyen_lieu`
--
ALTER TABLE `nguyen_lieu`
  MODIFY `MaNL` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `MaNV` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT cho bảng `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  MODIFY `MaNCC` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT cho bảng `phieu_chi_ncc`
--
ALTER TABLE `phieu_chi_ncc`
  MODIFY `MaPCNCC` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT cho bảng `phieu_dat_ban`
--
ALTER TABLE `phieu_dat_ban`
  MODIFY `MaPDB` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT cho bảng `phieu_nhap_hang`
--
ALTER TABLE `phieu_nhap_hang`
  MODIFY `MaPNH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT cho bảng `phong_ban`
--
ALTER TABLE `phong_ban`
  MODIFY `MaPB` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT cho bảng `tai_khoan`
--
ALTER TABLE `tai_khoan`
  MODIFY `MaNV` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT cho bảng `thuc_don`
--
ALTER TABLE `thuc_don`
  MODIFY `MaTD` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
