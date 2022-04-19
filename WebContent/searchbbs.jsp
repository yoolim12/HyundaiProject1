<!--  작성자 : 이승연 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DTO.*" %>
<%@page import= "DAO.*" %>
<%@page import= "java.util.*" %>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
//리뷰리스트 반환
MemberDAO dao = MemberDAO.getInstance();
List reviewlist = new ArrayList();
String id=request.getParameter("searchText");
reviewlist = dao.listMembers2(id);
request.setAttribute("reviewlist",reviewlist);
%>
</head>
<body>
<table border="1" align="left">
   <tr align="center" bgcolor="lightgreen">
      <td width="10%">번호</td>
      <td width="10%">아이디</td>
      <td width="7%">비밀번호</td>
      <td width="7%">이름</td>
      <td width="7%">생년월일</td>
      <td width="7%">성별</td>
      <td width="12%">이메일</td>
      <td width="12%">연락처</td>
      <td width="7%">가입일</td>
      <td width="10%">리뷰</td>
      <td width="10%">삭제</td>
   </tr>
   <c:forEach var="reviewlist" items="${reviewlist}">
   <tr align="center">
   	  <td>${reviewlist.member_num}</td>
      <td>${reviewlist.id}</td>
      <td>${reviewlist.password}</td>
      <td>${reviewlist.name}</td>
      <td>${reviewlist.birth}</td>
      <td>${reviewlist.gender}</td>
      <td>${reviewlist.email}</td>
      <td>${reviewlist.tel}</td>
      <td>${reviewlist.joinDate}</td>
      
      <td><form method = "post" action="review">
         <input type="hidden" name="id" value="${reviewlist.id}">
         <input type="submit" value="작성 리뷰 확인"/>
         </form>
      </td>   
      <td><form method = "post" action="Delete_admin">
         <input type="hidden" name="delete_id" value="${reviewlist.id}">
         <input type="submit" value="회원 영구 삭제"/>
         </form>
      </td>
   </tr>
   </c:forEach>
</table>


</body>
</html>