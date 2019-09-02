package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.queryDriver;
import Facade.Validation;
import POJO.Employee;
@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		queryDriver obj=new queryDriver();
		PrintWriter out = res.getWriter();
		String error = "";
		Employee employee = new Employee(req.getParameter("Name"),req.getParameter("Gender"),req.getParameter("Email"),
				req.getParameter("Password"),req.getParameter("Number"),req.getParameter("Company"));
		Validation validate = new Validation();
		error = validate.validate(employee,req.getParameter("ConfirmPassword"));
		if(error==""){
			try {
				if(obj.executeInsertionQuery(employee)){
					ResultSet result = obj.getRegistrationNumber(employee);
					result.next();
					int regNo = result.getInt(1);
					req.setAttribute("Registered", "true");
					req.setAttribute("RegistrationNumber", regNo);
					RequestDispatcher rd = req.getRequestDispatcher("RegistrationPage.jsp");
					rd.forward(req, res);
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
					rd = req.getRequestDispatcher("/RegistrationPage.jsp");
					rd.include(req, res);
				}
			}
		}
		else{
			RequestDispatcher rd = null;
			out.println("<div align='center'><p><b><font color=red>"+error+"</font></b></p><br></div>");
			req.setAttribute("Registered", "false");
			req.setAttribute("Employee",employee);
			rd = req.getRequestDispatcher("/RegistrationPage.jsp");
			rd.include(req, res);
		}
	}
}