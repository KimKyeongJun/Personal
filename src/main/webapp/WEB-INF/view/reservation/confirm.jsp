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
	
	<form id="reserveForm">
		<div>
			<span>이름</span>
			<input type="text" name="name" readonly value="${reservationVO.name}"/>
		</div>
		<div>
			상영시간
		</div>
		<div>
			<c:forEach items="{reservationVO.seatList}" var="seatNumber">
				<span>좌석</span>
				<input type="text" name="seatNumber" readonly value="${seatNumber}"/>
			</c:forEach>			
		</div>
		
		<div>
			<span>마일리지</span><br/>
			<span>보유 마일리지</span>
			<input type="text" name="mileage" placeholder="마일리지" />
			<input type="checkbox" name="chkMileage" />전액사용
		</div>
		
		<div>
			<span> 결제수단 </span>
			<input type="radio" name="payment">계좌 이체
			<input type="radio" name="payment">신용카드
			<input type="radio" name="payment">휴대폰 결제
		</div>
		
		<div>
			<input type="button" id="reservationBtn" value="예약하기" />
		</div>
	</form>

</body>
</html>