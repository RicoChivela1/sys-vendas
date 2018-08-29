<!doctype html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Cliente</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<div class="principal">
	<div class="page-header">
  		<h1>Cadastro de Clientes </h1>
	</div>
	<form action="novoCliente" method="post">
	<fieldset class="campo">
	<legend>Informações pessoais</legend>

		<div class="esquerda">
		
		<div class="caixa">
			<label for="nome">Primeiro Nome:</label>
			<input type="text" name="nome" size="40" class="form-control" aria-describedby="sizing-addon3">  
			<label for="sobreNome">Segundo Nome:</label>
			<input type="text" name="sobreNome" size="40" class="form-control" aria-describedby="sizing-addon3">
			<br />
		</div>
		<div class="caixa">
		<div class="input-group input-group-sm">
			Nascimento: <br /> 
			<input type="text" name="dia" size="2" maxlength="2" placeholder="dd" class="form-control" aria-describedby="sizing-addon3"> &nbsp; / &nbsp;
			<input type="text" name="mes" size="2" maxlength="2" placeholder="mm" class="form-control" aria-describedby="sizing-addon3"> &nbsp; / &nbsp;
			<input type="text" name="ano" size="4" maxlength="4" placeholder="aaaa" class="form-control" aria-describedby="sizing-addon3"><br />
		</div>
		</div>
		<br />
		
		<div class="radio">
				<p>Pessoa:</p>
				<input type="radio" id="pessoa1" name="pessoa" value="FISICA"
					checked> <label for="situacao1">Física</label> <input
					type="radio" id="pessoa2" name="pessoa" value="JURIDICA"> <label
					for="situacao2">Jurídica</label>
			</div>

			<div class="radio">
				<p>Sexo:</p>
				<input type="radio" id="sexo1" name="sexo" value="M"> <label
					for="situacao1">Masculino</label> <input type="radio" id="sexo2"
					name="sexo" value="F" checked> <label for="situacao2">Feminino</label>
			</div>
			
		
		
		</div>
		
		<div class="direita">
		<div class="caixa">
			<label for="email">Email:</label>
			<input type="text" name="email" size="30" class="form-control" aria-describedby="sizing-addon3">
			<label for="celular">Celular:</label>
			<input type="text" name="celular" size="30" class="form-control" aria-describedby="sizing-addon3">
			<label for="observacao">Observação:</label>
			<input type="text" name="observacao" size="30" class="form-control" aria-describedby="sizing-addon3">
		</div>
		
			<div class="radio">
				<p>Situação:</p>
				<input type="radio" id="situacao1" name="situacao" value="ATIVO"
					checked> <label for="situacao1">Ativo</label> <input
					type="radio" id="situacao2" name="situacao" value="BLOQUEADO">
				<label for="situacao2">Bloqueado</label>
			</div>

			
		</div>
		
	</fieldset>
	
	
	
	
	
	
	
	
	
	<fieldset>
	<legend>Endereço</legend>
	<div class="esquerda">
		
		<div class="caixa">
			Endereço: <input type="text" name="endereco" size="40" class="form-control" aria-describedby="sizing-addon3"> 
			Bairro: <input type="text" name="bairro" size="20" class="form-control" aria-describedby="sizing-addon3">
			Cidade: <input type="text" name="cidade" size="20" class="form-control" aria-describedby="sizing-addon3">  
			Complemento: <input type="text" name="complemento" size="20" class="form-control" aria-describedby="sizing-addon3">
			
		
		</div>
	</div>
	
	
	<div class="direita">
		<div class="caixa">
			UF: <input type="text" name="uf" size="2" class="form-control" aria-describedby="sizing-addon3"> 
			CEP: <input type="text" name="cep" size="20" class="form-control" aria-describedby="sizing-addon3">
			Fone: <input type="text" name="fone" size="20" class="form-control" aria-describedby="sizing-addon3">
			Observação: <input type="text" name="observacao" size="40" class="form-control" aria-describedby="sizing-addon3">
			Número: <input type="text" name="numero" size="10" class="form-control" aria-describedby="sizing-addon3"> 
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