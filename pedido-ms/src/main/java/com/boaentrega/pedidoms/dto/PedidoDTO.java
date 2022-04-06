package com.boaentrega.pedidoms.dto;

import java.sql.Date;

public class PedidoDTO {
	private Long id;
	private String numero;
	private Date dataGeracao;
	private Long clienteId;
	private double total;
	
	public PedidoDTO() {
	}

	public PedidoDTO(Long id, String numero, Date dataGeracao, Long clienteId, double total) {
		super();
		this.id = id;
		this.numero = numero;
		this.dataGeracao = dataGeracao;
		this.clienteId = clienteId;
		this.total = total;
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
}
