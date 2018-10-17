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
	
	<div style="position: relative; top: 100px;">
		<div>
			<div>
				<a href="/PersonalProject/movie/comment/${reservationVO.movieVO.movieCode}"><img src="/PersonalProject/img/${reservationVO.movieVO.poster}"></a>
				<span>영화명 </span><span>${reservationVO.movieVO.movieName}</span>
			</div>
			<div>
				<span>상영시간 </span><span>${reservationVO.showingListVO.startDate} ~ ${reservationVO.showingListVO.endDate}</span>
			</div>
			<div>
				<span>상영관 정보 </span><span>${reservationVO.showingNum}관 ${reservationVO.seatNumber}</span>
			</div>
		</div>
	</div>

</body>
</html>