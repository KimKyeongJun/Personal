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
							alert("등록되었습니다");
							location.href="/PersonalProject/movie/showinglist";
				});
			});
		});
	});
</script>
<style>
.formSpan {
	display:inline-block; 
	width: 65px;
	font-weight: bold;
}

input {
	vertical-align: middle;
	width: 350px;
	padding-top: 15px;
	padding-bottom: 15px;
	font-size: 15px;
	border-radius:10px;
}

.button {
	width: 150px;
	background-color:#2056ac; 
	color: #FFF; 
	border:none; 
	border-radius:10px;
	font-size: 15px;
    margin: 4px;
}

.formDiv {
	padding-bottom: 10px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<div style="position:relative; top: 30%; left: 30%; width:900px;">
	
		<form id="registForm">
			<div class='formDiv'>
				<span class="formSpan">영화</span>
				<select	name="movieCode">
					<c:forEach items="${movieList}" var="movie">
							<option value="${movie.movieCode}">${movie.movieName}</option>
					</c:forEach>		
				</select>
			</div>
			<div class='formDiv'>
				<span class="formSpan">상영관</span>
				<select	name="showingNum">
					<c:forEach items="${showingList}" var="showing">
							<option value="${showing}">${showing}</option>
					</c:forEach>		
				</select>
			</div>
			<div class='formDiv'>
				<span class="formSpan">상영날짜</span>
				<input type="datetime-local" name="startDate" min="2018-10-11T00:00 "/>
			</div>
			<div>
				<input class="button" type="button" id="registBtn" value="등록" />
			</div>
		</form>
	
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
	
	
</body>
</html>