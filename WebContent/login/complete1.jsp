<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@page import= "java.sql.Connection" %>
<%@page import= "java.sql.PreparedStatement"%>
<%@page import= "DTO.*" %>
<%@page import="DAO.*" %>
<%@page import= "java.sql.Date" %>

<%
	request.setCharacterEncoding("UTF-8");

	String id=request.getParameter("userID");
	String password=request.getParameter("userPassword1");
	String name=request.getParameter("userName");
	String birth=request.getParameter("userBirth");
	String gender=request.getParameter("userGender");
	String ph=request.getParameter("userPH");
	String email=request.getParameter("userEmail");
	
	UserBean userbean=new UserBean(id,password,name,birth,gender,email,ph);
	
	UserDAO dao=UserDAO.getInstance();
	
	dao.addMember(userbean);
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>로그인</title>

</head>

<body>



</body>