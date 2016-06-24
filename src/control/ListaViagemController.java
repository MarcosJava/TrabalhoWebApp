package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Viagem;
import model.persistence.ViagemDao;

@WebServlet({"/ListaViagemController", "/jsp/ListaViagemController", 
			"/ListaViagemController/excluir","/jsp/ListaViagemController/excluir"})
public class ListaViagemController extends AbstractController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListaViagemController() {
		 super();
	}
	
	
	@Override
	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = request.getServletPath();
		System.out.println(url);	
		
		
		if(request.getParameter("ok") != null && request.getParameter("ok").trim().equals("sim")){
			loading(request, response);
		}
		
		if(url.trim().equals("/ListaViagemController/excluir")){
			excluir(request, response);
			
		} 		
	}
	
	private void loading(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ViagemDao viagemDao = new ViagemDao();
			List<Viagem> listaViagem = viagemDao.todasViagens();
			request.setAttribute("viagens", listaViagem);
			request.getRequestDispatcher(ConstantsController.PAGE_LISTAR_VIAGEM).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher(ConstantsController.PAGE_LISTAR_VIAGEM).forward(request, response);
		}
		
	}


	private void excluir(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ViagemDao viagemDao = new ViagemDao();
			viagemDao.excluir(new Long(request.getParameter("id")));
			List<Viagem> listaViagem = viagemDao.todasViagens();
			request.setAttribute("viagens", listaViagem);
			request.getRequestDispatcher(ConstantsController.PAGE_LISTAR_VIAGEM).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher(ConstantsController.PAGE_LISTAR_VIAGEM).forward(request, response);
		}
		
	}

}
