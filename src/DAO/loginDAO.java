//작업자 : 이승연
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//로그인
public class LoginDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	private CallableStatement cstmt;

	// JDBC 연동
	private LoginDAO() {
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
	private static LoginDAO instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return instance;
	}

	// 테이블에 맞는 멤버(회원)이 있는지 확인한뒤 그에 맞는 로그인 시도를 하는 메서드
	public int access(String id, String password) {

		try {
			con = dataFactory.getConnection();	// db 연결

			/*
			 * String query="select * from member where id=?";
			 * pstmt=con.prepareStatement(query); pstmt.setString(1, id);
			 */

			String query = "{call Member_pack.member_login(?,?)}";	// 패키지에 저장된 프로시저 호출(id값을 통해 회원정보를 가져오는 프로시저)
			cstmt = con.prepareCall(query);
			System.out.println(query);
			cstmt.setString(1, id);	// 첫번째 파라미터에 id 적용
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);	// 두번째 파라미터(out parameter)커서 적용 
			System.out.println(cstmt);
			cstmt.executeQuery();	// 위에 내용 적용
			System.out.println(cstmt.getObject(2));
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			System.out.println(rs);
			// 위의 쿼리를 통해 받은 password값이 파라미터로 전달된 password와 일치하면 return 1(정상) 아니면 0(password값 안맞음) 그 이외는 -1(오류)
			if (rs.next()) {
				if (rs.getString("password").equals(password)) {
					return 1;
				} else
					return 0;
			}
			return -1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 오류
	}

}