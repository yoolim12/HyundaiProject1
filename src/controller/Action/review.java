//�۾��� : �̽¿�
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

@WebServlet("/review")
public class review extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "/review.jsp"; //�Ѹ��� ȸ���� �ۼ��� ��� ���� ��ȸ�ϴ� jsp���Ϸ� �̵�
			    String id =request.getParameter("id");
			    
			    System.out.println(id);
			    reviewDAO dao = reviewDAO.getInstance(); //reviewDAO �� DB ����
			    
			    List review_list=dao.review_list(id);//id�� �ش��ϴ� ��� ���� ����Ʈ�� ��ȯ
				
			    
				
			    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			    request.setAttribute("review_list",review_list); //request��ü�� ���丮��Ʈ ��ȯ
			    dispatcher.forward(request, response); // ������ ��� �� ��ȯ
	}


	
}
