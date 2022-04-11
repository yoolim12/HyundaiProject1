package controller.Action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_login1")
public class admin_login1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/login/admin_login_1.jsp"; 
			    
			    

				String id=request.getParameter("masterID"); 
				String password=request.getParameter("masterPassword1");
				request.setAttribute("id",id);
				request.setAttribute("password", password);
				 
				
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher(url);
				
				dispatcher.forward(request, response);
	}


	
}
