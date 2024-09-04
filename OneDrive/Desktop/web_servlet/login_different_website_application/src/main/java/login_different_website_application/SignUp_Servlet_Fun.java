package login_different_website_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns = "/signup")
public class SignUp_Servlet_Fun extends HttpServlet	{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("ename");
		Long phno = Long.parseLong(req.getParameter("phno"));
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd"); 
		
		Connection c = null;
		PreparedStatement p = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
			p = c.prepareStatement("insert into login_servlet.entertainment_servlet values (?,?,?,?)");
			p.setString(1, name);
			p.setLong(2, phno);
			p.setString(3, email);
			p.setString(4, pwd);
			p.executeUpdate();
			
			resp.sendRedirect("signup_successful.html");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(c!=null && p!=null ) {
				try {
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
