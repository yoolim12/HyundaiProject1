<!-- 작성자: 최유림 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<title>고객의 소리</title>
<link rel="stylesheet" type="text/css" href="css/SubLayout.css?after">0
<%
String session_id=(String)session.getAttribute("id");
if (session_id == null && application.getAttribute("result") == "1") {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('로그인이 해제되었습니다.')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}
%>

<% if(session_id == null) {
%>
<%@include file="../container/Header.jsp"  %>
<%
} else {
%>
<%@include file="../container/AfterLoginHeader.jsp"  %>
<%
} 
%>
</head>
<body>

	<div class="container_area" id="contents">

		<!-- Body -->

		<!-- contents : str -->
		<div class="sub_layout sub_visual_6">
			<!-- 하이어라키 -->
			<ul class="hierarchy_list">
				<li class="icon_home"><a href="#"><img
						src="image/icon/icon_home.png" alt="Home"></a></li>
				<li class="depth_2"><a href="#" class="m_hierarchy">고객센터 </a>

					<ul class="hierarchy_depth" style="display: none;">
						<li><a href="#">고객센터</a></li>
					</ul></li>
				<li class="depth_3"><a href="#" class="t_block_hierarchy">고객의
						소리 </a>

					<ul class="hierarchy_depth">
						<li><a href="#">자주 묻는 질문</a></li>
						<li><a href="#">거래·상담</a></li>
						<li class="on"><a href="#">고객의 소리</a></li>
					</ul></li>
			</ul>
			<!-- //하이어라키 -->

			<!-- 작성자로부터 작성자 정보 및 리뷰 내용을 받습니다. 
			form은 post 방식으로 진행되며, submit을 누르면 ComplainServlet.java 라는 서블릿으로 넘어갑니다. -->
			<form name="formInfo" id="formInfo" method="post" action="ComplainServlet">
				<!-- 서브 컨텐츠 -->
				<div class="sub_contents">
					<!-- 타이틀 , 디스크립션 -->
					<div class="title_description">
						<h2 class="title_sub">고객의 소리</h2>

						<p class="sub_description">고객의 작은 목소리에도 귀 기울이겠습니다.</p>
					</div>
					<!-- //타이틀 , 디스크립션 -->



					<div class="n_counsel_area">
						<ul class="counsel_list">
							<li>
								<dl>
									<dt>
										<img src="image/icon/icon_customer.png" alt=""> <span
											class="title_dt"><strong title="필수입력">*</strong>분류</span>
									</dt>
									<dd>
									<!-- 카테고리 선택 -->
										<ul class="counsel_check">

											<li><input name="category" type="radio" id="counsel1"
												value="칭찬"><label for="counsel1">칭찬</label></li>

											<li><input name="category" type="radio" id="counsel2"
												value="불만"><label for="counsel2">불만</label></li>

											<li><input name="category" type="radio" id="counsel3"
												value="제안"><label for="counsel3">제안</label></li>

											<li><input name="category" type="radio" id="counsel4"
												value="기타"><label for="counsel4">기타</label></li>

										</ul>
									</dd>
								</dl>
							</li>

							<li>
								
							</li>

							<li>
								<dl>
									<dt>
										<img src="image/icon/icon_name.png" alt=""> <label
											for="name" class="title_dt"><strong title="필수입력">*</strong>성명</label>
									</dt>
									<dd>
										<!-- 이름 입력 -->
										<input type="text" id="name"
											class="input_text counsel_name" name="name" maxlength="15"
											required="true" title="성명">
									</dd>
								</dl>
							</li>

							<li>
								<dl>
									<dt>
										<img src="image/icon/icon_phone2.png" alt=""> <label
											for="phone" class="title_dt"><strong title="필수입력">*</strong>연락처</label>
									</dt>
									<dd>
										<!-- 연락처 첫번째 자리 선택 -->
										<select id="phone" class="input_select counsel_phone1"
											required="true" name="wrterTelnoFrt" title="연락처 첫번째 자리">
											<option value="">선택</option>

											<option>010</option>

											<option>011</option>

											<option>016</option>

											<option>017</option>

											<option>018</option>

											<option>019</option>

										</select>
										<!-- 연락처 두,세번째 자리 입력 -->
										- <input type="text" id="phone"
											class="input_text counsel_phone2" title="연락처 두번째 자리"
											required="true" format="number" maxlength="4" minlength="3"
											name="wrterTelnoMdd"> - <input type="text" id="phone"
											class="input_text counsel_phone3" title="연락처 세번째 자리"
											required="true" format="number" maxlength="4" minlength="4"
											name="wrterTelnoBck">
									</dd>
								</dl>
							</li>

							<li>
								<dl>
									<dt>
										<img src="image/icon/icon_email.png" alt="">

										<label for="email" class="title_dt"><strong
											title="필수입력">*</strong>이메일</label>
									</dt>
									<dd>
										<!-- 이메일 주소 입력 -->
										<input type="text" id="email"
											class="input_text counsel_email1" title="이메일 아이디"
											required="true" name="wrterEmailFrt" maxlength="30"
											format="emailid"> @ <input type="text"
											class="input_text counsel_email2" title="이메일 주소"
											required="true" name="wrterEmailBck" maxlength="30"
											format="emaildomain">
									</dd>
								</dl>
							</li>

							<li id="voc_file_attach_area">
								
							</li>

							<li class="title_contents_li">
								<dl>
									<dt>
										<label for="title">제목</label>
									</dt>
									<dd>
										<!-- 제목 입력 -->
										<input type="text" id="title" class="input_text counsel_title"
											name="title" maxlength="30" required="true"
											title="제목">
									</dd>
								</dl>

								<dl>
									<dt>
										<label for="counse_content">내용</label>
									</dt>
									<dd>
										<!-- 내용 입력 -->
										<textarea class="counsel_content" id="details"
											name="details" required="true" title="내용"></textarea>
									</dd>
								</dl>
							</li>
						</ul>
					</div>
					<!-- submit을 누르면 ComplainServlet.java 라는 서블릿으로 넘어갑니다 -->
					<input type="submit" value="등록">
				</div>
				<!-- //서브 컨텐츠 -->
			</form>
		</div>	
		<!-- contents : end -->
	</div>
	<%@include file="../container/footer.jsp"%>
</body>
</html>