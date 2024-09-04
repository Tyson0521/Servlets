package demo_http_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo_HTTP_Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String emailId = req.getParameter("email");
		long contact = Long.parseLong(req.getParameter("contact"));
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
			PreparedStatement p = c.prepareStatement("insert into demo_http_servlet.demo_http values (?,?,?,?)");
			p.setString(1, fn);
			p.setString(2, ln);
			p.setString(3, emailId);
			p.setLong(4, contact);
			p.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		pw.println("<p>Thank you for submitting your form</p>");
		pw.println("<p>User details are : </p>");
		pw.println("<p>User name : "+fn+" "+ln+"<br>EmailID : "+emailId+"<br>Contact :"+contact+"</p>");
		pw.println("</body></html>");
		
		
	}
}
