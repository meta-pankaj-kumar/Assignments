package Facade;

import POJO.Student;

public class Validation {
	private String error="";
	public String validate(Student student){
		if(student.getFirstName().trim().equals("")){
			this.error = "First Name Cannnot Contain Only Spaces";
		}
		else if(student.getLastName().trim().equals("")){
			this.error = "Last Name Cannnot Contain Only Spaces";
		}
		else if(student.getFathersName().trim().equals("")){
			this.error = "Fathers Name Cannnot Contain Only Spaces";
		}
		else if(student.getEmail().trim().equals("")){
			this.error = "Email Cannnot Contain Only Spaces";
		}
		else if(!student.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
			this.error = "Invalid Email Entered";
		}
		return this.error;
	}
	public String validateUpdate(Student student){
		if(!student.getFirstName().trim().matches("[a-zA-Z]+")){
			this.error = "First Name Should Contain Only Alphabets";
		}
		else if(!student.getLastName().trim().matches("[a-zA-Z]+")){
			this.error = "Last Name Should Contain Only Alphabets";
		}
		else if(!student.getFathersName().trim().matches("[a-z A-Z]+")){
			this.error = "Fathers Name Should Contain Only Alphabets";
		}
		return this.error;
	}
}
