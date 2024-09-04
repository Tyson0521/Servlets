package calculator_application_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Sqaure_Servlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Using Attribute method
//		int a = (int)req.getAttribute("a");
		
		
		//Using Form 
//		int a = Integer.parseInt(req.getParameter("sq")); //from the form tag of addition servlet
		
		
		//Using String URL
//		int a = Integer.parseInt(req.getParameter("c")); //from string url
		
		
		//Session
		HttpSession session = req.getSession();
		int a = (int) session.getAttribute("c");
		session.setAttribute("a", a); 
		
		int sq = a*a; 
		
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>The Sqaure of sum of two values is : "+sq+"</h1>"); 
		pw.println("<h3>Click to do Division</h3>"); 
		pw.println("<form action='division'>"
				+ "<input name='c' hidden value="+sq+">"
				+ "<button>Division</button>"
				+ "</form>");
		
	}
}
