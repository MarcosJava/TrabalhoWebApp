<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

	<title>Turismo</title>
	<jsp:include page="tagHeader.jsp"></jsp:include>
	<script src="../js/comprar.js"></script>
	<link rel="stylesheet" type="text/css" href="../style/myStyle.css" />
	
</head>
<body>

<jsp:include page="topo.jsp"></jsp:include>


<h3 class="page-header">TURISMO LEGAL</h3>
		
	<div class="row">
		<a href="/AppWeb/" class="btn btn-success"> Novos Pacotes </a> 
	</div>
		
	<br />
		${msg}
		
	<div class="row">
		  <!-- Primeira parte das imagens -->
		  <div class="col-md-12">
		  		<div class="panel panel-default">
					<div class="panel-body">
						<div class="media">
						  <div class="media-left media-middle">
						      <img class="media-object" src="../img/london.jpg" alt="..." style="width:160px; heigth:160px;">
						  </div>
						  <div class="media-body">
						    <h4 class="media-heading">${nome}</h4>
							    <div class="col-md-12">
							  		<div class="panel panel-default">
  										<div class="panel-body">
									  		<p class="textoFinal">Boa viagem! Sua compra para ${qtde} pessoa(s) no pacote </p> 
									  		<p class= "textoFinal"> " ${descricao}",  foi finalizada!</p>
							  			</div> <!-- panel -body -->
							  		</div> <!-- panel-default  -->
							  	</div> <!-- col-md4 end -->
						  </div>
						  
						</div> <!-- media end -->
					
					</div>
				</div>
		  </div>
	</div><!-- row end -->
	

<jsp:include page="rodape.jsp"></jsp:include>