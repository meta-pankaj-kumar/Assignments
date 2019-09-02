package POJO;

public class Plan {
	private int vehicleId;
	private String email;
	private String currency;
	private String planType;
	private String price;
	public Plan(int vehicleId , String email , String currency , String planType , String price) {
		this.vehicleId = vehicleId;
		this.price = price;
		this.planType = planType;
		this.email = email;
		this.currency = currency;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
