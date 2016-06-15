package model.persistence;

import java.sql.SQLException;

import model.entity.Usuario;

public class UsuarioDao extends Dao{
	
	public Usuario buscarUsuario(String email, String senha) throws Exception{
		
		Usuario usuario = null;
		
		try {
			open();
			con.setAutoCommit(false);
			stmt = con.prepareStatement("select * from USUARIO where email=? and senha=?");
			stmt.setString(1, email);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			while (rs.next()){
				
				
				usuario = new Usuario(rs.getLong(Usuario.ID_USUARIO), 
									  rs.getString(Usuario.EMAIL), 
									  rs.getString(Usuario.NOME), 
									  rs.getString(Usuario.SENHA));
				
			}
			
			close();
			
			return usuario;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			close();
			e.printStackTrace();
			return usuario;
		}
	}
	
	public static void main(String[] args) {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario u = usuarioDao.buscarUsuario("admin@gmail.com", "123");
			System.out.println(u.toString());
		} catch (Exception e) {
			System.out.println("Error !");
			e.printStackTrace();
		}
		
	}
	
}
