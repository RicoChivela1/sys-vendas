<!doctype html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Fornecedor</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

</head>
<body>
<div class="principal">
	<div class="page-header">
  		<h1>Cadastro de Fornecedor </h1>
	</div>
	<form action="novoFornecedor" >
	<fieldset class="campo">
	<legend>Identifica��o</legend>

	<div class="esquerda">
		
		<div class="caixa">
			<label for="nome">Nome - RS:</label>
			<input type="text" name="nome" size="40" class="form-control" aria-describedby="sizing-addon3">  
		</div>

		<div class="caixa">
			<label for="cnpjCpf">CNPJ - CPF:</label>
			<input type="text" name="cnpjCpf" size="40" class="form-control" aria-describedby="sizing-addon3">  	
		</div>
		
	</div>
		<br />
	<div class="direita">
		<div class="radio">
				<p>Pessoa:</p>
				<input type="radio" id="pessoa1" name="pessoa" value="FISICA"
					checked> <label for="situacao1">F�sica</label> <input
					type="radio" id="pessoa2" name="pessoa" value="JURIDICA"> <label
					for="situacao2">Jur�dica</label>
		</div>

	</div>
		
	</fieldset>
	

	<fieldset>
	<legend>Endere�o</legend>
	<div class="esquerda">
		
		<div class="caixa">
			<label for="endereco">Endere�o:</label>
			<input type="text" name="endereco" size="40" class="form-control" aria-describedby="sizing-addon3">  
			
			<div class="esquerda">
				<label for="cep">CEP:</label>
				<input type="text" name="cep" size="40" class="form-control" style="width: 225px; " >  
			</div>
			<div class="direita">
				<label for="bairro">Bairro:</label>
				<input type="text" name="bairro" size="40" class="form-control" style="width: 225px; margin-left: 20px;" >  
			</div>
			
			<div class="esquerda">
				<label for="cidade">Cidade:</label>
				<input type="text" name="cidade" size="40" class="form-control" style="width: 225px; margin-right: 20px" >  
			</div>
			
			<div class="direita">
				<label for="uf">UF:</label>
				<input type="text" name="uf" size="30" class="form-control" style="width: 50px; margin-left: 20px;" >
			</div>
			
		</div>
	</div>
	
	
	<div class="direita">
		<div class="caixa">
			<label for="complemento">Complemento:</label>
			<input type="text" name="complemento" size="30" class="form-control" >
			
			<div class="esquerda">
				<label for="fone">Fone:</label>
				<input type="text" name="fone" size="30" class="form-control" style="width: 225px; height: 38px" >
			</div>
			<div class="direita">
				<label for="email">Email:</label>
				<input type="text" name="email" size="30" class="form-control" style="width: 225px; margin-left: 20px;" >
			</div>
			<label for="observacao">Observa��o:</label>
			<input type="text" name="observacao" size="30" class="form-control" >	
		</div>
	</div>
	
	<br />
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