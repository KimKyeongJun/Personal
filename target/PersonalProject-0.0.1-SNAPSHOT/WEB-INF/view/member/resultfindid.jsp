<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.button {
	width: 150px;
	background-color:#2056ac; 
	color: #FFF; 
	border:none; 
	border-radius:10px;
	font-size: 15px;
    margin: 4px;
}
</style>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="position:relative; top: 20%; left: 30%; width:600px; text-align:center;">
		<h1>회원님의 아이디는 ${findId}입니다.</h1>
		<input type="button" class="button" value="로그인" onclick="window.location.href='/PersonalProject/member/login'" />
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>