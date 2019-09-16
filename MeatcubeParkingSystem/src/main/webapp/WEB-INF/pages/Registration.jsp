<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page import = "com.metacube.parking.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<style>
.form-group{
width: 70%;
margin: auto;
}
</style>

<body>

	<div align="center">
	<h1>Registration Page</h1>
		<div align = "right"><b><a href = "login">Existing User Login Here &nbsp;&nbsp;&nbsp;</a></b></div>
	<form:form action="addEmployee" modelAttribute="employee">
	
	  <div class="form-group">
	    <label for="fullName">Full Name:</label>
	    <form:input path="fullName" type="text" class="form-control" id="fullName"/>
	    <form:errors path="fullName" cssClass="text-danger" />
	  </div>
	   </br>
	  <div class="form-group">
	  <form:label path = "gender">Gender</form:label>
      <form:radiobutton path = "gender" value = "Male" label = "Male" checked = "checked"/>
      <form:radiobutton path = "gender" value = "Female" label = "Female" />
	  <form:errors path="gender" cssClass="text-danger" />
	  </div>
	  <div class="form-group">
	    <label for="email">Email:</label>
	    <form:input path="email" type="text" class="form-control" id="email"/>
	    <form:errors path="email" cssClass="text-danger" />
	  </div>
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <form:input path="password" type="password" class="form-control" id="password"/>
	    <form:errors path="password" cssClass="text-danger" />
	  </div>
	  <div class="form-group">
	    <label for="confirmPassword">Confirm Password</label>
	    <form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword"/>
	    <form:errors path="confirmPassword" cssClass="text-danger" />
	  </div>
	  <div class="form-group">
	    <label for="contactNumber">Contact Number:</label>
	    <form:input path="contactNumber" type="number" class="form-control" id="contactNumber"/>
	    <form:errors path="contactNumber" cssClass="text-danger" />
	  </div>
	  <div class="form-group">
	  </br>
	  <form:select path="organization">
			<form:option value="Metacube" label="Metacube"/>
			<form:option value="IBM" label="IBM"/>
			<form:option value="TCS" label="TCS"/>
			<form:option value="Wipro" label="Wipro"/>
			<form:option value="Oracle" label="Oracle"/>
	  </form:select>
	  </div>
	  <div align="center">
	   </br>
  <button type="submit" class="btn btn-primary" >Submit</button>
  </div>
	 </form:form>
	  </br>
	
	</div>
</body>
</html>