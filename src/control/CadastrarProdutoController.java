package control;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Viagem;
import model.persistence.ViagemDao;

@WebServlet({"/CadastrarProduto","/jsp/CadastrarProduto/ajaxEnviar","/jsp/CadastrarProduto/"})
public class CadastrarProdutoController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    public CadastrarProdutoController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String cidade = request.getParameter("cidade");
			String descricao = request.getParameter("descricao");
			String nome = request.getParameter("nome");
			String quantidade = request.getParameter("quantidade");
			String valor = request.getParameter("valor");
			String saida = request.getParameter("dtSaida");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Viagem viagem = new Viagem(null, 
									   nome, 
									   descricao, 
									   sdf.parse(saida), 
									   Integer.parseInt(quantidade), 
									   cidade, 
									   Float.parseFloat(valor));
			
			System.out.println(viagem);
			
			ViagemDao viagemDao = new ViagemDao();
			viagemDao.insertViagem(viagem);
			
			
			request.setAttribute("msg", super.setMensagemError("Produto cadastrado com sucesso !"));
			request.getRequestDispatcher(ConstantsController.PAGE_CADASTRAR_PRODUTO).forward(request, response);
			
			
		} catch (Exception e) {
			
			request.setAttribute("msg", super.setMensagemError("Ocorreu algum erro!"));
			request.getRequestDispatcher(ConstantsController.PAGE_CADASTRAR_PRODUTO).forward(request, response);
		}
		
	}

}
