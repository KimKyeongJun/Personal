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
				$("#id").blur(function() {
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
				
				$("#passwordConfirm").blur(function() {
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
				$("#registBtn").click(
						function() {
							$.post("/PersonalProject/member/regist", $(
									"#registForm").serialize(), function(
									response) {
								if (response.regist) {
									alert("가입되었습니다");
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
			<input type="text" id="id" name="id" placeholder="Id" />
		</div>
		<div>
			<input type="password" id="password" name="password"
				placeholder="Password" />
		</div>
		<div>
			<input type="password" id="passwordConfirm" placeholder="PasswordConfirm" />
		</div>
		<div>
			<input type="text" id="phone" name="phone" placeholder="Phone" />
		</div>
		<div>
			<input type="email" id="email" name="email" placeholder="Email" />
		</div>
		<div>
			<input type="button" id="registBtn" value="가입하기" />
		</div>
	</form>

</body>
</html>