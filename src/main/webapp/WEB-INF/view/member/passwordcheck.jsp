<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js"></script>
<script>
	$().ready(function() {
		
		
		$("#pwdBtn").click(function() {
			if ( $("#pwd").val() == "" ) {
				alert("비밀번호를 입력하세요");
				$("#pwd").focus();
				return;				
			}
			
			$.post("/PersonalProject/member/passwordcheck"
					, $("#pwdForm").serialize()
					, function(response) {
						if ( response ) {
							location.href="/PersonalProject/member/modify";
						}
						else {
							alert("비밀번호를 다시 확인해주세요");
						}
			});
		});
	});
</script>
<style>
.formSpan {
	display:inline-block; 
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

.button {
	width: 150px;
	background-color:#2056ac; 
	color: #FFF; 
	border:none; 
	border-radius:10px;
	font-size: 15px;
    margin: 4px;
}

.formDiv {
	padding-bottom: 10px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="position:relative; top: 20%; left: 30%; width:525px; text-align:center;">
		<form id="pwdForm">
			<h1 style="text-align: center;">비밀번호 확인</h1>
			<div class="formDiv">
				<span class="formSpan"></span>
				<input id="pwd" type="password" name="password" placeholder="비밀번호 입력"/>
			</div>
			<div class="formDiv" style="text-align: right;">
				<input class="button" type="button" id="pwdBtn" value="확인" />
			</div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>