//작업자 : 이승연
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//관리자로그인
public class AdminLoginDAO {
	private Connection con;
	private DataSource dataFactory;
	private CallableStatement cstmt;

	// JDBC 연동
	private AdminLoginDAO() {
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
	private static AdminLoginDAO instance = new AdminLoginDAO();

	public static AdminLoginDAO getInstance() {
		return instance;
	}

	// 관리자 로그인하는 메서드
	// id와 password값을 파라미터로 받아와 패키지 프로시저에 적용
	public int access(String id, String password) {

		try {
			con = dataFactory.getConnection();

			String query = "{call Master_pack.admin_login(?,?)}";	// 패키지에 저장된 프로시저 사용 (멤버가 작성한 리뷰 삭제)
			cstmt = con.prepareCall(query);	// 프로시저 사용한 쿼리를 집어넣어 callableStatement 개체 만듬
			System.out.println(query);
			cstmt.setString(1, id);	// 첫번째 파라미터에 id값 적용
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);	// 두번째 파라미터(out parameter)커서 적용 
			System.out.println(cstmt);
			cstmt.executeQuery();	// 위에 내용 적용
			System.out.println(cstmt.getObject(2));
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			// 위의 쿼리를 통해 받은 password값이 파라미터로 전달된 password와 일치하면 return 1(정상) 아니면 0(password값 안맞음) 그 이외는 -1(오류)
			if (rs.next()) {
				if (rs.getString(3).equals(password)) {
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
