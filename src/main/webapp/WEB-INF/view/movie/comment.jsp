<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" type="text/css">
<title>Insert title here</title>
<script src="/PersonalProject/js/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {
		var userSession = "${sessionScope._USER_.name}";
		
		if ( userSession == "" ) {
			$("#movieComment").prop('readonly',true);
			$("#movieComment").val("영화 후기는 회원만 등록하실 수 있습니다.");
			$("#registBtn").prop("disabled", true);
		}
		
		var isCheck=false;
		$("input[type=radio][name=grade]").on('click', function() {
			isCheck = $(this).prop("checked");
			
		});
		$("#registBtn").click(function() {
			if ( $("#movieComment").val() == "" ) {
				alert("후기 내용을 입력하세요");
				$("#movieComment").focus();
				return;
			}
			
			if ( $("#movieComment").val().length <10 ) {
				alert("후기는 10자 이상 입력하셔야 합니다");
				$("#movieComment").focus();
				return;
			}
			if ( isCheck == false ) {
				alert("평점을 선택해주세요!");
				return;
			}
			$.post("/PersonalProject/movie/comment"
					, $("#registForm").serialize()
					, function(response) {
						if (response == true) {
							location.href="/PersonalProject/movie/comment/${movieVO.movieCode}";
						}
			});
		});
		
	});
</script>
<style>
fieldset,
label {
  margin: 0;
  padding: 0;
  margin-bottom: 10px;
}

.rating {
  border: none;
  float: left;
}

.rating>input {
  display: none;
}

.rating>label:before {
  margin: 5px;
  font-size: 1.25em;
  font-family: FontAwesome;
  display: inline-block;
  content: "\f005";
}

.rating>.half:before {
  content: "\f089";
  position: absolute;
}

.rating>label {
  color: #ddd;
  float: right;
}

.rating>input:checked~label,

/* show gold star when clicked */

.rating:not(:checked)>label:hover,

/* hover current star */

.rating:not(:checked)>label:hover~label {
  color: #FFD700;
}


/* hover previous stars in list */

.rating>input:checked+label:hover,

/* hover current star when changing rating */

.rating>input:checked~label:hover,
.rating>label:hover~input:checked~label,

/* lighten current selection */

.rating>input:checked~label:hover~label {
  color: #FFED85;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	<div style="position:relative; top: 10%; left: 30%; width:900px;">
		<div>
			<div style="float:left; padding-right: 20px;">
				<img src="/PersonalProject/img/${movieVO.poster}"/>
			</div>
			<div style="margin: 15px;">
				<div style="padding-bottom:10px;">
					<span style="display: inline-block; width: 75px;font-weight: bold; padding-right:10px;">제목</span>
					<span>${movieVO.movieName}</span>
				</div>
				<div style="padding-bottom:10px;">
					<span style="display: inline-block; width: 75px;font-weight: bold; padding-right:10px;">상영시간</span>
					<span>${movieVO.runningTime}분</span>
				</div>
				<div style="padding-bottom:10px;">
					<span style="display: inline-block; width: 75px;font-weight: bold; padding-right:10px;">평점 </span>
					<span> ${movieVO.grade}</span>
				</div>			
			</div>
		</div>
		<div>
			<c:choose>
				<c:when test="${not empty  movieVO.movieCommentList}">
					<c:forEach items="${movieVO.movieCommentList}" var="comment">
						<div style="padding-top: 15px; clear:both;">
							<div style="font-size: 15px; font-weight: bold;">${comment.memberVO.name}</div>
							<div style="padding-left: 12px;">${comment.content}</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					등록된 후기가 없습니다
				</c:otherwise>
			</c:choose>
		</div>
		<div style="padding-top: 15px;">
			<form id="registForm">
				<div>
					<input type="hidden" name="movieCode" value="${movieVO.movieCode}"/>
				</div>
				<div>
					<span style="font-weight:bold; padding-right:10px;">내용</span>
					<input style="width: 250px;"type="text" id="movieComment" name="content" placeholder="후기를 입력해주세요 (10자 이상 입력)">
				</div>
				<div>
					<fieldset class="rating">
						<legend style="font-weight:bold;">평점</legend>
						<input type="radio" id="5star" name="grade" value="5" />
						<label class="full" for="5star"></label>
						
						<input type="radio" id="4halfstar" name="grade" value="4.5" />
						<label class="half" for="4halfstar"></label>
						
						<input type="radio" id="4star" name="grade" value="4" />
						<label class="full" for="4star"></label>
						
						<input type="radio" id="3halfstar" name="grade" value="3.5" />
						<label class="half" for="3halfstar" ></label>
						
						<input type="radio" id="3star" name="grade" value="3" />
						<label class="full" for="3star"></label>
						
						<input type="radio" id="2halfstar" name="grade" value="2.5" />
						<label class="half" for="2halfstar"></label>
						
						<input type="radio" id="2star" name="grade" value="2" />
						<label class="full" for="2star"></label>
						
						<input type="radio" id="1halfstar" name="grade" value="1.5" />
						<label class="half" for="1halfstar"></label>
						
						<input type="radio" id="1star" name="grade" value="1" />
						<label class="full" for="1star" ></label>
						
						<input type="radio" id="halfstar" name="grade" value="0.5" />
						<label class="half" for="halfstar"></label>
			  		</fieldset>
			  		<div style="clear:both;">
			  		<input type="button" id="registBtn" value="등록"/>
		  		</div>
				</div>		  		
			</form>			
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>