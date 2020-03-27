<%@page import="com.app.utils.TreeStructure"%>
<%@page import="solution.constants.JspTagNameConstant"%>
<%@page import="solution.controller.AppController"%>
<%@page import="com.app.controllers.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String thisFileName = "index.jsp";

HttpSession fileSession = request.getSession();
fileSession.setAttribute("fileName", thisFileName);

FilesController fc = FilesController.getInstance();
String titleJsp = fc.getAbsolutPathTo("title.jsp", "/");
%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<!-- <title>Solution</title>
		<link rel="icon" href="<% out.write("varios/logo.png"); %>" > -->
		<link rel="stylesheet" href="<% out.write(fc.getAbsolutPathTo("index.css", "/")); %>">
		<%-- <jsp:include page="solution-structure/varios/title.jsp"></jsp:include> --%>
		<jsp:include page="<%= titleJsp %>"></jsp:include>
		<!-- <style type="text/css">
			html, body, div, iframe { 
				margin:0; 
				padding:0; 
				height:100%; 
			} 
			iframe { 
				display:block; 
				width:100%; 
				border:none; 
			} 
		</style> -->
	</head>
	<body>
    	<div id="div-information" class="div-information-no-login">
			<div class="div-paragraft">
				<p>
					Holas mundo, este es un texto prueba para probar el formato del layout.
				</p>
			</div>
			<input type="button" id="btn-show-login-panel" value="&#9776; Mostrar"/>
		</div>
		<div class="div-form-login" >
			<input type="button" id="btn-hidden-login-panel" value="&times;"/>
			<br>
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
		</div>
	</body>
	<script type="text/javascript" src="<% out.write(fc.getAbsolutPathTo("uncompressed_development_JQuery_3_4_1.js", "/")); %>" ></script>
	<script type="text/javascript" src="<% out.write(fc.getAbsolutPathTo("index.js", "/")); %>" ></script>
</html>