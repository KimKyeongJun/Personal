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
			$.post("/PersonalProject/notice/regist"
					, $("#registForm").serialize()
					, function(response) {
						if ( response.status ) {
							alert("등록되었습니다");
							location.href="/PersonalProject/notice/notice";
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
				<input type="text" id="subject" name="subject" placeholder="제목" />
			</div>
			<div>
				<textarea id="content" name="content" placeholder="내용"></textarea>
			</div>
			<div>
				<input type="button" id="registBtn" value="등록" />
			</div>
		</form>
	</div>

</body>
</html>