-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 08, 2017 lúc 08:34 PM
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
(1, 1, '2017-02-03', 1000000, 'lý do là đang test phần mềm', 1),
(2, 5, '2017-02-03', 200000, 'thich thì chi', 1),
(3, 1, '2017-03-03', 200000, 'ád', 1),
(4, 5, '2017-03-03', 300000, 'ád', 1),
(5, 1, '2017-04-08', 3000000, 'Tra tien dau thang', 1),
(6, 1, '2017-05-08', 4000000, 'trả tiền nợ giữa tháng', 1),
(7, 1, '2017-06-08', 4000000, 'trả tiền', 1),
(8, 1, '2017-02-08', 5000000, 'trả tiền', 1),
(9, 2, '2017-02-08', 3000000, 'trả tiền đầu tháng', 1),
(10, 2, '2017-03-08', 1250000, 'trả tiền', 1),
(11, 2, '2017-05-08', 2500000, 'trả tiền', 1),
(12, 2, '2017-06-08', 4000000, 'trả tiền\n', 1),
(13, 3, '2017-02-08', 17000000, 'trả tiền đầu tháng', 1),
(14, 3, '2017-03-08', 10000000, 'trả tiền', 1),
(15, 3, '2017-04-08', 7500000, 'trả tiền', 1),
(16, 3, '2017-05-08', 12000000, 'trả tiền', 1),
(17, 3, '2017-06-08', 2400000, 'trả tiền', 1),
(18, 3, '2017-02-08', 6000000, 'trả tiền', 1),
(19, 3, '2017-03-08', 6000000, 'trả tiền', 1),
(20, 4, '2017-02-08', 1000000, 'trả tiền đầu tháng', 1),
(21, 4, '2017-03-08', 3000000, 'trả tiền', 1),
(22, 4, '2017-04-08', 500000, 'trả tiền', 1),
(23, 4, '2017-05-08', 1000000, 'trả tiền', 1),
(24, 4, '2017-06-08', 2000000, 'trả tiền', 1),
(25, 4, '2017-02-08', 1000000, 'trả tiền', 1),
(26, 5, '2017-04-08', 2000000, 'trả tiền đầu tháng', 1),
(27, 5, '2017-05-08', 2000000, 'trả tiền', 1),
(28, 5, '2017-06-08', 4000000, 'trả tiền ', 1),
(29, 6, '2017-05-08', 3000000, 'trả tiền đầu tháng', 1),
(30, 6, '2017-06-08', 1000000, 'trả tiền', 1),
(31, 6, '2017-02-08', 2500000, 'trả tiền', 1),
(32, 7, '2017-02-08', 10000000, 'trả tiền đầu tháng', 1),
(33, 7, '2017-03-08', 15000000, 'trả tiền', 1),
(34, 7, '2017-04-08', 24000000, 'trả tiền', 1),
(35, 7, '2017-05-08', 30000000, 'trả tiền', 1),
(36, 7, '2017-06-08', 10000000, 'trả tiền', 1),
(37, 7, '2017-02-08', 2000000, 'trả tiền', 1),
(38, 7, '2017-03-08', 4000000, 'trả tiền', 1),
(39, 8, '2017-05-09', 700000, 'trả tiền đầu tháng', 1),
(40, 8, '2017-06-09', 400000, 'trả tiền', 1),
(41, 9, '2017-02-09', 7000000, 'trả tiền đầu tháng', 1),
(42, 9, '2017-03-09', 4000000, 'trả tiền', 1),
(43, 9, '2017-05-09', 3000000, 'trả tiền', 1),
(44, 9, '2017-06-09', 3000000, 'trả tiền', 1),
(45, 10, '2017-02-09', 3000000, 'trả tiền đầu tháng', 1),
(46, 10, '2017-03-09', 6000000, 'trả tiền', 1),
(47, 10, '2017-05-09', 60000000, 'trả tiền', 1),
(48, 10, '2017-06-09', 10000000, 'trả tiền', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `phieu_chi_ncc`
--
ALTER TABLE `phieu_chi_ncc`
  ADD PRIMARY KEY (`MaPCNCC`),
  ADD UNIQUE KEY `MaPCNCC_UNIQUE` (`MaPCNCC`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `phieu_chi_ncc`
--
ALTER TABLE `phieu_chi_ncc`
  MODIFY `MaPCNCC` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
