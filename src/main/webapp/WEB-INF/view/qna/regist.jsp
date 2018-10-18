<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>
.formSpan {
	width: 70px;
	font-weight: bold;
	display: inline-block;
}

input {
	vertical-align: middle;
	width: 450px;
	padding-top: 15px;
	padding-bottom: 15px;
	font-size: 15px;	
	border-radius:10px;
}

textarea {
	vertical-align: middle;
	width: 450px;
	height: 350px;
	padding-top: 15px;
	padding-bottom: 15px;
	font-size: 15px;	
	border-radius:10px;
	resize: none;
}

.button {
	width: 150px;
	background-color:#2056ac; 
	color: #FFF; 
	border:none; 
	border-radius:10px;
	font-size: 15px;
    margin: 4px;
}

.formSpan a {
	text-decoration: none;	
}

.formDiv {
	padding-bottom: 10px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />

	<div style="position:relative; top: 10%; left: 30%; width:550px; text-align:center;">
		<form id="registForm">
			<div class="formDiv">
				<span class="formSpan">작성자</span>
				<input type="text" id="writer" name="writer" placeholder="작성자" />
			</div>
			<div class="formDiv">
				<span class="formSpan">비밀번호</span>
				<input type="password" id="password" name="password" placeholder="비밀번호" />
			</div>
			<div class="formDiv">
				<span class="formSpan">제목</span>
				<input type="text" id="subject" name="subject" placeholder="제목" />
			</div>
			<div class="formDiv">
				<span class="formSpan">내용</span>
				<textarea id="content" name="content" placeholder="내용"></textarea>
			</div>
			<div class="formDiv">
				<span class="formSpan">공개여부</span>
				<input style="width: 30px;" type="radio" name="isVisible" value="Y" checked="checked" >공개
				<input style="width: 30px;" class="notInput" type="radio" name="isVisible" value="N">비공개
			</div>		
			<div class="formDiv" style="text-align:right; padding-right:18px;">
				<input type="button" id="registBtn" class="button" value="등록" />
			</div>				
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>