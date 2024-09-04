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

public class Update_Search_Servlet_App extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String updateColumn = req.getParameter("select");
		String data = req.getParameter("data");
		
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
			p = c.prepareStatement("select * from crud_app.emp_details_app where "+updateColumn+"=?");
			p.setString(1, data);
			r = p.executeQuery();
			
			PrintWriter pw = resp.getWriter();
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Home</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<h1 align=\"center\">The Employee Record Details are :</h1>\r\n");
			
			while(r.next()) {
				String empno = r.getString("empno");
				String ename = r.getString("ename");
				long phno = r.getLong("phno");
				String address = r.getString("address");
				String email = r.getString("email");
				String password = r.getString("password");
			
	            	pw.println("<form action='update' method='post'>");
	                pw.println("<label>Empno : </label><input type='text' name='empno' value='" + empno+ "' readonly><br>");
	                pw.println("<label>Ename : </label><input type='text' name='ename' value='" + ename+ "'><br>");
	                pw.println("<label>Phno : </label><input type='text' name='phno' value='" + phno+ "'><br>");
	                pw.println("<label>Address : </label><input type='text' name='address' value='" +address+ "'><br>");
	                pw.println("<label>Email : </label><input type='text' name='email' value='" + email+ "'><br>");
	                pw.println("<label>Password : </label><input type='text' name='password' value='" +password+ "'><br>");
	                pw.println("<a href='update_successful.html'><button>Update</button><a><br><br>");
	                pw.println("</form");
	            
				
			}
			pw.println("<h4>Click here to return Home : &nbsp;<a href=\"home_app.html\"><button>Home</button></a></h4>"
					+ "</body>\r\n"
					+ "</html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
