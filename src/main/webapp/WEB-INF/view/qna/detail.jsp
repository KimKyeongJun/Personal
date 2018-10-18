<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#registBtn").click(function() {
			if( $("#content").val() == "" ) {
				alert("내용을 입력하세요");
				setTimeout( function() { 
					$("#content").focus(); 
					}, 10);
				return;
			}
			
			$.post("/PersonalProject/qna/reply"
					, $("#qnaReplyForm").serialize()
					, function(response) {
						if ( response.regist ) {
							location.href="/PersonalProject/qna/detail?qnaId=${qna.qnaId}";
						}
						else {
							alert("등록실패!");
						}
				
			});
		});
	});
</script>
<style>
.button {
	width: 60px;
	background-color:#2056ac; 
	color: #FFF; 
	border:none;
	font-size: 15px;
    margin: 4px;
}
#headDiv {
	text-align:center;
	font-weight:bold;
	font-size:20px;
	padding:50px;
}

.detailDiv {
	border:1px solid #2056ac;
	padding:10px;
	margin: 10px;
}

#contentDiv {
	border:1px solid #2056ac;
	padding:10px;
	margin: 10px;
	height: 350px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />

	<div style="position:relative; top: 5%; left: 30%; width:525px; height:550px;">
		 <div>
		 	<div id="headDiv">QnA</div>	
			<div class="detailDiv">${qna.subject}</div>
			<div class="detailDiv">${qna.writer}</div>
			<div class="detailDiv">${qna.crtDt}</div>
			<div id ="contentDiv">${qna.content}</div>
		 </div>
		 
		 <div>	 	
		 	<c:choose>
		 		<c:when test="${not empty qnaReplyList}">
		 			<c:forEach items="${qnaReplyList}" var="qnaReply">
		 				<div style="padding-left: 15px;">
		 					<span>${qnaReply.memberVO.name}</span>
		 					<span>${qnaReply.crtDt}</span>
		 				</div>
		 				<div style="padding-left: 35px;">
		 					${qnaReply.content}
		 				</div>
		 			</c:forEach>
		 		</c:when>
		 	</c:choose>
		 </div>
		 <c:if test="${empty qnaReplyList}">
			 <s:authorize access="hasRole('ROLE_ADMIN')">
				 <div>
				 	<form id="qnaReplyForm">
				 		<input type="hidden" id="qnaId" name="qnaId" value="${qna.qnaId}" />
				 		<input type="hidden" id="adminId" name="adminId" value="${sessionScope._USER_.id}" />
				 		<textarea id="content" name="content" placeholder="내용"></textarea>
				 		<input type="button" id="registBtn" value="등록" />
				 	</form>
				 </div>
			 </s:authorize>
		 </c:if>
		 <div style="text-align:right; padding-right: 10px">
			<button class="button" onclick="window.location.href='/PersonalProject/qna/qna'">목록</button>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>