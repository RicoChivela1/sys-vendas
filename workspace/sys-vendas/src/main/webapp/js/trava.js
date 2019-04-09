
$(document).ready(function(){
	$(function(){
		$('#chkToggle').bootstrapToggle({
			on: 'Cancelar',
			off: 'Editar',
			onstyle:'outline-dark',
			offstyle:'outline-danger',
			size:'medium',
			width:'100',
			height: '49'
	});});

	var t = document.querySelector("input[name=hiddenTotalParcelas]").value;
	
	//Detecta mudanças no toggle
	$('input[name=trava]').change(function () {
		var checado = $(this).prop('checked');	
		console.log("Total de parcelas: "+t);
		
		//checa o estado
		if($('input[name=trava]').is(":checked") == true){
			
			//troca inputs por checkbox
			for(var i = 1; i <= t; i++){
				
				//pega o valor do input
				var valorStatus = $("input[name='inputStatus["+i+"]']").val();
				console.log("Valor da parcelas"+i+":"+valorStatus);
				
				//descobre o pai do input
				var elemento = $("input[name='inputStatus["+i+"]']").parents("td");
				elemento.empty();
						
				//adiciona o checkbox no pai
				elemento.append("<input type='checkbox' data-toggle='toggle' name='checkBoxPagar["+i+"]' data-on='Quitado' data-off='A Pagar' data-onstyle='success' data-offstyle='outline-danger'  data-width='120' data-size='mini'> ");
				
				//ajusta o status do checkbox
				if(valorStatus == "QUITADO"){
					$("input[name='checkBoxPagar["+i+"]']").attr('checked','checked');
					
				} else if(valorStatus != "QUITADO"){
					$("input[name='checkBoxPagar["+i+"]']").removeAttr('checked');	
					
				}
				
			}
			
			elemento.append("<link href='bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css' rel='stylesheet'>");	
			elemento.append("<script src='bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js'></script>");	
			elemento.append("<script src='bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js'></script>");
		}
		
		//Adiciona botão submit
		$("#divSalvaPagamentos").prepend(" <button type='submit' id='asd' name='asd' onClick='ocultarBtnEfetivarPagamento()' class='btn btn-success btn-lg'> <i class='fa fa-money' > </i> Registrar Pagamento </button> ");
		
		//cancela a edição
		if ($('input[name=trava]').is(":checked") == false){
			location.reload();
			$("#divSalvaPagamentos").empty();
			$("#divSalvaPagamentos").text("aguarde...");
		}	
	});	
});
