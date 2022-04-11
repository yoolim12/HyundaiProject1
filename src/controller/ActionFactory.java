package controller;
import controller.Action.*;
public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() { //private���� ���������ν� �ܺο��� �Ժη� �����ڸ� ȣ���� �� ����.
	}
	
	
	public static ActionFactory getInstance() {
	    return instance; 
	} // ActionFactory �ν��Ͻ��� ��ȯ
	


	public Action getAction(String command) {
		Action action=null;
		System.out.println("ActionFactory  :" + command);
		
		if (command.equals("green_food")) {
			action = new companyIntro();
		}
		else if(command.equals("login1")) {//ȸ������ Ŀ�ǵ�
			action=new register1();
		}
		else if(command.equals("login2")){ // �α��� Ŀ�ǵ�
			action=new register2();
		}
		else if(command.equals("board")){ //�Խ��� Ŀ�ǵ�
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
