$(document).ready(function() {
	if($("#drp_Books_Ill_Illustrations2").length > 0 && $('#xxx').length > 0){
		$("#drp_Books_Ill_Illustrations2").select2().select2('val',JSON.parse($('#xxx').val()|| "null"));
	}
});



var message="";

$('#txtMessage').keyup(function() {
	var tamanho = this.value.replace(/\[([^\]]+)\]/g, "").length;
     $('#charCount').text(tamanho);
     if(tamanho <= 150){
    	 setValues('SMS',"#348ce8");
     } else if(tamanho <= 250){
    	 setValues('Premium I',"#54Ace8");
     } else if(tamanho <= 380){
    	 setValues('Premium II',"#74Cce8");
     } else{
    	 setValues('Premium III',"#94Ece8");
     } 
    	 
});

function setValues(text,color){
	 $('#tiposms')[0].innerText  = text;
	 $("#box_tipo").css("background-color", color);
	 $("#tiposms").css("background-color", color);
	 $("#iconesms").css("background-color", color);
	 $("#iconespan").css("background-color", color);
}


/**** QUICK PAGINATION***/
$(document).ready(function() {
	$("ul.pagination1").quickPagination({pageSize:"3"});
});


/**** MULTI SELECT***/


var selectedValues = new Array();
selectedValues[0] = "a";
selectedValues[1] = "c";

$('#drp_Books_Ill_Illustrations2').select2();


function changeType(type) {
	$('#shipType').val(type);

	if (type == 'PARTITIONED') {
		$('#schedPartition').show('fast');
		$('#schedDate').hide();
	} else if (type == 'SCHEDULED') {
		$('#schedPartition').hide();
		$('#schedDate').show('fast');
	} else if (type == 'IMMEDIATE') {
		$('#schedPartition').hide();
		$('#schedDate').hide();
	}
	
	$('#dateSched').hideBalloon();
	$('#date').hideBalloon();
	$('#total').hideBalloon();

}

var counter = 1;
$(document).ready(function() {
	
$('input:radio[name="entity.type"]').filter('[value="IMMEDIATE"]').attr(
			'checked', true);

$('#date').datetimepicker({
	dateFormat : 'dd/mm/yy'
});

$('#dateSched').datetimepicker({
	dateFormat : 'dd/mm/yy'
});

$('#sbmtBtn').click(function(){
	$('#checkshipping').submit();
});


	$('#remove').click(function() {
			if ($('#mytable tbody>tr').length > 2) {
				$('#mytable tbody>tr:last').remove();
			}
		});

		$("#add").click(
				function() {

					var tr = $('#mytable tbody>tr:last').clone(true)
							.insertAfter('#mytable tbody>tr:last');

					var td1 = tr[0].children[0];
					td1.children[0].id = 'date' + counter;
					td1.children[0].name = 'entity.segmentations['
							+ counter
							+ '].shippingSchedule.scheduleDate';
					td1.children[0].value = '';

					var td2 = tr[0].children[2];
					td2.children[0].id = 'total' + counter;
					td2.children[0].name = 'entity.segmentations['
							+ counter + '].amount';
					td2.children[0].value = '';

					$('.startdatum').each(function() {
						$(this).datetimepicker('destroy');
						$(this).datetimepicker({
							dateFormat : 'dd/mm/yy'
						});
					});

					counter++;
					return false;
				});
	})
	

function distribute() {
	var total = parseInt($("#contador").val());
	var linhas = $('#mytable tbody>tr').length - 1;

	if (total >= linhas) {
		var sobra = total % linhas;
		var qtdPorLinha = parseInt(total/linhas);
		var tr = $('#mytable tbody>tr');
		
		for(i = 1 ; i<=linhas;i++){
			tr[i].children[2].children[0].value = qtdPorLinha + sobra;
			sobra = 0;
		}

	}
}

function validateTotal() {
	var total = parseInt($("#contador").val());
	var linhas = $('#mytable tbody>tr').length - 1;
	var count = 0;

	var tr = $('#mytable tbody>tr');

	for (i = 1; i <= linhas; i++) {
		count += parseInt(tr[i].children[2].children[0].value);
	}

	return count != total;

}
