// �۾���: ������
package controller.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sub3_First implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/menu/sub3_first.jsp";  // ���� �ý��� ȭ�� �̵�
	    
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url);	// RequestDispatcher�� ���� url ��û ����(������ ���� �ִ� �� ���ø����̼� ���� �������� ��û ����)
	    dispatcher.forward(request, response);	// ������ ��� �� ��ȯ
	}

}
