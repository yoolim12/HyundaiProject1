package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


//관리자로그인
public class admin_loginDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	private admin_loginDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println(" JDBC Data Sources JNDI Resource Factory");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static admin_loginDAO instance = new admin_loginDAO();
	
	public static admin_loginDAO getInstance() {
	    return instance;
	 }
	
	public int access(String masterID, String masterPassWord1) {
			
			try {
				con = dataFactory.getConnection(); 
				String query="select * from master where masterID=?";
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, masterID);
				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString(2).equals(masterPassWord1)) {
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

