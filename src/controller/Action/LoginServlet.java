//작업자 : 이승연
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

// /LoginServlet으로 어노테이션
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/login/Confirm.jsp"; //DB 랑 연동하여 로그인 시, 아이디 비밀번호 일치 여부 확인하는 jsp파일로 이동
			    
			    

				String id=request.getParameter("id"); // form을 통해서 전달받은 id값 저장(멤버 id)
				String password=request.getParameter("password");	// form을 통해서 전달받은 password값 저장(멤버 password)
				request.setAttribute("id",id); //request 객체에 id 와 password 값 할당
				request.setAttribute("password", password);	// 전달받은 password값을 request를 통해 password로 저장(request로 받을시 password 키워드로 받으면 전달받은 password값을 쓸수있다)
				 
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(url);	//RequestDispatcher를 통해 url 요청 실행(서블릿이 속해 있는 웹 어플리케이션 범위 내에서만 요청 제어
			    dispatcher.forward(request, response);		// 페이지 출력 및 전환
				
				
	}


	
}
