package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.queryDriver;
@SuppressWarnings("serial")
public class displayStudentServlet extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException{
		queryDriver obj=new queryDriver();
		try {
			ResultSet rs =obj.executeDisplayQuery();
			
			PrintWriter out = res.getWriter();
			out.println("<html>"
							+ "<body background='pattern.jpg'>"
									+ "<div align = 'center'><table>");
			out.println("<tr>"
						  + "<td> </td>"
						  + "<td><b>First Name</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td><b>Last Name</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td><b>Fathers Name</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td><b>Email</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td><b>Class</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td><b>Age</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td><b>Update Link</b>&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "</tr>");
			while (rs.next()) {
					out.println("<tr> <form action = 'updateStudent' method = 'get'><tr>"
							+ "<td><input type = 'text' name ='student_id' value ='"+rs.getInt(1)+"' readonly size = '3' style = 'border-style:none; opacity:0'></td>"
							+ "<td>"+(rs.getString(2))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getString(3))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getString(4))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getString(5))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getInt(6))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getInt(7))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td> <input type = 'submit' value = 'Update Details'"
							+ "</tr></form></tr>");
			}
			out.println("<a href='index.html'><p style = 'color:red; font-size: 120%'>Return To Homepage</p></a></div></body></html>");
			out.print(""
								+ "</table></div>"
						+ "</body>"
					+ "</html>");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException{
		doPost(req, res);
	}
}