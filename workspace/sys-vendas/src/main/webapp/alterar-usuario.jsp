<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Usuário</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css"  >

</head>
<body>
<div class="principal">${usuarioLogado.nome}
	<div class="page-header">
		<h1>Alterar Usuário</h1>
	</div>

	<form action="adicionaAlteraUsuario" method="post">
	<fieldset class="campo">
		<legend>Dados do Usuário</legend>
		<div class="esquerda">
			<div class="esquerda">
				<div class="caixa">
					<label for="nome">Nome:</label> 
					<input id="fieldComum" required="required" name="nome" value="${usuario.nome}" class="form-control" >
				</div>
				<div class="caixa">
					<label for="login">Login:</label> 
					<input id="fieldComum" required="required" name="login" value="${usuario.login}" class="form-control" >
				</div>
				<div class="caixa">
					<label for="senha">Senha:</label> 
					<input id="fieldComum" required="required" name="senha" value="${usuario.senha}" size="40" class="form-control" >
				</div>
				<div class="caixa">
					<label for="senha2">Repita a senha:</label> 
					<input id="fieldComum" required="required" name="senha2" value="${usuario.nome}" size="40" class="form-control" >
				</div>
				
				<div id="btnForm">
					<input type="submit" class="btn btn-primary" name="Enviar"> 	
					<input type="hidden" name="usuarioId" value="${usuario.id}">
				</div>
	
			</div>
		</div>

	</fieldset>
		
	</form>
</div>
</body>
</html>