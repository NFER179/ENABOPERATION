<%@ page import="java.io.File" %>
<%@ page import="java.lang.ProcessBuilder.Redirect" %>
<%@ page import="database.Test" %>
<%@ page import="database.DataBaseManager" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>NF-ENSIS</title>
	</head>
	<body>
		<%
			/*
			Test dbc = new Test();
			if (dbc.conexionUp()) {
				response.sendRedirect("schema/log.jsp");
			} else {
				response.sendRedirect("schema/common/database/dbsetting.jsp");
				out.write("<h1>Falla en la configuración de la base de datos.</h1>");
			}
			*/
			
	
			String mensaje = "lala";
			//DataBaseManager dbm = new DataBaseManager(mensaje);
			if (true) {
				response.sendRedirect("schema/log.jsp");
			} else {
				response.sendRedirect("schema/common/database/dbsetting.jsp");
				out.write("<h1>" + mensaje + "</h1>");
			}
		%>
	</body>
</html>