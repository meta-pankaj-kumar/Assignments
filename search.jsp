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
	<form action="searchStudentServlet" method = "post">
		<table>
			<tr>
				<td>
					Enter Name To Search For Student: 
				</td>
			</tr>
			<tr>
				<td>
					Enter First Name :
				</td>
				<td>
					<input type = "text" placeholder = "First Name" id = "firstName" name="firstName">
				</td>
			</tr>
			<tr>
				<td>
					Enter Last Name :
				</td>
				<td>
					<input type = "text" placeholder = "Last Name" id = "lastName" name="lastName">
				</td>
		</table>
		<input type = "submit" value = "Search Students">
	</form>
	<form action = "loadClassesServlet" method = "get">
		<input type = "submit" value = "Load Classes For Filtering">
	</form>
	<% if(request.getAttribute("List") != null){ %>
	<form action="loadClassesServlet" method = "post">
		<table>
			<tr>
				<td>
					Filtering By Class: 
				</td>
			</tr>
			<tr>
				<td>
					<select name = "Class" onChange = "this.form.submit()">
						<option value="">Select</option>
						<%
						ArrayList<Integer> list = (ArrayList)request.getAttribute("List");
							for(int index : list){
						%>
                        <option value="<%=index%>"><%=index %></option>
                       <%} %>
                    </select>
				</td>
			</tr>
		</table>
		
	</form>
	<%} %>
</body>
</html>