//작업자 : 신동근, 이승연
package DTO;
import java.sql.Date;
// 회원가입시 필요한 값들을 저장해주는 객체
public class MemberBean {
	//private int userIndex;
	private int member_num;	// 인덱스 
	private String id;	
	private String password;
	private String name;
	private String birth;
	private int gender;
	private String tel;
	private String email;
	private Date joinDate;
	
	/*
	 * public int getUserIndex() { return userIndex; } public void setUserIndex(int
	 * userIndex) { this.userIndex = userIndex; }
	 */
	public MemberBean() {
		
	}
	public MemberBean(String id,    String password, String name, 
					String birth, int gender,    String tel, 
					String email) 
	{
		this.id=id; 
		this.password=password; 
		this.name=name;
		this.birth=birth; 
		this.gender=gender;
		this.tel=tel; 
		this.email=email;
		
	 
	}
	
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	


}
