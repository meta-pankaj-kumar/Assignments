package com.sms.service;

import java.util.List;
import com.sms.dao.SMSDAO;
import com.sms.dto.Student;

/**
 * 
 * @author Pankaj
 *
 */
public class SMSService {

	//Singleton object of SMSService class
	private static SMSService smsService;
	
	/**
	 * This method return the singleton object of SMSService class
	 * @return object of SMSService class
	 */
	public static SMSService getInstance() {
	
		if(smsService == null) {
			smsService = new SMSService();
		}
		
		return smsService;
	}
	
	/**
	 * This method add student
	 * @param student object of Student class containing details about student to be added
	 * @return true if added else false
	 */
	public boolean addStudent(Student student) {
		
		SMSDAO smsDAO = SMSDAO.getInstance();
		return smsDAO.addStudent(student);
	}
	
	/**
	 * This method return list of all student
	 * @return List of Student
	 */
	public List<Student> getAllStudent(){
		
		SMSDAO smsDAO = SMSDAO.getInstance();
		return smsDAO.getAllStudent();
	}
}
