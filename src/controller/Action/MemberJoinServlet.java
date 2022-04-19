//작업자 : 이승연, 신동근
package controller.Action;

import java.io.IOException;


import DAO.*;
import DTO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// /MemberJoinServlet으로 어노테이션
@WebServlet("/MemberJoinServlet")

//DAO의 addMember를 통한 DB에 데이터 삽입 (회원가입)
public class MemberJoinServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "index.jsp";  //회원가입 후, 메인 페이지로 복귀한다. (로그인 전 페이지)
			    
			   
	
				String id=request.getParameter("id");	// 폼에서 전송받은 id값을 받아와서 id변수에 저장
				String password=request.getParameter("password");	// 폼에서 전송받은 password값을 받아와서 password변수에 저장
				String name=request.getParameter("name");	// 폼에서 전송받은 password값을 받아와서 password변수에 저장
				String birth=request.getParameter("birth");	// 폼에서 전송받은 password값을 받아와서 password변수에 저장
				int gender=Integer.parseInt(request.getParameter("gender"));	// 폼에서 전송받은 gender값을 받아와서 gender변수에 저장(gender = 1 -> 남자, 2 -> 여자)
				String tel=request.getParameter("tel");	// 폼에서 전송받은 tel값을 받아와서 tel변수에 저장
				String email=request.getParameter("email");	// 폼에서 전송받은 email값을 받아와서 email변수에 저장
				
				// 전달받은값들을 저장받기위한 멤버 객체 생성
				MemberBean memberBean=new MemberBean(id,password,name,birth,gender,tel, email);
				
				MemberDAO dao=MemberDAO.getInstance();	// 싱글턴패턴 사용한 getInstance 호출
				
				dao.addMember(memberBean);	// 멤버테이블에 멤버를 저장하는 메서드 호출
				
				
			    response.sendRedirect(url); //전달할 객체는 없으므로, sendRedirect 사용

	}
}
