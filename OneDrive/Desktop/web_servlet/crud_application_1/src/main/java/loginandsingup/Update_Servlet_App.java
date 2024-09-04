package loginandsingup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update_Servlet_App extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		long phno = Long.parseLong(req.getParameter("phno"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Connection c = null;
		PreparedStatement p =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
			p = c.prepareStatement("update crud_app.emp_details_app set ename=?,phno=?,address=?,email=?,password=? where empno=?");
			p.setString(1, ename);
			p.setLong(2, phno);
			p.setString(3, address);
			p.setString(4, email);
			p.setString(5, password);
			p.setString(6, empno);
			p.executeUpdate();
			
			resp.sendRedirect("update_successful.html");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(c!=null && p!=null) {
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
