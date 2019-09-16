package com.sms;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.sms.dto.Student;
import com.sms.service.SMSService;

/**
 * 
 * @author Pankaj
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentManagementSystemTest {

	//Static object of SMSService class
	public static SMSService smsService = SMSService.getInstance();
	
	/**
	 * This method test positive cases on addStudent method of SMSService class
	 */
	@Test
	public void addStudentMethodPositiveTest() {
		
		Student student = new Student("asdf","asdf","f","sdf@sdf.sdf","12","22");
		assertTrue(smsService.addStudent(student));
	}
	
	/**
	 * This test method test positive test case on getAllStudent method of SMSService
	 */
	@Test
	public void getAllStudentPositiveTest() {
		
		Student expected = new Student("asdf","asdf","f","sdf@sdf.sdf","12","22");
		Student actual = smsService.getAllStudent().get(0);
		assertEquals(expected.getFirstName(),actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getFatherName(),actual.getFatherName());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getStudentClass(),actual.getStudentClass());
		assertEquals(expected.getAge(), actual.getAge());
	}
}
