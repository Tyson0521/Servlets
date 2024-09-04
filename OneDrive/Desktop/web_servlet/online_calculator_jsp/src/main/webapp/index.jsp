<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calci JSP</title>
<style type="text/css">
	form {
    max-width: 300px; /* Set maximum width */
    margin: 20px auto; /* Center form with margin */
    padding: 15px; /* Padding inside the form */
    border: 1px solid #ddd; /* Light gray border */
    border-radius: 8px; /* Rounded corners */
    background-color: #f9f9f9; /* Light background color */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow */
}

label {
    display: block; /* Block display for labels */
    margin-bottom: 8px; /* Space below the label */
    font-size: 14px; /* Font size for labels */
}

input {
    width: 100%; /* Full width of the form */
    padding: 15px; /* Padding inside the input */
    margin-bottom: 12px; /* Space below the input */
    border: 1px solid #ccc; /* Light gray border */
    border-radius: 10px; /* Slightly rounded corners */
    box-sizing: border-box; /* Include padding and border in width */
}

button {
    width: 100%; /* Full width of the form */
    padding: 10px; /* Padding inside the button */
    border: none; /* Remove default border */
    border-radius: 4px; /* Rounded corners */
    background-color: #007bff; /* Blue background */
    color: white; /* White text */
    font-size: 16px; /* Font size for button */
    cursor: pointer; /* Pointer cursor on hover */
}

button:hover {
    background-color: #0056b3; /* Darker blue on hover */
}
</style>
</head>
<body>
<br>
	<form action="add.jsp">
		<label>Enter the Number 1 :</label>
		<input name="num_1"><br><br>
		<label>Enter the Number 2 :</label>
		<input name="num_2"><br><br>
		<button>Add</button>
	</form>
</body>
</html>