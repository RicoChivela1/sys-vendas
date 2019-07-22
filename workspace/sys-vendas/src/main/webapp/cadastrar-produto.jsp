<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Pegando os selects -->

<jsp:useBean id="categoriaDao"
	class="br.com.aluizio.sysvendas.dao.CategoriaDao" />
<jsp:useBean id="fornecedorDao"
	class="br.com.aluizio.sysvendas.dao.FornecedorDao" />


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Adiciona Produto</title>
<link rel="stylesheet" href="css/style.css">

<script src="jquery/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="bootstrap-4.1.3-dist/css/bootstrap.css"  >
<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/script.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>

	<div id="container">

	<form action="adicionar-produto.jsp" method="post" class="md-form" enctype="multipart/form-data">

	<fieldset class="campo">
		<legend>Dados do Produto</legend>

		<div class="esquerda">
			<div id="">
				<div>
					<input type="file" class=" btn btn-primary" name="imagem" id="imagem" onchange="previewImagem()" />
				</div>
				<img id=imgPreview />
			</div>
			 
		<div class="esquerda">
			<div class="caixa">
				<label for="fornecedorId">Fornecedor:</label> 
				<select name="fornecedorId" id="selectDeProdutos" class="form-control">
					<option value="0">SELECIONE</option>
					<c:forEach var="lista" items="${fornecedorDao.list}">
						<option value="${lista.id}">${lista.nome}</option>
					</c:forEach>
				</select> 
				
				<span class="input-group-btn">
						<a id="linkSelect" href="cadastrar-fornecedor.jsp">&#10010; Novo Fornecedor</a>
				</span>
			</div>
		</div>

		<div class="direita">
			<div class="caixa">
				<label for="categoriaId">Categoria:</label> <select
					name="categoriaId" id="selectDeProdutos"
					class="form-control">
					<option value="0">SELECIONE</option>
					<c:forEach var="lista" items="${categoriaDao.list}">
						<option value="${lista.id}">${lista.nome}</option>
					</c:forEach>
				</select> 
				<span class="input-group-btn">
					<a id="linkSelect" href="cadastrar-categoria.jsp">&#10010; Nova Categoria</a>
				</span>
			</div>
		</div>
		</div>

		<div class="direita">
			<div class="caixa">
				<label for="nome">Nome:</label> 
				<input id="fieldComum" type="text" name="nome" size="40" class="form-control" required="required"> 
				<label for="descricao">Descrição:</label> 
				<input id="fieldComum" type="text" name="descricao" size="40" class="form-control"> 
				<label for="indicacao">Indicação:</label> 
				<input id="fieldComum" type="text" name="indicacao" size="40" class="form-control">

				<label for="volume">Volume:</label> 
				<input id="fieldComum" type="text" name="volume" size="30" class="form-control">
				
				<div class="esqValor">

					<label id="labelsProdutosValor" for="qtdEntrada">Quantidade:</label> 
					<input id="fieldsValorSmall" type="text" name="qtdEntrada" size="10" class="form-control" required="required">
					<label id="labelsProdutosValor" for="custoUnid"> Custo Unitário: </label> 
					<input id="custoUnid" type="text" name="custoUnid" size="30" class="form-control" onKeyPress="return(MascaraMoeda(this,'.',',',event))" required="required">
				</div>

				<div class="esqValor">
					<label id="labelsProdutosValor" for="qtdMinima"> Limite Mínimo: </label> 
					<input id="fieldsValorSmall" type="text" name="qtdMinima" size="10" class="form-control" required="required">
						
					<label id="labelsProdutosValor" for="percentual"> Percentual Venda: </label> 
					<label unit="%">
						<input type="number" name="percentual" id="percentual" 
						
						step='0.01' value='0.00'
						min="0.01" max="70.00" placeholder='0.00' size="30"
						class="form-control" required="required" onmouseup="calcular()" />			
					</label>
				</div>

				<div class="esqValor">
					<label id="labelsProdutosValor" for="qtdDisponivel"> Quantidade Disponível:</label> 
						<input id="fieldsValorSmall" type="text" name="qtdDisponivel" value="0"
						size="10" class="form-control" readonly="readonly" />
				</div>

				<div class="esqValor">
				    <label id="labelsProdutosValor" for="lucro">Lucro:</label> 
					<input type="text" name="lucro" value=""
					id="lucro" class="form-control" onKeyPress="return(MascaraMoeda(this,'.',',',event))" readonly="readonly" />

					<label id="labelsProdutosValor" for="sugestaoVenda">Valor de Venda:</label>
					<input type="text" name="sugestaoVenda" readonly="readonly" value=""
					id="sugestaoVenda" class="form-control" onKeyPress="return(MascaraMoeda(this,'.',',',event))"/>		
				</div>
			</div>
		</div>
	</fieldset>
	<div id="btnForm">
		<input type="submit" class="btn btn-primary" name="Enviar" value="Enviar">
		<input type="reset" class="btn btn-default" name="Limpar" value="Limpar">
	</div>
</form>

</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>