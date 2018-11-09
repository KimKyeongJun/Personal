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
			
			if ($("#fsubject").val() == '' ) {
				alert("제목을 입력하세요");
				focus("#fsubject").focus();
				return;
			}
			if ($("#fcontent").val() == '' ) {
				alert("내용을 입력하세요");
				focus("#fcontent").focus();
				return;
			}
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
<style>
.formSpan {
	width: 65px;
	font-weight: bold;
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

	<div style="position:relative; top: 20%; left: 30%; width:525px; text-align:center;">
		<form id="registForm">
			<div class="formDiv">
				<span class="formSpan">제목</span>
				<input type="text" id="fsubject" name="subject" placeholder="제목" />
			</div>
			<div class="formDiv">
				<span class="formSpan">내용</span>
				<textarea id="fcontent" name="content" placeholder="내용"></textarea>				
			</div>
			<div class="formDiv" style="text-align: right; padding-right:15px;">
				<input class="button" type="button" id="registBtn" value="등록" />
			</div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>