let w = "width"
let classSelect = "Select"
let classMenuItemShow = "div-menu-hidden"

$( window ).on( "load", function() {
    $( ".ul-menu-hidden" ).toggle()
    $( ".li-menu-hidden" ).toggle()
})

$( "#btn-open-close-menu" ).on( "click", function() {

    if ($( "#div-menu-body" ).css( w ) == "0px" ) {
        $( "#div-menu-body" ).css( w, "250px" )
      
        let a = $( "#div-main" ).css( w ).split( "px" );
        $( "#div-main" ).css( w, a[0] - 250)
        $( "#div-main" ).css( "margin-left", "250px" )
    } else {
        $( "#div-menu-body" ).css( w, "0px" )

        $( "#div-main" ).css( w, "100%")
        $( "#div-main" ).css( "margin-left", "0px" )
    }

    $( "#btn-lines-cross" ).toggleClass( "change" );
});

function menuUI( list ) {

    let timer = 250

    if ( list.hasClass( classSelect ) ) {
        selectAndUnselectListElement( list, 0 )
        showAndNoShow( list, timer )
    } else {
        showAndNoShow( list, 0 )
        selectAndUnselectListElement( list, timer )
    }
}

/*
 * Function to mark list element as select or not select item
 */
function selectAndUnselectListElement( liElement, mls ) {
    liElement.toggleClass( classSelect )

    //liElement.children( "div" ).toggle( 1000 )
    //liElement.children( "div" ).children( "ul" ).children( "li" ).toggle( 1000 )
    
    liElement.children( "div" ).children( "ul" ).delay( mls ).toggle( 500 )
    liElement.children( "div" ).children( "ul" ).children( "li" ).toggle( 500 )

 /*   liElement.children( "div" ).children( "ul" ).children( "li" ).each( function() {
        $( this ).toggle( "slow" )
    })
*/    //liElement.children( "div" ).toggle( "slow" )
    //liElement.children( "div" ).toggleClass( classMenuItemShow ) //Hago visible el grupo
}

/**
 * 
 */
function showAndNoShow( liElement, mls ) {

    liElement.parent().children( "li" ).delay( mls )
    liElement.parent().children( "li" ).each( function() {
        let menuList = $( this )
        if ( !menuList.is( liElement ) ) {
            menuList.toggle( 500 ) 
        }
    })
}

$( ".link-menu-module" ).on( "click", function() {
    let parent = $( this ).parent()
 //   parent.children( "div" ).toggle( "slow" )
    //parent.children( "div" ).toggleClass( classMenuItemShow ) //Hago visible el grupo
 //   parent.toggleClass( classSelect )

    menuUI( parent )
});

$( ".link-menu-group" ).on( "click", function() {
    let parent = $( this ).parent()
 //   parent.children( "div" ).toggle( "slow" )
    /* parent.children( "div" ).toggleClass( classMenuItemShow ) */
 //   parent.toggleClass( classSelect );

    menuUI( parent )
});
