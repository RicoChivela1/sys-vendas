<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Usuário</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  >

</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>

	<div id="container">

	<form action="adicionaAlteraUsuario" method="post">

	<fieldset class="campo">
		<legend>Dados do Usuário</legend>
    
		<div class="esquerda">
			<div class="esquerda">
				<div class="caixa">
					<label for="nome">Nome:</label> 
					<input id="fieldComum" required="required" name="nome"size="40" class="form-control" >
				</div>
				<div class="caixa">
					<label for="login">Login:</label> 
					<input id="fieldComum" required="required" name="login"size="40" class="form-control" >
				</div>
				<div class="caixa">
					<label for="senha">Senha:</label> 
					<input id="fieldComum" required="required" name="senha"size="40" class="form-control" >
				</div>
				<div class="caixa">
					<label for="senha2">Repita a senha:</label> 
					<input id="fieldComum" required="required" name="senha2"size="40" class="form-control" >
				</div>
			</div>
		</div>
	</fieldset>
	<div id="btnForm">
		<input type="submit" class="btn btn-primary" name="Enviar" value="Enviar"> 	
	</div>	
	</form>
</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>
	
</body>
</html>