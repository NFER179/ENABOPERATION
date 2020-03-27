<%@page import="com.app.controllers.FilesController"%>
<%@page import="solution.login.AppSession"%>
<%@page import="solution.constants.VarSessionConst"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String thisFileName = "main.jsp", titleJsp = "title.jsp";

HttpSession fileSession = request.getSession();
fileSession.setAttribute("fileName", thisFileName);

FilesController fc = FilesController.getInstance();
String titlePage = fc.getPathFromFileToFile(thisFileName, titleJsp, "/");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="<% out.write(fc.getPathFromFileToFile(thisFileName, "main.css", "/")); %>">
		<jsp:include page="<%= titlePage %>"></jsp:include>
	</head>
	<body>
		<div class="head" >
			<div class="welcome">
				<span>Hello <%
				AppSession as = (AppSession)request.getSession().getAttribute(VarSessionConst.APPSESSION.var());
				out.print(as.getUserName());
				%></span>
			</div>
			<div>
				<input type="button" id="btn-open-menu" value="&#9776; Open" />
			</div>
		</div>
		<div id="toggle" class="body-menu">
			<div><span class=closebtn id="btn-close-menu">&times;</span></div>
			<div class="module">
				<span>Contract</span>
			</div>
			<div class="task">
				<span>Currency</span>
			</div>
		</div>
		<div class="body-main">
			<span>main</span>
		</div>
		<div class="foot" >
			<div>
				<input type="button" id="btn-foot" value="Foot" />
			</div>
		</div>
	</body>
	<script type="text/javascript" src="<% out.write(fc.getPathFromFileToFile(thisFileName, "uncompressed_development_JQuery_3_4_1.js", "/")); %>" ></script>
	<script type="text/javascript" src="<% out.write(fc.getPathFromFileToFile(thisFileName, "main.js", "/")); %>" ></script>
</html>