$(document).ready(function() {

	generateDatatable('tableshippingsumary', [ [ 'id' ], [ 'creationDate', 'Data', true, 'date', 'datetime' ], [ 'department.name', 'Departamento' ], [ 'messageBody', 'Mensagem' ],

	[ 'amountTotal', 'Total Enviado' ], [ 'amountSent', 'Total com Sucesso' ], [ 'amountErrors', 'Total Erro' ], [ 'amountQueued', 'Total Aguardando' ],

	], 'paginate/' + $('#departments').val() + '/' + $('#initDate').val().replace(/\//g, '-') + '/' + $('#endDate').val().replace(/\//g, '-')

	);

	$('#textbox').keypress(function(event) {
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if (keycode == '13') {
			oTable.fnPageChange(document.getElementById("textbox").value - 1);
		}

	});

});
