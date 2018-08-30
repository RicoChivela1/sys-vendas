
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SysVendas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  >

</head>
<body>
<div class="page-header">
			<h1>Bem vindo</h1>
			<form action="logout" method="post">
			
			<div class="caixa">
						<input name="usuario" value="nome" size="20" class="form-control" style="border-style: none;">
						<input type="submit" name="logout" value="Log-out" class="btn btn-primary" > 	
					</div>
					
			</form>
		</div>
		
 <div class="principal"><br />
		
	
	<a href="http://localhost:8180/sys-vendas/cadastrar-usuario.jsp">Cadastrar Usuário</a><br />
	<a href="http://localhost:8180/sys-vendas/cadastrar-cliente.jsp">Cadastrar Cliente</a><br /> 	
	<a href="http://localhost:8180/sys-vendas/cadastrar-fornecedor.jsp">Cadastrar Fornecedor</a><br /> 
 	<a href="http://localhost:8180/sys-vendas/cadastrar-categoria.jsp">Cadastrar Categoria</a><br />
 	<a href="http://localhost:8180/sys-vendas/cadastrar-produto.jsp">Cadastrar Produto</a><br />
 	<a href="http://localhost:8180/sys-vendas/buscaClientePorNome">Busca cliente por nome</a>
	
	
</div>	
</body>
</html>