<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Division_2 JSP</title>
</head>
<body>
	<h3>Enter the Values to perform Division :</h3>
	<form action="division.jsp">
		<label>Enter the dividend :</label>
		<input name="num_1"><br><br>
		<label>Enter the divisor :</label>
		<input name="num_2"><br><br>
		<button>Divide</button> 
	</form>
	<% 
		String a = request.getParameter("num_1");
		String b = request.getParameter("num_2");
		
		session.setAttribute("a", a);
		session.setAttribute("b", b);
	
	%>
</body>
</html>