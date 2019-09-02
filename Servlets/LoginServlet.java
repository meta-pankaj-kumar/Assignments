package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.queryDriver;
import POJO.Employee;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		queryDriver obj=new queryDriver();
		PrintWriter out = res.getWriter();
		try {
			Boolean status = obj.areCredentialsAuthentic(req.getParameter("Email"), req.getParameter("Password"));
			if(status) {
				HttpSession session = req.getSession();
				String email = req.getParameter("Email");
				session.setAttribute("Email",email);
				ResultSet result = obj.getProfile(email);
				result.next();
				Employee employee = new Employee(result.getString(1),result.getString(2),result.getString(3),
						"Not to Be Shown",result.getString(4),result.getString(5));
				session.setAttribute("UserProfile", employee);
				if(obj.execteCheckIfFirstTimeRegister(email)){
					res.sendRedirect("Vehicle.jsp");
				}
				else{
					session.setAttribute("List", null);
					res.sendRedirect("index.jsp");
				}
			}
		}
		catch (SQLException e) {		
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			RequestDispatcher rd = null;
			out.println("<div align='center'><p><b><font color=red>!!! Invalid Credentials !!!</font></b></p><br></div>");
			rd = req.getRequestDispatcher("/Login.jsp");
			rd.include(req, res);
		}
	}
}