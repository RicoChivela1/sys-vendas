
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                          <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Total Investido</small>
                            <h5 class="mr-2 mb-0">R$ ${totalInvestido}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                          <div class="d-flex flex-column justify-content-around">
                          
  
                            <small class="mb-1 text-muted">Lucro Total</small>
                            <h5 class="mr-2 mb-0">R$ ${lucroLiquido}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Total em Atraso</small>
                            <h5 class="mr-2 mb-0">R$ ${totalAtraso}</h5>
                          </div>
                        </div>
                        <div class="d-flex py-3 border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-eye mr-3 icon-lg text-success"></i>
                          <div class="d-flex flex-column justify-content-around">
                             <small class="mb-1 text-muted">Total Dívidas</small>
                            <h5 class="mr-2 mb-0">R$ ${totalDividas}</h5>
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
                          <i class="mdi mdi-currency-usd mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Lucro Bruto</small>
                            <h5 class="mr-2 mb-0">R$ ${lucroBruto}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-currency-usd mr-3 icon-lg text-danger"></i>
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
                          <i class="mdi mdi-currency-usd mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Lucro Extimado Líquido</small>
                            <h5 class="mr-2 mb-0">R$ ${extimativaLiquida}</h5>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane fade" id="purchases" role="tabpanel" aria-labelledby="purchases-tab">
                      <div class="d-flex flex-wrap justify-content-xl-between">
                        
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Total à receber:</small>
                            <h5 class="mr-2 mb-0">R$ ${valorTotalAtraso}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">À receber Hoje:</small>
                            <h5 class="mr-2 mb-0">R$ ${valorAReceberHoje}</h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">À receber Semana:</small>
                            <h5 class="mr-2 mb-0">R$ ${valorAReceberSemana}</h5>
                          </div>
                        </div>
                        <div class="d-flex py-3 border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-flag mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">À Receber Mês</small>
                            <h5 class="mr-2 mb-0">R$ ${valorAReceberMes}</h5>
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
            <div class="col-md-6 grid-margin stretch-card">
            
            
              <div class="card">
              
        
                <div class="card-body">
                  <p class="card-title">Vendas vs Investimentos</p>
                  
                  
                  
                  
     <!-- Grafico Vendas  Investimento -->
                   
    <div id="divValor"><c:forEach var="arrayValor" items="${vendasMes}"><input type="hidden" value="${arrayValor.valorTotal}"></c:forEach></div>
	
	<div id="divMes"><c:forEach var="arrayMes" items="${vendasMes}"><input type="hidden" value="${arrayMes.mes}"></c:forEach></div>
	
	<div id="divAno"><c:forEach var="arrayAno" items="${vendasMes}"><input type="hidden" value="${arrayAno.ano}"></c:forEach></div>
	
	<div id="divInvestimentos"><c:forEach var="arrayInvestimentos" items="${investimentosMes}"><input type="hidden" value="${arrayInvestimentos.valorTotal}"></c:forEach></div>

	
	
	<div style="width: 100%">
		<canvas id="canvas"></canvas>
	</div>
	<script src="js/grafico1.js">
	</script>
 
                </div>
              </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
            
            
              <div class="card">
                <div class="card-body">
                  <p class="card-title">Produtos mais vendidos</p>
    
                  <!-- Gráfico Mais Vendidos -->
                  
        <div id="divTopListId"><c:forEach var="topListId" items="${produtoTopList}"><input type="hidden" value="${topListId.id}"></c:forEach></div>
	
		<div id="divTopListNome"><c:forEach var="topListNome" items="${produtoTopList}"><input type="hidden" value="${topListNome.nome} ${topListNome.volume}"></c:forEach></div>
	
		<div id="divTopListSaida"><c:forEach var="topListSaida" items="${produtoTopList}"><input type="hidden" value="${topListSaida.estoque.qtdSaida}"></c:forEach></div>

        <div id="canvas-holder" style="width:100%">
			<canvas id="chart-area"></canvas>
		</div>
				
	<script src="js/grafico2.js"></script>
                </div>

              </div>
            </div>
          </div>
          
          
          <div class="row">
            <div class="col-md-6 grid-margin stretch-card">
            
            
              <div class="card">
              
        
                <div class="card-body">
                  <p class="card-title">Dívidas à receber</p>
               
                  <form action="gerenciar-orcamento.jsp" method="post">

	<c:choose>	
		<c:when test="${empty dividasAReceber}">
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
		
		<c:when test="${not empty dividasAReceber}">
			<div class="table-responsive">
				<table class="table table-hover">
					  <thead>
					    <tr>
					      <th > Cliente </th>
					      <th > Valor </th>
					      <th > Vencimento</th>
					 	  <th > Ações</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="dividas" items="${dividasAReceber}">
					    <tr>
							 
							<td><input type="hidden" value="${dividas.idOrcamento}"> 
								<span class="nome2">${dividas.nomeCliente}</span>
							</td>
							<td>${dividas.valorParcela}</td>
							<td>${dividas.dataVencimento}</td>
					      <td> 
					    	<div class="btnAcoes">
					      		<button type="submit" name="detalhes" value="${dividas.idOrcamento}" class="btn btn-outline-warning btn-sm" title="Permite ver ou alterar os dados da dívida."> <i class="fa fa-info-circle" ></i>Info</button>			  		
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
   
                 
                  
                  
                  
                  
	
	
	
                 
                </div>
              </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
            
            
              <div class="card">
                <div class="card-body">
                  <p class="card-title">Á receber em atraso</p>
                  
   
                  <form action="gerenciar-orcamento.jsp" method="post">

	<c:choose>	
		<c:when test="${empty dividasAtrasadas}">
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
		
		<c:when test="${not empty dividasAtrasadas}">
			<div class="table-responsive">
				<table class="table table-hover">
					  <thead>
					    <tr>
	
					      <th > Cliente </th>
					      <th > Valor </th>
					      <th > Vencimento</th>
					 	  <th > Ações</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="dividas" items="${dividasAtrasadas}">
					    <tr>
							<td><input type="hidden" value="${dividas.idOrcamento}"> 
								<span class="nome2">${dividas.nomeCliente} </span>
							</td>
							<td>${dividas.valorParcela}</td>
							<td>${dividas.dataVencimento}</td>
					      <td> 
					    	<div class="btnAcoes">
					      		<button type="submit" name="detalhes" value="${dividas.idOrcamento}" class="btn btn-outline-warning btn-sm" title="Permite ver e alterar os dados da dívida."> <i class="fa fa-info-circle" ></i> Info</button>			  		
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
                  
                  
                  
                </div>

              </div>
            </div>
          </div>
          
          
          
          <div class="row">
            <div class="col-md-6 grid-margin stretch-card">
            
            
              <div class="card">
              
        
                <div class="card-body">
                  <p class="card-title">Produtos na reserva</p>
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
					  <thead>
					    <tr>
	
					      <th > </th>
					      <th > Nome </th>
					      <th > Estoque </th>
					      <th > Ações</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="produto" items="${produtosReserva}">
					    <tr>
					     
					      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
							<td><span class="nome2">${produto.nome}</span>
								${produto.volume}
							</td>
							<td>${produto.estoque.qtdDisponivel}</td>
					
					      <td> 
					    	<div class="btnAcoes">
					    		<button type="submit" name="info" title="Mais informações." value="${produto.id}" class="btn btn-outline-info btn-sm" > <i class="fa fa-info-circle" ></i> Info</button>
					    		<button type="submit" name="alterar" title="Alterar." value="${produto.id}" class="btn btn-outline-warning btn-sm" > <i class="fa fa-pencil-square-o" ></i> Alterar</button>
					      		
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
   
                 
                  
                  
                  
                  
	
	
	
                 
                </div>
              </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
            
            
              <div class="card">
                <div class="card-body">
                  <p class="card-title">Produtos esgotados</p>
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
				
					  <thead>
					    <tr>
					      <th ></th>
					      <th > Nome </th>
					      <th > Estoque </th>
					      <th > Ações</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="produto" items="${produtosEsgotados}">
					    <tr>
					      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
							<td><span class="nome2"> ${produto.nome}</span>
								${produto.volume}
							</td>
				
							<td>${produto.estoque.qtdDisponivel}</td>
					
					      <td> 
					    	<div class="btnAcoes">
					    		<button type="submit" name="info" title="Mais informações." value="${produto.id}" class="btn btn-outline-info btn-sm" > <i class="fa fa-info-circle" ></i> Info</button>
					    		<button type="submit" name="alterar" title="Alterar." value="${produto.id}" class="btn btn-outline-warning btn-sm" > <i class="fa fa-pencil-square-o" ></i> Alterar</button>
					      			
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
                  
                  
                  
                </div>

              </div>
            </div>
          </div>
          
          
          
          
          
          
          
          <div class="row">
          
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title">Últimos Lançamentos</p>
                  
                      <form action="gerenciar-orcamento.jsp" method="post">
	
	
	<div class="table-responsive">
				<table  class="table table-hover">
				<caption>Últimos Lançamentos</caption>
					   <thead>
					    <tr>
					      <th>Data da Compra</th>
					      <th>Cliente</th>
					      <th>Valor da Compra</th>
					      <th>Situação</th>
					      <th>Parcelas Pagas</th>
					      <th>Ações</th>
			
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="orcamento" items="${orcamentos}">
				   <tr>
					<td>
						<fmt:parseDate value="${orcamento.dataLancamento}" pattern="yyyy-MM-dd" var="dataLancamento" type="both" />
						<fmt:formatDate pattern="dd/MM/yyyy" value="${dataLancamento}" /> <br />
			            
					</td>
					<td> 
			      		 ${orcamento.cliente.nome}
			      	</td>
					<td> 
			      		R$ ${orcamento.totalOrcamento}
			      	</td>
					<td>
			      		<c:choose>
							<c:when test="${orcamento.parcelasAPagar > 0}">
								<input class="camposAPagar" type="text" value="EM DÉBITO" readonly="readonly">
							</c:when>
							<c:when test="${orcamento.parcelasAPagar == 0}">
								<input class="camposQuitados" type="text" value="QUITADO" readonly="readonly">
							</c:when>
						</c:choose>
			      	</td>

					    <td> 
			      			${orcamento.parcelasPagas}
			      		- 
			      			${orcamento.totalParcelas}
			      		</td>
			      		<td> 
					    	<div class="btnAcoes">

					      		<button type="submit" name="detalhes" title="Mais informações." value="${orcamento.id}" class="btn btn-outline-info btn-sm" > <i class="fa fa-info-circle" ></i> Info</button>
					    		
					      		
							</div>
					  	</td>	
					  </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
		</form>
                
                  </div>
                </div>
              </div>
            </div>
          </div>
        
        
        
     
        </div>
        <!-- content-wrapper ends -->

        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
 
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
<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>
       
        
</body>
</html>