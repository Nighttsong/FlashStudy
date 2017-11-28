<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	th, td {
    	padding: 15px;
    	text-align: left;
	}
	table, th, td {
    	border: 1px solid black;
	}
</style>
<script type="text/javascript"> 

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body style="background-color: #d3ccb8">
	<div id="banner" align="center">
		<div id="wrapper" style="width: 100%; overflow: hidden;">
			<div id="container" style="width: 100%; margin-right: auto;">
				<img style="width: 100%;" src="https://i.imgur.com/p0McYtw.jpg" />
			</div>
		</div>
		<div style="width: 75%;">
			<div style="width: 100%; margin-right: auto;">
				<a href="/Flashcard/mainPublicPage">Home</a>
			</div>
		</div>
	</div>
	<center><h2>${name}</h2></center>
	<table align="center">
		<tr>
			<th>Front</th>
			<th>Back</th>
		</tr>
		
		 <c:forEach items="${FlashCardList}" var="flashcard" >
			<tr>
				<td>${flashcard.front}</td>
 				 <td>${flashcard.back}</td> 
 				 
			</tr>
		</c:forEach>
	</table>
	<center><a href="javascript:window.print();">Print</a></center>
</body>
</html>