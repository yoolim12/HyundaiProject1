<%@page import="java.io.PrintWriter"%>
<%@page import="DAO.*"%>
<%@page import="DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="loginBean" class="DTO.loginBean" scope="page" />
<jsp:setProperty name="loginBean" property="userID" />
<jsp:setProperty name="loginBean" property="userPassword1" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		application.setAttribute("result","1");
		String id=(String)request.getAttribute("id");
		String password=(String)request.getAttribute("password");
	
		loginDAO dao = loginDAO.getInstance();
		
		loginBean.setUserID(id);
		loginBean.setUserPassword1(password);
	
		
		
		int result = dao.access(id,password);  //로그인 결과값 리턴
		
		if(result == 1){
			session.setAttribute("id", id);
			session.setAttribute("password",password);
			session.setMaxInactiveInterval(5); //15초
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('로그인 성공')");
			script.println("location.href='after_login.jsp'");
			script.println("</script>");
			
		}else if(result == 0){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result == -1){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result == -2){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류입니다')");
			script.println("history.back()");
			script.println("</script>");
		} 
	%>
</body>
</html>