<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="categoriaDao"
	class="br.com.aluizio.sysvendas.dao.CategoriaDao" />
<jsp:useBean id="fornecedorDao"
	class="br.com.aluizio.sysvendas.dao.FornecedorDao" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Adiciona Produto</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">

<script type="text/javascript" src="js/script.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</head>
<body>
	<div class="principal">
		<div class="page-header">
			<h1>Cadastrar Produto</h1>
		</div>

		<form action="adicionaProduto" method="post" class="md-form"
			enctype="multipart/form-data">


			<fieldset class="campo">
				<legend>Dados do Produto</legend>

				<div class="esquerda">
					<div id="">
						<div>
							<input type="file" class=" btn btn-primary" name="imagem"
								id="imagem" onchange="previewImagem()" /><br />
							<br />
						</div>
					</div>
					<img style="width: 150px; height: 150px;" /><br /> <br />
					<br />
					<div class="esquerda"></div>
					<div class="esquerda">
						<div class="caixa">
							<label for="fornecedorId">Fornecedor:</label> <select
								name="fornecedorId" style="width: 170px; height: 38px"
								class="form-control">
								<option value="0">SELECIONE</option>
								<c:forEach var="lista" items="${fornecedorDao.list}">
									<option value="${lista.id}">${lista.nome}</option>
								</c:forEach>
							</select> <span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<a href="/sys-vendas/cadastrar-fornecedor.jsp">&#10010;</a>
								</button>
							</span>
						</div>
					</div>

					<div class="direita">
						<div class="caixa">
							<label for="categoriaId">Categoria:</label> <select
								name="categoriaId" style="width: 170px; height: 38px"
								class="form-control">
								<option value="0">SELECIONE</option>
								<c:forEach var="lista" items="${categoriaDao.list}">
									<option value="${lista.id}">${lista.nome}</option>
								</c:forEach>
							</select> <span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<a href="/sys-vendas/cadastrar-categoria.jsp">&#10010;</a>
								</button>
							</span>

						</div>
					</div>
				</div>

				<div class="direita">
					<div class="caixa">
						<label for="nome">Nome:</label> <input type="text" name="nome"
							size="40" class="form-control" required="required"> <label
							for="descricao">Descrição:</label> <input type="text"
							name="descricao" size="40" class="form-control"> <label
							for="indicacao" style="margin-top: 4px;">Indicação:</label> <input
							type="text" name="indicacao" size="40" class="form-control">

						<label for="volume" style="margin-top: 4px;">Volume:</label> <input
							type="text" name="volume" size="30" class="form-control">
						<br />

						<div class="esqValor">

							<label for="qtdEntrada" style="margin-top: 5px; color: maroon;">Adicionar
								Quantidade:</label> <input type="text" name="qtdEntrada" value=""
								size="10" class="form-control" required="required"
								style="width: 120px; border-color: maroon;"><br /> <label
								for="custoUnid" style="margin-top: 5px; color: maroon;">
								
								Custo Unitário: </label> <input value="" type="text" name="custoUnid"
								id="custoUnid" size="30" class="form-control" onKeyPress="return(MascaraMoeda(this,'.',',',event))"
								style="width: 120px; border-color: maroon;" required="required">
						</div>

						<div class="esqValor">
							<label for="qtdMinima" style="margin-top: 5px;">
								
								Limite Mínimo:
								</label> <input type="text" name="qtdMinima" size="10"
								class="form-control" style="width: 120px;" required="required">
							<br /> <label for="percentual"
								style="margin-top: 5px; color: maroon;"> 
								
								Percentual Venda: 
								</label> <label unit="%"> <input type="number"
								name="percentual" id="percentual" step='0.01' value='0.01'
								min="0.01" max="70.00" placeholder='0.00' size="30"
								class="form-control" style="width: 120px; border-color: maroon;"
								required="required" onchange="calcular()" />
							
						</div>


						<div class="esqValor">

							<label for="qtdDisponivel" style="margin-top: 5px;">
							    
							    Quantidade Disponível:
								</label> <input type="text" name="qtdDisponivel" value="0"
								size="10" class="form-control"
								style="width: 140px;" readonly="readonly" />

						</div>


						<div class="esqValor">
							<br /> <label for="lucro" style="color: maroon;">
								Lucro: 
								</label> <input type="text" name="lucro" value=""
								id="lucro" class="form-control" onKeyPress="return(MascaraMoeda(this,'.',',',event))"
								style="width: 140px;" readonly="readonly" />

								</label> <label for="sugestaoVenda" style="color: maroon;"> <br />
								Valor de Venda:
								</label><br /> <input type="text" name="sugestaoVenda" readonly="readonly" value=""
								id="sugestaoVenda" class="form-control" onKeyPress="return(MascaraMoeda(this,'.',',',event))"
								/>
						</div>

					</div>
				</div>

				<div class="caixa">
					<input type="submit" class="btn btn-primary" name="Enviar">
					<input type="reset" class="btn btn-primary" name="Limpar">
				</div>

			</fieldset>

		</form>

	</div>
</body>
</html>