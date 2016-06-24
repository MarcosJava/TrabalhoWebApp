package model.persistence;

import java.sql.SQLException;
import java.sql.Statement;

import model.entity.Usuario;
import model.entity.Viagem;

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
	
	public void cadastrarUsuario(Usuario usuario) throws Exception{
		
		try {
			open();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append(Usuario.TABELA);
			sb.append("("+ Usuario.ID_USUARIO + ","
					+ Usuario.NOME + ","
					+ Usuario.EMAIL + ","
					+ Usuario.SENHA + " )");
			sb.append("values(nextval('"+  Viagem.SEQUENCE  +"'), ?, ?, 'qlqr')");
			
			
			System.out.println("Insert = " + sb.toString());
			
			stmt = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
			    int lastId = rs.getInt(1);
			    usuario.setIdUsuario(rs.getLong(1));
			    System.out.println(lastId);
			}
			
			
			stmt.close();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			close();
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario usuario = new Usuario(null, "@@@", "marco", "senha");
			usuarioDao.cadastrarUsuario(usuario);
			System.out.println(usuario.toString());
		} catch (Exception e) {
			System.out.println("Error !");
			e.printStackTrace();
		}
		
	}
	
}
