<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.button {
	width: 60px;
	background-color:#2056ac; 
	color: #FFF; 
	border:none;
	font-size: 15px;
    margin: 4px;
}
#headDiv {
	text-align:center;
	font-weight:bold;
	font-size:20px;
	padding:50px;
}

.detailDiv {
	border:1px solid #2056ac;
	padding:10px;
	margin: 10px;
}

#contentDiv {
	border:1px solid #2056ac;
	padding:10px;
	margin: 10px;
	height: 350px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<div style="position:relative; top: 5%; left: 30%; width:525px; height:550px;">
		<div>
			<div id="headDiv">공지사항</div>	
			<div class="detailDiv">${notice.subject}</div>
			<div class="detailDiv">${notice.memberVO.name}</div>
			<div class="detailDiv">${notice.crtDt}</div>
			<div id ="contentDiv">${notice.content}</div>			
		</div>
		<div style="text-align:right; padding-right: 10px">
			<button class="button" onclick="window.location.href='/PersonalProject/notice/notice'">목록</button>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>