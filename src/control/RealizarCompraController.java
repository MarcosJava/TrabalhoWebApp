package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.CartaoCredito;
import model.entity.Usuario;
import model.entity.Venda;
import model.entity.Viagem;
import model.persistence.CartaoCreditoDAO;
import model.persistence.UsuarioDao;
import model.persistence.VendaDao;
import model.persistence.ViagemDao;


@WebServlet({"/RealizarCompraController", "/jsp/RealizarCompraController"})
public class RealizarCompraController extends AbstractController {
	
	private static final long serialVersionUID = 1L;
    
	private HttpServletRequest request;
    private HttpServletResponse response;
  
    public RealizarCompraController() {
        super();
    }
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			this.request = request;
			this.response = response;
			
			Integer qtdeViagem = null;
			Long idViagem = null;
			if(request.getParameter("idViagem") != null &&
					request.getParameter("qtdViagem") != null){
				try {
					idViagem = Long.parseLong(request.getParameter("idViagem"));
					qtdeViagem = Integer.parseInt(request.getParameter("qtdViagem"));
				
				} catch (Exception e) {
					super.paginaErro(request, response);
				}
				
			}
			
			//Pega valores da view
			String nome = request.getParameter("nomeUsuario");
			String cpf = request.getParameter("cpfUsuario");
			String checkin = request.getParameter("checkin");
			String telefone = request.getParameter("telefoneUsuario");
			String email = request.getParameter("emailUsuario");
			String formaPagamento = request.getParameter("pagamento");

			//Popula o cartao de credito
			CartaoCredito  cartaoCredito = new CartaoCredito();
			if (formaPagamento.equals("cc") ){
				popularCartaoCredito(cartaoCredito);
				CartaoCreditoDAO cartaoDao = new CartaoCreditoDAO();
				cartaoDao.cadastraCartaoCredito(cartaoCredito);
			} else if (formaPagamento.equals("boleto")){
				
			}
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			
			VendaDao vendaDao = new VendaDao();
			ViagemDao viagemDao = new ViagemDao();
			Viagem viagem = viagemDao.buscarViagemPeloID(idViagem);
			Venda venda = null;
			Usuario usuario = new Usuario();
			
			if(qtdeViagem < viagem.getQuantidade()){
				
				
				usuario.setEmail(email);
				usuario.setNome(nome);
				UsuarioDao usuarioDao = new UsuarioDao();
				usuarioDao.cadastrarUsuario(usuario);
				
				//TODO: Verifica se existe o Usuario. (UsuarioDAO)
				
				venda = new Venda(null, 
						qtdeViagem, 
						sdf.parse(checkin), 
						cpf, telefone, 
						new Date(), 
						usuario, 
						viagem, 
						cartaoCredito);
				
				vendaDao.realizarVenda(venda);
				
				viagem.diminuirQuantidade(qtdeViagem);
				viagemDao.alterarViagem(viagem);
				
			} else {
				request.setAttribute("msg", ConstantsController.MSG_QUANTIDADE_NAO_DISPONIVEL);
			}
			
			
			request.setAttribute("msg", super.setMensagemInfo(ConstantsController.MGS_VALEU));
			request.setAttribute("nome", usuario.getNome());
			request.setAttribute("qtde", qtdeViagem);
			request.setAttribute("descricao", viagem.getNome());
			request.getRequestDispatcher(ConstantsController.PAGE_COMPRA_REALIZADA).forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			super.paginaErro(request, response);
		}
	}

	private void popularCartaoCredito(CartaoCredito cartaoCredito) throws ServletException, IOException {
		
		try {
			String numCartao = this.request.getParameter("numCartao");
			String dtValidade = this.request.getParameter("dtValidade");
			String titularCartao = this.request.getParameter("nomeCartao");
			String codSeguranca = this.request.getParameter("codSeguranca");
			dtValidade = "01/" + dtValidade;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataValidade = sdf.parse(dtValidade);
			
			Integer codigoSeguranca = null;
			try {
				codigoSeguranca = Integer.parseInt(codSeguranca);
				
			} catch (IllegalArgumentException e) {
				request.setAttribute("msg", super.setMensagemError(ConstantsController.MSG_NUMERO_CARTAO_ERRADO));
				request.getRequestDispatcher(ConstantsController.PAGE_INTERNA_INICIAL).forward(request, response);
				
			} catch (Exception ex){
				super.paginaErro(request, response);
				
			}
			cartaoCredito.setCodSeguranca(codigoSeguranca);
			cartaoCredito.setTitular(titularCartao);
			cartaoCredito.setDataValidade(dataValidade);
			cartaoCredito.setNumCartao(numCartao);
			
		} catch (Exception e) {
			super.paginaErro(request, response);
		}
		
	}

}
