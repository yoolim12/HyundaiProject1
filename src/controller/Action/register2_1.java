package controller.Action;

import java.io.IOException;

import DTO.*;
import DAO.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register2_1")
public class register2_1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/login/register2_1.jsp"; 
			    
			    

				String id=request.getParameter("userID"); 
				String password=request.getParameter("userPassword1");
				request.setAttribute("id",id);
				request.setAttribute("password", password);
				 
				
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher(url);
				
				dispatcher.forward(request, response);
	}


	
}
