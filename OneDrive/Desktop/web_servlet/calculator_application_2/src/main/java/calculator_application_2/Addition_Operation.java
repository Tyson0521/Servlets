package calculator_application_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Addition_Operation extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("value_1"));
		int b = Integer.parseInt(req.getParameter("value_2"));
		int c = a+b;
		
		
		//Using session
		HttpSession session = req.getSession();
		session.setAttribute("c", c);
		
		//Using Form
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Sum of "+a+" and "+b+" is : "+c+"</h1>"
				+ "<h3>Click to do Sqaure</h3>"); 
		pw.println("<form action='square'>"
//				+ "<input name='sq' hidden value="+c+">"
				+ "<button>Sqaure</button>"
				+ "</form>");  
		pw.println("</body></html>"); 
	
		
		//Using string URL
//		RequestDispatcher rd = req.getRequestDispatcher("square?c="+c);
//		rd.forward(req, resp);
		
		
		//Using attribute method
//		req.setAttribute("a", c); //String is key-can be any name & c is value-which we want to pass to another servlet
//		RequestDispatcher rd = req.getRequestDispatcher("square"); //here square is URL and we need to configure in web.xml 
//		rd.forward(req, resp); 
		
	}
}
