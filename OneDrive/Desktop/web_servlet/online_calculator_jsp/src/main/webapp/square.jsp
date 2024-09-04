<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sqaure</title>
</head>
<body>
<br>
	<h1>The Sqaure of the sum of given values is 
		<% 
			int c = 0;
			System.out.println(request.getParameter("c"));
			if(request.getParameter("c")!=null){
				c = Integer.parseInt(request.getParameter("c"));
			} else {
				c = (int)session.getAttribute("c");
			}
			
			int d = c*c;
			out.println(d);
			session.setAttribute("d", d);
		%>
	</h1><br>
	<h3>Click to get the Division of the sum of the value</h3><br>
	<form action="division.jsp">
		<button>Division</button>
	</form>
	
</body>
</html>