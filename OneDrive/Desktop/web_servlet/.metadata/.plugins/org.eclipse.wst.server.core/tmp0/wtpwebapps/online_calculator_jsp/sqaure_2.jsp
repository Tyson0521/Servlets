<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sqaure-2 jsp</title>
</head>
<body>
	<h3>Enter the Value to get Sqaure :</h3>
	<form action="square.jsp">
		<label>Enter the Number 1 :</label>
		<input name="c"><br><br>
		<button>Square</button>
	</form> 
	<%
		String a = request.getParameter("c");
		session.setAttribute("c", a);
	%>
</body>
</html>