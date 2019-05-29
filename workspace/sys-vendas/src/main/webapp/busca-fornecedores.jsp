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
<title>Buscar Fornecedores</title>
</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container">
	
<form action="busca-fornecedor.jsp" method="post">
	<div id="divBusca">
	<div class="campoBusca" >		
		<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" title="Escreva um nome para pesquisar." /> 
	</div>
	<div class="direita">		
		<button id="btnBusca" type="submit" name="Enviar" class="btn btn-outline-info"> <i class="fa fa-search" aria-hidden="true"></i></button>
	</div>
	</div>	
	
	<c:choose>	
		<c:when test="${empty fornecedor}">
			<button id="btnBuscaTodos" value="busca-fornecedor.jsp?filtro=" type="submit" name="btnBuscaTodos" class="btn btn-outline-secondary" title="Listar todos" style="float: right;"> <i class="fa fa-search" aria-hidden="true" > Qualé todos</i></button>
		</c:when>
	</c:choose>	
</form>	
		
<form action="gerencia-fornecedor.jsp" method="post">
	<c:choose>	
		<c:when test="${empty fornecedor}">
			<div class="box">
			<div>
				<label class="listaNula">Não encontramos registros.</label>	
			</div>
			<div>
				<a href="busca-fornecedor.jsp?filtro=" title="Listar todos os fornecedores."> Ver todos.</a> |
				<a href="cadastrar-fornecedor.jsp" title="Cadastrar um novo fornecedor."> Adicionar </a> |
				<a href="orcamento.jsp" title="Página de orçamento."> Orçamento </a>
			</div>
		
			</div>
				
		</c:when>
			
		<c:when test="${not empty fornecedor}">
		<div class="table-responsive">
			<table class="table table-hover">
			<caption>Lista de Fornecedores</caption>
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nome</th>
				      <th scope="col">Endereco</th>
				      <th scope="col">Fone</th>
				      <th scope="col">Email</th>
				      <th scope="col">Observação</th>
				      <th> Ações</th>
		
				    </tr>
				  </thead>
			  <tbody>
			
			   <c:forEach var="fornecedor" items="${fornecedor}">
				    <tr>
				      <th scope="row">${fornecedor.id}</th>
				      <td>${fornecedor.nome}</td>
				      <td>${fornecedor.endereco}</td>
				      <td>${fornecedor.fone}</td>
				      <td>${fornecedor.email}</td>
				 	  <td>${fornecedor.observacao}</td>
				 
				      <td> 
				      <div class="btnAcoes">
				  
				      <button type="submit" name="info" value="${fornecedor.id}"  class="btn btn-outline-info" title="Mais Informações."> <i class="fa fa-info-circle"></i> Info</button>
				      <button type="submit" name="alterar" value="${fornecedor.id}"  class="btn btn-outline-warning" title="Alterar Fornecedor."> <i class="fa fa-pencil-square-o"></i> Alterar</button>
					  <button type="submit" name="remover" value="${fornecedor.id}" class="btn btn-outline-danger" title="Remover fornecedor do sistema."> <i class="	fa fa-trash-o"></i> Remover</button>
						
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