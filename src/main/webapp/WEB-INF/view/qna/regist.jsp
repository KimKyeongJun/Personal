<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#registBtn").click(function() {
			$.post("/PersonalProject/qna/regist"
					, $("#registForm").serialize()
					, function(response) {
						if ( response.success ) {
							alert("등록되었습니다.");
							location.href="/PersonalProject/qna/qna"
						}
						else {
							alert("등록이 되지 않았습니다");
						}
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />

	<div>
		<form id="registForm">
			<div>
				<input type="text" id="writer" name="writer" placeholder="글쓴이" />
			</div>
			<div>
				<input type="password" id="password" name="password" placeholder="비밀번호" />
			</div>
			<div>
				<input type="text" id="subject" name="subject" placeholder="제목" />
			</div>
			<div>
				<textarea id="content" name="content" placeholder="내용"></textarea>
			</div>
			<div>
				<span><input type="radio" name="isVisible" value="Y">공개</span>
				<span><input type="radio" name="isVisible" value="N">비공개</span>
			</div>		
			<div>
				<input type="button" id="registBtn" value="등록" />
			</div>				
		</form>
	</div>

</body>
</html>