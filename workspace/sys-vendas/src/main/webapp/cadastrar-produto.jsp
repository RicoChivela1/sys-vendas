<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="categoriaDao" class="br.com.aluizio.sysvendas.dao.CategoriaDao"/>
<jsp:useBean id="fornecedorDao" class="br.com.aluizio.sysvendas.dao.FornecedorDao"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Produto</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  >

</head>
<body>
	<div class="principal">
		<div class="page-header">
			<h1>Cadastro de Produtos</h1>
		</div>

<form action="novoProduto" method="post">

<fieldset class="campo">
			<legend>Dados do Produto</legend>
    
			<div class="esquerda">
					<div class="esquerda">
						<div class="caixa">
							<label for="fornecedor">Fornecedor:</label> 
							
							<select name="fornecedor" style="width: 170px; height: 38px" class="form-control" >
								<option value="0">SELECIONE</option>
								<c:forEach var="lista" items="${fornecedores}">
									<option value="${lista.id}">${lista.nome}</option>
								</c:forEach>
							</select>
      						
      						<span class="input-group-btn" >
        						<button class="btn btn-default" type="button"><a href="http://localhost:8180/sys-vendas/cadastrar-fornecedor.jsp">&#10010;</a></button>
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
							
							<span class="input-group-btn" >
        						<button class="btn btn-default" type="button"><a href="http://localhost:8180/sys-vendas/cadastrar-categoria.jsp">&#10010;</a></button>
      						</span>
      						
      						
						</div>
					</div>


					<div class="caixa">
						<label for="nome">Nome:</label> 
						<input required="required" name="nome"size="40" class="form-control" >

						<label for="descricao">Descrição:</label> 
						<input type="text" name="descricao" size="40" class="form-control" >
					</div>
			</div>


				<div class="direita">
					<div class="caixa">
						<label for="indicacao" style="margin-top: 4px;">Indicação:</label>
						<input type="text" name="indicacao" size="40" class="form-control"> 
						
						<label for="volume" style="margin-top: 4px;">Volume:</label> 
						<input type="text" name="volume" size="30" class="form-control" >

						<div class="esquerda">
							<label for="qtdEstoque" style="margin-top: 5px;">Quantidade
								em estoque:</label> <input type="text" name="qtdEstoque" size="30"
								class="form-control" style="width: 160px;" required="required">
						</div>

						<div class="direita">
							<label for="qtdMinima" style="margin-top: 5px;">Quantidade
								Mínima:</label> <input type="text" name="qtdMinima" size="30"
								class="form-control" style="width: 160px;" required="required"> <br />
						</div>




						<div class="esquerda">
							<label for="custoUnid" style="margin-top: 5px; color: maroon;">Custo
								Unitário:</label> <input  type="text" name="custoUnid" size="30"
								class="form-control" style="width: 120px; border-color: maroon;" required="required">
						</div>
						<div class="direita">
							<label for="sugestaoVenda"
								style="margin-top: 5px; color: maroon;">Sugestão de
								Venda:</label> <input  type="text" name="sugestaoVenda" size="30"
								class="form-control" style="width: 120px; border-color: maroon;"required="required">

						</div>

					</div>
				</div>
	
		<div class="caixa">
			<input type="submit" class="btn btn-primary" name="Enviar"> 
			<input type="reset" class="btn btn-default" name="Limpar">		
		</div>
		
		
		
</fieldset>
		

</form>

	</div>
</body>
</html>