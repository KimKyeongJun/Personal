<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#chkMileage").blur(function() {
			if ( $(this).val() > "${sessionScope._USER_.mileage}" ) {
				alert("보유 마일리지보다 사용하려는 마일리지가 많습니다.");
				$(this).val("");
				$(this).focus();
			}
			else {
				var price = "${reservationVO.price}" - $(this).val();
				$("#payPrice").text("결제 금액 : "+price+"원");
			}
		});
		
		$("#chkBox").on('click', function() {
			var isCheck = $(this).prop("checked");
			if ( isCheck ) {
				$("#chkMileage").val("${sessionScope._USER_.mileage}");
				var price = "${reservationVO.price}" - "${sessionScope._USER_.mileage}";
				$("#payPrice").text("결제 금액 : "+price+"원");
			}
			else {
				$("#chkMileage").val("");
				$("#payPrice").text("결제 금액 : ${reservationVO.price}원");
			}
		});
		
		$("#reservationBtn").click(function() {
			$.post("/PersonalProject/reserve"
					, $("#reserveForm").serialize()
					, function(response){
						if (response) {
							alert("예약이 완료되었습니다");
							opener.parent.location = "/PersonalProject/reserve/result";
							window.close();
						}
			});
		});
		


	});
</script>
<body>
		<form id="reserveForm">
			<input type="hidden" name="showingId" value="${showingListVO.showingId}" />
			<input type="hidden" name="showingNum" value="${showingListVO.showingNum}" />
			<div>
				<span>이름</span>
				<input type="text" name="name" readonly value="${sessionScope._USER_.name}"/>
			</div>
			<div>
				<span>영화 ${showingListVO.movieVO.movieName}</span>
			</div>
			<div>
				<span>상영시간 ${showingListVO.startDate} ~ ${showingListVO.endDate}</span>
			</div>
			<div>
				<span>상영관 ${showingListVO.showingNum}관</span>
			</div>
			<div>
				<c:forEach items="${reservationVO.seatNumberList}" var="seatNumber">
					<span>좌석</span>
					<input type="text" name="seatNumberList" readonly value="${seatNumber}"/>
				</c:forEach>			
			</div>
			
			<div>
				<span>마일리지</span>
				<input type="text" id="chkMileage" name="mileage" placeholder="마일리지" />
				<input type="checkbox" id="chkBox" name="chkMileage" />전액사용 (보유 마일리지 : ${sessionScope._USER_.mileage}점)
			</div>
			
			<div>
				<span> 결제수단 </span>
				<input type="radio" name="payment">계좌 이체
				<input type="radio" name="payment">신용카드
				<input type="radio" name="payment">휴대폰 결제
			</div>
			<div>
				<span id="payPrice">결제 금액 : ${reservationVO.price}원</span>
			</div>
			
			<div>
				<input type="button" id="reservationBtn" value="예약하기" />
			</div>
		</form>

</body>
</html>