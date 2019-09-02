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
import Facade.VehicleValidation;
import POJO.Employee;
import POJO.Vehicle;
@SuppressWarnings("serial")
public class VehicleRegistrationServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		queryDriver obj=new queryDriver();
		PrintWriter out = res.getWriter();
		String error = "";
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("Email");
		Vehicle vehicle = new Vehicle(email,req.getParameter("VehicleName"),req.getParameter("VehicleType"),req.getParameter("VehicleNumber"),
				req.getParameter("EmployeeId"),req.getParameter("VehicleDetails"));
		VehicleValidation validate = new VehicleValidation();
		error = validate.validate(vehicle);
		if(error==""){
			try {				
				if(obj.executeVehicleInsertionQuery(vehicle)){
					session.setAttribute("Type",req.getParameter("VehicleType"));
					ResultSet result = obj.executeGetVehicleId(email);
					result.next();
					int id = result.getInt(1);
					session.setAttribute("VehicleId",id);
					ResultSet resultSet = obj.getProfile(email);
					resultSet.next();
					Employee employeeNew = new Employee(result.getString(1),result.getString(2),result.getString(3),
							"Not to Be Shown",result.getString(4),result.getString(5));
					session.setAttribute("UserProfile", employeeNew);
					RequestDispatcher rd = req.getRequestDispatcher("PlanSelection.jsp");
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
			rd = req.getRequestDispatcher("/Vehicle.jsp");
			rd.include(req, res);
		}
	}
}