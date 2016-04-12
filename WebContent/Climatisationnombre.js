$(document).ready(function() {
	$("#sourceNbID").blur(function() { // blur c'est le faite de perdre le
										// focus d'un champs

		$.ajax({
			url : 'ClimatisationajaxController',
			type : 'GET',
			dataType : 'text', // On désire recevoir du text
			success : function(texte) {
				$("#nbID").html(texte);
			}
		});

	});
});

/**
 * 
 */
