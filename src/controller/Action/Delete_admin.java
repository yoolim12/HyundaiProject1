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

// /Delete_admin으로 어노테이션
@WebServlet("/Delete_admin")
public class Delete_admin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
		    	
			    String url = "/delete_admin.jsp"; // 관리자가 회원영구삭제 버튼을 눌렀을때 alert를 띄워주는 창으로 이동
			    
				String id=request.getParameter("delete_id"); 	// 폼에서 전송받은 delete_id값을 받아와서 id변수에 저장
				request.setAttribute("id",id);	
				Admin_deleteDAO delete=Admin_deleteDAO.getInstance();	// 싱글턴패턴 사용한 getInstance 호출
				delete.delete(id);	// Admin_deleteDAO 클래스의 delete 메서드 호출(회원 영구 삭제하는 메서드)
				 
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(url);	// RequestDispatcher를 통해 url 요청 실행(서블릿이 속해 있는 웹 어플리케이션 범위 내에서만 요청 제어)
			    dispatcher.forward(request, response);	// 페이지 출력 및 전환
				
				
	}


	
}
