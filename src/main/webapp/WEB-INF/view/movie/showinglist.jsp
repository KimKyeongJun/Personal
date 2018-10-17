<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="text-align: center; top:100px; position:relative;">
		<div>
			<span>영화제목</span>
			<span>상영날짜</span>
			<span>상영관</span>
		</div>
		<c:forEach items="${showingList}" var="showing">
			<div>
				<span>${showing.movieVO.movieName}</span>
				<span>${showing.startDate}</span>
				<span>${showing.showingNum}</span>
			</div>
			<a href="#" onclick="window.open('/PersonalProject/reserve/showingseat?movieCode=${showing.movieVO.movieCode}&showingId=${showing.showingId}&showingNum=${showing.showingNum}', '_blank', 'width=800 height=600')">예매하기</a>
		</c:forEach>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>