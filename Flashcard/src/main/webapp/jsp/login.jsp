<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<style>
.image {
	background-image: url("https://i.imgur.com/p0McYtw.jpg");
	
	
	background-repeat: no-repeat;
	background-width: 100%;
	background-size: 100% 350px;
	width: 100%;
	height: 350px;
	border-collapse: collapse;
	border-spacing: 0px;
	border-style: hidden;
}
</style>
<body style="background-color: #d3ccb8">
	<div id="banner" align=center>


		<table class="image">
			<tr align="right">
				<td><div style="padding-right: 15%; color: blue;">Home |
						Login</div></td>
			</tr>
			<tr>
				<td><div style="height: 150px;">
						</span></td>
			</tr> 
		</table>



		<div style="width: 75%;">
			<div style="width: 100%; margin-right: auto;">
				<a href="mainPublicPage">Home</a> <a href="register">Register</a>
			</div>
		</div>
	</div>
	<form:form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post">
		<table align="center">
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><form:input path="username" name="username" id="username" />
				</td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="login" name="login">Login</form:button>
				</td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>