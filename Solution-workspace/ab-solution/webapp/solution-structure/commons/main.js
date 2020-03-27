/* elements */
/* Buttons */
let btnOpenMenu = $("#btn-open-menu")
let btnCloseMenu = $( "#btn-close-menu" )
let btnFoot = $("#btn-foot")

/* Divs */
let menu = $( ".body-menu" )
let mainBody = $( ".body-main" )

/* functions */
/*
btnmenu.on( "click" , function() {
	if (menu.is(":visible")) {
		/* menu.hide("slide", {}, 1000, function(){}) */
/*		menu.width("0%")
		menu.hide();
	}
	else {
		/* menu.show("slide", {}, 1000, function(){}) */
/*		menu.width("15%")
		menu.hide();
	}
})
*/

btnOpenMenu.on( "click", function() {
	menu.width("15%")
	mainBody.width("85%")
})

btnCloseMenu.on( "click", function() {
	menu.width("0%")
	mainBody.width("100%")
})

btnFoot.on( "click" , function(){
	alert("foot");
})