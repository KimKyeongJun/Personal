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
		<h1>${notice.subject}</h1>
		<div><span>${notice.memberVO.name}</span><span>${notice.crtDt}</span></div>
		<div>${notice.content}</div>
	</div>
</body>
</html>