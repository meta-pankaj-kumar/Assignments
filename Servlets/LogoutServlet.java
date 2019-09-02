package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession();
		session.invalidate();
		PrintWriter out = res.getWriter();
		RequestDispatcher rd = null;
		out.println("<div align='center'><p><b><font color=red>!!! Logged Out Successfully !!!</font></b></p><br></div>");
		rd = req.getRequestDispatcher("Login.jsp");
		rd.include(req, res);
	}
}
