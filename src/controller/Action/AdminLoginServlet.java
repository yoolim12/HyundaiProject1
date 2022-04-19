//작업자 : 이승연
package controller.Action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// /AdminLoginServlet으로 어노테이션
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// Post방식의 메서드
	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/login/AdminLoginConfirm.jsp"; //DB연동하는 로그인 로직 jsp 로 이동
			    
			    

				String id=request.getParameter("id"); 	// form을 통해서 전달받은 id값 저장(관리자 id)
				String password=request.getParameter("password");	// form을 통해서 전달받은 password값 저장(관리자 password)
				request.setAttribute("id",id);	// 전달받은 id값을 request를 통해 id로 저장(request로 받을시 id 키워드로 받으면 전달받은 id값을 쓸수있다)
				request.setAttribute("password", password);	// 전달받은 password값을 request를 통해 password로 저장(request로 받을시 password 키워드로 받으면 전달받은 password값을 쓸수있다)
				
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(url);	//RequestDispatcher를 통해 url 요청 실행(서블릿이 속해 있는 웹 어플리케이션 범위 내에서만 요청 제어
			    dispatcher.forward(request, response);	// 페이지 출력 및 전환
	}


	
}
