<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Study</title>
</head>
<script>
	
	var index =0;
	var current = "front";
	var data = $(FlashcardList).getFlashcards().get(index).getFront();
	document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
	function flipCard{
		 if(current == "front"){
			//display back
			 document.getElementById("flashcard").textContent = $(FlashCardList).getFlashcards().get(index).getBack(); //the back
			 current = "back";
		 }else if(current=="back"){
			//display front
			 document.getElementById("flashcard").textContent = $(FlashCardList).getFlashcards().get(index).getFront();//the front
			 current = "front";
		 }
	 }
	function prevCard{
		if(index==0){
			index = $(FlashcardList).getFlashcards().size()-1;
			current = "front";
			document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
	
		}else{
			index--;
			current = "front";
			document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
		}
	}
	function nextCard{
		if(index >= $(FlashcardList).getFlashcards().size()){
			index = 0;
			current = "front";
			document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
		}else{
			index++;
			current = "front";
			document.getElementById("flashcard").textContent =  $(FlashCardList).getFlashcards().get(index).getFront();
		}
	}
</script>
<body>
	<button id="flashcard" onclick="flipCard"></button>
	<button id="prev" onclick="prevCard">prev</button><button id="next" onclick="nextCard">next</button>
</body>
</html>