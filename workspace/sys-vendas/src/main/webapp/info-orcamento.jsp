<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="js/script.js"></script>

<link href="bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
		<script src="jquery/js/jquery-1.8.3.js"></script>
		<link href="bootstrap4-toggle-3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">	
		<script src="bootstrap4-toggle-3.4.0/js/bootstrap4-toggle.min.js"></script>
		<script src="js/trava.js"></script>

<title>Info Or�amento</title>

</head>
<body>

	<div class="page-header">
		<c:import url="cabecalho.jsp"/>
	</div>
	
<div id="container">
  	
	
	<fieldset class="campo">
	<legend>Info Or�amento</legend>
		<div class="table-responsive">
		<table class="table table-hover">
			  <thead>
			    <tr>
			    	<th > N�</th>
			    	<th > Data Lancamento</th>
			    	<th > Vendedor </th> 
			      	<th > Subtotal</th>
			      	<th > Descontos </th>
			      	<th > Total </th>
			      	<th > Parcelas Pagas </th> 
			    </tr>
			  </thead>
		  <tbody>
		
		  <tr>
		  	<td>
				${orcamento.id}
			</td>
		  	<td>
				${orcamento.dataLancamento}
			</td>
			<td>
			    ${orcamento.usuario.nome}
			</td>
		    <td>
				${orcamento.subTotalOrcamento}
			</td>
			<td>
				${orcamento.descontos}
			</td>
			<td>
				${orcamento.totalOrcamento}
			</td>
			 <td>
				${orcamento.parcelasPagas}
			 				de
				${orcamento.totalParcelas}
			<input type="hidden" name="hiddenTotalParcelas" value="${orcamento.totalParcelas}">
			
			</td>	
	      <td> 
	      
	      
	      
	      </td>
	    </tr>
		  </tbody>
		</table>
	</div>
	</fieldset>
	
	<form action="gerenciaCliente?filtro=" method="post">
	<fieldset class="campo">
	<legend>Cliente</legend>
	
	<div class="table-responsive">
		<table class="table table-hover">
			  <thead>
			  <caption></caption>
			    <tr>
			      <th> Cliente </th>
			      <th> Cel </th>
			      <th> Observa��o </th>
			      <th> A��es </th>
			    </tr>
			  </thead>
		  <tbody>
		
		  <tr>
			<td>
				${orcamento.cliente.nome} ${orcamento.cliente.sobreNome}
			</td>
			<td>
				${orcamento.cliente.celular}
			</td>
			<td>
				${orcamento.cliente.observacao}
			</td>
	      <td> 
		  <div class="btnAcoes">			      		
		    <button type="submit" name="info" value="${orcamento.cliente.id}"  class="btn btn-outline-info" title="Mais informa��es."> <i class="fa fa-info-circle"></i> Info</button>
		    
		  </div>
	      </td>
	    </tr>
		  </tbody>
		</table>
	</div>
	</fieldset>
</form>
	
	<fieldset class="campo">
	<legend>Produtos Comprados:</legend>
	<div class="table-responsive">
		<table class="table table-hover">
			  <thead>
			    <tr>
			      <th > Imagem </th>
			      <th > Id </th>
			      <th > Produto </th>
			      <th > Valor Unit�rio </th>
			      <th > Quantidade </th>
			      <th > Total </th>
			    </tr>
			  </thead>
		  <tbody>
		
		  <c:forEach var="produto" items="${orcamento.list}"> 
		  <tr>
	
		     <td>
		      	<img class="miniaturaProdutoPeq" src="./carregadorImagem?id=${produto.produtoId}" />
		     </td>
		     <td>
				${produto.produtoId}
			 </td>
			<td>
				${produto.produtoNome}
			</td>
			<td>
				${produto.valorUnid}
			</td>
			<td>
				${produto.qtd}
			</td>
			<td>
				${produto.subTotal}
			</td>
			
	    </tr>
		   </c:forEach>
		  </tbody>
		</table>
	</div>		
	</fieldset>
	
	
	
	
	
	
	<fieldset class="campo">
	<legend>Pagamentos</legend>
	<div class="direitaLink">	
	    
		<input id="chkToggle" name="trava" type="checkbox" data-style="ios"> 
		<div id="saida"></div>   		
		
		
		
		
		
		
		
		
	</div>
	<div class="table-responsive">
		<table class="table table-hover">
			  <thead>
			    <tr>
			      <th > N�. Parcela </th>
			      <th > Valor da Parcela</th>
			      <th > Vencimento </th>
			      <th > Situa��o </th>
			 
			    </tr>
			  </thead>
		  <tbody>
		
		  <c:forEach var="pagamento" items="${orcamento.pagamentos}"> 
		  <tr>
			<td>
				${pagamento.numParcela}
			</td>
			<td>
				${pagamento.valorParcela}
			</td>
			<td>
				${pagamento.parcelaData}
			</td>
			<td id="tdStatus">
			<c:set var="quitado" value="QUITADO" />
			<c:set var="apagar" value="A_PAGAR" />
			<c:set var="status" value="${pagamento.status}" />
				<c:choose>
					<c:when test="${pagamento.status == quitado}">
						<input class="camposQuitados" name="inputStatus[${pagamento.numParcela}]" type="text" value="${pagamento.status}">
					</c:when>
					
					<c:when test="${pagamento.status == apagar}">
						<input class="camposAPagar" name="inputStatus[${pagamento.numParcela}]" type="text" value="${pagamento.status}">
					</c:when>
				</c:choose>
				
			</td> 
	      <td> 
	
	      </td>
	    </tr>
		   </c:forEach>
		  </tbody>
		</table>
	</div>		
	</fieldset>

</div>

<footer class="site-footer push">
    <c:import url="rodape.jsp"/>
</footer>

</body>
</html>