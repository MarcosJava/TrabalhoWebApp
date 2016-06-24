<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>


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
<script src="../js/listaViagem.js"></script>



 <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<jsp:include page="topo.jsp"></jsp:include>

	<form action="/AppWeb/ListaViagemController/excluir?id=0" method="get">
		<input type="submit" id="submit"/>
	</form>

<h3 class="page-header">TURISMO LEGAL</h3>
		
	<div class="row">
		 <table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Cidade</th>
					<th>Descrição</th>
					<th>Valor</th>
					<th>Quantidade</th>
					<th>Opção</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${viagens}" var="viagem">
				<tr>
					<th scope="row">${viagem.idViagem }</th>
					<td>${viagem.nome }</td>
					<td>${viagem.cidade }</td>
					<td>${viagem.descricao }</td>
					<td>${viagem.valor }</td>
					<td>${viagem.quantidade}</td>
					<td>
						<a  href="/AppWeb/ListaViagemController/excluir?id=${viagem.idViagem }" type="button" class="btn btn-default" aria-label="Left Align">
						  <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</a>
					</td>	
				</tr>
				</c:forEach>
			</tbody>
		 </table>
	</div><!-- row end -->
	

<jsp:include page="rodape.jsp"></jsp:include>