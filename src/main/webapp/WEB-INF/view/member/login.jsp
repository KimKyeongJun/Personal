<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#loginBtn").click(function() {
			if ($("#id").val() == "" ){
				alert("아이디를 입력하세요");
				setTimeout( function() { 
					$("#id").focus(); 
					}, 10);
				return;
			}
			 
			if ( $("#password").val() == "") {
				alert("비밀번호를 입력하세요");
				setTimeout( function() { 
					$("#password").focus(); 
					}, 10);
				return;
			}
			
			$.post("/PersonalProject/memberlogin",
					$("#loginForm").serialize(),
					function(response) {
						if ( response.login ) {
							alert("로그인 되었습니다");
							location.href="/PersonalProject/";
						}
						else {
							alert(response.message);
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
.loginSpan a {
	text-decoration: none;	
}

.loginDiv {
	padding-bottom: 10px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<div style="position:relative; top: 20%; left: 30%; width:525px; text-align:center;">
		<div style="text-align:center; padding-bottom: 15px;">
			<span class="loginSpan" style="color: #00008b; font-weight: bold;"> 회원 로그인  |</span>
			<span class="loginSpan"><a href="/PersonalProject/member/guest" style="text-decoration: none; color: #00008b; font-weight: bold;">비회원 로그인</a></span>
		</div>
	
		<form id="loginForm">
			<div class="loginDiv">
				<span class="formSpan">아이디</span>
				<input type="text" id="id" name="id" placeholder="아이디" />
			</div>
			<div class="loginDiv">
				<span class="formSpan">비밀번호</span>
				<input type="password" id="password" name="password"
					placeholder="비밀번호" />
			</div>
			<div class="loginDiv" style="text-align:right;">
				<input type="button" class="button" value="아이디찾기" onclick="window.location.href='/PersonalProject/member/findid'"/>
				<input type="button" class="button" id="loginBtn" value="로그인" style=""/>
			</div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>