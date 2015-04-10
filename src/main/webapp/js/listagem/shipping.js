$(document).ready(function() {

	var labels = new Array();
	labels['WAITING_SCHEDULE_DATE'] = {
		label : 'AGENDADO',
		color : 'blue'
	};
	labels['PROCESSING'] = {
		label : "PROCESSANDO",
		color : 'lightblue'
	};
	labels['STARTED'] = {
		label : 'INICIADO',
		color : 'lightblue'
	};
	labels['STOPED'] = {
		label : 'PARALIZADO',
		color : 'red'
	};
	labels['OK'] = {
		label : 'ATIVO',
		color : 'green'
	};
	labels['WAITING'] = {
		label : 'AGUARDANDO',
		color : 'orange'
	};
	labels['IMMEDIATE'] = {
		label : 'IMEDIATO',
		color : 'darkblue'
	};
	labels['READY_SEND'] = {
		label : 'PRONTO PARA ENVIO',
		color : 'lightgreen'
	};
	labels['SCHEDULED'] = {
		label : 'AGENDADO',
		color : 'darkblue'
	};
	labels['PARTITIONED'] = {
		label : 'PARTICIONADO',
		color : 'blue'
	};
	labels['SENT'] = {
		label : 'ENVIADO',
		color : 'green'
	};

	var oTable = generateDatatable({
		tableId : 'tableshipping',
		columns : [ [ 'id' ], [ 'creationDate', 'Data de Cadastro', true, 'date', 'datetime' ], [ 'message', 'Mensagem' ], [ 'type', 'Tipo de Envio' ], [ 'status', 'Status' ] ],
		urlAjax : 'shipping/paginate',
		fnRowCallback : function(row) {
			$(row).children().each(function(index, td) {

				$(td).html(!(obj = labels[$(td).html()]) ? $(td).html() : function() {
					$(td).css("color", obj.color);
					$(td).css("font-weight", "bold");
					return obj.label
				});

			});
		}

	});

	$('#textbox').keypress(function(event) {
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if (keycode == '13') {
			oTable.fnPageChange(document.getElementById("textbox").value - 1);
		}

	});

});