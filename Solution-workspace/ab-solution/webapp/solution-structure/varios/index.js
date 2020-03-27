/* variables */
let divInformation = $( "#div-information" )
let divLogIn = $( ".div-form-login" )
let btnMostrar = $( "#btn-show-login-panel" )
let btnOcultar = $( "#btn-hidden-login-panel" )

/*
let tgl = function() {
	if ( $(this).attr('value') === "Mostrar") {
		divInformation.attr('class', 'div-information-login')
		$( ".div-form-login" ).width('28%')
		$( ".div-form-login" ).css({"padding":"1%"})
	} else {
		divInformation.attr('class',  'div-information-no-login')
		$( ".div-form-login" ).width('0%')
		$( ".div-form-login" ).css({"padding":"0%"})
	}
	
	//$( ".div-form-login" ).toggle( "slow", function() {})
	//$( ".div-form-login" ).toggle( "clip", function() {})
	btnMostrar.toggle( "clip" )
}

btnMostrar.on( "click", tgl)
btnOcultar.on( "click", tgl)
*/
btnMostrar.on( "click", function() {
	divInformation.attr('class', 'div-information-login')
	divLogIn.width('28%')
	divLogIn.css({"padding":"1%"})
	btnMostrar.toggle( "clip" )
})

btnOcultar.on( "click", function() {
	divInformation.attr('class',  'div-information-no-login')
	divLogIn.width('0%')
	divLogIn.css({"padding":"0%"})
	btnMostrar.toggle( "clip" )
})