
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
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.min.css"  >


</head>
<body>



<div class="page-header">
	<c:import url="cabecalho.jsp"/>	
</div>

<div id="container"> 
<div class="caixaIndex">
	<div class="menutemp">
	    <div>	
	    	<a href="cadastrar-usuario.jsp">Cadastrar Usuário</a><br />		
			<a href="cadastrar-cliente.jsp">Cadastrar Cliente</a><br /> 	
			<a href="cadastrar-fornecedor.jsp">Cadastrar Fornecedor</a><br /> 
		 	<a href="cadastrar-categoria.jsp">Cadastrar Categoria</a><br />
		 	<a href="cadastrar-produto.jsp">Cadastrar Produto</a><br />
		 
		 </div>
	    <div>
	    <form action="busca-cliente.jsp" method="post">
	    	<a href="busca-cliente.jsp?filtro=" > Pesquisar Clientes</a><br />
	    </form>
	    
	    <form action="busca-produto.jsp" method="post">
	    	<a href="busca-produto.jsp?filtro="> Pesquisar Produtos</a><br />
	    </form>	
	    
	    <form action="busca-usuario.jsp" method="post">
	    	<a href="busca-usuario.jsp?filtro="> Pesquisar Usuários</a><br />
	    </form>	
	    
	    <form action="busca-categoria.jsp" method="post">
	    	<a href="busca-categoria.jsp?filtro="> Pesquisar Categorias</a><br />
	    </form>
	    
	    <form action="busca-fornecedor.jsp" method="post">
	    	<a href="busca-fornecedor.jsp?filtro="> Pesquisar Fornecedor</a><br />
	    </form>
	    
		 </div>
	    <div>
	    	<a href="orcamento.jsp">Orçamento</a><br />			
			<a href="index.jsp">x Verificar Atividades</a><br /> 
		 	<a href="index.jsp">x Relatórios</a><br />
		 	<a href="index.jsp">x Estimativas</a><br />
		 </div>
	    </div>
    
	</div>
</div>	
<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>
       
        
</body>
</html>