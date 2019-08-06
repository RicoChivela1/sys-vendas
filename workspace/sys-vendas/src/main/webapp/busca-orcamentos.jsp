<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="pt-BR">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="magestic/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="magestic/vendors/base/vendor.bundle.base.css">

<link rel="stylesheet" href="magestic/vendors/datatables.net-bs4/dataTables.bootstrap4.css">

<link rel="stylesheet" href="magestic/css/style.css">
<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Buscar Or�amento</title>
</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>



<div id="container">

<div class="container-scroller">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-description">BUSCAR OR�AMENTO</h4>
					<form action="buscaOrcamento" method="post">
						<div id="divBusca">
						<div class="campoBusca">		
							<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Nome do cliente" title="Escreva um nome para pesquisar"/> 
						</div>
						<div class="direita">		
							<button  type="submit" name="Enviar" class="btn btn-sm btn-primary"> <i class="mdi mdi-yeast" aria-hidden="true"></i></button>
						</div>
						</div>	
					</form>	
                  </div>
                </div>
              </div>
            </div>
            <br />
            
            <div class="row">
            <div class="col-md-12 stretch-card">
              <div class="card">
     
                <div class="card-body">
                  
                   <h4 class="card-description">LISTA DE OR�AMENTOS</h4>
					<form action="gerenciaCliente" method="post">
						<c:choose>	
							<c:when test="${empty clientes}">
							<div class="box">
							<div>
								<label class="listaNula">N�o encontramos registros.</label>	
							</div>
							<div>
								<a href="buscaClientes?filtro=" title="Listar todos os or�amentos."> Ver todos </a> |
								<a href="orcamento.jsp" title="P�gina de or�amento."> Or�amento </a>
							</div>
						
							</div>
								
							</c:when>
							
							<c:when test="${not empty clientes}">
					
								<div class="table-responsive">
									<table class="table table-striped">
									<caption>Lista de Clientes</caption>
										   <thead>
										    <tr>
										      <th>#</th>
										      <th>Nome</th>
										      <th>Sobre Nome</th>
										      <th>Situa��o</th>
										      <th>Celular</th>
										      <th>A��es</th>
								
										    </tr>
										  </thead>
									  <tbody>
									
									   <c:forEach var="cliente" items="${clientes}">
										    <tr>
										      <td>${cliente.id}</td>
										      <td>${cliente.nome}</td>
										      <td>${cliente.sobreNome}</td>
										      <td>${cliente.situacao}</td>
										      <td>${cliente.celular}</td>
										 
										      <td> 
											  <div class="btnAcoes">
											      <button type="submit" name="info" value="${cliente.id}"  class="btn btn-outline-info" title="Mais informa��es."> <i class="fa fa-info-circle"></i> Info</button>
											      <button type="submit" name="alterar" value="${cliente.id}"  class="btn btn-outline-warning" title="Alterar dados do cliente."> <i class="fa fa-pencil-square-o"></i> Alterar</button>
												  <button type="submit" name="remover" value="${cliente.id}" class="btn btn-outline-danger" title="Excluir este cliente do sistema."> <i class="	fa fa-trash-o"></i> Remover</button>
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
        </div>
      </div> 
	</div>
<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>