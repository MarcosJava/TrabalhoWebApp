$(function() {
	
    $(".dinheiro").maskMoney({showSymbol:true, symbol:"R$ ", decimal:",", thousands:"."});   

	 /*Máscara dos campos com Jquery - biblioteca JQUERY- MASKED INPUT*/ 
    $(".data").mask("99/99/9999");
    $(".data-cartao").mask("99/9999");
    $("#idTelefone").mask("(99) 99999-9999");
    //$("#idCelular").mask("(99) 99999-9999");
    $("#idCPF").mask("999.999.999-99");
    $(".codSeguranca").mask("999");
    $(".numCartaoCredito").mask("9999.9999.9999.9999");
    //$("#cep").mask("99.999-999");
    //$(".hora").mask("99:99");
   // $(".sonums").mask("9?9999"); //depois da interrogação é tudo opcional
    //$(".2dignum").mask("99");
    //$(".percentual").mask("9?9%");
    
    
   
    /* INICIAR COM A RADIO CHECKING */
    var $radios = $('input:radio[name=pagamento]');
    if($radios.is(':checked') === false) {
        $radios.filter('[value=boleto]').prop('checked', true);
    }
    
    /* On Loading */
    $("#divBoleto").show();
    $("#divCC").hide();
    
    
    
    /* Troca dos radios*/
    $('input:radio[name=pagamento]').on('change', function() {
    	var valueCheck = $('input[name=pagamento]:checked').val();

    	if (valueCheck === 'cc'){
    		$("#divBoleto").hide();
    		$("#divCC").show();
    	
    	} else if (valueCheck === 'boleto'){
    		$("#divBoleto").show();
    		$("#divCC").hide();
    	}
    	
    	
    });
    
   
	
});