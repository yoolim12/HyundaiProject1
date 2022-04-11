package DTO;
import java.sql.Date;
//회원가입
public class UserBean {
	//private int userIndex;
	private String userID;
	private String userPassword1;
	private String userName;
	private String userBirth;
	private String userGender;
	private String userPH;
	private String userEmail;
	//private String file;
	private Date joinDate;
	
	/*
	 * public int getUserIndex() { return userIndex; } public void setUserIndex(int
	 * userIndex) { this.userIndex = userIndex; }
	 */
	public UserBean() {
		
	}
	public UserBean(String userID,    String userPassword1, String userName, 
					String userBirth, String userGender,    String userEmail, 
					String userPH) 
	{
		this.userID=userID; 
		this.userPassword1=userPassword1; 
		this.userName=userName;
		this.userGender=userGender; 
		this.userBirth=userBirth;
		this.userPH=userPH; 
		this.userEmail=userEmail;
		
	 
	}
	

	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPH() {
		return userPH;
	}
	public void setUserPH(String userPH) {
		this.userPH = userPH;
	}
	
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword1() {
		return userPassword1;
	}
	public void setUserPassword1(String userPassword1) {
		this.userPassword1 = userPassword1;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
