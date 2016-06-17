package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Viagem;
import model.persistence.ViagemDao;

/**
 * Servlet implementation class ComprarController
 */
@WebServlet({"/ComprarController","/jsp/ComprarController"})
public class ComprarController extends AbstractController {
	
	private static final long serialVersionUID = 1L;
	private static final String ERROR_PRODUTO = "Produto não encontrado ! Tente novamente";
   
    public ComprarController() {
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
			if (request.getParameter("id") != null || !request.getParameter("id").isEmpty()){
				
				ViagemDao viagemDao = new ViagemDao();
				Viagem viagem = viagemDao.buscarViagemPeloID(request.getParameter("id"));
				
				if (viagem == null){
					request.setAttribute("error", super.setMensagemError(ERROR_PRODUTO));
					request.getRequestDispatcher("/jsp/comprar.jsp").forward(request, response);
				}
				request.setAttribute("viagem", viagem);
				
				System.out.println(viagem);
				request.setAttribute("error", "");
				request.setAttribute("qtdEscolhido", request.getParameter("qtdEscolhido"));
				request.getRequestDispatcher("/jsp/comprar.jsp").forward(request, response);
			} else {
				request.setAttribute("error", super.setMensagemError(ERROR_PRODUTO));
				request.getRequestDispatcher("/jsp/comprar.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			request.getRequestDispatcher("/jsp/errorServidor.jsp").forward(request, response);
		}
		
		
	}

}
