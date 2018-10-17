<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="top: 100px; position: relative">
		<div>
			<span>예매번호</span>
			<span>영화명</span>
			<span>예매날짜</span>
		</div>
		<c:choose>
			<c:when test="${not empty reservationList}">			
				<c:forEach items="${reservationList}" var="reservation">
					<div>
						<span><a href="/PersonalProject/reserve/detail/${reservation.reservationId}">${reservation.reservationId}</a></span>
						<span>${reservation.movieVO.movieName}</span>
						<span>${reservation.reservationDate}</span>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>예매 내역이 존재하지 않습니다.</div>
			</c:otherwise>
		
		</c:choose>
	</div>

</body>
</html>