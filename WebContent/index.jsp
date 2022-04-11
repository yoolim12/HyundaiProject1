<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>


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
    <header class="header">
        <h1><a href=""><img class="logo" src="image/logo.png"/></a></h1>

        <nav>
            <ul class="gnb">
                <li>    
                    <a href="">회사소개</a>

                    <div class="gnb_sub_area">
                        <ul class="gnb_sub_area1">
                            <li><a href="sub?command=green_food">현대그린푸드</a></li>
                            <li><a href="">윤리경영</a></li>
                            <li><a href="">지속가능경영</a></li>
                            <li><a href="">사회공헌활동</a></li>
                        </ul>
                    </div>
                </li>

                <li>
                    <a href="">사업영역</a>
                    
                    <div class="gnb_sub_area">
                        <ul class="gnb_sub_area2">
                            <li><a href="">푸드서비스사업</a></li>
                            <li><a href="">외식사업</a></li>
                            <li><a href="">리테일사업</a></li>
                            <li><a href="">식자재유통사업</a></li>
                            <li><a href="">해외사업</a></li>
                            <li><a href="">건강식사업</a></li>
                    </div>

                    
                </li>

                <li>
                    <a href="">인프라시스템</a>
                    
                    <div class="gnb_sub_area">
                        <ul class="gnb_sub_area3">
                            <li><a href="">물류시스템</a></li>
                            <li><a href="">식품안전시스템</a></li>
                            <li><a href="">구매시스템</a></li>
                            <li><a href="">가공&전처리시스템</a></li>
                            <li><a href="">R&D시스템</a></li>
                            <li><a href="">고객서비스</a></li>
                        </ul>
                    </div>

                    
                </li>

                <li>
                    <a href="">브랜드이야기</a>
                    <div class="gnb_sub_area">
                        <ul class="gnb_sub_area4">
                            <a href="">브랜드이야기</a>
                        </ul>

                    </div>
                </li>

                <li>
                    <a href="">홍보센터</a>
                    <div class="gnb_sub_area">
                        <ul  class="gnb_sub_area5">
                            <a href="">공지소식</a>
                        </ul>
                    </div>
                </li>        
                
                <li>
                    <a href="">투자정보</a>
                    <div class="gnb_sub_area">
                        <ul class="gnb_sub_area6">
                            <li><a href="">주가정보</a></li>
                            <li><a href="">경영활동</a></li>
                            <li><a href="">재무정보</a></li>
                            <li><a href="">배당정보</a></li>
                            <li><a href="">기업지배구조</a></li>
                            <li><a href="">공시정보</a></li>
                            <li><a href="">공고사항</a></li>
                            <li><a href="">IR자료실</a></li>
                        </ul>
                    </div>
                    
                </li>

                <li>
                    <a href="">고객센터</a>
                    <div class="gnb_sub_area">
                        <ul class="gnb_sub_area7">
                            <li><a href="sub?command=board">고객의 소리</a></li>
                            <li><a href="">거래·상담</a></li>
                        </ul>
                    </div>
                    
                </li>
                
                <!-- <li>
                    <a href="">Admin</a>
                    <div class="gnb_sub_area">
                        <ul class="gnb_sub_area7">
                            <li><a href="">Admin</a></li>
                        </ul>
                    </div>
                    
                </li>   -->      
            </ul>
        </nav>
    </header>

    <div class="video">
        
        <video width="100%" height="auto" autoplay muted loop>
            <source src="video/1_cooking_dark.mp4" type="video/mp4">
        </video>  
    </div>
    
     <a href="sub?command=login1">회원가입</a>
	 <a href="sub?command=login2">로그인</a> | <a href="sub?command=admin_login">관리자 로그인</a>
	 <% String session_id=(String)session.getAttribute("id"); //세션 체크
	 	application.setAttribute("result",'0'); //로그인 유무 체크
	 	
	 %>
	 session 값 : <%=session_id %>
	 application 값 : <%=application.getAttribute("result") %>
	  
	
	
</body>
</html>

