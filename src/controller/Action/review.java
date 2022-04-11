package controller.Action;
import java.io.IOException;


import DAO.*;
import DTO.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class review extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/review.jsp"; 
			    String id =request.getParameter("id");
			    System.out.println(id);
			    reviewDAO dao = reviewDAO.getInstance();
			    
			    List review_list=dao.review_list(id);
				
			    
				
			    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			    request.setAttribute("review_list",review_list);
			    dispatcher.forward(request, response);
	}


	
}
