package web_servlet_annotations_p;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/addition") 
public class Annotations_Addition  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("value_1"));
		int b = Integer.parseInt(req.getParameter("value_2"));
		int c = a+b;
		
		HttpSession session = req.getSession();
		session.setAttribute("c", c);
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Sum of "+a+" and "+b+" is : "+c+"</h1>"
				+ "<h3>Click to do Sqaure</h3>"); 
		pw.println("<form action='square'>"
//				+ "<input name='sq' hidden value="+c+">"
				+ "<button>Sqaure</button>"
				+ "</form>");  
		pw.println("</body></html>"); 
		
	}
	
}
