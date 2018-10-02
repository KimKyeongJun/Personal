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

	<div>
		<div>
			<input type="text" id="subject" name="subject" placeholder="제목" />
		</div>
		<div>
			<textarea id="content" name="content" placeholder="내용"></textarea>
		</div>
		<div>
			<input type="button" id="registBtn" value="등록" />
		</div>
	</div>

</body>
</html>