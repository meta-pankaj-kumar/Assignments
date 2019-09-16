package com.sms.dao;

import java.util.ArrayList;
import java.util.List;

import com.sms.dto.Student;

/**
 * 
 * @author Pankaj
 *
 */
public class SMSDAO {

	//List of Student
	public static List<Student> studentList = new ArrayList<Student>();
	//Singleton object of SMSDAO class
	private static SMSDAO smsDAO;
	
	/**
	 * This method return the object of SMSDAO class
	 * @return object of SMSDAO class
	 */
	public static SMSDAO getInstance() {
		
		if(smsDAO == null) {
			smsDAO = new SMSDAO();
		}
		return smsDAO;
	}
	
	/**
	 * This method add student
	 * @param student object of Student class containing details about student to be added
	 * @return true if added else false
	 */
	public boolean addStudent(Student student){
		
		if(studentList.contains(student)) {
			
		}else {
			System.out.println("added");
			studentList.add(student);
			System.out.println(studentList.size());
		}
		return true;
	}
	
	/**
	 * This method return list of all student
	 * @return List of Student
	 */
	public List<Student> getAllStudent(){
		
		return studentList;
	}
}
