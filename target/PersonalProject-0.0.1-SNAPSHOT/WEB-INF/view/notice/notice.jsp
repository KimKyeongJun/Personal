<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/PersonalProject/css/layout.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<div style="text-align: center;">
		<span>공지사항</span>
		<span><a href="/PersonalProject/qna/qna">QnA</a></span>
	</div>
	<div id="wrapper">
      <div id="headerWrapper">
         <div class="number header box">글 번호</div><!-- 
          --><div class="subject header box">제목</div><!-- 
          --><div class="writer header box">작성자</div><!-- 
          --><div class="create-date header box">작성일</div>
      </div>
      <c:choose>
      	<c:when test="${not empty noticeList}">
	      <c:forEach items="${noticeList}" var="notice">
	         <div class="contentWrapper">
	            <div class="number box">${notice.rowNum}</div><!-- 
	            --><div class="subject box"><a href="/PersonalProject/notice/detail/${notice.noticeId}">${notice.subject}</a></div><!-- 
	            --><div class="writer box">${notice.memberVO.name}</div><!-- 
	             --><div class="create-date box">${notice.crtDt}</div>
	         </div>
	      </c:forEach>
	    </c:when>
	    <c:otherwise>
		      <div id="no-articles">
		      	등록된 게시글이 없습니다.
		      </div> 
	    </c:otherwise>     
      </c:choose>
      </div>	
	<div>
		<a href="/PersonalProject/notice/regist">글 작성</a>
	</div>
</body>
</html>