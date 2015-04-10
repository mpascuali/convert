$.datepicker._defaults.onAfterUpdate = null;

var datepicker__updateDatepicker = $.datepicker._updateDatepicker;
$.datepicker._updateDatepicker = function( inst ) {
   datepicker__updateDatepicker.call( this, inst );

   var onAfterUpdate = this._get(inst, 'onAfterUpdate');
   if (onAfterUpdate)
      onAfterUpdate.apply((inst.input ? inst.input[0] : null),
         [(inst.input ? inst.input.val() : ''), inst]);
}



function customDatepicker(divId, initDateId, endDateId){

	var divv = '#'+divId;
	
	$(function() {

	   var cur = -1, prv = -1;
	   $(divv+' div')
	      .datepicker({
	    	numberOfMonths:2,
	    	changeMonth: true,
	    	changeYear: true,
	    	showButtonPanel: true,
		dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
		dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
	      	nextText: 'Próximo',
	   	prevText: 'Anterior',
	   	dateFormat: 'dd/mm/yy',

	            beforeShowDay: function ( date ) {
	                  return [true, ( (date.getTime() >= Math.min(prv, cur) && date.getTime() <= Math.max(prv, cur)) ? 'date-range-selected' : '')];
	               },

	            onSelect: function ( dateText, inst ) {
	                  var d1, d2;

	                  prv = cur;
	                  cur = (new Date(inst.selectedYear, inst.selectedMonth, inst.selectedDay)).getTime();
	                  if ( prv == -1 || prv == cur ) {
	                     prv = cur;
	                     $(divv+' input').val( dateText );
	                     
	                     if(initDateId != null && initDateId != ''){
	                    	 $('#'+initDateId)[0].value = dateText;
	                     }
	                     if(endDateId != null && endDateId != ''){
	                    	 $('#'+endDateId)[0].value = dateText;
	                     }
	                  } else {
	                     d1 = $.datepicker.formatDate( 'dd/mm/yy', new Date(Math.min(prv,cur)), {} );
	                     d2 = $.datepicker.formatDate( 'dd/mm/yy', new Date(Math.max(prv,cur)), {} );
	                     $(divv+' input').val( d1+' - '+d2 );
	                     
	                     if(initDateId != null && initDateId != ''){
	                    	 $('#'+initDateId)[0].value = d1;
	                     }
	                     if(endDateId != null && endDateId != ''){
	                    	 $('#'+endDateId)[0].value = d2;
	                     }
	                     
	                  }
	               },

	            onChangeMonthYear: function ( year, month, inst ) {
	                  //prv = cur = -1;
	               },

	            onAfterUpdate: function ( inst ) {

	                  $('<button type="button" class="btn btn-envia-sms btn-large" data-handler="hide" data-event="click">Selecionar</button>')
	                     .appendTo($(divv+' div .ui-datepicker-buttonpane'))
	                     .on('click', function () { $(divv+' div').hide(); });
	               }
	         })
	      .position({
	            my: 'left top',
	            at: 'left bottom',
	            of: $(divv+' input')
	         })
	      .hide();

	   $(divv+' input').on('focus', function (e) {

	         var v = this.value,
	             d;

	         try {
	            if ( v.indexOf(' - ') > -1 ) {
	               d = v.split(' - ');

	               prv = $.datepicker.parseDate( 'dd/mm/yy', d[0] ).getTime();
	               cur = $.datepicker.parseDate( 'dd/mm/yy', d[1] ).getTime();

	            } else if ( v.length > 0 ) {

	               prv = cur = $.datepicker.parseDate( 'dd/mm/yy', v ).getTime();
	            }
	         } catch ( e ) {
	            cur = prv = -1;
	         }

	         if ( cur > -1 )

	            $(divv+' div').datepicker('setDate', new Date(cur));

	         $(divv+' div').datepicker('refresh').show();
	      });

	});

}


var selectedValues = new Array();
selectedValues[0] = "a";
selectedValues[1] = "c";

$('#datepicker').select2();



