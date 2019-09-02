package Servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.queryDriver;
import POJO.Plan;
@SuppressWarnings("serial")
public class PlanDetailsServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		queryDriver obj=new queryDriver();
		HttpSession session = req.getSession();
		Plan plan = new Plan((int)session.getAttribute("VehicleId"),(String)session.getAttribute("Email"),(String)session.getAttribute("Currency"),(String)session.getAttribute("PlanType"),req.getParameter("Price"));
		try {
				if(obj.executePlanInsertionQuery(plan)){
					ResultSet result = obj.executeGetPlanId((int)session.getAttribute("VehicleId"),(String)session.getAttribute("Email"));
					result.next();
					int planid = result.getInt(1);
					session.setAttribute("PlanId", planid);
					session.setAttribute("List", null);
					req.setAttribute("Display","!!!!Vehicle details and Plan details are inserted Successfully!!!!!");
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
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
}