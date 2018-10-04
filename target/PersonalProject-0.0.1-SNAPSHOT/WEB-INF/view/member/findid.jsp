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
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/menu.jsp" />

	<form id="idSearchForm">
		<div>
			<input type="text" id="name" name="name" placeholder="이름" />
		</div>
		<div>
			<input type="email" id="email" name="email" placeholder="이메일" />
		</div>
		<div>
			<input type="text" id="phone" name="phone"
				placeholder="전화번호" />
		</div>
		<div>
			<input type="button" id="searchBtn" value="찾기" />
		</div>
	</form>

</body>
</html>