<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����׸�Ǫ��</title>


<%
String session_id=(String)session.getAttribute("id");


if (session_id == null && application.getAttribute("result") =="1"){
	PrintWriter script=response.getWriter();
	script.println("<script>");
	script.println("alert('�α����� �����Ǿ����ϴ�.')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}
%>
</head>
<body>
ȸ��Ұ� �������Դϴ�.
</body>
</html>