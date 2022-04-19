//�۾��� : ����

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
		
		if (command.equals("green_food")) {			// ȸ��Ұ� Ŀ�ǵ�
			action = new companyIntro();
		}
		else if(command.equals("Sub2_First")) {		// Ǫ�弭�񽺻�� Ŀ�ǵ�
			action = new Sub2_First();
		}
		else if(command.equals("Sub2_Second")) {	// �ܽĻ�� Ŀ�ǵ�
			action = new Sub2_Second();
		}
		else if(command.equals("Sub3_First")) {		// �����ý��� Ŀ�ǵ�
			action = new Sub3_First();
		}
		else if(command.equals("Sub3_Second")) {	// ��ǰ�����ý��� Ŀ�ǵ�
			action = new Sub3_Second();
		}
		else if(command.equals("Sub4_First")) {	// �귣���̾߱� Ŀ�ǵ�
			action = new Sub4_First();
		}
		else if(command.equals("Complain")) {	// ���� �Ҹ� Ŀ�ǵ�(ȸ�� �α��ν� �� ȭ�� ����)
			action = new Complain();
		}
		else if(command.equals("MemberJoin")) {//ȸ������ Ŀ�ǵ�
			action=new MemberJoin();
		}
		else if(command.equals("Login")){ // �α��� Ŀ�ǵ�
			action=new Login();
		}
		else if(command.equals("Logout")) { //�α׾ƿ� Ŀ�ǵ�
			action=new Logout();
		}
		else if(command.equals("Modify")) {	// ȸ������ Ŀ�ǵ�
			action=new Modify();
		}
		else if(command.equals("AdminLogin")) { // ������ �α��� Ŀ�ǵ�
			action=new AdminLogin();
		}
		return action;
	}
}
