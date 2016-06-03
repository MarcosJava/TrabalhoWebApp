package model.entity;

import java.io.Serializable;
import java.util.Date;

public class Viagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idViagem;
	private String nome;
	private byte[] foto;
	private String descricao;
	private Date saida;
	private Integer quantidade;
	private String cidade;
	
	
	/***
	 * CONSTRAINT PARA BANCO DE DADOS
	 */
	public final static String ID_VIAGEM = "id_viagem";
	public final static String NOME = "nome";
	public final static String FOTO = "foto";
	public final static String DESCRICAO = "descricao";
	public final static String SAIDA = "dt_saida";
	public final static String QUANTIDADE = "quantidade";
	public final static String CIDADE = "cidade";
	
	
	
	/***
	 * Construtor default
	 */
	public Viagem() {
		
	}
	
	/***
	 * Construtor para select no banco
	 * @param idViagem
	 * @param nome
	 * @param foto
	 * @param descricao
	 * @param saida
	 * @param quantidade
	 */
	public Viagem(Long idViagem, String nome, byte[] foto, String descricao,
			Date saida, Integer quantidade, String cidade) {
		super();
		this.idViagem = idViagem;
		this.nome = nome;
		this.foto = foto;
		this.descricao = descricao;
		this.saida = saida;
		this.quantidade = quantidade;
		this.cidade = cidade;
	}
	
	
	/***
	 * 
	 * GETTER AND SETTER
	 */
	
	public Long getIdViagem() {
		return idViagem;
	}
	public void setIdViagem(Long idViagem) {
		this.idViagem = idViagem;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	/***
	 * HASHCODE AND EQUALS -- idViagem
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idViagem == null) ? 0 : idViagem.hashCode());
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
		Viagem other = (Viagem) obj;
		if (idViagem == null) {
			if (other.idViagem != null)
				return false;
		} else if (!idViagem.equals(other.idViagem))
			return false;
		return true;
	}
	
	
	
	
}