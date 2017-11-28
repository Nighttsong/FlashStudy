<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Study</title>
</head>
<script language="JavaScript" type="text/javascript" src="/js/jquery-1.2.6.min.js"></script>
<script language="JavaScript" type="text/javascript" src="/js/jquery-ui-personalized-1.5.2.packed.js"></script>
<script language="JavaScript" type="text/javascript" src="/js/sprinkle.js"></script>
<script type="text/javascript">
	
	var index =0;
	var current = "front";
// 	var data = $(FlashcardList).getFlashcards().get(index).getFront();
// 	document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
	
	function parseJSON(data) {
   		 return window.JSON && window.JSON.parse ? window.JSON.parse( data ) : (new Function("return " + data))(); 
	}
	
	function flipCard() {
		//var element = document.getElementById("FlashCardList");
		var personJson = $('#FlashCardList');
	   var person = parseJSON(personJson.val());
		var maybe = element.value;
		var yes = parseJSON(person);
		
		 if(current == "front"){
			//display back
			// document.getElementById("flashcard").textContent = $(FlashCardList).getFlashcards().get(index).getBack(); //the back
			 current = "back";
		 }else if(current=="back"){
			//display front
			// document.getElementById("flashcard").textContent = $(FlashCardList).getFlashcards().get(index).getFront();//the front
			 current = "front";
		 }
	 }
	function prevCard() {
		if(index==0){
			index = $(FlashcardList).getFlashcards().size()-1;
			current = "front";
			//document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
	
		}else{
			index--;
			current = "front";
			//document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
		}
	}
	function nextCard(){
		if(index >= $(FlashcardList).getFlashcards().size()){
			index = 0;
			current = "front";
			//document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
		}else{
			index++;
			current = "front";
			//document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
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
				<a href="register">Register</a>
				<a href="login">Login</a>
			</div>
		</div>
	</div>

	<button id="flashcard" onclick="flipCard()"></button>
	<button id="prev" onclick="prevCard()">prev</button><button id="next" onclick="nextCard()">next</button>
	<input type="hidden" id="FlashCardList" value="${FlashCardList}">     
</body>
</html>