package POJO;

public class Vehicle {
	private String vehicleName;
	private String email;
	private String vehicleType;
	private String vehiclenumber;
	private String employeeId;
	private String vehicleDetails;
	public Vehicle(String email , String vehicleName,	String vehicleType,	String vehiclenumber,	String employeeId,	String vehicleDetails) {
		this.email = email;
		this.employeeId=employeeId;
		this.vehicleDetails=vehicleDetails;
		this.vehicleName=vehicleName;
		this.vehiclenumber=vehiclenumber;
		this.vehicleType=vehicleType;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVehicleName() {
		return this.vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return this.vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehiclenumber() {
		return this.vehiclenumber;
	}
	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}
	public String getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getVehicleDetails() {
		return this.vehicleDetails;
	}
	public void setVehicleDetails(String vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
	
}
