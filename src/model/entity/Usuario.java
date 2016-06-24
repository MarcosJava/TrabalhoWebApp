package model.entity;

import java.io.Serializable;
import java.util.List;


public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long idUsuario;
	private String email;
	private String nome;
	private String senha;
	
	private List<Venda> vendas;
	
	
	/******
	 * 
	 * CONSTRAINT PARA BANCO DE DADOS
	 * 
	 * *******/
	public final static String ID_USUARIO = "id_usuario";
	public final static String EMAIL = "email";
	public final static String SENHA = "senha";
	public final static String NOME = "nome";
	public static final String SEQUENCE = "seq_id_usuario";
	public static final String TABELA = "USUARIO";
	
	
	
	/* Construtor vazio */
	public Usuario() {
		super();
	}
	
	/* Construtor cheio */
	public Usuario(Long idUsuario, String email, String nome, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	
	/* Getters e Setters*/
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", email=" + email
				+ ", nome=" + nome + ", senha=" + senha + "]";
	}

	/***
	 * HASH E EQUALS = ID e EMAIL
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
	
	
	
}
