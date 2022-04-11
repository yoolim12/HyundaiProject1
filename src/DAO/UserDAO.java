package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import DTO.*;
import java.util.*;
import java.sql.Date;

//회원가입
public class UserDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	private UserDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println(" JDBC Data Sources JNDI Resource Factory");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
	    return instance;
	 }
	
	public List listMembers() {
	      List list = new ArrayList();
	      try {
	         con = dataFactory.getConnection();
	         String query = "select * from emp order by joinDate desc ";
	         System.out.println("prepareStatememt: " + query);
	         pstmt = con.prepareStatement(query);
	         ResultSet rs = pstmt.executeQuery();
	         while (rs.next()) {
	            String id = rs.getString("userId");
	            String pwd = rs.getString("userpassWord1");
	            String name = rs.getString("userName");
	            String birth= rs.getString("userBirth");
	            String email = rs.getString("userEmail");
	            String ph=rs.getString("userPH");
	            String gender=rs.getString("userGender");
	            Date joinDate = rs.getDate("joinDate");
	            UserBean user = new UserBean();
	            user.setUserID(id);
	            user.setUserPassword1(pwd);
	            user.setUserName(name);
	            user.setUserBirth(birth);
	            user.setUserEmail(email);
	            user.setUserGender(gender);
	            user.setUserPH(ph);
	            user.setJoinDate(joinDate);
	            list.add(user);
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return list;
	   }

	
	
	
	
	
		
	public void addMember(UserBean userBean) { 
		try { 
			Connection con = dataFactory.getConnection(); 
			  String id = userBean.getUserID(); 
			  String pwd =userBean.getUserPassword1(); 
			  String name = userBean.getUserName(); 
			  String email = userBean.getUserEmail(); 
			  String birth=userBean.getUserBirth();
			  String ph=userBean.getUserPH();
			  String gender=userBean.getUserGender();
			  
			  
			  String query = "insert into emp"; 
			  query+= " (userId,userPassword1,userName,userBirth,userGender,userEmail,userPH,joindate)";
			  query += " values(?,?,?,?,?,?,?,sysdate)";
			  System.out.println("prepareStatememt: " + query); 
			  
			  pstmt =con.prepareStatement(query); 
			  pstmt.setString(1, id); 
			  pstmt.setString(2, pwd);
			  pstmt.setString(3, name); 
			  pstmt.setString(4, birth);
			  pstmt.setString(5, gender);
			  pstmt.setString(6, email);
			  pstmt.setString(7, ph);
			  
			  pstmt.executeUpdate();
			  pstmt.close(); 
			  } 
		
		catch (Exception e) { e.printStackTrace(); } 
	}
		 

//	public int access(String userID, String userPassWord1) {
//		
//		try {
//			Connection con = dataFactory.getConnection(); 
//			String query="select * from emp where userID=?";
//			pstmt=con.prepareStatement(query);
//			pstmt.setString(1, userID);
//			
//			ResultSet rs=pstmt.executeQuery();
//			if(rs.next()) {
//				if(rs.getString(1).equals(userPassWord1)) {
//					return 1;
//				}
//				else
//					return 0;
//			}
//			return -1;
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -2; //오류
//	}
	
	//DML저장프로시저(회원테이블)
	//select, 자기자신정보조회 
	//insert, 회원가입
	//update, 회원정보수정
	//delete, 회언탈퇴
	
	
	//DML저장프로시저(게시판)
	//select, 게시판 정보 조회
	//insert, 게시판 글쓰기
	//update, 게시판 글수정
	//delete, 게시판 글삭제
	
	
	
	
	
}
