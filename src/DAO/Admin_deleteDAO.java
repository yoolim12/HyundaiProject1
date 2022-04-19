//작성자 : 이승연, 신동근
//이승연 : DB프로시저 자바에 삽입 (cstmt 추가, 전체 틀 완성)
//신동근 : 프로시저 2개 작성

package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Admin_deleteDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	private CallableStatement cstmt;

	// JDBC 연동
	private Admin_deleteDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println(" JDBC Data Sources JNDI Resource Factory");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 싱글톤 패턴 사용
	private static Admin_deleteDAO instance = new Admin_deleteDAO();

	public static Admin_deleteDAO getInstance() {
		return instance;
	}

	// 관리자페이지에서 멤버를 삭제하는 메서드
	// 먼저 멤버가 작성한 리뷰들을 삭제한 뒤
	// 멤버를 삭제한다
	public void delete(String id) {
		try {
			Connection con = dataFactory.getConnection();	// db 연결
			String query1 = "{call Member_pack.delete_reviewWrite_member(?)}";	// 패키지에 저장된 프로시저 사용 (멤버가 작성한 리뷰 삭제)
			System.out.println("CallableStatememt: " + query1);
			cstmt = con.prepareCall(query1);	// 프로시저 사용한 쿼리를 집어넣어 callableStatement 개체 만듬
			cstmt.setString(1, id);				// 파라미터값에 id 적용
			cstmt.executeUpdate();				// 위에 내용 적용

			String query2 = "{call Member_pack.delete_member(?)}";	// 패키지에 저장된 프로시저 사용 (멤버 삭제)
			System.out.println("CallableStatememt: " + query2);
			cstmt = con.prepareCall(query2);	// 프로시저 사용한 쿼리를 집어넣어 callableStatement 개체 만듬
			cstmt.setString(1, id);	// 파라미터값에 id 적용
			cstmt.executeUpdate();	// 위에 내용 적용
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}