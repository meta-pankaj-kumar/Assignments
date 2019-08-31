<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="pattern.jpg">
<%@ page import = "java.util.*" %>
<div align='center'>
	<h1>Search Student According to Names or Class Filter</h1></br>
	<p style="color:#001BFF;font-family: verdana; font-size: 120%;"><b>Searching by Name :</b></p>
	<form action="searchStudentServlet" method = "post">
		<table>
			<tr>
				<td colspan = '2'>
				<div align = "center">
					<b>Enter First Name or Last Name or Both To Search For Student:</b> 
				</div>
				</td>
			</tr>
			<tr>
				<td> </br>
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
				<td></br>
				</td>
			</tr>
			<tr>
				<td>
					Enter Last Name :
				</td>
				<td>
					<input type = "text" placeholder = "Last Name" id = "lastName" name="lastName">
				</td>
			</tr>
			<tr>
				<td></br>
				</td>
			</tr>
		</table>
		<input type = "submit" value = "Search Students">
	</form></br></br>
	<p style="color:#001BFF;font-family: verdana; font-size: 120%;"><b>Filtering By Class :</b></p>
	<form action = "loadClassesServlet" method = "get">
		<input type = "submit" value = "Load Classes For Filtering">
	</form>
	<% if(request.getAttribute("List") != null){ %>
	<form action="loadClassesServlet" method = "post">
		<table>
			<tr>
				<td>
					</br><b>Filtering By Class: </b>
				</td>
			</tr>
			<tr>
				<td></br>
				</td>
			</tr>
			<tr>
				<td>
					<select name = "Class" onChange = "this.form.submit()">
						<option value="">Select Class</option>
						<%
						ArrayList<Integer> list = (ArrayList)request.getAttribute("List");
						int flag=0;
							for(int index : list){
							flag=1;
						%>
                        <option value="<%=index%>"><%=index %></option>
                       <%} %>
                    </select>
				</td>
			</tr>
			<tr>
				<td>
				<%if(flag==0) {%>
					<p>No Classes Found For filtering in Records</p>
					<%} %>
				</td>
			</tr>
		</table>
		
	</form>
	<%} %>
	</div>
</body>
</html>
