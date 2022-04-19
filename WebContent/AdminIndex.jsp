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
<link rel="stylesheet" href="css/custom.css?after">
<title>로그인</title>


<% String session_id=(String)session.getAttribute("id");	// session_id 값을 session 통해서 받아옴

	// session_id 
	if (session_id == null){
	PrintWriter script=response.getWriter();
	script.println("<script>");
	script.println("alert('로그인이 해제되었습니다.')");
	script.println("location.href='index.jsp'");
	script.println("</script>");
}
%>



<% 
MemberDAO memberdao= MemberDAO.getInstance();
List memberlist = new ArrayList();
memberlist=memberdao.listMembers();

request.setAttribute("memberlist",memberlist); %>
</head>

<body>
관리자<%=session_id %>님 환영합니다. <br>
session 값 : <%=session_id %><br>

<div class="container">
      <div class="row">
         <form method="post" name="search" action="searchbbs.jsp">
             <table class="pull-left">
               <tr>
                  
               <td><input type="text" class="form-control"
                     placeholder="검색할 아이디를 입력해주세요" name="searchText" maxlength="100"></td>
                  <td><button type="submit" class="btn btn-success">검색</button></td>
               </tr>

            </table>
         </form>
      </div>
</div>

<a href="search.jsp">회원목록 조회하기</a>

<%@include file="chart.jsp" %>

</body>