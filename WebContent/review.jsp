<!-- 작업자 : 이승연 -->
<%@page import="DAO.*"%>
<%@page import="DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@ page import="java.util.*"%>

<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<table border="1" align="left">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%">번호</td>
			<td width="7%">이름</td>
			<td width="7%">후기</td>
			<td width="7%">작성날짜</td>
		</tr>
		<c:forEach var="list" items="${review_list }">
			<tr align="center">
				<td>${list.review_num}</td>
				<td>${list.name}</td>
				<td>${list.category}</td>
				<td>${list.joinDate}</td>
				<td><form method="post" action="plus">
						<input type="hidden" name="num" value="${list.review_num}">
						<input type="submit" value="게시물 보기" />
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>