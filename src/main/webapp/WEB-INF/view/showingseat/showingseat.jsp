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
		var list = [];
		<c:forEach items="${reservationSeatList}" var="item">
			list.push("${item}");
		</c:forEach>
		
		$(".seatBtn").each(function(i,e) {
			for ( var i in list ) {
				if ( $(this).val() == list[i] ) {
					$(this).css('background-color', 'gray');
					$(this).prop('disabled', true);
				}
			}
		});
		
		$(".seatBtn").click(function() {
			var input = '<div class="seatDiv" data-count ="'+$(this).data('count')+'">'+$(this).val()+'</div>';
			var formInput = '<input type="hidden" data-count ="'+$(this).data('count')+'" class="seatClass" multiple name="seatNumberList" value="'+$(this).val()+'" />'
			
			
			var seatValue=$(this).data('count');
			var seat = $(this);
			if ( $(".seatDiv[data-count='"+seatValue+"']").data('count') == seatValue ) {
				seat.css('background-color', '#f44336');
				$(".seatDiv[data-count='"+seatValue+"']").remove();
				$(".seatClass[data-count='"+seatValue+"']").remove();
			}
			else {
				if ( $(".seatDiv").length > 3 ){
					alert("한 사람당 최대 예매 가능한 매수는 4매 입니다.");
				}
				else {						
					$(this).css('background-color', 'gray');
					$("#shadowInput").append(input);
					$("#reserveForm").append(formInput);					
				}
			}
			
		});
		
		$("#reserveBtn").click(function() {
			if ($(".seatDiv").length === 0 ){
				alert("좌석을 선택해주세요");
				return;
			}			
			
			if ( confirm ("예매하시겠습니까?") ){
				alert("네");
			}
			else {
				
			}
			
			/* $.post("/PersonalProject/reserve",
					$("#reserveForm").serialize(),
					function(response) {
						alert(response.status);				
			}); */
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
	<!-- 좌표값을 데이터로 줘서 한다. -->
	<div style="text-align:center">		
		<div id="seatList">
			<c:forEach items="${showingSeat}" var="seat" varStatus="status">
				<span style="padding: 5px;">
					<button class="seatBtn"
						value="${seat.seatNumber}"
						style="width: 30px; height: 35px; background-color: #f44336;" data-count="${status.count}"></button>
				</span>
				<c:if test="${ status.count%10 eq 0 }">
					<br />
				</c:if>				
			</c:forEach>
		</div>		
	</div>
	<div style="text-align:right; clear: both;">		
		<hr/>
		<div>
			<form id="reserveForm">
				<input type="hidden" name="showingId" value="${showingId}" />
				<input type="hidden" name="showingNum" value="${showingNum}" />
			</form>
		</div>
		<div id="shadowInput">
			
		</div>
		<input type="button" value="좌석 다시 선택" onClick="window.location.reload()">
		<input type="button" id="reserveBtn" value="예매하기" /> 
		<!-- <a href="/PersonalProject/reserve">예매하기</a> -->
	</div>
	
	<c:set var="items" value="${reservationSeatList}"></c:set>
</body>
</html>