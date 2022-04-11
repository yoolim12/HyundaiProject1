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


//·Î±×ÀÎ
public class reviewDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	private reviewDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println(" JDBC Data Sources JNDI Resource Factory");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static reviewDAO instance = new reviewDAO();
	
	public static reviewDAO getInstance() {
	    return instance;
	 }
	
	
	
	public List review_list(String id) {
	      List list = new ArrayList();
	      try {
	         con = dataFactory.getConnection();
	         
	         String query = "select * from review where id=? ";
	         System.out.println("prepareStatememt: " + query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, id);
	         ResultSet rs = pstmt.executeQuery();
	         while (rs.next()) {
	      
	            String category = rs.getString("category");
	            String num = rs.getString("review_num");
	            String title=rs.getString("title");
	            String content = rs.getString("content");
	            String name= rs.getString("name");
	            String ph=rs.getString("ph");
	            String email = rs.getString("email");
	            Date joinDate=rs.getDate("joinDate");
	            
	            reviewBean reviewbean=new reviewBean();
	            reviewbean.setId(id);
	            reviewbean.setReview_num(num);
	            reviewbean.setName(name);
	            reviewbean.setCategory(category);
	            reviewbean.setContent(content);
	            reviewbean.setReview_num(email);
	            reviewbean.setPh(ph);
	            reviewbean.setEmail(email);
	            reviewbean.setTitle(title);
	            reviewbean.setJoinDate(joinDate);
	            list.add(reviewbean);
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return list;
	
	}
}
