<!-- 작업자 : 신동근 -->
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
<title>회원 탈퇴</title>
</head>
<body>

 <%
//작업자 이승연 : 회원 탈퇴하면 세션 값 초기화시키고 메인페이지로 이동
 session.invalidate(); 
 
 PrintWriter script=response.getWriter();  
 script.println("<script>");
 script.println("alert('회원 탈퇴되었습니다.')");
 script.println("location.href='index.jsp'");
 script.println("</script>");
 //---------------------------------------------------
 %>
</body>
</html>