package model.entity;

import java.io.Serializable;
import java.util.Date;

public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idVenda;
	private Integer quantidade;
	private Date checkIn;
	private String cpf;
	private String telefone;
	private Date dataCompra;
	
	private Usuario usuario;
	private Viagem viagem;
	private CartaoCredito cartaoCredito;
	
	
	/***
	 * CONSTRAINT PARA BANCO DE DADOS
	 */
	
	public final static String ID_VENDA = "id_vendas";
	public final static String QUANTIDADE = "quantidade";
	public final static String CHECK_IN = "checkin";
	public final static String CPF = "cpf";
	public final static String TELEFONE = "telefone";
	public final static String DATA_COMPRA = "dt_compra";
	public final static String FK_USUARIO = "fk_usuario";
	public final static String FK_VIAGEM = "fk_viagem";
	public final static String FK_CARTAO_CREDITO = "fk_cartao_credito";

	
	
	/***
	 * Construtor default
	 */
	public Venda() {
	}

	/***
	 * Construtor para select no banco
	 * @param idVenda
	 * @param quantidade
	 * @param checkIn
	 * @param cpf
	 * @param telefone
	 * @param dataCompra
	 * @param usuario
	 * @param viagem
	 * @param cartaoCredito
	 */
	public Venda(Long idVenda, Integer quantidade, Date checkIn, String cpf,
			String telefone, Date dataCompra, Usuario usuario, Viagem viagem,
			CartaoCredito cartaoCredito) {
		super();
		this.idVenda = idVenda;
		this.quantidade = quantidade;
		this.checkIn = checkIn;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataCompra = dataCompra;
		this.usuario = usuario;
		this.viagem = viagem;
		this.cartaoCredito = cartaoCredito;
	}
	
	/***
	 * 
	 * GETTER AND SETTER
	 */

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	
	
	/***
	 * HASHCODE AND EQUAL -- Idvenda 
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVenda == null) ? 0 : idVenda.hashCode());
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
		Venda other = (Venda) obj;
		if (idVenda == null) {
			if (other.idVenda != null)
				return false;
		} else if (!idVenda.equals(other.idVenda))
			return false;
		return true;
	}

	

}
