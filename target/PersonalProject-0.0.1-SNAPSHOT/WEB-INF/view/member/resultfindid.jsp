<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<h1>회원님의 아이디는 ${findId}입니다.</h1>
	<a href="/PersonalProject/member/login">로그인</a>

</body>
</html>