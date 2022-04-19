//작업자 : 공동

package controller;
import controller.Action.*;
public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() { //private으로 설정함으로써 외부에서 함부로 생성자를 호출할 수 없다.
	}
	
	
	public static ActionFactory getInstance() {
	    return instance; 
	} // ActionFactory 인스턴스를 반환
	


	public Action getAction(String command) {
		Action action=null;
		System.out.println("ActionFactory  :" + command);
		
		if (command.equals("green_food")) {			// 회사소개 커맨드
			action = new companyIntro();
		}
		else if(command.equals("Sub2_First")) {		// 푸드서비스사업 커맨드
			action = new Sub2_First();
		}
		else if(command.equals("Sub2_Second")) {	// 외식사업 커맨드
			action = new Sub2_Second();
		}
		else if(command.equals("Sub3_First")) {		// 물류시스템 커맨드
			action = new Sub3_First();
		}
		else if(command.equals("Sub3_Second")) {	// 식품안전시스템 커맨드
			action = new Sub3_Second();
		}
		else if(command.equals("Sub4_First")) {	// 브랜드이야기 커맨드
			action = new Sub4_First();
		}
		else if(command.equals("Complain")) {	// 고객의 소리 커맨드(회원 로그인시 폼 화면 나옴)
			action = new Complain();
		}
		else if(command.equals("MemberJoin")) {//회원가입 커맨드
			action=new MemberJoin();
		}
		else if(command.equals("Login")){ // 로그인 커맨드
			action=new Login();
		}
		else if(command.equals("Logout")) { //로그아웃 커맨드
			action=new Logout();
		}
		else if(command.equals("Modify")) {	// 회원수정 커맨드
			action=new Modify();
		}
		else if(command.equals("AdminLogin")) { // 관리자 로그인 커맨드
			action=new AdminLogin();
		}
		return action;
	}
}
