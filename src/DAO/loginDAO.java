//�۾��� : �̽¿�
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//�α���
public class LoginDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	private CallableStatement cstmt;

	// JDBC ����
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

	// �̱��� ���� ���
	private static LoginDAO instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return instance;
	}

	// ���̺� �´� ���(ȸ��)�� �ִ��� Ȯ���ѵ� �׿� �´� �α��� �õ��� �ϴ� �޼���
	public int access(String id, String password) {

		try {
			con = dataFactory.getConnection();	// db ����

			/*
			 * String query="select * from member where id=?";
			 * pstmt=con.prepareStatement(query); pstmt.setString(1, id);
			 */

			String query = "{call Member_pack.member_login(?,?)}";	// ��Ű���� ����� ���ν��� ȣ��(id���� ���� ȸ�������� �������� ���ν���)
			cstmt = con.prepareCall(query);
			System.out.println(query);
			cstmt.setString(1, id);	// ù��° �Ķ���Ϳ� id ����
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);	// �ι�° �Ķ����(out parameter)Ŀ�� ���� 
			System.out.println(cstmt);
			cstmt.executeQuery();	// ���� ���� ����
			System.out.println(cstmt.getObject(2));
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			System.out.println(rs);
			// ���� ������ ���� ���� password���� �Ķ���ͷ� ���޵� password�� ��ġ�ϸ� return 1(����) �ƴϸ� 0(password�� �ȸ���) �� �ܴ̿� -1(����)
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
		return -2; // ����
	}

}