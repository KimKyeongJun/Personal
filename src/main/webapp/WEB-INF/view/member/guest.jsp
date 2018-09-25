<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script>
</script>
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/menu.jsp" />

	<div>
		<span><a href="/PersonalProject/member/login">회원 로그인</a></span>
		<span>비회원 로그인</span>
	</div>

	<form id="guestForm">
		<div>
			<input type="text" id="name" name="name" placeholder="이름" />
		</div>
		<div>
			<input type="text" id="phone" name="phone"
				placeholder="전화번호" />
		</div>
		<div>
			<input type="button" id="guestBtn" value="등록" />
		</div>
	</form>

</body>
</html>