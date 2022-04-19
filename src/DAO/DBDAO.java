// �ۼ��� : ������

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

	// JDBC ����
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
		conn = dataFactory.getConnection(); // DB�� ����
		System.out.println("Connection established......");
		List<Integer> list = new ArrayList<Integer>(); // �� ī�װ��� ���� ������ ���� ����Ʈ ����
		
		// pl/sql���� �ۼ��� category_count �Լ� ����(�� ī�װ� �� �� ���� ���䰡 �ִ��� �����ϴ� �Լ�)
		CallableStatement cs = conn.prepareCall("{? = call category_count(?)}");
		cs.registerOutParameter(1, Types.INTEGER); // ù ��° ����ǥ�� �ش��ϴ� ���� int Ÿ������ ����
		
		// �� ī�װ� �� �� ���� ���䰡 �ۼ��Ǿ� �ִ����� �޾ƿͼ� list�� �߰�
		cs.setString(2, "Ī��"); // �� ��° ����ǥ�� "Ī��"�� �����Ͽ� Ī�� ī�װ��� ���� ���� ������ �޾ƿ´�.
		cs.execute(); // ���� ����
		list.add(cs.getInt(1)); // ���� ���� Ī�� ī�װ� ���� ������ ����Ʈ�� �߰�
		
		cs.setString(2, "�Ҹ�"); // �� ��° ����ǥ�� "�Ҹ�"�� �����Ͽ� �Ҹ� ī�װ��� ���� ���� ������ �޾ƿ´�.
		cs.execute(); // ���� ����
		list.add(cs.getInt(1)); // ���� ���� �Ҹ� ī�װ� ���� ������ ����Ʈ�� �߰�
		
		cs.setString(2, "����"); // �� ��° ����ǥ�� "����"�� �����Ͽ� ���� ī�װ��� ���� ���� ������ �޾ƿ´�.
		cs.execute(); // ���� ����
		list.add(cs.getInt(1)); // ���� ���� ���� ī�װ� ���� ������ ����Ʈ�� �߰�
		
		cs.setString(2, "��Ÿ"); // �� ��° ����ǥ�� "��Ÿ"�� �����Ͽ� ��Ÿ ī�װ��� ���� ���� ������ �޾ƿ´�.
		cs.execute(); // ���� ����
		list.add(cs.getInt(1)); // ���� ���� ��Ÿ ī�װ� ���� ������ ����Ʈ�� �߰�
		
		// connection ����
		cs.close();
		conn.close();
		return list;
	}
}