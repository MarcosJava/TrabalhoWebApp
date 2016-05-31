package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Cliente;
import model.persistence.ClienteDao;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({
	"/",
	"index"
})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getServletPath();
		
		System.out.println(url);
		if(url.trim().equalsIgnoreCase("/jsp/consultarcliente.html")){
			consultar(request, response);
			
		} else {
			//TODO: Not Found Page
		}
		
		
	}
	
	
	/* Consultar os dados de um Cliente */
	protected void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			/* Pegar o cpf digitado na tela */			
			Long cpf = new Long(request.getParameter("cpf"));
			/* Instanciar a classe DaoCliente */
			ClienteDao cd = new ClienteDao();
			/* Acionar o m�todo da classe Dao Cliente que retorna os dados de um cliente a 
			 * partir do CPF do cliente*/
			Cliente cliente = cd.buscarPorCpf(cpf);
		
			if(cliente == null){ //Cliente n�o encontrado
				request.setAttribute("msg", "<div class='alert alert-warning'>Cliente "
						+ " nao existente</div>");
				request.getRequestDispatcher("/jsp/ConsultarClienteBS.jsp").forward(request, response);
			}else{
				request.setAttribute("c", cliente);
				request.setAttribute("op", "C"); //opera��o = consulta
				request.getRequestDispatcher("/jsp/CadastrarCliente.jsp").forward(request, response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
