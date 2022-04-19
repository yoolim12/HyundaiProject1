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

// /plus로 어노테이션
@WebServlet("/plus")
public class plus extends HttpServlet {
   
   private static final long serialVersionUID = 1L;


   protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
             request.setCharacterEncoding("UTF-8");
             String url = "/plus.jsp"; //리뷰 상세 조회 하는 jsp파일로 이동
             
             String num=request.getParameter("num");	// 폼에서 전송받은 num값을 받아와서 num변수에 저장
             System.out.println(num);
             reviewDAO dao = reviewDAO.getInstance();	// 싱글턴패턴 사용한 getInstance 호출
             
             List plus_list=dao.detail(num);	// 리뷰를 상세하게 보여주는 메서드 호출
            
             
            
             RequestDispatcher dispatcher=request.getRequestDispatcher(url);	//RequestDispatcher를 통해 url 요청 실행(서블릿이 속해 있는 웹 어플리케이션 범위 내에서만 요청 제어
             request.setAttribute("plus_list", plus_list);	// 전달받은 plus_list값을 request를 통해 plus_list로 저장(request로 받을시 plus_list 키워드로 받으면 전달받은 password값을 쓸수있다)
             dispatcher.forward(request, response);	// 페이지 출력 및 전환
   }


   
}