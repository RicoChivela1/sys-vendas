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

<div class="principal">
<br />
<br />
		<div class="page-header">
			<h2>Lista de Clientes</h2>
		</div>
	
<form action="buscaClientes" method="post">
	<div>
	<div class="campoBusca">		
		<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" /> 
	</div>
	<div class="direita">		
		<button  type="submit" name="Enviar" class="btn btn-outline-info" id="btnBusca"> <i class="fa fa-search" aria-hidden="true"></i></button>
	</div>
	</div>	
</form>	
		
<form action="gerenciaCliente" method="post">


<div class="table-responsive">
	<table class="table table-hover">
	<caption>Lista de Clientes</caption>
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nome</th>
		      <th scope="col">Sobre Nome</th>
		      <th scope="col">Situação</th>
		      <th scope="col">Celular</th>
		      <th scope="col" ></th>

		    </tr>
		  </thead>
	  <tbody>
	
	   <c:forEach var="cliente" items="${clientes}">
		    <tr>
		      <th scope="row">${cliente.id}</th>
		      <td>${cliente.nome}</td>
		      <td>${cliente.sobreNome}</td>
		      <td>${cliente.situacao}</td>
		      <td>${cliente.celular}</td>
		 
		      <td> 
			  <div class="btnAcoes">
		  
		      <button type="submit" name="info" value="${cliente.id}"  class="btn btn-outline-info"> <i class="fa fa-info-circle"></i> Info</button>
		      <button type="submit" name="alterar" value="${cliente.id}"  class="btn btn-outline-warning"> <i class="fa fa-pencil-square-o"></i> Alterar</button>
			  <button type="submit" name="remover" value="${cliente.id}" class="btn btn-outline-danger"> <i class="	fa fa-trash-o"></i> Remover</button>
				
			  </div>
		      </td>
		    	
		    </tr>
	   </c:forEach>
	  </tbody>
	</table>
</div>
</form>
</div>


</body>
</html>