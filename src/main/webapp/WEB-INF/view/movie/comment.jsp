<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		$("input[type=radio][name=rating]").click(function() {
			if ( $(this).val() == "" ){
				alert("평점을 선택해주세요!")
			}
			alert( $(this).val() );
		});
	});
</script>
<style>
fieldset,
label {
  margin: 0;
  padding: 0;
  margin-bottom: 20px;
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
	<form>
		<div>
			내용<input type="text" name="comment" placeholder="후기를 입력해주세요">
		</div>
		
		<fieldset class="rating">
			<legend>평점</legend>
			<input type="radio" id="5star" name="rating" value="5" />
			<label class="full" for="5star" title="핵잼"></label>
			
			<input type="radio" id="4halfstar" name="rating" value="4.5" />
			<label class="half" for="4halfstar" title="존잼"></label>
			
			<input type="radio" id="4star" name="rating" value="4" />
			<label class="full" for="4star" title="꿀잼"></label>
			
			<input type="radio" id="3halfstar" name="rating" value="3.5" />
			<label class="half" for="3halfstar" title="걍잼"></label>
			
			<input type="radio" id="3star" name="rating" value="3" />
			<label class="full" for="3star" title="잼"></label>
			
			<input type="radio" id="2halfstar" name="rating" value="2.5" />
			<label class="half" for="2halfstar" title="노잼"></label>
			
			<input type="radio" id="2star" name="rating" value="2" />
			<label class="full" for="2star" title="걍노잼"></label>
			
			<input type="radio" id="1halfstar" name="rating" value="1.5" />
			<label class="half" for="1halfstar" title="꿀노잼"></label>
			
			<input type="radio" id="1star" name="rating" value="1" />
			<label class="full" for="1star" title="존노잼"></label>
			
			<input type="radio" id="halfstar" name="rating" value="0.5" />
			<label class="half" for="halfstar" title="핵노잼"></label>
  		</fieldset>
  		
	</form>

	<a href="/PersonalProject/movie/apilist">리스트</a>
</body>
</html>