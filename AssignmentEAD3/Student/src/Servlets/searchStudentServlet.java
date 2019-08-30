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





import Dao.queryDriver;

@SuppressWarnings("serial")
public class searchStudentServlet extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException{
		queryDriver query = new queryDriver();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		firstName = firstName.trim();
		lastName  = lastName.trim();
		if(!(firstName.equals("") && lastName.equals(""))){
		try {
			System.out.println(" in");
			PrintWriter out = res.getWriter();
			ResultSet result = query.executeSearchQuery(firstName, lastName);
			out.println("<html><body background='pattern.jpg'><div align='center'><h1>Searching By "+firstName+" "+lastName+"</h1><table>");
			if(result.next()){
				result.beforeFirst();
				
				out.println("<tr>"
				      + "<td><b>First Name</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
					  + "<td><b>Last Name</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
					  + "<td><b>Fathers Name</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
					  + "<td><b>Email</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
					  + "<td><b>Class</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
					  + "<td><b>Age</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
					  + "</tr>");
				while (result.next()) {
					out.println("<tr>"
						+ "<td>"+(result.getString(1))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						+ "<td>"+(result.getString(2))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						+ "<td>"+(result.getString(3))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						+ "<td>"+(result.getString(4))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						+ "<td>"+(result.getInt(5))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						+ "<td>"+(result.getInt(6))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						+ "</tr>");
				}
				}
			else {
				out.println("<h3>No Such Record Found</h3>");
			}
			out.print("</table>"
					+ "</div></body>"
						+ "</html>");
		out.println("<html><body><div align='center'></br></br><a href='index.html'><p style = 'color:red; font-size: 120%'>Return To Homepage</p></a></div></body></html>");
	
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		}
		else{
			RequestDispatcher rd = null;
			PrintWriter out = res.getWriter();
			out.println("<div align='center'><p><b><font color=red>Searching Aborted</font></b></p><p><b><font color=red>Both Searching Fields Cannot Be Blank</font></b></p><br></div>");
			rd = req.getRequestDispatcher("search.jsp");
			rd.include(req, res);
		}
	}
}