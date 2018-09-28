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
<title>Buscar Categorias</title>
</head>
<body>

<div class="principal">
<br />
<br />
		<div class="page-header">
			<h2>Lista de Categorias</h2>
		</div>
	
<form action="buscaCategoria" method="post">
	<div>
	<div class="esquerda" style=" width: 30%">		
		<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" /> 
	</div>
	<div class="direita">		
		<button  type="submit" name="Enviar" style=" font-size:24px;" class="btn btn-outline-info"> <i class="fa fa-search" aria-hidden="true"></i></button>
	</div>
	</div>	
</form>	
		
<form action="gerenciaCategoria" method="post">


<div class="table-responsive">
	<table class="table table-hover table-striped">
	<caption>Lista de Categorias</caption>
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nome</th>

		    </tr>
		  </thead>
	  <tbody>
	
	   <c:forEach var="categorias" items="${categorias}">
		    <tr>
		      <th scope="row">${categorias.id}</th>
		      <td>${categorias.nome}</td>
		 
		      <td> 
		      	
		      <button type="submit" name="alterar" value="${categorias.id}" style="font-size:14px;" class="btn btn-outline-warning"> <i class="fa fa-pencil-square-o"></i></button>
			  	
			  <button type="submit" name="excluir" value="${categorias.id}" style="font-size:14px;" class="btn btn-outline-danger"> <i class="	fa fa-trash-o"></i></button>
				

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