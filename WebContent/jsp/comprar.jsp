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
</head>
<body>

<jsp:include page="topo.jsp"></jsp:include>


<h3 class="page-header">TURISMO LEGAL</h3>

<c:choose>
	<c:when test="${error.equals('')}">
				
		<form class="form-inline" action="#" method="post">
			
			
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
								    <h4 class="media-heading">${viagem.nome }</h4>
									    <div class="col-md-4">
									  		  <!-- valor -->
											  <div class="form-group">
											    <label class="sr-only" for="valor">Amount (in dollars)</label>
											    <div class="input-group">
											      <div class="input-group-addon">R$</div>
											      <input type="text" 
											      		 class="form-control" 
											      		 value='<fmt:formatNumber value="${viagem.valor }" type="currency" />'" 
											      		 id="valor" 
											      		 placeholder="Amount" 
											      		 readonly="readonly">
											    </div>
											  </div> <!-- end:valor -->
											  
											  <br /><br />
											  <!-- Quantidade -->
											  <div class="form-group">
												  <label for="idQuantidade">Quantidade: </label>
												  <input type="text" value="${qtdEscolhido}" readonly class="form-control"/>
											  </div>
											
									  </div> <!-- col-md4 end -->
								  </div>
								  
								</div> <!-- media end -->
							
							</div>
						</div>
				  </div>
			</div><!-- row end -->
			
			
			
			
			
			<div class="row">
				<div class="col-md-12">
				  <!-- Nome -->
				  <div class="col-md-4">
					  <div class="form-group">
						  <label for="idNome">Nome: </label>
						  <input type="text" name="nomeUsuario" id="idNome" class="form-control"/>
					  </div>
				  </div>
				  
				  <!-- CPF -->
				  <div class="col-md-4">
					  <div class="form-group">
						  <label for="idCPF">CPF: </label>
						  <input type="text" name="cpfUsuario" id="idCPF" class="form-control"/>
					  </div>
				  </div>
				  
				  <!-- Data chegada -->
				  <div class="form-group col-md4">
					<label for="inputdefault">Data chegada (Check-in):</label>
					<input type="text" class="form-control data" name="checkin" id="dataproduto" />				
				  </div>
				</div>
			</div><!-- row end -->
			
			<br />
			<div class="row">
				<div class="col-md-12">
				  <!-- Telefone -->
				  <div class="col-md-4">
					  <div class="form-group">
						  <label for="idTelefone">Telefone: </label>
						  <input type="text" name="telefoneUsuario" id="idTelefone" class="form-control"/>
					  </div>
				  </div>
				  
				  <!-- email -->
				  <div class="col-md-4">
					  <div class="form-group">
						  <label for="idEmail">E-mail: </label>
						  <input type="text" name="emailUsuario" id="idEmail" class="form-control"/>
					  </div>
				  </div>
				  
				  <!-- Data saida -->
				  <div class="form-group col-md4">
					<label for="idDtSaida">Data saída:</label>
					<input type="text" 
						   value='<fmt:formatDate value="${viagem.saida}" pattern="dd/MM/yyyy"/>' 
						   class="form-control" 
						   name="dtSaida" 
						   id="idDtSaida" readonly/>				
				  </div>
				</div>
			</div><!-- row end -->
			
			
			
			<br />
			<div class="row">
				<div class="col-md-12">
					<div class="form-group col-md4">
						<label>Forma de Pagamento: </label>
						<label class="radio-inline"><input type="radio" name="pagamento" value="boleto">Boleto Bancario</label>
						<label class="radio-inline"><input type="radio" name="pagamento" value="cc">Cartão de Crédito</label>
					</div>
				</div>
			</div><!-- row end -->
			
			<br /><br /><br />
			<div class="row" id="divBoleto">
				<div class="col-md-12">
					<div class="form-group col-md-4" align="center">
						<button type="button" class="btn btn-warning" onclick="return;">EM MANUTENÇÃO</button>
					</div>
				</div>
			</div><!-- row end -->
			
			
			<div id="divCC">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-6">
							<label for="idNumCartao">Número Cartao</label>
							<input type="text" class="form-control" name="numCartao" id="idNumCartao"/>
						</div>
						
						<div class="form-group col-md-6">
							<label for="idDtValidade">Data Validade (MM/AAAA)</label>
							<input type="text" class="form-control data-cartao" name="dtValidade" id="idDtValidade"/>
						</div>
					</div>
				</div><!-- row end -->
				
				<br /><br />
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-6">
							<label for="idNomeCartao">Nome Titular</label>
							<input type="text" class="form-control" name="nomeCartao" id="idNomeCartao"/>
						</div>
						
						<div class="form-group col-md-6">
							<label for="idCdSeg">Código Segurança</label>
							<input type="text" class="form-control" name="codSeguranca" id="idCdSeg"/>
						</div>
					</div>
				</div><!-- row end -->
				
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group col-md-4">	
						</div>
						
						<div class="form-group col-md-4">
							<input type="hidden" name="idViagem" value="${viagem.idViagem }">
							<button type="button" class="btn btn-primary">Finalizar Compra</button>
						</div>
						
						<div class="form-group col-md-4">
						</div>
						
					</div>
				</div><!-- row end -->
				
			</div><!-- Div CC -->
			
		</form>
	</c:when>
	<c:otherwise>
		${error }
	
	</c:otherwise>
</c:choose>	
	


<jsp:include page="rodape.jsp"></jsp:include>