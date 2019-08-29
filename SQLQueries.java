package DB;

public class SQLQueries {
	private String query;
	public SQLQueries(){
		this.query="";
	}
	public String getQuery() {
		return this.query;
	}
	public String getInsertionQuery(){
		this.query="INSERT INTO Student("
				+ "FirstName , LastName , FathersName , Email , ClassOfStudent , Age)"
				+ "VALUES(?,?,?,?,?,?);";
				
		return this.query;
	}
	public String getStudentsQuery(){
		this.query="SELECT * FROM Student ;";
		return this.query;
	}
	public String getStudentByIdQuery(){
		this.query="SELECT * FROM Student WHERE student.StudentId = ?;";
		return this.query;
	}
	public String getUpdationQuery(){
		this.query="Update Student "
				+ "SET Student.FirstName = ?,	"
				+ "Student.LastName = ?,	"
				+ "Student.FathersName = ?,	"
				+ "Student.Email = ?,	"
				+ "Student.ClassOfStudent = ? ,	"
				+ "Student.age = ? "
				+ "WHERE Student.StudentId = ? ;";
		return this.query;
	}
	public String getSearchQuery(){
		this.query = "call GetStudentDetailByName(?,?);";
		return this.query;
	}	
	public String getClassQuery(){
		this.query = "SELECT Student.ClassOfStudent "
				+ "FROM Student "
				+ "GROUP BY (Student.ClassOfStudent) ASC;";
		return this.query;
	}
	public String getClassStudentsQuery(){
		this.query="SELECT Student.FirstName , Student.LastName , Student.FathersName , Student.Email , Student.ClassOfStudent , Student.age FROM Student WHERE Student.ClassOfStudent = ? ;";
		return this.query;
	}
}