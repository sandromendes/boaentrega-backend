package com.boaentrega.pedidoms.dto;

public class EnderecoDTO {
	private String logradouro;
	private String cidade;
	private String estado;
	private String numero;
	private String complemento;
	private String cep;
	
	public EnderecoDTO() {
	}

	public EnderecoDTO(String logradouro, String cidade, String estado, String numero, String complemento,
			String cep) {
		super();
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public EnderecoDTO(String logradouro, String cidade, String estado) {
		super();
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
