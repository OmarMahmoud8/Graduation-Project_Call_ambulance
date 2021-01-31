-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2015 at 06:02 PM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinicmsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `clinic`
--

CREATE TABLE `clinic` (
  `C_ID` int(11) NOT NULL,
  `C_Name` varchar(10) NOT NULL,
  `C_Street` varchar(15) NOT NULL,
  `City` varchar(10) NOT NULL,
  `Building_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clinic`
--

INSERT INTO `clinic` (`C_ID`, `C_Name`, `C_Street`, `City`, `Building_No`) VALUES
(1, 'Elhayat', 'sayed hussien', 'Giza', 3);

-- --------------------------------------------------------

--
-- Table structure for table `clinicphone`
--

CREATE TABLE `clinicphone` (
  `PhoneID` int(11) NOT NULL,
  `ClinicID` int(11) NOT NULL,
  `PhoneNo` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clinicphone`
--

INSERT INTO `clinicphone` (`PhoneID`, `ClinicID`, `PhoneNo`) VALUES
(1, 1, '01005020010'),
(2, 1, '01144568201');

-- --------------------------------------------------------

--
-- Table structure for table `consultation`
--

CREATE TABLE `consultation` (
  `Const_ID` int(11) NOT NULL,
  `Vis_IDC` int(11) NOT NULL,
  `Cstart_time` time NOT NULL,
  `Cend_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `Dept_ID` int(11) NOT NULL,
  `Clinic_ID` int(11) NOT NULL,
  `Dept_Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`Dept_ID`, `Clinic_ID`, `Dept_Name`) VALUES
(1, 1, 'Physiotherapy'),
(2, 1, 'Orthopaedic'),
(3, 1, 'Dentistry'),
(4, 1, 'Surgery');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `D_ID` int(11) NOT NULL,
  `DrQual` text NOT NULL,
  `DUser_ID` int(11) NOT NULL,
  `Dept_IDD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`D_ID`, `DrQual`, `DUser_ID`, `Dept_IDD`) VALUES
(2, 'ZZZasdpiep', 9, 2),
(3, 'I will add my qualification sooooon', 10, 3),
(4, 'I will add my qualification sooooon', 11, 4),
(5, 'i hava alot of Qualification', 28, 1);

-- --------------------------------------------------------

--
-- Table structure for table `doctor_workdays`
--

CREATE TABLE `doctor_workdays` (
  `D_ID` int(11) NOT NULL,
  `D_Day` varchar(10) NOT NULL,
  `Dstart_time` time NOT NULL,
  `Dend_time` time NOT NULL,
  `Dduration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_workdays`
--

INSERT INTO `doctor_workdays` (`D_ID`, `D_Day`, `Dstart_time`, `Dend_time`, `Dduration`) VALUES
(2, 'Monday', '09:00:00', '11:00:00', 2),
(2, 'Wednesday', '09:00:00', '11:00:00', 2),
(3, 'Friday', '09:00:00', '11:00:00', 2),
(3, 'Thursday', '08:00:00', '10:00:00', 2),
(4, 'Saturday', '09:00:00', '11:00:00', 2),
(4, 'Sunday', '09:00:00', '11:00:00', 2),
(5, 'Monday', '09:00:00', '11:00:00', 2),
(5, 'Thursday', '09:00:00', '11:00:00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `P_ID` int(11) NOT NULL,
  `P_Auth` tinyint(1) NOT NULL DEFAULT '1',
  `PUser_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`P_ID`, `P_Auth`, `PUser_ID`) VALUES
(5, 1, 18),
(6, 1, 27);

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `ID` int(11) NOT NULL,
  `Name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`ID`, `Name`) VALUES
(1, 'Cash'),
(2, 'Visa');

-- --------------------------------------------------------

--
-- Table structure for table `user_data`
--

CREATE TABLE `user_data` (
  `User_IDs` int(11) NOT NULL,
  `Fname` varchar(10) NOT NULL,
  `Lname` varchar(10) NOT NULL,
  `Mail` varchar(25) NOT NULL,
  `UserPhone` varchar(11) NOT NULL,
  `Ustatus` int(11) NOT NULL DEFAULT '1',
  `Age` int(11) NOT NULL,
  `City` varchar(10) NOT NULL,
  `Gender` char(1) NOT NULL,
  `Upassword` varchar(15) NOT NULL,
  `Utype` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_data`
--

INSERT INTO `user_data` (`User_IDs`, `Fname`, `Lname`, `Mail`, `UserPhone`, `Ustatus`, `Age`, `City`, `Gender`, `Upassword`, `Utype`) VALUES
(6, 'Omar', 'Rehan', 'o_khaled201553@yahoo.com', '1005020031', 1, 19, 'Giza', 'M', '691995367', 2),
(9, 'Mohamed', 'Hassan', 'mohamed12@gmail.com', '01273162021', 2, 37, 'Cairo', 'M', '123456789', 3),
(10, 'Ali', 'Mohamed', 'ali2015@gmail.com', '01273172321', 1, 36, 'Giza', 'M', '5565041', 3),
(11, 'Hassan', 'Ibrahim', 'hassan2011@gmail.com', '01005020090', 1, 35, 'Cairo', 'M', '5565041', 3),
(18, 'mido', 'el masry', 'mido3@yahoo.com', '33374673390', 2, 0, 'xd', 'M', '224466881012', 1),
(27, 'hassan', 'mohamed', 'mohamedhass@gmail.com', '564659898', 1, 19, 'Cairo', 'M', '54648923111', 1),
(28, 'Mohamed', 'Hamdi', 'hamdi33@yahoo.com', '01147115125', 1, 36, 'giza', 'M', '258147369', 3);

-- --------------------------------------------------------

--
-- Table structure for table `user_status`
--

CREATE TABLE `user_status` (
  `Status_ID` int(11) NOT NULL,
  `status_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_status`
--

INSERT INTO `user_status` (`Status_ID`, `status_type`) VALUES
(1, 'Activated'),
(2, 'Deactivated');

-- --------------------------------------------------------

--
-- Table structure for table `user_types`
--

CREATE TABLE `user_types` (
  `UTypeID` int(11) NOT NULL,
  `user_types` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_types`
--

INSERT INTO `user_types` (`UTypeID`, `user_types`) VALUES
(1, 'Patient'),
(2, 'Admin'),
(3, 'Doctor');

-- --------------------------------------------------------

--
-- Table structure for table `visit`
--

CREATE TABLE `visit` (
  `Vis_ID` int(11) NOT NULL,
  `Vstatus` int(11) NOT NULL DEFAULT '1',
  `Vday` varchar(11) NOT NULL,
  `Reserved` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Vstart_Hour` int(11) NOT NULL,
  `Vduration` int(11) NOT NULL DEFAULT '20',
  `Vstart_Min` int(11) NOT NULL,
  `Visit_type` int(11) NOT NULL,
  `Pv_ID` int(11) NOT NULL,
  `Dv_ID` int(11) NOT NULL,
  `PaymentMethodid` int(11) NOT NULL DEFAULT '1',
  `visvalue` int(11) NOT NULL DEFAULT '50'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visit`
--

INSERT INTO `visit` (`Vis_ID`, `Vstatus`, `Vday`, `Reserved`, `Vstart_Hour`, `Vduration`, `Vstart_Min`, `Visit_type`, `Pv_ID`, `Dv_ID`, `PaymentMethodid`, `visvalue`) VALUES
(2, 1, 'Monday', '2015-12-21 14:20:35', 9, 20, 20, 1, 5, 2, 1, 50),
(8, 1, 'Monday', '2015-12-21 14:20:35', 10, 20, 0, 1, 5, 2, 1, 50),
(9, 1, 'Monday', '2015-12-21 14:20:35', 10, 20, 40, 1, 5, 2, 1, 50),
(10, 1, 'Monday', '2015-12-21 14:20:35', 10, 20, 20, 1, 5, 2, 1, 50),
(12, 1, 'Thursday', '2015-12-21 14:20:35', 10, 20, 0, 1, 5, 3, 1, 50),
(16, 1, 'Friday', '2015-12-21 14:20:35', 10, 20, 40, 1, 5, 3, 1, 50),
(17, 1, 'Friday', '2015-12-21 14:20:35', 10, 20, 20, 1, 5, 3, 1, 50),
(19, 1, 'Saturday', '2015-12-21 14:20:35', 11, 20, 0, 1, 5, 4, 1, 50),
(20, 1, 'Saturday', '2015-12-21 14:20:35', 9, 20, 40, 1, 5, 4, 1, 50);

-- --------------------------------------------------------

--
-- Table structure for table `visit_desc`
--

CREATE TABLE `visit_desc` (
  `ID` int(11) NOT NULL,
  `Description` text NOT NULL,
  `VisID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `visit_type`
--

CREATE TABLE `visit_type` (
  `VType_ID` int(11) NOT NULL,
  `VType` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visit_type`
--

INSERT INTO `visit_type` (`VType_ID`, `VType`) VALUES
(1, 'Visit'),
(2, 'Consultation');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clinic`
--
ALTER TABLE `clinic`
  ADD PRIMARY KEY (`C_ID`);

--
-- Indexes for table `clinicphone`
--
ALTER TABLE `clinicphone`
  ADD PRIMARY KEY (`PhoneID`),
  ADD KEY `c355` (`ClinicID`);

--
-- Indexes for table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`Const_ID`),
  ADD UNIQUE KEY `Vis_IDC` (`Vis_IDC`),
  ADD KEY `c13` (`Vis_IDC`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Dept_ID`),
  ADD UNIQUE KEY `Dept_Name` (`Dept_Name`),
  ADD KEY `c6` (`Clinic_ID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`D_ID`),
  ADD KEY `c7` (`DUser_ID`),
  ADD KEY `c8` (`Dept_IDD`);

--
-- Indexes for table `doctor_workdays`
--
ALTER TABLE `doctor_workdays`
  ADD PRIMARY KEY (`D_ID`,`D_Day`,`Dstart_time`,`Dend_time`,`Dduration`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`P_ID`),
  ADD KEY `c3` (`PUser_ID`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_data`
--
ALTER TABLE `user_data`
  ADD PRIMARY KEY (`User_IDs`),
  ADD UNIQUE KEY `Mail` (`Mail`),
  ADD UNIQUE KEY `UserPhone` (`UserPhone`),
  ADD KEY `c0` (`Utype`),
  ADD KEY `C20` (`Ustatus`);

--
-- Indexes for table `user_status`
--
ALTER TABLE `user_status`
  ADD PRIMARY KEY (`Status_ID`);

--
-- Indexes for table `user_types`
--
ALTER TABLE `user_types`
  ADD PRIMARY KEY (`UTypeID`);

--
-- Indexes for table `visit`
--
ALTER TABLE `visit`
  ADD PRIMARY KEY (`Vis_ID`),
  ADD KEY `c11` (`Pv_ID`),
  ADD KEY `c12` (`Dv_ID`),
  ADD KEY `C24` (`Visit_type`),
  ADD KEY `c357` (`PaymentMethodid`);

--
-- Indexes for table `visit_desc`
--
ALTER TABLE `visit_desc`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `c356` (`VisID`);

--
-- Indexes for table `visit_type`
--
ALTER TABLE `visit_type`
  ADD PRIMARY KEY (`VType_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clinic`
--
ALTER TABLE `clinic`
  MODIFY `C_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `clinicphone`
--
ALTER TABLE `clinicphone`
  MODIFY `PhoneID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `Const_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `Dept_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `D_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `P_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_data`
--
ALTER TABLE `user_data`
  MODIFY `User_IDs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `user_status`
--
ALTER TABLE `user_status`
  MODIFY `Status_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_types`
--
ALTER TABLE `user_types`
  MODIFY `UTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `visit`
--
ALTER TABLE `visit`
  MODIFY `Vis_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `visit_desc`
--
ALTER TABLE `visit_desc`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `visit_type`
--
ALTER TABLE `visit_type`
  MODIFY `VType_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `clinicphone`
--
ALTER TABLE `clinicphone`
  ADD CONSTRAINT `c355` FOREIGN KEY (`ClinicID`) REFERENCES `clinic` (`C_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `c13` FOREIGN KEY (`Vis_IDC`) REFERENCES `visit` (`Vis_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `c6` FOREIGN KEY (`Clinic_ID`) REFERENCES `clinic` (`C_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `c7` FOREIGN KEY (`DUser_ID`) REFERENCES `user_data` (`User_IDs`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `c8` FOREIGN KEY (`Dept_IDD`) REFERENCES `department` (`Dept_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `doctor_workdays`
--
ALTER TABLE `doctor_workdays`
  ADD CONSTRAINT `C15` FOREIGN KEY (`D_ID`) REFERENCES `doctor` (`D_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `c3` FOREIGN KEY (`PUser_ID`) REFERENCES `user_data` (`User_IDs`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_data`
--
ALTER TABLE `user_data`
  ADD CONSTRAINT `C20` FOREIGN KEY (`Ustatus`) REFERENCES `user_status` (`Status_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `c0` FOREIGN KEY (`Utype`) REFERENCES `user_types` (`UTypeID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `visit`
--
ALTER TABLE `visit`
  ADD CONSTRAINT `C24` FOREIGN KEY (`Visit_type`) REFERENCES `visit_type` (`VType_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `c11` FOREIGN KEY (`Pv_ID`) REFERENCES `patient` (`P_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `c12` FOREIGN KEY (`Dv_ID`) REFERENCES `doctor` (`D_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `c357` FOREIGN KEY (`PaymentMethodid`) REFERENCES `payment_method` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `visit_desc`
--
ALTER TABLE `visit_desc`
  ADD CONSTRAINT `c356` FOREIGN KEY (`VisID`) REFERENCES `visit` (`Vis_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
