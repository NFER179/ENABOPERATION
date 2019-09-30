<%@page import="model.UserLogModel"%>
<%@ page import="dto.UserLog " %>
<div id="HeadMenu">
	<div id="head-menu">
		<div>
			Wellcome <b><% UserLog ul = (UserLog)session.getAttribute("usr");
			out.print(ul.getName());%></b>
		</div>
		<div>
			<b>Configuration</b>
		</div>
		<div>
			<details>
				<ul>
					<li>
						<input type="submit" id="exit" value="[->" />
					</li>
				</ul>
			</details>
		</div>
	</div>
	<!-- <div id="divMenu"> -->
	<div class="menu" tabindex="0" >
		<!-- 
		<div>
			<h3><b>|||</b></h3>
		</div>
		-->
		<header class="avatar">
			<!-- <img src="https://s3.amazonaws.com/uifaces/faces/twitter/kolage/128.jpg" /> -->
			<img src="../../<% out.print(ul.getPhoto()); %>" />
			<!-- <h2>UserName</h2> -->
			<h2><% out.print(ul.getName()); %></h2>
		</header>
		<!-- 
		<ul>
			<li tabindex="0" class="icon-dashboard"><span>Dashboard</span></li>
			<li tabindex="0" class="icon-customers"><span>Customers</span></li>
			<li tabindex="0" class="icon-users"><span>Users</span></li>
			<li tabindex="0" class="icon-settings"><span>Settings</span></li>
		</ul>
		-->
		<ul class="menu-task">
			<li>Pedidos
				<ul>
					<li>Pedido de días</li>
					<li>Cambio de horarios</li>
				</ul>
			</li>
			<li>Autoevaluación
				<ul>
					<li>Elementos a evaluar</li>
				</ul>
			</li>
		</ul>
	</div>
	<input type="button" value="button-test"/>
</div>
<link type="text/css" rel="stylesheet" href="../css/head-menu.css">
<link type="text/css" rel="stylesheet" href="../css/smartphone-menu-trigger.css">
<link type="text/css" rel="stylesheet" href="../css/commons.css">