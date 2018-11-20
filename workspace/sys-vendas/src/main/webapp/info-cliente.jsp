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
<title>Info Cliente</title>
</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>

	<div id="container">
  	<form action="agregar-cliente.jsp" method="post">	
	<fieldset class="campo">
	<legend>${cliente.nome} ${cliente.sobreNome}</legend>
		
		<div class="direita">

			<div class="btnForm">
				
				<fieldset class="campo">
				<legend><span>Adicionar ao Orçamento</span></legend>
				
				<div class="divCarrinho"><br />
					<div class="esquerdaValor">
						
						rsrsr
					</div>
					
				    <div class="centroValor"> 	
				     	<button type="submit" name="id" value="${cliente.id}"  class="btn btn-success"> <i class="fa fa-cart-plus" aria-hidden="true"></i> Add </button>
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
			<label>Nome:</label> ${cliente.nome}<br />
			<label>Sobre Nome:</label> ${cliente.sobreNome}<br />
			<label>Sexo:</label> ${cliente.sexo}<br />
			<label>Pessoa:</label> ${cliente.pessoa}<br />
			<label>SItuação:</label> ${cliente.situacao}<br />
		
			<label>Nascimento:</label> ${cliente.nascimento}<br />
			<label>Observação:</label> ${cliente.observacao}<br />
			
			<label>E-mail:</label> ${cliente.email}<br />
			<label>Celular:</label> ${cliente.celular}<br />

	  		<label>Edereço:</label> ${cliente.endereco}<br />
			<label>Bairro:</label> ${cliente.bairro}<br />
			<label>Cidade:</label> ${cliente.cidade}<br />
			<label>Complemento:</label> ${cliente.complemento}<br />
			<label>Número:</label> ${cliente.numero}<br />
			<label>Uf:</label> ${cliente.uf}<br />
			<label>CEP:</label> ${cliente.cep}<br />
			<label>Fone:</label> ${cliente.fone}<br />
		</div>
		
		<div class="direita">
			
			
		</div>
	</fieldset>
	
	</form>
</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>