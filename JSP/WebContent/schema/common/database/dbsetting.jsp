<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DataBase Setting</title>
<script>
function openPopUp() {
	alert("Open");
}
</script>
</head>
<body>
	<div id="modal" class="modal-form-popup" >
		<form>
			<p>URL: </p>
			<input type="text">
			<p>USer: </p>
			<input type="text">
			<p>Pass: </p>
			<input type="text">
			<p>enginier database: </p>
			<input type="text">
			<fieldset>
				<input type="button" id="abtnTest" value="Test">
				<input type="button" id="abtnSave" value="Save">
			</fieldset>
		</form>
	</div>
	<fieldset>
		<!-- <input type="button" value="Add" id="DataBaseSettingAdd" onClick="openPopUp()"> -->
		<input type="button" value="Add" id="DataBaseSettingAdd">
	</fieldset>
	<!-- <div class="form-popup" id="myForm" >
		<form class="form-container">
			<h1>New Setting</h1>
		</form>
	</div>
	<form>
		<
	</form> -->
	<!--
	<a href='#' onclick='javascript:window.open("http://www.google.com", "_blank", "scrollbars=1,resizable=1,height=300,width=450");' title='Pop Up'>Pop Up</a>
	-->
	<form action="">
		<table id="tblConfiguration">
			<thead>
				<tr>
					<th>URL</th>
					<th>User</th>
					<th>pass</th>
					<th>engine</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</form>
</body>
<script type="text/javascript" src="../../../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../../js/jquery-1.12.1.ui.js"></script>
<script type="text/javascript" src="dbsetting.js"></script>
<link type="text/css" rel="stylesheet" href="../../../css/commons.css">
</html>