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
		$(".reserveLink").click(function() {
			var memberSession = "${sessionScope._USER_.id}";
			var guestSession = "${sessionScope._GUEST_.name}"
			
			if ( memberSession == "" && guestSession == "" ) {
				alert("로그인 후 이용하세요.");
			}
		});
		
	});
</script>
<style>
.button {
	width: 80px;
	background-color:#2056ac; 
	color: #FFF; 
	border:none; 
	border-radius:5px;
	font-size: 15px;
    margin: 4px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div id="container" style="position:relative; top: 35%; left: 30%; width:900px;">
		<c:forEach items="${movieList}" var="movie">
			<div style="position: relative;">
				<div style="position: relative; float:left;  padding-left: 25px;">
					<a href="/PersonalProject/movie/comment/${movie.movieCode}">
						<img src="/PersonalProject/img/${movie.poster}">
					</a>
				</div>
				<div style="display: block; position: relative; float:left; padding-left: 15px;">
					<div style="padding-bottom:15px">${movie.movieName}</div>
					<div style="padding-bottom:15px">상영시간 ${movie.runningTime}분</div>
					<button class="button" onclick="window.location.href='/PersonalProject/movie/showinglist?movieCode=${movie.movieCode}'">예매하기</button>
				</div>
			</div>
		</c:forEach>
	</div>
	
	

</body>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</html>