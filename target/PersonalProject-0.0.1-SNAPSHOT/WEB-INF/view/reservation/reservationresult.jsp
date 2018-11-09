<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="position:relative; top: 20%; left: 30%; width:525px; text-align:center;">	
		<div style="font-weight:bold; font-size: 20px; padding-bottom:15px;">
			예약이 완료되었습니다.
		</div>
		<div>
			<a href="/PersonalProject/reserve/inquiry" style="text-decoration:none;">예매 내역 확인하기</a>
		</div>
	</div>

	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>