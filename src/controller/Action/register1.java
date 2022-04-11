package controller.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class register1 implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {    
		    String url = "login/register1.jsp";  
		    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);

	}
}
