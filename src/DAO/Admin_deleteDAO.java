//�ۼ��� : �̽¿�, �ŵ���
//�̽¿� : DB���ν��� �ڹٿ� ���� (cstmt �߰�, ��ü Ʋ �ϼ�)
//�ŵ��� : ���ν��� 2�� �ۼ�

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

	// JDBC ����
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

	// �̱��� ���� ���
	private static Admin_deleteDAO instance = new Admin_deleteDAO();

	public static Admin_deleteDAO getInstance() {
		return instance;
	}

	// ���������������� ����� �����ϴ� �޼���
	// ���� ����� �ۼ��� ������� ������ ��
	// ����� �����Ѵ�
	public void delete(String id) {
		try {
			Connection con = dataFactory.getConnection();	// db ����
			String query1 = "{call Member_pack.delete_reviewWrite_member(?)}";	// ��Ű���� ����� ���ν��� ��� (����� �ۼ��� ���� ����)
			System.out.println("CallableStatememt: " + query1);
			cstmt = con.prepareCall(query1);	// ���ν��� ����� ������ ����־� callableStatement ��ü ����
			cstmt.setString(1, id);				// �Ķ���Ͱ��� id ����
			cstmt.executeUpdate();				// ���� ���� ����

			String query2 = "{call Member_pack.delete_member(?)}";	// ��Ű���� ����� ���ν��� ��� (��� ����)
			System.out.println("CallableStatememt: " + query2);
			cstmt = con.prepareCall(query2);	// ���ν��� ����� ������ ����־� callableStatement ��ü ����
			cstmt.setString(1, id);	// �Ķ���Ͱ��� id ����
			cstmt.executeUpdate();	// ���� ���� ����
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}