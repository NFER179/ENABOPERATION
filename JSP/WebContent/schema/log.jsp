<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NF-ENSIS Main</title>
</head>
<body>
	<div id='divlog'>
		<form action="../LoginCheck" method="post">
			<!--
			<table>
				<tr>
					<td><label>Usuario: </label></td>
					<td><input type="text" name="uName"></td>
				</tr>
				<tr>
					<td><label>Password: </label></td>
					<td><input type="password" name="uPass"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" class="accept"></td>
				</tr>
			</table>
			-->
			<label>Usuario: </label>
			<input type="text" name="uName">
			<label>Password: </label>
			<input type="password" name="uPass">
			<input type="submit" value="Login" class="accept">
		</form>
	</div>
</body>

<script type="text/javascript" src="/js/index.js"></script>
<link type="text/css" rel="stylesheet" href="css/log.css">
</html>