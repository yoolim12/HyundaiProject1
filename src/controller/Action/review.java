//작업자 : 이승연
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
			    String url = "/review.jsp"; //한명의 회원이 작성한 모든 리뷰 조회하는 jsp파일로 이동
			    String id =request.getParameter("id");
			    
			    System.out.println(id);
			    reviewDAO dao = reviewDAO.getInstance(); //reviewDAO 로 DB 연결
			    
			    List review_list=dao.review_list(id);//id에 해당하는 모든 리뷰 리스트를 반환
				
			    
				
			    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			    request.setAttribute("review_list",review_list); //request객체에 리뷰리스트 반환
			    dispatcher.forward(request, response); // 페이지 출력 및 전환
	}


	
}
