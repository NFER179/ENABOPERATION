<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.app.controllers.FilesController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String thisFileName = request.getSession().getAttribute("fileName").toString(), iconTab="logo.png";
FilesController fc = FilesController.getInstance();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Solution</title>
		<!-- <link  rel="icon" href="solution-structure/varios/logo.png"></link> -->
		<link  rel="icon" href="<% out.write(fc.getPathFromFileToFile(thisFileName, iconTab, "/")); %>"></link>
	</head>
	<body>

	</body>
</html>