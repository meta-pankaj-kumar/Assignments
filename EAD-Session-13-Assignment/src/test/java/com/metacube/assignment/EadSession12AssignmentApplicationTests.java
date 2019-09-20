package com.metacube.assignment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metacube.assignment.dto.StudentDTO;
import com.metacube.assignment.repository.StudentRepository;

/**
 * 
 * @author Pankaj
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EadSession12AssignmentApplicationTests {

	@Autowired
	StudentRepository repository;
	
	@Autowired
	public void setStudentDao(StudentRepository repository) {
		this.repository = repository;
	}

	StudentDTO student;
	
	@Test
	public void testgetStudents()
	{
		assertEquals("aaa.kukreja@metacube.com", repository.findAll().get(0).getEmail());
	}

}
