package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.queryDriver;
import POJO.Student;

@SuppressWarnings("serial")
public class addStudentServlet extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException{
		queryDriver obj=new queryDriver();
		PrintWriter out = res.getWriter();
		Student student = new Student(req.getParameter("firstName"),req.getParameter("lastName"),
									req.getParameter("fathersName"),req.getParameter("email"),
									Integer.parseInt(req.getParameter("class")),Integer.parseInt(req.getParameter("age")));
		
		
			try {
				if(obj.executeInsertionQuery(student)){
					out.println("Student Inserted Successfully");
					out.println("<html><body><div align='center'><a href='index.html'>Return To Homepage</a></div></body></html>");
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}