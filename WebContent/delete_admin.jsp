<!-- 작업자 : 이승연 -->
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
<title>회원 정보 삭제</title>
</head>
<body>
 <%
 // 자바스크립트 삽입
 PrintWriter script=response.getWriter();  
 script.println("<script>");
 script.println("alert('회원정보가 삭제되었습니다.')");
 script.println("location.href='AdminIndex.jsp'");
 script.println("</script>");
 
 %>
</body>
</html>