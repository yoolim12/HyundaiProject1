<!-- 작업자: 최유림 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>현대그린푸드</title>
    <link rel="stylesheet" type="text/css" href="css/Layout.css?after">
    <link rel="stylesheet" type="text/css" href="css/Main.css">
    <link rel="stylesheet" type="text/css" href="css/Header.css?after">
</head>
<body>
    <header class="header no-touch-color">
       <div class="cont_center">
        <h1 class="logo"><a href="../pro12/index.jsp"><!-- <img class="logo" src="./image/logo.png"/>--></a></h1>
        <nav class="gnb_area">
            <ul class="gnb">
                <li>    
                    <a class="main_menu" href="main.jsp">회사소개</a>

                    <div class="gnb_sub_area">
                        <ul class="cont_center gnb_sub gnb_sub_area1">
                            <li><a href="sub?command=green_food">현대그린푸드</a></li>
                        </ul>
                    </div>
                </li>

                <li>
                    <a class="main_menu" href="">사업영역</a>
                    
                    <div class="gnb_sub_area">
                        <ul class="cont_center gnb_sub gnb_sub_area2">
                            <li><a href="sub?command=Sub2_First">푸드서비스사업</a></li>
                            <li><a href="sub?command=Sub2_Second">외식사업</a></li>
                        </ul>
                    </div>

                    
                </li>

                <li>
                    <a class="main_menu" href="">인프라시스템</a>
                    
                    <div class="gnb_sub_area">
                        <ul class="cont_center gnb_sub gnb_sub_area3">
                            <li><a href="sub?command=Sub3_First">물류시스템</a></li>
                            <li><a href="sub?command=Sub3_Second">식품안전시스템</a></li>
                        </ul>
                    </div>

                    
                </li>

                <li>
                    <a class="main_menu" href="">브랜드이야기</a>
                    <div class="gnb_sub_area">
                        <ul class="cont_center gnb_sub gnb_sub_area4">
                            <li><a href="sub?command=Sub4_First">브랜드이야기</a></li>
                        </ul>

                    </div>
                </li>

                <li>
                    <a class="main_menu" href="">홍보센터</a>
                    <div class="gnb_sub_area">
                        <ul class="cont_center gnb_sub gnb_sub_area5">
                        </ul>
                    </div>
                </li>        
                
                <li>
                    <a class="main_menu" href="">투자정보</a>
                    <div class="gnb_sub_area">
                        <ul class="cont_center gnb_sub gnb_sub_area6">
                            <li><a href="">주가정보</a></li>
                        </ul>
                    </div>
                    
                </li>

                <!-- <li>
                    <a class="main_menu" href="">고객센터</a>
                    <div class="gnb_sub_area">
                        <ul class="cont_center gnb_sub gnb_sub_area7">
                            <li><a href="">고객의 소리</a></li>
                            <li><a href="">거래·상담</a></li>
                        </ul>
                    </div>
                    
                </li> -->
                
                <!-- <li>
                    <a class="main_menu" href="">Admin</a>
                    <div class="gnb_sub_area">
                        <ul class="cont_center gnb_sub gnb_sub_area8">
                            <li><a href="">Admin</a></li>
                        </ul>
                    </div>
                    
                </li>  -->        
            </ul>
        </nav>
      </div>
    </header>
      <script>
           const header = document.querySelector('.header');
           const logo = document.querySelector('.logo > a');
           const mainmenu = document.querySelectorAll('.main_menu');
           const menuHover = document.querySelectorAll('.gnb > li');
           
         header.setAttribute("style", "background: white;");
         logo.setAttribute("style", "background: url(./image/header/logo.png); background-size: 100%");
         mainmenu.forEach(function(menu) {
            menu.setAttribute("style", "color: black;");
         });
         
         menuHover.forEach(function(hover) {
            /*hover.addEventListener('mouseover', function(event){
            hover.setAttribute("style", "border-bottom: 5px solid #459459;");
            });*/
             hover.addEventListener('mouseout', function(event){
                hover.setAttribute("style", "border-bottom: none;");
             });
          });
    </script>
</body>
</html>