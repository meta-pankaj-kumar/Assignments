package com.sms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * @author Pankaj
 *
 */
public class Student {
	
	//This represent first name of student
	@NotBlank(message="{firstName.NotBlank}")
	@Pattern(regexp="[a-zA-Z]+" , message="{firstName.OnlyAlphabates}")
	@Size(min=2, max=30, message="{firstName.Size}")
	private String firstName;
	
	//This represent last name of student
	@NotBlank(message="{lastName.NotBlank}")
	@Pattern(regexp="[a-zA-Z]+" , message="{lastName.OnlyAlphabates}")
	@Size(min=2, max=30, message="{lastName.Size}")
	private String lastName;
	
	//This represent father's name of student
	@NotBlank(message="{fatherName.NotBlank}")
	@Pattern(regexp="[a-zA-Z ]+" , message="{fatherName.OnlyAlphabates}")
	@Size(min=2, max=30, message="{fatherName.Size}")
	private String fatherName;
	
	//This represent email of student
	@NotBlank(message="{email.NotBlank}")
	@Email(message="{email.ValidEmail}")
	private String email;
	
	//This represent class of student
	@NotBlank(message="{studentClass.NotBlank}")
	@Pattern(regexp="[0-9]+" , message="{studentClass.OnlyNumber}")
	@Min(1)
	@Max(12)
	private String studentClass;
	
	//This represent age of student
	@NotBlank(message="{age.NotBlank}")
	@Pattern(regexp="[0-9]+" , message="{age.OnlyNumber}")
	@Min(1)
	@Max(25)
	private String age;
	
	/**
	 * Default constructor 
	 */
	public Student () {
		
	}
	
	/**
	 * This is parameterized constructor 
	 * @param firstName first name of student
	 * @param lastName last name of student
	 * @param fatherName father name of student
	 * @param email email of student
	 * @param studentClass class of student
	 * @param age age of student
	 */
	public Student(String firstName,String lastName,String fatherName,String email,String studentClass,String age) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.age = age;
	}
	
	/**
	 * This method return the first name of student
	 * @return first name of student
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * This method set the last name of student
	 * @param firstName first name of student
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * This method return last name of student
	 * @return last name of student
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * This method set the last name of student
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * This method return the father name of student
	 * @return father name of student
	 */
	public String getFatherName() {
		return fatherName;
	}
	
	/**
	 * This method set the father name of student
	 * @param fatherName father name of student
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	/**
	 * This method return the email of student
	 * @return email of student
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * This method set the email of student
	 * @param email email of student
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This method return the class of student
	 * @return class of student
	 */
	public String getStudentClass() {
		return studentClass;
	}
	
	/**
	 * This method set the class of student
	 * @param studentClass class of student
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	
	/**
	 * This method return the age of student
	 * @return age of student
	 */
	public String getAge() {
		return age;
	}
	
	/**
	 * This method set the age of student
	 * @param age age of student
	 */
	public void setAge(String age) {
		this.age = age;
	}

}
