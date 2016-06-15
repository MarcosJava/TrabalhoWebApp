package model.persistence;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	private void todasViagens(List<Viagem> viagens) {
		try {
			stmt = con.prepareStatement("SELECT * FROM viagem v WHERE v.dt_saida > NOW()");
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void todasViagensPelaCidade(List<Viagem> viagens, String cidade) {
		try {
			stmt = con.prepareStatement("SELECT * FROM viagem v where v.cidade = ? AND v.dt_saida > now() ");
			stmt.setString(1, cidade);
//			Date date = new Date(new java.util.Date().getTime());
//			stmt.setDate(2, date);
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Viagem> buscarViagensPorCidadeParaVenda(String cidade) throws Exception {
		try {
			open();
			List<Viagem> viagens = new ArrayList<Viagem>();
			
			if(cidade == null || cidade.trim().equals("0")){
				todasViagens(viagens);
			
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
