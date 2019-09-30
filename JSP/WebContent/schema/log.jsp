<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>NF-ENSIS Main</title>
	</head>
	<body>
		<form action="../LoginCheck" method="post">
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
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</body>

	<script type="text/javascript" src="/js/index.js"></script>
</html>