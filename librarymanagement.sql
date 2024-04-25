-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 25, 2024 lúc 04:37 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `librarymanagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `abook`
--

CREATE TABLE `abook` (
  `id` int(11) NOT NULL,
  `bookid` int(11) NOT NULL,
  `abookid` varchar(15) NOT NULL,
  `importbookid` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `genreid` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `author` varchar(200) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `numberpage` int(11) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `borrowreturn`
--

CREATE TABLE `borrowreturn` (
  `id` int(11) NOT NULL,
  `readerid` int(11) NOT NULL,
  `abookid` int(11) NOT NULL,
  `borrowdate` date NOT NULL,
  `duedate` date NOT NULL,
  `returndate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `errorbook`
--

CREATE TABLE `errorbook` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `percentage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `errorbookreturn`
--

CREATE TABLE `errorbookreturn` (
  `borrowreturnid` int(11) NOT NULL,
  `errorbookid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import`
--

CREATE TABLE `import` (
  `id` int(11) NOT NULL,
  `librarianid` int(11) NOT NULL,
  `supplierid` int(11) NOT NULL,
  `importdate` date NOT NULL,
  `deliverydate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `importbook`
--

CREATE TABLE `importbook` (
  `id` int(11) NOT NULL,
  `importid` int(11) NOT NULL,
  `namebook` varchar(200) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reader`
--

CREATE TABLE `reader` (
  `id` int(11) NOT NULL,
  `readerid` varchar(15) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(200) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `roleid` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name`, `roleid`) VALUES
(1, 'Quản lý', 'QL'),
(2, 'Thủ thư', 'NV');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`id`, `fullname`, `email`, `phone`, `address`) VALUES
(1, 'Nguyen A', 'a@gmail.com', '0123456789', 'Ha Noi'),
(2, 'Nguyen B', 'b@gmail.com', '0123456789', 'Ha Noi'),
(3, 'Nguyen C', 'c@gmail.com', 'Ha Noi', 'Ha Noi'),
(4, 'Nguyen D', 'd@gmail.com', 'Ha Noi', 'Ha Noi'),
(5, 'Nguyen E', 'e@gmail.com', 'Hai Phong', 'Hai Phong');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `userid` varchar(15) NOT NULL,
  `roleid` int(11) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `userid`, `roleid`, `fullname`, `email`, `phone`, `address`, `username`, `password`) VALUES
(2, 'QL001', 1, 'Nguyen Thi A', NULL, NULL, NULL, 'admin', '111'),
(3, 'NV001', 2, 'Nguyen Van B', NULL, NULL, NULL, 'user1', '111');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `violation`
--

CREATE TABLE `violation` (
  `id` int(11) NOT NULL,
  `readerid` int(11) NOT NULL,
  `librarianid` int(11) NOT NULL,
  `date` date NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `violationreturn`
--

CREATE TABLE `violationreturn` (
  `violationid` int(11) NOT NULL,
  `borrowreturnid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `abook`
--
ALTER TABLE `abook`
  ADD PRIMARY KEY (`id`),
  ADD KEY `importbookid` (`importbookid`),
  ADD KEY `bookid` (`bookid`);

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `genreid` (`genreid`);

--
-- Chỉ mục cho bảng `borrowreturn`
--
ALTER TABLE `borrowreturn`
  ADD PRIMARY KEY (`id`),
  ADD KEY `abookid` (`abookid`),
  ADD KEY `readerid` (`readerid`);

--
-- Chỉ mục cho bảng `errorbook`
--
ALTER TABLE `errorbook`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `errorbookreturn`
--
ALTER TABLE `errorbookreturn`
  ADD PRIMARY KEY (`borrowreturnid`,`errorbookid`),
  ADD KEY `errorbookid` (`errorbookid`);

--
-- Chỉ mục cho bảng `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `import`
--
ALTER TABLE `import`
  ADD PRIMARY KEY (`id`),
  ADD KEY `librarianid` (`librarianid`),
  ADD KEY `supplierid` (`supplierid`);

--
-- Chỉ mục cho bảng `importbook`
--
ALTER TABLE `importbook`
  ADD PRIMARY KEY (`id`),
  ADD KEY `importid` (`importid`);

--
-- Chỉ mục cho bảng `reader`
--
ALTER TABLE `reader`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `roleid` (`roleid`);

--
-- Chỉ mục cho bảng `violation`
--
ALTER TABLE `violation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `readerid` (`readerid`),
  ADD KEY `librarianid` (`librarianid`);

--
-- Chỉ mục cho bảng `violationreturn`
--
ALTER TABLE `violationreturn`
  ADD PRIMARY KEY (`violationid`,`borrowreturnid`),
  ADD KEY `borrowreturnid` (`borrowreturnid`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `abook`
--
ALTER TABLE `abook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `borrowreturn`
--
ALTER TABLE `borrowreturn`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `errorbook`
--
ALTER TABLE `errorbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `import`
--
ALTER TABLE `import`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `importbook`
--
ALTER TABLE `importbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `reader`
--
ALTER TABLE `reader`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `violation`
--
ALTER TABLE `violation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `abook`
--
ALTER TABLE `abook`
  ADD CONSTRAINT `abook_ibfk_2` FOREIGN KEY (`importbookid`) REFERENCES `importbook` (`id`),
  ADD CONSTRAINT `abook_ibfk_3` FOREIGN KEY (`bookid`) REFERENCES `book` (`id`);

--
-- Các ràng buộc cho bảng `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`genreid`) REFERENCES `genre` (`id`);

--
-- Các ràng buộc cho bảng `borrowreturn`
--
ALTER TABLE `borrowreturn`
  ADD CONSTRAINT `borrowreturn_ibfk_1` FOREIGN KEY (`abookid`) REFERENCES `abook` (`id`),
  ADD CONSTRAINT `borrowreturn_ibfk_2` FOREIGN KEY (`readerid`) REFERENCES `reader` (`id`);

--
-- Các ràng buộc cho bảng `errorbookreturn`
--
ALTER TABLE `errorbookreturn`
  ADD CONSTRAINT `errorbookreturn_ibfk_1` FOREIGN KEY (`borrowreturnid`) REFERENCES `borrowreturn` (`id`),
  ADD CONSTRAINT `errorbookreturn_ibfk_2` FOREIGN KEY (`errorbookid`) REFERENCES `errorbook` (`id`);

--
-- Các ràng buộc cho bảng `import`
--
ALTER TABLE `import`
  ADD CONSTRAINT `import_ibfk_1` FOREIGN KEY (`librarianid`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `import_ibfk_2` FOREIGN KEY (`supplierid`) REFERENCES `supplier` (`id`);

--
-- Các ràng buộc cho bảng `importbook`
--
ALTER TABLE `importbook`
  ADD CONSTRAINT `importbook_ibfk_1` FOREIGN KEY (`importid`) REFERENCES `import` (`id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`);

--
-- Các ràng buộc cho bảng `violation`
--
ALTER TABLE `violation`
  ADD CONSTRAINT `violation_ibfk_1` FOREIGN KEY (`readerid`) REFERENCES `reader` (`id`),
  ADD CONSTRAINT `violation_ibfk_2` FOREIGN KEY (`librarianid`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `violationreturn`
--
ALTER TABLE `violationreturn`
  ADD CONSTRAINT `violationreturn_ibfk_1` FOREIGN KEY (`violationid`) REFERENCES `violation` (`id`),
  ADD CONSTRAINT `violationreturn_ibfk_2` FOREIGN KEY (`borrowreturnid`) REFERENCES `borrowreturn` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
