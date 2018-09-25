<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="categoriaDao" class="br.com.aluizio.sysvendas.dao.CategoriaDao"/>
<jsp:useBean id="fornecedorDao" class="br.com.aluizio.sysvendas.dao.FornecedorDao"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Alterar Produto</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css"  >

<script type="text/javascript" src="js/script.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	

</head>
<body>
	<div class="principal">
		<div class="page-header">
			<h1>Alterar Produto</h1>
		</div>

<form action="alteraProduto" method="post"   class="md-form" enctype="multipart/form-data">

    
<fieldset class="campo">
	<legend>Dados do Produto</legend>
    
	<div class="esquerda">
	<div id=""> 
	<div >	      
  		<input type="file" class=" btn btn-primary"  name="imagem" id="imagem" onchange="previewImagem()" /><br /><br />
    </div></div>
        <img style="width: 150px; height: 150px;" src="carregadorImagem?id=${produto.id} "/><br />
   		
	<br /><br />
			<div class="esquerda">
			</div>
					<div class="esquerda">
						<div class="caixa">
							<label for="fornecedor">Fornecedor:</label> 
							
							<select name="fornecedor" style="width: 170px; height: 38px" class="form-control" >
								<option value="0">SELECIONE</option>
								<c:forEach var="lista" items="${fornecedorDao.list}">
									<option value="${lista.id}">${lista.nome}</option>
								</c:forEach>
							</select>
      						
      						<span class="input-group-btn" >
        						<button class="btn btn-default" type="button"><a href="http://localhost:8080/sys-vendas/cadastrar-fornecedor.jsp">&#10010;</a></button>
      						</span>
						</div>
					</div>
	
					<div class="direita">
						<div class="caixa">
							<label for="categoria">Categoria:</label> 
							<select name="categoria" style="width: 170px; height: 38px" class="form-control" >
								<option value="0">SELECIONE</option>
								<c:forEach var="lista" items="${categoriaDao.list}">
									<option value="${lista.nome}">${lista.nome}</option>
								</c:forEach>
							</select>
							<input type="hidden" name="categoriaId" value="${produto.categoria.id}">
							<span class="input-group-btn" >
        						<button class="btn btn-default" type="button"><a href="http://localhost:8080/sys-vendas/cadastrar-categoria.jsp">&#10010;</a></button>
      						</span>						
						</div>
					</div>		
			</div>

				<div class="direita">
				<div class="caixa">
						<label for="nome">Nome:</label> 
						<input type="text" name="nome" value="${produto.nome}" size="40" class="form-control" required="required" >

						<label for="descricao">Descrição:</label> 
						<input type="text" name="descricao" value="${produto.descricao}" size="40" class="form-control" >
					
						<label for="indicacao" style="margin-top: 4px;">Indicação:</label>
						<input type="text" name="indicacao" value="${produto.indicacao}" size="40" class="form-control"> 
						
						<label for="volume" style="margin-top: 4px;">Volume:</label> 
						<input type="text" name="volume" value="${produto.volume}" size="30" class="form-control" >


						<div class="esquerda">
						
							<label for="qtdDisponivel" style="margin-top: 5px;">Quantidade
								Disponível:</label> 

								<input type="text" name="qtdDisponivel" 
								value="${produto.estoque.qtdDisponivel}" 
								size="10" disabled="disabled" class="form-control" style="width: 160px;" >
					
							<label for="qtdMinima" style="margin-top: 5px;">Limite Mínimo:</label> <input type="text" name="qtdMinima" 
								value="${produto.estoque.qtdMinima}" size="10"
								class="form-control" style="width: 160px;" required="required"> 
							
							<label for="qtdAdicional" style="margin-top: 5px; color: maroon;">Adicionar Quantidade:</label> 
								<input type="text" name="qtdAdicional"  size="10" class="form-control" required="required" 
								style="width: 120px; border-color: maroon;">
								
								<input type="hidden" name="qtdEntrada" value="${produto.estoque.qtdEntrada}">
								
						</div>

						<div class="esquerda">
							<label for="custoUnid" style="margin-top: 5px; color: maroon;">Custo
								Unitário:</label> <input  type="text" name="custoUnid" 
								value="${produto.custoUnid}" size="30"
								class="form-control" style="width: 120px; border-color: maroon;" required="required">
						</div>
						<div class="direita">
							<label for="sugestaoVenda"
								style="margin-top: 5px; color: maroon;">Valor de
								Venda:</label> <input  type="text" name="sugestaoVenda" size="30"
								class="form-control" value="${produto.sugestaoVenda}" style="width: 120px; border-color: maroon;"required="required">
								
								<label for="percentual"
								style="margin-top: 5px; color: maroon;">Percentual
								Venda:</label> <input  type="text" name="percentual" size="30"
								class="form-control" style="width: 120px; border-color: maroon;"required="required">

						</div>

					</div>
				</div>
	
		<div class="caixa">
			<input type="submit" class="btn btn-primary" name="Enviar"> 
			<input type="hidden" name="produtoId" value="${produto.id}">
			<input type="hidden" name="estoqueId" value="${produto.estoque.id}">
					
		</div>
				
</fieldset>		

</form>

	</div>
</body>
</html>