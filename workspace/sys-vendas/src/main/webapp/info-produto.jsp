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
<script type="text/javascript" src="js/script.js"></script>
<title>Buscar Produtos</title>
</head>
<body>

<div class="principal">
	<div class="page-header">

	</div>
  <form action="agregar-carrinho.jsp" method="post">	
	<fieldset class="campo">
	<legend>${produto.nome} <span>${produto.volume}</span></legend>
	
		<div class="esquerda">

			<img class="miniaturaProdutoInf" src="./carregadorImagem?id=${produto.id}" />
			<label>R$ </label> 
			<input type="text" value="${produto.sugestaoVenda}" id="redInputInfo" size="10">
			<input type="hidden" name="sugestaoVenda" value="${produto.sugestaoVenda}" />	
		
		</div>
		
		<div class="direita">

			<div class="btnForm">
				<div class="divQtdInfo">
					<label>Quatidade dispon�vel:</label>
					
					<input id="redInputInfo" name="result" type="text" value="${produto.estoque.qtdDisponivel}" size="5">
					<input type="hidden" id="fieldQtdEstoque" value="${produto.estoque.qtdDisponivel}" />
				</div>
				
				<fieldset class="campo">
				<legend><span>Adicionar ao Carrinho</span></legend>
				
				<div class="divCarrinho"><br />
					<div class="esquerdaValor">
						<label>Quantidade: </label>
						<input type="number" name="qtdProduto" id="fieldQtdInfo" onmouseup="calcularEstoque()" class="form-control" required="required" min="1" max="${produto.estoque.qtdDisponivel}">
					</div>
					
				    <div class="centroValor"> 	
				     	<button type="submit" name="idProduto" value="${produto.id}"  class="btn btn-success"> <i class="fa fa-cart-plus" aria-hidden="true"></i> Add</button>
						<input type="hidden" name="nomeProduto" value="${produto.nome}">
					</div>	
				</div>
				
				</fieldset>
			</div>
		</div>

		
	</fieldset>
	<fieldset class="campo">
	<legend>Detalhes:</legend>
	
		<div class="esquerda">
			<br />
			<label>Nome:</label> ${produto.nome}<br />
			<label>Descri��o:</label> ${produto.descricao}<br />
			<label>Indica��o:</label> ${produto.indicacao}<br />
			<label>Custo:</label> ${produto.custoUnid}<br />
			<label>Lucro:</label> ${produto.lucro}<br />
			<label>Percentual:</label> ${produto.percentual}<br />
			
		</div>
		
		<div class="direita">
			
			
		</div>
	</fieldset>
	
	</form>
</div>


</body>
</html>