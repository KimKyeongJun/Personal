<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrapper {
	font-weight:bold;
	width: 650px;
	padding-bottom: 15px;
	padding-top: 30px;
}

.reserveWrapper {
	width: 650px;
	padding-bottom: 15px;
}

.box {
	display: inline-block;
}

.reserveNum { 
	width: 250px;
}

.movieName {
	width: 150px;
}

.reserveDate {
	width: 150px;
}

.ticketCount {
	width: 50px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="position:relative; top: 10%; left: 30%; width:700px; text-align: center;">
		<font style="font-size:30px; font-weight:bold;">예매 내역</font>
		<div id="wrapper">
			<span class="reserveNum box">예매번호</span>
			<span class="movieName box">영화명</span>
			<span class="reserveDate box">예매날짜</span>
			<span class="ticketCount box">예매수</span>
		</div>
		<c:choose>
			<c:when test="${not empty reservationList}">			
				<c:forEach items="${reservationList}" var="reservation">
					<div class="reserveWrapper">
						<span class="reserveNum box"><a style="color: #000000; text-decoration:none;" href="/PersonalProject/reserve/detail/${reservation.reservationId}">${reservation.reservationId}</a></span>
						<span class="movieName box">${reservation.movieVO.movieName}</span>
						<span class="reserveDate box">${reservation.reservationDate}</span>
						<span class="ticketCount box">${reservation.ticketCount}매</span>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>예매 내역이 존재하지 않습니다.</div>
			</c:otherwise>
		
		</c:choose>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>