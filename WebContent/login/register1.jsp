<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css"> 
<link rel="stylesheet" href="css/custom.css">
<title>회원 가입</title>
<script src="https://code.jquery.com/jquery-3.1.1min.js"></script>
<script src="js/bootstrap.js"></script>

</head>
<body>
	<div class="container">
		<form method="post" action="register1_1">
			<table class="table table-bordered table-hover" style="text-align: center; border:1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"><h4>회원 가입</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:110px"><h5>아이디</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userID" name="userID" maxLength="20"></td>
						<td style="width:110px;"><button class="btn btn-primary" onclick="registerCheckFunction();" type="button">중복체크</button>
					</tr>
					<tr>
						<td style="width:110px"><h5>비밀번호</h5></td>
						<td colspan="2"><input class="form-control" type="password" id="userPassword1" name="userPassword1" maxLength="20"></td>
					</tr>
					<!-- <tr>
						<td style="width:110px"><h5>비밀번호 확인</h5></td>
						<td colspan="2"><input class="form-control" type="password" id="userPassword2" name="userPassword2" maxLength="20"></td>
					</tr> -->
					<tr>
						<td style="width:110px"><h5>이름</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userName" name="userName" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width:110px"><h5>생년월일</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userBirth" name="userBirth" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>성별</h5></td>
						<td colspan="2">
							<div class="form-group" style="text-algin:center;margin:0 auto;">
								<label class="btn btn-primary active">
									<input type="radio" name="userGender" autocomplete="off" value="남자" checked>남자
								</label>
								<label class="btn btn-primary active">
									<input type="radio" name="userGender" autocomplete="off" value="여자">여자
								</label>
							</div>
						</td>
					</tr>

					<tr>
						<td style="width:110px"><h5>연락처</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userPH" name="userPH" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width:110px"><h5>이메일</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userEmail" name="userEmail" maxLength="20"></td>
					</tr>
					<tr>
						<td style="text-align:left" colspan="3"><input class="btn btn-primary pull-right" type="submit" value="회원가입"></td>
					</tr>
				</tbody>
				
				
			</table>
		</form>
	</div>

</body>
</html>