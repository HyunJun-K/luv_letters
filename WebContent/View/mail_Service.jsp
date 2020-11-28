<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mail Service</title>
</head>

<!--  capcha -->
 <script src="https://www.google.com/recaptcha/api.js" async defer></script>


<!-- Jquery cdn -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<!-- css link & Js link  -->
<link rel="stylesheet" type="text/css" href="../CSS/mails.css">
<script type="text/javascript" src="../JS/mails.js"></script>


<body>
	<div id="form-div">
		<form class="form" id="form1" name="myforms" action="mailSend_ok.ME" method="POST" onsubmit="return chk_data()">
			
			
			
			<p class="name">
				<input name="title" type="text"
					class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
					placeholder="Title" id="name" />
			</p>


			<p class="email">
				<input name="email" type="text"
					class="validate[required,custom[email]] feedback-input" id="email"
					placeholder="Email" />
			</p>
			
			<p class="text">
				<textarea name="text"
					class="validate[required,length[6,300]] feedback-input"
					id="comment" placeholder="Comment"></textarea>
			</p>
		
			<p class="g-recaptcha " data-sitekey="6LffD-IZAAAAANuqCjSeHuEyjZ9AXUQn9jFkn5NZ"></p> 
				
			<div class="submit">
				<!--  <input type="submit" id="button-blue" />-->
				<button type="submit" id="button-blue"> 전송</button>
				<button type="button" id="button-blue"onclick="history.back()"> 취소 </button>
				<div class="ease"></div>
			</div>
			
		
		
		</form>
	</div>

<jsp:include page="../loading/emailLoading.jsp"/>
</body>
</html>