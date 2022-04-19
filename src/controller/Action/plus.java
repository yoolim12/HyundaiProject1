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

// /plus�� ������̼�
@WebServlet("/plus")
public class plus extends HttpServlet {
   
   private static final long serialVersionUID = 1L;


   protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
             request.setCharacterEncoding("UTF-8");
             String url = "/plus.jsp"; //���� �� ��ȸ �ϴ� jsp���Ϸ� �̵�
             
             String num=request.getParameter("num");	// ������ ���۹��� num���� �޾ƿͼ� num������ ����
             System.out.println(num);
             reviewDAO dao = reviewDAO.getInstance();	// �̱������� ����� getInstance ȣ��
             
             List plus_list=dao.detail(num);	// ���並 ���ϰ� �����ִ� �޼��� ȣ��
            
             
            
             RequestDispatcher dispatcher=request.getRequestDispatcher(url);	//RequestDispatcher�� ���� url ��û ����(������ ���� �ִ� �� ���ø����̼� ���� �������� ��û ����
             request.setAttribute("plus_list", plus_list);	// ���޹��� plus_list���� request�� ���� plus_list�� ����(request�� ������ plus_list Ű����� ������ ���޹��� password���� �����ִ�)
             dispatcher.forward(request, response);	// ������ ��� �� ��ȯ
   }


   
}