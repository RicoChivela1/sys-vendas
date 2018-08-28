<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="dao" class="br.com.aluizio.sysvendas.dao.CategoriaDao"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Produto</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<div class="principal">
	<div class="page-header">
  		<h1>Cadastro de Produtos </h1>
	</div>
	
	<form action="novoProduto" >
	
	<fieldset class="campo">
	<legend>Dados do Produto</legend>

		<div class="esquerda">
			<div class="esquerda">
			 <div class="caixa">
				<label for="categoria2">Categoria:</label>
				<input type="text" name="categoria" style="width:200px; " size="36" class="form-control" aria-describedby="sizing-addon3">
			</div>
		   </div>	
		   
		<div class="direita">
		   <div class="caixa">
		   		<label for="categoria">Categorias Existentes:</label>
				<select name="categoria" style="width:200px; height:38px">
					<option value="0">SELECIONE</option>
						<c:forEach var="lista" items="${dao.list}">
							<option value="${lista.nome}"> ${lista.nome}</option>
						</c:forEach>
			   </select>
			   </div>
		   </div>
				
		
			<div class="caixa">
				
				<label for="nome">Nome:</label>
				<input type="text" name="nome" size="40" class="form-control" aria-describedby="sizing-addon3">  
				
				<label for="descricao">Descrição:</label>
				<input type="text" name="descricao" size="40" class="form-control" aria-describedby="sizing-addon3">
			
		
			</div>
		</div>
		
		<div class="direita">
			<div class="caixa">
				<label for="indicacao" style="margin-top: 4px; ">Indicação:</label>
				<input type="text" name="indicacao" size="40" class="form-control" aria-describedby="sizing-addon3">
				
				<label for="volume" style="margin-top: 4px; ">Volume:</label>
				<input type="text" name="volume" size="30" class="form-control" aria-describedby="sizing-addon3">
			
			<div class="esquerda">
				<label for="qtdEstoque" style="margin-top: 5px; ">Quantidade em estoque:</label>
				<input type="text" name="qtdEstoque" size="30" class="form-control" aria-describedby="sizing-addon3" style="width:160px; ">
			</div>
			
			<div class="direita">
				<label for="qtdMinima" style="margin-top: 5px; ">Quantidade Mínima:</label>
				<input type="text" name="qtdMinima" size="30" class="form-control" aria-describedby="sizing-addon3" style="width:160px; ">
			<br />
			</div>
			
			
			
		
			<div class="esquerda">
				<label for="custoUnid" style="margin-top: 5px;  color: maroon;">Custo Unitário:</label>
				<input type="text" name="custoUnid" size="30" class="form-control" aria-describedby="sizing-addon3" style="width:120px; border-color: maroon;">
			</div>
			<div class="direita">
				<label for="sugestaoVenda" style="margin-top: 5px;  color: maroon;">Sugestão de Venda:</label>
				<input type="text" name="sugestaoVenda" size="30" class="form-control" aria-describedby="sizing-addon3" style="width:120px; border-color: maroon;">
			
			</div>	
				
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