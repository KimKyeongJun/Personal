<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 창</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$(".seatBtn").click(function() {
			var input = '<div>'+$(this).val()+'</div>';
			$("#shadowInput").append(input);
			alert($(this).val());
		});
	});
</script>
</head>
<body>
	<div style="text-align: center;">
		<span>
			<select name="date">
			</select>
		</span>
		
		<span>
			<select name="movie">
			
			</select>
		</span>
		<span>
		</span>
	</div>
	<div style="text-align: center;">
		<div style="float: left; width:10%; background:black;">
			룰루랄라
		</div>
		<div  style="float: left; width:80%">
			<c:forEach items="${showingSeat}" var="seat" varStatus="status">
				<span style="padding: 5px;">
					<button class="seatBtn"
						value="${seat.seatNumber}"
						style="width: 30px; height: 35px; background-color: #f44336;"></button>
				</span>
				<c:if test="${ status.count%10 eq 0 }">
					<br />
				</c:if>
			</c:forEach>
		</div>
		<div id="shadowInput" style="float: left; width:10%">
			룰루랄라
		</div>
	</div>
	<div style="text-align:right; clear: both;">
		<hr/>
		<input type="button" value="예매하기" /> 
		<a href="/PersonalProject/reserve">예매하기</a>
	</div>
</body>
</html>