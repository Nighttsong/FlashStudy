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
			<th>FlashCard Category</th>
			<th>FlashCard Set</th>
			<th>Privacy</th>
			<th>View</th>
			<th>Edit</th>
			<th>Print</th>
		</tr>
		
		 <c:forEach items="${FlashCardList}" var="flashcard" >
			<tr>
				<td>${flashcard.category}</td>
				<td>${flashcard.name}</td>
				 <td>${flashcard.privacy}</td>
				 <td><a href="/view?id=${flashcard.id}">View</a></td>
				 <td><a href="/edit?id=${flashcard.id}">Edit</a></td>
				 <td><a href="/print?id=${flashcard.id}">Print</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>