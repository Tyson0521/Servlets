package loginandsingup;

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

public class Delete_Servlet_App extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String columnName = req.getParameter("select");
		String data = req.getParameter("data");
		
		Connection c = null;
		PreparedStatement p =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
			p = c.prepareStatement("delete from crud_app.emp_details_app where "+columnName+"=?");
			p.setString(1, data);
			p.executeUpdate();
			
			PrintWriter pw = resp.getWriter();
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Home</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<h1 align=\"center\">The record of "+columnName+" - "+ data +" has been Deleted!!</h1>\r\n");
			pw.println("</table>\r\n"
					+ "<h4>Click here to return Home : &nbsp;<a href=\"home_app.html\"><button>Home</button></a></h4>"
					+ "</body>\r\n"
					+ "</html>");
			
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
