package Facade;

import POJO.Vehicle;;

public class VehicleValidation {
	private String error="";
	public String validate(Vehicle vehicle){
		if(vehicle.getVehicleName().trim().equals("")){
			this.error = "Vehicle Name Cannnot be blank";
		}
		else if(vehicle.getVehiclenumber().trim().equals("")){
			this.error = "Vehicle Number Cannnot be blank";
		}
		else if(vehicle.getVehicleType().equals("")){
			this.error = "Vehicle Type Cannnot be blank";
		}
		else if(vehicle.getEmployeeId().trim().equals("")){
			this.error = "Employee Id Cannnot be blank";
		}
		return this.error;
	}
}