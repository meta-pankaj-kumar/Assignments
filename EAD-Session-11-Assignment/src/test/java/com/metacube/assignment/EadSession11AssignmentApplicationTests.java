package com.metacube.assignment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metacube.assignment.dao.StudentDAO;
import com.metacube.assignment.dto.StudentForm;
import com.metacube.assignment.model.Student;
import com.metacube.assignment.util.DTOUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EadSession11AssignmentApplicationTests {

	@Autowired
	StudentDAO studentDao;
	
	@Autowired
	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	StudentForm student;
	
	@Before
	public void initialize() {
		student = new StudentForm();
		student.setEmail("aaa@metacube.com");
		student.setFirstName("aaa");
		student.setLastName("aaa");
		student.setFatherName("aaa");
		student.setStudentAge("12");
		student.setStudentClass("8");
	}
	
	@Test
	public void testAddStudent()
	{
		assertEquals(0, studentDao.add(DTOUtil.map(student, Student.class)));
	}
}
