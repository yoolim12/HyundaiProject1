<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>현대그린푸드</title>


<%
String session_id=(String)session.getAttribute("id");


if (session_id == null && application.getAttribute("result") =="1"){
	PrintWriter script=response.getWriter();
	script.println("<script>");
	script.println("alert('로그인이 해제되었습니다.')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}
%>
</head>
<body>
회사소개 페이지입니다.
</body>
</html>