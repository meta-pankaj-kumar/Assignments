package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.queryDriver;
import POJO.Student;
@SuppressWarnings("serial")
public class displayStudentServlet extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException{
		queryDriver obj=new queryDriver();
		try {
			ResultSet rs =obj.executeDisplayQuery();
			ArrayList<String> list=new ArrayList<String>();
			while(rs.next()){
				list.add(Integer.toString(rs.getInt(1)));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(Integer.toString(rs.getInt(6)));
				list.add(Integer.toString(rs.getInt(7)));
			}
			req.setAttribute("List",list);
			RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
			rd.include(req,res);
			/*PrintWriter out = res.getWriter();
			out.println("<html>"
							+ "<body>"
									+ "<table>");
			out.println("<tr>"
						  + "<td>Id&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td>FirstName&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td>LastName&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td>FathersName&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td>Email&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td>ClassOfStudent&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "<td>Age&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
						  + "</tr>");
			while (rs.next()) {
					out.println("<tr> <form action = 'update.jsp' method = 'get'><tr>"
							+ "<td><input type = 'text' name ='student_id' value ='"+rs.getInt(1)+"' readonly></td>"
							+ "<td>"+(rs.getString(2))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getString(3))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getString(4))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getString(5))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getInt(6))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td>"+(rs.getInt(7))+"&nbsp&nbsp&nbsp&nbsp&nbsp</td>"
							+ "<td> <input type = 'submit' value = 'Update Details'"
							+ "</tr></form></tr>");
			}
			out.print(""
								+ "</table>"
						+ "</body>"
					+ "</html>");
					*/
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}