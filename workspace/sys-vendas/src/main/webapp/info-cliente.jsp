<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css"  >
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/script.js"></script>
<title>Info Cliente</title>
</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>	
	</div>

	<div id="container">
  	<form action="agregar-cliente.jsp" method="post">	
  	<div>			 	
	
			
		</div>
	<fieldset class="campo">
	
	<legend>${cliente.nome} ${cliente.sobreNome} 
	<button type="submit" name="id" value="${cliente.id}" class="btn btn-success"> <i class="fa fa-cart-plus" aria-hidden="true"></i> Add </button></legend>
		
		
		<div class="esquerda">
			<label>Celular:</label> ${cliente.celular}<br />
			<label>Edere�o:</label> ${cliente.endereco} n�: ${cliente.numero}<br />
			<label>Bairro:</label> ${cliente.bairro}<br />
			<label>Cidade:</label> ${cliente.cidade}
			<label>-</label> ${cliente.uf}<br />
			<label>Complemento:</label> ${cliente.complemento}<br />
		</div>
		
	</fieldset>
	<fieldset class="campo">
	<legend>Detalhes:</legend>
	
		<div class="esquerda">
			<br />
			<label>Sexo:</label> ${cliente.sexo}<br />
			<label>Pessoa:</label> ${cliente.pessoa}<br />
			<label>SItua��o:</label> ${cliente.situacao}<br />
		
			<label>Nascimento:</label> 
			<fmt:parseDate value="${cliente.nascimento}" pattern="yyyy-MM-dd" var="data" type="both" />
			<fmt:formatDate pattern="dd-MM-yyyy" value="${data}" /> <br />
			
			<label>E-mail:</label> ${cliente.email}<br />
			<label>Fone Residencial:</label> ${cliente.fone}<br />
			<label>CEP:</label> ${cliente.cep}<br />
			<label>Observa��o:</label> ${cliente.observacao}<br />
		</div>
		
		<div class="direita">
	
		</div>
	</fieldset>
	
	<fieldset class="campo">
	<legend>Movimenta��es:</legend>
	
		<div class="esquerda">
			<br />
			<label>Total de Compras Realizadas:</label> ${list.size()}<br />
			----------------------------------------------<br />
			<c:forEach var="list" items="${list}">
			
			    <tr>
			      
			      <td>
			      <label>Data da Compra:</label> 
					<fmt:parseDate value="${list.dataLancamento}" pattern="yyyy-MM-dd" var="dataLancamento" type="both" />
					<fmt:formatDate pattern="dd-MM-yyyy" value="${dataLancamento}" /> <br />
			      </td>
			      
			      
			      <td>
			      	<label>Valor da Compra:</label> 
			      	${list.total}
			      </td><br />
			      <td>
			      	
			      	<c:choose>
					<c:when test="${list.parcelasAPagar > 0}">
						<label>N�o quitado: </label>
			
					</c:when>
					<c:when test="${list.parcelasAPagar == 0}">
						<label>Quitado</label>
					</c:when>
					</c:choose>
			      </td>
			      
			      <td> 
			    	<div class="btnAcoes">
			      		<button type="submit" name="info" value="${produto.id}"  class="btn btn-outline-info" title="Veja maiores informa��es sobre um produto e realize uma venda."> <i class="fa fa-info-circle" ></i> Info</button>
			      		
					</div>
			      </td>
			      
			    </tr>
			    ----------------------------------------------<br />
		   </c:forEach>
		</div>
		
		<div class="direita">
	
		</div>
	</fieldset>
	
	
	
	
	
	
	
	</form>
</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>