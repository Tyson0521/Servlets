<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Division</title>
</head>
<body>
	<%
	
		double d = 0, e = 0, div = 0;
		if(request.getParameter("num_1")==null){
			d = (int)session.getAttribute("d");
			div = d/0;
		} else {
			d = Double.parseDouble(request.getParameter("num_1"));
			e = Double.parseDouble(request.getParameter("num_2"));
			div = d/e;
		}
		out.println("<h1>The division of the given value is "+div+"</h1>");
	%>
</body>
</html>