	$(document).ready(function() {

		var oTable =	generateDatatable('tablereceiver',
									[['id'],
									 ['name','Nome'],['surname','Sobrenome'],['contact.phone','Telefone'],['contact.cellphone','Celular'],['contact.email','Email']
									], 
									
									'receiver/paginate',
									
									function() {
										$("#tablereceiver tbody tr").click(function() {									
											var position = oTable.fnGetPosition(this); // getting the clicked row position
											var contactId = oTable.fnGetData(this);
											id=contactId['id'];//or row[0] depend of situation
											document.location.href = "receiver/" +id+"/editar";
																
									
									});
								});
					
									$('#textbox').keypress(function(event){
										 
										var keycode = (event.keyCode ? event.keyCode : event.which);
										if(keycode == '13'){
											oTable.fnPageChange( document.getElementById("textbox").value-1 );									}
									 
									});
							}); 
								
							
						
	