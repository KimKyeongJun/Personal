<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		
		$("#phone").blur( function() {
			var num = $("#phone").val();
			var phone_num = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
			$("#phone").val(phone_num);
		});
		
		$("#searchBtn").click(function() {
			if ( $("#name").val() == "" ) {
				alert("이름은 필수 입력 값입니다.");
				setTimeout( function() { 
					$("#name").focus(); 
					}, 10);
				return;
			}
			
			if ( $("#email").val() == "" ) {
				alert("이메일은 필수 입력 값입니다.");
				setTimeout( function() { 
					$("#email").focus(); 
					}, 10);
				return;
			}
			if ( $("#phone").val() == "" ) {
				alert("전화번호는 필수 입력 값입니다.");
				setTimeout( function() { 
					$("#phone").focus(); 
					}, 10);
				return;
			}
			
			$.post("/PersonalProject/member/findid"
					, $("#idSearchForm").serialize()
					, function(response) {
						if ( response.exist ) {
							location.href="/PersonalProject/member/resultfindid?resultId="+response.id;
						}
						else {
							alert("아이디를 찾을 수 없습니다");
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
	text-align: left;
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
	
		<form id="idSearchForm">
			<h1 style="text-align:center;">아이디 찾기</h1>
			<div class="formDiv">
				<span class="formSpan">이름</span>
				<input type="text" id="name" name="name" placeholder="이름" />
			</div>
			<div class="formDiv">
				<span class="formSpan">이메일</span>
				<input type="email" id="email" name="email" placeholder="이메일" />
			</div>
			<div class="formDiv">
				<span class="formSpan">전화번호</span>
				<input type="text" id="phone" name="phone"
					placeholder="전화번호" />
			</div>
			<div class="formDiv" style="text-align: right;">
				<input class="button" type="button" id="searchBtn" value="찾기" />
			</div>
		</form>

	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>