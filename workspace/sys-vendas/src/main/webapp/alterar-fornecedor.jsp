<!doctype html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Fornecedor</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css" >

</head>
<body>
<div class="principal">
	<div class="page-header">
  		<h1>Alterar Fornecedor </h1>
	</div>
	<form action="alteraFornecedor" method="post">
	<fieldset class="campo">
	<legend>Identifica��o</legend>

	<div class="esquerda">
		
		<div class="caixa">
			<label for="nome">Nome - RS:</label>
			<input id="fieldComum" type="text" value="${fornecedor.nome}" name="nome" size="40" class="form-control" aria-describedby="sizing-addon3">  
		</div>

		<div class="caixa">
			<label for="cnpjCpf">CNPJ - CPF:</label>
			<input id="fieldComum" type="text" value="${fornecedor.cnpjCpf}" name="cnpjCpf" size="40" class="form-control" aria-describedby="sizing-addon3">  	
		</div> 
	  
	</div>
		
	<div class="direita">
	<label>Pessoa:</label>
		<div class="radio">
				
				<input type="radio" id="pessoa1" name="pessoa" value="${fornecedor.pessoa}"
					checked> <label for="situacao1">F�sica</label>&nbsp; <input
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
			<input id="fieldComum" type="text" name="endereco" value="${fornecedor.endereco}" size="40" class="form-control" aria-describedby="sizing-addon3">  
			
			<div class="esquerda">
				<label for="cep">CEP:</label>
				<input id="fieldsMedio"  type="text" name="cep" value="${fornecedor.cep}" class="form-control"  >  
			</div>
			<div class="direita">
				<label for="bairro">Bairro:</label>
				<input id="fieldsMedio" type="text" name="bairro" value="${fornecedor.bairro}" class="form-control"  >  
			</div>
			
			<div class="esquerda">
				<label for="cidade">Cidade:</label>
				<input id="fieldsMedio" type="text" name="cidade" value="${fornecedor.cidade}"  class="form-control"  >  
			</div>
			
			<div class="direita">
				<label for="uf">UF:</label>
				<input id="fieldsPequeno" type="text" name="uf" value="${fornecedor.uf}" class="form-control">
			</div>
		</div>
	</div>
	
	<div class="direita">
		<div class="caixa">
			<label for="complemento">Complemento:</label>
			<input id="fieldComum" type="text" name="complemento" value="${fornecedor.complemento}" class="form-control" >
			
			<div class="esquerda">
				<label for="fone">Fone:</label>
				<input id="fieldsMedio" type="text" name="fone" value="${fornecedor.fone}" class="form-control" >
			</div>
			<div class="direita">
				<label for="email">Email:</label>
				<input id="fieldsMedio" type="text" name="email" 
				value="${fornecedor.email}" class="form-control" >
			</div>
			<label for="observacao">Observa��o:</label>
			<input type="text" name="observacao" value="${fornecedor.observacao}"
			 id="fieldComum" class="form-control" >	
		</div>
	</div>
	
	<br />
		<div class="caixa">
			<input type="submit" class="btn btn-primary" name="Enviar"> 
			<input type="hidden"  name="fornecedorId" value="${fornecedor.id}">		
		</div>
	<br /><br />
	
	</fieldset>	
		
	</form>
	</div>
</body>
</html>