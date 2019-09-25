<%@page import="model.UserLogModel"%>
<%@ page import="dto.UserLog " %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registro dias compensatorios</title>
	</head>
	<body>
		<jsp:include page="../common/Menu/Menu.jsp"/>

		<input type="button" value="estoy para probar el include."/>
		
		<div id="divPanel">
			<form action="cargarDias">
				<h2>Pedido de hora conpensatorios</h2>
				<input type="date" />
				<input type="submit" value="Solicitar" />
			</form>
		</div>
	</body>
</html>