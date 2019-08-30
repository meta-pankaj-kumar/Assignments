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

import Dao.queryDriver;

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
			out.println("<html><body background = 'pattern.jpg'><div align = 'center'>"
					+ "<table><h1>Filtering By Class "+classSelected+"</h1>");
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
			out.print("</table>");
			out.println("</br></br><a href='index.html'><p style = 'color:red; font-size: 120%'>Return To Homepage</p></a></div></body></html>");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}