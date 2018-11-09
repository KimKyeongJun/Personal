<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

#wrapper {
	width: 600px;
	padding-top: 30px;
	padding-bottom: 15px;
	font-weight: bold;
}
.showingWraper {
	width: 600px;
	padding-bottom: 15px;
}
.subject {
	width: 100px;
}

.showingDate {
	width: 200px;
}

.showingNum {
	width: 100px;
}
.reserve {
	width: 100px;
}

.box {
	display: inline-block;
}

.button {
	width: 100px;
	background-color:#2056ac; 
	color: #FFF; 
	border:none; 
	border-radius:10px;
	font-size: 15px;
    margin: 4px;
}


</style>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div style="position:relative; top: 10%; left: 30%; width:525px; text-align: center; ">
		<font style="font-size:30px; font-weight:bold;">현재 상영 영화</font>
		<div id="wrapper">
			<span class="subject box">영화제목</span>
			<span class="showingDate box">상영날짜</span>
			<span class="showingNum box">상영관</span>
			<span class="reserve box"></span>
		</div>
		<c:forEach items="${showingList}" var="showing">
			<div class="showingWraper">
				<span class="subject box">${showing.movieVO.movieName}</span>
				<span class="showingDate box">${showing.startDate}</span>
				<span class="showingNum box">${showing.showingNum}</span>
				<span>
					<button class="button" onclick="window.open('/PersonalProject/reserve/showingseat?movieCode=${showing.movieVO.movieCode}&showingId=${showing.showingId}&showingNum=${showing.showingNum}', '_blank', 'width=800 top=80 left=400 height=750')">
						예매하기
					</button>
				</span>
			</div>
		</c:forEach>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>