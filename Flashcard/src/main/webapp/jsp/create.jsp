<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body style="background-color: #d3ccb8">
	<div align="center" id="banner">
		<div id="wrapper" style="width: 75%; overflow: hidden;">
			<div id="container" style="width: 100%; margin-right: auto;">
				<img style="width: 100%;" src="https://i.imgur.com/p0McYtw.jpg" />
			</div>
		</div>
		<div style="width: 75%;">
			<div style="width: 100%; margin-right: auto;">
				<a href="userMainPage">My Flashcards</a> <a href="mainPublicPage">Home</a>
			</div>
		</div>
	</div>
	<div align="center">
		<div style="width: 75%; overflow: hidden;">
			<div align="center"
				style="width: 100%; margin-right: auto; overflow: hidden; -moz-box-shadow: 0 0 2px black; -webkit-box-shadow: 0 0 2px black; box-shadow: 0 0 2px black;">
				<form:form id="createForm" modelAttribute="flashCardSet"
					action="createProcess" method="post">
					<table id="myTable">
						<tr>
							<td>Flashcard Set Name:</td>
							<td><input type="text" name="flashcardSetName" id="flashcardSetName"><br></td>
						</tr>
						<tr>
							<td>Privacy: <select name="privacy" id="privacy"><option value="Y">Private</option>
									<option value="N">Public</option></select> <br> <td>
				
						</tr>
				<tr>
					<th>Front</th>
					<th>Back</th>
				</tr>
				<tr>
					<td><textarea rows="4" cols="35" id="front" name=" front"></textarea></td>
					<td><textarea rows="4" cols="35" id="back" name="back"></textarea></td>
				</tr>
				<tr>
					<td><textarea rows="4" cols="35" id="front" name=" front"></textarea></td>
					<td><textarea rows="4" cols="35" id="back" name="back"></textarea></td>
				</tr>
				<tr>
					<td><textarea rows="4" cols="35" id="front" name=" front"></textarea></td>
					<td><textarea rows="4" cols="35" id="back" name="back"></textarea></td>
				</tr>
				<tr>
					<td><textarea rows="4" cols="35" id="front" name=" front"></textarea></td>
					<td><textarea rows="4" cols="35" id="back" name="back"></textarea></td>
				</tr>
			</table>
			<button id="addplease" onclick="add()" type="button">+</button>
		
		</form:form>
		
		<button id="buildSet" onclick="buildSet()" type="button">Submit</button>
	</div>
	</div>
	</div>
</body>

<script type="text/javascript">
	function add() {
		var table = document.getElementById("myTable");
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		cell1.innerHTML = "<textarea rows=\"4\" cols=\"35\" name=\"front\" id=\"front\"></textarea>";
		cell2.innerHTML = "<textarea rows=\"4\" cols=\"35\" name=\"back\" id=\"back\"></textarea>";
	}
	
	function buildSet() {
		var table = document.getElementById("myTable");
		var rowCount = table.rows.length;
		var FrontBack = [];
		$('#myTable').find('textarea').each(function(){
			FrontBack.push(this.value);
		});
// 		 $("#myTable").find("#flashcardSetName");
// 		var flashcardSetName = document.getElementById('flashcardSetName').value();
// 		var privacy = document.getElementById('privacy').value();
// 		alert(privacy);
// 		alert(flashcardSetName);
	}
	
</script>

</html>