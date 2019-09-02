package Facade;

import POJO.Employee;;

public class UpdationValidation {
	private String error="";
	public String validate(Employee employee){
		if(employee.getName().trim().equals("")){
			this.error = "Name Cannnot Contain Only Spaces";
		}
		else if(!employee.getName().matches("[a-z A-z]+")){
			this.error = "Name Should Contain only Aplhabets";
		}
		else if(employee.getContact().length()<8){
			this.error = "Contact Number should be between 8-10 digits";
		}
		else if(!employee.getContact().matches("[0-9]+")) {
			this.error = "Contact Number should Contain only Numeric Digits";
		}
		return this.error;
	}
}