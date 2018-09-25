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
			
			$.post("/PersonalProject/member/login",
					$("#loginForm").serialize(),
					function(response) {
						if ( response.login ) {
							alert("로그인 되었습니다")
						}
						else {
							alert("로그인에 실패하였습니다. 아이디와 비밀번호를 확인하세요!");
						}
			});
		});
	});	
</script>
</head>
<body>

	<div>
		<span>회원 로그인</span>
		<span><a href="/PersonalProject/member/guest">비회원 로그인</a></span>
	</div>

	<form id="loginForm">
		<div>
			<input type="text" id="id" name="id" placeholder="아이디" />
		</div>
		<div>
			<input type="password" id="password" name="password"
				placeholder="비밀번호" />
		</div>
		<div>
			<input type="button" id="loginBtn" value="로그인" />
		</div>
	</form>
	<div>
		<a href="/PersonalProject/member/findid">아이디 찾기</a>
	</div>



</body>
</html>