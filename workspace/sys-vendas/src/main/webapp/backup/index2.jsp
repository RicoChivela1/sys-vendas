
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SysVendas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleIndex.css">
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.min.css"  >
<script src="chart/vendor/Chart.min.js"></script>
	<script src="chart/src/utils.js"></script>
	<style>
	canvas{
		-moz-user-select: none;
		-webkit-user-select: none;
		-ms-user-select: none;
	}
	</style>

</head>
<body>



<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container"> 

<div class="caixa">


<h3><label>Visão Geral</label></h3>
	<ul>
		<li>Total Investido: R$ ${totalInvestido}</li>
		<li>Lucro Bruto: R$ ${lucroBruto}</li>
		<li>Lucro Líquido: R$ ${lucroLiquido}</li>
		<li>Lucro extimado Bruto: R$ ${extimativaBruta}</li>
		<li>Lucro extimado Líquido: R$ ${extimativaLiquida}</li>
		
	</ul>
	<br />
	
	
	
	
	
	
	
	<div style="width:100%;">
		<canvas id="canvas"></canvas>
	</div>
	${vendasMes}
	<label> vendas Mes</label>
	
	<div id="divValor"><c:forEach var="arrayValor" items="${vendasMes}"><input type="hidden" value="${arrayValor.valorTotal}"></c:forEach>
	</div>
	
	<div id="divMes"><c:forEach var="arrayMes" items="${vendasMes}"><input type="text" value="${arrayMes.mes}"></c:forEach>
	</div>

	<div id="divAno"><c:forEach var="arrayAno" items="${vendasMes}"><input type="text" value="${arrayAno.ano}"></c:forEach>
	</div>
<script>
	// Obtém a data atual
	var data = new Date();
	var mes = data.getMonth()+1;         
	var ano = data.getFullYear();
	var fullMes = ("00" + mes).slice(-2);
	var stringData =  ano + '/' + fullMes;
	
	// pega valor R$
	var campoValor = [0,0,0,0,0,0,0,0,0,0,0,0];
	for(var i=0; i < divValor.childNodes.length; i++){
		campoValor[i] = parseFloat(divValor.childNodes[i].value);
	}
	
	// pega mês
	var campoMes = new Array();
	for(var i=0; i<divMes.childNodes.length; i++){
		campoMes[i] = divMes.childNodes[i].value;
	} 

	// pega ano
	var campoAno = new Array();
	for(var i=0; i<divAno.childNodes.length; i++){
		campoAno[i] = divAno.childNodes[i].value;
	} 
	
	var chartMes = new Array();
	var campoData = new Array();
	for (var i = 0; i < 12; i++){
		chartMes[i] = i+1;
		
		//Ajusta ano conforme o mês
		if(campoMes[i] < 1){
			campoAno[i] = (campoAno[i]-1);
		}
		
		// 
		if(campoMes[i] == chartMes[i]){
			campoValor[i] = parseFloat(divValor.childNodes[i].value);
		}
	

		var fulldata = chartMes[i]+"/"+campoAno[i];
		campoData[i] = fulldata;
		console.log("campo data: "+campoData[i]);
		console.log("Chart mes: "+chartMes[i]);
	}
	
		var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June' ];
		var config = {
			type: 'bar',
			data: {
				//labels: [mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano, mes+'/'+ano],
				labels:campoData,
				datasets: [{
					label: 'Valor total de vendas',
					backgroundColor: window.chartColors.red,
					borderColor: window.chartColors.red,
					data: campoValor,
					fill: false,
				}, 
				 {
					label: 'My Second dataset',
					fill: false,
					backgroundColor: window.chartColors.blue,
					borderColor: window.chartColors.blue,
					data: [
						200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 2, 113
					],
				}] 
			},
			options: {
				responsive: true,
				title: {
					display: true,
					text: 'SOMATÓRIO DE VENDAS POR MÊS'
				},
				tooltips: {
					mode: 'index',
					intersect: false,
				},
				hover: {
					mode: 'nearest',
					intersect: true
				},
				scales: {
					xAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: ''
						}
					}],
					yAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'R$'
						}
					}]
				}
			}
		};

		window.onload = function() {
			var ctx = document.getElementById('canvas').getContext('2d');
			window.myLine = new Chart(ctx, config);
		};

		var colorNames = Object.keys(window.chartColors);
		document.getElementById('addDataset').addEventListener('click', function() {
			var colorName = colorNames[config.data.datasets.length % colorNames.length];
			var newColor = window.chartColors[colorName];
			var newDataset = {
				label: 'Dataset ' + config.data.datasets.length,
				backgroundColor: newColor,
				borderColor: newColor,
				data: [],
				fill: false
			};

			for (var index = 0; index < config.data.labels.length; ++index) {
				newDataset.data.push(randomScalingFactor());
			}

			config.data.datasets.push(newDataset);
			window.myLine.update();
		});

	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	<br />
	<label> vendas Ano</label>
	${vendasAno}
<br />
<h3><label>Dívidas</label></h3>
	<ul>
		<li>Total Dívidas: R$ ${totalDividas}</li> 
		<li>Total em atraso: R$ ${totalAtraso}</li> 
		<li>Total à receber: R$ ${valorTotalAtraso}</li> 
		<li>Total a receber hoje: R$ ${valorAReceberHoje}</li> 
		<li>Total a receber mês: R$ ${valorAReceberMes} </li>
		<li>Total a receber semana: R$ ${valorAReceberSemana}</li> 
	</ul>
<br />
<h3><label>Produtos</label></h3>
	<ul>
	
	
	
	
		<li> -Os Mais vendidos</li>
		
		<form action="gerencia-produto.jsp" method="post">

	<c:choose>	
		<c:when test="${empty produtosReserva}">
			<div class="box">
			<div>
				<label class="listaNula">Não encontramos registros.</label>	
			</div>
			<div>
				<a href="gerencia-produto.jsp?filtro=" title="Listar todos os produtos.">Ver todos </a> |
				<a href="cadastrar-produto.jsp" title="Cadastrar um novo produto."> Adicionar </a> |
				<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
			</div>
		
			</div>
				
		</c:when>
		
		<c:when test="${not empty produtoTopList}">
			<div class="table-responsive">
				<table class="table table-hover">
				<caption>Produtos Top List</caption>
					  <thead>
					    <tr>
					      <th > # </th>
					      <th > Imagem </th>
					      <th > Nome </th>
					      <th > Descricao/Indicação </th>
					      <th > Custo Unid </th>
					      <th > Sugestão Venda </th>
					      <th > Estoque </th>
					      <th > Ações</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="produto" items="${produtoTopList}">
					    <tr>
					      <td>${produto.id}</td>
					      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
							<td><span class="nome">-${produto.nome}</span><br />
								${produto.volume}
							</td>
							<td>-${produto.descricao}<br />
								-${produto.indicacao}
							</td>
							
						    <td class="valores">R$ ${produto.custoUnid}</td>
							<td class="valores">R$ ${produto.sugestaoVenda}</td>
							<td>${produto.estoque.qtdDisponivel}</td>
					
					      <td> 
					    	<div class="btnAcoes">
					      		<button type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info" title="Veja maiores informações sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i> Info</button>
					      		<button type="submit" name="alterar" value="${produto.id}" class="btn btn-outline-warning" title="Permite alterar os dados do produto."> <i class="fa fa-pencil-square-o" ></i> Atualizar</button>	
						  		<button type="submit" name="remover" value="${produto.id}" class="btn btn-outline-danger" title="Apaga este produto do sistema.">  <i class="fa fa-trash-o" ></i> Remover</button>
							</div>
					      </td>
					    </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
		</c:when>
	</c:choose>

</form>
		
		
		
		
		
		<li> - Estão na reserva</li>
		<form action="gerencia-produto.jsp" method="post">

	<c:choose>	
		<c:when test="${empty produtosReserva}">
			<div class="box">
			<div>
				<label class="listaNula">Não encontramos registros.</label>	
			</div>
			<div>
				<a href="gerencia-produto.jsp?filtro=" title="Listar todos os produtos.">Ver todos </a> |
				<a href="cadastrar-produto.jsp" title="Cadastrar um novo produto."> Adicionar </a> |
				<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
			</div>
		
			</div>
				
		</c:when>
		
		<c:when test="${not empty produtosReserva}">
			<div class="table-responsive">
				<table class="table table-hover">
				<caption>Produtos na Reserva</caption>
					  <thead>
					    <tr>
					      <th > # </th>
					      <th > Imagem </th>
					      <th > Nome </th>
					      <th > Descricao/Indicação </th>
					      <th > Custo Unid </th>
					      <th > Sugestão Venda </th>
					      <th > Estoque </th>
					      <th > Ações</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="produto" items="${produtosReserva}">
					    <tr>
					      <td>${produto.id}</td>
					      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
							<td><span class="nome">-${produto.nome}</span><br />
								${produto.volume}
							</td>
							<td>-${produto.descricao}<br />
								-${produto.indicacao}
							</td>
							
						    <td class="valores">R$ ${produto.custoUnid}</td>
							<td class="valores">R$ ${produto.sugestaoVenda}</td>
							<td>${produto.estoque.qtdDisponivel}</td>
					
					      <td> 
					    	<div class="btnAcoes">
					      		<button type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info" title="Veja maiores informações sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i> Info</button>
					      		<button type="submit" name="alterar" value="${produto.id}" class="btn btn-outline-warning" title="Permite alterar os dados do produto."> <i class="fa fa-pencil-square-o" ></i> Atualizar</button>	
						  		<button type="submit" name="remover" value="${produto.id}" class="btn btn-outline-danger" title="Apaga este produto do sistema.">  <i class="fa fa-trash-o" ></i> Remover</button>
							</div>
					      </td>
					    </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
		</c:when>
	</c:choose>

</form>







		<li>Esgotados</li>
		</ul>
		<form action="gerencia-produto.jsp" method="post">

	<c:choose>	
		<c:when test="${empty produtosEsgotados}">
			<div class="box">
			<div>
				<label class="listaNula">Não encontramos registros.</label>	
			</div>
			<div>
				<a href="gerencia-produto.jsp?filtro=" title="Listar todos os produtos.">Ver todos </a> |
				<a href="cadastrar-produto.jsp" title="Cadastrar um novo produto."> Adicionar </a> |
				<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
			</div>
		
			</div>
				
		</c:when>
		
		<c:when test="${not empty produtosEsgotados}">
			<div class="table-responsive">
				<table class="table table-hover">
				<caption>Produtos Esgotados</caption>
					  <thead>
					    <tr>
					      <th > # </th>
					      <th > Imagem </th>
					      <th > Nome </th>
					      <th > Descricao/Indicação </th>
					      <th > Custo Unid </th>
					      <th > Sugestão Venda </th>
					      <th > Estoque </th>
					      <th > Ações</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="produto" items="${produtosEsgotados}">
					    <tr>
					      <td>${produto.id}</td>
					      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
							<td><span class="nome">-${produto.nome}</span><br />
								${produto.volume}
							</td>
							<td>-${produto.descricao}<br />
								-${produto.indicacao}
							</td>
							
						    <td class="valores">R$ ${produto.custoUnid}</td>
							<td class="valores">R$ ${produto.sugestaoVenda}</td>
							<td>${produto.estoque.qtdDisponivel}</td>
					
					      <td> 
					    	<div class="btnAcoes">
					      		<button type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info" title="Veja maiores informações sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i> Info</button>
					      		<button type="submit" name="alterar" value="${produto.id}" class="btn btn-outline-warning" title="Permite alterar os dados do produto."> <i class="fa fa-pencil-square-o" ></i> Atualizar</button>	
						  		<button type="submit" name="remover" value="${produto.id}" class="btn btn-outline-danger" title="Apaga este produto do sistema.">  <i class="fa fa-trash-o" ></i> Remover</button>
							</div>
					      </td>
					    </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
		</c:when>
	</c:choose>

</form>
<br />
</div>
<div class="caixaIndex">
	<div class="menutemp">
	    <div>	
	    	<a href="cadastrar-usuario.jsp">Cadastrar Usuário</a><br />		
			<a href="cadastrar-cliente.jsp">Cadastrar Cliente</a><br /> 	
			<a href="cadastrar-fornecedor.jsp">Cadastrar Fornecedor</a><br /> 
		 	<a href="cadastrar-categoria.jsp">Cadastrar Categoria</a><br />
		 	<a href="cadastrar-produto.jsp">Cadastrar Produto</a><br />
		 
		 </div>
	    <div>
	    <form action="busca-cliente.jsp" method="post">
	    	<a href="busca-cliente.jsp?filtro=" > Pesquisar Clientes</a><br />
	    </form>
	    
	    <form action="busca-produto.jsp" method="post">
	    	<a href="busca-produto.jsp?filtro="> Pesquisar Produtos</a><br />
	    </form>	
	    
	    <form action="busca-usuario.jsp" method="post">
	    	<a href="busca-usuario.jsp?filtro="> Pesquisar Usuários</a><br />
	    </form>	
	    
	    <form action="busca-categoria.jsp" method="post">
	    	<a href="busca-categoria.jsp?filtro="> Pesquisar Categorias</a><br />
	    </form>
	    
	    <form action="busca-fornecedor.jsp" method="post">
	    	<a href="busca-fornecedor.jsp?filtro="> Pesquisar Fornecedor</a><br />
	    </form>
	    
		 </div>
	    <div>
	    	<a href="orcamento.jsp">Orçamento</a><br />			
			<a href="index.jsp">x Verificar Atividades</a><br /> 
		 	<a href="index.jsp">x Relatórios</a><br />
		 	<a href="index.jsp">x Estimativas</a><br />
		 </div>
	    </div>
    
	</div>
</div>	
<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>
       
        
</body>
</html>