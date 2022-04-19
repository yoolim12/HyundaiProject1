// 작성자: 최유림
//cannot be cast to javax.servlet.Servlet 에러
// --> 이는 클래스에서 HttpServlet 를 상속받지 않아서 그렇다. HttpServlet를 상속받으면 말끔히 해결!
// 예시) public class clasName extends HttpServlet {}

package controller.Action;

import DAO.*;
import DTO.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// /ComplainServlet으로 어노테이션
@WebServlet("/ComplainServlet")
public class ComplainServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   // Post방식의 메서드
   protected void doPost(HttpServletRequest request,
               HttpServletResponse response) throws ServletException, IOException {
               request.setCharacterEncoding("UTF-8");
               String url = "/complain/ComplainAlert.jsp";	// 고객의 소리 등록 완료하는 페이지로 이동할 수 있게끔 저장
                
               
               HttpSession session=request.getSession(); //세션값 받아오기
             
               String id=(String)session.getAttribute("id");	//id를 키로 갖고 있는 세션 값 id에 할당
               System.out.println("받아온 id값: " + id);
               String category = request.getParameter("category");	// 폼에서 전송받은 category(분류 -> 칭찬, 불만, 제안, 기타)값을 받아와서 category 변수에 저장
               System.out.println("category: " + category);
               String name = request.getParameter("name");	// 폼에서 전송받은 name값을 받아와서 name 변수에 저장
               System.out.println("name: " + name);
               
               // 폼에서 전송받은 핸드폰 번호값들을 받아와서 tel 변수에 저장
               String tel = request.getParameter("wrterTelnoFrt") + "-" +request.getParameter("wrterTelnoMdd") + "-" + request.getParameter("wrterTelnoBck");
               System.out.println(tel);
               
               // 폼에서 전송받은 이메일값들을 받아와서 email 변수에 저장
               String email = request.getParameter("wrterEmailFrt") + "@" + request.getParameter("wrterEmailBck");
               
               String title = request.getParameter("title");	// 폼에서 전송받은 title(제목)값을 받아와서 title 변수에 저장
               System.out.println("제목: " + title);
               String details = request.getParameter("details");	// 폼에서 전송받은 details(내용)값을 받아와서 details 변수에 저장
               
               // 고객의 소리 폼값을 저장받기위한 객체 생성
               ComplainBean complainBean = new ComplainBean(category, name, tel, email, title, details);
               ComplainDAO complainDao = ComplainDAO.getInstance();	// 싱글턴패턴 사용한 getInstance 호출
               complainDao.addComplain(complainBean, id);	// 고객의 소리 등록하는 메서드 호출
               
               ServletContext context = request.getServletContext();
               RequestDispatcher dispatcher = context.getRequestDispatcher(url);	//RequestDispatcher를 통해 url 요청 실행(서블릿이 속해 있는 웹 어플리케이션 범위 내에서만 요청 제어)
               
               dispatcher.forward(request, response);	// 페이지 출력 및 전환
      }
}