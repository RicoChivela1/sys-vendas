<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import ="br.com.aluizio.sysvendas.model.Carrinho"%>
<%@page import ="br.com.aluizio.sysvendas.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<% 
HttpSession sessao;
HttpSession sessaoCliente; 
%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrinho</title>
</head>
<body>
<div class="page-header">
			
			<form action="logout" method="post">
			<div class="caixa" style="margin-left: 80%;">		
				Olá, ${usuarioLogado.nome} <input type="submit" name="logout" value="Log-out" class="btn btn-primary" > 	
			</div>	
			</form>
		</div>
	<h3>Orçamento: </h3>
	
	
	
	<fieldset class="campo">
	<legend>Dados do Cliente: </legend>
	
	Nome: ${sessaoCliente.nome} 

	</fieldset>
	<a href="buscaClientes?filtro=">Adicionar/Modificar</a>	
	<br /><br />	
	
	<fieldset class="campo">
	<legend>Lista de produtos: </legend>
	
	<table>
	<tr>
		<th>id do array</th>
		<th>id do produto</th>
		<th>Nome</th> 
		<th>Quantidade</th>
		<th>Valor unitário</th>
		<th>Valor total</th>
		<th>Remover</th>
	</tr>
	
	<c:forEach var="produtoCarrinho" items="${carroCompras}" varStatus="counter">
	<tr>
		<td>${counter.index}</td>
		<td>${produtoCarrinho.idProduto}</td>
		<td>${produtoCarrinho.nomeProduto}</td>
		<td>${produtoCarrinho.qtdProduto}</td>
		<td>${produtoCarrinho.custoUnid}</td>
		<td>${produtoCarrinho.subTotal}</td>
		<td> 
			<a href="remover-carrinho.jsp?id=${counter.index}">Eliminar</a>	
		</td>
	</tr>
	</c:forEach>

	</table>
	</fieldset>
	
	<a href="#">Adicionar mais ítens</a>
		
</body>
</html>