
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- plugins:css -->
<link rel="stylesheet" href="magestic/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="magestic/vendors/base/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<link rel="stylesheet" href="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="magestic/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="magestic/images/favicon.png" />



<title>SysVendas</title>

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
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
   
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      
      <!-- partial -->
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 grid-margin">
             
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body dashboard-tabs p-0">
                  <ul class="nav nav-tabs px-4" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active" id="overview-tab" data-toggle="tab" href="#overview" role="tab" aria-controls="overview" aria-selected="true">Visão Geral</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="sales-tab" data-toggle="tab" href="#sales" role="tab" aria-controls="sales" aria-selected="false">Lucros</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="purchases-tab" data-toggle="tab" href="#purchases" role="tab" aria-controls="purchases" aria-selected="false">Á receber</a>
                    </li>
                  </ul>
                  <div class="tab-content py-0 px-0">
                    <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview-tab">
                      <div class="d-flex flex-wrap justify-content-xl-between">
                        <div class="d-none d-xl-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-calendar-heart icon-lg mr-3 text-primary"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Start date</small>
                            <div class="dropdown">
                              <a class="btn btn-secondary dropdown-toggle p-0 bg-transparent border-0 text-dark shadow-none font-weight-medium" href="#" role="button" id="dropdownMenuLinkA" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <h5 class="mb-0 d-inline-block">26 Jul 2018</h5>
                              </a>
                              <div class="dropdown-menu" aria-labelledby="dropdownMenuLinkA">
                                <a class="dropdown-item" href="#">12 Aug 2018</a>
                                <a class="dropdown-item" href="#">22 Sep 2018</a>
                                <a class="dropdown-item" href="#">21 Oct 2018</a>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-currency-usd mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Total Investido</small>
                            <h5 class="mr-2 mb-0">R$ ${totalInvestido}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Total Dívidas</small>
                            <h5 class="mr-2 mb-0">R$ ${totalDividas}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-download mr-3 icon-lg text-warning"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Total em Atraso</small>
                            <h5 class="mr-2 mb-0">R$ ${totalAtraso}</h5>
                          </div>
                        </div>
                        <div class="d-flex py-3 border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Flagged</small>
                            <h5 class="mr-2 mb-0">3497843</h5>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane fade" id="sales" role="tabpanel" aria-labelledby="sales-tab">
                      <div class="d-flex flex-wrap justify-content-xl-between">
                        <div class="d-none d-xl-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-calendar-heart icon-lg mr-3 text-primary"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Start date</small>
                            <div class="dropdown">
                              <a class="btn btn-secondary dropdown-toggle p-0 bg-transparent border-0 text-dark shadow-none font-weight-medium" href="#" role="button" id="dropdownMenuLinkA" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <h5 class="mb-0 d-inline-block">26 Jul 2018</h5>
                              </a>
                              <div class="dropdown-menu" aria-labelledby="dropdownMenuLinkA">
                                <a class="dropdown-item" href="#">12 Aug 2018</a>
                                <a class="dropdown-item" href="#">22 Sep 2018</a>
                                <a class="dropdown-item" href="#">21 Oct 2018</a>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-download mr-3 icon-lg text-warning"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Lucro Bruto</small>
                            <h5 class="mr-2 mb-0">R$ ${lucroBruto}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Lucro Líquido</small>
                            <h5 class="mr-2 mb-0">R$ ${lucroLiquido}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-currency-usd mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Lucro Extimado Bruto</small>
                            <h5 class="mr-2 mb-0">R$ ${extimativaBruta}</h5>
                          </div>
                        </div>
                        <div class="d-flex py-3 border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Lucro Extimado Líquido</small>
                            <h5 class="mr-2 mb-0">R$ ${extimativaLiquida}</h5>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane fade" id="purchases" role="tabpanel" aria-labelledby="purchases-tab">
                      <div class="d-flex flex-wrap justify-content-xl-between">
                        <div class="d-none d-xl-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-calendar-heart icon-lg mr-3 text-primary"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Start date</small>
                            <div class="dropdown">
                              <a class="btn btn-secondary dropdown-toggle p-0 bg-transparent border-0 text-dark shadow-none font-weight-medium" href="#" role="button" id="dropdownMenuLinkA" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <h5 class="mb-0 d-inline-block">26 Jul 2018</h5>
                              </a>
                              <div class="dropdown-menu" aria-labelledby="dropdownMenuLinkA">
                                <a class="dropdown-item" href="#">12 Aug 2018</a>
                                <a class="dropdown-item" href="#">22 Sep 2018</a>
                                <a class="dropdown-item" href="#">21 Oct 2018</a>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-currency-usd mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Total à receber:</small>
                            <h5 class="mr-2 mb-0">R$ ${valorTotalAtraso}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Á receber hoje:</small>
                            <h5 class="mr-2 mb-0">R$ ${valorAReceberHoje}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-download mr-3 icon-lg text-warning"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">À receber mês:</small>
                            <h5 class="mr-2 mb-0">R$ ${valorAReceberMes}</h5>
                          </div>
                        </div>
                        <div class="d-flex py-3 border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">À Receber Semana</small>
                            <h5 class="mr-2 mb-0">R$ ${valorAReceberSemana}</h5>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-7 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title">Vendas vs Investimentos</p>
                  <p class="mb-4">A linha azul acima da linha vermelha indica que você está indo muito bem nos negócios.</p>
                  
                  <canvas id="canvas" width="904" height="452" class="chartjs-render-monitor" style="display: block; width: 904px; height: 452px;"></canvas>
                </div>
              </div>
            </div>
            <div class="col-md-5 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title">Total Lucro</p>
                  <h1>R$ ${lucroLiquido}</h1>
                  <h4>Gross sales over the years</h4>
                  <p class="text-muted">Today, many people rely on computers to do homework, work, and create or store useful information. Therefore, it is important </p>
                  <div id="total-sales-chart-legend"></div>                  
                </div>
                <canvas id="total-sales-chart"></canvas>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title">Recent Purchases</p>
                  <div class="table-responsive">
                    <table id="recent-purchases-listing" class="table">
                      <thead>
                        <tr>
                            <th>Name</th>
                            <th>Status report</th>
                            <th>Office</th>
                            <th>Price</th>
                            <th>Date</th>
                            <th>Gross amount</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                            <td>Jeremy Ortega</td>
                            <td>Levelled up</td>
                            <td>Catalinaborough</td>
                            <td>$790</td>
                            <td>06 Jan 2018</td>
                            <td>$2274253</td>
                        </tr>
                        <tr>
                            <td>Alvin Fisher</td>
                            <td>Ui design completed</td>
                            <td>East Mayra</td>
                            <td>$23230</td>
                            <td>18 Jul 2018</td>
                            <td>$83127</td>
                        </tr>
                        <tr>
                            <td>Emily Cunningham</td>
                            <td>support</td>
                            <td>Makennaton</td>
                            <td>$939</td>
                            <td>16 Jul 2018</td>
                            <td>$29177</td>
                        </tr>
                        <tr>
                            <td>Minnie Farmer</td>
                            <td>support</td>
                            <td>Agustinaborough</td>
                            <td>$30</td>
                            <td>30 Apr 2018</td>
                            <td>$44617</td>
                        </tr>
                        <tr>
                            <td>Betty Hunt</td>
                            <td>Ui design not completed</td>
                            <td>Lake Sandrafort</td>
                            <td>$571</td>
                            <td>25 Jun 2018</td>
                            <td>$78952</td>
                        </tr>
                        <tr>
                            <td>Myrtie Lambert</td>
                            <td>Ui design completed</td>
                            <td>Cassinbury</td>
                            <td>$36</td>
                            <td>05 Nov 2018</td>
                            <td>$36422</td>
                        </tr>
                        <tr>
                            <td>Jacob Kennedy</td>
                            <td>New project</td>
                            <td>Cletaborough</td>
                            <td>$314</td>
                            <td>12 Jul 2018</td>
                            <td>$34167</td>
                        </tr>
                        <tr>
                            <td>Ernest Wade</td>
                            <td>Levelled up</td>
                            <td>West Fidelmouth</td>
                            <td>$484</td>
                            <td>08 Sep 2018</td>
                            <td>$50862</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
           </div>
        </footer>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->
  <script src="magestic/vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="magestic/vendors/chart.js/Chart.min.js"></script>
  <script src="magestic/vendors/datatables.net/jquery.dataTables.js"></script>
  <script src="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="magestic/js/off-canvas.js"></script>
  <script src="magestic/js/hoverable-collapse.js"></script>
  <script src="magestic/js/template.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="magestic/js/dashboard.js"></script>
  <script src="magestic/js/data-table.js"></script>
  <script src="magestic/js/jquery.dataTables.js"></script>
  <script src="magestic/js/dataTables.bootstrap4.js"></script>
  <!-- End custom js for this page-->



<div class="caixa">

	<div style="width:100%;">
		<canvas id="canvas"></canvas>
	</div>
	
	<div id="divValor"><c:forEach var="arrayValor" items="${vendasMes}"><input type="hidden" value="${arrayValor.valorTotal}"></c:forEach></div>
	
	<div id="divMes"><c:forEach var="arrayMes" items="${vendasMes}"><input type="hidden" value="${arrayMes.mes}"></c:forEach></div>
	
	<div id="divAno"><c:forEach var="arrayAno" items="${vendasMes}"><input type="hidden" value="${arrayAno.ano}"></c:forEach></div>
	
	<div id="divInvestimentos"><c:forEach var="arrayInvestimentos" items="${investimentosMes}"><input type="hidden" value="${arrayInvestimentos.valorTotal}"></c:forEach></div>
	
<script>
	var campoData = new Array();
	var campoAno = new Array(); 
	var campoMes = new Array();
	var campoValor = new Array();
	var campoInvestimentos = new Array();
	
	var ano; 
	var mes;
	var valor = 0.00;
	var investimento = 0.00;
	
	// pega investimento R$
	for(var i=0; i < divInvestimentos.childNodes.length; i++){
		investimento = divInvestimentos.childNodes[i].value;
		console.log(investimento);
		campoInvestimentos[i] = (investimento.toLocaleString("pt-BR"));
	}
	
	
	// pega valor R$
	for(var i=0; i < divValor.childNodes.length; i++){
		valor = parseFloat(divValor.childNodes[i].value);
		campoValor[i] = valor;
	}
	
	// pega mês
	for(var i=0; i<divMes.childNodes.length; i++){
		campoMes[i] = divMes.childNodes[i].value;
	}
	
	// pega ano
	for(var i=0; i < divAno.childNodes.length; i++){
		campoAno[i] = divAno.childNodes[i].value;
	} 
	
	//Monta a Data
	for(var i=0; i < 12; i++){
		ano = campoAno[i];
		mes = campoMes[i];
		var fulldata;
		
		//testa se data é null
		if(ano == null){
			fulldata = "..."
		} else {
			fulldata = mes+"/"+ano;
		}

		//popula array com data montada
		campoData[i] = fulldata;
	}
	 
	// chart
		var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'  ];
		var config = {
			type: 'line',
			data: {
				labels: campoData,
				datasets: [{
					label: 'Vendas',
					backgroundColor: window.chartColors.blue,
					borderColor: window.chartColors.blue,
					data: campoValor,
					fill: false,
				}, 
				 {
					label: 'Investimentos',
					backgroundColor: window.chartColors.red,
					borderColor: window.chartColors.red,
					data: campoInvestimentos,
					fill: false,
				}] 
			},
			options: {
				responsive: true,
				title: {
					display: true
					//, text: 'VENDAS vs DESPESAS'
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

		document.getElementById('randomizeData').addEventListener('click', function() {
			config.data.datasets.forEach(function(dataset) {
				dataset.data = dataset.data.map(function() {
					return randomScalingFactor();
				});

			});

			window.myLine.update();
		});

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

		
		//botoes
		document.getElementById('addData').addEventListener('click', function() {
			if (config.data.datasets.length > 0) {
				var month = MONTHS[config.data.labels.length % MONTHS.length];
				config.data.labels.push(month);

				config.data.datasets.forEach(function(dataset) {
					dataset.data.push(randomScalingFactor());
				});

				window.myLine.update();
			}
		});

		document.getElementById('removeDataset').addEventListener('click', function() {
			config.data.datasets.splice(0, 1);
			window.myLine.update();
		});

		document.getElementById('removeData').addEventListener('click', function() {
			config.data.labels.splice(-1, 1); // remove the label first

			config.data.datasets.forEach(function(dataset) {
				dataset.data.pop();
			});

			window.myLine.update();
		});
	</script>
	
	<label> vendas Ano</label>
	${vendasAno}
<br />
<h3><label>Dívidas</label></h3>

<h3><label>Produtos</label></h3>
	<ul>
	
	
	
	
	
	
	
		<li> -Os Mais vendidos</li>
		
		

	<c:choose>	
		<c:when test="${empty produtoTopList}">
			<div class="box">
			<div>
				<label class="listaNula">Não há produtos na reserva.</label>	
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
					      <th > Saída</th>
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
							
						<td>${produto.estoque.qtdSaida}
							</td>
					      <td> 
					    	<div class="btnAcoes">
					      		<button type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info" title="Veja maiores informações sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i></button>
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