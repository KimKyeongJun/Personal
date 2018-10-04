<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/PersonalProject/css/layout.css" />
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$(".qnaLink").click(function() {
			var password = prompt("비밀번호를 입력하세요");
			if ( password != $(this).closest(".contentWrapper").children(".qnaPassword").text() ) {
				alert("비밀번호를 확인하세요!");
				location.href="/PersonalProject/qna/qna"
			}
			else {
				var qnaId = $(this).closest(".contentWrapper").children(".qnaId").text();
				alert(qnaId);
				location.href="/PersonalProject/qna/detail?qnaId="+qnaId;
			}
			//alert( $(this).closest(".contentWrapper").children(".qnaPassword").text() );
		});
	});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
		<div style="text-align: center;">
			<span><a href="/PersonalProject/notice/notice">공지사항</a></span> <span>QnA</span>
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
	         	<div class="qnaPassword" style="display: none;">${qna.password}</div>
	         	<div class="qnaId" style="display: none;">${qna.qnaId}</div>
	            <div class="number box">${qna.qnaRowNum}</div><!-- 
	            --><div class="subject box"><span class="qnaLink">${qna.subject}</span></div><!-- 
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
      
      <div class="padded">
      	<form id="searchForm" onsubmit="javascript:movePage(0);">
      		${pagenation}
      		<div>
      			<input type="text" name="searchKeyword" value="${qnaSearchVO.searchKeyword}" placeholder="작성자">
      			<a href="/PersonalProject/qna/init">검색 초기화</a>
      		</div>
      	</form>
      </div>
		<div>
			<a href="/PersonalProject/qna/regist">글 작성</a>
		</div>
	
</body>
</html>