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
<title>Buscar Usu�rios</title>
</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>
<div id="container">
	
<form action="buscaUsuario" method="post">
	<div>
	<div class="campoBusca">		
		<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" title="Escreva algo para pesquisar."/> 
	</div>
	<div class="direita">		
		<button id="btnBusca" type="submit" name="Enviar" class="btn btn-outline-info"> <i class="fa fa-search" aria-hidden="true"></i></button>
	</div>
	</div>	
	<c:choose>	
		<c:when test="${empty usuarios}">
				<button  id="btnBuscaTodos" value="buscaUsuario?filtro=" type="submit" name="btnBuscaTodos" class="btn btn-outline-secondary" title="Listar todos." style="float: right;"> <i class="fa fa-search" aria-hidden="true" > Qual� todos</i></button>
		</c:when>
	</c:choose>	
</form>	
		
<form action="gerenciaUsuario" method="post">
	<c:choose>	
		<c:when test="${empty usuarios}">
		<div class="box">
		<div>
			<label class="listaNula">N�o encontramos registros.</label>	
		</div>
		<div>
			<a href="buscaUsuario?filtro=" title="Listar todos os usu�rios."> Ver todos.</a> | 
			<a href="cadastrar-usuario.jsp" title="Cadastrar um novo usu�rio."> Adicionar </a> |
			<a href="orcamento.jsp" title="P�gina de or�amento."> Or�amento </a>
		</div>
	
		</div>
			
		</c:when>
		
		<c:when test="${not empty usuarios}">
			<div class="table-responsive">
			<table class="table table-striped">
			<caption>Lista de Usu�rios</caption>
				<thead>
					<tr>
				     <th>#</th>
				     <th>Nome</th>
				     <th>Login</th>
				     <th>Senha</th>
				     <th>A��es</th>
					</tr>
				</thead>
			    <tbody>	
			
		   <c:forEach var="usuario" items="${usuarios}">
			    <tr> 
			      <td>${usuario.id}</td>
			      <td>${usuario.nome}</td>
			      <td>${usuario.login}</td>
			      <td>${usuario.senha}</td>
			      
			      <td>
			      		<div class="btnAcoes">
			  
				      		<button type="submit" name="info" value="${usuario.id}"  class="btn btn-outline-info" title="Mais informa��es."> <i class="fa fa-info-circle"></i> Info</button>
				      		<button type="submit" name="alterar" value="${usuario.id}"  class="btn btn-outline-warning" title="Alterar informa��es."> <i class="fa fa-pencil-square-o"></i> Alterar</button>
					  		<button type="submit" name="remover" value="${usuario.id}" class="btn btn-outline-danger" title="Excluir usu�rio do sistema."><i class="fa fa-trash-o"></i> Remover</button>
						
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