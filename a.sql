drop schema employee;

use employee;

CREATE TABLE `employee` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Number` varchar(15) NOT NULL,
  `Company` varchar(50) NOT NULL,
  ProfilePhtotoUrl varchar(200) NOT null,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `vehicle` (
  `VehicleId` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(45) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Number` varchar(255) NOT NULL,
  `EmployeeId` varchar(15) NOT NULL,
  `Details` varchar(255) NOT NULL,
  PRIMARY KEY (`Email`,`VehicleId`),
  KEY `VehicleId` (`VehicleId`),
  CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `employee` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1$$
delimiter $$

CREATE TABLE `plandetails` (
  `PlanId` int(11) NOT NULL AUTO_INCREMENT,
  `VehicleId` int(11) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Currency` varchar(3) NOT NULL,
  `Price` varchar(50) NOT NULL,
  PRIMARY KEY (`PlanId`),
  KEY `Email` (`Email`),
  KEY `VehicleId` (`VehicleId`),
  KEY `PlanId` (`PlanId`),
  CONSTRAINT `plandetails_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `vehicle` (`Email`),
  CONSTRAINT `plandetails_ibfk_2` FOREIGN KEY (`VehicleId`) REFERENCES `vehicle` (`VehicleId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1$$




