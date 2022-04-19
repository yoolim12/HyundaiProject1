// �ۼ��� : ������, �̽¿�

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

	// JDBC ����
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

	// �̱��� ���� ���
	private static ComplainDAO instance = new ComplainDAO();

	public static ComplainDAO getInstance() {
		return instance;
	}

	// ���� �Ҹ� ����ϴ� �޼���. 
	// ������ complainBean ��ü�� �����ߴ� ������ �޾ƿͼ� DB ���� review ���̺� �ۼ��ڰ� �Է��� ������ ����
	public void addComplain(ComplainBean complainBean, String session_id) {
		try {
			conn = dataFactory.getConnection();	// db �����Ͽ� �ۼ��ڰ� �Է��� ������ DB�� ����
			
			// �Ķ���ͷ� �޾ƿ� ���ǼҸ� ��ü�� getter
			int review_num = complainBean.getReview_num();	
			String category = complainBean.getCategory();
			String name = complainBean.getName();
			String tel = complainBean.getTel();
			String email = complainBean.getEmail();
			Date joindate = complainBean.getJoinDate();
			String title = complainBean.getTitle();
			String details = complainBean.getDetails();

			// �۾���: �̽¿�
			String function = " {?= call Review_pack.getNumfunc(?)}";	// ��Ű���� ����� fuction ��� (����� �ε��� �޾ƿ�)
			cstmt = conn.prepareCall(function);
			cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);	// ���ϰ��� Ÿ���� INTEGER�� ����
			cstmt.setString(2, session_id);	// �ι�° �Ķ���Ϳ� session_id ����
			cstmt.executeQuery();	// ���� ����� ����
			int member_num = cstmt.getInt(1);	// ��ȯ�� ���̺������� �÷�1�� �����͸� member_num�� ����
			String query = "{call Review_pack.review_insert(seq_review.NEXTVAL,?,?,?,?,sysdate,?,?,?)}";	// ��Ű���� ����� ���ν��� ��� (���� ����ϴ� ���ν���)
			System.out.println(query);
			cstmt = conn.prepareCall(query);	// ���ν��� ����� ������ ����־� callableStatement ��ü ����
			cstmt.setString(1, category);	// ù��° �Ķ���Ϳ� category ����
			cstmt.setString(2, name);	// �ι�° �Ķ���Ϳ� name ����
			cstmt.setString(3, tel);	// ����° �Ķ���Ϳ� tel ����
			cstmt.setString(4, email);	// �׹�° �Ķ���Ϳ� email ����
			cstmt.setString(5, title);	// �ټ���° �Ķ���Ϳ� title ����
			cstmt.setString(6, details);	// ������° �Ķ���Ϳ� details ����
			cstmt.setInt(7, member_num);	// 7��° �Ķ���Ϳ� member_num ����(member_num�� ���̺� Ȯ���غ��� ������Ÿ���� number�̹Ƿ� setInt�� ���ش�)

			cstmt.executeUpdate();	// ���� ���� ����
			cstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}