$(document).ready(function() {
    $('#tableuser').dataTable( {
        "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
    decorateRow(nRow);
        return nRow;
        }
    } );
     
    $('#example').dataTable().fnUpdate( ["-","1","2","-","4"], $('#example tbody tr:eq(0)')[0] );
} );
 
function decorateRow(row) {
    $(row).children().each(function(index, td){
        if ($(td).html().indexOf("-") === 0) {
            $(td).css("color", "red");
        }
        else {
            $(td).css("color", "");
        }
    });
}