<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Cliente</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css" >

</head>
<body>
<div class="principal">
	<div class="page-header">
  		<h1>Alterar Cliente</h1>
	</div>
	
	
	<form action="adicionaAlteraCliente" method="post">
	
	<fieldset class="campo">
	<legend>Informa��es pessoais</legend>

		<div class="esquerda">
		
		<div class="caixa">
			<label for="nome">Primeiro Nome:</label>
			<input id="fieldComum" type="text" name="nome" value="${cliente.nome}" class="form-control" aria-describedby="sizing-addon3">  
			
			<label for="sobreNome">Segundo Nome:</label>
			<input id="fieldComum" type="text" name="sobreNome" value="${cliente.sobreNome}" class="form-control" aria-describedby="sizing-addon3">
		</div>
		
		<label>Nascimento: </label>
		<div class="fieldsData">

			<input id="fieldsPequenoData" type="text" name="dia" size="2" maxlength="2" placeholder="dd" class="form-control" aria-describedby="sizing-addon3" required="required"> 
			<input id="fieldsPequenoData" type="text" name="mes" size="2" maxlength="2" placeholder="mm" class="form-control" aria-describedby="sizing-addon3"required="required"> 
			<input id="fieldsPequenoData" type="text" name="ano" size="4" maxlength="4" placeholder="aaaa" class="form-control" aria-describedby="sizing-addon3" required="required"><br />
		
		</div>
		
		<label>Pessoa:</label>
		<div class="radio">
				
				<input type="radio" id="pessoa1" name="pessoa" value="FISICA"
					checked> <label for="situacao1">F�sica</label> &nbsp; <input
					type="radio" id="pessoa2" name="pessoa" value="JURIDICA"> <label
					for="situacao2">Jur�dica</label>
			</div>
			
		<label>Sexo:</label>
			<div class="radio">
				<input type="radio" id="sexo1" name="sexo" value="M"> <label
					for="situacao1">Masculino</label> &nbsp; <input type="radio" id="sexo2"
					name="sexo" value="F" checked> <label for="situacao2">Feminino</label>
			</div>

		</div>
		
		<div class="direita">
		<div class="caixa">
		
		
			<label for="email">Email:</label>
			<input id="fieldsMedio" type="text" name="email" value="${cliente.email}" class="form-control" aria-describedby="sizing-addon3">
			<label for="celular">Celular:</label>
			<input id="fieldsMedio" type="text" name="celular" value="${cliente.celular}" class="form-control" aria-describedby="sizing-addon3">
			
			<label for="observacao">Observa��o:</label>
			<input id="fieldComum" type="text" name="observacao" value="${cliente.observacao}" class="form-control" aria-describedby="sizing-addon3">
		</div>
		
		<label>Situa��o:</label>
			<div class="radio">
				<input type="radio" id="situacao1" name="situacao" value="ATIVO"
					checked> <label for="situacao1">Ativo</label> &nbsp; <input
					type="radio" id="situacao2" name="situacao" value="BLOQUEADO">
				<label for="situacao2">Bloqueado</label>
			</div>
	
		</div>
	</fieldset>
	
	
	<fieldset>
	
	<legend>Endere�o ${cliente.observacao}</legend>
	<div class="esquerda">	
		<div class="caixa">
			<label>Endere�o:</label>
			<input id="fieldComum" type="text" name="endereco" value="${cliente.endereco}" class="form-control" aria-describedby="sizing-addon3" required="required"> 
			<label>Bairro:</label>
			<input id="fieldsMedio" type="text" name="bairro" value="${cliente.bairro}" class="form-control" aria-describedby="sizing-addon3">
			<label>Cidade:</label>
			<input id="fieldsMedio" type="text" name="cidade" value="${cliente.cidade}" class="form-control" aria-describedby="sizing-addon3">  
			<label>Complemento:</label>
			<input id="fieldComum" type="text" name="complemento" value="${cliente.complemento}" class="form-control" aria-describedby="sizing-addon3">
		</div>
		
	</div>
	
	<div class="direita">
		<div class="caixa">
			<label for="uf">UF:</label>
			<input id="fieldsPequeno" type="text" name="uf" value="${cliente.uf} "size="2" class="form-control" aria-describedby="sizing-addon3" > 
			
			<label for="cep">CEP:</label>
			<input id="fieldComum" type="text" name="cep" value="${cliente.cep}" class="form-control" aria-describedby="sizing-addon3" >
			<label>Fone:</label>
			<input id="fieldsMedio" type="text" name="fone" value="${cliente.fone}"  class="form-control" aria-describedby="sizing-addon3">
			<label>Observa��o:</label>
			<input id="fieldComum" type="text" name="observacao" value="${cliente.observacao}" class="form-control" aria-describedby="sizing-addon3">
			<label>N�mero:</label>
			<input id="fieldsMedio" type="text" name="numero" value="${cliente.numero}" class="form-control" aria-describedby="sizing-addon3"> 
		</div>	
	</div>
	</fieldset>	
	<div id="btnForm">
		<input type="submit" class="btn btn-primary" name="Concluir">
		<input type="hidden" name="clienteId" value="${cliente.id}"> 		
	</div>
</form>		

</div>
	


</body>
</html>