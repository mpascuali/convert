
$(document).ready(function() {
		

	
	var oTable = generateDatatable({
		tableId : 'tableuser',
		columns : [ [ 'id' ], [ 'name', 'Nome' ],
				[ 'surname', 'Sobrenome' ], [ 'cpf', 'CPF' ],
				[ 'status', 'Status' ], [ 'contact.email', 'Email' ],
				[ 'perfil' ] ],
		urlAjax : 'user/paginate',
		fnCallBack : function() {
			$("#tableuser tbody tr").click(function() {
				var position = oTable.fnGetPosition(this); // getting
				// the
				// clicked
				// row
				// position
				var contactId = oTable.fnGetData(this);
				id = contactId['id'];// or row[0] depend of situation
				document.location.href = "user/" + id + "/editar";

			});

		},
		fnRowCallback:function(row){
			  $(row).children().each(function(index, td){
	    	        if ($(td).html().indexOf("OK") == 0) {
	    	        	$(td).html("ATIVO");
	    	        	$(td).css("color", "green");
	    	        }
	    	        if ($(td).html().indexOf("WAITING") == 0) {
	    	        	$(td).html("AGUARDANDO ENVIO");
	    	        	$(td).css("color", "orange");
	    	        }
	    	    });
		}

	});
	

			$('#textbox').keypress(
					function(event) {

						var keycode = (event.keyCode ? event.keyCode
								: event.which);
						if (keycode == '13') {
							oTable.fnPageChange(document
									.getElementById("textbox").value - 1);
						}

					});

		});