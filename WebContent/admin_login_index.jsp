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
<link rel="stylesheet" href="css/custom.css">
<title>로그인</title>


<% String session_id=(String)session.getAttribute("id");


	if (session_id == null){
	PrintWriter script=response.getWriter();
	script.println("<script>");
	script.println("alert('로그인이 해제되었습니다.')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}
%>



<% 
UserDAO dao= UserDAO.getInstance();
List memberlist = new ArrayList();
memberlist=dao.listMembers();

request.setAttribute("memberlist",memberlist); %>
</head>

<body>
관리자<%=session_id %>님 환영합니다. <br>
session 값 : <%=session_id %><br>


<table border="1" align="left">
	<tr align="center" bgcolor="lightgreen">
		<td width="15%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">생년월일</td>
		<td width="7%">성별</td>
		<td width="7%">이메일</td>
		<td width="15%">연락처</td>
		<td width="7%">가입일</td>
		<td width="10%">리뷰</td>
	</tr>
	<c:forEach var="memberlist" items="${memberlist}">
	<tr align="center">
		<td>${memberlist.userID}</td>
		<td>${memberlist.userPassword1}</td>
		<td>${memberlist.userName}</td>
		<td>${memberlist.userBirth}</td>
		<td>${memberlist.userGender}</td>
		<td>${memberlist.userEmail}</td>
		<td>${memberlist.userPH}</td>
		<td>${memberlist.joinDate}</td>
		
		<td><form method = "post" action="review">
			<input type="hidden" name="id" value="${memberlist.userID}">
			<input type="submit" value="작성 리뷰 확인"/>
			</form>
		</td>	
	</tr>
	</c:forEach>
</table>
</body>