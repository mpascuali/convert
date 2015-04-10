function generateDatatable(ref) {
	
	
       return $('#'+ref.tableId).dataTable({
             "bPaginate": (ref.paginate != null) ? ref.paginate : true,
             "bFilter": (ref.paginate != null) ? ref.paginate : true,
             "aoColumns" : getColumns(ref.columns),
             "bServerSide" : true,
             "bStateSave": true,
             "bRetrieve": true,
             "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
            	   if(ref.fnRowCallback){
            		   ref.fnRowCallback(nRow, aData, iDisplayIndex);
            	   }
            	        return nRow;
            	        },
             "sAjaxSource" : ref.urlAjax,
             "fnDrawCallback" : ref.fnCallBack
       });
}
       function column(mDataProp, sTitle, bSortable, sType,format) {
             this.mDataProp = mDataProp;
             this.sTitle = (sTitle != null) ? sTitle : mDataProp;
             this.bSortable = (bSortable != null) ? bSortable : true;
             this.sDefaultContent = "";
             
             if(mDataProp == 'id'){
                    this.bVisible = false
                    this.bSortable = false;
             }
             
             if(sType == 'date'){
                    this.sType = sType;
                    
                    if(format == null || format == 'date'){
                    this.fnRender = function ( oObj ) {
                     var jsDate = new Date(getDataProp(oObj.aData,this.mDataProp));
                     jsDate = (jsDate.getDate() > 9 ? jsDate.getDate() : "0"+jsDate.getDate() )+"/"+((jsDate.getMonth() +1) > 9 ? (jsDate.getMonth() +1) : "0"+(jsDate.getMonth() +1))+"/"+jsDate.getFullYear();
                     return "<div class=date>"+jsDate+"<div>";
                     }
                    } else if (format == 'datetime'){
                           this.fnRender = function ( oObj ) {
                                  var jsDate = new Date(getDataProp(oObj.aData,this.mDataProp));
                                  jsDate = jsDate.getDate()+"/"+(jsDate.getMonth() +1)+"/"+jsDate.getFullYear()+" "+jsDate.getHours()+":"+jsDate.getMinutes()+":"+jsDate.getSeconds();
                                  return "<div class=date>"+jsDate+"<div>";
                           }
                    } else if (format == 'time'){
                           this.fnRender = function ( oObj ) {
                                  var jsDate =  new Date(getDataProp(oObj.aData,this.mDataProp));
                                  jsDate = jsDate.getHours()+":"+jsDate.getMinutes()+":"+jsDate.getSeconds();
                                  return "<div class=date>"+jsDate+"<div>";
                           }
                    }
             }
       }

       function getColumns(cols) {
             var c = new Array();
             for (i = 0; i < cols.length; i++) {
                    c[i] = new column(cols[i][0], cols[i][1], cols[i][2], cols[i][3], cols[i][4]);
             }
             return c;
       }
       
       function getDataProp(aData, dataProp){
             var arr = dataProp.split('.');
             var ret = aData[arr[0]];
             
             for(i = 1; i < arr.length; i++){
                    ret = ret[arr[i]];
             }
             
             return ret;
             
       }


       