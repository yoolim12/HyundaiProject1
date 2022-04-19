//작업자 : 이승연
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import DTO.*;
import java.util.*;
import java.sql.Date;

//로그인
public class reviewDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	private CallableStatement cstmt;

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

	
	//리뷰 리스트 반환하는 함수
	public List review_list(String id) {
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();

			String query = "{call Master_pack.review_list(?,?)}";//커서 사용하여 프로시저 생성
			System.out.println("CallableStatememt: " + query);
			cstmt = con.prepareCall(query);
			cstmt.setString(1, id);//id 세팅
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);//out으로 되어 있는 커서 세팅
			cstmt.executeQuery();
			ResultSet rs = (ResultSet) cstmt.getObject(2);//형변환
			
			while (rs.next()) {

				String category = rs.getString("category");
				int num = rs.getInt("review_num");
				String title = rs.getString("title");
				String details = rs.getString("details");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				reviewBean reviewbean = new reviewBean(); //Bean 생성 후 객체담기
				reviewbean.setReview_num(num);
				reviewbean.setName(name);
				reviewbean.setCategory(category);
				reviewbean.setDetails(details);
				;
				reviewbean.setTel(tel);
				;
				reviewbean.setEmail(email);
				reviewbean.setTitle(title);
				reviewbean.setJoinDate(joinDate);
				list.add(reviewbean); //리스트에 추가
			}
			rs.close();
			cstmt.close();
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List detail(String num) {
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "{call Review_pack.review_detail(?,?)}";//커서 사용하여 프로시저 작성, 리뷰 자세히 보기
			System.out.println("CallableStatememt: " + query);
			cstmt = con.prepareCall(query);
			cstmt.setString(1, num);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			;

			if (rs.next()) {
				int review_num = rs.getInt("review_num");
				String category = rs.getString("category");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				String title = rs.getString("title");
				String details = rs.getString("details");

				reviewBean reviewbean = new reviewBean();
				reviewbean.setReview_num(review_num);
				reviewbean.setCategory(category);
				reviewbean.setName(name);
				reviewbean.setTel(tel);
				reviewbean.setEmail(email);
				reviewbean.setJoinDate(joinDate);
				reviewbean.setTitle(title);
				reviewbean.setDetails(details);
				list.add(reviewbean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}