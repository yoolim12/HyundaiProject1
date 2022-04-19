<!-- 작성자: 최유림 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="DAO.DBDAO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review Chart</title>
<% 
	DBDAO db = new DBDAO();	// DBDAO 생성자 생성
    List<Integer> list = db.ReviewCountList(); 	// 리스트 객체 생성 및 저장
%>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

        // 차트 버전을 최신으로 불러오기
        google.charts.load('current', { 'packages': ['corechart'] });

        // 차트를 로드하기
        google.charts.setOnLoadCallback(drawVisualization);
		
        var list = <%= list %>;
        console.log(list);
        // drawVisualization 함수 속에 차트에 들어갈 데이터 setting
        function drawVisualization() {
            var data = google.visualization.arrayToDataTable([
                ['category', 'count'],
                ['칭찬', list[0]], // 임의로 넣은 칭찬 개수
                ['불만', list[1]], // 임의로 넣은 불만 개수
                ['제안', list[2]], // 임의로 넣은 제안 개수
                ['기타', list[3]] // 임의로 넣은 기타 개수
            ]);

            // 옵션 세팅
            var options = {
                title: '리뷰 차트'
            };

            // 차트 그리기. div 객체에 맵핑시켜서 차트를 만들어준다. ComboChart 부분을 변경해줌으로써 차트 모양을 변경할 수 있다.
            var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
	<div id="chart_div" style="width:900px; height: 500px;"></div>
</body>
</html>