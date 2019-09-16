<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1 align="center">${welcomeMessage}</h1>
<div align="center">
	<a href="/add">Add Student</a>
	<a href="/showall">Show All Student</a>
	
</div>
</body>
</html>