package Facade;


import POJO.Employee;;

public class Validation {
	private String error="";
	public String validate(Employee employee,String ConfirmPassword){
		if(employee.getName().trim().equals("")){
			this.error = "Name Cannnot Contain Only Spaces";
		}
		else if(!employee.getName().matches("[a-z A-z]+")){
			this.error = "Name Should Contain only Aplhabets";
		}
		else if(!employee.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
			this.error = "Invalid Email Entered";
		}
		/*else if(true){
			this.error = "Password should contain 8 - 15 characters having one Capital letter , one Small letter , one numeric digit and one Special Character excluding blank spac";
		}*/
		else if(!employee.getPassword().equals(ConfirmPassword)) {
			this.error = "Password and Confirm Password are not Same";
		}
		else if(employee.getContact().length()<8){
			this.error = "Contact Number should be between 8-10 digits";
		}
		else if(!employee.getContact().matches("[0-9]+")) {
			this.error = "Contact Number should Contain only Numeric Digits";
		}
		else if(employee.getCompany().equals("")) {
			this.error = "Company Not Selected";
		}
		return this.error;
	}
}