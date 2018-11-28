
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Pushy - Off-Canvas Navigation Menu</title>
        <meta name="description" content="Pushy is an off-canvas navigation menu for your website.">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/demo.css">
        <!-- Pushy CSS -->
        <link rel="stylesheet" href="css/pushy.css">
        
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    	<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
    	
    </head>
    <body>

        <header class="site-header push">
        
	        <div style="float: left; width: 30%;">
	        	<button title="Menu" class="menu-btn"> &#9776;</button>
	        </div>
	        
	        <div style="float: left; width: 40%; padding-top: 10px; text-align: center;">
	        	 
	        	 <c:choose>
					<c:when test="${total == 0}">
						<a href="orcamento.jsp" title="Orçamento"><i class="fa fa-cart-plus" style="font-size:24px;color: black;"></i></a>
					</c:when>
					<c:when test="${empty total}">
						<a href="orcamento.jsp" title="Orçamento"><i class="fa fa-cart-plus" style="font-size:24px; color: black;"></i></a>
					</c:when>
					<c:when test="${total > 0}">
						<a href="orcamento.jsp" title="Orçamento"><i class="fa fa-cart-plus" style="font-size:24px; color: red;"></i></a>
						R$ ${total}
					</c:when>
				 </c:choose>
	        	 
	        </div>
	        
	        <div style="float: left; width: 30%; text-align: right; padding-right: 3%;">
	        	<form action="logout" method="post">				
					Olá, ${usuarioLogado.nome} &nbsp;
					<a href="logout" title="Sair"> <i class="fa fa-sign-out" style="font-size:24px; color: black;"></i></a>
						
				</form>
	        </div>
        </header>

        <!-- Pushy Menu -->
        <nav class="pushy pushy-left" data-focus="#first-link">
            <div class="pushy-content">
                <ul>
                    <li class="pushy-submenu">
                        <button id="first-link">Cadastrar</button>
                        <ul>
                            <li class="pushy-link"><a href="cadastrar-categoria.jsp">Categoria</a></li>
                            <li class="pushy-link"><a href="cadastrar-cliente.jsp">Cliente</a></li>
                            <li class="pushy-link"><a href="cadastrar-fornecedor.jsp">Fornecedor</a></li>
                            <li class="pushy-link"><a href="cadastrar-produto.jsp">Produto</a></li>
                            <li class="pushy-link"><a href="cadastrar-usuario.jsp">Usuário</a></li>
                        </ul>
                    </li>
                    <li class="pushy-submenu">
                        <button>Pesquisar</button>
                        <ul>
                            <li class="pushy-link"><a href="buscaCategoria?filtro=">Categoria</a></li>
                            <li class="pushy-link"><a href="buscaClientes?filtro=">Cliente</a></li>
                            <li class="pushy-link"><a href="buscaFornecedor?filtro=">Fornecedor</a></li>
                            <li class="pushy-link"><a href="buscaProdutos?filtro=">Produto</a></li>
                            <li class="pushy-link"><a href="buscaUsuario?filtro=">Usuário</a></li>
                        </ul>
                    </li>
                
                    <li class="pushy-submenu">
                        <button>Outros</button>
                        <ul>
                            <li class="pushy-link"><a href="#">Outro 1</a></li>
                            <li class="pushy-link"><a href="#">Outro 2</a></li>
                            <li class="pushy-link"><a href="#">Outro 3</a></li>
                        </ul>
                    </li>
                    <li class="pushy-link"><a href="orcamento.jsp">Orçamento</a></li>
                    <li class="pushy-link"><a href="https://www.marykay.com.br">MK&#174; Brasil</a></li>
                    <li class="pushy-link"><a href="index.jsp">x Início</a></li>
                </ul>
            </div>
        </nav>





        <!-- Site Overlay -->
        <div class="site-overlay"> </div>
      
		<!-- Site Overlay -->
        <footer class="site-footer push"></footer>

        <!-- Pushy JS -->
        <script src="js/pushy.min.js"></script>

    </body>
</html>
