// �۾���: �ŵ���
package controller.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sub2_First implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/menu/sub2_first.jsp";  // Ǫ�� ����ȭ�� �̵�
	    
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url); // RequestDispatcher�� ���� url ��û ����(������ ���� �ִ� �� ���ø����̼� ���� �������� ��û ����)
	    dispatcher.forward(request, response);	// ������ ��� �� ��ȯ

	}

}
