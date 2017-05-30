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
(31, 'Đậu bắp', 10, 'kg', 2),
(2, 'Thịt ba chỉ', 200, 'kg', 20),
(3, 'Thịt trâu', 220, 'kg', 20),
(4, 'Cánh gà ta', 115, 'kg', 20),
(5, 'Chân gà ta', 102, 'kg', 20),
(6, 'Tôm sú', 150, 'kg', 20),
(7, 'Cá diêu hồng', 150, 'kg', 20),
(8, 'Cá chép', 150, 'kg', 20),
(9, 'Cá kèo', 150, 'kg', 20),
(10, 'ếch', 200, 'kg', 20),
(11, 'Lươn', 150, 'kg', 20),
(12, 'Bia Tiger (Lon)', 100, 'Lon', 50),
(13, 'Bia Larue(Lon)', 200, 'Lon', 50),
(14, 'Bia Heniken(Lon)', 200, 'Lon', 50),
(15, 'Bia Tiger(Chai)', 300, 'Chai', 50),
(16, 'Bia Larue(Chai)', 300, 'Chai', 50),
(17, 'Bia Heniken(Chai)', 300, 'Chai', 50),
(18, 'CocaCola(Lon)', 100, 'Lon', 50),
(19, 'Pepsi(Lon)', 100, 'Lon', 50),
(20, 'CocaCola(Chai)', 150, 'Chai', 50),
(21, 'Pepsi(Chai)', 150, 'Chai', 50),
(22, 'Nước suối', 100, 'Chai', 50),
(23, 'Đậu đỏ', 100, 'kg', 20),
(24, 'Cam', 100, 'kg', 20),
(25, 'Bánh mì ', 100, 'ổ', 15),
(26, 'Sườn heo', 100, 'kg', 20),
(27, 'Tiêu đen', 50, 'kg', 10),
(28, 'Sả', 100, 'kq', 10),
(29, 'Cua biển', 100, 'kg', 10),
(32, 'Tỏi', 20, 'kg', 2),
(33, 'Khoai tây', 20, 'kg', 5),
(34, 'Gà (nguyên con)', 25, 'kg', 10),
(35, 'Rau răm', 2, 'kg', 0.5),
(36, 'Chả cá', 5, 'kg', 1),
(37, 'Tương ớt', 15, 'kg', 5),
(38, 'Thịt dê', 10, 'kg', 5),
(39, 'Củ cải đường', 5, 'kg', 1),
(40, 'Ốc cúc', 10, 'kg', 3),
(41, 'ỐC hoàng', 10, 'kg', 3),
(42, 'Đậu phộng', 2, 'kg', 0.5),
(43, 'Rạn biển', 10, 'kg', 2),
(44, 'Mực biển', 10, 'kg', 2),
(45, 'Bạch tuộc', 10, 'kg', 2),
(46, 'Cá Thu', 15, 'kg', 3),
(47, 'Cà rốt', 5, 'kg', 1),
(48, 'Vẹm biển ', 10, 'kg', 3),
(49, 'Chim cút', 15, 'kg', 5),
(50, 'Hào', 10, 'kg', 5),
(51, 'Phô mai', 2, 'kg', 0.5),
(1, 'Thịt bò', 300, 'kg', 10),
(52, 'Rau salad', 3, 'kg', 1),
(53, 'Mỳ tôm', 100, 'gói', 10),
(54, 'Rượu vang đỏ', 100, 'lít', 20),
(55, 'Bánh kem Socola', 20, 'g', 5),
(56, 'bánh phở', 5, 'kg', 2),
(57, 'Chanh', 30, 'kg', 10),
(58, 'Dâu', 10, 'kg', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `nguyen_lieu`
--
ALTER TABLE `nguyen_lieu`
  ADD PRIMARY KEY (`MaNL`),
  ADD UNIQUE KEY `MaNL_UNIQUE` (`MaNL`),
  ADD UNIQUE KEY `TenNL_UNIQUE` (`TenNL`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `nguyen_lieu`
--
ALTER TABLE `nguyen_lieu`
  MODIFY `MaNL` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
