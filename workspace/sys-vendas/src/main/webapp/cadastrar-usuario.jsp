<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Usuário</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  >

</head>
<body>
<div class="principal">
		<div class="page-header">
			<h1>Cadastro de Usuário</h1>
		</div>

	<form action="novoUsuario" method="post">

	<fieldset class="campo">
		<legend>Dados do Usuário</legend>
    
		<div class="esquerda">
				<div class="esquerda">
					<div class="caixa">
						<label for="nome">Nome:</label> 
						<input required="required" name="nome"size="40" class="form-control" >
					</div>
					<div class="caixa">
						<label for="login">Login:</label> 
						<input required="required" name="login"size="40" class="form-control" >
					</div>
					<div class="caixa">
						<label for="senha">Senha:</label> 
						<input required="required" name="senha"size="40" class="form-control" >
					</div>
					<div class="caixa">
						<label for="senha2">Repita a senha:</label> 
						<input required="required" name="senha2"size="40" class="form-control" >
					</div>
					
					<div class="caixa">
						<input type="submit" class="btn btn-primary" name="Enviar"> 	
					</div>
		
				</div>
			</div>

	</fieldset>
		
	</form>
</div>
</body>
</html>