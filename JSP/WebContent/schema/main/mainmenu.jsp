<%@page import="model.UserLogModel"%>
<%@page import="dto.UserLog " %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registro dias compensatorios</title>
	</head>
	<body>
		<div id="divHead">
		Well come <% UserLog ul = (UserLog)session.getAttribute("usr");
		out.print(ul.getNick());%>
		</div>
		<div id="divMenu">
			<ul>
				<li>Pedidos<ul>
					<li>Pedido de días</li>
					<li>Cambio de horarios</li>
				</ul></li>
			</ul>
		</div>
		<div id="divPanel">
			<form action="cargarDias">
				<h2>Pedido de hora conpensatorios</h2>
				<input type="date" />
				<input type="submit" value="Solicitar" />
			</form>
		</div>
	</body>
</html>