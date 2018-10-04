<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	});
</script>
 <style type="text/css">
  body {
    padding: 0px;
    margin: 0px;
    font-size: 12pt;
  }
  
  nav {
    background-color: #2056ac;
    padding: 15px;
    margin-bottom: 15px;
    text-align: center;
  }

  nav ul {
    padding: 0px;
    margin: 0px;
    
  }

  nav ul > li {
    display: inline-block;
    margin-left: 30px;
    color: #FFFFFF;
  }

  nav ul > li:first-child {
    margin-left: 0px;
  }
  
  nav ul > .leftMenu {
  	text-align: left;
  }
  
  .rightMenu {
  	text-align: right;
  }

  li > .menuLink, .menuLink:visited {
    text-decoration: none;
    color: #FFFFFF;
  }

  li > .menuLink:active {
    text-decoration: underline;
  }

  li > .menuLink:hover {
    color: #999;
  }
</style>
<nav>
	<ul>
		<li class="leftMenu"><a class="menuLink" href="/PersonalProject/">홈</a></li>
		<li class="leftMenu"><a id="ticket" class="menuLink" href="/PersonalProject/movie/movie">티켓 예매</a></li>		
		<li class="leftMenu"><a class="menuLink" href="/PersonalProject/notice/notice">고객센터</a></li>
		<c:choose>
			<c:when test="${!empty sessionScope._USER_}">
				<li>${sessionScope._USER_.name}님</li>
				<li>마이 페이지</li>
				<li><a class="menuLink" href="/PersonalProject/member/logout">로그아웃</a></li>
			</c:when>
			<c:when test="${!empty sessionScope._GUEST_}">				
				<li>${sessionScope._GUEST_.name}님</li>
				<li><a class="menuLink" href="/PersonalProject/member/logout">로그아웃</a></li>
			</c:when>			
			<c:otherwise>
				<li><a class="menuLink" href="/PersonalProject/member/login">로그인</a></li>
				<li><a class="menuLink" href="/PersonalProject/member/regist">회원가입</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>