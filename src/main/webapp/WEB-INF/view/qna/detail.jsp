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
	 		<span>제목</span><span>${qna.subject}</span>
	 	</div>
	 	<div>
	 		<span>작성자</span><span>${qna.writer}</span>
	 	</div>
	 	<div>
	 		<span>작성일</span><span>${qna.crtDt}</span>
	 	</div>
	 	<div>
	 		<span>내용</span><span>${qna.content}</span>
	 	</div>	 
	 </div>

</body>
</html>