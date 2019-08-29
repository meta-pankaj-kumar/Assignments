package POJO;

public class Student {
	private String firstName;
	private String lastName;
	private String fathersName;
	private String email;
	private int classOfStudent;
	private int age;
	
	public Student(String firstName,String lastName, String fathersName, String email, int classOfStudent, int age){
		this.age = age;
		this.classOfStudent = classOfStudent;
		this.email = email;
		this.fathersName = fathersName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFathersName() {
		return this.fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getClassOfStudent() {
		return this.classOfStudent;
	}

	public void setClassOfStudent(int classOfStudent) {
		this.classOfStudent = classOfStudent;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}