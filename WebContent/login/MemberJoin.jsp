<!-- 작업자 : 이승연 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  <link rel="stylesheet" href="css/bootstrap.css">--> 
<link rel="stylesheet" href="css/custom.css?after">
<title>회원 가입</title>
<!--  <script src="https://code.jquery.com/jquery-3.1.1min.js"></script>
<script src="js/bootstrap.js"></script>-->
<%@include file="../container/Header_NotMain.jsp" %>
</head>
<body>
<div class="wrapper">
   <div class="container">
      <form method="post" action="MemberJoinServlet">
         <table class="table table-bordered table-hover" style="text-align: center; border:1px solid #dddddd">
            <thead>
               <tr>
                  <th colspan="3"><h4>회원 가입</h4></th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td style="width:110px"><h5>아이디</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="id" name="id" maxLength="20"></td>
                  <td style="width:110px;"><button class="btn btn-primary" onclick="registerCheckFunction();" type="button">중복체크</button>
               </tr>
               <tr>
                  <td style="width:110px"><h5>비밀번호</h5></td>
                  <td colspan="2"><input class="form-control" type="password" id="password" name="password" maxLength="20"></td>
               </tr>
               <!-- <tr>
                  <td style="width:110px"><h5>비밀번호 확인</h5></td>
                  <td colspan="2"><input class="form-control" type="password" id="userPassword2" name="userPassword2" maxLength="20"></td>
               </tr> -->
               <tr>
                  <td style="width:110px"><h5>이름</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="name" name="name" maxLength="20"></td>
               </tr>
               <tr>
                  <td style="width:110px"><h5>생년월일</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="birth" name="birth" maxLength="20"></td>
               </tr>
               <tr>
                  <td style="width: 110px;"><h5>성별</h5></td>
                  <td colspan="2">
                     <div class="form-group" style="text-algin:center;margin:0 auto;">
                        <label class="btn btn-primary active">
                           <input type="radio" name="gender" autocomplete="off" value=1 checked>남자
                        </label>
                        <label class="btn btn-primary active">
                           <input type="radio" name="gender" autocomplete="off" value=2>여자
                        </label>
                     </div>
                  </td>
               </tr>

               <tr>
                  <td style="width:110px"><h5>연락처</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="tel" name="tel" maxLength="20"></td>
               </tr>
               <tr>
                  <td style="width:110px"><h5>이메일</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="email" name="email" maxLength="30"></td>
               </tr>
               <tr>
                  <td style="text-align:left" colspan="3"><input class="btn btn-primary pull-right" type="submit" value="회원가입"></td>
               </tr>
            </tbody>
            
            
         </table>
      </form>
   </div>
</div>
<%@include file="../container/footer.jsp" %>
</body>
</html>