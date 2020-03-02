<%@page import="solution.constants.JspTagNameConstant"%>
<%@page import="solution.controller.AppController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<!-- <title>Solution</title>
		<link rel="icon" href="<% out.write("varios/logo.png"); %>" > -->
		<link rel="stylesheet" href="index.css">
		<jsp:include page="varios/title.jsp"></jsp:include>
	</head>
	<body>
		<form action="LogIn" method="post">
			<table>
				<tbody>
					<tr>
						<td><label>Database</label></td>
						<td>
							<select name=<% out.write("'" + JspTagNameConstant.DATABASEID.var() + "'"); %>>
								<%
								AppController ac = AppController.getInstance();
								for (String s: ac.getDataBasesNames()) {
									out.write("<option value=\"" + s + "\">" + s + "</option>");
								}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<td><label>Usuario:</label></td>
						<td><input type='text' name=<% out.write("'" + JspTagNameConstant.USERID.var() + "'"); %> /></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><input type='password' name=<% out.write("'" + JspTagNameConstant.PASSWROD.var() + "'"); %> /></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type='Submit' id='LogIn' value='INGRESAR' /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>