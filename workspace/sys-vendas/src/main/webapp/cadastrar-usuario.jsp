<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Usu�rio</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css"  >

<script type="text/javascript" src="jquery/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/senhaUsuario.js"></script>

</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>

	<div id="container">

	<form action="adicionar-usuarios.jsp" method="post">
	<fieldset class="campo">
		<legend>Dados do Usu�rio</legend>
		<div class="esquerda">
			<div class="esquerda">
				<div class="caixa">
					<label for="nome">Nome:</label> 
					<input id="fieldComum" name="nome" value="${usuario.nome}" class="form-control" >
				</div>
				<div class="caixa">
					<label for="login">Login:</label> 
					<input id="fieldComum" required="required" name="login" value="${usuario.login}" class="form-control" >
				</div>
				<div class="caixa" id="divSenha">
					<label for="senha">Senha:</label> <img id="imgSenha" src="" />
					<input type="password" id="fieldComum" required="required" title="Insira uma senha de no m�nimo cinco d�gitos" name="senha" value="" size="40" class="form-control" >
					
				</div>
				<div class="caixa" id="divRepeteSenha">
					<label for="repeteSenha">Repita a senha:</label> <img id="imgRepeteSenha" src="" />
					
					<input type="password" id="fieldComum" required="required" title="Repita a senha digitada anteriormente" name="repeteSenha" value="" size="40" class="form-control" >  
					
				</div>
				
				<div id="btnForm">
					<button type='submit' id="submit" disabled="disabled" class='btn btn-success btn-lg'> Enviar </button>
					<input type="hidden" name="usuarioId" value="${usuario.id}">
				
				</div>
	
			</div>
		</div>

	</fieldset>
		
	</form>
</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>
	
</body>
</html>