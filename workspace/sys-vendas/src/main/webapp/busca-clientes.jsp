<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css"  >
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Buscar Clientes</title>
</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>
<div id="container">
	
<form action="busca-cliente.jsp" method="post">
	<div id="divBusca">
	<div class="campoBusca">		
		<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" title="Escreva um nome para pesquisar"/> 
	</div>
	<div class="direita">		
		<button  type="submit" name="Enviar" class="btn btn-outline-info" id="btnBusca" > <i class="fa fa-search" aria-hidden="true"></i></button>
	</div>
	</div>	
	<c:choose>	
		<c:when test="${empty clientes}">
			<button  id="btnBuscaTodos" value="busca-cliente.jsp?filtro=" type="submit" name="btnBuscaTodos" class="btn btn-outline-secondary" title="Listar todos" style="float: right;"> <i class="fa fa-search" aria-hidden="true" > Listar Todos</i></button>
		</c:when>
	</c:choose>
	
</form>	
		
<form action="gerenciar-cliente.jsp" method="post">


	<c:choose>	
		<c:when test="${empty clientes}">
		<div class="box">
		<div>
			<label class="listaNula">Não encontramos registros.</label>	
		</div>
		<div>
			<a href="busca-cliente.jsp?filtro=" title="Listar todos os clientes."> Ver todos </a> |
			<a href="cadastrar-cliente.jsp" title="Cadastrar um novo cliente."> Adicionar </a> |
			<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
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
					      <th>Situação</th>
					      <th>Celular</th>
					      <th>Ações</th>
			
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
						      <button type="submit" name="info" value="${cliente.id}"  class="btn btn-outline-info" title="Mais informações."> <i class="fa fa-info-circle"></i> Info</button>
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

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>