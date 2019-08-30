package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class addStudentServlet extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException{
		queryDriver obj=new queryDriver();
		PrintWriter out = res.getWriter();
		String error = "";
		Student student = new Student(req.getParameter("firstName"),req.getParameter("lastName"),req.getParameter("fathersName"),req.getParameter("email"),Integer.parseInt(req.getParameter("class")),Integer.parseInt(req.getParameter("age")));
		Validation validate = new Validation();
		error = validate.validate(student);
		if(error==""){
			try {
				if(obj.executeInsertionQuery(student)){
					out.println("<html><body background='pattern.jpg'><div align = 'center' ><h1>Add New Student Portal</h1></br><p style='color:#001BFF;font-family: verdana; font-size: 120%;'><b>Student Inserted Successfully</b></p></br>");
					out.println("<a href='addStudent.html'><p style = 'color:red; font-size: 120%'>Add Another Student</p></a><a href='index.html'><p style = 'color:red; font-size: 120%'>Return To Homepage</p></a></div></body></html>");
				}
			} 
			catch (SQLIntegrityConstraintViolationException e) {		
					error = "Email Address Already Exists";
			}
			 catch (Exception e) {
				System.out.println(e);
			}
		finally{
				if(error.equals("Email Address Already Exists")){
					RequestDispatcher rd = null;
					out.println("<div align='center'><p><b><font color=red>"+error+"</font></b></p><br></div>");
					rd = req.getRequestDispatcher("/addStudent.html");
					rd.include(req, res);
				}
			}
		}
		else{
			RequestDispatcher rd = null;
			out.println("<div align='center'><p><b><font color=red>"+error+"</font></b></p><br></div>");
			rd = req.getRequestDispatcher("/addStudent.html");
			rd.include(req, res);
		}
	}
}