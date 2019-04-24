
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

<div class="caixa">


<h3><label>Vis�o Geral</label></h3>
	<ul>
		<li> - Total Investido</li>
		<li> - Lucro Bruto</li>
		<li> - Lucro L�quido</li>
		
		<li> - Lucro extimado Bruto</li>
		<li> - Lucro extimado L�quido</li>
	</ul>
<br />
<h3><label>D�vidas</label></h3>
	<ul>
		<li> - Total D�vidas</li> 
		<li> - Total em atrazo</li> 
		<li>Total � receber: R$ ${valorTotalAtraso}</li> 
		<li>Total a receber hoje: R$ ${valorAReceberHoje}</li> 
		<li>Total a receber m�s: R$ ${valorAReceberMes} </li>
		<li>Total a receber semana: R$ ${valorAReceberSemana}</li> 
	</ul>
<br />
<h3><label>Produtos</label></h3>
	<ul>
		<li> - Mais vendidos</li>
		<li> - Est�o na reserva</li>
		
		
		
		
		
		
		<form action="gerencia-produto.jsp" method="post">

	<c:choose>	
		<c:when test="${empty produtosReserva}">
			<div class="box">
			<div>
				<label class="listaNula">N�o encontramos registros.</label>	
			</div>
			<div>
				<a href="gerencia-produto.jsp?filtro=" title="Listar todos os produtos.">Ver todos </a> |
				<a href="cadastrar-produto.jsp" title="Cadastrar um novo produto."> Adicionar </a> |
				<a href="orcamento.jsp" title="P�gina de or�amento."> Or�amento </a>
			</div>
		
			</div>
				
		</c:when>
		
		<c:when test="${not empty produtosReserva}">
			<div class="table-responsive">
				<table class="table table-hover">
				<caption>Produtos na Reserva</caption>
					  <thead>
					    <tr>
					      <th > # </th>
					      <th > Imagem </th>
					      <th > Nome </th>
					      <th > Descricao/Indica��o </th>
					      <th > Custo Unid </th>
					      <th > Sugest�o Venda </th>
					      <th > Estoque </th>
					      <th > A��es</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="produto" items="${produtosReserva}">
					    <tr>
					      <td>${produto.id}</td>
					      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
							<td><span class="nome">-${produto.nome}</span><br />
								${produto.volume}
							</td>
							<td>-${produto.descricao}<br />
								-${produto.indicacao}
							</td>
							
						    <td class="valores">R$ ${produto.custoUnid}</td>
							<td class="valores">R$ ${produto.sugestaoVenda}</td>
							<td>${produto.estoque.qtdDisponivel}</td>
					
					      <td> 
					    	<div class="btnAcoes">
					      		<button type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info" title="Veja maiores informa��es sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i> Info</button>
					      		<button type="submit" name="alterar" value="${produto.id}" class="btn btn-outline-warning" title="Permite alterar os dados do produto."> <i class="fa fa-pencil-square-o" ></i> Atualizar</button>	
						  		<button type="submit" name="remover" value="${produto.id}" class="btn btn-outline-danger" title="Apaga este produto do sistema.">  <i class="fa fa-trash-o" ></i> Remover</button>
							</div>
					      </td>
					    </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
		</c:when>
	</c:choose>

</form>







		<li>Esgotados</li>
		</ul>
		<form action="gerencia-produto.jsp" method="post">

	<c:choose>	
		<c:when test="${empty produtosEsgotados}">
			<div class="box">
			<div>
				<label class="listaNula">N�o encontramos registros.</label>	
			</div>
			<div>
				<a href="gerencia-produto.jsp?filtro=" title="Listar todos os produtos.">Ver todos </a> |
				<a href="cadastrar-produto.jsp" title="Cadastrar um novo produto."> Adicionar </a> |
				<a href="orcamento.jsp" title="P�gina de or�amento."> Or�amento </a>
			</div>
		
			</div>
				
		</c:when>
		
		<c:when test="${not empty produtosEsgotados}">
			<div class="table-responsive">
				<table class="table table-hover">
				<caption>Produtos Esgotados</caption>
					  <thead>
					    <tr>
					      <th > # </th>
					      <th > Imagem </th>
					      <th > Nome </th>
					      <th > Descricao/Indica��o </th>
					      <th > Custo Unid </th>
					      <th > Sugest�o Venda </th>
					      <th > Estoque </th>
					      <th > A��es</th>
					    </tr>
					  </thead>
				  <tbody>
				
				   <c:forEach var="produto" items="${produtosEsgotados}">
					    <tr>
					      <td>${produto.id}</td>
					      <td><img class="miniaturaProduto" src="./carregadorImagem?id=${produto.id}" /></td>
							<td><span class="nome">-${produto.nome}</span><br />
								${produto.volume}
							</td>
							<td>-${produto.descricao}<br />
								-${produto.indicacao}
							</td>
							
						    <td class="valores">R$ ${produto.custoUnid}</td>
							<td class="valores">R$ ${produto.sugestaoVenda}</td>
							<td>${produto.estoque.qtdDisponivel}</td>
					
					      <td> 
					    	<div class="btnAcoes">
					      		<button type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info" title="Veja maiores informa��es sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i> Info</button>
					      		<button type="submit" name="alterar" value="${produto.id}" class="btn btn-outline-warning" title="Permite alterar os dados do produto."> <i class="fa fa-pencil-square-o" ></i> Atualizar</button>	
						  		<button type="submit" name="remover" value="${produto.id}" class="btn btn-outline-danger" title="Apaga este produto do sistema.">  <i class="fa fa-trash-o" ></i> Remover</button>
							</div>
					      </td>
					    </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
		</c:when>
	</c:choose>

</form>
<br />
</div>
<div class="caixaIndex">
	<div class="menutemp">
	    <div>	
	    	<a href="cadastrar-usuario.jsp">Cadastrar Usu�rio</a><br />		
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
	    	<a href="busca-usuario.jsp?filtro="> Pesquisar Usu�rios</a><br />
	    </form>	
	    
	    <form action="busca-categoria.jsp" method="post">
	    	<a href="busca-categoria.jsp?filtro="> Pesquisar Categorias</a><br />
	    </form>
	    
	    <form action="busca-fornecedor.jsp" method="post">
	    	<a href="busca-fornecedor.jsp?filtro="> Pesquisar Fornecedor</a><br />
	    </form>
	    
		 </div>
	    <div>
	    	<a href="orcamento.jsp">Or�amento</a><br />			
			<a href="index.jsp">x Verificar Atividades</a><br /> 
		 	<a href="index.jsp">x Relat�rios</a><br />
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