// �۾���: �̽¿�, �ŵ���
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

//ȸ������
//�۾��� : �̽¿�
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

	// �̱��� ���� �̿�
	// 
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	//�۾��� : �̽¿�
	public List listMembers() { //ȸ������ ��ȸ�ϴ� �Լ�, memberbean�� ��Ƽ� �� ȸ���� ����Ʈ�� ����
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

	//�۾��� : �̽¿�
	public List listMembers2(String id) { // Ư�� ȸ��id �Է��ϸ� ���͸��� ���ļ� �ϳ��� ���� ��ȯ�Ѵ�.
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "{call Member_pack.member_check(?,?)}"; //Ŀ���� ����Ͽ� ���ν��� ����
			System.out.println("CallableStatement: " + query);
			cstmt = con.prepareCall(query);
			cstmt.setString(1, id); //ù��° �Ķ���� ����
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);//out���� ������ Ŀ�� ����
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
	
	//�۾��� : �̽¿�
	public void addMember(MemberBean memberBean) { // ȸ������
		try {
			Connection con = dataFactory.getConnection();

			String id = memberBean.getId();
			String password = memberBean.getPassword();
			String name = memberBean.getName();
			String birth = memberBean.getBirth();
			int gender = memberBean.getGender();
			String tel = memberBean.getTel();
			String email = memberBean.getEmail();

			
			//member_insert ���ν��� �ۼ� (ȸ������ ��)
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

	// �۾���: �ŵ���
	// ���̵� �̿��� ���� ȸ�������� �������� �޼���
	public List selectMember(String session_id) {
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			con = dataFactory.getConnection();	// db ����
			String query = "{call Member_pack.select_member(?, ?)}";	// ��Ű���� ����� ���ν��� ȣ�� (ȸ������ �������� ���ν���)
			System.out.println("selectMember() ȣ���");
			System.out.println("CallableStatement: " + query);
			cstmt = con.prepareCall(query);	// ���ν��� ����� ������ ����־� callableStatement ��ü ����
			cstmt.setString(1, session_id);	// ù��° �Ķ���Ϳ� session_id ����
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);	// �ι�° �Ķ����(out parameter)Ŀ�� ���� 
			cstmt.executeQuery();	// ���� ����� ����
			ResultSet rs = (ResultSet) cstmt.getObject(2);	
			
			// �޾ƿ� �����͵��� �� ���ö����� �ݺ�(null�� �ɶ�����)
			while (rs.next()) {
				// �����Ͱ����� �� ������ ����
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				int gender = rs.getInt("gender");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				// System.out.println(name);
				// Date joinDate = rs.getDate("joinDate");
				
				// ��Ű�� ���ν��� ȣ���� ���� �޾ƿ� ������ MemberBean ��ü�� ����
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

	// �۾��� : �ŵ���, MemberBean��ü�� �̿��� ���� ȸ�������� �����ϴ� �޼���
	public void updateMember(MemberBean memberBean) {
		try {
			Connection con = dataFactory.getConnection();	// db ����
			String id = memberBean.getId();	// MemberBean ��ü�� ���� id�� �޾ƿ�
			String password = memberBean.getPassword();	// MemberBean ��ü�� ���� password�� �޾ƿ�
			String email = memberBean.getEmail();	// MemberBean ��ü�� ���� email�� �޾ƿ�
			String tel = memberBean.getTel();	// MemberBean ��ü�� ���� tel�� �޾ƿ�
			int gender = memberBean.getGender();	// MemberBean ��ü�� ���� gender�� �޾ƿ�

			String query = "{call Member_pack.update_member(?, ?, ?, ?, ?)}";	// ��Ű���� ����� ���ν��� ȣ��(���� �޾ƿ� ����� ȸ������ �����ϴ� ���ν���)
			System.out.println("updateMember() ȣ���");
			System.out.println("CallableStatement: " + query);
			cstmt = con.prepareCall(query);	// ���ν��� ����� ������ ����־� callableStatement ��ü ����
			cstmt.setString(1, password);	// ù��° �Ķ���Ϳ� password ����
			cstmt.setString(2, email);		// �ι�° �Ķ���Ϳ� email ����
			cstmt.setString(3, tel);		// ����° �Ķ���Ϳ� tel ����
			cstmt.setInt(4, gender);		// �׹�° �Ķ���Ϳ� gender ����
			cstmt.setString(5, id);			// �ټ���° �Ķ���Ϳ� id ����
			cstmt.executeUpdate();			// ���� ����� ����

			// System.out.println(pstmt.toString());
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �۾��� :�ŵ���, ȸ�������� �����ϴ� �޼���
	public void deleteMember(String id) {
		try {
			// �ܷ�Ű�� ���� ����� �� ����� �� �����ϴ� ��Ű�� ���ν���
			Connection con = dataFactory.getConnection();	// db ����
			String query = "{call Member_pack.delete_reviewWrite_member(?)}";	// ��Ű���� ����� ���ν��� ȣ��(id���� ���� ����� �� ���� ����)
			System.out.println("CallableStatement1: " + query);
			cstmt = con.prepareCall(query);	// ���ν��� ����� ������ ����־� callableStatement ��ü ����
			cstmt.setString(1, id);	// ù��° �Ķ���Ϳ� id�� ����
			cstmt.executeUpdate();	// ���� ���� ����

			// �ܷ�Ű�� ������ ������� �� �����Ͽ����Ƿ� �������� ���� X -> ��� ����
			query = "{call Member_pack.delete_member(?)}";	// ��Ű���� ����� ���ν��� ȣ��(id���� ���� ��� ����)
			System.out.println("CallableStatement2: " + query);
			cstmt = con.prepareCall(query);	// ���ν��� ����� ������ ����־� callableStatement ��ü ����
			cstmt.setString(1, id);	// ù��° �Ķ���Ϳ� id�� ����
			cstmt.executeUpdate();	// ���� ���� ����

			cstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
