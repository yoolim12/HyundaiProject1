//작업자 : 이승연
package DTO;

// 멤버(회원) 로그인시 필요한 값들을 저장해주는 객체
public class LoginBean {
	private String id;
	private String password;
	
	public LoginBean() {
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
