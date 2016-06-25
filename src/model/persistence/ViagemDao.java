package model.persistence;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.entity.Viagem;

public class ViagemDao extends Dao {

	public void insertViagem(Viagem viagem) throws Exception{
		
		try {
			open();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append(Viagem.TABELA);
			sb.append("("+ Viagem.ID_VIAGEM + ","
					+ Viagem.NOME + ","
					+ Viagem.DESCRICAO + ","
					+ Viagem.CIDADE + ","
					+ Viagem.QUANTIDADE + ","
					+ Viagem.SAIDA + ","
					+ Viagem.VALOR + ") ");
			sb.append("values(nextval('"+  Viagem.SEQUENCE  +"'), ?, ? ,? ,? ,?, ?)");
			
			
			System.out.println("Insert = " + sb.toString());
			
			stmt = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, viagem.getNome());
			stmt.setString(2, viagem.getDescricao());
			stmt.setString(3, viagem.getCidade());
			stmt.setInt(4, viagem.getQuantidade());
			stmt.setDate(5, new Date(viagem.getSaida().getTime()));
			stmt.setFloat(6, viagem.getValor());
			
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
			    int lastId = rs.getInt(1);
			    viagem.setIdViagem(rs.getLong(1));
			    System.out.println(lastId);
			}
			
			
			stmt.close();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			close();
			e.printStackTrace();
		}
		
	}
	
	
	public void alterarViagem(Viagem viagem) throws Exception{
		
		try {
			open();
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ");
			sb.append(Viagem.TABELA);
			sb.append(" SET "+  Viagem.NOME + " = ? ,"
					+ Viagem.DESCRICAO + " = ?,"
					+ Viagem.CIDADE + " = ?,"
					+ Viagem.QUANTIDADE + " = ?,"
					+ Viagem.SAIDA + " = ?,"
					+ Viagem.VALOR + " = ?");
			sb.append(" WHERE " + Viagem.ID_VIAGEM + " = ?");
			
			
			System.out.println("update = " + sb.toString());
			
			stmt = con.prepareStatement(sb.toString());
			
			stmt.setString(1, viagem.getNome());
			stmt.setString(2, viagem.getDescricao());
			stmt.setString(3, viagem.getCidade());
			stmt.setInt(4, viagem.getQuantidade());
			stmt.setDate(5, new Date(viagem.getSaida().getTime()));
			stmt.setFloat(6, viagem.getValor());
			stmt.setLong(7, viagem.getIdViagem());
			
			stmt.executeUpdate();
			
			stmt.close();
			
			close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			close();
			e.printStackTrace();
		}
		
	}
	
	
	private void todasViagensComDataValida(List<Viagem> viagens) {
		try {
			stmt = con.prepareStatement("SELECT * FROM viagem v WHERE v.dt_saida > NOW()");
			rs = stmt.executeQuery();

			Random gerador = new Random();

			while (rs.next()) {
				
				Viagem v = new Viagem(rs.getLong(Viagem.ID_VIAGEM),
									  rs.getString(Viagem.NOME),
									  rs.getString(Viagem.DESCRICAO), 
									  rs.getDate(Viagem.SAIDA), 
									  rs.getInt(Viagem.QUANTIDADE), 
									  rs.getString(Viagem.CIDADE), 
									  rs.getFloat(Viagem.VALOR));
				
				
				v.setFoto(gerador.nextInt(11));
				viagens.add(v);
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Viagem> todasViagens() throws Exception {
		
		List<Viagem> viagens = new ArrayList<Viagem>();
		
		try {
			open();
			stmt = con.prepareStatement("SELECT * FROM viagem v");
			rs = stmt.executeQuery();

			while (rs.next()) {
				
				Viagem v = new Viagem(rs.getLong(Viagem.ID_VIAGEM),
									  rs.getString(Viagem.NOME),
									  rs.getString(Viagem.DESCRICAO), 
									  rs.getDate(Viagem.SAIDA), 
									  rs.getInt(Viagem.QUANTIDADE), 
									  rs.getString(Viagem.CIDADE), 
									  rs.getFloat(Viagem.VALOR));
				viagens.add(v);
			}

			stmt.close();
			close();
			return viagens;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			close();
			return viagens;
		}
	}
	public void excluir(Long id) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("DELETE FROM viagem where id_viagem = ? ");
			stmt.setLong(1, id);
			stmt.executeQuery();
			
			close();
		} catch (Exception e) {
			e.printStackTrace();
			close();
		}
		
	}
	
	
	private void todasViagensPelaCidade(List<Viagem> viagens, String cidade) {
		try {
			
			stmt = con.prepareStatement("SELECT * FROM viagem v where v.cidade = ? AND v.dt_saida > now() ");
			stmt.setString(1, cidade);
			rs = stmt.executeQuery();
			Random gerador = new Random();
			while (rs.next()) {
				
				Viagem v = new Viagem(rs.getLong(Viagem.ID_VIAGEM),
									  rs.getString(Viagem.NOME),
									  rs.getString(Viagem.DESCRICAO), 
									  rs.getDate(Viagem.SAIDA), 
									  rs.getInt(Viagem.QUANTIDADE), 
									  rs.getString(Viagem.CIDADE), 
									  rs.getFloat(Viagem.VALOR));
				v.setFoto(gerador.nextInt(11));
				viagens.add(v);
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public Viagem buscarViagemPeloID(Long id) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("SELECT * FROM viagem v where " + Viagem.ID_VIAGEM + "= ?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			Viagem v = null;
			if (rs.next()) {
				
				 v = new Viagem(rs.getLong(Viagem.ID_VIAGEM),
									  rs.getString(Viagem.NOME),
									  rs.getString(Viagem.DESCRICAO), 
									  rs.getDate(Viagem.SAIDA), 
									  rs.getInt(Viagem.QUANTIDADE), 
									  rs.getString(Viagem.CIDADE), 
									  rs.getFloat(Viagem.VALOR));
				
			}

			stmt.close();
			close();
			return v;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			close();
			return null;
		}
	}
	public List<Viagem> buscarViagensPorCidadeParaVenda(String cidade) throws Exception {
		try {
			open();
			List<Viagem> viagens = new ArrayList<Viagem>();
			
			if(cidade == null || cidade.trim().equals("0")){
				todasViagensComDataValida(viagens);
			
			} else {
				todasViagensPelaCidade(viagens, cidade);
				
			}
			
			
			close();
			return viagens;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			close();
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		
		Viagem viagem = new Viagem(null, "Marconha", "Muito linda a cidade", new java.util.Date(), 2, "Rio de Janeiro", 24.0f);
		
		
		ViagemDao dao = new ViagemDao();
		dao.insertViagem(viagem);
		
		System.out.println(viagem.getIdViagem());
		
	}


	
	
}
