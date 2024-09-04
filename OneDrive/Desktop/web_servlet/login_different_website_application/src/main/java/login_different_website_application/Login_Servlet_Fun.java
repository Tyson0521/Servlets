package login_different_website_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class Login_Servlet_Fun extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		Connection c = null;
		PreparedStatement p =null;
		ResultSet r = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
			p = c.prepareStatement("select * from login_servlet.entertainment_servlet where email=? and password=?");
			p.setString(1, email);
			p.setString(2, pwd);
			r = p.executeQuery();
			
			String em = null;
			String pwds = null;
			
			while(r.next()) {
				em = r.getString("email");
				pwds = r.getString("password");
				
			}
			
			if(email.equals(em) && pwd.equals(pwds)) {
				resp.sendRedirect("home_Entertainment.html");
			} else {
				resp.sendRedirect("invalid_app.html");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(c!=null && p!=null && r!=null) {
				try {
					r.close();
					p.close();
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				System.out.println("resources are not closed !!!!");
			}
			
		}
		
		
	}
}
