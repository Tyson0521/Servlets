<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nav</title>
<style type="text/css">
	*{
		margin:0px;
		padding: 0px;
	}
	
	nav {
	    background-color: #3795BD; 
	    padding: 20px; 
	}
	
	nav ul {
	    list-style-type: none; /* Remove bullet points */
	    margin: 0; /* Remove default margin */
	    padding: 0; /* Remove default padding */
	    text-align: center; /* Center align the items */
	}
	
	nav ul li {
	    display: inline; /* Display list items in a horizontal line */
	    margin: 0 15px; /* Space between items */
	}
	
	nav ul li a {
	    color: #021526; /* White text color */
	    text-decoration: none; /* Remove underline */
	    font-size: 16px; /* Font size */
	    padding: 10px 15px; /* Padding inside the links */
	    border-radius: 4px; /* Slightly rounded corners */
	    transition: background-color 0.3s; /* Smooth transition for background color */
	}
	
	nav ul li a:hover {
	    color: #F5004F; /* Ensure text stays white on hover */
	}
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="add.html">Add</a></li>
			<li><a href="sqaure_2.jsp">Square</a></li>
			<li><a href="division_2.jsp">Division</a></li>
		</ul>
	</nav>
	
</body>
</html>