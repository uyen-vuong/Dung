-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 30, 2024 lúc 07:29 PM
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

--
-- Đang đổ dữ liệu cho bảng `abook`
--

INSERT INTO `abook` (`id`, `bookid`, `abookid`, `importbookid`, `status`) VALUES
(1, 1, 'S001001', 2, 1),
(2, 1, 'S001002', 2, 1),
(3, 1, 'S001003', 2, 1),
(4, 1, 'S001004', 2, 1),
(5, 1, 'S001005', 2, 1),
(6, 1, 'S001006', 2, 1),
(7, 1, 'S001007', 2, 1),
(8, 1, 'S001008', 2, 1),
(9, 1, 'S001009', 2, 1),
(10, 1, 'S001010', 2, 1),
(11, 2, 'S002001', 3, 1),
(12, 2, 'S002002', 3, 1),
(13, 2, 'S002003', 3, 1),
(14, 2, 'S002004', 3, 1),
(15, 2, 'S002005', 3, 1),
(16, 2, 'S002006', 3, 1),
(17, 2, 'S002007', 3, 1),
(18, 2, 'S002008', 3, 1),
(19, 2, 'S002009', 3, 1),
(20, 2, 'S002010', 3, 1),
(21, 3, 'S003001', 4, 1),
(22, 3, 'S003002', 4, 1),
(23, 3, 'S003003', 4, 1),
(24, 3, 'S003004', 4, 1),
(25, 3, 'S003005', 4, 1),
(26, 3, 'S003006', 4, 1),
(27, 3, 'S003007', 4, 1),
(28, 3, 'S003008', 4, 1),
(29, 3, 'S003009', 4, 1),
(30, 3, 'S003010', 4, 1),
(31, 4, 'S004001', 5, 1),
(32, 4, 'S004002', 5, 1),
(33, 4, 'S004003', 5, 1),
(34, 4, 'S004004', 5, 1),
(35, 4, 'S004005', 5, 1),
(36, 4, 'S004006', 5, 1),
(37, 4, 'S004007', 5, 1),
(38, 4, 'S004008', 5, 1),
(39, 4, 'S004009', 5, 1),
(40, 4, 'S004010', 5, 1),
(41, 5, 'S005001', 7, 0),
(42, 5, 'S005002', 7, 1),
(43, 5, 'S005003', 7, 1),
(44, 5, 'S005004', 7, 1),
(45, 5, 'S005005', 7, 1),
(46, 5, 'S005006', 7, 1),
(47, 5, 'S005007', 7, 1),
(48, 5, 'S005008', 7, 1),
(49, 5, 'S005009', 7, 1),
(50, 5, 'S005010', 7, 1),
(51, 5, 'S005011', 7, 1),
(52, 5, 'S005012', 7, 1),
(53, 5, 'S005013', 7, 1),
(54, 5, 'S005014', 7, 1),
(55, 5, 'S005015', 7, 1),
(56, 5, 'S005016', 7, 1),
(57, 5, 'S005017', 7, 1),
(58, 5, 'S005018', 7, 1),
(59, 5, 'S005019', 7, 1),
(60, 5, 'S005020', 7, 1),
(61, 6, 'S006001', 8, 0),
(62, 6, 'S006002', 8, 1),
(63, 6, 'S006003', 8, 1),
(64, 6, 'S006004', 8, 1),
(65, 6, 'S006005', 8, 1);

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

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`id`, `genreid`, `name`, `author`, `price`, `numberpage`, `description`) VALUES
(1, 1, 'Đắc nhân tâm', 'Dale Carnegie', 85000, 320, 'Đắc nhân tâm của Dale Carnegie là quyển sách duy nhất về thể loại self-help liên tục đứng đầu danh mục sách bán chạy nhất (best-selling Books) do báo The New York Times bình chọn suốt 10 năm liền. Được xuất bản năm 1936, với số lượng bán ra hơn 15 triệu bản, tính đến nay, sách đã được dịch ra ở hầu hết các ngôn ngữ, trong đó có cả Việt Nam, và đã nhận được sự đón tiếp nhiệt tình của đọc giả ở hầu hết các quốc gia.'),
(2, 1, 'Sống thực tế giữa đời thực dụng', 'Mễ Mông', 130000, 360, 'THỰC DỤNG Ư? KHÔNG HỀ, TÔI CHỈ RẤT THỰC TẾ THÔI!\n\nCon người muốn trưởng thành đều phải trải qua ba lần lột xác “phá kén hóa bướm”. Lần đầu tiên là khi nhận ra mình không phải trung tâm thế giới. Lần thứ hai là khi phát hiện ra dù cố gắng đến đâu vẫn có những việc cảm thấy thật bất lực. Lần thứ ba là khi biết rõ có những việc bản thân không thể làm được nhưng vẫn cố tranh đấu đến cùng.'),
(3, 1, 'Cây cam ngọt của tôi', 'José Mauro de Vasconcelos', 70000, 244, '“Vị chua chát của cái nghèo hòa trộn với vị ngọt ngào khi khám phá ra những điều khiến cuộc đời này đáng số một tác phẩm kinh điển của Brazil.”\n\n- Booklist\n\n“Một cách nhìn cuộc sống gần như hoàn chỉnh từ con mắt trẻ thơ… có sức mạnh sưởi ấm và làm tan nát cõi lòng, dù người đọc ở lứa tuổi nào.”\n\n- The National\n\nHãy làm quen với Zezé, cậu bé tinh nghịch siêu hạng đồng thời cũng đáng yêu bậc nhất, với ước mơ lớn lên trở thành nhà thơ cổ thắt nơ bướm. Chẳng phải ai cũng công nhận khoản “đáng yêu” kia đâu nhé. Bởi vì, ở cái xóm ngoại ô nghèo ấy, nỗi khắc khổ bủa vây đã che mờ mắt người ta trước trái tim thiện lương cùng trí tưởng tượng tuyệt vời của cậu bé con năm tuổi.\n\nCó hề gì đâu bao nhiêu là hắt hủi, đánh mắng, vì Zezé đã có một người bạn đặc biệt để trút nỗi lòng: cây cam ngọt nơi vườn sau. Và cả một người bạn nữa, bằng xương bằng thịt, một ngày kia xuất hiện, cho cậu bé nhạy cảm khôn sớm biết thế nào là trìu mến, thế nào là nỗi đau, và mãi mãi thay đổi cuộc đời cậu.\nMở đầu bằng những thanh âm trong sáng và kết thúc lắng lại trong những nốt trầm hoài niệm, Cây cam ngọt của tôi khiến ta nhận ra vẻ đẹp thực sự của cuộc sống đến từ những điều giản dị như bông hoa trắng của cái cây sau nhà, và rằng cuộc đời thật khốn khổ nếu thiếu đi lòng yêu thương và niềm trắc ẩn. Cuốn sách kinh điển này bởi thế không ngừng khiến trái tim người đọc khắp thế giới thổn thức, kể từ khi ra mắt lần đầu năm 1968 tại Brazil.'),
(4, 1, 'Vị thần của những quyết định', 'Universe', 55000, 320, 'Không có gì là ngẫu nhiên.\nMọi chuyện đều là tất nhiên.\nMột cuốn sách tâm linh giúp bạn giải quyết những vấn đề trong cuộc sống, công việc, tình cảm… Nếu bạn đang phân vân trước những lựa chọn, nếu bạn đang thiếu quyết đoán, nếu bạn không biết tiếp theo nên làm gì: hãy đặt một câu hỏi.\nVà hãy để những vị thần quyết định thay bạn.'),
(5, 3, 'Một chỗ trong đời', 'Annie Ernaux', 50000, 98, 'Một người cha không bao giờ bước chân vào viện bảo tàng, chỉ đọc báo địa phương, không dùng gì khác ngoài con dao Opinel của riêng mình để ăn. Một người cha xuất thân nông dân rồi trở thành công nhân và cuối cùng là chủ một tiệm cà phê kiêm cửa hàng tạp phẩm. Một người cha luôn lo lắng bị nhầm “vị trí”. Cũng người cha ấy lấy làm tự hào về cô con gái nhờ được học hành tử tế mà đã đặt chân được vào giới tiểu tư sản. Nhưng đằng sau đó là khoảng cách, là những đớn đau, giằn vặt giữa cha và con.'),
(6, 4, 'Suy Nghĩ Thống Kê Trong Đời Thường', 'Nguyễn Văn Tuấn', 104000, 392, 'Chúng ta đang sống trong một xã hội hiện đại, một xã hội mà nhu cầu về hiểu biết con số trở nên rất quan trọng. Hầu như mỗi ngày chúng ta đều được “dội bom” bằng những con số thống kê về tình hình kinh tế, về sự trồi sụt của thị trường chứng khoán, về tỉ lệ thất nghiệp, về kết quả khoa học. Có những con số dễ hiểu, nhưng đa số là những con số đòi hỏi phải có sự đầu tư thời gian suy nghĩ mới hiểu được. Nếu chúng ta không hiểu những con số được trình báo, chúng ta rất dễ bị khuynh đảo và làm lạc hướng vấn đề. Do đó, đọc và hiểu con số trở thành một kĩ năng sống trong thế giới hiện đại.\n\nThống kê là một môn khoa học cũng là một nghệ thuật. Khoa học thống kê giúp cho các nhà khoa học khai thác và khám phá qui luật tiềm ẩn trong dữ liệu lớn. Tuy quan trọng như thế, nhưng đa số sinh viên đều cảm thấy khoa học thống kê là một môn học đáng sợ. Quyển sách này có mục đích đơn giản là làm cho bạn đọc yêu môn thống kê như một nghệ thuật.\n\nGiá sản phẩm trên Tiki đã bao gồm thuế theo luật hiện hành. Bên cạnh đó, tuỳ vào loại sản phẩm, hình thức và địa chỉ giao hàng mà có thể phát sinh thêm chi phí khác như phí vận chuyển, phụ phí hàng cồng kềnh, thuế nhập khẩu (đối với đơn hàng giao từ nước ngoài có giá trị trên 1 triệu đồng).....');

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

--
-- Đang đổ dữ liệu cho bảng `borrowreturn`
--

INSERT INTO `borrowreturn` (`id`, `readerid`, `abookid`, `borrowdate`, `duedate`, `returndate`) VALUES
(1, 1, 1, '2024-04-29', '2024-05-02', '2024-04-30'),
(2, 1, 13, '2024-04-29', '2024-05-05', '2024-04-30'),
(4, 1, 21, '2024-04-30', '2024-05-04', '2024-04-30'),
(5, 1, 1, '2024-04-30', '2024-05-04', '2024-04-30'),
(6, 1, 2, '2024-04-30', '2024-05-04', '2024-04-30'),
(7, 1, 61, '2024-04-30', '2023-04-30', NULL),
(8, 1, 41, '2024-04-30', '2024-05-03', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `errorbook`
--

CREATE TABLE `errorbook` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `percentage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `errorbook`
--

INSERT INTO `errorbook` (`id`, `name`, `percentage`) VALUES
(1, 'Mất sách', 100),
(2, 'Quá hạn trả sách', 10),
(3, 'Hỏng sách mức 1', 20),
(4, 'Hỏng sách mức 2', 50),
(5, 'Hỏng sách mức 3', 75),
(6, 'Mất bìa', 50);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `errorbookreturn`
--

CREATE TABLE `errorbookreturn` (
  `borrowreturnid` int(11) NOT NULL,
  `errorbookid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `errorbookreturn`
--

INSERT INTO `errorbookreturn` (`borrowreturnid`, `errorbookid`) VALUES
(1, 3),
(2, 6),
(4, 2),
(5, 6),
(6, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'Sách tư duy - Kỹ năng sống'),
(2, 'Tiểu thuyết'),
(3, 'Văn học'),
(4, 'Kinh tế');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import`
--

CREATE TABLE `import` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `supplierid` int(11) NOT NULL,
  `importdate` date NOT NULL,
  `deliverydate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `import`
--

INSERT INTO `import` (`id`, `userid`, `supplierid`, `importdate`, `deliverydate`) VALUES
(4, 3, 1, '2024-04-26', '2024-04-26'),
(7, 3, 1, '2024-04-26', '2024-04-26'),
(10, 3, 3, '2024-04-26', '2024-04-27'),
(11, 3, 4, '2024-04-27', '2024-04-27');

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

--
-- Đang đổ dữ liệu cho bảng `importbook`
--

INSERT INTO `importbook` (`id`, `importid`, `namebook`, `quantity`, `price`) VALUES
(2, 4, 'Đắc nhân tâm', 10, 85000),
(3, 4, 'Sống thực tế giữa đời thực dụng', 10, 120000),
(4, 4, 'Cây cam ngọt của tôi', 10, 65000),
(5, 7, 'Vị thần của những quyết định', 10, 51400),
(7, 10, 'Một chỗ trong đời', 20, 44850),
(8, 11, 'Suy Nghĩ Thống Kê Trong Đời Thường', 5, 104000);

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

--
-- Đang đổ dữ liệu cho bảng `reader`
--

INSERT INTO `reader` (`id`, `readerid`, `fullname`, `email`, `phone`, `address`, `date`) VALUES
(1, 'BD001', 'Le Thị Tíu', 'tiu@gmail.com', '0123456789', 'Ha Noi', '2024-04-28');

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
(3, 'Nguyen C', 'c@gmail.com', '0123456789', 'Ha Noi'),
(4, 'Nguyen D', 'd@gmail.com', '0123456789', 'Đà Nẵng'),
(5, 'Nguyen E', 'e@gmail.com', '0123456789', 'Hai Phong'),
(6, 'Nguyen F', 'f@gmail.com', '0123456789', 'HCM'),
(9, 'Nguyễn H', 'h@gmail.com', '0123456789', 'Hưng Yên'),
(10, 'Nguyễn K', 'k@gmail.com', '0123456789', 'Vũng Tàu');

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
  `password` varchar(200) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `userid`, `roleid`, `fullname`, `email`, `phone`, `address`, `username`, `password`, `status`) VALUES
(2, 'QL001', 1, 'Nguyen Thi A', NULL, NULL, NULL, 'admin', '111', 1),
(3, 'NV001', 2, 'Nguyen Van B', NULL, NULL, NULL, 'user1', '111', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `violation`
--

CREATE TABLE `violation` (
  `id` int(11) NOT NULL,
  `readerid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `date` date NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `violation`
--

INSERT INTO `violation` (`id`, `readerid`, `userid`, `date`, `note`) VALUES
(5, 1, 3, '2024-04-30', 'Hỏng sách'),
(7, 1, 3, '2024-04-30', 'Làm mất bìa'),
(8, 1, 3, '2024-04-30', 'Làm mất bìa và hỏng sách'),
(9, 1, 3, '2024-04-30', 'hỏng sách ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `violationreturn`
--

CREATE TABLE `violationreturn` (
  `violationid` int(11) NOT NULL,
  `borrowreturnid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `violationreturn`
--

INSERT INTO `violationreturn` (`violationid`, `borrowreturnid`) VALUES
(5, 1),
(7, 2),
(8, 4),
(8, 5),
(9, 6);

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
  ADD KEY `librarianid` (`userid`),
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
  ADD KEY `librarianid` (`userid`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `borrowreturn`
--
ALTER TABLE `borrowreturn`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `errorbook`
--
ALTER TABLE `errorbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `import`
--
ALTER TABLE `import`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `importbook`
--
ALTER TABLE `importbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `reader`
--
ALTER TABLE `reader`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `violation`
--
ALTER TABLE `violation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
  ADD CONSTRAINT `import_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
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
  ADD CONSTRAINT `violation_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`);

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
