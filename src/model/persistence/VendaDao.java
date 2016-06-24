package model.persistence;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.entity.Venda;

public class VendaDao extends Dao{

	public void realizarVenda(Venda venda) throws Exception{
		
		try {
			open();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append(Venda.TABELA);
			sb.append("("+ Venda.ID_VENDA + ","
					+ Venda.QUANTIDADE + ","
					+ Venda.CHECK_IN + ","
					+ Venda.CPF + ","
					+ Venda.DATA_COMPRA + ","
					+ Venda.FK_USUARIO + ","
					+ Venda.FK_VIAGEM + ","
					+ Venda.FK_CARTAO_CREDITO + ","
					+ Venda.TELEFONE + " )");
			sb.append("values(nextval('"+  Venda.SEQUENCE  +"'), ?, ?, ?, ?, ?, ?, ?, ?)");
			
			
			System.out.println("Insert = " + sb.toString());
			
			stmt = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, venda.getQuantidade());
			stmt.setDate(2, new java.sql.Date(venda.getCheckIn().getTime()));
			stmt.setString(3, venda.getCpf());
			stmt.setDate(4, new java.sql.Date( new Date().getTime()));
			stmt.setInt(5, venda.getUsuario().getIdUsuario().intValue());
			stmt.setInt(6, venda.getViagem().getIdViagem().intValue());
			stmt.setInt(7, venda.getCartaoCredito().getIdCartaoCredito().intValue());
			stmt.setString(8, venda.getTelefone());
			
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
			    int lastId = rs.getInt(1);
			    venda.setIdVenda(rs.getLong(1));
			    System.out.println(lastId);
			}
			
			
			stmt.close();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			close();
			e.printStackTrace();
		}finally{
			close();
		}
		
	}
	
	
	
}
