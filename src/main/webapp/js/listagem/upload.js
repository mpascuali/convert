	$(document).ready(function() {

		var oTable =	generateDatatable('tableupload',
									[['id'],
									 ['uploadDate','Data Upload',true,'date','datetime'], ['name','Nome'],['status']
									], 
									
									'../upload/paginate',
									
									function() {
										$("#tableupload tbody tr").click(function() {									
											var position = oTable.fnGetPosition(this); // getting the clicked row position
											var contactId = oTable.fnGetData(this);
											id=contactId['id'];//or row[0] depend of situation
											document.location.href = "upload/" +id+"/editar";
																
									
									});
								}
									);
					
				});
								
							
						
	