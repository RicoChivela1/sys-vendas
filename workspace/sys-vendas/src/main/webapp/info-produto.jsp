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
	<div class="page-header">

	</div>
  <form action="      " method="post">	
	<fieldset class="campo">
	<legend>${produto.nome} <span>${produto.volume}</span></legend>
	
		<div class="esquerda">

			<img class="miniaturaProdutoInf" src="./carregadorImagem?id=${produto.id}" />
			<label>R$ </label> 
			<input type="text" value="${produto.sugestaoVenda}" id="redInputInfo" size="10">
				
		
		</div>
		
		<div class="direita">

			<div class="btnForm">
				<div class="divQtdInfo">
					<label>Quatidade disponível:</label>
					<input id="redInputInfo" type="text" value="${produto.estoque.qtdDisponivel}" size="5">
				</div>
				
				<fieldset class="campo">
				<legend><span>Adicionar ao Carrinho</span></legend>
				
				<div class="divCarrinho"><br />
					<div class="esquerdaValor">
						<label>Quantidade: </label>
						<input type="number" name="qtd" value="qtd" min="0" id="fieldsValorSmall" class="form-control" required="required">
					</div>
					
				    <div class="centroValor"> 	
				     	<button type="submit" name="AddCarrinho" value="${produto.id}"  class="btn btn-outline-success"> <i class="fa fa-cart-plus" aria-hidden="true"></i> Add ao Carriho</button>
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
			<label>Descrição:</label> ${produto.descricao}<br />
			<label>Indicação:</label> ${produto.indicacao}<br />
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