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

@SuppressWarnings("serial")
public class loadClassesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException{
		queryDriver query = new queryDriver();
		try {
			ResultSet result = query.executeClassQuery();
			ArrayList<Integer> list=new ArrayList<Integer>();
			while(result.next()){
				list.add(result.getInt(1));
			}
			req.setAttribute("List",list);
			RequestDispatcher rd=req.getRequestDispatcher("search.jsp");
			rd.include(req,res);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException{
		queryDriver query = new queryDriver();
		int classSelected = Integer.parseInt(req.getParameter("Class"));
		try {
			PrintWriter out = res.getWriter();
			ResultSet result = query.executeClassStudentsQuery(classSelected);
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