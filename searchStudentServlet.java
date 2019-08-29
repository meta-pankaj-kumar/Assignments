package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DB.queryDriver;

@SuppressWarnings("serial")
public class searchStudentServlet extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException{
		queryDriver query = new queryDriver();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		try {
			PrintWriter out = res.getWriter();
			out.println("i am in");
			ResultSet result = query.executeSearchQuery(firstName, lastName);
			out.println("<html><body>"
					+ "<table>");
			out.println("<tr>"
			      + "<td>FirstName&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
				  + "<td>LastName&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
				  + "<td>FatheresultName&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
				  + "<td>Email&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
				  + "<td>ClassOfStudent&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
				  + "<td>Age&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
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
			out.print("</table>"
						+ "</body>"
							+ "</html>");
			out.println("<html><body><div align='center'><a href='index.html'>Return To Homepage</a></div></body></html>");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}