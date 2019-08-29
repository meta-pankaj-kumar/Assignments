package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.queryDriver;
import POJO.Student;
@SuppressWarnings("serial")
public class UpdateStudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException{
		PrintWriter out = res.getWriter();
		int studentId = Integer.parseInt(req.getParameter("student_id"));
		queryDriver query = new queryDriver();
		try {
			ResultSet result = query.executeDisplayQueryForStudentId(studentId);
			out.println("<html>"
							+ "<body>"
								+ "<table>"
								+ "<form action = '' method = 'Post'>");
			
			while (result.next()) {
				out.println("<tr>"
							+ "<td>Student Id: </td><td><input type = 'text' value ='"+result.getInt(1)+"' readonly></td></tr>"
							+ "<tr><td>First Name: </td><td><input type = 'text' name = 'firstName' value ='"+result.getString(2)+"'></td></tr>"
							+ "<tr><td>Last Name: </td><td><input type = 'text' name = 'lastName' value ='"+result.getString(3)+"'></td></tr>"
							+ "<tr><td>Fathers Name: </td><td><input type = 'text' name = 'fathersName' value ='"+result.getString(4)+"'></td></tr>"
							+ "<tr><td>Email: </td><td><input type = 'text' name = 'email' value ='"+result.getString(5)+"'></td></tr>"
							+ "<tr><td>Class: </td><td><input type = 'number' name = 'class' value ='"+result.getInt(6)+"'></td></tr>"
							+ "<tr><td>Age: </td><td><input type = 'number' name = 'age' value ='"+result.getInt(7)+"'></td></tr>"
							+ "<input type = 'submit' value = 'Update Details'>"
							+ "</form>");
			}
			out.print(""
								+ "</table>"
						+ "</body>"
					+ "</html>");
			Student student = new Student(req.getParameter("firstName"),req.getParameter("lastName"),
					req.getParameter("fathersName"),req.getParameter("email"),
					Integer.parseInt(req.getParameter("class")),Integer.parseInt(req.getParameter("age")));
			if(query.executeUpdateQuery(student,studentId)){
				out.println("Student Updated Successfully");
				out.println("<html><body><div align='center'><a href='index.html'>Return To Homepage</a></div></body></html>");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}