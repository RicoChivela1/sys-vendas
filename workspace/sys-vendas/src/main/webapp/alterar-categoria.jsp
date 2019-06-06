<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Categoria</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css"  >

</head>
<body>
<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container">

	<form action="alterar-categoria.jsp" method="post">

	<fieldset class="campo">
		<legend>Dados da Categoria</legend>
    
		<div class="esquerda">
				<div class="esquerda">
					<div class="caixa">
						<label for="nome">Nome:</label> 
						<input id="fieldComum" required="required" name="nome" value="${categoria.nome}" class="form-control" >
					</div>
					
				</div>
				
			</div>

	</fieldset>
		<div id="btnForm">
			<input type="submit" class="btn btn-primary" name="Enviar"> 
			<input type="hidden" name="categriaId" value="${categoria.id}">	
		</div>
	</form>
</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>