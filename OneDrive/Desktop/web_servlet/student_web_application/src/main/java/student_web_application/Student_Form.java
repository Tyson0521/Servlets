package student_web_application;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Student_Form extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		int age = Integer.parseInt(req.getParameter("age"));
		long mobileNo = Long.parseLong(req.getParameter("mobileno")); 
		String address = req.getParameter("address");
		
		Connection c = null;
		PreparedStatement p = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			p = c.prepareStatement("insert into student_web_application.student_form_details values(?,?,?,?,?)");
			p.setString(1, firstName);
			p.setString(2, lastName);
			p.setInt(3, age);
			p.setLong(4, mobileNo);
			p.setString(5, address);
			p.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(c!=null && p!=null) {
				try {
					c.close();
					p.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
		
		
		//in html format we are giving a response
//		PrintWriter pw = resp.getWriter();
//		pw.println("<html><body>");
//		pw.println("<p>User First name is :"+ firstName+"</p>");
//		pw.println("<p>User Last name is :"+ lastName+"</p>");
//		pw.println("<p>User age is :"+ age+"</p>");
//		pw.println("<p>User mobile number is :"+ mobileNo +"</p>");
//		pw.println("<p>User address is :"+ address +"</p>");
//		pw.println("</body></html>");
		
		PrintWriter pw1 = resp.getWriter();
		pw1.println("<html><body style='text-align='center''>");
		pw1.println("<h1> Thank you Mr."+firstName+" for submitting your form.</h1>");
		pw1.println("<p>Your details have been successfully stored.</p>");
		pw1.println("</body></html>");
		
		
		
	}
}
