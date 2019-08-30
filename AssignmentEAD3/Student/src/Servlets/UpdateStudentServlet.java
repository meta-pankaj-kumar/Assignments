package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.queryDriver;
import Facade.Validation;
import POJO.Student;
@SuppressWarnings("serial")
public class UpdateStudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException{
		PrintWriter out = res.getWriter();
		int studentId = Integer.parseInt(req.getParameter("student_id"));
		queryDriver query = new queryDriver();
		try {
			ResultSet result = query.executeDisplayQueryForStudentId(studentId);
			result.next();
			Student student = new Student(result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getInt(6),result.getInt(7));
			out.println("<html>"
							+ "<body background='pattern.jpg'>"
							+ "<div align = 'center'>"
								+ "<table>"
								+ "<h1>Update Student Details</h1>"
								+ "<form action = 'updateStudent' method= 'post'>");
			
				out.println("<tr>"
							+ "<td> </td><td><input type = 'text' name = 'id' value ='"+studentId+"' readonly style = 'border-style:none; opacity:0'></td></tr>"
							+ "<tr><td></br></td></tr>"
							+ "<tr><td>First Name: </td><td><input type = 'text' name = 'firstName' value ='"+student.getFirstName()+"'></td></tr>"
							+ "<tr><td></br></td></tr>"
							+ "<tr><td>Last Name: </td><td><input type = 'text' name = 'lastName' value ='"+student.getLastName()+"'></td></tr>"
							+ "<tr><td></br></td></tr>"
							+ "<tr><td>Fathers Name: </td><td><input type = 'text' name = 'fathersName' value ='"+student.getFathersName()+"'></td></tr>"
							+ "<tr><td></br></td></tr>"
							+ "<tr><td>Email: </td><td><input type = 'text' name = 'email' value ='"+student.getEmail()+"'></td></tr>"
							+ "<tr><td></br></td></tr>"
							+ "<tr><td>Class: </td><td><input type = 'number' name = 'class' value ='"+student.getClassOfStudent()+"'></td></tr>"
							+ "<tr><td></br></td></tr>"
							+ "<tr><td>Age: </td><td><input type = 'number' name = 'age' value ='"+student.getAge()+"'></td></tr>"
							+ "<tr><td></br></td></tr>"
							+ "<tr><td colspan = '2'><div align = 'center'><input type = 'submit' value = 'Update Details'></div></td></tr>"
							+ "</form>");
			out.print(""
								+ "</table>"
						+ "</div></body>"
					+ "</html>");
		} 
		catch (SQLException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException{
		PrintWriter out = res.getWriter();
		queryDriver query = new queryDriver();
		int studentId = Integer.parseInt(req.getParameter("id"));
		Student student = new Student(req.getParameter("firstName"),req.getParameter("lastName"),
				req.getParameter("fathersName"),req.getParameter("email"),
				Integer.parseInt(req.getParameter("class")),Integer.parseInt(req.getParameter("age")));
		String error = "";
		Validation validate = new Validation();
		error = validate.validate(student);
		if(error.equals("")){
			error = validate.validateUpdate(student);
		}
		if(error==""){
			try {
				if(query.executeUpdateQuery(student,studentId)){
					out.println("<html><body background='pattern.jpg'><div align='center'><h3>Student Details Updated Successfully</h3>");
					out.println("<a href='displayStudentServlet'><p style = 'color:red; font-size: 120%'>Update Another Student</p></a><a href='index.html'><p style = 'color:red; font-size: 120%'>Return To Homepage</p></a></div></body></html>");
				}
			} 
			catch (SQLIntegrityConstraintViolationException e) {		
				error = "Can not Update Selected Student as Inputted Email Address Already Exists";
			} 
			catch (Exception e) {
				System.out.println(e);
			}
			finally{
				if(error.equals("Can not Update Selected Student as Inputted Email Address Already Exists")){
					RequestDispatcher rd = null;
					out.println("<div align='center'><p><b><font color=red>Updation Aborted</font></b></p><p><b><font color=red>"+error+"</font></b></p><br></div>");
					rd = req.getRequestDispatcher("displayStudentServlet");
					rd.include(req, res);
				}
			}
		}
		else{
			RequestDispatcher rd = null;
			out.println("<div align='center'><p><b><font color=red>Updation Aborted</font></b></p><p><b><font color=red>"+error+"</font></b></p><br></div>");
			rd = req.getRequestDispatcher("displayStudentServlet");
			rd.include(req, res);
		}
	}
}