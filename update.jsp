<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "java.util.*" %>
	<% 
		/* int id = Integer.parseInt(request.getParameter("student_id"));
		RequestDispatcher rd= request.getRequestDispatcher("updateStudent");
		rd.forward(request,response); */
	%>
	<table>
		<tr>
			<td>Id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>FirstName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>LastName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>FathersName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>ClassOfStudent&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>Age&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<% 
			ArrayList<String> list = (ArrayList)request.getAttribute("List");		
			for(int index = 0; index < list.size();index=index){
		%>	
		<tr>
		<form action = 'updateStudent' method = 'get'>
			<tr>
				<td>
					<input type = 'text' name ='student_id' value ='<%list.get(index++);%>' readonly>
				</td>
				<td>
					<%list.get(index++);%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					<%list.get(index++);%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					<%list.get(index++);%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					<%list.get(index++);%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					<%list.get(index++);%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					<%list.get(index++);%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td> 
				<input type = 'submit' value = 'Update Details'>
			</tr>
		</form>
		</tr>
		<%} %>
		</table>
</body>
</html>