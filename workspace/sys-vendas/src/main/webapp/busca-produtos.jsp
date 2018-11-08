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
<title>Buscar Produtos</title>
</head>
<body>

<div class="principal">
<br />
<br />
		<div class="page-header">
			<h2>Lista de Produtos</h2>
		</div>
	
<form action="buscaProdutos" method="post">
	<div>
	<div class="campoBusca">		
		<input type="text" class="form-control mr-sm-2" name="filtro" placeholder="Busca por nome" /> 
	</div>
	<div class="direita">		
		<button  id="btnBusca" type="submit" name="Enviar" class="btn btn-outline-info"> <i class="fa fa-search" aria-hidden="true"></i></button>
	</div>
	</div>	
</form>	
		
<form action="gerenciaProdutos" method="post">


<div class="table-responsive">
	<table class="table table-hover ">
	<caption>Lista de Produtos</caption>
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col"> # </th>
		      <th scope="col"> Imagem </th>
		      <th scope="col"> Nome </th>
		      <th scope="col"> Descricao/Indica��o </th>
		      <th scope="col"> Custo Unid </th>
		      <th scope="col"> Sugest�o Venda </th>
		      <th scope="col"> Estoque </th>
		      <th scope="col"> A��es</th>
		    </tr>
		  </thead>
	  <tbody>
	
	   <c:forEach var="produto" items="${produtos}">
		    <tr>
		      <th scope="row">${produto.id}</th>
		      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
				<td>-${produto.nome}<br />
					-${produto.volume}
				</td>
				<td>-${produto.descricao}<br />
					-${produto.indicacao}
				</td>
				
			    <td>R$ ${produto.custoUnid}</td>
				<td class="sugestaoVenda">R$ ${produto.sugestaoVenda}</td>
				<td>${produto.estoque.qtdDisponivel}</td>

		 

		      <td> 
		    <div class="btnAcoes">
		      <button  type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info"> <i class="fa fa-info-circle"></i> Info</button>
		      <button type="submit" name="alterar" value="${produto.id}" class="btn btn-outline-warning"> <i class="fa fa-pencil-square-o"></i> Atualizar</button>	
			  <button type="submit" name="remover" value="${produto.id}" class="btn btn-outline-danger">  <i class="fa fa-trash-o"></i> Remover</button>
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