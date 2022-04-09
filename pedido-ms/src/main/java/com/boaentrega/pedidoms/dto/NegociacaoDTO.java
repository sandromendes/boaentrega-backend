package com.boaentrega.pedidoms.dto;

import java.util.UUID;

public class NegociacaoDTO {

	public UUID codigo;
	public String numeroPedido;
	public Double valorOriginal;
	public Double desconto;
	public Double valorNegociado;
	public String message;
	
	public NegociacaoDTO() {
		this.codigo = UUID.randomUUID();
	}

	public NegociacaoDTO(String numeroPedido, Double valorOriginal, Double desconto, Double valorNegociado, String message) {
		super();
		this.numeroPedido = numeroPedido;
		this.valorOriginal = valorOriginal;
		this.desconto = desconto;
		this.valorNegociado = valorNegociado;
		this.message = message;
		this.codigo = UUID.randomUUID();
	}
	
	public UUID getCodigo() {
		return codigo;
	}

	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Double getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(Double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(Double valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
