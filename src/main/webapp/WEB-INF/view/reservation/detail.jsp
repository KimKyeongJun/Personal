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
	width: 550px;
	padding-bottom: 15px;
	padding-top: 30px;
	clear: both;
	text-align: center;
}

.reserveWrapper {
	width: 550px;
	padding-bottom: 15px;
	text-align: center;
}

.box {
	display: inline-block;
}

.reserveNum { 
	width: 250px;
}

.seatNum {
	width: 150px;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="position:relative; top: 10%; left: 30%; width:550px;">
		<div>
			<div style="text-align:center; padding-bottom: 30px;">
				<font style="font-weight:bold; text-align:center; font-size:30px;">예약 조회</font>
			</div>
			<div>
				<div style="position: relative; float:left; padding-right: 50px;">
					<a href="/PersonalProject/movie/comment/${reservationVO.movieVO.movieCode}">
						<img src="/PersonalProject/img/${reservationVO.movieVO.poster}">
					</a>
				</div>
				<div style="margin-left: 30px;">
					<div style="padding-bottom: 15px;">
						<span>영화명 </span>
						<span>${reservationVO.movieVO.movieName}</span>
					</div>
					<div style="padding-bottom: 15px;">
						<span>상영시간 </span>
						<span>${reservationVO.showingListVO.startDate} ~ ${reservationVO.showingListVO.endDate}</span>
					</div>
				</div>				
			</div>
			<div id="wrapper">
				<span class="reserveNum box">티켓번호</span>
				<span class="seatNum box">좌석번호</span>
			</div>
			<c:forEach items="${ticketList}" var="ticket">
				<div class="reserveWrapper">
					<span class="reserveNum box">${ticket.ticketingId}</span>
					<span class="seatNum box">${ticket.showingNum}관 ${ticket.seatNumber}</span>
				</div>
			</c:forEach>
			<div style="clear:both; text-align:right;">
				<div>실제 금액 : ${reservationVO.originPrice}원</div>
				<div>결제 금액 : ${reservationVO.payPrice}원</div>
				<div>사용한 마일리지 : ${reservationVO.useMileage}점</div>
				<a href="/PersonalProject/reserve/inquiry" style="text-decoration:none; padding-right: 20px; font-weight: bold; color: #00008b; ">목록</a>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>