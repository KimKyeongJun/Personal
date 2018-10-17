<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<script src="/PersonalProject/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#ticket").click(function() {
			var userCheck = "${sessionScope._USER_.id}";
			var guestCheck = "${sessionScope._GUEST_.name}";
			if( userCheck == "" && guestCheck == "" ) {
				alert("로그인 후 이용하세요.");
			}
		});
		$("#movieMenu").mouseenter(function() {
			$(".subMenu").stop().slideDown(100);
			$("#parentMenu").hide();
		});
		$("#movieMenu").mouseleave(function() {
			$(".subMenu").stop().slideUp(100);
			$("#parentMenu").show();
		});
	});
</script>
 <style type="text/css">
 html,body{
		margin: 0;
		padding: 0;
		width: 100%;
		height: 100%;
}
#container {
	
}

#navibar{
	position: absolute;
	height: 50px;
	background-color: #2056ac;
	width: 100%;
	top: 0;
	z-index: 99999;
}		

#navibar>ul{
	margin: 0;
	padding: 0;
	list-style: none;
	width: 1200px;
	margin: 0 auto;
}

#navibar>ul>li{
	float: left;
	width: 150px;
	height: 50px;
}

#navibar>ul>li a{
	display: block;
	width: 100%;
	height: 100%;
	color: #fff;
	text-decoration: none;
	text-align: center;
	font: bold 14px/50px "맑은고딕",verdana;
	transition: all .4s;
}

#navibar>ul>li:hover>a{
	color: #001ab7;
	background-color: #FFFFFF;
}

.smenu{
	margin: 0;
	padding: 0;
	list-style: none;
	background-color: #3a3a3a;	
	height: 0;
	overflow: hidden;
	transition: height .4s ease-out;
}



#navibar>ul>li:nth-child(2):hover>.smenu{
	height: 150px;
}

#navibar>ul>li:nth-child(3):hover>.smenu{
	height: 100px;
}
#navibar>ul>li:nth-child(4):hover>.smenu{
	height: 100px;
}

#navibar>ul>li:nth-child(6):hover>.smenu{
	height: 100px;
}

.smenu>li:hover>a{
	color: #3A3939 !important;
	background-color: #CCC;
}
  
  
</style>

<nav id="navibar">
		<ul>
			<li><a href="/PersonalProject/">홈</a></li>
			<li><a>영화</a>
				<ul class="smenu">
					<li><a href="#">영화 정보</a></li>
					<li><a href="/PersonalProject/movie/showinglist">상영 중 영화</a></li>
					<s:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
					<c:choose>
						<c:when test="${isAdmin}">
							<li><a href="/PersonalProject/movie/movie">영화 등록</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#">영화 예매</a></li>
						</c:otherwise>					
					</c:choose>
				</ul>
			
			
			</li>
			<li><a href="/PersonalProject/notice/notice">고객센터</a>
				<ul class="smenu">
					<li><a href="/PersonalProject/notice/notice">공지사항</a></li>
					<li><a href="/PersonalProject/qna/qna">QnA</a></li>
				</ul>			
			</li>
			<c:choose>
				<c:when test="${not empty sessionScope._USER_}">
					<li><a>마이 페이지</a>
						<ul class="smenu">
							<li><a href="/PersonalProject/reserve/inquiry">예매 조회</a></li>
							<li><a href="/PersonalProject/member/passwordcheck">회원정보수정</a></li>
						</ul>
					</li>
					<li style="width:250px;"><a>${sessionScope._USER_.name}님 (보유 마일리지: ${sessionScope._USER_.mileage}점)</a>
					</li>
					<li><a class="menuLink" href="/PersonalProject/member/logout">로그아웃</a></li>
				</c:when>
				<c:when test="${!empty sessionScope._GUEST_}">				
					<li><a href="/PersonalProject/reserve/inquiry">예매 조회</a></li>
					<li><a>${sessionScope._GUEST_.name}님</a></li>
					<li><a class="menuLink" href="/PersonalProject/member/logout">로그아웃</a></li>
				</c:when>
				<c:otherwise>
					<li><a class="menuLink" href="/PersonalProject/member/login">로그인</a></li>
					<li><a class="menuLink" href="/PersonalProject/member/regist">회원가입</a></li>
				</c:otherwise>				
			</c:choose>
		</ul>	
</nav>

