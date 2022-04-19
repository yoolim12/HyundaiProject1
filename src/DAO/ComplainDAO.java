// 작성자 : 최유림, 이승연

package DAO;

import DTO.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ComplainDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	private CallableStatement cstmt;

	// JDBC 연동
	public ComplainDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println(" JDBC Data Sources JNDI Resource Factory");
			// dataFactory = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 싱글톤 패턴 사용
	private static ComplainDAO instance = new ComplainDAO();

	public static ComplainDAO getInstance() {
		return instance;
	}

	// 고객의 소리 등록하는 메서드. 
	// 이전에 complainBean 객체에 전달했던 값들을 받아와서 DB 내의 review 테이블에 작성자가 입력한 값들을 삽입
	public void addComplain(ComplainBean complainBean, String session_id) {
		try {
			conn = dataFactory.getConnection();	// db 연결하여 작성자가 입력한 값들을 DB에 삽입
			
			// 파라미터로 받아온 고객의소리 객체의 getter
			int review_num = complainBean.getReview_num();	
			String category = complainBean.getCategory();
			String name = complainBean.getName();
			String tel = complainBean.getTel();
			String email = complainBean.getEmail();
			Date joindate = complainBean.getJoinDate();
			String title = complainBean.getTitle();
			String details = complainBean.getDetails();

			// 작업자: 이승연
			String function = " {?= call Review_pack.getNumfunc(?)}";	// 패키지에 저장된 fuction 사용 (멤버의 인덱스 받아옴)
			cstmt = conn.prepareCall(function);
			cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);	// 리턴값의 타입은 INTEGER로 받음
			cstmt.setString(2, session_id);	// 두번째 파라미터에 session_id 적용
			cstmt.executeQuery();	// 위에 내용들 적용
			int member_num = cstmt.getInt(1);	// 반환된 테이블형태의 컬럼1의 데이터를 member_num에 적용
			String query = "{call Review_pack.review_insert(seq_review.NEXTVAL,?,?,?,?,sysdate,?,?,?)}";	// 패키지에 저장된 프로시저 사용 (리뷰 등록하는 프로시저)
			System.out.println(query);
			cstmt = conn.prepareCall(query);	// 프로시저 사용한 쿼리를 집어넣어 callableStatement 개체 만듬
			cstmt.setString(1, category);	// 첫번째 파라미터에 category 적용
			cstmt.setString(2, name);	// 두번째 파라미터에 name 적용
			cstmt.setString(3, tel);	// 세번째 파라미터에 tel 적용
			cstmt.setString(4, email);	// 네번째 파라미터에 email 적용
			cstmt.setString(5, title);	// 다섯번째 파라미터에 title 적용
			cstmt.setString(6, details);	// 여섯번째 파라미터에 details 적용
			cstmt.setInt(7, member_num);	// 7번째 파라미터에 member_num 적용(member_num은 테이블 확인해보면 데이터타입이 number이므로 setInt로 해준다)

			cstmt.executeUpdate();	// 위에 내용 적용
			cstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}