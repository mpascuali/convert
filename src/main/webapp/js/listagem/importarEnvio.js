
$(document).ready(
		function() {
			

			$("#dropdiv").dropzone({
				url : "../../upload/file-upload"
			});

			var dropdiv = Dropzone.forElement("#dropdiv");

			dropdiv.on("success", function(file,response) {
				var files = $("#files")[0];
				if(!(files.value.indexOf(file.name) !== -1)){
					files.value = files.value + file.name + ";";
				}
				var resp = response.value;
				$("#contador").val(resp.rows);
				$('#totalLinha')[0].innerText = resp.rows + ' linha(s)';
				
				if(resp.headers){
					for(i = 0 ; i < resp.headers.length;i++){
						$('#ClickWordList').append('<li class="btn btn-info btn-mini"><i class="icon-white icon-user"></i>&nbsp;['+ resp.headers[i]+']</li>&nbsp;');
					}
				}
				
				var fl = $('#firtLine')[0];
				
				fl.value = resp.firstLine;
				

				$('#ClickWordList li').click(function() { 
					$("#txtMessage").insertAtCaret($(this).text());
					return false
				});
				
				$("#dropdiv").hideBalloon();
				
			});


		});

