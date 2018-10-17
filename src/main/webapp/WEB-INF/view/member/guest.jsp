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
	$().ready(function() {
		$("#phone").blur( function() {
			var num = $("#phone").val();
			var phone_num = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
			$("#phone").val(phone_num);
		});
		
		
		$("#guestBtn").click(function() {
			if ($("#name").val() == "" ) {
				alert("이름은 필수 입력값입니다.");
				return;
			}
			
			if ( $("#phone").val() == "" ) {
				alert("전화번호는 필수 입력값입니다.");
				return;
			}
			
			if ( $("#email").val() == "" ) {
				alert("이메일은 필수 입력값 입니다.");
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
			
			$.post("/PersonalProject/member/guest"
					, $("#guestForm").serialize()
					, function(response) {
						if ( response )	{
							location.href="/PersonalProject";
						}
						else {
							alert("회원에 등록되어 있는 정보입니다. 아이디를 찾아주세요.");
							location.href="/PersonalProject/member/findid";
						}
			});
		});
	});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<div style="top:100px; position:relative">
		<div>
			<span><a href="/PersonalProject/member/login">회원 로그인</a></span>
			<span>비회원 로그인</span>
		</div>
	
		<form id="guestForm">
			<div>
				<input type="text" id="name" name="name" placeholder="이름" />
			</div>
			<div>
				<input type="text" id="phone" name="phone"
					placeholder="전화번호" />
			</div>
			<div>
				<input type="email" id="email" name="email"
					placeholder="이메일" />
			</div>		
			<div>
				<input type="button" id="guestBtn" value="등록" />
			</div>
		</form>
	</div>

</body>
</html>