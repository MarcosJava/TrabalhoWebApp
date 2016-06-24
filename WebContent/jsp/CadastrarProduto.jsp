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
	<script src="../js/cadastrarProduto.js"></script>
</head>
<body>

<jsp:include page="topo.jsp"></jsp:include>

<h1>Cadastro de Produto</h1>


${msg}

<form name="formproduto" id="formproduto" action="/AppWeb/CadastrarProduto/cadastro" method="post">

	<fieldset>	
		<legend class="control-label">Dados do Produto</legend>		
		
		<div class="row">
			<div class="form-group col-md-4">
				<label for="idNome">Nome:</label>
				<input type="text" name="nome" id="idNome" class="form-control" maxlength="18" size="18" />
				<!-- O código será por geração automática -->									
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-9">
				<label for="idDescricao">Descrição*:</label>				
				<textarea class="form-control" rows="5" id="idDescricao" name="descricao"></textarea>						
			</div>
		</div>			
		
		<div class="row">
			<div class="form-group col-md-3">
				<label for="idCidade">Cidade*:</label> 
				<select id=idCidade class="form-control" name="cidade">
					<option value="0">Selecione uma Cidade </option>
					<option value="RIO_JANEIRO">Rio de Janeiro</option>			
					<option value="SAO_PAULO">São Paulo</option>
					<option value="FORTALEZA">Fortaleza</option>
					<option value="RECIFE">Recife</option>
					<option value="PERNAMBUCO">Pernambuco</option>
					<option value="NATAL">Natal</option>
				</select>
			</div>			
			<div class="form-group col-md-3">
				<label for="idQuantidade">Quantidade*:</label>
				<input type="number" min="0" name="quantidade" id="idQuantidade" class="form-control" maxlength="40" size="40" />
			</div>
			
			<div class="form-group col-md-3">
				<label for="idValor">Valor*:</label>
				<input type="text" class="form-control" id="idValor" name="valor" maxlength="14"
				size="14" />
			</div>
			
		</div>
		
		
		
		<div class="row">		
			<div class="form-group col-md-3">
				<label for="inputdefault">Data saída:</label>
				<input type="text" class="form-control data" name="dtSaida" id="dataproduto"
				maxlength="10" size="10" readonly="readonly"/>				
			</div>
		</div>
		
		
		<!-- BOTÕES -->
		<div class="row">
			<div class="col-md-8">
				<input type="submit" value="Enviar" id="btnEnviar" class="btn btn-primary"/>
			</div>
		</div>
							
		
	</fieldset>
</form>
<hr>

<jsp:include page="rodape.jsp"></jsp:include>
