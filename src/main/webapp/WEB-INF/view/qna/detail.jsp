<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							alert("등록완료");
							location.href="/PersonalProject/qna/detail/${qna.qnaId}";
						}
						else {
							alert("등록실패!");
						}
				
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />


	 <div style="text-align: center;">
	 	<div style="border-width: 1px; border-style:solid;">
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
	 <div>
	 	<form id="qnaReplyForm">
	 		<textarea id="content" name="content" placeholder="내용"></textarea>
	 		<input type="button" id="registBtn" value="등록" />
	 		<input type="hidden" id="qnaId" name="qnaId" value="${qna.qnaId}" />
	 		<input type="hidden" id="adminId" name="adminId" value="${sessionScope._USER_.id}" />
	 	</form>
	 </div>
	 <div>
	 	<a href="/PersonalProject/qna/qna">목록</a>
	 </div>

</body>
</html>