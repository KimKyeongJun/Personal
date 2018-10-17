<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js"></script>
<script>

	$().ready(function() {
		$("#fpasswordConfirm").blur( function() {
			if ( $("#fpassword").val() != $("#fpasswordConfirm").val() ) {
				alert("비밀번호가 일치하지 않습니다");
				setTimeout( function() { 
					$("#fpasswordConfirm").focus(); 
					}, 10);
				return;
			}
			else {
				
			}
		});
		
		$("#fphone").blur( function() {
			var num = $("#fphone").val();
			var phone_num = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
			$("#fphone").val(phone_num);
		});
		var emailRegex = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			$("#femail").blur( function() {
			if ( !emailRegex.test($("#femail").val()) ) {
				alert("이메일 형식을 확인해주세요");
				setTimeout( function() { 
					$("#femail").focus(); 
					}, 10);
				return;
			}
		});
		
		$("#modifyBtn").click(function() {
			var passwordRegex = /^(?=.*[a-zA-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}/;
			if ( !passwordRegex.test($("#fpassword").val()) ) {
				alert("비밀번호는 8글자 이상 20글자 이하 대소문자, 숫자, 특수문자를 포함해야 합니다.");
				setTimeout( function() { 
					$("#fpassword").focus(); 
					}, 10);
				return;
			}
			
			
			
		});
		
		
	});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="top:100px; position:relative">
		<form id="modifyForm">
			<div>
				<input type="text" id="fname" name="name" placeholder="이름" />
			</div>
			<div>
				<input type="password" id="fpassword" name="password"
					placeholder="비밀번호" />
			</div>
			<div>
				<input type="password" id="fpasswordConfirm" placeholder="비밀번호 확인" />
			</div>
			<div>
				<input type="text" id="fphone" name="phone" placeholder="휴대폰 번호 ( -없이 입력 )" />
			</div>
			<div>
				<input type="email" id="femail" name="email" placeholder="이메일" />
			</div>
			<div>
				<input type="button" id="modifyBtn" value="수정하기" />
			</div>
		</form>
	</div>

</body>
</html>