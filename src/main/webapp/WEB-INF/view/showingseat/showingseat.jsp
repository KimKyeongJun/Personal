<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$(".seatBtn").click(function() {
			alert($(this).val());
		});
	});
</script>
</head>
<body>
	<c:forEach items="${showingSeat}" var="seat" varStatus="status">
			<span style="padding: 5px;"><button class="seatBtn" value="${seat.seatNumber}" style="width: 30px; height: 35px" ></button></span>
			<c:if test="${ status.count%10 eq 0 }" ><br/></c:if>
	</c:forEach>
</body>
</html>