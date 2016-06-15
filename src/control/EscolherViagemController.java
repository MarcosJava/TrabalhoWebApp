package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Viagem;
import model.persistence.ViagemDao;

/**
 * Servlet implementation class EscolherViagemController
 */
@WebServlet({
			"/EscolherViagemController",
			"/jsp/EscolherViagemController"})
public class EscolherViagemController extends AbstractController {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EscolherViagemController() {
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
			String id = request.getParameter("id");
			
			if (id != null && !id.isEmpty()){
				request.getRequestDispatcher("/jsp/comprar.jsp").forward(request, response);
			}
			
			ViagemDao viagemDao = new ViagemDao();
			
			List<Viagem> viagens = viagemDao.buscarViagensPorCidadeParaVenda(cidade);
			if (viagens.size() > 0 ) request.setAttribute("listaProdutos", viagens);
			
			request.getRequestDispatcher("/jsp/buscarPasseios.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			request.getRequestDispatcher("/jsp/errorServidor.jsp").forward(request, response);
		}
		
		
	}
}
