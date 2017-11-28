<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<style>

	input[type=text] {
	    padding: 0;
	    height: 30px;
	    position: relative;
	    left: 0;
	    outline: none;
	    border: 1px solid #cdcdcd;
	    border-color: rgba(0,0,0,.15);
	    background-color: white;
	    font-size: 16px;
	}
	
	.passwordclass {
	    padding: 0;
	    height: 30px;
	    position: relative;
	    left: 0;
	    outline: none;
	    border: 1px solid #cdcdcd;
	    border-color: rgba(0,0,0,.15);
	    background-color: white;
	    font-size: 16px;
	}
	
	.label {
		font-size: 16px;
		
	}
	
	.stylingDiv {
		border-radius: 5px;
		padding:10px;
	
	
	}


        .btn {
		  -webkit-border-radius: 7;
		  -moz-border-radius: 7;
		  border-radius: 7px;
		  font-family: Georgia;
		  color: #000000;
		  font-size: 15px;
		  background: #dbdbdb;
		  padding: 6px 15px 6px 15px;
		  text-decoration: none;
		}
		
		.btn:hover {
		  background: #d5aed9;
		  text-decoration: none;
		}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body style="background-color: #d3ccb8">
	<div id="banner" align="center">
		<div id="wrapper" style="width: 100%; overflow: hidden;">
			<div id="container" style="width: 100%; margin-right: auto;">
				<img style="width: 100%;" src="https://i.imgur.com/p0McYtw.jpg" />
			</div>
		</div>
		<div  style="width: 75%;">
			<div style="width: 100%; margin-right: auto;">
				<a href="mainPublicPage">Home</a>
				<a href="login">Login</a>
			</div>
		</div>
	</div>
	<div class="stylingDiv">
	<form:form id="registerForm" modelAttribute="user" action="registerProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label class="label" path="username">Username  : </form:label></td>
				<td><form:input path="username" name="username" id="username" />
				</td>
			</tr>
			<tr>
				<td><form:label class="label" path="password">Password   : </form:label></td>
				<td><form:password class="passwordclass" path="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td><form:label class="label" path="nickname">Nickname : </form:label></td>
				<td><form:input path="nickname" name="nickname"
						id="nickname" /></td>
			</tr>
			<tr>
				<td><form:label class="label" path="email">E-mail : </form:label></td>
				<td><form:input path="email" name="email" id="email" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><form:button class="btn" id="register" name="register">Register</form:button>
				</td>
			</tr>
		</table>
	</form:form>
	<table align="center">
    	<tr>
    		<td style="font-style: italic; color: red;">${message}</td>
    	</tr>
     </table>
    </div>
</body>
</html>