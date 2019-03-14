
$(document).ready(function(){


	$('select[name=parcelas]').change(function () {
		
		var valor = $('input[name="totalOrcamento"]').val();
		
		// Obtém a data/hora atual
		var data = new Date();
		
		var qtdParcela = $('select[name=parcelas]').val();
		var valParcela = (valor / qtdParcela).toFixed(2);;
		
		//Calcula o resto com retorno decimal
		var resto = (valor - (valParcela * qtdParcela)).toFixed(2);

		//alert( "Resto da divisão: " + resto );
		
		// limpa inputs
		$("#divParcelas").empty();
		
		//gera inputs
		for(var i = 1; i <= qtdParcela; i++){
				
			// Guarda cada pedaço em uma variável
			var dia = data.getDate();           
			var mes = data.getMonth()+1;          // 0-11 (zero=janeiro)
			var fullAno = data.getFullYear();       
			
			//ajusta o mes para 2 caracteres
			var fullMes = ("00" + mes).slice(-2);
			
			//ajusta o dia para 2 caracteres
			var fullDia = ("00" + dia).slice(-2);
			
			if(i == qtdParcela){
				valParcela = (parseFloat(valParcela)+parseFloat(resto)).toFixed(2);
			}
			
			// concatena
			var stringData =  fullAno + '-' + fullMes + '-' + fullDia;
			
			$("#divParcelas").append("<label> - "+i+"&deg; parcela: <label/>","<input id='fieldsMedio'  name='parcelaValor["+i+"]' id='parcelaValor["+i+"]' value="+valParcela+">");
			$("#divParcelas").append("<label> &nbsp;- Data: <label/>","<input type='date' id='fieldsMedio'  name='parcelaData["+i+"]' id='parcelaData["+i+"]' value="+stringData+">");
			$("#divParcelas").append("<br /><br />");
			data.setDate(data.getDate() + 30);
			
			var saida = $('#parcelaValor').index(i);
			console.log(saida);
	
		}
		if (qtdParcela > 0){
			$("#divParcelas").append("<button type='submit' name='idProduto' class='btn btn-success'> <i class='fa fa-money' style='font-size:24px'> </i> Efetivar Venda</button>");
		}
    });
});










/* $(document).ready(function(){

	$("#parcela").change(function () {
		
		var valor = $("#valor").val();
	
		// Obtém a data/hora atual
		var data = new Date();
		
		var qtdParcela = $("#parcela").val();
		var parcela = (valor / qtdParcela).toFixed(2);
		
		// limpa inputs
		$("#divParcelas").empty();
		
		//gera inputs
		for(var i = 1; i <= qtdParcela; i++){
				
			// Guarda cada pedaço em uma variável
			var dia = data.getDate();           
			var mes = data.getMonth();          // 0-11 (zero=janeiro)
			var fullAno = data.getFullYear();       
			
			//ajusta o mes para 2 caracteres
			mes=mes+1; 
			var fullMes = ("00" + mes).slice(-2);
			
			//ajusta o dia para 2 caracteres
			var fullDia = ("00" + dia).slice(-2);
			
			var stringData =  fullAno + '-' + fullMes + '-' + fullDia;
			
			$("#divParcelas").append("<label> - "+i+"° parcela: <label/>", "<input id='parcelaValor["+i+"]' value="+parcela+">");
			$("#divParcelas").append("<label> - Data: <label/>","<input type='date' id='parcelaData["+i+"]' value="+stringData+">");
			$("#divParcelas").append("<br /><br />");
			
			data.setDate(data.getDate() + 31);
		}
    });
});
 */

		/* 		// Obtém a data/hora atual
			var data = new Date();

			// Guarda cada pedaço em uma variável
			var dia     = data.getDate();           // 1-31
			var dia_sem = data.getDay();            // 0-6 (zero=domingo)
			var mes     = data.getMonth();          // 0-11 (zero=janeiro)
			var ano2    = data.getYear();           // 2 dígitos
			var ano4    = data.getFullYear();       // 4 dígitos
			var hora    = data.getHours();          // 0-23
			var min     = data.getMinutes();        // 0-59
			var seg     = data.getSeconds();        // 0-59
			var mseg    = data.getMilliseconds();   // 0-999
			var tz      = data.getTimezoneOffset(); // em minutos

			// Formata a data e a hora (note o mês + 1)
			var str_data = dia + '/' + (mes+1) + '/' + ano4;
			var str_hora = hora + ':' + min + ':' + seg;

			// Mostra o resultado
			alert('Hoje é ' + str_data + ' às ' + str_hora); */
			
			
// 283swrn