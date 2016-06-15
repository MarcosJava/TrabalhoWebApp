$(function() {
	
    $(".dinheiro").maskMoney({showSymbol:true, symbol:"R$ ", decimal:",", thousands:"."});   

	 /*Máscara dos campos com Jquery - biblioteca JQUERY- MASKED INPUT*/ 
    $(".data").mask("99/99/9999");
    $("#telefone").mask("(99) 9999-9999");
    $("#celular").mask("(99) 99999-9999");
    $("#cpf").mask("999.999.999-99");
    $("#cep").mask("99.999-999");
    //$(".hora").mask("99:99");
    $(".sonums").mask("9?9999"); //depois da interrogação é tudo opcional
    $(".2dignum").mask("99");
    $(".percentual").mask("9?9%");
    
    /*Jquery UI para exibição de calendário*/
    $( "#dataproduto" ).datepicker({
    	dateFormat: 'dd/mm/yy', /*formato Brasil*/
    	showOn: "button",
        buttonImage: "../js/jquery-ui-1.11.4.custom/images/calendar.gif",
        buttonImageOnly: true,
        buttonText: "Select date"
    });    
    
   
	
});