<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection,java.lang.ClassNotFoundException,java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>a_jsp</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		out.println("Welcome home "+name);
	 try{	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("insert into jsp.jsp_demo values (?)");
		pstmt.setString(1, name);
		pstmt.executeUpdate();
	}catch(ClassNotFoundException | SQLException ce){
		ce.printStackTrace();
	}
	%>
	

</body>
</html>