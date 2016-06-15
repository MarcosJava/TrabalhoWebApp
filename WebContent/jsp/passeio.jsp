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
<head>
	<jsp:include page="tagHeader.jsp"></jsp:include>
	
	<script src="../js/passeio.js"></script>
	
</head>
<body>

<jsp:include page="topo.jsp"></jsp:include>


<h3 class="page-header">TURISMO LEGAL</h3>

<div class="row">
	<div class="col-md-12">
		
		<button type="submit" class="btn btn-default" id="ok">Voltar para pacotes</button>
	</div>
</div>

<hr />

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
				    <h4 class="media-heading">Londres</h4>
				    	
				    	<form class="form-inline">
				    	  <!-- Quantidade Escolhida -->
						  <div class="form-group">
						    <label for="idQtdEscolhida">Quantidade Escolhida: </label>
						    <input type="text" class="form-control" id="idQtdEscolhida" readonly="readonly">
						  </div>
						  
						  <br /><br />
						  
						  <!-- Valor Total -->
						  <div class="form-group">
						    <label for="idValorTotal">Valor Total: </label>
						    <input type="email" class="form-control" id="idValorTotal" readonly="readonly">
						  </div>
				    	</form>
				    	
				  </div>
				</div>
			
			</div>
		</div>
  </div>
 
</div>


<!-- FORM -->
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline">
				  <!-- Nome -->
				  <div class="form-group">
				    <label for="exampleInputName2">Nome: </label>
				    <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
				  </div>
				  <!-- CPF -->
				  <div class="form-group">
				    <label for="exampleInputEmail2">CPF: </label>
				    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
				  </div>
				  <!-- DatePicker -->
				  <div class="form-group">
				  		<label for="lbDataChekin">Data Checkin: </label>
		                <div class='input-group date' id='lbDataChekin'>
		                    <input type='date' class="form-control" />
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>
		                </div>
		            </div>
		            <br /><br />
		             <!-- Nome -->
				  <div class="form-group">
				    <label for="idTelefone">Telefone: </label>
				    <input type="text" class="form-control" id="idTelefone" placeholder="(21) 9.9999-9999">
				  </div>
				  <!-- CPF -->
				  <div class="form-group">
				    <label for="idEmail">E-mail: </label>
				    <input type="email" class="form-control" id="idEmail" placeholder="jane.doe@example.com">
				  </div>
				  <!-- DatePicker -->
				  <div class="form-group">
				  		<label for="idDataSaida">Data Saida: </label>
		                <div class='input-group date' id='idDataSaida'>
		                    <input type='date' class="form-control" />
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>
		                </div>
		            </div>
		            
		            
		            <br /><br />
		            <div class="form-group">
			            <label> Forma de Pagamento: </label>
			            <label class="radio-inline"><input type="radio" name="frmPagamento" value="cc">Cartão de Crédito</label>
						<label class="radio-inline"><input type="radio" name="frmPagamento" value="bol">Boleto</label>
		            </div>
				</form>
			</div>
		</div>
	</div>
</div>

<hr />


 


<jsp:include page="rodape.jsp"></jsp:include>