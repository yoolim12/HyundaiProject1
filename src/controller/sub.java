//�۾��� : ����

package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action.*;

// /sub�� ������̼�
@WebServlet("/sub")
public class sub extends HttpServlet {
  private static final long serialVersionUID = 1L;

// doGet �޼��带 ȣ���Ͽ� ������ ���� Ŀ�ǵ带 �Է¹޾ƿͼ� ActionFatory�� ���� �� action ����
// URL�� ������ ���Ե�
// Get������� ȣ��Ǵ� �޼����� ���� �ȴ�
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

// Post������� ȣ��Ǵ� �޼���
// URL�� ������ ���Ե��� ����, ����� ������ ����
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    doGet(request, response);
  }
}//end class