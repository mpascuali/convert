
$(document).ready(
		function() {

			$("#dropdiv").dropzone({
				url : "../upload/file-upload"
			});

			var dropdiv = Dropzone.forElement("#dropdiv");

			dropdiv.on("success", function(file) {
				var files = $("#files")[0];
				if(!(files.value.indexOf(file.name) !== -1)){
					files.value = files.value + file.name + ";";
				}
				enableSubmit();
			});


		});

function enableSubmit() {
	var sbmt = document.getElementById("sbmtBtn");
	sbmt.disabled = false;
}

// 			var select = $("#combobx")[0];
function addNemGroup(id, valor) {
	var bx = $("#combobx")[0];
	var opt = new Option(valor, id);
	opt.selected = true;

	bx.options[bx.options.length] = opt;
	$("#combobx").multiselect("refresh");

	$('#addBookDialog').modal('hide');
}

//	var select = $("#combobx")[0];
function addNemGroupCellphone(valor) {
	var bx = $("#combobx")[0];
	var opt = new Option(valor, valor);
	opt.selected = true;

	bx.options[bx.options.length] = opt;
	//$("#combobx").multiselect("refresh");

	//$('#addBookDialog').modal('hide');
}

function getSelectText(box) {
	if (box[0].length == 1) {
		return box[0][0].label;
	} else {
		return "# selecionados"
	}
}