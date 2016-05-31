package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/index"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	
	

	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getServletPath();
		System.out.println(url);
		
		try {
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.getRequestDispatcher("jsp/errorServidor.jsp").forward(request, response);
		}
		
		
		
	}
	
	
	

}
