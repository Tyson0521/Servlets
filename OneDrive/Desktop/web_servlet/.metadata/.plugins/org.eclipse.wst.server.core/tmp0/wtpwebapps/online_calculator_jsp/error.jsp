<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<style type="text/css">
	h1{
	color: red;
	}
</style>
</head>
<body>	
	<h1> Error !! <%= exception.getMessage()  %></h1>
	
</body>
</html>