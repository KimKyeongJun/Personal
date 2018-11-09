<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/PersonalProject/css/layout.css" />
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<s:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin"></s:authorize>
<script type="text/javascript">
	$().ready(function() {
		$(".qnaLink").click(function() {
			var qnaId = $(this).closest(".contentWrapper").children(".qnaId").text();
			if ( $(this).closest(".contentWrapper").children(".isVisible").text() == "Y" ) {
				location.href="/PersonalProject/qna/detail?qnaId="+qnaId;
			}
			else {
				if ( ${isAdmin} == true ){
					location.href="/PersonalProject/qna/detail?qnaId="+qnaId;
				}
				else{
					window.open("/PersonalProject/qna/password?qnaId="+qnaId,'상세','width=500, height=250, left=400, top=350, toolbar=no, status=no, scrollbars=yes');
				}
			}
});
	});
</script>
<style>
.qnaLink:hover {
    color: #999;
    text-decoration: underline;
  }
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<div style=" top: 10%; left: 25%; width: 900px; position:relative">	
		<div style="text-align: center; padding-bottom: 50px; padding-top: 30px;">
			<span><a href="/PersonalProject/notice/notice" style="text-decoration: none; color: #00008b; font-weight: bold;">공지사항 </a></span>
			<span style="color: #00008b; font-weight: bold;"> | QnA</span>
		</div>
		
		<div id="wrapper">
      <div id="headerWrapper">
         <div class="number header box">글 번호</div><!-- 
          --><div class="subject header box">제목</div><!-- 
          --><div class="writer header box">작성자</div><!-- 
          --><div class="create-date header box">작성일</div>
      </div>
      <c:choose>
      	<c:when test="${not empty qnaList}">
	      <c:forEach items="${qnaList}" var="qna">
	         <div class="contentWrapper">
	         	<div class="isVisible" style="display: none;">${qna.isVisible}</div>
	         	<div class="qnaId" style="display: none;">${qna.qnaId}</div>
	            <div class="number box">${qna.qnaRowNum}</div><!-- 
	            --><div class="subject box"><span class="qnaLink">${qna.subject}<c:if test="${qna.isVisible eq 'N'}"><img src="/PersonalProject/img/lock.png" width="20px"height="20px"></c:if></span></div><!-- 
	            --><div class="writer box">${qna.writer}</div><!-- 
	             --><div class="create-date box">${qna.crtDt}</div>
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
      <div class="padded" style="text-align:center">
      	<form id="searchForm" onsubmit="javascript:movePage(0);">
      		${pagenation}
      		<div>
      			<input type="text" name="searchKeyword" value="${qnaSearchVO.searchKeyword}" placeholder="작성자">
      			<a href="/PersonalProject/qna/init" style="padding-right: 20px; font-weight: bold; color: #00008b; text-decoration: none;">검색 초기화</a>
      		</div>
      	</form>
      </div>
		<div style="text-align:right; padding-top: 15px;">
			<a href="/PersonalProject/qna/regist" style="padding-right: 20px; font-weight: bold; color: #00008b; text-decoration: none;">글 작성</a>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>