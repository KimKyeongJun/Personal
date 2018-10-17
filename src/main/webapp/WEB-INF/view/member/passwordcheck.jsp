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
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="position: relative; top: 100px; text-align: center;">
		<form id="pwdForm">
			<div>
				<input id="pwd" type="password" name="password" placeholder="비밀번호 입력"/>
			</div>
			<div>
				<input type="button" id="pwdBtn" value="확인" />
			</div>
		</form>
	</div>

</body>
</html>