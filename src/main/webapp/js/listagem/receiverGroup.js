$(document).ready(function() {

	var oTable = generateDatatable('tablereceivergroup', [ [ 'id' ], [ 'name', 'Nome' ], ], 'receiverGroup/paginate',

	function() {
		$("#tablereceivergroup tbody tr").click(function() {
			var position = oTable.fnGetPosition(this); // getting the clicked row position
			var contactId = oTable.fnGetData(this);
			id = contactId['id'];//or row[0] depend of situation
			document.location.href = "receiverGroup/" + id + "/editar";

		});
	});
	$('#textbox').keypress(function(event) {

		var keycode = (event.keyCode ? event.keyCode : event.which);
		if (keycode == '13') {
			oTable.fnPageChange(document.getElementById("textbox").value - 1);
		}

	});
});