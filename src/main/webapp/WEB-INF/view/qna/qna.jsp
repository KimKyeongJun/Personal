<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		 <c:choose>
      	<c:when test="${not empty qnaList}">
	      <c:forEach items="${qnaList}" var="qna">
	         <div class="contentWrapper">
	            <span>${qna.qnaRowNum}</span>
	            <span>${qna.subject}</span>
	            <span>${qna.content}</span>
	            <span>${qna.crtDt}</span>
	            <span>${qna.quaId}</span>
	         </div>
	      </c:forEach>
	    </c:when>
	    <c:otherwise>
		      <div id="no-articles">
		      	등록된 게시글이 없습니다.
		      </div> 
	    </c:otherwise>     
      </c:choose>
		<div>
			<a href="/PersonalProject/qna/regist">글 작성</a>
		</div>
	</div>
</body>
</html>