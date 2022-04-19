<!-- 작업자 : 이승연 -->
<%@page import="java.io.PrintWriter"%>
<%@page import="DAO.*"%>
<%@page import="DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="LoginBean" class="DTO.LoginBean" scope="page" />
<jsp:setProperty name="LoginBean" property="id" />
<jsp:setProperty name="LoginBean" property="password" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
	<%
	
	/* ************************* 필독 *****************************
		회원이 로그인 성공 시, application 을 이용하여 웹 전체에 result 값에 1을 할당한다.
					result 가 1이면, 로그인 된 후
					result가 0이면, 로그아웃 된 후 
	*/
		String id=(String)request.getAttribute("id");
		String password=(String)request.getAttribute("password");
	
		LoginDAO logindao = LoginDAO.getInstance();
		
		LoginBean.setId(id);
		LoginBean.setPassword(password);
	
		
		
		int result = logindao.access(id,password);  //로그인 결과값 리턴
		
		if(result == 1){//로그인 성공
			application.setAttribute("result","1");
			session.setAttribute("id", id);
			session.setAttribute("password",password);
			session.setMaxInactiveInterval(100); //15초
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('로그인 성공')");
			script.println("location.href='after_login.jsp'");
			script.println("</script>");
			
		}else if(result == 0){//비밀번호 오류
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result == -1){//아이디 오류
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다')");
			script.println("history.back()");
			script.println("</script>");
		}else if(result == -2){//DB 오류
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류입니다')");
			script.println("history.back()");
			script.println("</script>");
		} 
	%>
</body>
</html>