/**
 * 
 */
dialog = $( "#modal" ).dialog({
	autoOpen: false,
	height: 400,
	width: 350,
	modal: true,
	/*buttons: {
		//"Create an account": addUser,
		Cancel: function() {
			dialog.dialog( "close" );
		}
	},
	close: function() {
		form[ 0 ].reset();
		allFields.removeClass( "ui-state-error" );
	}*/
});

$("#DataBaseSettingAdd").click(function(){
	/*var myWindow = window.open("newdatabaseconfiguration.jsp", "myWindow", "width=200, height=100");*/
	$("#modal").dialog("open");
});

$("#abtnSave").click(function(){
	$("#tblConfiguration").append("<tr>" +
			"<td>http//:loquesea</td>" +
			"<td>nicolas</td>" +
			"<td>pass</td>" +
			"<td>MySql</td>" +
			"<td><input type='checkbox'/></td>" +
			"</tr>");
	$("#modal").dialog("close");
});