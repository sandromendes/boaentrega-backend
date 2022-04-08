package com.boaentrega.pedidoms.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedidos")
public class Pedido{
	@Id
	private Long id;
	private String numero;
	private Date dataGeracao;
	private Long clienteId;
	private double total;
	private String logradouro;
	private String cidade;
	private String estado;
	private String numeroEndereco;
	private String complemento;
	private String cep;
	
	public Pedido() {
	}
	
	public Pedido(Long id, String numero, Date dataGeracao, Long clienteId, double total) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataGeracao = dataGeracao;
		this.clienteId = clienteId;
		this.total = total;
	}

	public Pedido(Long id, String numero, Date dataGeracao, Long clienteId, double total, String logradouro,
			String cidade, String estado, String numeroEndereco, String complemento, String cep) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataGeracao = dataGeracao;
		this.clienteId = clienteId;
		this.total = total;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroEndereco = numeroEndereco;
		this.complemento = complemento;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
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

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", numero=" + numero + ", dataGeracao=" + dataGeracao + ", clienteId=" + clienteId
				+ ", total=" + total + ", logradouro=" + logradouro + ", cidade=" + cidade + ", estado=" + estado
				+ ", numeroEndereco=" + numeroEndereco + ", complemento=" + complemento + ", cep=" + cep + "]";
	}
}
