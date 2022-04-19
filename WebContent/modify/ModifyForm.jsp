<!-- 작성자: 신동근 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="DAO.*"%>
<%@page import="DTO.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css"> 
<link rel="stylesheet" href="css/custom.css?after">
<title>회원정보 수정 입력 화면</title>

	<%	
		//out.println(session.getAttribute("session_id"));
		String session_id=(String)session.getAttribute("id");
		//out.println(session_id);
		MemberDAO dao = MemberDAO.getInstance();
		List memberlist = dao.selectMember(session_id);
		//pageContext.setAttribute("memberList", memberList);
		//request.setAttribute("memberList", memberList);
		request.setAttribute("memberlist",memberlist);
	%>
	
<!-- <script>
	fuction toEnabled() {
		$("input[name=userID]").attr("disalbed", false);
		$("input[name=userName]").attr("disalbed", false);
		$("input[name=userBirth]").attr("disalbed", false);
	}
</script> -->
</head>
<body>
		<div class="container">
		<form method="post" action="UpdateMember">
			<table class="table table-bordered table-hover" style="text-align: center; border:1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"><h4>회원 정보</h4></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="memberlist" items="${memberlist}">
					<tr>
						<td style="width:110px"><h5>아이디</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="id" name="id" maxLength="20" value="${memberlist.id}" readonly></td>
					</tr>
					<tr>
						<td style="width:110px"><h5>비밀번호</h5></td>
						<td colspan="2"><input class="form-control" type="password" id="password" name="password" maxLength="20"></td>
					</tr>
					<!-- <tr>
						<td style="width:110px"><h5>비밀번호 확인</h5></td>
						<td colspan="2"><input class="form-control" type="password" id="userPassword2" name="userPassword2" maxLength="20"></td>
					</tr> -->
					<tr>
						<td style="width:110px"><h5>이름</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="name" name="name" maxLength="20" value="${memberlist.name}" readonly></td>
					</tr>
					<tr>
						<td style="width:110px"><h5>생년월일</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="birth" name="birth" maxLength="20" value="${memberlist.birth}" readonly></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>성별</h5></td>
						<td colspan="2">
							<div class="form-group" style="text-algin:center;margin:0 auto;">
								<c:choose>
									<c:when test="${memberlist.gender eq 1}" >
										<label class="btn btn-primary active"> <input
											type="radio" name="gender" autocomplete="off" value=1 checked>남자
										</label>
										<label class="btn btn-primary active"> <input
											type="radio" name="gender" autocomplete="off" value=2>여자
										</label>
									</c:when>
									
									<c:when test="${memberlist.gender eq 2}" >
										<label class="btn btn-primary active"> <input
											type="radio" name="gender" autocomplete="off" value=1>남자
										</label>
										<label class="btn btn-primary active"> <input
											type="radio" name="gender" autocomplete="off" value=2 checked>여자
										</label>
									</c:when>
								</c:choose>
							</div>
						</td>
					</tr>

					<tr>
						<td style="width:110px"><h5>연락처</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="tel" name="tel" maxLength="20" value="${memberlist.tel}"></td>
					</tr>
					<tr>
						<td style="width:110px"><h5>이메일</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="email" name="email" maxLength="20" value="${memberlist.email}"></td>
					</tr>
					<tr>
						<td style="text-align:left" colspan="3"><input class="btn btn-primary pull-right" type="submit" value="수정하기"></td>
					</tr>
					</c:forEach>
				</tbody>
				
				
			</table>
		</form>
		
		<form method="post" action="DeleteMemberServlet">
			<input class="btn btn-primary pull-right" type="submit" value="탈퇴하기"> 
		</form>
	</div>
</body>
</html>