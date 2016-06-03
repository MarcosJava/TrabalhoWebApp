package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Usuario;
import model.persistence.UsuarioDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({"/login", "/jsp/login"})
public class LoginController extends AbstractController {
	private static final long serialVersionUID = 1L;
   
	private UsuarioDao usuarioDao;
   
    public LoginController() {
        super();
        usuarioDao = new UsuarioDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			Usuario usuario = this.usuarioDao.buscarUsuario(email, senha);
			
			//Se o usuario for nullo, avisa que nao existe esse usuario.
			//Se existir mostra o sistema para o usuário.
			if(usuario != null){				
				System.out.println(usuario.toString());
				super.setUsuarioSessao(usuario, request);
				request.setAttribute("msg", super.getUsuarioSessao(request).getEmail());
				request.getRequestDispatcher(ConstantsController.PAGE_INTERNA_INICIAL).forward(request,response);
				
			} else {
				request.setAttribute("msgErro", super.getMensagemError(ConstantsController.MSG_LOGIN_INVALIDO));
				request.getRequestDispatcher(ConstantsController.PAGE_LOGIN).forward(request, response);
			}
			
			
			
		} catch (Exception e) {
			
		}
		
	}

}
