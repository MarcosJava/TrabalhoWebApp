package model.persistence;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.entity.CartaoCredito;

public class CartaoCreditoDAO extends Dao{
	
	public void cadastraCartaoCredito(CartaoCredito cartaoCredito) throws Exception{
		
		try {
			open();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append(CartaoCredito.TABELA);
			sb.append("("+ CartaoCredito.ID_CARTAO_CREDITO + ","
					+ CartaoCredito.NUM_CARTAO + ","
					+ CartaoCredito.TITULAR_CARTAO + ","
					+ CartaoCredito.DATA_VALIDADE + ","
					+ CartaoCredito.COD_SEGURANCA + " )");
			sb.append("values(nextval('"+  CartaoCredito.SEQUENCE  +"'), ?, ?, ?, ?)");
			
			
			System.out.println("Insert = " + sb.toString());
			
			stmt = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cartaoCredito.getNumCartao());
			stmt.setString(2, cartaoCredito.getTitular());
			stmt.setDate(3, new java.sql.Date(cartaoCredito.getDataValidade().getTime()));
			stmt.setInt(4, cartaoCredito.getCodSeguranca());
			
			
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
			    int lastId = rs.getInt(1);
			    cartaoCredito.setIdCartaoCredito(rs.getLong(1));
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
			CartaoCreditoDAO cartaoDao = new CartaoCreditoDAO();
			CartaoCredito cartao = new CartaoCredito(null, "12312312", "Eu", new Date(), 123);
			cartaoDao.cadastraCartaoCredito(cartao);
			System.out.println(cartao.toString());
		} catch (Exception e) {
			System.out.println("Error !");
			e.printStackTrace();
		}
		
	}
	
	

}
