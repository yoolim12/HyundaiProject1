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

// /AdminLoginServlet���� ������̼�
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// Post����� �޼���
	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/login/AdminLoginConfirm.jsp"; //DB�����ϴ� �α��� ���� jsp �� �̵�
			    
			    

				String id=request.getParameter("id"); 	// form�� ���ؼ� ���޹��� id�� ����(������ id)
				String password=request.getParameter("password");	// form�� ���ؼ� ���޹��� password�� ����(������ password)
				request.setAttribute("id",id);	// ���޹��� id���� request�� ���� id�� ����(request�� ������ id Ű����� ������ ���޹��� id���� �����ִ�)
				request.setAttribute("password", password);	// ���޹��� password���� request�� ���� password�� ����(request�� ������ password Ű����� ������ ���޹��� password���� �����ִ�)
				
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(url);	//RequestDispatcher�� ���� url ��û ����(������ ���� �ִ� �� ���ø����̼� ���� �������� ��û ����
			    dispatcher.forward(request, response);	// ������ ��� �� ��ȯ
	}


	
}
