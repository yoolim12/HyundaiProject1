// 작성자 : 최유림

package DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBDAO {
	private DataSource dataFactory;
	private Connection conn;

	// JDBC 연동
	public DBDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
	public List<Integer> ReviewCountList() throws SQLException {
		conn = dataFactory.getConnection(); // DB와 연결
		System.out.println("Connection established......");
		List<Integer> list = new ArrayList<Integer>(); // 각 카테고리의 리뷰 개수를 담을 리스트 선언
		
		// pl/sql에서 작성한 category_count 함수 실행(각 카테고리 당 몇 개의 리뷰가 있는지 리턴하는 함수)
		CallableStatement cs = conn.prepareCall("{? = call category_count(?)}");
		cs.registerOutParameter(1, Types.INTEGER); // 첫 번째 물음표에 해당하는 값이 int 타입임을 선언
		
		// 각 카테고리 당 몇 개의 리뷰가 작성되어 있는지를 받아와서 list에 추가
		cs.setString(2, "칭찬"); // 두 번째 물음표에 "칭찬"을 세팅하여 칭찬 카테고리에 대한 리뷰 개수를 받아온다.
		cs.execute(); // 쿼리 실행
		list.add(cs.getInt(1)); // 리턴 받은 칭찬 카테고리 리뷰 개수를 리스트에 추가
		
		cs.setString(2, "불만"); // 두 번째 물음표에 "불만"을 세팅하여 불만 카테고리에 대한 리뷰 개수를 받아온다.
		cs.execute(); // 쿼리 실행
		list.add(cs.getInt(1)); // 리턴 받은 불만 카테고리 리뷰 개수를 리스트에 추가
		
		cs.setString(2, "제안"); // 두 번째 물음표에 "제안"을 세팅하여 제안 카테고리에 대한 리뷰 개수를 받아온다.
		cs.execute(); // 쿼리 실행
		list.add(cs.getInt(1)); // 리턴 받은 제안 카테고리 리뷰 개수를 리스트에 추가
		
		cs.setString(2, "기타"); // 두 번째 물음표에 "기타"를 세팅하여 기타 카테고리에 대한 리뷰 개수를 받아온다.
		cs.execute(); // 쿼리 실행
		list.add(cs.getInt(1)); // 리턴 받은 기타 카테고리 리뷰 개수를 리스트에 추가
		
		// connection 해제
		cs.close();
		conn.close();
		return list;
	}
}