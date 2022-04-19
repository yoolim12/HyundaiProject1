//작성자 : 신동근
package controller.Action;

import java.io.IOException;


import DAO.*;
import DTO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// /UpdateMember로 어노테이션
@WebServlet("/UpdateMember")


public class UpdateMember extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "after_login.jsp";  //업데이트 후, 로그인 되어있는 페이지로 복귀한다.     
			   
			    
			    
				String id=request.getParameter("id");	// 폼에서 전송받은 id값을 받아와서 id 변수에 저장
				String password=request.getParameter("password");	// 폼에서 전송받은 password값을 받아와서 password 변수에 저장
				String name=request.getParameter("name");	// 폼에서 전송받은 name값을 받아와서 name 변수에 저장
				String birth=request.getParameter("birth");	// 폼에서 전송받은 birth값을 받아와서 birth 변수에 저장
				int gender=Integer.parseInt(request.getParameter("gender"));	// 폼에서 전송받은 gender값을 받아와서 gender 변수에 저장(gender = 1 -> 남자, 2 -> 여자)
				System.out.println(id);
				System.out.println(gender);
				String tel=request.getParameter("tel");	// 폼에서 전송받은 tel값을 받아와서 tel 변수에 저장
				String email=request.getParameter("email");	// 폼에서 전송받은 email값을 받아와서 email 변수에 저장
				
				// 전달받은값들을 저장받기위한 멤버 객체 생성
				MemberBean memberBean=new MemberBean(id,password,name,birth,gender,tel,email);
				
				MemberDAO dao=MemberDAO.getInstance();	// 싱글턴패턴 사용한 getInstance 호출
				
				dao.updateMember(memberBean);	// MemberBean객체를 이용해 현재 회원정보를 수정하는 메서드 호출
				
			    response.sendRedirect(url);	// 페이지 전환

	}
}
