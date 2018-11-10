<!doctype html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Cliente</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<div class="principal">
	<div class="page-header">
  		<h1>Cadastro de Clientes </h1>
	</div>
	<form action="adicionaAlteraCliente" method="post">
	<fieldset class="campo">
	<legend>Informações pessoais</legend>

		<div class="esquerda">
		
		<div class="caixa">
			<label for="nome">Primeiro Nome:</label>
			<input id="fieldComum" type="text" name="nome"  class="form-control" aria-describedby="sizing-addon3">  
			<label for="sobreNome">Segundo Nome:</label>
			<input id="fieldComum" type="text" name="sobreNome"  class="form-control" aria-describedby="sizing-addon3">
		</div>
		
		<div class="fieldsData">
		
			<label>Nascimento: </label><br /> 
			<input id="fieldsPequenoData" type="text" name="dia" size="2" maxlength="2" placeholder="dd" class="form-control" aria-describedby="sizing-addon3" required="required"> 
			<input id="fieldsPequenoData" type="text" name="mes" size="2" maxlength="2" placeholder="mm" class="form-control" aria-describedby="sizing-addon3"required="required"> 
			<input id="fieldsPequenoData" type="text" name="ano" size="4" maxlength="4" placeholder="aaaa" class="form-control" aria-describedby="sizing-addon3" required="required"><br />
		
		</div>
		
		<label>Pessoa:</label>
		<div class="radio">
				
				<input type="radio" id="pessoa1" name="pessoa" value="FISICA"
					checked> <label for="situacao1">Física</label> &nbsp; <input
					type="radio" id="pessoa2" name="pessoa" value="JURIDICA"> <label
					for="situacao2">Jurídica</label>
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
			<input id="fieldsMedio" type="text" name="email" class="form-control" aria-describedby="sizing-addon3">
			<label for="celular">Celular:</label>
			<input id="fieldsMedio" type="text" name="celular" class="form-control" aria-describedby="sizing-addon3">
			<label for="observacao">Observação:</label>
			<input id="fieldComum" type="text" name="observacao" class="form-control" aria-describedby="sizing-addon3">
		</div>
		
			<label>Situação:</label>
			<div class="radio">
				<input type="radio" id="situacao1" name="situacao" value="ATIVO"
					checked> <label for="situacao1">Ativo</label> &nbsp; <input
					type="radio" id="situacao2" name="situacao" value="BLOQUEADO">
				<label for="situacao2">Bloqueado</label>
			</div>
		</div>
	</fieldset>
	
	<fieldset>
	<legend>Endereço</legend>
	<div class="esquerda">
		<div class="caixa">
			<label>Endereço:</label>
			<input id="fieldComum" type="text" name="endereco" class="form-control" aria-describedby="sizing-addon3" required="required"> 
			<label>Bairro:</label>
			<input id="fieldsMedio" type="text" name="bairro" class="form-control" aria-describedby="sizing-addon3">
			<label>Cidade:</label>
			<input id="fieldsMedio" type="text" name="cidade" class="form-control" aria-describedby="sizing-addon3">  
			<label>Complemento:</label>
			<input id="fieldComum" type="text" name="complemento" class="form-control" aria-describedby="sizing-addon3">
		</div>
	</div>
	
	
	<div class="direita">
			<div class="caixa">
			<label for="uf">UF:</label>
			<input id="fieldsPequeno" type="text" name="uf" size="2" class="form-control" aria-describedby="sizing-addon3" > 
			
			<label for="cep">CEP:</label>
			<input id="fieldComum" type="text" name="cep" class="form-control" aria-describedby="sizing-addon3" >
			<label>Fone:</label>
			<input id="fieldsMedio" type="text" name="fone" class="form-control" aria-describedby="sizing-addon3">
			<label>Observação:</label>
			<input id="fieldComum" type="text" name="observacao" class="form-control" aria-describedby="sizing-addon3">
			<label>Número:</label>
			<input id="fieldsMedio" type="text" name="numero" class="form-control" aria-describedby="sizing-addon3"> 
		</div>	
	</div>
		<div class="caixa">
			<input type="submit" class="btn btn-primary" name="Enviar"> 
			<input type="reset" class="btn btn-default" name="Limpar">		
		</div>
	<br /><br />
	
	</fieldset>	
		
	</form>
	</div>
</body>
</html>