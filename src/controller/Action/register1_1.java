package controller.Action;

import java.io.IOException;


import DAO.*;
import DTO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register1_1")

//DAO의 addMember를 통한 DB에 데이터 삽입 (회원가입)
public class register1_1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "index.jsp";  //회원가입 후, 메인 페이지로 복귀한다. (로그인 전 페이지)
			    
			   
	
				String id=request.getParameter("userID");
				String password=request.getParameter("userPassword1");
				String name=request.getParameter("userName");
				String birth=request.getParameter("userBirth");
				String gender=request.getParameter("userGender");
				String ph=request.getParameter("userPH");
				String email=request.getParameter("userEmail");
				
				UserBean userbean=new UserBean(id,password,name,birth,gender,email,ph);
				
				UserDAO dao=UserDAO.getInstance();
				
				dao.addMember(userbean);
				
				
			    response.sendRedirect(url);

	}
}
