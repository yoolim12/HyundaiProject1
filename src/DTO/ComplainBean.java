// �ۼ��� : ������

package DTO;

import java.sql.Date;

//���鿡 ���� setter, getter �Լ����� ����ִ� DTO 
public class ComplainBean {
	
	// ComplainBean ��ü�� �޾ƿ� ������ �����ϱ� ���� ������
   private int review_num; // review_num ���� �����ϴ� ����
   private String category; // category ���� �����ϴ� ����
   private String name; // name ���� �����ϴ� ����
   private String tel; // tel ���� �����ϴ� ����
   private String email; // email ���� �����ϴ� ����
   private Date joinDate; // joinDate ���� �����ϴ� ����
   private String title; // title ���� �����ϴ� ����
   private String details; // details ���� �����ϴ� ����
   
   // ComplainBean �����ڵ�. DB ���Կ� �ʿ��� ������ �޾ƿ´�.
   public ComplainBean() {
      System.out.println("ComplainBean ������ ȣ��");
   }

   public ComplainBean(String category, String name, String tel, String email,
         String title, String details) {
		this.category = category;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.title = title;
		this.details = details;
   }

	public ComplainBean(int review_num, String category, String name, String tel, String email, Date joinDate,
			String title, String details) {
		this.review_num = review_num;
		this.category = category;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.joinDate = joinDate;
		this.details = details;
	}

	// �Ķ���ͷ� ���� ���鿡 ���� setter, getter
	public int getReview_num() { // review_num �� ���� getter
		return review_num;
	}

	public void setReview_num(int review_num) { // review_num �� ���� setter
		this.review_num = review_num;
	}

	public String getCategory() { // category �� ���� getter
		return category;
	}

	public void setCategory(String category) { // category �� ���� setter
		this.category = category;
	}

	public String getName() { // name �� ���� getter
		return name;
	}

	public void setName(String name) { // name �� ���� setter
		this.name = name;
	}

	public String getTel() { // tel �� ���� getter
		return tel;
	}

	public void setTel(String tel) { // tel �� ���� setter
		this.tel = tel;
	}

	public String getEmail() { // email �� ���� getter
		return email;
	}

	public void setEmail(String email) { // email �� ���� setter
		this.email = email;
	}

	public Date getJoinDate() { // joindate �� ���� getter
		return joinDate;
	}

	public void setJoinDate(Date joinDate) { // joindate �� ���� setter
		this.joinDate = joinDate;
	}

	public String getTitle() { // title �� ���� getter
		return title;
	}

	public void setTitle(String title) { // title �� ���� setter
		this.title = title;
	}

	public String getDetails() { // details �� ���� getter
		return details;
	}

	public void setDetails(String details) { // details �� ���� setter
		this.details = details;
	}   
}