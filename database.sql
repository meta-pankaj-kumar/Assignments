CREATE database Employee;
Use Employee;
drop table vehicle;
drop table employee;
CREATE TABLE employee (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(255) NOT NULL,
  Gender varchar(6) NOT NULL check(Gender = 'Male' OR Gender = 'Female'),
  Email varchar(255) UNIQUE NOT NULL,
  Password varchar(15) NOT NULL,
  Number varchar(15) NOT NULL,
  Company varchar(50) NOT NULL,
  PRIMARY KEY (Id) ) ;

CREATE TABLE Vehicle (
  VehicleId int(11) NOT NULL AUTO_INCREMENT,
  Email varchar(45) Not Null,
  Name varchar(255) NOT NULL,
  Type varchar(50) NOT NULL,
  Number varchar(255) NOT NULL,
  EmployeeId varchar(15) NOT NULL,
  Details varchar(255) NOT NULL,
  Foreign Key(Email) REFERENCES employee(email),
  KEY(VehicleId),
  PRIMARY KEY (Email,VehicleId) ) ;
  
  CREATE TABLE PlanDetails (
  PlanId int(11) NOT NULL AUTO_INCREMENT,
  VehicleId int(11) NOT NULL,
  Email varchar(45) Not Null,
  Currency varchar(3) NOT NULL,
  PlanType varchar(7) NOT NULL,
  Price varchar(50) NOT NULL,
  Foreign Key(Email) REFERENCES Vehicle(email),
  Foreign Key(VehicleId) REFERENCES Vehicle(VehicleId),
  KEY(PlanId),
  PRIMARY KEY (PlanId) ) ;
  
