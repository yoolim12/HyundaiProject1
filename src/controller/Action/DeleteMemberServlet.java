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
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;

// /DeleteMemberServlet으로 어노테이션
@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/delete/DeleteMember.jsp"; 
			    
			    

			    HttpSession session=request.getSession();	//세션값 받아오기
	           
	            String id=(String)session.getAttribute("id"); //로그인 할때 id에 할당된 세션 값 가져오기
				
				System.out.println("받아온 세션 id 값: " + id); // 세션 id값 확인
				MemberDAO memberDao=MemberDAO.getInstance(); //DB 연결 객체 생성
				memberDao.deleteMember(id);//MemberDAO.deleteMember를 통해 회원탈퇴하기
				
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(url);	// RequestDispatcher를 통해 url 요청 실행(서블릿이 속해 있는 웹 어플리케이션 범위 내에서만 요청 제어)
			    dispatcher.forward(request, response);	// 페이지 출력 및 전환
	}


	
}
