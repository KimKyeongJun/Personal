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
	
	<div>
		<c:forEach items="${movieList}" var="movie">
			<div style="position: relative;">
				<div style="position: relative; float:left;"><img src="/PersonalProject/img/${movie.poster}"></div>
				<div style="display: block; position: relative; float:left;">
					<div>${movie.movieName}</div>
					<div>상영시간 ${movie.runningTime}</div>
					<a href="/PersonalProject/movie/showinglist">예매하기</a>
				</div>
			</div>
		</c:forEach>
	</div>
	
	

</body>
<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</html>