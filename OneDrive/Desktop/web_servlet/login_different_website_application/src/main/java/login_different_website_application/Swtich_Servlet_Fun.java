package login_different_website_application;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/swtich_app")
public class Swtich_Servlet_Fun extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String app = req.getParameter("website");
		
		switch (app) {
		case "prime":
			resp.sendRedirect("https://www.primevideo.com/storefront/ref=atv_hom_pri_c_9zZ8D2_hm_mv?contentType=movie&contentId=home");
			break;
		case "aha":
			resp.sendRedirect("https://www.aha.video/");
			break;
		case "hotstar":
			resp.sendRedirect("https://www.hotstar.com/in/movies");
			break;
		case "aniwave":
			resp.sendRedirect("https://aniwave.to/home");
			break;
		case "jiocinema":
			resp.sendRedirect("https://www.jiocinema.com/");
			break;
		default:
			resp.sendRedirect("home_Entertainment.html");
			break;
		}
		
		
		
	}
}
