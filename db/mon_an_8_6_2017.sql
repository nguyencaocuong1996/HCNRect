-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 08, 2017 lúc 03:58 CH
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
(47, 'Tôm cuộn khoai tây', 33000, 'tom-cuon-khoai-tay', 1),
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

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `mon_an`
--
ALTER TABLE `mon_an`
  ADD PRIMARY KEY (`MaMA`),
  ADD UNIQUE KEY `MaMA_UNIQUE` (`MaMA`),
  ADD UNIQUE KEY `TenMA_UNIQUE` (`TenMA`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `mon_an`
--
ALTER TABLE `mon_an`
  MODIFY `MaMA` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
