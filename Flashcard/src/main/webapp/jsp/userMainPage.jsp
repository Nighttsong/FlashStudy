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
				<a href="create">Create New Set</a> <a href="mainPublicPage">Home</a>
			</div>
		</div>
	</div>
	<h2>Personal Flash Card Sets</h2>
	<table align="center">
		<tr>
			<th>FlashCard Set</th>
			<th>Is Private</th>
			<th>Study</th>
			<th>View</th>
		</tr>
		
		 <c:forEach items="${FlashCardList}" var="flashcard" >
			<tr>
				<td>${flashcard.name}</td>
 				 <td>${flashcard.privacy}</td> 
 				 <td><a href="study/${flashcard.id}">Study</a></td> 
 				  <td><a href="view/${flashcard.id}">View</a></td>  
			</tr>
		</c:forEach>
	</table>
</body>
</html>