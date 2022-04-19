// 작업자: 이승연, 신동근
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

//회원가입
//작업자 : 이승연
public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private CallableStatement cstmt;
	private DataSource dataFactory;

	private MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			System.out.println(" JDBC Data Sources JNDI Resource Factory");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 싱글턴 패턴 이용
	// 
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	//작업자 : 이승연
	public List listMembers() { //회원정보 조회하는 함수, memberbean에 담아서 한 회원씩 리스트에 삽입
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from member order by joinDate desc ";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int member_num = rs.getInt("member_num");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				int gender = rs.getInt("gender");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberBean memberBean = new MemberBean();
				memberBean.setMember_num(member_num);
				memberBean.setId(id);
				memberBean.setPassword(password);
				memberBean.setName(name);
				memberBean.setBirth(birth);
				memberBean.setGender(gender);
				memberBean.setTel(tel);
				memberBean.setEmail(email);
				memberBean.setJoinDate(joinDate);
				list.add(memberBean);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//작업자 : 이승연
	public List listMembers2(String id) { // 특정 회원id 입력하면 필터링을 거쳐서 하나의 행을 반환한다.
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "{call Member_pack.member_check(?,?)}"; //커서를 사용하여 프로시저 생성
			System.out.println("CallableStatement: " + query);
			cstmt = con.prepareCall(query);
			cstmt.setString(1, id); //첫번째 파라미터 세팅
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);//out으로 선언한 커서 세팅
			cstmt.executeQuery();
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			if (rs.next()) {
				int member_num = rs.getInt("member_num");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				int gender = rs.getInt("gender");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberBean member = new MemberBean();
				member.setMember_num(member_num);
				member.setId(id);
				;
				member.setPassword(password);
				member.setName(name);
				member.setBirth(birth);
				member.setGender(gender);
				member.setTel(tel);
				member.setEmail(email);
				;
				member.setJoinDate(joinDate);
				list.add(member);
			}
			rs.close();
			cstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//작업자 : 이승연
	public void addMember(MemberBean memberBean) { // 회원가입
		try {
			Connection con = dataFactory.getConnection();

			String id = memberBean.getId();
			String password = memberBean.getPassword();
			String name = memberBean.getName();
			String birth = memberBean.getBirth();
			int gender = memberBean.getGender();
			String tel = memberBean.getTel();
			String email = memberBean.getEmail();

			
			//member_insert 프로시저 작성 (회원가입 시)
			String query = "{call Member_pack.member_insert(seq_member.NEXTVAL,?,?,?,?,?,?,?,sysdate)}";
			System.out.println("CallableStatement: " + query);
			cstmt = con.prepareCall(query);
			cstmt.setString(1, id);
			cstmt.setString(2, password);
			cstmt.setString(3, name);
			cstmt.setString(4, birth);
			cstmt.setInt(5, gender);
			cstmt.setString(6, tel);
			cstmt.setString(7, email);

			cstmt.executeUpdate();
			cstmt.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 작업자: 신동근
	// 아이디를 이용해 현재 회원정보를 가져오는 메서드
	public List selectMember(String session_id) {
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			con = dataFactory.getConnection();	// db 연결
			String query = "{call Member_pack.select_member(?, ?)}";	// 패키지에 저장된 프로시저 호출 (회원정보 가져오는 프로시저)
			System.out.println("selectMember() 호출됨");
			System.out.println("CallableStatement: " + query);
			cstmt = con.prepareCall(query);	// 프로시저 사용한 쿼리를 집어넣어 callableStatement 개체 만듬
			cstmt.setString(1, session_id);	// 첫번째 파라미터에 session_id 적용
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);	// 두번째 파라미터(out parameter)커서 적용 
			cstmt.executeQuery();	// 위에 내용들 적용
			ResultSet rs = (ResultSet) cstmt.getObject(2);	
			
			// 받아온 데이터들이 다 나올때까지 반복(null이 될때까지)
			while (rs.next()) {
				// 데이터값들을 각 변수에 저장
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				int gender = rs.getInt("gender");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				// System.out.println(name);
				// Date joinDate = rs.getDate("joinDate");
				
				// 패키지 프로시저 호출을 통해 받아온 값들을 MemberBean 객체에 저장
				MemberBean memberbean = new MemberBean();
				memberbean.setId(id);
				memberbean.setPassword(password);
				memberbean.setName(name);
				memberbean.setBirth(birth);
				memberbean.setGender(gender);
				memberbean.setTel(tel);
				memberbean.setEmail(email);
				list.add(memberbean);
			}
			rs.close();
			cstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 작업자 : 신동근, MemberBean객체를 이용해 현재 회원정보를 수정하는 메서드
	public void updateMember(MemberBean memberBean) {
		try {
			Connection con = dataFactory.getConnection();	// db 연결
			String id = memberBean.getId();	// MemberBean 객체를 통해 id값 받아옴
			String password = memberBean.getPassword();	// MemberBean 객체를 통해 password값 받아옴
			String email = memberBean.getEmail();	// MemberBean 객체를 통해 email값 받아옴
			String tel = memberBean.getTel();	// MemberBean 객체를 통해 tel값 받아옴
			int gender = memberBean.getGender();	// MemberBean 객체를 통해 gender값 받아옴

			String query = "{call Member_pack.update_member(?, ?, ?, ?, ?)}";	// 패키지에 저장된 프로시저 호출(위의 받아온 값들로 회원정보 수정하는 프로시저)
			System.out.println("updateMember() 호출됨");
			System.out.println("CallableStatement: " + query);
			cstmt = con.prepareCall(query);	// 프로시저 사용한 쿼리를 집어넣어 callableStatement 개체 만듬
			cstmt.setString(1, password);	// 첫번째 파라미터에 password 적용
			cstmt.setString(2, email);		// 두번째 파라미터에 email 적용
			cstmt.setString(3, tel);		// 세번째 파라미터에 tel 적용
			cstmt.setInt(4, gender);		// 네번째 파라미터에 gender 적용
			cstmt.setString(5, id);			// 다섯번째 파라미터에 id 적용
			cstmt.executeUpdate();			// 위의 내용들 실행

			// System.out.println(pstmt.toString());
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 작업자 :신동근, 회원정보를 삭제하는 메서드
	public void deleteMember(String id) {
		try {
			// 외래키를 통해 멤버가 쓴 리뷰들 다 삭제하는 패키지 프로시저
			Connection con = dataFactory.getConnection();	// db 연결
			String query = "{call Member_pack.delete_reviewWrite_member(?)}";	// 패키지에 저장된 프로시저 호출(id값을 통해 멤버가 쓴 리뷰 삭제)
			System.out.println("CallableStatement1: " + query);
			cstmt = con.prepareCall(query);	// 프로시저 사용한 쿼리를 집어넣어 callableStatement 개체 만듬
			cstmt.setString(1, id);	// 첫번째 파라미터에 id값 적용
			cstmt.executeUpdate();	// 위에 내용 적용

			// 외래키로 지정된 리뷰들을 다 삭제하였으므로 제약조건 위배 X -> 멤버 삭제
			query = "{call Member_pack.delete_member(?)}";	// 패키지에 저장된 프로시저 호출(id값을 통해 멤버 삭제)
			System.out.println("CallableStatement2: " + query);
			cstmt = con.prepareCall(query);	// 프로시저 사용한 쿼리를 집어넣어 callableStatement 개체 만듬
			cstmt.setString(1, id);	// 첫번째 파라미터에 id값 적용
			cstmt.executeUpdate();	// 위에 내용 적용

			cstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
