<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<style>
.form-group{
width: 70%;
margin: auto;
}
</style>

<body>

<h1 align="center">Add Student</h1>

<div >
<form:form action="addStudent" modelAttribute="student">
  <div class="form-group">
    <label for="firstName">First Name:</label>
    <form:input path="firstName" type="text" class="form-control" id="firstName"/>
    <form:errors path="firstName" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <label for="lastName">Last Name:</label>
    <form:input path="lastName" type="text" class="form-control" id="lastName"/>
    <form:errors path="lastName" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <label for="fatherName">Father's Name:</label>
    <form:input path="fatherName" type="text" class="form-control" id="fatherName"/>
    <form:errors path="fatherName" cssClass="text-danger" />
  </div>
   <div class="form-group">
    <label for="email">Email address:</label>
    <form:input path="email" type="email" class="form-control" id="email" />
    <form:errors path="email" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <label for="studentClass">class:</label>
    <form:input path="studentClass" type="number" class="form-control" id="studentClass"/>
    <form:errors path="studentClass" cssClass="text-danger" />
  </div>
   <div class="form-group">
    <label for="age">Age:</label>
    <form:input path="age" type="number" class="form-control" id="age"/>
    <form:errors path="age" cssClass="text-danger" />
  </div >
  <div align="center">
  <button type="submit" class="btn btn-primary" >Submit</button>
  </div>
</form:form>
<div align = "center">
</br> <a href="/index">Return To Homepage</a></div>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>