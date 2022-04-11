package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


//로그인
public class loginDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	private loginDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println(" JDBC Data Sources JNDI Resource Factory");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static loginDAO instance = new loginDAO();
	
	public static loginDAO getInstance() {
	    return instance;
	 }
	
	public int access(String userID, String userPassWord1) {
			
			try {
				con = dataFactory.getConnection(); 
				String query="select * from emp where userID=?";
				
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, userID);
				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString(2).equals(userPassWord1)) {
						return 1;
					}
					else
						return 0;
				}
				return -1;
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return -2; //오류
		}

}
