<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Turismo</title>

<!-- LINK PARA O BOOTSTRAP -->
<link rel="stylesheet" type="text/css" href="../bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script src="../bootstrap-3.3.6-dist/datepicker/js/bootstrap-datepicker.js"></script>
 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>




 <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<jsp:include page="topo.jsp"></jsp:include>


<h3 class="page-header">TURISMO LEGAL</h3>


<!-- Select a cidade para a lista -->
<div class="row">
	<div class="col-md-8">
		<form class="form-inline" action="EscolherViagemController" method="post">
			<div class="form-group">
			  <label for="sel1">Cidade</label>
			  <select class="form-control" id="sel1" name="cidade">
			    	<option value="0">Selecione uma Cidade </option>
					<option value="RIO_JANEIRO">Rio de Janeiro</option>			
					<option value="SAO_PAULO">São Paulo</option>
					<option value="FORTALEZA">Fortaleza</option>
					<option value="RECIFE">Recife</option>
					<option value="PERNAMBUCO">Pernambuco</option>
					<option value="NATAL">Natal</option>
			  </select>
			  <input type="submit" class="btn btn-default" id="ok" value="OK" />
			</div>
		</form>
	</div>
</div>
<hr />
	<c:forEach items="${listaProdutos }" var="item">	
	
		<div class="row">
		  <!-- Primeira parte das imagens -->
		  <div class="col-md-8">
		  		<div class="panel panel-default">
					<div class="panel-body">
						<div class="media">
						  <div class="media-left media-middle">
						      <img class="media-object" src="../img/${item.foto }.jpeg" alt="..." style="width:160px; heigth:160px;">
						  </div>
						  <div class="media-body">
						    <h4 class="media-heading">${item.nome}</h4>
						    	 <br />
						  </div>
						</div>
					
					</div>
				</div>
		  </div>
		  
		  <!-- Botoes -->
		  <div class="col-md-4">
		  		<form action="ComprarController">
		  		
		  		  <!-- valor -->
				  <div class="form-group">
				    <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
				    <div class="input-group">
				      <div class="input-group-addon">R$</div>
				      <input type="text" class="form-control" value='<fmt:formatNumber value="${item.valor }" type="currency" />'  id="exampleInputAmount" placeholder="Amount" readonly="readonly">
				    </div>
				  </div> <!-- end:valor -->
				  
				  <div class="form-group">
					  <select class="form-control" id="selQuantiade" name="qtdEscolhido">
					    <option>Quantidade</option>
					    <c:forEach begin="1" end="${item.quantidade}" varStatus="no">
					       <option value='<c:out value="${no.count}"/>'><c:out value="${no.count}"/></option>
					    </c:forEach>
					  </select>
					</div>
					
				  <input type="hidden" name="id" value="<c:out value="${item.idViagem}"/>"/>
				  <button type="submit" class="btn btn-default" id="comprar">Comprar</button>
				</form>
		  </div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						${item.descricao}
					</div>
				</div>
			</div>
		</div>
		
		<hr />
	</c:forEach>


<jsp:include page="rodape.jsp"></jsp:include>