<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  >
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Buscar Clientes</title>
</head>
<body>

<ul>
	<c:forEach var="cliente" items="${clientes}">
		<li> 
			${cliente.nome} 

			${cliente.situacao}

			${cliente.celular}

			${cliente.observacao}
		</li>
	</c:forEach>
</ul>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Situação</th>
      <th scope="col">Celular</th>
      <th scope="col">+Info</th>
      <th scope="col">Orçamento</th>
      <th scope="col">Alterar</th>
      <th scope="col">Remover</th>
    </tr>
  </thead>
  <tbody>

   <c:forEach var="cliente" items="${clientes}">
	    <tr>
	      <th scope="row">${cliente.id}</th>
	      <td>${cliente.nome}</td>
	      <td>${cliente.situacao}</td>
	      <td>${cliente.celular}</td>
	      <td>button</td>
	      <td>button</td>
	      <td>button</td>
	      <td>button</td>
	    </tr>
   </c:forEach>
  </tbody>
</table>

</body>
</html>