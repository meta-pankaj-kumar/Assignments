package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.queryDriver;
import Facade.UpdationValidation;
import POJO.Employee;
@SuppressWarnings("serial")
public class UpdateDetailsServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		queryDriver obj=new queryDriver();
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		Employee employee = new Employee(req.getParameter("Name"),req.getParameter("Gender"),(String)session.getAttribute("Email"),"Not to be shown",req.getParameter("Number"),req.getParameter("Company"));
		String error = "";
		System.out.println(req.getParameter("fullName"));
		UpdationValidation validate = new UpdationValidation();
		error = validate.validate(employee);
		if(error==""){
			try {
				if(obj.executeUpdationQuery(employee)){
					req.setAttribute("Updated", "true");
					session.setAttribute("UserProfile", employee);
					RequestDispatcher rd = req.getRequestDispatcher("updateDetails.jsp");
					rd.forward(req, res);
				}
			} 
			catch (SQLException e) {		
					System.out.println(e);
			}
			 catch (Exception e) {
				System.out.println(e);
			}
		}
		else{
			RequestDispatcher rd = null;
			out.println("<div align='center'><p><b><font color=red>"+error+"</font></b></p><br></div>");
			req.setAttribute("Updated", "false");
			rd = req.getRequestDispatcher("/updateDetails.jsp");
			rd.include(req, res);
		}
	}
}