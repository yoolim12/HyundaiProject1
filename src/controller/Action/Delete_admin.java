//�۾��� : �̽¿�
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

// /Delete_admin���� ������̼�
@WebServlet("/Delete_admin")
public class Delete_admin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
		    	
			    String url = "/delete_admin.jsp"; // �����ڰ� ȸ���������� ��ư�� �������� alert�� ����ִ� â���� �̵�
			    
				String id=request.getParameter("delete_id"); 	// ������ ���۹��� delete_id���� �޾ƿͼ� id������ ����
				request.setAttribute("id",id);	
				Admin_deleteDAO delete=Admin_deleteDAO.getInstance();	// �̱������� ����� getInstance ȣ��
				delete.delete(id);	// Admin_deleteDAO Ŭ������ delete �޼��� ȣ��(ȸ�� ���� �����ϴ� �޼���)
				 
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(url);	// RequestDispatcher�� ���� url ��û ����(������ ���� �ִ� �� ���ø����̼� ���� �������� ��û ����)
			    dispatcher.forward(request, response);	// ������ ��� �� ��ȯ
				
				
	}


	
}
