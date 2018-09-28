<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Categoria</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  >

</head>
<body>
<div class="principal">
		<div class="page-header">
			<h1>Alterar de Categoria</h1>
		</div>

	<form action="adicionaAlteraCategoria" method="post">

	<fieldset class="campo">
		<legend>Dados da Categoria</legend>
    
		<div class="esquerda">
				<div class="esquerda">
					<div class="caixa">
						<label for="nome">Nome:</label> 
						<input required="required" name="nome"size="40" value="${categoria.nome}" class="form-control" >
					</div>
					
					<div class="caixa">
						<input type="submit" class="btn btn-primary" name="Enviar"> 
						<input type="hidden" name="categriaId" value="${categoria.id}">	
					</div>
		
				</div>
			</div>

	</fieldset>
		
	</form>
</div>
</body>
</html>