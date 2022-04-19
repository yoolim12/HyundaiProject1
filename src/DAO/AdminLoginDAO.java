//�۾��� : �̽¿�
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//�����ڷα���
public class AdminLoginDAO {
	private Connection con;
	private DataSource dataFactory;
	private CallableStatement cstmt;

	// JDBC ����
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

	// �̱��� ���� ���
	private static AdminLoginDAO instance = new AdminLoginDAO();

	public static AdminLoginDAO getInstance() {
		return instance;
	}

	// ������ �α����ϴ� �޼���
	// id�� password���� �Ķ���ͷ� �޾ƿ� ��Ű�� ���ν����� ����
	public int access(String id, String password) {

		try {
			con = dataFactory.getConnection();

			String query = "{call Master_pack.admin_login(?,?)}";	// ��Ű���� ����� ���ν��� ��� (����� �ۼ��� ���� ����)
			cstmt = con.prepareCall(query);	// ���ν��� ����� ������ ����־� callableStatement ��ü ����
			System.out.println(query);
			cstmt.setString(1, id);	// ù��° �Ķ���Ϳ� id�� ����
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);	// �ι�° �Ķ����(out parameter)Ŀ�� ���� 
			System.out.println(cstmt);
			cstmt.executeQuery();	// ���� ���� ����
			System.out.println(cstmt.getObject(2));
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			// ���� ������ ���� ���� password���� �Ķ���ͷ� ���޵� password�� ��ġ�ϸ� return 1(����) �ƴϸ� 0(password�� �ȸ���) �� �ܴ̿� -1(����)
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
		return -2; // ����
	}

}
