//작업자 : 공동
package controller.Action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Action 인터페이스
public interface Action {
	public void execute(HttpServletRequest request,
			 HttpServletResponse response)
	            throws ServletException, IOException;
	

}
