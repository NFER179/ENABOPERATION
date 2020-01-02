<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="LogIn" method="post">
			<table>
				<tbody>
					<tr>
						<td><label>Usuario:</label></td>
						<td><input type='text' id='usrid' /></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><input type='password' id='usrpss' /></td>
					</tr>
					<tr>
						<td>
							<input type='Submit' id='LogIn' value='INGRESAR' />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>