CREATE database student;
Use Student;
CREATE TABLE student (
  StudentId int(11) NOT NULL AUTO_INCREMENT,
  FirstName varchar(255) NOT NULL,
  LastName varchar(255) NOT NULL,
  FathersName varchar(255) NOT NULL,
  Email varchar(255) UNIQUE NOT NULL,
  ClassOfStudent int(11) NOT NULL,
  Age int(11) NOT NULL,
  PRIMARY KEY (StudentId) ) ;



DELIMITER $$
CREATE PROCEDURE GetStudentDetailByName(IN firstName varchar(45),IN lastName varchar(45))
BEGIN
IF(firstName <> "" AND lastName = "") THEN
SELECT student.FirstName,student.LastName,student.FathersName,student.Email,student.ClassOfStudent,student.Age 
FROM student 
WHERE student.FirstName = firstName ;
ELSEIF(firstName = "" AND lastName <> "") THEN
SELECT student.FirstName,student.LastName,student.FathersName,student.Email,student.ClassOfStudent,student.Age FROM student WHERE student.LastName = lastName ORDER BY student.Class,student.LastName;
ELSE
SELECT student.FirstName,student.LastName,student.FathersName,student.Email,student.ClassOfStudent,student.Age FROM student WHERE student.FirstName = firstName AND student.LastName = lastName ORDER BY student.Class,student.FirstName,student.LastName;
END IF;

END
$$
DELIMITER ;



