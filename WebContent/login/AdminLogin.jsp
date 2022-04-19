<!-- 작업자 : 이승연 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  <link rel="stylesheet" href="css/bootstrap.css">--> 
<link rel="stylesheet" href="css/custom.css?after">
<title>로그인</title>
<!--  <script src="https://code.jquery.com/jquery-3.1.1min.js"></script>
<script src="js/bootstrap.js"></script>-->
<%@include file="../container/Header_NotMain.jsp" %>
</head>
<body>
<div class="wrapper">
   <div class="container">
      <form method="post" action="AdminLoginServlet"> 
         <table class="table table-bordered table-hover" style="text-align: center; border:1px solid #dddddd">
            <thead>
               <tr>
                  <th colspan="3"><h4>관리자 로그인</h4></th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td style="width:110px"><h5>관리자 아이디</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="id" name="id" maxLength="20"></td>
                  <td style="width:110px;"><button class="btn btn-primary" onclick="registerCheckFunction();" type="button">중복체크</button>
               </tr>
               <tr>
                  <td style="width:110px"><h5>관리자 비밀번호</h5></td>
                  <td colspan="2"><input class="form-control" type="password" id="password" name="password" maxLength="20"></td>
               </tr>
               
               <tr>
                  <td style="text-align:left" colspan="3"><input class="btn btn-primary pull-right" type="submit" value="로그인"></td>
               </tr>
            </tbody>
            
            
         </table>
      </form>
   </div>
</div>
<%@include file="../container/footer.jsp" %>
</body>
</html>