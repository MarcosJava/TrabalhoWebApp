package control;

/***
 * 
 * @author markFelipe
 * Classe que guarda as constantes do projeto , para nao precisar ficar alterando em outros lugares.
 * <melhora> -- Criar um Bundle com properties !
 * 
 */
public class ConstantsController {
	
	
	
	
	/****
	 * ****************************** PAGINAS
	 */
	public static final String PAGE_LOGIN = "/jsp/login.jsp";
	public static final String PAGE_INTERNA_INICIAL = "/jsp/buscarPasseios.jsp";
	public static final String PAGE_CADASTRAR_PRODUTO = "/jsp/CadastrarProduto.jsp";
	public static final String PAGE_COMPRA_REALIZADA = "/jsp/compraRealizada.jsp";
	public static final String PAGE_LISTAR_VIAGEM = "/jsp/listaViagem.jsp";
	
	
	
	
	/****
	 *********************************  MENSAGENS 
	 */
	public static final String MSG_LOGIN_INVALIDO = "Login ou Senha inválidos";
	public static final String MSG_NUMERO_CARTAO_ERRADO = "Numero de cartão errado/codigo seguranca";
	public static final String MSG_QUANTIDADE_NAO_DISPONIVEL = "Quantidade não disponivel para venda";
	public static final String MGS_VALEU = "Obrigado por comprar conosco ! ";
	

}
