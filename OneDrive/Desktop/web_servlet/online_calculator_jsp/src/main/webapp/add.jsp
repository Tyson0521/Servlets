<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator JSP</title>
</head>
<body>
<br>
	<%
		int a = Integer.parseInt(request.getParameter("num_1"));
		int b = Integer.parseInt(request.getParameter("num_2"));
		
		int c = a+b;
		session.setAttribute("c", c);
		
	%>
	<h1>The sum of given two values is <% out.println(c); %></h1><br>
	<h3>Click to get the sqaure of the sum of the value</h3><br>
	<form action="square.jsp">
		<button>Sqaure</button>
	</form>
</body>
</html>