<!-- 작업자: 신동근 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외식사업</title>
<link rel="stylesheet" type="text/css" href="css/SubLayout.css?after">

<%
//작성자 : 이승연
//jsp에 방문 했을 때, session_id값 가져오기 (로그인 유무 확인)
String session_id =(String)session.getAttribute("id");
if (session_id == null && application.getAttribute("result") =="1"){//로그인 안했을 때도 일반 유저가 jsp 파일에 접근 가능하게 로직 완료
   PrintWriter script=response.getWriter();
   script.println("<script>");
   script.println("alert('로그인이 해제되었습니다.')");
   script.println("location.href='index.jsp'");
   script.println("</script>");
}
%>

<% if(session_id == null) {
%>
<%@include file="../container/Header.jsp"  %>
<%
} else {
%>
<%@include file="../container/AfterLoginHeader.jsp"  %>
<%
} 
%>
</head>
<body>
	<div class="container_area" id="contents">
		<div class=""container">
			<!-- 상단 비쥬얼 -->
			<p class="visual_business eatout" style="transform: translate(0px, 0px);"></p>
			<h2 class="title_business">
				외식사업
			</h2>
			<p class="description_business">
				“현대그린푸드는 업계를 선도하는 외식문화 큐레이터로
				<br>
				 만족스러운 한 끼의 식사 그 이상을 제공하기 위해 노력합니다”
			</p>
			<div class="business_info business_info_eatout">
				<ul class="clear cont_center business_info_list">
					<li>
						<img src="image/business/icon_eatout1.png" alt="">
						<strong>
							<span class="count_num">1985</span>년
						</strong>
						외식사업 진출
						<br>
						(한솔냉면)
					</li>
					<li>
						<img src="image/business/icon_eatout2.png" alt="">
						<strong>
							<span class="count_num">21</span>개
						</strong>
						보유 브랜드
					</li>
					<li>
						<img src="image/business/icon_eatout3.png" alt="">
						<strong>
							<span class="count_num">150</span>명
						</strong>
						전문셰프
					</li>
					<li>
						<img src="image/business/icon_eatout4.png" alt="">
						<strong>
							<span class="count_num">67</span>개
						</strong>
						운영 매장 수
					</li>
				</ul>
			</div>
			<div class="global_brand_area_joe_eataly">
				<h3 class="cont_center title_eatout2"></h3>
				<ul class="clear cont_center food_distri_list">
					<li>
						<div class="meal_area">
							<h3 class="title_business_sub">
								Eataly is Italy ! 
								<br>
								이탈리아 프리미엄 식품 브랜드 
								<br>
								이탈리(EATALY)
							</h3>
							<p class="description_business_sub">	
							 2007년 이탈리아 토리노에서 시작한 이탈리(EATALY)는 이탈리아 프리미엄 식품 브랜드입니다. Eataly is Italy ! (이탈리는 이탈리아 그 자체) 라는 슬로건 아래 현재 미국, 일본, 터키 및 UAE에 진출, 정통 이탈리아의 음식과 식사의 즐거움을 전파하고 있습니다. 
							 Eat better, Live better. 
							 웰빙을 적합한 가격에 대중 모두가 누릴 수 있도록 한다는 목표 아래 마켓과 레스토랑이 한곳에 어우러져 식자재 구입은 물론, 마켓에서 판매하고 있는 식재료로 만든 요리까지 한 공간에서 즐길 수 있는 그로서란트형 매장으로 구성되어 있습니다.
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ현대백화점 판교점 지하 1층(031.5170.1061)</dd>
							</dl>
						</div>
					</li>
					<li>
						<div class="meal_area">
							<h3 class="title_business_sub">
								No syrup, No sugar, No water !  
								<br>
								덴마크 프리미엄 주스바 
								<br>
								조앤더주스
							</h3>
							<p class="description_business_sub">
								조앤더주스는 덴마크 사람들의 라이프 스타일 ‘후거(hygge)’를 충실히 따르고 있는 건강 주스&커피 브랜드입니다. 
								건강한 삶을 위한 사람들에게 최적의 솔루션을 제공하는 조앤더주스는 인공 시럽을 사용하지 않는 주스를 만들고 로컬푸드 원재료를 사용한 샌드위치 등 북유럽의 건강한 식문화를 그대로 담고 있습니다. 
								주문 후 직접 과일을 블렌딩한 착즙 주스와 신나는 음악과 에너지가 충만한 분위기, Juicer 들의 퍼포먼스 등 액티브한 조앤더주스를 만끽해 보세요.
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ현대백화점 판교/목동/천호/킨텍스/대구점</dd>
								<dd>ㆍ현대아울렛 동대문/송도점</dd>
								<dd>ㆍ교보문고 광화문/코엑스 파르나스몰/용산 아이파크몰</dd>
							</dl>
						</div>
						
					</li>
				</ul>
			</div>
			<div class="global_brand_area2">
				<h3 class="cont_center title_eatout2">
				
				</h3>
				<ul class="clear cont_center food_distri_list">
					<li>
						<div class="meal_area">
							<h3 class="title_business_sub">
								Legendary Food, Legendary Service
								<br>
								Texas Roadhouse
							</h3>
							<p class="description_business_sub">
								텍사스 로드하우스는 현재 미국인들에게 가장 사랑받고 있는 스테이크 하우스입니다. 
								1993년 미국 인디애나주에서 첫 매장을 오픈한 텍사스 로드하우스는 단순히 스테이크 만을 판매하는 레스토랑이 아닌 모든 연령대의 사람들이 적합한 가격과 훌륭한 식사를 경험할 수 있는 가족같은 분위기의 미국식 캐주얼 다이닝 레스토랑입니다. 
								현재 미국에서 600여개 매장을 운영하고 있으며, 멕시코, 대만, 필리핀, 중동지역에도 오픈하였고, 2019년에는 한국에 새롭게 오픈하였습니다.
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ평택 미군부대(Camp Humphreys)</dd>
							</dl>
						</div>
					</li>
					<li>
						<div class="meal_area">
							<h3 class="title_business_sub">
								 140 YEARS OF CHOCOLATE ARTISTRY	
								 <br>
								 Venchi
							</h3>
							<p class="description_business_sub">
								벤키(Venchi)는 1878년 시작되어 140년 전통을 자랑하는 이탈리아 대표 초콜릿 브랜드입니다. 
								과거에는 이탈리아 왕실에서 납품하던 초콜릿 브랜드로 최고급 품질 재료만을 사용하며, 트랜스 지방, 인공 색소, 방부제, 버터 등이 들어가지 않는 것이 대표적인 특징입니다. 
								현재 벤키 매장은 이탈리아와 한국뿐만 아니라, 런던, 홍콩, 뉴욕 등 전 세계 100여개의 매장에서 사랑받고 있습니다.
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ현대백화점 판교점</dd>
								<dd>ㆍ송도아울렛</dd>
							</dl>
						</div>
					</li>
				</ul>
			</div>
			<div class="food_court_area2">
				<h3 class="cont_center title_eatout">
					푸드코트&캐쥬얼다이닝 
					<span>Food Court & Casual Dining</span>
				</h3>
				<ul class="clear meal_list">
					<li class="f">
						<div class="meal_area">
							<h3 class="title_business_sub">
								현대백화점 Select-Dining 
								<br>
								프리미엄 푸드코트 h’_Kitchen
							</h3>
							<p class="description_business_sub">
							 	제철 식재와 지역 향토메뉴를 스토리로 풀어내는 에이치키친은 현대백화점 프리미엄 푸드코트 브랜드 입니다. 
							 	한식, 중식, 일식, 양식 각 분야에서 경력과 전문성을 인정받은 셰프들이 개발한 메뉴를 모던하고 세련된 인테리어의 매장에서 제공합니다. 
							 	전주선비빔, 건강밥상, 온드린 등 한국인이 가장 좋아하는 한식 전문 브랜드부터, 찹쌀탕수육이 맛있는 중식 브랜드 메이루, 고봉밥처럼 푸짐한 양배추 샐러드를 자랑하는 일본식 한상차림 캬베츠닷뿌리 등. 
							 	독자적인 유명 외식브랜드를 한 곳에 모아놓은 Select-Dining 형태의 에이치키친 은 다시 방문하고 싶은 맛집같은 프리미엄 푸드코트입니다. 
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ현대백화점 대구/ 목동/ 무역/ 미아/ 신촌/ 울산/ 중동/ 충청/ 판교점</dd>
								<dd>ㆍ현대아울렛 김포/동대문점</dd>
								<dd>ㆍ교보문고 광화문점</dd>
							</dl>
						</div>
					</li>
					<li class="s">
						<div class="meal_area">
							<h3 class="title_business_sub">
								사시사철 늘 한결 같은 
								<br>
								장인의 손 맛, 한솔냉면
							</h3>
							<p class="description_business_sub">
								한솔냉면은 현대백화점의 대표 냉면 브랜드로, '한솔'은 언제나 한결 같이 늘 푸른 소나무를 의미합니다. 
								한식 명인 신덕용 기술고문이 개발한 한솔냉면은 1985년 현대백화점 압구정 본점 오픈과 함께 시작했습니다. 
								시원한 매실동치미와 진한 소고기 육수에 얼갈이 김치가 어우러진 그 고유의 맛을 인정받아, 현재는 현대백화점을 넘어 미국 LA 마당몰, 캘리포니아 토렌스 H-MART에 입점하며 세계인이 찾는 글로벌 냉면 맛집으로 알려져 있습니다.
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ현대백화점 압구정본점/ 무역/ 천호/ 신촌/ 미아/ 목동/ 중동/킨텍스/ 울산/ 동구/ 대구/ 충청/ 판교점 </dd>
								<dd>ㆍ현대아울렛 김포/ 동대문점/ 송도/ 가든파이브점</dd>
								<dd>ㆍ교보문고 광화문점/ 미국 LA 마당몰/ 미국 CA 토렌스 H-MART</dd>
							</dl>
						</div>
					</li>
					<li class="t">
						<div class="meal_area">
							<h3 class="title_business_sub">
								전통 일본식 회전초밥 전문점, 
								<br>
								본가스시
							</h3>
							<p class="description_business_sub">
							 	본가스시는 현대백화점 대표 회전초밥 브랜드입니다. 
							 	2015국제스시대회 대한민국 대표 출신 한대원 셰프가 총괄을 맡고 있으며, 전국 산지에서 공수한 식재를 바탕으로 가장 신선한 초밥을 즉석에서 만들어 제공합니다. 
							 	신선한 활어와 제철 식재를 이용한 시즌별 메뉴를 꾸준히 선보이고 있으며 전통 일본식 레시피와 조리 스타일을 고수하여 가장 맛있는 스시를 제공하기 위해 항상 연구합니다.
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ현대백화점 압구정본점/ 무역/ 천호/ 신촌/ 미아/ 목동/ 중동/ 킨텍스/ 울산/ 충청/ 판교/ 디큐브/ 대구점 (부산점, 동구점 제외 전점)</dd>
								<dd>ㆍ현대아울렛 가든파이브/ 송도점</dd>
								<dd>ㆍ교보문고 광화문점</dd>
							</dl>
						</div>
					</li>
				</ul>
			</div>
			<div class="fine_dining_area">
				<h3 class="cont_center title_eatout">
					파인다이닝
					<span>Fine dining</span>
					
				</h3>
				<ul class="clear cont_center food_distri_list">
					<li>
						<div class="meal_area">
							<h4 class="title_business_sub">고품격 프렌치 비스트로<br>h’_450</h4>
							<p class="description_business_sub">
								h'450은 정원을 산책하는 가벼운 마음으로 즐겁게 맛있는 음식을 즐길 수 있는 프렌치 파인다이닝 레스토랑 입니다. 프랑스 르 꼬르동블루 출신 김형석 셰프를 중심으로 신선한 식재를 엄선하여, 건강하면서도 맛있는 음식을 요리합니다. 모던하면서 고급스러운 인테리어로 아늑한 공간을 제공하며 화덕피자와 매장에서 매일 아침 직접 만드는 시그니쳐 메뉴 스콘과 다양한 종류의 파스타 및 스테이크를 제공합니다.  또한, 서브 브랜드 스몰플레이트 h’_450는 h’_450의 유명 시그니처 메뉴들을 보다 캐쥬얼하게 즐기실 수 있습니다. 
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍh’450 압구정동 450번지 현대백화점 토파즈홀</dd>
								<dd>ㆍh’541 현대백화점 판교점</dd>
								<dd>ㆍh’123 현대프리미엄아울렛 송도점</dd>
								<dd>ㆍ스몰플레이트 h’_450 현대백화점 대구/ 현대아울렛 가든파이브점</dd>
							</dl>
						</div>
					</li>
					<li>
						<div class="meal_area">
							<h4 class="title_business_sub">쉐라톤서울팔래스강남호텔 <br>올데이 다이닝 뷔페 <br>h’_Garden</h4>

							<p class="description_business_sub">
								 에이치가든은 쉐라톤 서울 팔래스 강남호텔의 All Day Dining 뷔페 레스토랑입니다. 특급호텔 출신의 전문 셰프들의 제철 식재료를 활용한 시즌메뉴를 비롯한 세계 각국의 다양한 뷔페 메뉴, 일품 요리를 품격 있는 서비스와 함께 제공합니다. 특별한 날, 기념하고 싶은 날 에이치가든에서 최고의 다이닝 서비스를 경험하실 수 있습니다.
							</p>

							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ쉐라톤 서울팔래스 강남호텔 1층 h’_Garden (02.2186.6885) </dd>
							</dl>
						</div>
					</li>
				</ul>
			</div>
			<div class="fine_dining_area catering_area">
				<h3 class="cont_center title_eatout">
					베이커리&케이터링
					<span>Bakery&Catering</span>
				</h3>
				<ul class="clear cont_center food_distri_list">
					<li>
						<div class="meal_area">
							<h4 class="title_business_sub">
								기본을 제대로 하는 빵, 
								<br>현대백화점 프리미엄 베이커리 … 
								<br>베즐리
							</h4>
							<p class="description_business_sub">
								기본을 제대로 하는 베이커리, 베즐리는 까다롭게 엄선된 원재료로 매일 현장에서 직접 구워내는 원칙을 지키는 프리미엄 베이커리 브랜드입니다. 
								만드는 과정이 어렵고 힘들지만 기본을 지키면서 제대로 만드는데 집중합니다. 
								베즐리의 유럽건강빵은 밀, 물, 소금, 건강한 곡물에 발효종을 넣어 밑반죽을 하고 하루를 숙성시켜 다시 반죽하는 유럽 정통 풀리쉬법(Poolish)으로, 식빵은 끓는 물로 반죽하여 숙성시키는 탕종(湯種)법을 고집합니다. 
								아울러 트렌드를 반영한 다양한 신제품을 연구하며, 제철 국산 원재료를 이용한 시즌 상품으로 고객에게 새로운 감동을 드리기 위해 노력하고 있습니다. 
								또한, 계절을 느낄 수 있는 음료와 매장에서 매일 직접 구워내는 베이커리를 베이커리 카페 h’_Oven에서도 즐기 실 수 있습니다.
							</p>
							<dl class="enter_store">
								<dt>입점위치</dt>
								<dd>ㆍ베즐리 현대백화점 압구정본점/ 무역/ 천호/ 신촌/ 미아/ 목동/ 중동/ <br>킨텍스/ 대구/ 판교 </dd>
								<dd>ㆍ현대아울렛 송도점</dd>
								<dd>ㆍh’_Oven 현대시티몰 가든파이브점 에이치오븐</dd>
							</dl>
						</div>
					</li>
					<li>
						<div class="meal_area">
							<h4 class="title_business_sub">
								셰프들이 펼치는 오케스트라, 
								<br>아르드셰프(Art de Chef)
								</h4>
							<p class="description_business_sub">
								 아르드셰프 (Art de Chef)는 프랑스어로 ‘요리사가 펼치는 예술’을 의미합니다. 
								 고객의 앞선 라이프스타일을 위한 고품격 케이터링 서비스 ‘아르드셰프’는 단순 출장 연회가 아닌 음식 그 이상의 감동을 선사합니다. 
								 2013 인천 실내 무도게임대회에서 글로벌 맞춤 식단을 제공했던 경험을 바탕으로, 2014년에는 할리우드 블록버스터 어벤져스 2 국내 촬영 당시 공식 케이터링 협력사로 선정되었습니다.
								 <br> 프라이빗한 소규모 행사부터 수천명 이상의 대규모 행사까지, 고객의 다양한 이벤트별 맞춤 메뉴를 제공하며 전문 푸드스타일리스트가 함께 하여 행사의 품격을 높여 드립니다.
							</p>

							<p class="call">문의전화 : 031-525-2173~6</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready( function(){
				$('.count_num').counterUp({
					delay: 10,
					time: 200
				});
			});
		</script>
	</div>
	 <%=session_id %>님 환영합니다!</a> 
	 session 값 : <%=session_id %>
	 application 값 : <%=application.getAttribute("result") %>
	 <%@include file="../container/footer.jsp"%>
</body>
</html>