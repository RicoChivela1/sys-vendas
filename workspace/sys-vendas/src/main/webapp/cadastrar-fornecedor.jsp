<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!doctype html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Fornecedor</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css" >

</head>
<body>

<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container">
	<form action="adicionar-fornecedor.jsp" method="post">
	
	<fieldset class="campo">
	<legend>Identificação</legend>

	<div class="esquerda">
		
		<div class="caixa">
			<label for="nome">Nome - RS:</label>
			<input id="fieldComum" type="text" name="nome" size="40" class="form-control" aria-describedby="sizing-addon3">  
		</div>

		<label>Pessoa:</label>
		<div class="radio">
			<input type="radio" id="pessoa1" name="pessoa" value="FISICA"
				checked> <label for="situacao1">Física</label> &nbsp;<input
				type="radio" id="pessoa2" name="pessoa" value="JURIDICA"> <label
				for="situacao2">Jurídica</label>
		</div>
		
	</div>
	<div class="direita">
		<div class="caixa">
			<label for="cnpjCpf">CNPJ - CPF:</label>
			<input id="fieldComum" type="text" name="cnpjCpf" size="40" class="form-control" aria-describedby="sizing-addon3">  	
		</div>
	</div>
	</fieldset>

	<fieldset>
	<legend>Endereço</legend>
	<div class="esquerda">
		
		<div class="caixa">
			<label for="endereco">Endereço:</label>
			<input id="fieldComum" type="text" name="endereco" size="40" class="form-control" aria-describedby="sizing-addon3">  
			
			<div class="esquerda">
				<label for="cep">CEP:</label>
				<input id="fieldsMedio"  type="text" name="cep" class="form-control"  >  
			</div>
			<div class="direita">
				<label for="bairro">Bairro:</label>
				<input id="fieldsMedio" type="text" name="bairro" class="form-control"  >  
			</div>
			
			<div class="esquerda">
				<label for="cidade">Cidade:</label>
				<input id="fieldsMedio" type="text" name="cidade" class="form-control"  >  
			</div>
			
			<div class="direita">
				<label for="uf">UF:</label>
				<input id="fieldsPequeno" type="text" name="uf" class="form-control">
			</div>
			
		</div>
	</div>
	
	
		<div class="direita">
		<div class="caixa">
			<label for="complemento">Complemento:</label>
			<input id="fieldComum" type="text" name="complemento" class="form-control" >
			
			<div class="esquerda">
				<label for="fone">Fone:</label>
				<input id="fieldsMedio" type="text" name="fone" class="form-control" >
			</div>
			<div class="direita">
				<label for="email">Email:</label>
				<input id="fieldsMedio" type="text" name="email" class="form-control" >
			</div>
			<label for="observacao">Observação:</label>
			<input type="text" name="observacao" id="fieldComum" class="form-control" >	
		</div>
	</div>
	</fieldset>	
		<div id="btnForm">
			<input type="submit" class="btn btn-primary" name="Enviar" value="Enviar"> 
			<input type="reset" class="btn btn-default" name="Limpar" value="Limpar">		
		</div>	
	</form>
	</div>
	
	<footer class="site-footer push">
    	<c:import url="rodape.jsp"/>
	</footer>
	
</body>
</html>