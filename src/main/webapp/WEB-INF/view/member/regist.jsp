<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script>
	$().ready( function() {
		$("#id").blur( function() {
			$.post("/PersonalProject/member/duplicate", {
				id : $(this).val()
			}, function(response) {
				if (response.possible) {
					alert(response.data);
				}
				else {
					$("#id").val("");
					setTimeout( function(){ 
						$("#id").focus(); 
						}, 10);
					alert(response.data);
				}
			});					
		});
		
		$("#passwordConfirm").blur( function() {
			if ( $("#password").val() != $("#passwordConfirm").val() ) {
				alert("비밀번호가 일치하지 않습니다");
				setTimeout( function() { 
					$("#passwordConfirm").focus(); 
					}, 10);
				return;
			}
			else {
				
			}
		});
		
		$("#phone").blur( function() {
			var num = $("#phone").val();
			var phone_num = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
			$("#phone").val(phone_num);
		});
		
		$("#registBtn").click( function() {
					if ($("#id").val() == "" ) {
						alert("아이디는 필수 입력값입니다.");
						setTimeout( function() { 
							$("#id").focus(); 
							}, 10);
						return;
					}
					
					
					if($("#password").val() == "") {
						alert("비밀번호는 필수 입력 값입니다.");
						setTimeout( function() { 
							$("#password").focus(); 
							}, 10);
						return;
					}
					
					var passwordRegex = /^(?=.*[a-zA-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}/;
					if ( !passwordRegex.test($("#password").val()) ) {
						alert("비밀번호");
						setTimeout( function() { 
							$("#password").focus(); 
							}, 10);
						return;
					}
					
					if($("#phone").val() == "" ) {
						alert("휴대폰 번호를 입력하세요");
						setTimeout( function() { 
							$("#phone").focus(); 
							}, 10);
						return;
					}
					
					if($("#email").val() == "") {
						alert("이메일을 입력하세요");
						setTimeout( function() { 
							$("#email").focus(); 
							}, 10);
						return;
					}
					
					var emailRegex = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
					if ( !emailRegex.test($("#email").val()) ) {
						alert("이메일 형식을 확인해주세요");
						setTimeout( function() { 
							$("#email").focus(); 
							}, 10);
						return;
					}
					$.post("/PersonalProject/member/regist", $(
							"#registForm").serialize(), function(
							response) {
						if (response.regist) {
							alert("가입되었습니다");
							location.href="/PersonalProject/member/login";
						} else {
							alert("가입 실패!");
						}
					});
				});
	});
</script>
</head>
<body>

	<form id="registForm">
		<div>
			<input type="text" id="id" name="id" placeholder="아이디" />
		</div>
		<div>
			<input type="password" id="password" name="password"
				placeholder="비밀번호" />
		</div>
		<div>
			<input type="password" id="passwordConfirm" placeholder="비밀번호 확인" />
		</div>
		<div>
			<input type="text" id="phone" name="phone" placeholder="휴대폰 번호 ( -없이 입력 )" />
		</div>
		<div>
			<input type="email" id="email" name="email" placeholder="이메일" />
		</div>
		<div>
			<input type="button" id="registBtn" value="가입하기" />
		</div>
	</form>

</body>
</html>