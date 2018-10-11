<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$().ready(function() {
			$("#registBtn").click(function () {
				$.post("/PersonalProject/movie/regist"
						, $("#registForm").serialize()
						, function(response) {
							alert(response.status);
				});
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<form id="registForm">
		<div>
			<p>영화</p>
			<select	name="movieCode">
				<c:forEach items="${movieList}" var="movie">
						<option value="${movie.movieCode}">${movie.movieName}</option>
				</c:forEach>		
			</select>
		</div>
		<div>
			<p>상영관</p>
			<select	name="showingNum">
				<c:forEach items="${showingList}" var="showing">
						<option value="${showing}">${showing}</option>
				</c:forEach>		
			</select>
		</div>
		<div>
			<p>상영날짜</p>
			<input type="datetime-local" name="startDate" min="2018-10-11T00:00 "/>
		</div>
		<div>
			<input type="button" id="registBtn" value="등록" />
		</div>
	</form>
	
	
	
	<a href="/PersonalProject/showingseat?showingNum=1"> 상영관 정보 </a>
</body>
</html>