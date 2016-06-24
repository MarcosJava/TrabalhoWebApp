package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Usuario;

public abstract class AbstractController extends HttpServlet {
	
    public AbstractController() {
       super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	protected void setUsuarioSessao(Usuario usuario, HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);
	}
	
	
	protected Usuario getUsuarioSessao(HttpServletRequest request){
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		return usuario;
	}
	
	protected String setMensagemError(String mensagem) {
		
		if(mensagem.trim().isEmpty()) return null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("<div class='row'>");
		sb.append("<div class='alert alert-danger alert-dismissible' role='alert'>");
		sb.append("<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
		sb.append(mensagem);
		sb.append("</div>");
		sb.append("</div>");
		
		return sb.toString();
	}
	
protected String setMensagemInfo(String mensagem) {
		
		if(mensagem.trim().isEmpty()) return null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("<div class='row'>");
		sb.append("<div class='alert alert-info alert-dismissible' role='alert'>");
		sb.append("<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
		sb.append(mensagem);
		sb.append("</div>");
		sb.append("</div>");
		
		return sb.toString();
	}
	
	protected void paginaErro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("").forward(request, response);
	}

}
