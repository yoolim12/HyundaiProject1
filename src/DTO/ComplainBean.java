// 작성자 : 최유림

package DTO;

import java.sql.Date;

//값들에 대한 setter, getter 함수들이 들어있는 DTO 
public class ComplainBean {
	
	// ComplainBean 객체가 받아온 값들을 저장하기 위한 변수들
   private int review_num; // review_num 값을 저장하는 변수
   private String category; // category 값을 저장하는 변수
   private String name; // name 값을 저장하는 변수
   private String tel; // tel 값을 저장하는 변수
   private String email; // email 값을 저장하는 변수
   private Date joinDate; // joinDate 값을 저장하는 변수
   private String title; // title 값을 저장하는 변수
   private String details; // details 값을 저장하는 변수
   
   // ComplainBean 생성자들. DB 삽입에 필요한 값들을 받아온다.
   public ComplainBean() {
      System.out.println("ComplainBean 생성자 호출");
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

	// 파라미터로 받은 값들에 대한 setter, getter
	public int getReview_num() { // review_num 에 대한 getter
		return review_num;
	}

	public void setReview_num(int review_num) { // review_num 에 대한 setter
		this.review_num = review_num;
	}

	public String getCategory() { // category 에 대한 getter
		return category;
	}

	public void setCategory(String category) { // category 에 대한 setter
		this.category = category;
	}

	public String getName() { // name 에 대한 getter
		return name;
	}

	public void setName(String name) { // name 에 대한 setter
		this.name = name;
	}

	public String getTel() { // tel 에 대한 getter
		return tel;
	}

	public void setTel(String tel) { // tel 에 대한 setter
		this.tel = tel;
	}

	public String getEmail() { // email 에 대한 getter
		return email;
	}

	public void setEmail(String email) { // email 에 대한 setter
		this.email = email;
	}

	public Date getJoinDate() { // joindate 에 대한 getter
		return joinDate;
	}

	public void setJoinDate(Date joinDate) { // joindate 에 대한 setter
		this.joinDate = joinDate;
	}

	public String getTitle() { // title 에 대한 getter
		return title;
	}

	public void setTitle(String title) { // title 에 대한 setter
		this.title = title;
	}

	public String getDetails() { // details 에 대한 getter
		return details;
	}

	public void setDetails(String details) { // details 에 대한 setter
		this.details = details;
	}   
}