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
			
			if ( $("#fpassword").val() != "" ) {
				var passwordRegex = /^(?=.*[a-zA-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}/;
				if ( !passwordRegex.test($("#fpassword").val()) ) {
					alert("비밀번호는 8글자 이상 20글자 이하 대소문자, 숫자, 특수문자를 포함해야 합니다.");
					setTimeout( function() { 
						$("#fpassword").focus(); 
						}, 10);
					return;
				}
			}
			
			$.post("/PersonalProject/member/modify"
					, $("#modifyForm").serialize()
					, function(response) {
						if ( response ) {
							if ( $("#fpassword").val() != "" ) {
								alert("비밀번호가 변경되었습니다. 다시 로그인해주세요")
								location.href="/PersonalProject/member/logout";
							}
							else {
								alert("수정되었습니다");
								location.href="/PersonalProject";
							}
						}
			});
			
			
			
		});
		
		
	});

</script>
<style>
.formSpan {
	display:inline-block; 
	width: 120px;
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
	
	<div style="position:relative; top: 20%; left: 30%; width:600px;">
		<form id="modifyForm">
			<h1 style="text-align:center;">회원 정보 수정</h1>
			<div class="formDiv">
				<span class="formSpan">이름</span>
				<input type="text" id="fname" name="name" placeholder="이름" value="${sessionScope._USER_.name}" />
			</div>
			<div class="formDiv">
				<span class="formSpan">비밀번호</span>
				<input type="password" id="fpassword" name="password"
					placeholder="비밀번호" />
			</div>
			<div class="formDiv">
				<span class="formSpan">비밀번호 확인</span>
				<input type="password" id="fpasswordConfirm" placeholder="비밀번호 확인" />
			</div>
			<div class="formDiv">
				<span class="formSpan">휴대폰</span>
				<input type="text" id="fphone" name="phone" placeholder="휴대폰 번호 ( -없이 입력 )" value="${sessionScope._USER_.phone}"/>
			</div>
			<div class="formDiv">
				<span class="formSpan">이메일</span>
				<input type="email" id="femail" name="email" placeholder="이메일" value="${sessionScope._USER_.email}"/>
			</div>
			<div class="formDiv" style="text-align: right;">
				<input class="button" type="button" id="modifyBtn" value="수정하기" />
			</div>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>