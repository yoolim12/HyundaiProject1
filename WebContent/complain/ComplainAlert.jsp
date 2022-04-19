<!-- 작업자 : 이승연 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8" isELIgnored="False" %>
<%@page import="java.io.PrintWriter"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>현대그린푸드</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>

<body>
<%


PrintWriter script=response.getWriter();
script.println("<script>");
script.println("alert('고객의 소리 등록이 완료되었습니다.')");
script.println("location.href='after_login.jsp'");
script.println("</script>");
%>


</body>