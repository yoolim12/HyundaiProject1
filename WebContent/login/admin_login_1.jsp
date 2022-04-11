<%@page import="java.io.PrintWriter"%>
<%@page import="DAO.*"%>
<%@page import="DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="admin_loginBean" class="DTO.admin_loginBean" scope="page" />
<jsp:setProperty name="admin_loginBean" property="masterID" />
<jsp:setProperty name="admin_loginBean" property="masterPassword1" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		String id=(String)request.getAttribute("id");
		String password=(String)request.getAttribute("password");
	
		admin_loginDAO dao = admin_loginDAO.getInstance();
		
		admin_loginBean.setMasterID(id);
		admin_loginBean.setMasterPassword1(password);
	
		
		
		int result = dao.access(id,password);  //로그인 결과값 리턴
		
		if(result == 1){
			session.setAttribute("id", id);
			session.setAttribute("password",password);
			session.setMaxInactiveInterval(5); //15초
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('관리자 로그인 성공')");
			script.println("location.href='admin_login_index.jsp'");
			script.println("</script>");
			
		}else if(result == 0){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('관리자 비밀번호가 틀립니다')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result == -1){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 관리자 아이디입니다')");
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