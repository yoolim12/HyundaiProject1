// �ۼ���: ������
//cannot be cast to javax.servlet.Servlet ����
// --> �̴� Ŭ�������� HttpServlet �� ��ӹ��� �ʾƼ� �׷���. HttpServlet�� ��ӹ����� ������ �ذ�!
// ����) public class clasName extends HttpServlet {}

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

// /ComplainServlet���� ������̼�
@WebServlet("/ComplainServlet")
public class ComplainServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   // Post����� �޼���
   protected void doPost(HttpServletRequest request,
               HttpServletResponse response) throws ServletException, IOException {
               request.setCharacterEncoding("UTF-8");
               String url = "/complain/ComplainAlert.jsp";	// ���� �Ҹ� ��� �Ϸ��ϴ� �������� �̵��� �� �ְԲ� ����
                
               
               HttpSession session=request.getSession(); //���ǰ� �޾ƿ���
             
               String id=(String)session.getAttribute("id");	//id�� Ű�� ���� �ִ� ���� �� id�� �Ҵ�
               System.out.println("�޾ƿ� id��: " + id);
               String category = request.getParameter("category");	// ������ ���۹��� category(�з� -> Ī��, �Ҹ�, ����, ��Ÿ)���� �޾ƿͼ� category ������ ����
               System.out.println("category: " + category);
               String name = request.getParameter("name");	// ������ ���۹��� name���� �޾ƿͼ� name ������ ����
               System.out.println("name: " + name);
               
               // ������ ���۹��� �ڵ��� ��ȣ������ �޾ƿͼ� tel ������ ����
               String tel = request.getParameter("wrterTelnoFrt") + "-" +request.getParameter("wrterTelnoMdd") + "-" + request.getParameter("wrterTelnoBck");
               System.out.println(tel);
               
               // ������ ���۹��� �̸��ϰ����� �޾ƿͼ� email ������ ����
               String email = request.getParameter("wrterEmailFrt") + "@" + request.getParameter("wrterEmailBck");
               
               String title = request.getParameter("title");	// ������ ���۹��� title(����)���� �޾ƿͼ� title ������ ����
               System.out.println("����: " + title);
               String details = request.getParameter("details");	// ������ ���۹��� details(����)���� �޾ƿͼ� details ������ ����
               
               // ���� �Ҹ� ������ ����ޱ����� ��ü ����
               ComplainBean complainBean = new ComplainBean(category, name, tel, email, title, details);
               ComplainDAO complainDao = ComplainDAO.getInstance();	// �̱������� ����� getInstance ȣ��
               complainDao.addComplain(complainBean, id);	// ���� �Ҹ� ����ϴ� �޼��� ȣ��
               
               ServletContext context = request.getServletContext();
               RequestDispatcher dispatcher = context.getRequestDispatcher(url);	//RequestDispatcher�� ���� url ��û ����(������ ���� �ִ� �� ���ø����̼� ���� �������� ��û ����)
               
               dispatcher.forward(request, response);	// ������ ��� �� ��ȯ
      }
}