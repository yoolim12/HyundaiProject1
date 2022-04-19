//작업자 : 공동

package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action.*;

// /sub로 어노테이션
@WebServlet("/sub")
public class sub extends HttpServlet {
  private static final long serialVersionUID = 1L;

// doGet 메서드를 호출하여 서블릿을 통해 커맨드를 입력받아와서 ActionFatory에 저장 및 action 실행
// URL에 정보가 포함됨
// Get방식으로 호출되는 메서드라고 보면 된다
protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    String command = request.getParameter("command");
    System.out.println("sub_Servlet : " + command);

    ActionFactory fac = ActionFactory.getInstance();
    Action action = fac.getAction(command);

    if (action != null) {
      action.execute(request, response);
    }
  }

// Post방식으로 호출되는 메서드
// URL에 정보가 포함되지 않음, 헤더에 정보를 실음
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    doGet(request, response);
  }
}//end class