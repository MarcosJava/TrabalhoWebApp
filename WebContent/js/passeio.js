$(function() {
	$("#ok").click(function(){
		alert("volto");
	});
	 
	 $('input[type=radio][name=frmPagamento]').change(function() {
	        if (this.value == 'cc') {
	            alert("Cartao Credito");
	        }
	        else if (this.value == 'bol') {
	            alert("Boleto");
	        }
	    });
});