-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 08, 2017 lúc 08:34 CH
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
(1, 1, 1, '2017-06-11 12:00:00', 100000, 1, NULL, 85000),
(2, 1, 1, '2017-05-22 12:07:18', 500000, 0, NULL, 425000),
(3, 2, 1, '2017-07-22 12:10:12', 500000, 23, NULL, 425000),
(4, 1, 1, '2017-05-22 12:16:49', 1390000, 24, NULL, 1181500),
(5, 1, 1, '2017-05-22 12:17:29', 670000, 1, NULL, 569500),
(6, 3, 1, '2015-05-24 08:48:32', 400000, 1, NULL, 340000),
(7, 1, 1, '2015-05-25 11:19:07', 500000, 1, NULL, 425000),
(8, 1, 1, '2016-08-25 11:21:34', 530000, 3, NULL, 450500),
(9, 1, 1, '2016-05-25 11:25:25', 500000, 4, NULL, 425000),
(10, 5, 1, '2016-05-25 11:25:25', 500000, 4, NULL, 425000),
(11, 1, 1, '2015-05-25 11:27:35', 470000, 2, NULL, 399500),
(12, 1, 1, '2015-06-25 11:28:24', 370000, 2, NULL, 314500),
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
(43, 2, 4, '2015-05-08 21:29:41', 485000, 27, 'HCNHUY', 412250);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `PK_MaKH_idx` (`MaKH`),
  ADD KEY `PK_MaNV_idx` (`MaNV`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  MODIFY `MaHD` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
