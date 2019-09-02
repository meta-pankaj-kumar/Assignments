package POJO;

public class Employee {
	private String name;
	private String gender;
	private String email;
	private String password;
	private String contact;
	private String company;
	public Employee( String name , String gender, String email , String password, String contact, String company) {
		this.name=name;
		this.contact=contact;
		this.email=email;
		this.gender=gender;
		this.password=password;
		this.company=company;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return this.company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return this.contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
