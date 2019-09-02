package Dao;

public class SQLQueries {
	private String query;
	public SQLQueries(){
		this.query="";
	}
	public String getQuery() {
		return this.query;
	}
	public String getInsertionQuery(){
		this.query="INSERT INTO Employee("
				+ "Name , Gender , Email , Password , Number , Company)"
				+ "VALUES(?,?,?,?,?,?);";
				
		return this.query;
	}
	public String getRegistrationNumber(){
		this.query="SELECT Employee.Id FROM Employee WHERE Employee.Email = ? ;";
		return this.query;
	}
	public String getPassword(){
		this.query="SELECT Employee.Password from Employee Where Email = ? ;";
		return this.query;
	}
	public String getVehicleInsertionQuery(){
		this.query="INSERT INTO Vehicle("
				+ "Email , Name , Type , Number , EmployeeId , Details)"
				+ "VALUES(?,?,?,?,?,?);";
		return this.query;
	}
	public String getVehicleId(){
		this.query="SELECT VehicleId FROM vehicle where Email = ? ORDER BY (VehicleId) DESC LIMIT 1 ;";
		return this.query;
	}
	public String getCompany() {
		this.query="SELECT Company FROM Employee WHERE Email = ?";
		return this.query;
	}
	public String getFriends() {
		this.query="SELECT Email FROM Employee WHERE Company = ?";
		return this.query;
	}
	public String getFriendsByName() {
		this.query="SELECT Name FROM Employee WHERE Company = ?";
		return this.query;
	}
	public String getProfile(){
		this.query="SELECT Employee.Name , Employee.Gender , Employee.Email , Employee.Number , Employee.Company"
				+ " FROM Employee"
				+ " WHERE Employee.Email = ?;";
		return this.query;
	}
	public String getPlanInsertionQuery(){
		this.query="INSERT INTO PlanDetails("
				+ "VehicleId , Email , Currency , PlanType , Price)"
				+ "VALUES(?,?,?,?,?);";
		return this.query;
	}
	public String getPlanId(){
		this.query="SELECT PlanId FROM PlanDetails where VehicleId = ? and Email = ? ORDER BY (PlanId) DESC LIMIT 1 ;";
		return this.query;
	}
	public String getCheckIfFirstTimeRegisterQuery(){
		this.query = "SELECT COUNT(Vehicle.vehicleId) FROM Vehicle WHERE Vehicle.Email = ?";
		return this.query;
	}
	public String getUpdationQuery(){
		this.query="Update Employee "
				+ "SET Employee.Name = ?,	"
				+ "Employee.Gender = ?,	"
				+ "Employee.Number = ? ,	"
				+ "Employee.Company = ? "
				+ "WHERE Employee.Email = ? ;";
		return this.query;
	}
}