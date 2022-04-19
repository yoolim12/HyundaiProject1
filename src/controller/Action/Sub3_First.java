// 작업자: 변민혁
package controller.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sub3_First implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/menu/sub3_first.jsp";  // 물류 시스템 화면 이동
	    
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url);	// RequestDispatcher를 통해 url 요청 실행(서블릿이 속해 있는 웹 어플리케이션 범위 내에서만 요청 제어)
	    dispatcher.forward(request, response);	// 페이지 출력 및 전환
	}

}
