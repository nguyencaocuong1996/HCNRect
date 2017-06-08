-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 08, 2017 lúc 09:38 CH
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

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`MaKH`),
  ADD UNIQUE KEY `SDTKH_UNIQUE` (`SDTKH`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `MaKH` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
