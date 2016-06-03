package model.entity;

import java.io.Serializable;
import java.util.Date;

public class CartaoCredito implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idCartaoCredito;
	private Integer numCartao;
	private String titular;
	private Date dataValidade;
	private Integer codSeguranca;
	
	/***
	 * CONSTRAINT CARTAO CREDITO
	 */
	public final static String ID_CARTAO_CREDITO = "id_cartao_credito";
	public final static String NUM_CARTAO = "num_cartao";
	public final static String TITULAR_CARTAO = "titular_cartao";
	public final static String DATA_VALIDADE = "dt_validade";
	public final static String COD_SEGURANCA = "cod_seguranca";
	
	
	
	/***
	 * Construtor Default
	 */
	public CartaoCredito() {
		
	}

	/***
	 * Construtor para select no banco 
	 * @param idCartaoCredito
	 * @param numCartao
	 * @param titular
	 * @param dataValidade
	 * @param codSeguranca
	 */
	public CartaoCredito(Long idCartaoCredito, Integer numCartao,
			String titular, Date dataValidade, Integer codSeguranca) {
		super();
		this.idCartaoCredito = idCartaoCredito;
		this.numCartao = numCartao;
		this.titular = titular;
		this.dataValidade = dataValidade;
		this.codSeguranca = codSeguranca;
	}

	
	
	/***
	 * 
	 * GETTER AND SETTER
	 */
	
	public Long getIdCartaoCredito() {
		return idCartaoCredito;
	}

	public void setIdCartaoCredito(Long idCartaoCredito) {
		this.idCartaoCredito = idCartaoCredito;
	}

	public Integer getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(Integer numCartao) {
		this.numCartao = numCartao;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Integer getCodSeguranca() {
		return codSeguranca;
	}

	public void setCodSeguranca(Integer codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

	
	
	/***
	 * HASHCODE AND EQUAL -- idCartaoCredito, numCartao
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCartaoCredito == null) ? 0 : idCartaoCredito.hashCode());
		result = prime * result
				+ ((numCartao == null) ? 0 : numCartao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaoCredito other = (CartaoCredito) obj;
		if (idCartaoCredito == null) {
			if (other.idCartaoCredito != null)
				return false;
		} else if (!idCartaoCredito.equals(other.idCartaoCredito))
			return false;
		if (numCartao == null) {
			if (other.numCartao != null)
				return false;
		} else if (!numCartao.equals(other.numCartao))
			return false;
		return true;
	}

}
