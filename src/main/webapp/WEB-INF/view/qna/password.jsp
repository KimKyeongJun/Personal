<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 입력</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#confirmBtn").click(function() {
			$.post("/PersonalProject/qna/password"
					, $("#passwordForm").serialize()
					, function(response) {
						if( response.status) {
						opener.parent.location="/PersonalProject/qna/detail?qnaId="+response.qnaId;
						window.close();
					}
					else {
						alert("비밀번호를 확인해주세요.");
					}
			});
		});
	});
</script>
</head>
<body>
	<div style="text-align:center;">
		비밀글 입니다. 비밀번호를 입력해주세요
		<form id="passwordForm">
			<input type="hidden" name="qnaId" id="qnaId" value="${qnaId}"/>
			<input type="password" name="password" id="password"/>
			<input type="button" id="confirmBtn" value="확인"/>
		</form>
	</div>
</body>
</html>