
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SysVendas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleIndex.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  >

</head>
<body>
<div class="page-header">
			<h1>Bem vindo</h1>
			
			<form action="logout" method="post">
			<div class="caixa" style="margin-left: 80%;">		
				Ol�, ${usuarioLogado.nome} <input type="submit" name="logout" value="Log-out" class="btn btn-primary" > 	
			</div>	
			</form>
		</div>
		
		

 <div class="caixa"><br />

	<div class="menutemp">
	    <div>	
	    	<a href="cadastrar-usuario.jsp">Cadastrar Usu�rio</a><br />		
			<a href="cadastrar-cliente.jsp">Cadastrar Cliente</a><br /> 	
			<a href="cadastrar-fornecedor.jsp">Cadastrar Fornecedor</a><br /> 
		 	<a href="cadastrar-categoria.jsp">Cadastrar Categoria</a><br />
		 	<a href="cadastrar-produto.jsp">Cadastrar Produto</a><br />
		 
		 </div>
	    <div>
	    <form action="buscaClientes" method="post">
	    	<a href="buscaClientes?filtro=" > Pesquisar Clientes</a><br />
	    </form>
	    
	    <form action="buscaProdutos" method="post">
	    	<a href="buscaProdutos?filtro="> Pesquisar Produto</a><br />
	    </form>	
	    
	    <form action="buscaUsuarios" method="post">
	    	<a href="buscaUsuario?filtro="> Pesquisar Usu�rios</a><br />
	    </form>	
	     	
			<a href="index.jsp">x Pesquisar Fornecedor</a><br /> 
		 	<a href="index.jsp">x Pesquisar Categoria</a><br />
		 	
		 </div>
	    <div>
	    	<a href="index.jsp">x Lista de Or�amento</a><br />		
			<a href="index.jsp">x Realizar Vendas</a><br /> 	
			<a href="index.jsp">x Verificar Atividades</a><br /> 
		 	<a href="index.jsp">x Relat�rios</a><br />
		 	<a href="index.jsp">x Estimativas</a><br />
		 </div>
	    </div>
	    
	</div>	
</body>
</html>