package calculator_application_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Division_Servlet extends HttpServlet {
	
	String s = "";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			int data =(int) session.getAttribute("a");
			int n = 2;
			int res = data/n;
			PrintWriter pw = resp.getWriter();
			pw.println("<h1>The Division of "+data+" and "+n+" is "+res+"</h1>");
		} catch (ArithmeticException e) {
			// TODO: handle exception
			PrintWriter pw = resp.getWriter();
			pw.println("<h1>Error - We cannot divide with Zero</h1>");
		}
		
		
	}
}
