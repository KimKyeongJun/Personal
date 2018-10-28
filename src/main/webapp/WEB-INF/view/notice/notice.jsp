<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.button {
	width: 80px;
	height: 20px;
	color: #00008b; 
	border:none;
	font-size: 15px;
    margin: 4px;
    font-weight: bold;
    background-color: #fff;
}
</style>
<link rel="stylesheet" type="text/css"
	href="/PersonalProject/css/layout.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<div style=" top: 10%; left: 25%; width: 900px; position:relative">
		<div style="text-align: center; padding-bottom: 50px; padding-top: 30px;">
			<span style="color: #00008b; font-weight: bold;">공지사항 | </span>
			<span><a href="/PersonalProject/qna/qna" style="text-decoration: none; color: #00008b; font-weight: bold;">QnA</a></span>
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
		            --><div class="subject box"><a style="text-decoration:none;" href="/PersonalProject/notice/detail/${notice.noticeId}">${notice.subject}</a></div><!-- 
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
	     <div class="padded" style="text-align: center;">
	      	<form id="searchForm" onsubmit="javascript:movePage(0);">
	      		${pagenation}
	      		<div>
	      			<input type="hidden" name="searchKeyword" value="${qnaSearchVO.searchKeyword}" placeholder="작성자">
	      			<a href="/PersonalProject/qna/init" style="display: none;">검색 초기화</a>
	      		</div>
	      	</form>
      	</div>	
		<div style="text-align:right; padding-top: 15px;">
			<s:authorize access="hasRole('ROLE_ADMIN')">
				<a href="/PersonalProject/notice/regist" style="padding-right: 20px; font-weight: bold; color: #00008b; text-decoration: none;">글 작성</a>
			</s:authorize>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>