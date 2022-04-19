//�۾��� : �̽¿�
package controller.Action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;

// /DeleteMemberServlet���� ������̼�
@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/delete/DeleteMember.jsp"; 
			    
			    

			    HttpSession session=request.getSession();	//���ǰ� �޾ƿ���
	           
	            String id=(String)session.getAttribute("id"); //�α��� �Ҷ� id�� �Ҵ�� ���� �� ��������
				
				System.out.println("�޾ƿ� ���� id ��: " + id); // ���� id�� Ȯ��
				MemberDAO memberDao=MemberDAO.getInstance(); //DB ���� ��ü ����
				memberDao.deleteMember(id);//MemberDAO.deleteMember�� ���� ȸ��Ż���ϱ�
				
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(url);	// RequestDispatcher�� ���� url ��û ����(������ ���� �ִ� �� ���ø����̼� ���� �������� ��û ����)
			    dispatcher.forward(request, response);	// ������ ��� �� ��ȯ
	}


	
}
