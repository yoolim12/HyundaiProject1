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
		
		if (command.equals("green_food")) {
			action = new companyIntro();
		}
		else if(command.equals("login1")) {//회원가입 커맨드
			action=new register1();
		}
		else if(command.equals("login2")){ // 로그인 커맨드
			action=new register2();
		}
		else if(command.equals("board")){ //게시판 커맨드
			action=new board();
		}
		else if(command.equals("logout")) {
			action=new logout();
		}
		else if(command.equals("admin_login")) {
			action=new admin_login();
		}
		return action;
	}
}
