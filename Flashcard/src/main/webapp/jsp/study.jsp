<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Study</title>
</head>
<style>
		#flashcard {
            width: 500px;
            height: 250px;
            margin: 10px;
            background-size: 100%;
            font-size: 21px;
            font-family: Georgia;
            box-shadow: 3px 3px 0px #666666;
        }
        
        .btn {
		  -webkit-border-radius: 7;
		  -moz-border-radius: 7;
		  border-radius: 7px;
		  font-family: Georgia;
		  color: #000000;
		  font-size: 11px;
		  background: #dbdbdb;
		  padding: 7px 13px 7px 13px;
		  text-decoration: none;
		}
		
		
		.btn:hover {
		  background: #d5aed9;
		  text-decoration: none;
		}
</style>
<script type="text/javascript">
	
	var index = 0;
	var current = "back";
	var data = [];
	
	function parseJSON(data) {
   		 return window.JSON && window.JSON.parse ? window.JSON.parse( data ) : (new Function("return " + data))(); 
	}
	
	function flipCard() {
		if(data === undefined || data == null || data.length <= 0) {
			var element = document.getElementById("FlashCardList");
			var maybe = element.value;
			var maybe = maybe.replace(/\'/g, "\"");
			data = parseJSON(maybe);
		}
		 if(current == "front"){
			//display back
			 document.getElementById("flashcard").innerHTML  = data[index].back;
			 current = "back";
		 }else if(current=="back"){
			//display front
			document.getElementById("flashcard").innerHTML  = data[index].front;
			current = "front";
		 }
	 }
	function prevCard() {
		if(data === undefined || data == null || data.length <= 0) {
			var element = document.getElementById("FlashCardList");
			var maybe = element.value;
			var maybe = maybe.replace(/\'/g, "\"");
			data = parseJSON(maybe);
		}
		if(index==0){
			index = data.length-1;
			current = "front";
			document.getElementById("flashcard").innerHTML  = data[index].front;
		}else{
			index--;
			current = "front";
			document.getElementById("flashcard").innerHTML  = data[index].front;
		}
	}
	function nextCard(){
		if(data === undefined || data == null || data.length <= 0) {
			var element = document.getElementById("FlashCardList");
			var maybe = element.value;
			var maybe = maybe.replace(/\'/g, "\"");
			data = parseJSON(maybe);
		}
		if(index+1 == data.length){
			index = 0;
			current = "front";
			document.getElementById("flashcard").innerHTML  = data[index].front;
		}else{
			index++;
			current = "front";
			document.getElementById("flashcard").innerHTML  = data[index].front;
		}
	}
</script>
<body style="background-color: #d3ccb8">
	<div id="banner" align="center">
		<div id="wrapper" style="width: 100%; overflow: hidden;">
			<div id="container" style="width: 100%; margin-right: auto;">
				<img style="width: 100%;" src="https://i.imgur.com/p0McYtw.jpg" />
			</div>
		</div>
		<div  style="width: 75%;">
			<div style="width: 100%; margin-right: auto;">
				<a href="/Flashcard/mainPublicPage">Home</a>
				<a href="/Flashcard/register">Register</a>
				<a href="/Flashcard/login">Login</a>
			</div>
		</div>
	</div>

	<center><button id="flashcard" onclick="flipCard()">Press Flashcard to Start</button></center>
	<center>
	<button class="btn" id="prev" onclick="prevCard()"><<</button>      <button class="btn" id="next" onclick="nextCard()">>></button>
	<input type="hidden" id="FlashCardList" value="${FlashCardList}" >     
	</center>
</body>
</html>