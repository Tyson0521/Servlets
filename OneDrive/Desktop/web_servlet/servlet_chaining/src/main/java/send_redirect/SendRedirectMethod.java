package send_redirect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRedirectMethod extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
			p = c.prepareStatement("select * from login_servlet.login_details where emailId=? and password=?");
			p.setString(1, email);
			p.setString(2, pwd);
			r = p.executeQuery();
			
			String e = null;
			String ps = null;
			
			while(r.next()) {
				e = r.getString(1);
				ps = r.getString(2);
			}
			
			if(email.equals(e) && pwd.equals(ps)) {
				resp.sendRedirect("https://www.youtube.com/");
				
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/servlet_chaining/src/main/webapp/validation_incorrect.html");
				rd.include(req, resp);	
				
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
