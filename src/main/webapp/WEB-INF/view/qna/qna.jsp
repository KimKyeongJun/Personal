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
	<div style="text-align: center;">
		<div>
			<span><a href="/PersonalProject/notice/notice">공지사항</a></span>
			<span>QnA</span>
		</div>
		<div>QnA페이지</div>
		<div>
			<a href="/PersonalProject/qna/regist">글 작성</a>
		</div>
	</div>
</body>
</html>