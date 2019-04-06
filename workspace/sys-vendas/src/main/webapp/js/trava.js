
$(document).ready(function(){


	//
	$(function(){
		$('#chkToggle').bootstrapToggle();
	});
	
	var checado;
	var elemento;
	var t;
	
	//Detecta mudanças no toggle
	$('input[name=trava]').change(function () {
		$('#saida').html('Toggle: ' + $(this).prop('checked')) // ou this.checked
		checado = $(this).prop('checked');
		alert("checado"+checado)
		
		console.log("Total de parcelas: "+t);
		
		//checa o estado
		if(checado == true){
			t = document.querySelector("input[name=hiddenTotalParcelas]").value;
			
			//troca inputs por checkbox
			for(var i = 1; i <= t; i++){
				
				//pega o valor
				var valorStatus = $("input[name='inputStatus["+i+"]']").val();
				console.log("Valor da parcelas"+i+":"+valorStatus);
				
				//pega o pai
				elemento = $("input[name='inputStatus["+i+"]']").parents("td");
				$("input[name='inputStatus["+i+"]']").hide();
				//adiciona o checkbox no pai
				elemento.append("<input type='checkbox'  name='checkBoxPagar["+i+"]' data-toggle='toggle' data-onstyle='success' data-offstyle='danger'  data-on='Recebido' data-off='A receber'> ");
				
				//ajusta o status checked
				if(valorStatus == "QUITADO"){
					$("input[name='checkBoxPagar["+i+"]']").attr('checked','checked');
					return false;
				}
			
				
	
			}
			elemento.append("<link href='bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css' rel='stylesheet'>");	
			elemento.append("<script src='bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js'></script>");

			elemento.append("<script type='text/javascript' src='js/script.js'></script>");
			elemento.append("<link href='bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css' rel='stylesheet'>");	
			elemento.append("<script src='bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js'></script>");
	   
		}
		
		//troca checkbox por inputs
		if (checado != true){
			alert("Está fechado");
			t = document.querySelector("input[name=hiddenTotalParcelas]").value;
			//percorre os checkboxs
			for(var i = 1; i <= t; i++){
				
				//pega o valor do checkbox
				var valorStatus2 = $("input[name='checkBoxPagar["+i+"]']").is(":checked");//
				console.log("Valor do checkbox"+i+":"+valorStatus);
				
				
				
				//pega o pai do checkbox
				var elemento2 = $("input[name='checkBoxPagar["+i+"]']").parents("td");
				//Limpar checkbox não está funcionando
				$("input[name='checkBoxPagar["+i+"]']").hide();
				
				
				//adiciona o input no pai
				elemento2.append("<input name='inputStatus["+i+"]' type='text' value='${pagamento.status}'>");
				
				
				
				
				//ajusta o status do input conforme o checked
				if( valorStatus2 == true ){
					$("input[name='inputStatus["+i+"]']").attr('value','QUITADO');
					return false;
				}else {
					$("input[name='inputStatus["+i+"]']").attr('value','A_PAGAR');
					return false;
				}
				
				$("input[name='inputStatus["+i+"]']").hide();
			}
		}	
			
	});
	$('#saida').html('Toggle: ', this.checked); // ou $(this).prop('checked')
	checado = $(this).prop('checked');
	
	
});
