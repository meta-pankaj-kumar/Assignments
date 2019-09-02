package Servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.queryDriver;
import POJO.Employee;
@SuppressWarnings("serial")
public class FriendsServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		queryDriver obj=new queryDriver();
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("Email");
		try {
			ResultSet result = obj.getFriends(email);
			ArrayList<String> list = new ArrayList<String>();
			while(result.next()) {
				list.add(result.getString(1));
			}
			result = obj.getFriendsByName(email);
			ArrayList<String> listOfNames = new ArrayList<String>();
			while(result.next()) {
				listOfNames.add(result.getString(1));
			}
			session.setAttribute("List",list);
			session.setAttribute("ListOfNames", listOfNames);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		}
		catch (SQLException e) {	
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		queryDriver obj=new queryDriver();
		String email = req.getParameter("FriendsEmail");
		try {
			ResultSet result = obj.getProfile(email);
			result.next();
			Employee employee = new Employee(result.getString(1),result.getString(2),result.getString(3),
					"Not to Be Shown",result.getString(4),result.getString(5));
			HttpSession session = req.getSession();
			session.setAttribute("Friend",employee);
			session.removeAttribute("List");
			RequestDispatcher rd = req.getRequestDispatcher("Profile.jsp");
			rd.forward(req, res);
		}
		catch (SQLException e) {	
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}