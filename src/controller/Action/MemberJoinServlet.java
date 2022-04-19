//�۾��� : �̽¿�, �ŵ���
package controller.Action;

import java.io.IOException;


import DAO.*;
import DTO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// /MemberJoinServlet���� ������̼�
@WebServlet("/MemberJoinServlet")

//DAO�� addMember�� ���� DB�� ������ ���� (ȸ������)
public class MemberJoinServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    	request.setCharacterEncoding("UTF-8");
			    String url = "index.jsp";  //ȸ������ ��, ���� �������� �����Ѵ�. (�α��� �� ������)
			    
			   
	
				String id=request.getParameter("id");	// ������ ���۹��� id���� �޾ƿͼ� id������ ����
				String password=request.getParameter("password");	// ������ ���۹��� password���� �޾ƿͼ� password������ ����
				String name=request.getParameter("name");	// ������ ���۹��� password���� �޾ƿͼ� password������ ����
				String birth=request.getParameter("birth");	// ������ ���۹��� password���� �޾ƿͼ� password������ ����
				int gender=Integer.parseInt(request.getParameter("gender"));	// ������ ���۹��� gender���� �޾ƿͼ� gender������ ����(gender = 1 -> ����, 2 -> ����)
				String tel=request.getParameter("tel");	// ������ ���۹��� tel���� �޾ƿͼ� tel������ ����
				String email=request.getParameter("email");	// ������ ���۹��� email���� �޾ƿͼ� email������ ����
				
				// ���޹��������� ����ޱ����� ��� ��ü ����
				MemberBean memberBean=new MemberBean(id,password,name,birth,gender,tel, email);
				
				MemberDAO dao=MemberDAO.getInstance();	// �̱������� ����� getInstance ȣ��
				
				dao.addMember(memberBean);	// ������̺� ����� �����ϴ� �޼��� ȣ��
				
				
			    response.sendRedirect(url); //������ ��ü�� �����Ƿ�, sendRedirect ���

	}
}
