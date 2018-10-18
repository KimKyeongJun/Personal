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
				$("#payPrice").text(price+"원");
			}
		});
		
		$("#chkBox").on('click', function() {
			var isCheck = $(this).prop("checked");
			if ( isCheck ) {
				$("#chkMileage").val("${sessionScope._USER_.mileage}");
				var price = "${reservationVO.price}" - "${sessionScope._USER_.mileage}";
				$("#payPrice").text(price+"원");
			}
			else {
				$("#chkMileage").val("");
				$("#payPrice").text("${reservationVO.price}원");
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
<style>
.formSpan {
	display:inline-block; 
	width: 70px;
	font-weight: bold;
}

input {
	vertical-align: middle;
	width: 150px;
	font-size: 15px;
	border:none;
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
.radio {
	width: 10px;
}
</style>
<body>
		<div>
			<div>
				<p style="font-weight: bold; font-size:25px;">예매 확인 페이지</p>
			</div>
			
			<form id="reserveForm">
				<input type="hidden" name="showingId" value="${showingListVO.showingId}" />
				<input type="hidden" name="showingNum" value="${showingListVO.showingNum}" />
				<div class="formDiv">
					<span class="formSpan">이름</span>
					<input type="text" name="name" readonly value="${sessionScope._USER_.name}"/>
				</div>
				<div class="formDiv">
					<span class="formSpan">영화</span>
					<span> ${showingListVO.movieVO.movieName}</span>
				</div>
				<div class="formDiv">
					<span class="formSpan">상영시간</span>
					<span>${showingListVO.startDate} ~ ${showingListVO.endDate}</span>
				</div>
				<div class="formDiv">
					<span class="formSpan">상영관</span><span> ${showingListVO.showingNum}관</span>
				</div>
				<div>
					<c:forEach items="${reservationVO.seatNumberList}" var="seatNumber">
						<div class="formDiv">
							<span class="formSpan">좌석</span>
							<input type="text" name="seatNumberList" readonly value="${seatNumber}"/>
						</div>
					</c:forEach>			
				</div>
				
				<div class="formDiv">
					<span class="formSpan">마일리지</span>
					<input type="text" id="chkMileage" name="mileage" placeholder="마일리지" />
					<input style="width: 10px;"type="checkbox" id="chkBox" name="chkMileage" />전액사용 (보유 마일리지 : ${sessionScope._USER_.mileage}점)
				</div>
				
				<div class="formDiv">
					<span class="formSpan"> 결제 수단 </span>
					<input class="radio" type="radio" name="payment">계좌 이체
					<input class="radio" type="radio" name="payment">신용카드
					<input class="radio" type="radio" name="payment">휴대폰 결제
				</div>
				<div class="formDiv">
					<span class="formSpan">결제 금액  </span><span id="payPrice">${reservationVO.price}원</span>
				</div>
				
				<div>
					<input type="button" id="reservationBtn" value="예약하기" />
				</div>
			</form>
		</div>

</body>
</html>