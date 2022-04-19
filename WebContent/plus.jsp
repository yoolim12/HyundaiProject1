<!-- 작업자 : 이승연 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<%-- 글 번호 : ${plus_list.review_num} <br>
작성자  : ${plus_list.name }<br>
제목 : ${plus_list.title }<br>
내용   : ${plus_list.content } --%>

<c:forEach var="plus_list" items="${plus_list}">
   게시물번호  : ${plus_list.review_num} <br>
   이름   :   ${plus_list.name } <br>
   제목   :    ${plus_list.title } <br><br><br>
   [ 내용 ]<br><br><br>
   ${plus_list.details }
   
</c:forEach>

</body>
</html>
