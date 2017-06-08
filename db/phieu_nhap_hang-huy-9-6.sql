-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 08, 2017 lúc 08:35 PM
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

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `phieu_nhap_hang`
--
ALTER TABLE `phieu_nhap_hang`
  ADD PRIMARY KEY (`MaPNH`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `phieu_nhap_hang`
--
ALTER TABLE `phieu_nhap_hang`
  MODIFY `MaPNH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
