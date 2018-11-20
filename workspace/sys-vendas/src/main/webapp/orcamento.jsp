<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css"  >
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Orçamento</title>
</head>

<body>

		<div class="page-header">
			<c:import url="cabecalho.jsp"/>	
		</div>


<div id="container">
	
		

<fieldset class="caixa" >
<legend>Orçamento:</legend>

	<form action="#" method="post">
		
		<div class="titOrcamento">Cliente</div>
		
		<fieldset class="campoOrcamento" title="Adicionar um cliente é opcional mas, caso queira fazer isso, saiba que este cliente deve estar previamente cadastrado no sistema.">
		
		<c:choose>
			<c:when test="${empty sessaoCliente.nome}">
				<div id="btnFormOrca">
					<label id="labelAlerta">Adicione um Cliente aqui </label>
					<a href="buscaClientes?filtro=" title="Adiciona um Cliente"><i class="fa fa-plus-circle" style="font-size:24px"></i></a>
				</div>
				
			</c:when>
			<c:when test="${not empty sessaoCliente.nome}">
				<div class="esquerda">
					<label>Nome:</label>
		 				 
		 	<input id ="fieldsMedio" type="text" name="nomeCliente" value="${sessaoCliente.nome} ${sessaoCliente.sobreNome}" class="form-control"/>
				</div>
				<div class="direita">
					<label>Celular:</label>
					<input id ="fieldsMedio" type="text" name="celularCliente" value="${sessaoCliente.celular}" class="form-control"/>
				</div>
				<div id="btnFormOrca">
					<a href="buscaClientes?filtro=" title="Escolha outro Cliente"><i class="fa fa-refresh" style="font-size:24px;"></i></a>
					<a href="eliminar-cliente.jsp" title="Apagar este Cliente"><i class="fa fa-trash-o" style="font-size:24px; color: red;"></i></a>
				</div>
			</c:when>
		</c:choose>		
		</fieldset>
		
		<div class="titOrcamento">Produtos </div>
		
		<fieldset class="campoOrcamento" title="Adicione produtos aqui para que as opções de pagamento apareçam. Boas vendas!">
		<c:choose>
			
			<c:when test="${empty carroCompras}">
				<div id="btnFormOrca">
					<label id="labelAlerta">Adicione produtos aqui </label>
					<a href="buscaProdutos?filtro=" title="Adicionar Produto"><i class="fa fa-plus-circle" style="font-size:24px;"></i></a>
				</div>
			</c:when>
	
			<c:when test="${not empty carroCompras}">
		
				<table class="table table-striped">
				<thead>
				<tr>
					<th scope="col">Número</th>
					<th scope="col">Nome</th> 
					<th scope="col">Quantidade</th>
					<th scope="col">Valor unitário</th>
					<th scope="col">Sub total</th>
					<th scope="col">Remover</th>
				</tr>
				</thead>
				
				<c:forEach var="produtoCarrinho" items="${carroCompras}" varStatus="counter">
				<tbody>
				<tr>
					<td scope="row">${counter.index + 1}</td>
					<td>${produtoCarrinho.nomeProduto}</td>
					<td>${produtoCarrinho.qtdProduto}</td>
					<td>R$ ${produtoCarrinho.custoUnid}</td>
					<td>R$ ${produtoCarrinho.subTotal}</td>
					<td> 
						<a href="remover-carrinho.jsp?id=${counter.index}" title="Remover este produto do carrinho"><i class="fa fa-trash-o" style="font-size:24px; color: red;"></i></a>	
					</td>
				</tr>
				</tbody>
				</c:forEach>
				</table>
		
					<a href="buscaProdutos?filtro=" title="Adicione um produto aqui "><i class="fa fa-plus-circle" style="font-size:24px;"></i></a>
				
			</c:when>
		</c:choose>
		
		</fieldset>

		<c:choose>
			<c:when test="${not empty carroCompras}">
				<div class="titOrcamento"> Pagamento</div>
		
				<fieldset class="campoOrcamento">
				<div class="esquerda">
					<label for="totalOrcamento">Total:</label>
					
					<input id ="fieldsMedio" type="text" name="totalOrcamento" value="${total}" size="10" class="form-control" title="Calculo Automático" disabled="disabled"/>
					
					<label for="qtdParcelas">Parcelas:</label>
					<input type="number" id="qtdParcelas"  class="form-control" value="1" onmouseup="calcularParcela()" min="1" max="12" title="Digite o total de parcelas"/>
					
				</div>
				
				<div class="direita">
					<label for="valorParcela">Valor da Parcela:</label>
					<input id ="fieldsMedio" type="text" name="valorParcela" value="${total}" class="form-control"  title="Não é possível editar." disabled="disabled" />
					<label for="vencParcela">Data Vecimento:</label>  
					<input id ="fieldsMedio" type="date" name="vencParcela" class="form-control" required="required">
				</div>
				</fieldset>
			</c:when>
		</c:choose>
	</form>		
</fieldset>	
	<c:choose>
		<c:when test="${not empty carroCompras}">
			<div id="btnForm"> 	
				<button type="submit" name="idProduto" class="btn btn-success"> <i class="fa fa-money" style="font-size:24px"> </i> Efetivar Venda</button>
			</div>
		</c:when>
	</c:choose>
</div>	

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>
	
</body>
</html>