<!-- 작업자 : 공동 -->
<!-- 메인페이지(로그인 전 첫 페이지) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>현대그린푸드</title>
    <link rel="stylesheet" type="text/css" href="css/Main.css?after">
    <link rel="stylesheet" type="text/css" href="css/slick.css?after">
</head>



<body>
	<div class="wrap wrap_main">
	<%@include file="../container/Header.jsp" %>
		<div class="container_area" id="contents">

			<!-- Body
    ################# -->

			<!-- contents : str -->


			<!--모션관련 script-->
			<!--<script src="/Contents/js/modernizr-2.6.2.min.js"></script>
			<script src="/Contents/flash/libs/easeljs-0.7.0.min.js"></script>
			<script src="/Contents/flash/libs/tweenjs-0.5.0.min.js"></script>
			<script src="/Contents/flash/libs/movieclip-0.7.0.min.js"></script>
			<script src="/Contents/flash/libs/preloadjs-0.4.0.min.js"></script>

			<script src="/Contents/flash/GreenSock/easing/EasePack.js"></script>
			<script src="/Contents/flash/GreenSock/TweenLite.js"></script>
			<script src="/Contents/flash/GreenSock/TweenMax.js"></script>
			<script src="/Contents/flash/motionActive_Company.js"></script>  -->



			<!-- container -->
			<div class="container container_main">
				<!-- 영상 영역 -->
				<div class="main_video_area slick-initialized slick-slider"
					style="height: auto;">
					<!-- 영상 1 -->
					<div aria-live="polite" class="slick-list draggable">
						<div class="slick-track" role="listbox"
							style="opacity: 1; width: 3678px;">
							<div class="video_text_area video_text_area1 slick-slide"
								data-slick-index="0" aria-hidden="true" tabindex="-1"
								role="option" aria-describedby="slick-slide00"
								style="width: 1226px; position: relative; left: 0px; top: 0px; z-index: 998; opacity: 0; transition: opacity 500ms linear 0s;">
								<video width="100%" muted loop autoplay style="width: 2000px;">
									<source src="video/1_cooking_dark.mp4" type="video/mp4">
								</video>

								<div class="main_text" style="width: 1800px;">
									<img src="image/main/top_title1.png" alt="사람들의 맛있는 삶을 만들어 갑니다.">
								</div>
							</div>
							<div
								class="video_text_area video_text_area2 slick-slide slick-current slick-active"
								data-slick-index="1" aria-hidden="false" tabindex="-1"
								role="option" aria-describedby="slick-slide01"
								style="width: 1226px; position: relative; left: -1226px; top: 0px; z-index: 1000; opacity: 1; transition: opacity 500ms linear 0s;">
								<video width="100%" muted loop autoplay style="width: 2000px;">
									<source src="video/2_delivery_dark.mp4" type="video/mp4">
								</video>

								<div class="main_text" style="width: 1800px;">
									<img src="image/main/top_title3.png" alt="우리의 건강한 자연을 담아">
								</div>
							</div>
							<div class="video_text_area video_text_area3 slick-slide"
								data-slick-index="2" aria-hidden="true" tabindex="-1"
								role="option" aria-describedby="slick-slide02"
								style="width: 1226px; position: relative; left: -2452px; top: 0px; z-index: 998; opacity: 0; transition: opacity 500ms linear 0s;">
								<video width="100%" muted loop autoplay style="width: 2000px;">
									<source src="video/3_lab_dark.mp4" type="video/mp4">
								</video>

								<div class="main_text" style="width: 1800px;">
									<img src="image/main/top_title2.png" alt="우리의 정직한 마음">
								</div>
							</div>
						</div>
					</div>
					<!-- //영상 1 -->

					<!-- 영상 2 -->

					<!-- //영상 2 -->

					<!-- 영상 3 -->

					<!-- //영상 3 -->
				</div>
				<!-- //영상 영역 -->

				<!-- introduction -->
				<div class="cont_center introduction_area">
					<h2>
						<img src="image/main/title_intro.png" alt="Introduction">
					</h2>

					<!-- introduction slide -->
					<div
						class="intro_slide_area slick-initialized slick-slider slick-dotted"
						role="toolbar">
						<button type="button" data-role="none"
							class="slick-prev slick-arrow" aria-label="Previous"
							role="button" style="display: block;">이전</button>
						<div aria-live="polite" class="slick-list draggable">
							<div class="slick-track" role="listbox"
								style="opacity: 1; width: 4584px; transform: translate3d(-1146px, 0px, 0px);">
								<div class="intro_business slick-slide slick-cloned"
									data-slick-index="-3" aria-hidden="true" tabindex="-1"
									style="width: 382px;">
									<a href="/po/fb/fdb/FBFDB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img4.jpg" alt=""> <strong>식자재유통사업</strong>

										효율적인 시스템을 통해 신선하고 믿을 수 있는 <br>식자재를 합리적인 가격에 제공합니다.
									</a>
								</div>
								<div class="intro_business slick-slide slick-cloned"
									data-slick-index="-2" aria-hidden="true" tabindex="-1"
									style="width: 382px;">
									<a href="/po/fb/ovb/FBOVB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img5.jpg" alt=""> <strong>해외사업</strong>

										현지 맞춤식 레시피와 상품공급 능력을 통해 세계로 <br>나아가고 있습니다.
									</a>
								</div>
								<div class="intro_business slick-slide slick-cloned"
									data-slick-index="-1" aria-hidden="true" tabindex="-1"
									style="width: 382px;">
									<a href="/po/fb/gtb/FBGTB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img6.jpg" alt=""> <strong>건강식사업</strong>

										매일 즐길 수 있는 맛있는 건강식을 연구하고, <br>고객에게 맞춤형 건강식단을 배송합니다.
									</a>
								</div>
								<div
									class="intro_business slick-slide slick-current slick-active"
									data-slick-index="0" aria-hidden="false" tabindex="-1"
									role="option" aria-describedby="slick-slide10"
									style="width: 382px;">
									<a href="/po/fb/fsb/FBFSB01L.hgc" tabindex="0"> <img
										src="image/main/intro_img1.jpg" alt=""> <strong>급식사업</strong>

										오피스, 산업체, 병원환자식 등을 제공하며 <br>급식의 트렌드를 이끌어갑니다.
									</a>
								</div>
								<div class="intro_business slick-slide slick-active"
									data-slick-index="1" aria-hidden="false" tabindex="-1"
									role="option" aria-describedby="slick-slide11"
									style="width: 382px;">
									<a href="/po/fb/eob/FBEOB01L.hgc" tabindex="0"> <img
										src="image/main/intro_img2.jpg" alt=""> <strong>외식사업</strong>

										고품격 공간과 다양한 서비스로 외식문화의 <br>새로운 경험과 가치를 창조합니다.
									</a>
								</div>
								<div class="intro_business slick-slide slick-active"
									data-slick-index="2" aria-hidden="false" tabindex="-1"
									role="option" aria-describedby="slick-slide12"
									style="width: 382px;">
									<a href="/po/fb/rtb/FBRTB01L.hgc" tabindex="0"> <img
										src="image/main/intro_img3.jpg" alt=""> <strong>리테일사업</strong>

										품질 좋고 믿을 수 있는 상품을 제공하며 <br>쇼핑과 앞선 라이프 스타일을 제안합니다.
									</a>
								</div>
								<div class="intro_business slick-slide" data-slick-index="3"
									aria-hidden="true" tabindex="-1" role="option"
									aria-describedby="slick-slide13" style="width: 382px;">
									<a href="/po/fb/fdb/FBFDB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img4.jpg" alt=""> <strong>식자재유통사업</strong>

										효율적인 시스템을 통해 신선하고 믿을 수 있는 <br>식자재를 합리적인 가격에 제공합니다.
									</a>
								</div>
								<div class="intro_business slick-slide" data-slick-index="4"
									aria-hidden="true" tabindex="-1" role="option"
									aria-describedby="slick-slide14" style="width: 382px;">
									<a href="/po/fb/ovb/FBOVB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img5.jpg" alt=""> <strong>해외사업</strong>

										현지 맞춤식 레시피와 상품공급 능력을 통해 세계로 <br>나아가고 있습니다.
									</a>
								</div>
								<div class="intro_business slick-slide" data-slick-index="5"
									aria-hidden="true" tabindex="-1" role="option"
									aria-describedby="slick-slide15" style="width: 382px;">
									<a href="/po/fb/gtb/FBGTB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img6.jpg" alt=""> <strong>건강식사업</strong>

										매일 즐길 수 있는 맛있는 건강식을 연구하고, <br>고객에게 맞춤형 건강식단을 배송합니다.
									</a>
								</div>
								<div class="intro_business slick-slide slick-cloned"
									data-slick-index="6" aria-hidden="true" tabindex="-1"
									style="width: 382px;">
									<a href="/po/fb/fsb/FBFSB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img1.jpg" alt=""> <strong>급식사업</strong>

										오피스, 산업체, 병원환자식 등을 제공하며 <br>급식의 트렌드를 이끌어갑니다.
									</a>
								</div>
								<div class="intro_business slick-slide slick-cloned"
									data-slick-index="7" aria-hidden="true" tabindex="-1"
									style="width: 382px;">
									<a href="/po/fb/eob/FBEOB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img2.jpg" alt=""> <strong>외식사업</strong>

										고품격 공간과 다양한 서비스로 외식문화의 <br>새로운 경험과 가치를 창조합니다.
									</a>
								</div>
								<div class="intro_business slick-slide slick-cloned"
									data-slick-index="8" aria-hidden="true" tabindex="-1"
									style="width: 382px;">
									<a href="/po/fb/rtb/FBRTB01L.hgc" tabindex="-1"> <img
										src="image/main/intro_img3.jpg" alt=""> <strong>리테일사업</strong>

										품질 좋고 믿을 수 있는 상품을 제공하며 <br>쇼핑과 앞선 라이프 스타일을 제안합니다.
									</a>
								</div>
							</div>
						</div>




						<button type="button" data-role="none"
							class="slick-next slick-arrow" aria-label="Next" role="button"
							style="display: block;">다음</button>
						<ul class="slick-dots" style="display: block;" role="tablist">
							<li class="slick-active" aria-hidden="false" role="presentation"
								aria-selected="true" aria-controls="navigation10"
								id="slick-slide10"><button type="button" data-role="none"
									role="button" tabindex="0">1</button></li>
							<li aria-hidden="true" role="presentation" aria-selected="false"
								aria-controls="navigation11" id="slick-slide11"><button
									type="button" data-role="none" role="button" tabindex="0">2</button></li>
						</ul>
					</div>
					<!-- //introduction slide -->
				</div>
				<!-- //introduction -->

				<!-- our brand story -->
				<div class="brand_story_area">
					<div class="cont_center">
						<h2>
							<img src="image/main/title_our.png" alt="Our Brand Story">
						</h2>

						<ul class="clear m_brand_list">
							<li><a href="/po/bs/fds/BSFDS02C.hgc"> <strong><img
										src="image/main/story_icon1.png" alt="건강식"></strong></a> 내 몸에 안녕한
								건강하고 맛있는 건강식 브랜드</li>
							<li><a href="/po/bs/fds/BSFDS02C.hgc"> <strong><img
										src="image/main/story_icon2.png" alt="친환경"></strong></a> 우수산지와 지정농장을
								통해 연중 신선한 상품을 공급하는 친환경 브랜드</li>
							<li><a href="/po/bs/fds/BSFDS02C.hgc"> <strong><img
										src="image/main/story_icon3.png" alt="외식"></strong></a> 뛰어난 맛과 분위기로
								새로운 경험과 가치를 창조하는 외식 브랜드</li>
							<li><a href="/po/bs/fds/BSFDS02C.hgc"> <strong><img
										src="image/main/story_icon4.png" alt="상품"></strong></a> 독자적인 기술과 엄격한
								품질 관리로 만드는 상품 브랜드</li>
							<li><a href="/po/bs/fds/BSFDS02C.hgc"> <strong><img
										src="image/main/story_icon5.png" alt="마켓"></strong></a> 차별화되고 특화된 고객
								맞춤형 리테일 브랜드</li>
						</ul>
					</div>
				</div>


				<script type="text/javascript">
					$(document).ready(function() {
						/* header */
						var wrap = $('.wrap');
						if (wrap.length > 0) {
							var iTop = wrap.offset().top;
							$(window).scroll(function() {
								if ($(this).scrollTop() > iTop) {
									wrap.removeClass("wrap_main");
								} else {
									wrap.addClass("wrap_main");
								}
							}).scroll();
						}
						/* //header */

						$(".main_video_area").on("init", function(ev, el) {
							$("video").each(function() {
								this.play();
							});
						});

						$(".main_video_area").slick({
							dots : false,
							infinite : true,
							slidesToShow : 1,
							slidesToScroll : 1,
							arrows : false,
							autoplay : true,
							autoplaySpeed : 7000,
							fade : true,
							cssEase : 'linear'
						});

						$(".intro_slide_area").slick({
							dots : true,
							infinite : true,
							slidesToShow : 3,
							slidesToScroll : 3,
							responsive : [ {
								breakpoint : 600,
								settings : {
									slidesToShow : 2,
									slidesToScroll : 2
								}
							} ]
						});

						$(".brand_site_slide").slick({
							dots : true,
							infinite : true,
							slidesToShow : 3,
							slidesToScroll : 3,
							responsive : [ {
								breakpoint : 600,
								settings : {
									slidesToShow : 2,
									slidesToScroll : 2
								}
							} ]
						});
					});

					initPage = (function() {

						GetTopNotice();

						//StartMainBanner();
						/* setInterval(function(){
						    RollingMainBanner();
						}, 5000); */

						$(".business_brand_link > li > a")
								.click(
										function(e) {
											var mainidx = $(
													".business_brand_link > li")
													.index($(this).parent("li"));
											if (mainidx == 0) {
												$(".business_brand_link > li")
														.eq(0)
														.addClass(
																"business_info_on");
												$(".business_brand_link > li")
														.eq(0)
														.removeClass(
																"business_info");

												$(".business_brand_link > li")
														.eq(1).addClass(
																"brand_talk");
												$(".business_brand_link > li")
														.eq(1)
														.removeClass(
																"brand_talk_on");

												$("#ie8Img")
														.attr("src",
																"image/main/main_banner2.jpg");
											} else {
												$(".business_brand_link > li")
														.eq(0)
														.removeClass(
																"business_info_on");
												$(".business_brand_link > li")
														.eq(0)
														.addClass(
																"business_info");

												$(".business_brand_link > li")
														.eq(1).removeClass(
																"brand_talk");
												$(".business_brand_link > li")
														.eq(1)
														.addClass(
																"brand_talk_on");

												$("#ie8Img")
														.attr("src",
																"image/main/main_banner1.jpg");
											}
											$("div.m_business_info").hide();
											$("div.m_business_info")
													.eq(mainidx).show();
											e.preventDefault();
											return false;
										});

					});

					function GetTopNotice() {
						var _url = "/po/pr/ntn/PRNTN01L_AJAX.hg";
						var _dat = {};
						_dat.page = 1;
						_dat.pagesize = 1;
						_dat.bbsClsCd = "30";
						_dat.CmRi = "Ri";
						_dat.notStDe = getToday();

						if (__debug)
							alert(JSON.stringify(_dat));

						setAjax(_url, _dat, GetTopNoticeResult);
					}

					function GetTopNoticeResult(returnData) {
						if (__debug)
							alert(JSON.stringify(returnData));
						//TopNoticeCnt = returnData.json.count;
						//TopNoticeData = returnData.json.list;
						if (!returnData)
							return;

						if (returnData.json.count == 0) {
							//alert('<strong>추천채용 입사지원을 위한 정보</strong>가 일치하지 않습니다.<br />다시 확인 후 정보를 입력해주세요.', '입사지원하기');
						} else {
							var donotshow = $.cookie('HDGF_TOP_NOTICE_'
									+ returnData.json.list[0].bbsSqPk);
							//alert(donotshow);
							if (donotshow == "Y")
								return;

							$("#divTopNotice").html(
									(returnData.json.list[0].blltnsDesc
											.replace(/\n/g, "<br />")));
							//$("#aTopNotice").attr("href", "/po/pr/ntn/PRNTN04V.hg?bbsSqPk=" + returnData.json.list[0].bbsSqPk);
							if (returnData.json.list[0].source)
								$("#aTopNotice").attr("href",
										returnData.json.list[0].source);
							else
								$(".btn_detail").hide();

							if (returnData.json.list[0].fixYn == 1)
								$("#aTopNotice").attr("target", "_blank");

							$("#no_today")
									.click(
											function(e) {
												DoNotShowTopNotice(returnData.json.list[0].bbsSqPk);
											});
							$("#topNoticeArea").show();
						}
					}

					function DoNotShowTopNotice(bbsSqPk) {
						$.cookie('HDGF_TOP_NOTICE_' + bbsSqPk, 'Y', {
							expires : 1,
							path : '/'
						});
						$('#topNoticeArea').hide();
					}

					/* var mainBannerIdx = 0;
					 var mainBannerRolling = true;
					 function RollingMainBanner()
					 {
					 if(!mainBannerRolling) return;
					
					 $("#ie8Img").attr("src", "image/main/main_banner" + (mainBannerIdx + 1) + ".jpg");
					 mainBannerIdx = (++mainBannerIdx) % 2;
					 }

					 function SetMainBanner(rolling)
					 {
					 mainBannerRolling = rolling;
					
					 if(mainBannerRolling)
					 {
					 $("#btnMainBannerStart").hide();	
					 $("#btnMainBannerStop").show();   
					 }
					 else
					 {
					 $("#btnMainBannerStart").show(); 
					 $("#btnMainBannerStop").hide();   
					 }
					 } */
				</script>



				<!-- contents : end -->

			</div>
		</div>
		<!--  <div class="video">
        
        <video width="100%" height="auto" autoplay muted loop>
            <source src="video/1_cooking_dark.mp4" type="video/mp4">
        </video>  
    </div> -->
    <script>
           const header = document.querySelector('.header');
           const logo = document.querySelector('.logo > a');
           const mainmenu = document.querySelectorAll('.main_menu');
           
           
           const menuHover = document.querySelectorAll('.gnb > li');
           
           window.addEventListener("scroll", () => {
              if (window.scrollY > 0) {
                 header.setAttribute("style", "background: white;");
                 //logoImg.src = "./image/logo.png";
                 logo.setAttribute("style", "background: url(./image/header/logo.png); background-size: 100%");
                 mainmenu.forEach(function(menu) {
                    menu.setAttribute("style", "color: black;");
                 });
                 
                 menuHover.forEach(function(hover) {
                    hover.addEventListener('mouseover', function(event){
                    hover.setAttribute("style", "border-bottom: 5px solid #456459;");
                    });
                    hover.addEventListener('mouseout', function(event){
                       hover.setAttribute("style", "border: none;");
                    });
                 });
              }
                 
              else {
                 header.setAttribute("style", "background: transparent;");
              
                 logo.setAttribute("style", "background: url(./image/header/logo_main_top.png); background-size: 100%");
                 mainmenu.forEach(function(menu) {
                    menu.setAttribute("style", "color: white;");
                 });
                 
                 menuHover.forEach(function(hover) {
                    hover.addEventListener('mouseover', function(event){
                    hover.setAttribute("style", "border-bottom: 5px solid white;");
                    });
                    
                    hover.addEventListener('mouseout', function(event){
                       hover.setAttribute("style", "border: none;");
                    });
                 });
              }   
           })
    </script>



		<%@include file="../container/footer.jsp"%>
</body>
</html>

