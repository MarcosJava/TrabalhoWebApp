package control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.entity.Usuario;

public class AbstractController extends HttpServlet {
	
    public AbstractController() {
       super();
    }

	protected void setUsuarioSessao(Usuario usuario, HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);
	}
	
	
	protected Usuario getUsuarioSessao(HttpServletRequest request){
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		return usuario;
	}
	
	protected String getMensagemError(String mensagem) {
		
		if(mensagem.trim().isEmpty()) return null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("<div class='alert alert-danger alert-dismissible' role='alert'>");
		sb.append("<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
		sb.append(mensagem);
		sb.append("</div>");
		
		return sb.toString();
	}

}
