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
					<div>					
						<span>상영관 정보 </span>
						<span>${reservationVO.showingNum}관 ${reservationVO.seatNumber}</span>
					</div>
				</div>				
			</div>
			<div style="clear:both; text-align:right;">
				<a href="/PersonalProject/reserve/inquiry" style="text-decoration:none; padding-right: 20px; font-weight: bold; color: #00008b; ">목록</a>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>